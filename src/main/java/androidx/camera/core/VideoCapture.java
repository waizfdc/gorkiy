package androidx.camera.core;

import android.location.Location;
import android.media.AudioRecord;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.VideoCaptureConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.utils.UseCaseConfigUtil;
import androidx.work.WorkRequest;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoCapture extends UseCase {
    private static final String AUDIO_MIME_TYPE = "audio/mp4a-latm";
    private static final int[] CamcorderQuality = {8, 6, 5, 4};
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final int DEQUE_TIMEOUT_USEC = 10000;
    private static final Metadata EMPTY_METADATA = new Metadata();
    public static final int ERROR_ENCODER = 1;
    public static final int ERROR_MUXER = 2;
    public static final int ERROR_RECORDING_IN_PROGRESS = 3;
    public static final int ERROR_UNKNOWN = 0;
    private static final String TAG = "VideoCapture";
    private static final String VIDEO_MIME_TYPE = "video/avc";
    private static final short[] sAudioEncoding = {2, 3, 4};
    private int mAudioBitRate;
    private final MediaCodec.BufferInfo mAudioBufferInfo = new MediaCodec.BufferInfo();
    private int mAudioBufferSize;
    private int mAudioChannelCount;
    private MediaCodec mAudioEncoder;
    private final Handler mAudioHandler;
    private final HandlerThread mAudioHandlerThread = new HandlerThread("CameraX-audio encoding thread");
    private AudioRecord mAudioRecorder;
    private int mAudioSampleRate;
    private int mAudioTrackIndex;
    Surface mCameraSurface;
    private DeferrableSurface mDeferrableSurface;
    private final AtomicBoolean mEndOfAudioStreamSignal = new AtomicBoolean(true);
    private final AtomicBoolean mEndOfAudioVideoSignal = new AtomicBoolean(true);
    private final AtomicBoolean mEndOfVideoStreamSignal = new AtomicBoolean(true);
    private final AtomicBoolean mIsFirstAudioSampleWrite = new AtomicBoolean(false);
    private final AtomicBoolean mIsFirstVideoSampleWrite = new AtomicBoolean(false);
    private boolean mIsRecording = false;
    private MediaMuxer mMuxer;
    private final Object mMuxerLock = new Object();
    private boolean mMuxerStarted = false;
    private final MediaCodec.BufferInfo mVideoBufferInfo = new MediaCodec.BufferInfo();
    MediaCodec mVideoEncoder;
    private final Handler mVideoHandler;
    private final HandlerThread mVideoHandlerThread = new HandlerThread("CameraX-video encoding thread");
    private int mVideoTrackIndex;

    public static final class Metadata {
        public Location location;
    }

    public interface OnVideoSavedCallback {
        void onError(int i, String str, Throwable th);

        void onVideoSaved(File file);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoCaptureError {
    }

    public VideoCapture(VideoCaptureConfig videoCaptureConfig) {
        super(videoCaptureConfig);
        this.mVideoHandlerThread.start();
        this.mVideoHandler = new Handler(this.mVideoHandlerThread.getLooper());
        this.mAudioHandlerThread.start();
        this.mAudioHandler = new Handler(this.mAudioHandlerThread.getLooper());
    }

    private static MediaFormat createMediaFormat(VideoCaptureConfig videoCaptureConfig, Size size) {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(VIDEO_MIME_TYPE, size.getWidth(), size.getHeight());
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", videoCaptureConfig.getBitRate());
        createVideoFormat.setInteger("frame-rate", videoCaptureConfig.getVideoFrameRate());
        createVideoFormat.setInteger("i-frame-interval", videoCaptureConfig.getIFrameInterval());
        return createVideoFormat;
    }

    /* access modifiers changed from: protected */
    public UseCaseConfig.Builder<?, ?, ?> getDefaultBuilder(CameraInfo cameraInfo) {
        VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig) CameraX.getDefaultUseCaseConfig(VideoCaptureConfig.class, cameraInfo);
        if (videoCaptureConfig != null) {
            return VideoCaptureConfig.Builder.fromConfig(videoCaptureConfig);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public Map<String, Size> onSuggestedResolutionUpdated(Map<String, Size> map) {
        if (this.mCameraSurface != null) {
            this.mVideoEncoder.stop();
            this.mVideoEncoder.release();
            this.mAudioEncoder.stop();
            this.mAudioEncoder.release();
            releaseCameraSurface(false);
        }
        try {
            this.mVideoEncoder = MediaCodec.createEncoderByType(VIDEO_MIME_TYPE);
            this.mAudioEncoder = MediaCodec.createEncoderByType(AUDIO_MIME_TYPE);
            String boundCameraId = getBoundCameraId();
            Size size = map.get(boundCameraId);
            if (size != null) {
                setupEncoder(boundCameraId, size);
                return map;
            }
            throw new IllegalArgumentException("Suggested resolution map missing resolution for camera " + boundCameraId);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to create MediaCodec due to: " + e.getCause());
        }
    }

    public void startRecording(File file, Executor executor, OnVideoSavedCallback onVideoSavedCallback) {
        this.mIsFirstVideoSampleWrite.set(false);
        this.mIsFirstAudioSampleWrite.set(false);
        startRecording(file, EMPTY_METADATA, executor, onVideoSavedCallback);
    }

    public void startRecording(File file, Metadata metadata, Executor executor, OnVideoSavedCallback onVideoSavedCallback) {
        Log.i(TAG, "startRecording");
        final VideoSavedListenerWrapper videoSavedListenerWrapper = new VideoSavedListenerWrapper(executor, onVideoSavedCallback);
        if (!this.mEndOfAudioVideoSignal.get()) {
            videoSavedListenerWrapper.onError(3, "It is still in video recording!", null);
            return;
        }
        try {
            this.mAudioRecorder.startRecording();
            CameraInternal boundCamera = getBoundCamera();
            final String boundCameraId = getBoundCameraId();
            final Size attachedSurfaceResolution = getAttachedSurfaceResolution(boundCameraId);
            try {
                Log.i(TAG, "videoEncoder start");
                this.mVideoEncoder.start();
                Log.i(TAG, "audioEncoder start");
                this.mAudioEncoder.start();
                int sensorRotationDegrees = boundCamera.getCameraInfoInternal().getSensorRotationDegrees(((ImageOutputConfig) getUseCaseConfig()).getTargetRotation(0));
                try {
                    synchronized (this.mMuxerLock) {
                        MediaMuxer mediaMuxer = new MediaMuxer(file.getAbsolutePath(), 0);
                        this.mMuxer = mediaMuxer;
                        mediaMuxer.setOrientationHint(sensorRotationDegrees);
                        if (metadata.location != null) {
                            this.mMuxer.setLocation((float) metadata.location.getLatitude(), (float) metadata.location.getLongitude());
                        }
                    }
                    this.mEndOfVideoStreamSignal.set(false);
                    this.mEndOfAudioStreamSignal.set(false);
                    this.mEndOfAudioVideoSignal.set(false);
                    this.mIsRecording = true;
                    notifyActive();
                    this.mAudioHandler.post(new Runnable() {
                        /* class androidx.camera.core.VideoCapture.AnonymousClass1 */

                        public void run() {
                            VideoCapture.this.audioEncode(videoSavedListenerWrapper);
                        }
                    });
                    final File file2 = file;
                    this.mVideoHandler.post(new Runnable() {
                        /* class androidx.camera.core.VideoCapture.AnonymousClass2 */

                        public void run() {
                            if (!VideoCapture.this.videoEncode(videoSavedListenerWrapper, boundCameraId, attachedSurfaceResolution)) {
                                videoSavedListenerWrapper.onVideoSaved(file2);
                            }
                        }
                    });
                } catch (IOException e) {
                    setupEncoder(boundCameraId, attachedSurfaceResolution);
                    videoSavedListenerWrapper.onError(2, "MediaMuxer creation failed!", e);
                }
            } catch (IllegalStateException e2) {
                setupEncoder(boundCameraId, attachedSurfaceResolution);
                videoSavedListenerWrapper.onError(1, "Audio/Video encoder start fail", e2);
            }
        } catch (IllegalStateException e3) {
            videoSavedListenerWrapper.onError(1, "AudioRecorder start fail", e3);
        }
    }

    public void stopRecording() {
        Log.i(TAG, "stopRecording");
        notifyInactive();
        if (!this.mEndOfAudioVideoSignal.get() && this.mIsRecording) {
            this.mEndOfAudioStreamSignal.set(true);
        }
    }

    public void clear() {
        this.mVideoHandlerThread.quitSafely();
        this.mAudioHandlerThread.quitSafely();
        MediaCodec mediaCodec = this.mAudioEncoder;
        if (mediaCodec != null) {
            mediaCodec.release();
            this.mAudioEncoder = null;
        }
        AudioRecord audioRecord = this.mAudioRecorder;
        if (audioRecord != null) {
            audioRecord.release();
            this.mAudioRecorder = null;
        }
        if (this.mCameraSurface != null) {
            releaseCameraSurface(true);
        }
        super.clear();
    }

    private void releaseCameraSurface(boolean z) {
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            MediaCodec mediaCodec = this.mVideoEncoder;
            deferrableSurface.close();
            this.mDeferrableSurface.getTerminationFuture().addListener(new Runnable(z, mediaCodec) {
                /* class androidx.camera.core.$$Lambda$VideoCapture$vFHGdUhQ9YSrmNYVYvi35pHBmEc */
                private final /* synthetic */ boolean f$0;
                private final /* synthetic */ MediaCodec f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void run() {
                    VideoCapture.lambda$releaseCameraSurface$0(this.f$0, this.f$1);
                }
            }, CameraXExecutors.mainThreadExecutor());
            if (z) {
                this.mVideoEncoder = null;
            }
            this.mCameraSurface = null;
            this.mDeferrableSurface = null;
        }
    }

    static /* synthetic */ void lambda$releaseCameraSurface$0(boolean z, MediaCodec mediaCodec) {
        if (z && mediaCodec != null) {
            mediaCodec.release();
        }
    }

    public void setTargetRotation(int i) {
        VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig) getUseCaseConfig();
        VideoCaptureConfig.Builder fromConfig = VideoCaptureConfig.Builder.fromConfig(videoCaptureConfig);
        int targetRotation = videoCaptureConfig.getTargetRotation(-1);
        if (targetRotation == -1 || targetRotation != i) {
            UseCaseConfigUtil.updateTargetRotationAndRelatedConfigs(fromConfig, i);
            updateUseCaseConfig(fromConfig.getUseCaseConfig());
        }
    }

    /* access modifiers changed from: package-private */
    public void setupEncoder(final String str, final Size size) {
        VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig) getUseCaseConfig();
        this.mVideoEncoder.reset();
        this.mVideoEncoder.configure(createMediaFormat(videoCaptureConfig, size), (Surface) null, (MediaCrypto) null, 1);
        if (this.mCameraSurface != null) {
            releaseCameraSurface(false);
        }
        Surface createInputSurface = this.mVideoEncoder.createInputSurface();
        this.mCameraSurface = createInputSurface;
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(videoCaptureConfig);
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        ImmediateSurface immediateSurface = new ImmediateSurface(this.mCameraSurface);
        this.mDeferrableSurface = immediateSurface;
        ListenableFuture<Void> terminationFuture = immediateSurface.getTerminationFuture();
        createInputSurface.getClass();
        terminationFuture.addListener(new Runnable(createInputSurface) {
            /* class androidx.camera.core.$$Lambda$bKhot3B1n1f2PgvvZExesMq2yMg */
            private final /* synthetic */ Surface f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                this.f$0.release();
            }
        }, CameraXExecutors.mainThreadExecutor());
        createFrom.addSurface(this.mDeferrableSurface);
        createFrom.addErrorListener(new SessionConfig.ErrorListener() {
            /* class androidx.camera.core.VideoCapture.AnonymousClass3 */

            public void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                if (VideoCapture.this.isCurrentlyBoundCamera(str)) {
                    VideoCapture.this.setupEncoder(str, size);
                }
            }
        });
        attachToCamera(str, createFrom.build());
        setAudioParametersByCamcorderProfile(size, str);
        this.mAudioEncoder.reset();
        this.mAudioEncoder.configure(createAudioMediaFormat(), (Surface) null, (MediaCrypto) null, 1);
        AudioRecord audioRecord = this.mAudioRecorder;
        if (audioRecord != null) {
            audioRecord.release();
        }
        AudioRecord autoConfigAudioRecordSource = autoConfigAudioRecordSource(videoCaptureConfig);
        this.mAudioRecorder = autoConfigAudioRecordSource;
        if (autoConfigAudioRecordSource == null) {
            Log.e(TAG, "AudioRecord object cannot initialized correctly!");
        }
        this.mVideoTrackIndex = -1;
        this.mAudioTrackIndex = -1;
        this.mIsRecording = false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, long):void}
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void} */
    private boolean writeVideoEncodedBuffer(int i) {
        if (i < 0) {
            Log.e(TAG, "Output buffer should not have negative index: " + i);
            return false;
        }
        ByteBuffer outputBuffer = this.mVideoEncoder.getOutputBuffer(i);
        if (outputBuffer == null) {
            Log.d(TAG, "OutputBuffer was null.");
            return false;
        }
        if (this.mAudioTrackIndex >= 0 && this.mVideoTrackIndex >= 0 && this.mVideoBufferInfo.size > 0) {
            outputBuffer.position(this.mVideoBufferInfo.offset);
            outputBuffer.limit(this.mVideoBufferInfo.offset + this.mVideoBufferInfo.size);
            this.mVideoBufferInfo.presentationTimeUs = System.nanoTime() / 1000;
            synchronized (this.mMuxerLock) {
                if (!this.mIsFirstVideoSampleWrite.get()) {
                    Log.i(TAG, "First video sample written.");
                    this.mIsFirstVideoSampleWrite.set(true);
                }
                this.mMuxer.writeSampleData(this.mVideoTrackIndex, outputBuffer, this.mVideoBufferInfo);
            }
        }
        this.mVideoEncoder.releaseOutputBuffer(i, false);
        if ((this.mVideoBufferInfo.flags & 4) != 0) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, long):void}
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void} */
    private boolean writeAudioEncodedBuffer(int i) {
        ByteBuffer outputBuffer = getOutputBuffer(this.mAudioEncoder, i);
        outputBuffer.position(this.mAudioBufferInfo.offset);
        if (this.mAudioTrackIndex >= 0 && this.mVideoTrackIndex >= 0 && this.mAudioBufferInfo.size > 0 && this.mAudioBufferInfo.presentationTimeUs > 0) {
            try {
                synchronized (this.mMuxerLock) {
                    if (!this.mIsFirstAudioSampleWrite.get()) {
                        Log.i(TAG, "First audio sample written.");
                        this.mIsFirstAudioSampleWrite.set(true);
                    }
                    this.mMuxer.writeSampleData(this.mAudioTrackIndex, outputBuffer, this.mAudioBufferInfo);
                }
            } catch (Exception e) {
                Log.e(TAG, "audio error:size=" + this.mAudioBufferInfo.size + "/offset=" + this.mAudioBufferInfo.offset + "/timeUs=" + this.mAudioBufferInfo.presentationTimeUs);
                e.printStackTrace();
            }
        }
        this.mAudioEncoder.releaseOutputBuffer(i, false);
        if ((this.mAudioBufferInfo.flags & 4) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean videoEncode(OnVideoSavedCallback onVideoSavedCallback, String str, Size size) {
        boolean z = false;
        boolean z2 = false;
        while (!z && !z2) {
            if (this.mEndOfVideoStreamSignal.get()) {
                this.mVideoEncoder.signalEndOfInputStream();
                this.mEndOfVideoStreamSignal.set(false);
            }
            int dequeueOutputBuffer = this.mVideoEncoder.dequeueOutputBuffer(this.mVideoBufferInfo, WorkRequest.MIN_BACKOFF_MILLIS);
            if (dequeueOutputBuffer != -2) {
                z = writeVideoEncodedBuffer(dequeueOutputBuffer);
            } else {
                if (this.mMuxerStarted) {
                    onVideoSavedCallback.onError(1, "Unexpected change in video encoding format.", null);
                    z2 = true;
                }
                synchronized (this.mMuxerLock) {
                    int addTrack = this.mMuxer.addTrack(this.mVideoEncoder.getOutputFormat());
                    this.mVideoTrackIndex = addTrack;
                    if (this.mAudioTrackIndex >= 0 && addTrack >= 0) {
                        this.mMuxerStarted = true;
                        Log.i(TAG, "media mMuxer start");
                        this.mMuxer.start();
                    }
                }
            }
        }
        try {
            Log.i(TAG, "videoEncoder stop");
            this.mVideoEncoder.stop();
        } catch (IllegalStateException e) {
            onVideoSavedCallback.onError(1, "Video encoder stop failed!", e);
            z2 = true;
        }
        try {
            synchronized (this.mMuxerLock) {
                if (this.mMuxer != null) {
                    if (this.mMuxerStarted) {
                        this.mMuxer.stop();
                    }
                    this.mMuxer.release();
                    this.mMuxer = null;
                }
            }
        } catch (IllegalStateException e2) {
            onVideoSavedCallback.onError(2, "Muxer stop failed!", e2);
            z2 = true;
        }
        this.mMuxerStarted = false;
        setupEncoder(str, size);
        notifyReset();
        this.mEndOfAudioVideoSignal.set(true);
        Log.i(TAG, "Video encode thread end.");
        return z2;
    }

    /* access modifiers changed from: package-private */
    public boolean audioEncode(OnVideoSavedCallback onVideoSavedCallback) {
        boolean z = false;
        while (!z && this.mIsRecording) {
            if (this.mEndOfAudioStreamSignal.get()) {
                this.mEndOfAudioStreamSignal.set(false);
                this.mIsRecording = false;
            }
            MediaCodec mediaCodec = this.mAudioEncoder;
            if (mediaCodec != null && this.mAudioRecorder != null) {
                int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(-1);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer inputBuffer = getInputBuffer(this.mAudioEncoder, dequeueInputBuffer);
                    inputBuffer.clear();
                    int read = this.mAudioRecorder.read(inputBuffer, this.mAudioBufferSize);
                    if (read > 0) {
                        this.mAudioEncoder.queueInputBuffer(dequeueInputBuffer, 0, read, System.nanoTime() / 1000, this.mIsRecording ? 0 : 4);
                    }
                }
                while (true) {
                    int dequeueOutputBuffer = this.mAudioEncoder.dequeueOutputBuffer(this.mAudioBufferInfo, 0);
                    if (dequeueOutputBuffer == -2) {
                        synchronized (this.mMuxerLock) {
                            int addTrack = this.mMuxer.addTrack(this.mAudioEncoder.getOutputFormat());
                            this.mAudioTrackIndex = addTrack;
                            if (addTrack >= 0 && this.mVideoTrackIndex >= 0) {
                                this.mMuxerStarted = true;
                                this.mMuxer.start();
                            }
                        }
                    } else if (dequeueOutputBuffer != -1) {
                        z = writeAudioEncodedBuffer(dequeueOutputBuffer);
                    }
                    if (dequeueOutputBuffer >= 0) {
                        if (z) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        try {
            Log.i(TAG, "audioRecorder stop");
            this.mAudioRecorder.stop();
        } catch (IllegalStateException e) {
            onVideoSavedCallback.onError(1, "Audio recorder stop failed!", e);
        }
        try {
            this.mAudioEncoder.stop();
        } catch (IllegalStateException e2) {
            onVideoSavedCallback.onError(1, "Audio encoder stop failed!", e2);
        }
        Log.i(TAG, "Audio encode thread end");
        this.mEndOfVideoStreamSignal.set(true);
        return false;
    }

    private ByteBuffer getInputBuffer(MediaCodec mediaCodec, int i) {
        return mediaCodec.getInputBuffer(i);
    }

    private ByteBuffer getOutputBuffer(MediaCodec mediaCodec, int i) {
        return mediaCodec.getOutputBuffer(i);
    }

    private MediaFormat createAudioMediaFormat() {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(AUDIO_MIME_TYPE, this.mAudioSampleRate, this.mAudioChannelCount);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("bitrate", this.mAudioBitRate);
        return createAudioFormat;
    }

    private AudioRecord autoConfigAudioRecordSource(VideoCaptureConfig videoCaptureConfig) {
        short[] sArr = sAudioEncoding;
        int length = sArr.length;
        int i = 0;
        while (i < length) {
            short s = sArr[i];
            int i2 = this.mAudioChannelCount == 1 ? 16 : 12;
            int audioRecordSource = videoCaptureConfig.getAudioRecordSource();
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(this.mAudioSampleRate, i2, s);
                if (minBufferSize <= 0) {
                    minBufferSize = videoCaptureConfig.getAudioMinBufferSize();
                }
                int i3 = minBufferSize;
                AudioRecord audioRecord = new AudioRecord(audioRecordSource, this.mAudioSampleRate, i2, s, i3 * 2);
                if (audioRecord.getState() == 1) {
                    this.mAudioBufferSize = i3;
                    Log.i(TAG, "source: " + audioRecordSource + " audioSampleRate: " + this.mAudioSampleRate + " channelConfig: " + i2 + " audioFormat: " + ((int) s) + " bufferSize: " + i3);
                    return audioRecord;
                }
                i++;
            } catch (Exception e) {
                Log.e(TAG, "Exception, keep trying.", e);
            }
        }
        return null;
    }

    private void setAudioParametersByCamcorderProfile(Size size, String str) {
        int[] iArr = CamcorderQuality;
        int length = iArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = iArr[i];
            if (CamcorderProfile.hasProfile(Integer.parseInt(str), i2)) {
                CamcorderProfile camcorderProfile = CamcorderProfile.get(Integer.parseInt(str), i2);
                if (size.getWidth() == camcorderProfile.videoFrameWidth && size.getHeight() == camcorderProfile.videoFrameHeight) {
                    this.mAudioChannelCount = camcorderProfile.audioChannels;
                    this.mAudioSampleRate = camcorderProfile.audioSampleRate;
                    this.mAudioBitRate = camcorderProfile.audioBitRate;
                    z = true;
                    break;
                }
            }
            i++;
        }
        if (!z) {
            VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig) getUseCaseConfig();
            this.mAudioChannelCount = videoCaptureConfig.getAudioChannelCount();
            this.mAudioSampleRate = videoCaptureConfig.getAudioSampleRate();
            this.mAudioBitRate = videoCaptureConfig.getAudioBitRate();
        }
    }

    public static final class Defaults implements ConfigProvider<VideoCaptureConfig> {
        private static final int DEFAULT_AUDIO_BIT_RATE = 64000;
        private static final int DEFAULT_AUDIO_CHANNEL_COUNT = 1;
        private static final int DEFAULT_AUDIO_MIN_BUFFER_SIZE = 1024;
        private static final int DEFAULT_AUDIO_RECORD_SOURCE = 1;
        private static final int DEFAULT_AUDIO_SAMPLE_RATE = 8000;
        private static final int DEFAULT_BIT_RATE = 8388608;
        private static final VideoCaptureConfig DEFAULT_CONFIG = new VideoCaptureConfig.Builder().setVideoFrameRate(30).setBitRate(8388608).setIFrameInterval(1).setAudioBitRate(64000).setAudioSampleRate(8000).setAudioChannelCount(1).setAudioRecordSource(1).setAudioMinBufferSize(1024).setMaxResolution(DEFAULT_MAX_RESOLUTION).setSurfaceOccupancyPriority(3).getUseCaseConfig();
        private static final int DEFAULT_INTRA_FRAME_INTERVAL = 1;
        private static final Size DEFAULT_MAX_RESOLUTION = new Size(1920, 1080);
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 3;
        private static final int DEFAULT_VIDEO_FRAME_RATE = 30;

        public VideoCaptureConfig getConfig(CameraInfo cameraInfo) {
            return DEFAULT_CONFIG;
        }
    }

    private final class VideoSavedListenerWrapper implements OnVideoSavedCallback {
        Executor mExecutor;
        OnVideoSavedCallback mOnVideoSavedCallback;

        VideoSavedListenerWrapper(Executor executor, OnVideoSavedCallback onVideoSavedCallback) {
            this.mExecutor = executor;
            this.mOnVideoSavedCallback = onVideoSavedCallback;
        }

        public /* synthetic */ void lambda$onVideoSaved$0$VideoCapture$VideoSavedListenerWrapper(File file) {
            this.mOnVideoSavedCallback.onVideoSaved(file);
        }

        public void onVideoSaved(File file) {
            try {
                this.mExecutor.execute(new Runnable(file) {
                    /* class androidx.camera.core.$$Lambda$VideoCapture$VideoSavedListenerWrapper$vLMoiAzzt8RX4cghVgVbALA4Mc */
                    private final /* synthetic */ File f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        VideoCapture.VideoSavedListenerWrapper.this.lambda$onVideoSaved$0$VideoCapture$VideoSavedListenerWrapper(this.f$1);
                    }
                });
            } catch (RejectedExecutionException unused) {
                Log.e(VideoCapture.TAG, "Unable to post to the supplied executor.");
            }
        }

        public void onError(int i, String str, Throwable th) {
            try {
                this.mExecutor.execute(new Runnable(i, str, th) {
                    /* class androidx.camera.core.$$Lambda$VideoCapture$VideoSavedListenerWrapper$ZG5otqrkESy2VwQvd4RLRJQ1fFY */
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ String f$2;
                    private final /* synthetic */ Throwable f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        VideoCapture.VideoSavedListenerWrapper.this.lambda$onError$1$VideoCapture$VideoSavedListenerWrapper(this.f$1, this.f$2, this.f$3);
                    }
                });
            } catch (RejectedExecutionException unused) {
                Log.e(VideoCapture.TAG, "Unable to post to the supplied executor.");
            }
        }

        public /* synthetic */ void lambda$onError$1$VideoCapture$VideoSavedListenerWrapper(int i, String str, Throwable th) {
            this.mOnVideoSavedCallback.onError(i, str, th);
        }
    }
}

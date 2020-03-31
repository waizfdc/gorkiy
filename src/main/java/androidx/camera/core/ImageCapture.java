package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.location.Location;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageSaver;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.utils.UseCaseConfigUtil;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ImageCapture extends UseCase {
    public static final int CAPTURE_MODE_MAXIMIZE_QUALITY = 0;
    public static final int CAPTURE_MODE_MINIMIZE_LATENCY = 1;
    private static final long CHECK_3A_TIMEOUT_IN_MS = 1000;
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    public static final int ERROR_CAMERA_CLOSED = 3;
    public static final int ERROR_CAPTURE_FAILED = 2;
    public static final int ERROR_FILE_IO = 1;
    public static final int ERROR_INVALID_CAMERA = 4;
    public static final int ERROR_UNKNOWN = 0;
    public static final int FLASH_MODE_AUTO = 0;
    public static final int FLASH_MODE_OFF = 2;
    public static final int FLASH_MODE_ON = 1;
    private static final int MAX_IMAGES = 2;
    private static final String TAG = "ImageCapture";
    private final CaptureBundle mCaptureBundle;
    private final CaptureConfig mCaptureConfig;
    private final int mCaptureMode;
    private final CaptureProcessor mCaptureProcessor;
    private final ImageReaderProxy.OnImageAvailableListener mClosingListener = $$Lambda$ImageCapture$NPEX6fpK2w8zMZHH6SIcxrU.INSTANCE;
    private ImageCaptureConfig mConfig;
    private DeferrableSurface mDeferrableSurface;
    private boolean mEnableCheck3AConverged;
    private final ExecutorService mExecutor = Executors.newFixedThreadPool(1, new ThreadFactory() {
        /* class androidx.camera.core.ImageCapture.AnonymousClass1 */
        private final AtomicInteger mId = new AtomicInteger(0);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "CameraX-image_capture_" + this.mId.getAndIncrement());
        }
    });
    private int mFlashMode;
    ImageReaderProxy mImageReader;
    final Executor mIoExecutor;
    private final int mMaxCaptureStages;
    private CameraCaptureCallback mMetadataMatchingCaptureCallback;
    final ForwardingImageProxy.OnImageCloseListener mOnImageCloseListener = new ForwardingImageProxy.OnImageCloseListener() {
        /* class androidx.camera.core.ImageCapture.AnonymousClass5 */

        /* renamed from: onImageClose */
        public void lambda$onImageClose$0$ImageCapture$5(ImageProxy imageProxy) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                CameraXExecutors.mainThreadExecutor().execute(new Runnable(imageProxy) {
                    /* class androidx.camera.core.$$Lambda$ImageCapture$5$D4kGilBzCG3_Q3cVCqYA9kFIzJU */
                    private final /* synthetic */ ImageProxy f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        ImageCapture.AnonymousClass5.this.lambda$onImageClose$0$ImageCapture$5(this.f$1);
                    }
                });
            } else {
                ImageCapture.this.issueImageCaptureRequests();
            }
        }
    };
    final Deque<ImageCaptureRequest> mPendingImageCaptureRequests = new ConcurrentLinkedDeque();
    private final CaptureCallbackChecker mSessionCallbackChecker = new CaptureCallbackChecker();
    SessionConfig.Builder mSessionConfigBuilder;
    final TakePictureLock mTakePictureLock = new TakePictureLock(2, this);

    @Retention(RetentionPolicy.SOURCE)
    public @interface CaptureMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FlashMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ImageCaptureError {
    }

    public interface OnImageSavedCallback {
        void onError(ImageCaptureException imageCaptureException);

        void onImageSaved(OutputFileResults outputFileResults);
    }

    static /* synthetic */ Void lambda$issueTakePicture$11(List list) {
        return null;
    }

    static /* synthetic */ Void lambda$preTakePicture$8(Boolean bool) {
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        if (r3 != null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void lambda$new$0(androidx.camera.core.impl.ImageReaderProxy r3) {
        /*
            java.lang.String r0 = "ImageCapture"
            androidx.camera.core.ImageProxy r3 = r3.acquireLatestImage()     // Catch:{ IllegalStateException -> 0x002e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0020 }
            r1.<init>()     // Catch:{ all -> 0x0020 }
            java.lang.String r2 = "Discarding ImageProxy which was inadvertently acquired: "
            r1.append(r2)     // Catch:{ all -> 0x0020 }
            r1.append(r3)     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0020 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0020 }
            if (r3 == 0) goto L_0x0034
            r3.close()     // Catch:{ IllegalStateException -> 0x002e }
            goto L_0x0034
        L_0x0020:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r2 = move-exception
            if (r3 == 0) goto L_0x002d
            r3.close()     // Catch:{ all -> 0x0029 }
            goto L_0x002d
        L_0x0029:
            r3 = move-exception
            r1.addSuppressed(r3)     // Catch:{ IllegalStateException -> 0x002e }
        L_0x002d:
            throw r2     // Catch:{ IllegalStateException -> 0x002e }
        L_0x002e:
            r3 = move-exception
            java.lang.String r1 = "Failed to acquire latest image."
            android.util.Log.e(r0, r1, r3)
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageCapture.lambda$new$0(androidx.camera.core.impl.ImageReaderProxy):void");
    }

    ImageCapture(ImageCaptureConfig imageCaptureConfig) {
        super(imageCaptureConfig);
        ImageCaptureConfig imageCaptureConfig2 = (ImageCaptureConfig) getUseCaseConfig();
        this.mConfig = imageCaptureConfig2;
        this.mCaptureMode = imageCaptureConfig2.getCaptureMode();
        this.mFlashMode = this.mConfig.getFlashMode();
        this.mCaptureProcessor = this.mConfig.getCaptureProcessor(null);
        int maxCaptureStages = this.mConfig.getMaxCaptureStages(2);
        this.mMaxCaptureStages = maxCaptureStages;
        Preconditions.checkArgument(maxCaptureStages >= 1, "Maximum outstanding image count must be at least 1");
        Integer bufferFormat = this.mConfig.getBufferFormat(null);
        if (bufferFormat != null) {
            Preconditions.checkArgument(this.mCaptureProcessor == null, "Cannot set buffer format with CaptureProcessor defined.");
            setImageFormat(bufferFormat.intValue());
        } else if (this.mCaptureProcessor != null) {
            setImageFormat(35);
        } else {
            setImageFormat(ImageReaderFormatRecommender.chooseCombo().imageCaptureFormat());
        }
        this.mCaptureBundle = this.mConfig.getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle());
        this.mIoExecutor = (Executor) Preconditions.checkNotNull(this.mConfig.getIoExecutor(CameraXExecutors.ioExecutor()));
        int i = this.mCaptureMode;
        if (i == 0) {
            this.mEnableCheck3AConverged = true;
        } else if (i == 1) {
            this.mEnableCheck3AConverged = false;
        }
        this.mCaptureConfig = CaptureConfig.Builder.createFrom(this.mConfig).build();
    }

    /* access modifiers changed from: package-private */
    public SessionConfig.Builder createPipeline(String str, ImageCaptureConfig imageCaptureConfig, Size size) {
        Threads.checkMainThread();
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(imageCaptureConfig);
        createFrom.addRepeatingCameraCaptureCallback(this.mSessionCallbackChecker);
        HandlerThread handlerThread = new HandlerThread("OnImageAvailableHandlerThread");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        if (this.mCaptureProcessor != null) {
            ProcessingImageReader processingImageReader = new ProcessingImageReader(size.getWidth(), size.getHeight(), getImageFormat(), this.mMaxCaptureStages, handler, getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle()), this.mCaptureProcessor);
            this.mMetadataMatchingCaptureCallback = processingImageReader.getCameraCaptureCallback();
            this.mImageReader = processingImageReader;
        } else {
            MetadataImageReader metadataImageReader = new MetadataImageReader(size.getWidth(), size.getHeight(), getImageFormat(), 2, handler);
            this.mMetadataMatchingCaptureCallback = metadataImageReader.getCameraCaptureCallback();
            this.mImageReader = metadataImageReader;
        }
        this.mImageReader.setOnImageAvailableListener(this.mClosingListener, CameraXExecutors.mainThreadExecutor());
        ImageReaderProxy imageReaderProxy = this.mImageReader;
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        ImmediateSurface immediateSurface = new ImmediateSurface(this.mImageReader.getSurface());
        this.mDeferrableSurface = immediateSurface;
        immediateSurface.getTerminationFuture().addListener(new Runnable(handlerThread) {
            /* class androidx.camera.core.$$Lambda$ImageCapture$F_1wvTR60w78NQyIONsr09a1OLQ */
            private final /* synthetic */ HandlerThread f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                ImageCapture.lambda$createPipeline$1(ImageReaderProxy.this, this.f$1);
            }
        }, CameraXExecutors.mainThreadExecutor());
        createFrom.addNonRepeatingSurface(this.mDeferrableSurface);
        createFrom.addErrorListener(new SessionConfig.ErrorListener(str, imageCaptureConfig, size) {
            /* class androidx.camera.core.$$Lambda$ImageCapture$vo2FNNBh2zJowDghO6l4OnBlM */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ ImageCaptureConfig f$2;
            private final /* synthetic */ Size f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                ImageCapture.this.lambda$createPipeline$2$ImageCapture(this.f$1, this.f$2, this.f$3, sessionConfig, sessionError);
            }
        });
        return createFrom;
    }

    static /* synthetic */ void lambda$createPipeline$1(ImageReaderProxy imageReaderProxy, HandlerThread handlerThread) {
        imageReaderProxy.close();
        handlerThread.quitSafely();
    }

    public /* synthetic */ void lambda$createPipeline$2$ImageCapture(String str, ImageCaptureConfig imageCaptureConfig, Size size, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        clearPipeline();
        if (isCurrentlyBoundCamera(str)) {
            SessionConfig.Builder createPipeline = createPipeline(str, imageCaptureConfig, size);
            this.mSessionConfigBuilder = createPipeline;
            attachToCamera(str, createPipeline.build());
            notifyReset();
        }
    }

    /* access modifiers changed from: package-private */
    public void clearPipeline() {
        Threads.checkMainThread();
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        this.mDeferrableSurface = null;
        this.mImageReader = null;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
    }

    /* access modifiers changed from: protected */
    public UseCaseConfig.Builder<?, ?, ?> getDefaultBuilder(CameraInfo cameraInfo) {
        ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) CameraX.getDefaultUseCaseConfig(ImageCaptureConfig.class, cameraInfo);
        if (imageCaptureConfig != null) {
            return Builder.fromConfig(imageCaptureConfig);
        }
        return null;
    }

    private CameraControlInternal getCurrentCameraControl() {
        return getCameraControl(getBoundCameraId());
    }

    /* access modifiers changed from: protected */
    public void onCameraControlReady(String str) {
        getCameraControl(str).setFlashMode(this.mFlashMode);
    }

    public int getFlashMode() {
        return this.mFlashMode;
    }

    public void setFlashMode(int i) {
        this.mFlashMode = i;
        if (getBoundCamera() != null) {
            getCurrentCameraControl().setFlashMode(i);
        }
    }

    public void setCropAspectRatio(Rational rational) {
        ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) getUseCaseConfig();
        Builder fromConfig = Builder.fromConfig(imageCaptureConfig);
        if (!rational.equals(imageCaptureConfig.getTargetAspectRatioCustom(null))) {
            fromConfig.setTargetAspectRatioCustom(rational);
            updateUseCaseConfig(fromConfig.getUseCaseConfig());
            this.mConfig = (ImageCaptureConfig) getUseCaseConfig();
        }
    }

    public int getTargetRotation() {
        return ((ImageOutputConfig) getUseCaseConfig()).getTargetRotation();
    }

    public void setTargetRotation(int i) {
        ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) getUseCaseConfig();
        Builder fromConfig = Builder.fromConfig(imageCaptureConfig);
        int targetRotation = imageCaptureConfig.getTargetRotation(-1);
        if (targetRotation == -1 || targetRotation != i) {
            UseCaseConfigUtil.updateTargetRotationAndRelatedConfigs(fromConfig, i);
            updateUseCaseConfig(fromConfig.getUseCaseConfig());
            this.mConfig = (ImageCaptureConfig) getUseCaseConfig();
        }
    }

    public int getCaptureMode() {
        return this.mCaptureMode;
    }

    /* renamed from: takePicture */
    public void lambda$takePicture$3$ImageCapture(Executor executor, OnImageCapturedCallback onImageCapturedCallback) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute(new Runnable(executor, onImageCapturedCallback) {
                /* class androidx.camera.core.$$Lambda$ImageCapture$3TBxQKmNJ9VTGCKo1ZKi7E3ESgI */
                private final /* synthetic */ Executor f$1;
                private final /* synthetic */ ImageCapture.OnImageCapturedCallback f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    ImageCapture.this.lambda$takePicture$3$ImageCapture(this.f$1, this.f$2);
                }
            });
        } else {
            sendImageCaptureRequest(executor, onImageCapturedCallback);
        }
    }

    /* renamed from: takePicture */
    public void lambda$takePicture$4$ImageCapture(OutputFileOptions outputFileOptions, Executor executor, final OnImageSavedCallback onImageSavedCallback) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute(new Runnable(outputFileOptions, executor, onImageSavedCallback) {
                /* class androidx.camera.core.$$Lambda$ImageCapture$GKCJoIxQ7x6CHqe5VLbTJu0vu5E */
                private final /* synthetic */ ImageCapture.OutputFileOptions f$1;
                private final /* synthetic */ Executor f$2;
                private final /* synthetic */ ImageCapture.OnImageSavedCallback f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    ImageCapture.this.lambda$takePicture$4$ImageCapture(this.f$1, this.f$2, this.f$3);
                }
            });
            return;
        }
        final AnonymousClass2 r6 = new ImageSaver.OnImageSavedCallback() {
            /* class androidx.camera.core.ImageCapture.AnonymousClass2 */

            public void onImageSaved(OutputFileResults outputFileResults) {
                onImageSavedCallback.onImageSaved(outputFileResults);
            }

            public void onError(ImageSaver.SaveError saveError, String str, Throwable th) {
                int i = 1;
                if (AnonymousClass9.$SwitchMap$androidx$camera$core$ImageSaver$SaveError[saveError.ordinal()] != 1) {
                    i = 0;
                }
                onImageSavedCallback.onError(new ImageCaptureException(i, str, th));
            }
        };
        final OutputFileOptions outputFileOptions2 = outputFileOptions;
        final Executor executor2 = executor;
        final OnImageSavedCallback onImageSavedCallback2 = onImageSavedCallback;
        sendImageCaptureRequest(CameraXExecutors.mainThreadExecutor(), new OnImageCapturedCallback() {
            /* class androidx.camera.core.ImageCapture.AnonymousClass3 */

            public void onCaptureSuccess(ImageProxy imageProxy) {
                ImageCapture.this.mIoExecutor.execute(new ImageSaver(imageProxy, outputFileOptions2, imageProxy.getImageInfo().getRotationDegrees(), executor2, r6));
            }

            public void onError(ImageCaptureException imageCaptureException) {
                onImageSavedCallback2.onError(imageCaptureException);
            }
        });
    }

    /* renamed from: androidx.camera.core.ImageCapture$9  reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$ImageSaver$SaveError;

        static {
            int[] iArr = new int[ImageSaver.SaveError.values().length];
            $SwitchMap$androidx$camera$core$ImageSaver$SaveError = iArr;
            try {
                iArr[ImageSaver.SaveError.FILE_IO_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void onStateOffline(String str) {
        super.onStateOffline(str);
        abortImageCaptureRequests();
    }

    private void abortImageCaptureRequests() {
        CameraClosedException cameraClosedException = new CameraClosedException("Camera is closed.");
        for (ImageCaptureRequest notifyCallbackError : this.mPendingImageCaptureRequests) {
            notifyCallbackError.notifyCallbackError(getError(cameraClosedException), cameraClosedException.getMessage(), cameraClosedException);
        }
        this.mPendingImageCaptureRequests.clear();
        this.mTakePictureLock.cancelTakePicture(cameraClosedException);
    }

    private void sendImageCaptureRequest(Executor executor, OnImageCapturedCallback onImageCapturedCallback) {
        CameraInternal boundCamera = getBoundCamera();
        if (boundCamera == null) {
            onImageCapturedCallback.onError(new ImageCaptureException(4, "Not bound to a valid Camera [" + this + "]", null));
            return;
        }
        int sensorRotationDegrees = boundCamera.getCameraInfoInternal().getSensorRotationDegrees(this.mConfig.getTargetRotation(0));
        this.mPendingImageCaptureRequests.offer(new ImageCaptureRequest(sensorRotationDegrees, ImageUtil.rotate(this.mConfig.getTargetAspectRatioCustom(null), sensorRotationDegrees), executor, onImageCapturedCallback));
        issueImageCaptureRequests();
    }

    /* access modifiers changed from: package-private */
    public void issueImageCaptureRequests() {
        ImageCaptureRequest poll = this.mPendingImageCaptureRequests.poll();
        if (poll != null) {
            if (!takePictureInternal(poll)) {
                Log.d(TAG, "Unable to issue take picture. Re-queuing image capture request");
                this.mPendingImageCaptureRequests.offerFirst(poll);
            }
            Log.d(TAG, "Size of image capture request queue: " + this.mPendingImageCaptureRequests.size());
        }
    }

    private boolean takePictureInternal(final ImageCaptureRequest imageCaptureRequest) {
        if (!this.mTakePictureLock.lockTakePicture(imageCaptureRequest)) {
            return false;
        }
        this.mImageReader.setOnImageAvailableListener(new ImageReaderProxy.OnImageAvailableListener(imageCaptureRequest) {
            /* class androidx.camera.core.$$Lambda$ImageCapture$Se2g8H9Ol9SWt0Z5CI8LH4ED7w */
            private final /* synthetic */ ImageCapture.ImageCaptureRequest f$1;

            {
                this.f$1 = r2;
            }

            public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                ImageCapture.this.lambda$takePictureInternal$5$ImageCapture(this.f$1, imageReaderProxy);
            }
        }, CameraXExecutors.mainThreadExecutor());
        final TakePictureState takePictureState = new TakePictureState();
        FutureChain.from(preTakePicture(takePictureState)).transformAsync(new AsyncFunction(imageCaptureRequest) {
            /* class androidx.camera.core.$$Lambda$ImageCapture$FwmdWImX9Ye3d0zGMvHct0lO2Xk */
            private final /* synthetic */ ImageCapture.ImageCaptureRequest f$1;

            {
                this.f$1 = r2;
            }

            public final ListenableFuture apply(Object obj) {
                return ImageCapture.this.lambda$takePictureInternal$6$ImageCapture(this.f$1, (Void) obj);
            }
        }, this.mExecutor).addCallback(new FutureCallback<Void>() {
            /* class androidx.camera.core.ImageCapture.AnonymousClass4 */

            public void onSuccess(Void voidR) {
                ImageCapture.this.postTakePicture(takePictureState);
            }

            public void onFailure(Throwable th) {
                Log.e(ImageCapture.TAG, "takePictureInternal onFailure", th);
                ImageCapture.this.postTakePicture(takePictureState);
                CameraXExecutors.mainThreadExecutor().execute(new Runnable(imageCaptureRequest, th) {
                    /* class androidx.camera.core.$$Lambda$ImageCapture$4$MTDpzzYIsR_RGpGEj2QXeu1160 */
                    private final /* synthetic */ ImageCapture.ImageCaptureRequest f$1;
                    private final /* synthetic */ Throwable f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        ImageCapture.AnonymousClass4.this.lambda$onFailure$0$ImageCapture$4(this.f$1, this.f$2);
                    }
                });
            }

            public /* synthetic */ void lambda$onFailure$0$ImageCapture$4(ImageCaptureRequest imageCaptureRequest, Throwable th) {
                imageCaptureRequest.notifyCallbackError(ImageCapture.getError(th), th != null ? th.getMessage() : "Unknown error", th);
                if (!ImageCapture.this.mTakePictureLock.unlockTakePicture(imageCaptureRequest)) {
                    Log.d(ImageCapture.TAG, "Error unlocking wrong request");
                }
            }
        }, this.mExecutor);
        return true;
    }

    public /* synthetic */ void lambda$takePictureInternal$5$ImageCapture(ImageCaptureRequest imageCaptureRequest, ImageReaderProxy imageReaderProxy) {
        ImageProxy tryAcquireImage = this.mTakePictureLock.tryAcquireImage(imageReaderProxy, imageCaptureRequest);
        if (tryAcquireImage != null) {
            imageCaptureRequest.dispatchImage(tryAcquireImage);
        }
        if (!this.mTakePictureLock.unlockTakePicture(imageCaptureRequest)) {
            Log.d(TAG, "Error unlocking after dispatch");
        }
    }

    public /* synthetic */ ListenableFuture lambda$takePictureInternal$6$ImageCapture(ImageCaptureRequest imageCaptureRequest, Void voidR) throws Exception {
        return issueTakePicture(imageCaptureRequest);
    }

    private static class TakePictureLock implements ForwardingImageProxy.OnImageCloseListener {
        private ImageCaptureRequest mCurrentRequest = null;
        private final ImageCapture mImageCapture;
        private final Object mLock = new Object();
        private final int mMaxImages;
        private int mOutstandingImages = 0;

        TakePictureLock(int i, ImageCapture imageCapture) {
            this.mMaxImages = i;
            this.mImageCapture = imageCapture;
        }

        /* access modifiers changed from: package-private */
        public boolean lockTakePicture(ImageCaptureRequest imageCaptureRequest) {
            synchronized (this.mLock) {
                if (this.mOutstandingImages < this.mMaxImages) {
                    if (this.mCurrentRequest == null) {
                        this.mCurrentRequest = imageCaptureRequest;
                        return true;
                    }
                }
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public ImageProxy tryAcquireImage(ImageReaderProxy imageReaderProxy, ImageCaptureRequest imageCaptureRequest) {
            synchronized (this.mLock) {
                SingleCloseImageProxy singleCloseImageProxy = null;
                if (this.mCurrentRequest != imageCaptureRequest) {
                    Log.e(ImageCapture.TAG, "Attempting to acquire image with incorrect request");
                    return null;
                }
                try {
                    ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
                    if (acquireLatestImage != null) {
                        SingleCloseImageProxy singleCloseImageProxy2 = new SingleCloseImageProxy(acquireLatestImage);
                        try {
                            singleCloseImageProxy2.addOnImageCloseListener(this);
                            this.mOutstandingImages++;
                            singleCloseImageProxy = singleCloseImageProxy2;
                        } catch (IllegalStateException e) {
                            e = e;
                            singleCloseImageProxy = singleCloseImageProxy2;
                            Log.e(ImageCapture.TAG, "Failed to acquire latest image.", e);
                            return singleCloseImageProxy;
                        }
                    }
                } catch (IllegalStateException e2) {
                    e = e2;
                    Log.e(ImageCapture.TAG, "Failed to acquire latest image.", e);
                    return singleCloseImageProxy;
                }
            }
        }

        public void onImageClose(ImageProxy imageProxy) {
            synchronized (this.mLock) {
                this.mOutstandingImages--;
                ScheduledExecutorService mainThreadExecutor = CameraXExecutors.mainThreadExecutor();
                ImageCapture imageCapture = this.mImageCapture;
                imageCapture.getClass();
                mainThreadExecutor.execute(new Runnable() {
                    /* class androidx.camera.core.$$Lambda$yfOD6i21YfFnMd1B6A6ekn93X8I */

                    public final void run() {
                        ImageCapture.this.issueImageCaptureRequests();
                    }
                });
            }
        }

        /* access modifiers changed from: package-private */
        public boolean unlockTakePicture(ImageCaptureRequest imageCaptureRequest) {
            synchronized (this.mLock) {
                if (this.mCurrentRequest != imageCaptureRequest) {
                    return false;
                }
                this.mCurrentRequest = null;
                ScheduledExecutorService mainThreadExecutor = CameraXExecutors.mainThreadExecutor();
                ImageCapture imageCapture = this.mImageCapture;
                imageCapture.getClass();
                mainThreadExecutor.execute(new Runnable() {
                    /* class androidx.camera.core.$$Lambda$yfOD6i21YfFnMd1B6A6ekn93X8I */

                    public final void run() {
                        ImageCapture.this.issueImageCaptureRequests();
                    }
                });
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public void cancelTakePicture(Throwable th) {
            synchronized (this.mLock) {
                if (this.mCurrentRequest != null) {
                    this.mCurrentRequest.notifyCallbackError(ImageCapture.getError(th), th.getMessage(), th);
                }
                this.mCurrentRequest = null;
            }
        }
    }

    public String toString() {
        return "ImageCapture:" + getName();
    }

    static int getError(Throwable th) {
        if (th instanceof CameraClosedException) {
            return 3;
        }
        return th instanceof CaptureFailedException ? 2 : 0;
    }

    public void clear() {
        clearPipeline();
        this.mExecutor.shutdown();
        super.clear();
    }

    /* access modifiers changed from: protected */
    public Map<String, Size> onSuggestedResolutionUpdated(Map<String, Size> map) {
        String boundCameraId = getBoundCameraId();
        Size size = map.get(boundCameraId);
        if (size != null) {
            SessionConfig.Builder createPipeline = createPipeline(boundCameraId, this.mConfig, size);
            this.mSessionConfigBuilder = createPipeline;
            attachToCamera(boundCameraId, createPipeline.build());
            notifyActive();
            return map;
        }
        throw new IllegalArgumentException("Suggested resolution map missing resolution for camera " + boundCameraId);
    }

    private ListenableFuture<Void> preTakePicture(TakePictureState takePictureState) {
        return FutureChain.from(getPreCaptureStateIfNeeded()).transformAsync(new AsyncFunction(takePictureState) {
            /* class androidx.camera.core.$$Lambda$ImageCapture$titIgcLzCEMQ_nAX52EZpzdp7WA */
            private final /* synthetic */ ImageCapture.TakePictureState f$1;

            {
                this.f$1 = r2;
            }

            public final ListenableFuture apply(Object obj) {
                return ImageCapture.this.lambda$preTakePicture$7$ImageCapture(this.f$1, (CameraCaptureResult) obj);
            }
        }, this.mExecutor).transform($$Lambda$ImageCapture$C_GFpnhq4iWGnsxqH98jMkWKOWg.INSTANCE, this.mExecutor);
    }

    public /* synthetic */ ListenableFuture lambda$preTakePicture$7$ImageCapture(TakePictureState takePictureState, CameraCaptureResult cameraCaptureResult) throws Exception {
        takePictureState.mPreCaptureState = cameraCaptureResult;
        triggerAfIfNeeded(takePictureState);
        if (isFlashRequired(takePictureState)) {
            takePictureState.mIsFlashTriggered = true;
            triggerAePrecapture(takePictureState);
        }
        return check3AConverged(takePictureState);
    }

    /* access modifiers changed from: package-private */
    public void postTakePicture(TakePictureState takePictureState) {
        this.mExecutor.execute(new Runnable(takePictureState) {
            /* class androidx.camera.core.$$Lambda$ImageCapture$ynbpYfrtrQASytXNtToI3IXMF4 */
            private final /* synthetic */ ImageCapture.TakePictureState f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                ImageCapture.this.lambda$postTakePicture$9$ImageCapture(this.f$1);
            }
        });
    }

    private ListenableFuture<CameraCaptureResult> getPreCaptureStateIfNeeded() {
        if (this.mEnableCheck3AConverged || getFlashMode() == 0) {
            return this.mSessionCallbackChecker.checkCaptureResult(new CaptureCallbackChecker.CaptureResultChecker<CameraCaptureResult>() {
                /* class androidx.camera.core.ImageCapture.AnonymousClass6 */

                public CameraCaptureResult check(CameraCaptureResult cameraCaptureResult) {
                    return cameraCaptureResult;
                }
            });
        }
        return Futures.immediateFuture(null);
    }

    /* access modifiers changed from: package-private */
    public boolean isFlashRequired(TakePictureState takePictureState) {
        int flashMode = getFlashMode();
        if (flashMode != 0) {
            if (flashMode == 1) {
                return true;
            }
            if (flashMode == 2) {
                return false;
            }
            throw new AssertionError(getFlashMode());
        } else if (takePictureState.mPreCaptureState.getAeState() == CameraCaptureMetaData.AeState.FLASH_REQUIRED) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Boolean> check3AConverged(TakePictureState takePictureState) {
        if (!this.mEnableCheck3AConverged && !takePictureState.mIsFlashTriggered) {
            return Futures.immediateFuture(false);
        }
        if (is3AConverged(takePictureState.mPreCaptureState)) {
            return Futures.immediateFuture(true);
        }
        return this.mSessionCallbackChecker.checkCaptureResult(new CaptureCallbackChecker.CaptureResultChecker<Boolean>() {
            /* class androidx.camera.core.ImageCapture.AnonymousClass7 */

            public Boolean check(CameraCaptureResult cameraCaptureResult) {
                return ImageCapture.this.is3AConverged(cameraCaptureResult) ? true : null;
            }
        }, 1000, false);
    }

    /* access modifiers changed from: package-private */
    public boolean is3AConverged(CameraCaptureResult cameraCaptureResult) {
        if (cameraCaptureResult == null) {
            return false;
        }
        boolean z = cameraCaptureResult.getAfMode() == CameraCaptureMetaData.AfMode.ON_CONTINUOUS_AUTO || cameraCaptureResult.getAfMode() == CameraCaptureMetaData.AfMode.OFF || cameraCaptureResult.getAfMode() == CameraCaptureMetaData.AfMode.UNKNOWN || cameraCaptureResult.getAfState() == CameraCaptureMetaData.AfState.FOCUSED || cameraCaptureResult.getAfState() == CameraCaptureMetaData.AfState.LOCKED_FOCUSED || cameraCaptureResult.getAfState() == CameraCaptureMetaData.AfState.LOCKED_NOT_FOCUSED;
        boolean z2 = cameraCaptureResult.getAeState() == CameraCaptureMetaData.AeState.CONVERGED || cameraCaptureResult.getAeState() == CameraCaptureMetaData.AeState.UNKNOWN;
        boolean z3 = cameraCaptureResult.getAwbState() == CameraCaptureMetaData.AwbState.CONVERGED || cameraCaptureResult.getAwbState() == CameraCaptureMetaData.AwbState.UNKNOWN;
        if (!z || !z2 || !z3) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void triggerAfIfNeeded(TakePictureState takePictureState) {
        if (this.mEnableCheck3AConverged && takePictureState.mPreCaptureState.getAfMode() == CameraCaptureMetaData.AfMode.ON_MANUAL_AUTO && takePictureState.mPreCaptureState.getAfState() == CameraCaptureMetaData.AfState.INACTIVE) {
            triggerAf(takePictureState);
        }
    }

    private void triggerAf(TakePictureState takePictureState) {
        takePictureState.mIsAfTriggered = true;
        getCurrentCameraControl().triggerAf();
    }

    /* access modifiers changed from: package-private */
    public void triggerAePrecapture(TakePictureState takePictureState) {
        takePictureState.mIsAePrecaptureTriggered = true;
        getCurrentCameraControl().triggerAePrecapture();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cancelAfAeTrigger */
    public void lambda$postTakePicture$9$ImageCapture(TakePictureState takePictureState) {
        if (takePictureState.mIsAfTriggered || takePictureState.mIsAePrecaptureTriggered) {
            getCurrentCameraControl().cancelAfAeTrigger(takePictureState.mIsAfTriggered, takePictureState.mIsAePrecaptureTriggered);
            takePictureState.mIsAfTriggered = false;
            takePictureState.mIsAePrecaptureTriggered = false;
        }
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> issueTakePicture(ImageCaptureRequest imageCaptureRequest) {
        CaptureBundle captureBundle;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (this.mCaptureProcessor != null) {
            captureBundle = getCaptureBundle(null);
            if (captureBundle == null) {
                return Futures.immediateFailedFuture(new IllegalArgumentException("ImageCapture cannot set empty CaptureBundle."));
            }
            if (captureBundle.getCaptureStages().size() > this.mMaxCaptureStages) {
                return Futures.immediateFailedFuture(new IllegalArgumentException("ImageCapture has CaptureStages > Max CaptureStage size"));
            }
            ((ProcessingImageReader) this.mImageReader).setCaptureBundle(captureBundle);
        } else {
            captureBundle = getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle());
            if (captureBundle.getCaptureStages().size() > 1) {
                return Futures.immediateFailedFuture(new IllegalArgumentException("ImageCapture have no CaptureProcess set with CaptureBundle size > 1."));
            }
        }
        for (CaptureStage next : captureBundle.getCaptureStages()) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(this.mCaptureConfig.getTemplateType());
            builder.addImplementationOptions(this.mCaptureConfig.getImplementationOptions());
            builder.addAllCameraCaptureCallbacks(this.mSessionConfigBuilder.getSingleCameraCaptureCallbacks());
            builder.addSurface(this.mDeferrableSurface);
            builder.addImplementationOption(CaptureConfig.OPTION_ROTATION, Integer.valueOf(imageCaptureRequest.mRotationDegrees));
            builder.addImplementationOptions(next.getCaptureConfig().getImplementationOptions());
            builder.setTag(next.getCaptureConfig().getTag());
            builder.addCameraCaptureCallback(this.mMetadataMatchingCaptureCallback);
            arrayList.add(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(builder, arrayList2, next) {
                /* class androidx.camera.core.$$Lambda$ImageCapture$5JLyPf4u5drRQ_HJ2fPCo738ics */
                private final /* synthetic */ CaptureConfig.Builder f$1;
                private final /* synthetic */ List f$2;
                private final /* synthetic */ CaptureStage f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return ImageCapture.this.lambda$issueTakePicture$10$ImageCapture(this.f$1, this.f$2, this.f$3, completer);
                }
            }));
        }
        getCurrentCameraControl().submitCaptureRequests(arrayList2);
        return Futures.transform(Futures.allAsList(arrayList), $$Lambda$ImageCapture$WNq6haNO4IMmVes0WnqB75kIGY.INSTANCE, CameraXExecutors.directExecutor());
    }

    public /* synthetic */ Object lambda$issueTakePicture$10$ImageCapture(CaptureConfig.Builder builder, List list, CaptureStage captureStage, final CallbackToFutureAdapter.Completer completer) throws Exception {
        builder.addCameraCaptureCallback(new CameraCaptureCallback() {
            /* class androidx.camera.core.ImageCapture.AnonymousClass8 */

            public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
                completer.set(null);
            }

            public void onCaptureFailed(CameraCaptureFailure cameraCaptureFailure) {
                completer.setException(new CaptureFailedException("Capture request failed with reason " + cameraCaptureFailure.getReason()));
            }

            public void onCaptureCancelled() {
                completer.setException(new CameraClosedException("Capture request is cancelled because camera is closed"));
            }
        });
        list.add(builder.build());
        return "issueTakePicture[stage=" + captureStage.getId() + "]";
    }

    static final class CaptureFailedException extends RuntimeException {
        CaptureFailedException(String str, Throwable th) {
            super(str, th);
        }

        CaptureFailedException(String str) {
            super(str);
        }
    }

    private CaptureBundle getCaptureBundle(CaptureBundle captureBundle) {
        List<CaptureStage> captureStages = this.mCaptureBundle.getCaptureStages();
        return (captureStages == null || captureStages.isEmpty()) ? captureBundle : CaptureBundles.createCaptureBundle(captureStages);
    }

    public static abstract class OnImageCapturedCallback {
        public void onError(ImageCaptureException imageCaptureException) {
        }

        public void onCaptureSuccess(ImageProxy imageProxy) {
            imageProxy.close();
        }
    }

    public static final class Defaults implements ConfigProvider<ImageCaptureConfig> {
        private static final int DEFAULT_CAPTURE_MODE = 1;
        private static final ImageCaptureConfig DEFAULT_CONFIG = new Builder().setCaptureMode(1).setFlashMode(2).setSurfaceOccupancyPriority(4).getUseCaseConfig();
        private static final int DEFAULT_FLASH_MODE = 2;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 4;

        public ImageCaptureConfig getConfig(CameraInfo cameraInfo) {
            return DEFAULT_CONFIG;
        }
    }

    public static final class OutputFileOptions {
        private static final Metadata EMPTY_METADATA = new Metadata();
        private final ContentResolver mContentResolver;
        private final ContentValues mContentValues;
        private final File mFile;
        private final Metadata mMetadata;
        private final OutputStream mOutputStream;
        private final Uri mSaveCollection;

        OutputFileOptions(File file, ContentResolver contentResolver, Uri uri, ContentValues contentValues, OutputStream outputStream, Metadata metadata) {
            this.mFile = file;
            this.mContentResolver = contentResolver;
            this.mSaveCollection = uri;
            this.mContentValues = contentValues;
            this.mOutputStream = outputStream;
            this.mMetadata = metadata == null ? EMPTY_METADATA : metadata;
        }

        /* access modifiers changed from: package-private */
        public File getFile() {
            return this.mFile;
        }

        /* access modifiers changed from: package-private */
        public ContentResolver getContentResolver() {
            return this.mContentResolver;
        }

        /* access modifiers changed from: package-private */
        public Uri getSaveCollection() {
            return this.mSaveCollection;
        }

        /* access modifiers changed from: package-private */
        public ContentValues getContentValues() {
            return this.mContentValues;
        }

        /* access modifiers changed from: package-private */
        public OutputStream getOutputStream() {
            return this.mOutputStream;
        }

        /* access modifiers changed from: package-private */
        public Metadata getMetadata() {
            return this.mMetadata;
        }

        public static final class Builder {
            private ContentResolver mContentResolver;
            private ContentValues mContentValues;
            private File mFile;
            private Metadata mMetadata;
            private OutputStream mOutputStream;
            private Uri mSaveCollection;

            public Builder(File file) {
                this.mFile = file;
            }

            public Builder(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
                this.mContentResolver = contentResolver;
                this.mSaveCollection = uri;
                this.mContentValues = contentValues;
            }

            public Builder(OutputStream outputStream) {
                this.mOutputStream = outputStream;
            }

            public Builder setMetadata(Metadata metadata) {
                this.mMetadata = metadata;
                return this;
            }

            public OutputFileOptions build() {
                return new OutputFileOptions(this.mFile, this.mContentResolver, this.mSaveCollection, this.mContentValues, this.mOutputStream, this.mMetadata);
            }
        }
    }

    public static class OutputFileResults {
        private Uri mSavedUri;

        OutputFileResults(Uri uri) {
            this.mSavedUri = uri;
        }

        public Uri getSavedUri() {
            return this.mSavedUri;
        }
    }

    public static final class Metadata {
        private boolean mIsReversedHorizontal;
        private boolean mIsReversedVertical;
        private Location mLocation;

        public boolean isReversedHorizontal() {
            return this.mIsReversedHorizontal;
        }

        public void setReversedHorizontal(boolean z) {
            this.mIsReversedHorizontal = z;
        }

        public boolean isReversedVertical() {
            return this.mIsReversedVertical;
        }

        public void setReversedVertical(boolean z) {
            this.mIsReversedVertical = z;
        }

        public Location getLocation() {
            return this.mLocation;
        }

        public void setLocation(Location location) {
            this.mLocation = location;
        }
    }

    static final class TakePictureState {
        boolean mIsAePrecaptureTriggered = false;
        boolean mIsAfTriggered = false;
        boolean mIsFlashTriggered = false;
        CameraCaptureResult mPreCaptureState = CameraCaptureResult.EmptyCameraCaptureResult.create();

        TakePictureState() {
        }
    }

    static final class CaptureCallbackChecker extends CameraCaptureCallback {
        private static final long NO_TIMEOUT = 0;
        private final Set<CaptureResultListener> mCaptureResultListeners = new HashSet();

        public interface CaptureResultChecker<T> {
            T check(CameraCaptureResult cameraCaptureResult);
        }

        private interface CaptureResultListener {
            boolean onCaptureResult(CameraCaptureResult cameraCaptureResult);
        }

        CaptureCallbackChecker() {
        }

        public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
            deliverCaptureResultToListeners(cameraCaptureResult);
        }

        /* access modifiers changed from: package-private */
        public <T> ListenableFuture<T> checkCaptureResult(CaptureResultChecker<T> captureResultChecker) {
            return checkCaptureResult(captureResultChecker, 0, null);
        }

        /* access modifiers changed from: package-private */
        public <T> ListenableFuture<T> checkCaptureResult(CaptureResultChecker<T> captureResultChecker, long j, T t) {
            long j2 = 0;
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    j2 = SystemClock.elapsedRealtime();
                }
                return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(captureResultChecker, j2, j, t) {
                    /* class androidx.camera.core.$$Lambda$ImageCapture$CaptureCallbackChecker$RVxDy_zAdeqk9wi1C8KZybyVmF8 */
                    private final /* synthetic */ ImageCapture.CaptureCallbackChecker.CaptureResultChecker f$1;
                    private final /* synthetic */ long f$2;
                    private final /* synthetic */ long f$3;
                    private final /* synthetic */ Object f$4;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r5;
                        this.f$4 = r7;
                    }

                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        return ImageCapture.CaptureCallbackChecker.this.lambda$checkCaptureResult$0$ImageCapture$CaptureCallbackChecker(this.f$1, this.f$2, this.f$3, this.f$4, completer);
                    }
                });
            }
            throw new IllegalArgumentException("Invalid timeout value: " + j);
        }

        public /* synthetic */ Object lambda$checkCaptureResult$0$ImageCapture$CaptureCallbackChecker(CaptureResultChecker captureResultChecker, long j, long j2, Object obj, CallbackToFutureAdapter.Completer completer) throws Exception {
            final CaptureResultChecker captureResultChecker2 = captureResultChecker;
            final CallbackToFutureAdapter.Completer completer2 = completer;
            final long j3 = j;
            final long j4 = j2;
            final Object obj2 = obj;
            addListener(new CaptureResultListener() {
                /* class androidx.camera.core.ImageCapture.CaptureCallbackChecker.AnonymousClass1 */

                public boolean onCaptureResult(CameraCaptureResult cameraCaptureResult) {
                    Object check = captureResultChecker2.check(cameraCaptureResult);
                    if (check != null) {
                        completer2.set(check);
                        return true;
                    } else if (j3 <= 0 || SystemClock.elapsedRealtime() - j3 <= j4) {
                        return false;
                    } else {
                        completer2.set(obj2);
                        return true;
                    }
                }
            });
            return "checkCaptureResult";
        }

        private void deliverCaptureResultToListeners(CameraCaptureResult cameraCaptureResult) {
            synchronized (this.mCaptureResultListeners) {
                HashSet hashSet = null;
                Iterator it = new HashSet(this.mCaptureResultListeners).iterator();
                while (it.hasNext()) {
                    CaptureResultListener captureResultListener = (CaptureResultListener) it.next();
                    if (captureResultListener.onCaptureResult(cameraCaptureResult)) {
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.add(captureResultListener);
                    }
                }
                if (hashSet != null) {
                    this.mCaptureResultListeners.removeAll(hashSet);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void addListener(CaptureResultListener captureResultListener) {
            synchronized (this.mCaptureResultListeners) {
                this.mCaptureResultListeners.add(captureResultListener);
            }
        }
    }

    private static final class ImageCaptureRequest {
        private final OnImageCapturedCallback mCallback;
        AtomicBoolean mDispatched = new AtomicBoolean(false);
        private final Executor mListenerExecutor;
        final int mRotationDegrees;
        private final Rational mTargetRatio;

        ImageCaptureRequest(int i, Rational rational, Executor executor, OnImageCapturedCallback onImageCapturedCallback) {
            this.mRotationDegrees = i;
            this.mTargetRatio = rational;
            this.mListenerExecutor = executor;
            this.mCallback = onImageCapturedCallback;
        }

        /* access modifiers changed from: package-private */
        public void dispatchImage(ImageProxy imageProxy) {
            if (this.mDispatched.compareAndSet(false, true)) {
                try {
                    this.mListenerExecutor.execute(new Runnable(imageProxy) {
                        /* class androidx.camera.core.$$Lambda$ImageCapture$ImageCaptureRequest$E13UUGhRx8PID5WbaCuwcGP87BA */
                        private final /* synthetic */ ImageProxy f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            ImageCapture.ImageCaptureRequest.this.lambda$dispatchImage$0$ImageCapture$ImageCaptureRequest(this.f$1);
                        }
                    });
                } catch (RejectedExecutionException unused) {
                    Log.e(ImageCapture.TAG, "Unable to post to the supplied executor.");
                    imageProxy.close();
                }
            }
        }

        public /* synthetic */ void lambda$dispatchImage$0$ImageCapture$ImageCaptureRequest(ImageProxy imageProxy) {
            Size size = new Size(imageProxy.getWidth(), imageProxy.getHeight());
            if (ImageUtil.isAspectRatioValid(size, this.mTargetRatio)) {
                imageProxy.setCropRect(ImageUtil.computeCropRectFromAspectRatio(size, this.mTargetRatio));
            }
            this.mCallback.onCaptureSuccess(new SettableImageProxy(imageProxy, ImmutableImageInfo.create(imageProxy.getImageInfo().getTag(), imageProxy.getImageInfo().getTimestamp(), this.mRotationDegrees)));
        }

        /* access modifiers changed from: package-private */
        public void notifyCallbackError(int i, String str, Throwable th) {
            if (this.mDispatched.compareAndSet(false, true)) {
                try {
                    this.mListenerExecutor.execute(new Runnable(i, str, th) {
                        /* class androidx.camera.core.$$Lambda$ImageCapture$ImageCaptureRequest$1G7WSvt8TANxhZtOyewefm68pg4 */
                        private final /* synthetic */ int f$1;
                        private final /* synthetic */ String f$2;
                        private final /* synthetic */ Throwable f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void run() {
                            ImageCapture.ImageCaptureRequest.this.lambda$notifyCallbackError$1$ImageCapture$ImageCaptureRequest(this.f$1, this.f$2, this.f$3);
                        }
                    });
                } catch (RejectedExecutionException unused) {
                    Log.e(ImageCapture.TAG, "Unable to post to the supplied executor.");
                }
            }
        }

        public /* synthetic */ void lambda$notifyCallbackError$1$ImageCapture$ImageCaptureRequest(int i, String str, Throwable th) {
            this.mCallback.onError(new ImageCaptureException(i, str, th));
        }
    }

    public static final class Builder implements UseCaseConfig.Builder<ImageCapture, ImageCaptureConfig, Builder>, ImageOutputConfig.Builder<Builder>, IoConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls == null || cls.equals(ImageCapture.class)) {
                setTargetClass((Class<ImageCapture>) ImageCapture.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }

        public static Builder fromConfig(ImageCaptureConfig imageCaptureConfig) {
            return new Builder(MutableOptionsBundle.from((Config) imageCaptureConfig));
        }

        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        public ImageCaptureConfig getUseCaseConfig() {
            return new ImageCaptureConfig(OptionsBundle.from(this.mMutableConfig));
        }

        public ImageCapture build() {
            if (getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_TARGET_ASPECT_RATIO, null) == null || getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_TARGET_RESOLUTION, null) == null) {
                return new ImageCapture(getUseCaseConfig());
            }
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }

        public Builder setCaptureMode(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE, Integer.valueOf(i));
            return this;
        }

        public Builder setFlashMode(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_FLASH_MODE, Integer.valueOf(i));
            return this;
        }

        public Builder setCaptureBundle(CaptureBundle captureBundle) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_CAPTURE_BUNDLE, captureBundle);
            return this;
        }

        public Builder setCaptureProcessor(CaptureProcessor captureProcessor) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR, captureProcessor);
            return this;
        }

        public Builder setBufferFormat(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, Integer.valueOf(i));
            return this;
        }

        public Builder setMaxCaptureStages(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_MAX_CAPTURE_STAGES, Integer.valueOf(i));
            return this;
        }

        public Builder setSupportedResolutions(List<Pair<Integer, Size[]>> list) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
            return this;
        }

        public Builder setTargetClass(Class<ImageCapture> cls) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_CLASS, cls);
            if (getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_TARGET_NAME, null) == null) {
                setTargetName(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        public Builder setTargetName(String str) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_NAME, str);
            return this;
        }

        public Builder setTargetAspectRatioCustom(Rational rational) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_ASPECT_RATIO_CUSTOM, rational);
            getMutableConfig().removeOption(ImageCaptureConfig.OPTION_TARGET_ASPECT_RATIO);
            return this;
        }

        public Builder setTargetAspectRatio(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_ASPECT_RATIO, Integer.valueOf(i));
            return this;
        }

        public Builder setTargetRotation(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i));
            return this;
        }

        public Builder setTargetResolution(Size size) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_RESOLUTION, size);
            if (size != null) {
                getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_ASPECT_RATIO_CUSTOM, new Rational(size.getWidth(), size.getHeight()));
            }
            return this;
        }

        public Builder setDefaultResolution(Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
            return this;
        }

        public Builder setMaxResolution(Size size) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_MAX_RESOLUTION, size);
            return this;
        }

        public Builder setIoExecutor(Executor executor) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IO_EXECUTOR, executor);
            return this;
        }

        public Builder setDefaultSessionConfig(SessionConfig sessionConfig) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
            return this;
        }

        public Builder setDefaultCaptureConfig(CaptureConfig captureConfig) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
            return this;
        }

        public Builder setSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        public Builder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        public Builder setCameraSelector(CameraSelector cameraSelector) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, cameraSelector);
            return this;
        }

        public Builder setSurfaceOccupancyPriority(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i));
            return this;
        }

        public Builder setUseCaseEventCallback(UseCase.EventCallback eventCallback) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_USE_CASE_EVENT_CALLBACK, eventCallback);
            return this;
        }
    }
}

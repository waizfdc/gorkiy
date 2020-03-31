package androidx.camera.view;

import android.content.Context;
import android.util.Log;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.LensFacingConverter;
import androidx.camera.core.impl.VideoCaptureConfig;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.CameraView;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

final class CameraXModule {
    private static final Rational ASPECT_RATIO_16_9 = new Rational(16, 9);
    private static final Rational ASPECT_RATIO_3_4 = new Rational(3, 4);
    private static final Rational ASPECT_RATIO_4_3 = new Rational(4, 3);
    private static final Rational ASPECT_RATIO_9_16 = new Rational(9, 16);
    public static final String TAG = "CameraXModule";
    private static final float UNITY_ZOOM_SCALE = 1.0f;
    private static final float ZOOM_NOT_SUPPORTED = 1.0f;
    Camera mCamera;
    Integer mCameraLensFacing = 1;
    ProcessCameraProvider mCameraProvider;
    private final CameraView mCameraView;
    private CameraView.CaptureMode mCaptureMode = CameraView.CaptureMode.IMAGE;
    LifecycleOwner mCurrentLifecycle;
    private final LifecycleObserver mCurrentLifecycleObserver = new LifecycleObserver() {
        /* class androidx.camera.view.CameraXModule.AnonymousClass1 */

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy(LifecycleOwner lifecycleOwner) {
            if (lifecycleOwner == CameraXModule.this.mCurrentLifecycle) {
                CameraXModule.this.clearCurrentLifecycle();
                CameraXModule.this.mPreview.setSurfaceProvider(null);
            }
        }
    };
    private int mFlash = 2;
    private ImageCapture mImageCapture;
    private final ImageCapture.Builder mImageCaptureBuilder;
    private long mMaxVideoDuration = -1;
    private long mMaxVideoSize = -1;
    private LifecycleOwner mNewLifecycle;
    Preview mPreview;
    private final Preview.Builder mPreviewBuilder;
    private VideoCapture mVideoCapture;
    private final VideoCaptureConfig.Builder mVideoCaptureConfigBuilder;
    final AtomicBoolean mVideoIsRecording = new AtomicBoolean(false);

    public boolean isPaused() {
        return false;
    }

    CameraXModule(CameraView cameraView) {
        this.mCameraView = cameraView;
        Futures.addCallback(ProcessCameraProvider.getInstance(cameraView.getContext()), new FutureCallback<ProcessCameraProvider>() {
            /* class androidx.camera.view.CameraXModule.AnonymousClass2 */

            public void onSuccess(ProcessCameraProvider processCameraProvider) {
                Preconditions.checkNotNull(processCameraProvider);
                CameraXModule.this.mCameraProvider = processCameraProvider;
                if (CameraXModule.this.mCurrentLifecycle != null) {
                    CameraXModule cameraXModule = CameraXModule.this;
                    cameraXModule.bindToLifecycle(cameraXModule.mCurrentLifecycle);
                }
            }

            public void onFailure(Throwable th) {
                throw new RuntimeException("CameraX failed to initialize.", th);
            }
        }, CameraXExecutors.mainThreadExecutor());
        this.mPreviewBuilder = new Preview.Builder().setTargetName("Preview");
        this.mImageCaptureBuilder = new ImageCapture.Builder().setTargetName("ImageCapture");
        this.mVideoCaptureConfigBuilder = new VideoCaptureConfig.Builder().setTargetName("VideoCapture");
    }

    /* access modifiers changed from: package-private */
    public void bindToLifecycle(LifecycleOwner lifecycleOwner) {
        this.mNewLifecycle = lifecycleOwner;
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            bindToLifecycleAfterViewMeasured();
        }
    }

    /* access modifiers changed from: package-private */
    public void bindToLifecycleAfterViewMeasured() {
        Rational rational;
        if (this.mNewLifecycle != null) {
            clearCurrentLifecycle();
            LifecycleOwner lifecycleOwner = this.mNewLifecycle;
            this.mCurrentLifecycle = lifecycleOwner;
            this.mNewLifecycle = null;
            if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                this.mCurrentLifecycle = null;
                throw new IllegalArgumentException("Cannot bind to lifecycle in a destroyed state.");
            } else if (this.mCameraProvider != null) {
                Set<Integer> availableCameraLensFacing = getAvailableCameraLensFacing();
                if (availableCameraLensFacing.isEmpty()) {
                    Log.w(TAG, "Unable to bindToLifeCycle since no cameras available");
                    this.mCameraLensFacing = null;
                }
                Integer num = this.mCameraLensFacing;
                if (num != null && !availableCameraLensFacing.contains(num)) {
                    Log.w(TAG, "Camera does not exist with direction " + this.mCameraLensFacing);
                    this.mCameraLensFacing = availableCameraLensFacing.iterator().next();
                    Log.w(TAG, "Defaulting to primary camera with direction " + this.mCameraLensFacing);
                }
                if (this.mCameraLensFacing != null) {
                    boolean z = getDisplayRotationDegrees() == 0 || getDisplayRotationDegrees() == 180;
                    if (getCaptureMode() == CameraView.CaptureMode.IMAGE) {
                        this.mImageCaptureBuilder.setTargetAspectRatio(0);
                        rational = z ? ASPECT_RATIO_3_4 : ASPECT_RATIO_4_3;
                    } else {
                        this.mImageCaptureBuilder.setTargetAspectRatio(1);
                        rational = z ? ASPECT_RATIO_9_16 : ASPECT_RATIO_16_9;
                    }
                    this.mImageCaptureBuilder.setTargetRotation(getDisplaySurfaceRotation());
                    this.mImageCapture = this.mImageCaptureBuilder.build();
                    this.mVideoCaptureConfigBuilder.setTargetRotation(getDisplaySurfaceRotation());
                    this.mVideoCapture = this.mVideoCaptureConfigBuilder.build();
                    this.mPreviewBuilder.setTargetResolution(new Size(getMeasuredWidth(), (int) (((float) getMeasuredWidth()) / rational.floatValue())));
                    Preview build = this.mPreviewBuilder.build();
                    this.mPreview = build;
                    build.setSurfaceProvider(this.mCameraView.getPreviewView().getPreviewSurfaceProvider());
                    CameraSelector build2 = new CameraSelector.Builder().requireLensFacing(this.mCameraLensFacing.intValue()).build();
                    if (getCaptureMode() == CameraView.CaptureMode.IMAGE) {
                        this.mCamera = this.mCameraProvider.bindToLifecycle(this.mCurrentLifecycle, build2, this.mImageCapture, this.mPreview);
                    } else if (getCaptureMode() == CameraView.CaptureMode.VIDEO) {
                        this.mCamera = this.mCameraProvider.bindToLifecycle(this.mCurrentLifecycle, build2, this.mVideoCapture, this.mPreview);
                    } else {
                        this.mCamera = this.mCameraProvider.bindToLifecycle(this.mCurrentLifecycle, build2, this.mImageCapture, this.mVideoCapture, this.mPreview);
                    }
                    setZoomRatio(1.0f);
                    this.mCurrentLifecycle.getLifecycle().addObserver(this.mCurrentLifecycleObserver);
                    setFlash(getFlash());
                }
            }
        }
    }

    public void open() {
        throw new UnsupportedOperationException("Explicit open/close of camera not yet supported. Use bindtoLifecycle() instead.");
    }

    public void close() {
        throw new UnsupportedOperationException("Explicit open/close of camera not yet supported. Use bindtoLifecycle() instead.");
    }

    public void takePicture(Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback) {
        if (this.mImageCapture != null) {
            if (getCaptureMode() == CameraView.CaptureMode.VIDEO) {
                throw new IllegalStateException("Can not take picture under VIDEO capture mode.");
            } else if (onImageCapturedCallback != null) {
                this.mImageCapture.lambda$takePicture$3$ImageCapture(executor, onImageCapturedCallback);
            } else {
                throw new IllegalArgumentException("OnImageCapturedCallback should not be empty");
            }
        }
    }

    public void takePicture(File file, Executor executor, ImageCapture.OnImageSavedCallback onImageSavedCallback) {
        if (this.mImageCapture != null) {
            if (getCaptureMode() == CameraView.CaptureMode.VIDEO) {
                throw new IllegalStateException("Can not take picture under VIDEO capture mode.");
            } else if (onImageSavedCallback != null) {
                ImageCapture.Metadata metadata = new ImageCapture.Metadata();
                Integer num = this.mCameraLensFacing;
                metadata.setReversedHorizontal(num != null && num.intValue() == 0);
                this.mImageCapture.lambda$takePicture$4$ImageCapture(new ImageCapture.OutputFileOptions.Builder(file).setMetadata(metadata).build(), executor, onImageSavedCallback);
            } else {
                throw new IllegalArgumentException("OnImageSavedCallback should not be empty");
            }
        }
    }

    public void startRecording(File file, Executor executor, final VideoCapture.OnVideoSavedCallback onVideoSavedCallback) {
        if (this.mVideoCapture != null) {
            if (getCaptureMode() == CameraView.CaptureMode.IMAGE) {
                throw new IllegalStateException("Can not record video under IMAGE capture mode.");
            } else if (onVideoSavedCallback != null) {
                this.mVideoIsRecording.set(true);
                this.mVideoCapture.startRecording(file, executor, new VideoCapture.OnVideoSavedCallback() {
                    /* class androidx.camera.view.CameraXModule.AnonymousClass3 */

                    public void onVideoSaved(File file) {
                        CameraXModule.this.mVideoIsRecording.set(false);
                        onVideoSavedCallback.onVideoSaved(file);
                    }

                    public void onError(int i, String str, Throwable th) {
                        CameraXModule.this.mVideoIsRecording.set(false);
                        Log.e(CameraXModule.TAG, str, th);
                        onVideoSavedCallback.onError(i, str, th);
                    }
                });
            } else {
                throw new IllegalArgumentException("OnVideoSavedCallback should not be empty");
            }
        }
    }

    public void stopRecording() {
        VideoCapture videoCapture = this.mVideoCapture;
        if (videoCapture != null) {
            videoCapture.stopRecording();
        }
    }

    public boolean isRecording() {
        return this.mVideoIsRecording.get();
    }

    public void setCameraLensFacing(Integer num) {
        if (!Objects.equals(this.mCameraLensFacing, num)) {
            this.mCameraLensFacing = num;
            LifecycleOwner lifecycleOwner = this.mCurrentLifecycle;
            if (lifecycleOwner != null) {
                bindToLifecycle(lifecycleOwner);
            }
        }
    }

    public boolean hasCameraWithLensFacing(int i) {
        try {
            return CameraX.getCameraWithLensFacing(i) != null;
        } catch (Exception e) {
            throw new IllegalStateException("Unable to query lens facing.", e);
        }
    }

    public Integer getLensFacing() {
        return this.mCameraLensFacing;
    }

    public void toggleCamera() {
        Set<Integer> availableCameraLensFacing = getAvailableCameraLensFacing();
        if (!availableCameraLensFacing.isEmpty()) {
            Integer num = this.mCameraLensFacing;
            if (num == null) {
                setCameraLensFacing(availableCameraLensFacing.iterator().next());
            } else if (num.intValue() == 1 && availableCameraLensFacing.contains(0)) {
                setCameraLensFacing(0);
            } else if (this.mCameraLensFacing.intValue() == 0 && availableCameraLensFacing.contains(1)) {
                setCameraLensFacing(1);
            }
        }
    }

    public float getZoomRatio() {
        Camera camera = this.mCamera;
        if (camera != null) {
            return camera.getCameraInfo().getZoomState().getValue().getZoomRatio();
        }
        return 1.0f;
    }

    public void setZoomRatio(float f) {
        Camera camera = this.mCamera;
        if (camera != null) {
            Futures.addCallback(camera.getCameraControl().setZoomRatio(f), new FutureCallback<Void>() {
                /* class androidx.camera.view.CameraXModule.AnonymousClass4 */

                public void onSuccess(Void voidR) {
                }

                public void onFailure(Throwable th) {
                    throw new RuntimeException(th);
                }
            }, CameraXExecutors.directExecutor());
        } else {
            Log.e(TAG, "Failed to set zoom ratio");
        }
    }

    public float getMinZoomRatio() {
        Camera camera = this.mCamera;
        if (camera != null) {
            return camera.getCameraInfo().getZoomState().getValue().getMinZoomRatio();
        }
        return 1.0f;
    }

    public float getMaxZoomRatio() {
        Camera camera = this.mCamera;
        if (camera != null) {
            return camera.getCameraInfo().getZoomState().getValue().getMaxZoomRatio();
        }
        return 1.0f;
    }

    public boolean isZoomSupported() {
        return getMaxZoomRatio() != 1.0f;
    }

    private void rebindToLifecycle() {
        LifecycleOwner lifecycleOwner = this.mCurrentLifecycle;
        if (lifecycleOwner != null) {
            bindToLifecycle(lifecycleOwner);
        }
    }

    /* access modifiers changed from: package-private */
    public int getRelativeCameraOrientation(boolean z) {
        Camera camera = this.mCamera;
        if (camera == null) {
            return 0;
        }
        int sensorRotationDegrees = camera.getCameraInfo().getSensorRotationDegrees(getDisplaySurfaceRotation());
        return z ? (360 - sensorRotationDegrees) % 360 : sensorRotationDegrees;
    }

    public void invalidateView() {
        updateViewInfo();
    }

    /* access modifiers changed from: package-private */
    public void clearCurrentLifecycle() {
        if (!(this.mCurrentLifecycle == null || this.mCameraProvider == null)) {
            ArrayList arrayList = new ArrayList();
            ImageCapture imageCapture = this.mImageCapture;
            if (imageCapture != null && this.mCameraProvider.isBound(imageCapture)) {
                arrayList.add(this.mImageCapture);
            }
            VideoCapture videoCapture = this.mVideoCapture;
            if (videoCapture != null && this.mCameraProvider.isBound(videoCapture)) {
                arrayList.add(this.mVideoCapture);
            }
            Preview preview = this.mPreview;
            if (preview != null && this.mCameraProvider.isBound(preview)) {
                arrayList.add(this.mPreview);
            }
            if (!arrayList.isEmpty()) {
                this.mCameraProvider.unbind((UseCase[]) arrayList.toArray(new UseCase[0]));
            }
        }
        this.mCamera = null;
        this.mCurrentLifecycle = null;
    }

    private void updateViewInfo() {
        ImageCapture imageCapture = this.mImageCapture;
        if (imageCapture != null) {
            imageCapture.setCropAspectRatio(new Rational(getWidth(), getHeight()));
            this.mImageCapture.setTargetRotation(getDisplaySurfaceRotation());
        }
        VideoCapture videoCapture = this.mVideoCapture;
        if (videoCapture != null) {
            videoCapture.setTargetRotation(getDisplaySurfaceRotation());
        }
    }

    private Set<Integer> getAvailableCameraLensFacing() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(LensFacingConverter.values()));
        if (this.mCurrentLifecycle != null) {
            if (!hasCameraWithLensFacing(1)) {
                linkedHashSet.remove(1);
            }
            if (!hasCameraWithLensFacing(0)) {
                linkedHashSet.remove(0);
            }
        }
        return linkedHashSet;
    }

    public int getFlash() {
        return this.mFlash;
    }

    public void setFlash(int i) {
        this.mFlash = i;
        ImageCapture imageCapture = this.mImageCapture;
        if (imageCapture != null) {
            imageCapture.setFlashMode(i);
        }
    }

    public void enableTorch(boolean z) {
        Camera camera = this.mCamera;
        if (camera != null) {
            Futures.addCallback(camera.getCameraControl().enableTorch(z), new FutureCallback<Void>() {
                /* class androidx.camera.view.CameraXModule.AnonymousClass5 */

                public void onSuccess(Void voidR) {
                }

                public void onFailure(Throwable th) {
                    throw new RuntimeException(th);
                }
            }, CameraXExecutors.directExecutor());
        }
    }

    public boolean isTorchOn() {
        Camera camera = this.mCamera;
        if (camera != null && camera.getCameraInfo().getTorchState().getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public Context getContext() {
        return this.mCameraView.getContext();
    }

    public int getWidth() {
        return this.mCameraView.getWidth();
    }

    public int getHeight() {
        return this.mCameraView.getHeight();
    }

    public int getDisplayRotationDegrees() {
        return CameraOrientationUtil.surfaceRotationToDegrees(getDisplaySurfaceRotation());
    }

    /* access modifiers changed from: protected */
    public int getDisplaySurfaceRotation() {
        return this.mCameraView.getDisplaySurfaceRotation();
    }

    private int getMeasuredWidth() {
        return this.mCameraView.getMeasuredWidth();
    }

    private int getMeasuredHeight() {
        return this.mCameraView.getMeasuredHeight();
    }

    public Camera getCamera() {
        return this.mCamera;
    }

    public CameraView.CaptureMode getCaptureMode() {
        return this.mCaptureMode;
    }

    public void setCaptureMode(CameraView.CaptureMode captureMode) {
        this.mCaptureMode = captureMode;
        rebindToLifecycle();
    }

    public long getMaxVideoDuration() {
        return this.mMaxVideoDuration;
    }

    public void setMaxVideoDuration(long j) {
        this.mMaxVideoDuration = j;
    }

    public long getMaxVideoSize() {
        return this.mMaxVideoSize;
    }

    public void setMaxVideoSize(long j) {
        this.mMaxVideoSize = j;
    }
}

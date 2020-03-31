package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Rational;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

final class Camera2CameraControl implements CameraControlInternal {
    private final AeFpsRange mAeFpsRange;
    private final CameraCharacteristics mCameraCharacteristics;
    private final CameraControlInternal.ControlUpdateCallback mControlUpdateCallback;
    private Rect mCropRect = null;
    final Executor mExecutor;
    private volatile int mFlashMode = 2;
    private final FocusMeteringControl mFocusMeteringControl;
    private volatile boolean mIsTorchOn = false;
    volatile Rational mPreviewAspectRatio = null;
    final CameraControlSessionCallback mSessionCallback;
    private final SessionConfig.Builder mSessionConfigBuilder = new SessionConfig.Builder();
    private final TorchControl mTorchControl;
    private final ZoomControl mZoomControl;

    interface CaptureResultListener {
        boolean onCaptureResult(TotalCaptureResult totalCaptureResult);
    }

    /* access modifiers changed from: package-private */
    public int getDefaultTemplate() {
        return 1;
    }

    Camera2CameraControl(CameraCharacteristics cameraCharacteristics, ScheduledExecutorService scheduledExecutorService, Executor executor, CameraControlInternal.ControlUpdateCallback controlUpdateCallback) {
        this.mCameraCharacteristics = cameraCharacteristics;
        this.mControlUpdateCallback = controlUpdateCallback;
        this.mExecutor = executor;
        this.mSessionCallback = new CameraControlSessionCallback(this.mExecutor);
        this.mSessionConfigBuilder.setTemplateType(getDefaultTemplate());
        this.mSessionConfigBuilder.addRepeatingCameraCaptureCallback(CaptureCallbackContainer.create(this.mSessionCallback));
        this.mFocusMeteringControl = new FocusMeteringControl(this, scheduledExecutorService, this.mExecutor);
        this.mZoomControl = new ZoomControl(this, this.mCameraCharacteristics);
        this.mTorchControl = new TorchControl(this, this.mCameraCharacteristics);
        this.mAeFpsRange = new AeFpsRange(this.mCameraCharacteristics);
        this.mExecutor.execute(new Runnable() {
            /* class androidx.camera.camera2.internal.$$Lambda$o3ojAeQw5uAR3XMBxVrGNZPoNY0 */

            public final void run() {
                Camera2CameraControl.this.updateSessionConfig();
            }
        });
    }

    public ZoomControl getZoomControl() {
        return this.mZoomControl;
    }

    public TorchControl getTorchControl() {
        return this.mTorchControl;
    }

    /* access modifiers changed from: package-private */
    public void setActive(boolean z) {
        this.mFocusMeteringControl.setActive(z);
        this.mZoomControl.setActive(z);
        this.mTorchControl.setActive(z);
    }

    public void setPreviewAspectRatio(Rational rational) {
        this.mPreviewAspectRatio = rational;
    }

    public void setDefaultRequestBuilder(CaptureRequest.Builder builder) {
        this.mFocusMeteringControl.setDefaultRequestBuilder(builder);
    }

    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction focusMeteringAction) {
        return this.mFocusMeteringControl.startFocusAndMetering(focusMeteringAction, this.mPreviewAspectRatio);
    }

    public ListenableFuture<Void> cancelFocusAndMetering() {
        return this.mFocusMeteringControl.cancelFocusAndMetering();
    }

    public ListenableFuture<Void> setZoomRatio(float f) {
        return this.mZoomControl.setZoomRatio(f);
    }

    public ListenableFuture<Void> setLinearZoom(float f) {
        return this.mZoomControl.setLinearZoom(f);
    }

    public void setCropRegion(Rect rect) {
        this.mExecutor.execute(new Runnable(rect) {
            /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraControl$n55emHrx23eyFO4AOfALgxleaM */
            private final /* synthetic */ Rect f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                Camera2CameraControl.this.lambda$setCropRegion$0$Camera2CameraControl(this.f$1);
            }
        });
    }

    public int getFlashMode() {
        return this.mFlashMode;
    }

    public void setFlashMode(int i) {
        this.mFlashMode = i;
        this.mExecutor.execute(new Runnable() {
            /* class androidx.camera.camera2.internal.$$Lambda$o3ojAeQw5uAR3XMBxVrGNZPoNY0 */

            public final void run() {
                Camera2CameraControl.this.updateSessionConfig();
            }
        });
    }

    public ListenableFuture<Void> enableTorch(boolean z) {
        return this.mTorchControl.enableTorch(z);
    }

    public void triggerAf() {
        Executor executor = this.mExecutor;
        FocusMeteringControl focusMeteringControl = this.mFocusMeteringControl;
        focusMeteringControl.getClass();
        executor.execute(new Runnable() {
            /* class androidx.camera.camera2.internal.$$Lambda$jMLZkVYtb17sGVEMgJeaqSwRqM */

            public final void run() {
                FocusMeteringControl.this.triggerAf();
            }
        });
    }

    public void triggerAePrecapture() {
        Executor executor = this.mExecutor;
        FocusMeteringControl focusMeteringControl = this.mFocusMeteringControl;
        focusMeteringControl.getClass();
        executor.execute(new Runnable() {
            /* class androidx.camera.camera2.internal.$$Lambda$CYPdi4_uPx6_TvmhN2hVOTmRnZY */

            public final void run() {
                FocusMeteringControl.this.triggerAePrecapture();
            }
        });
    }

    public void cancelAfAeTrigger(boolean z, boolean z2) {
        this.mExecutor.execute(new Runnable(z, z2) {
            /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraControl$Jjzeg8tXscfy6ODM1OG_vXIvOO4 */
            private final /* synthetic */ boolean f$1;
            private final /* synthetic */ boolean f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                Camera2CameraControl.this.lambda$cancelAfAeTrigger$1$Camera2CameraControl(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$cancelAfAeTrigger$1$Camera2CameraControl(boolean z, boolean z2) {
        this.mFocusMeteringControl.cancelAfAeTrigger(z, z2);
    }

    public void submitCaptureRequests(List<CaptureConfig> list) {
        this.mExecutor.execute(new Runnable(list) {
            /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraControl$GERqx0LkpfTy59lJbP8w9DjVI18 */
            private final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                Camera2CameraControl.this.lambda$submitCaptureRequests$2$Camera2CameraControl(this.f$1);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void updateSessionConfig() {
        this.mSessionConfigBuilder.setImplementationOptions(getSessionOptions());
        this.mControlUpdateCallback.onCameraControlUpdateSessionConfig(this.mSessionConfigBuilder.build());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: setCropRegionInternal */
    public void lambda$setCropRegion$0$Camera2CameraControl(Rect rect) {
        this.mCropRect = rect;
        updateSessionConfig();
    }

    /* access modifiers changed from: package-private */
    public Rect getCropSensorRegion() {
        Rect rect = this.mCropRect;
        return rect == null ? getSensorRect() : rect;
    }

    /* access modifiers changed from: package-private */
    public Rect getSensorRect() {
        return (Rect) Preconditions.checkNotNull(this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }

    /* access modifiers changed from: package-private */
    public void removeCaptureResultListener(CaptureResultListener captureResultListener) {
        this.mSessionCallback.removeListener(captureResultListener);
    }

    /* access modifiers changed from: package-private */
    public void addCaptureResultListener(CaptureResultListener captureResultListener) {
        this.mSessionCallback.addListener(captureResultListener);
    }

    /* access modifiers changed from: package-private */
    public void enableTorchInternal(boolean z) {
        this.mExecutor.execute(new Runnable(z) {
            /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraControl$uR8xQejdgJo8dwAPBtWHbuq1xU */
            private final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                Camera2CameraControl.this.lambda$enableTorchInternal$3$Camera2CameraControl(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$enableTorchInternal$3$Camera2CameraControl(boolean z) {
        this.mIsTorchOn = z;
        if (!z) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(getDefaultTemplate());
            builder.setUseRepeatingSurface(true);
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(getSupportedAeMode(1)));
            builder2.setCaptureRequestOption(CaptureRequest.FLASH_MODE, 0);
            builder.addImplementationOptions(builder2.build());
            lambda$submitCaptureRequests$2$Camera2CameraControl(Collections.singletonList(builder.build()));
        }
        updateSessionConfig();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: submitCaptureRequestsInternal */
    public void lambda$submitCaptureRequests$2$Camera2CameraControl(List<CaptureConfig> list) {
        this.mControlUpdateCallback.onCameraControlCaptureRequests(list);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.impl.Config getSessionOptions() {
        /*
            r4 = this;
            androidx.camera.camera2.impl.Camera2ImplConfig$Builder r0 = new androidx.camera.camera2.impl.Camera2ImplConfig$Builder
            r0.<init>()
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.CONTROL_MODE
            r2 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r0.setCaptureRequestOption(r1, r3)
            androidx.camera.camera2.internal.FocusMeteringControl r1 = r4.mFocusMeteringControl
            r1.addFocusMeteringOptions(r0)
            androidx.camera.camera2.internal.AeFpsRange r1 = r4.mAeFpsRange
            r1.addAeFpsRangeOptions(r0)
            boolean r1 = r4.mIsTorchOn
            r3 = 2
            if (r1 == 0) goto L_0x0028
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.FLASH_MODE
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.setCaptureRequestOption(r1, r3)
            goto L_0x002e
        L_0x0028:
            int r1 = r4.mFlashMode
            if (r1 == 0) goto L_0x0031
            if (r1 == r2) goto L_0x0030
        L_0x002e:
            r3 = r2
            goto L_0x0031
        L_0x0030:
            r3 = 3
        L_0x0031:
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE
            int r3 = r4.getSupportedAeMode(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.setCaptureRequestOption(r1, r3)
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.CONTROL_AWB_MODE
            int r2 = r4.getSupportedAwbMode(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.setCaptureRequestOption(r1, r2)
            android.graphics.Rect r1 = r4.mCropRect
            if (r1 == 0) goto L_0x0056
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.SCALER_CROP_REGION
            android.graphics.Rect r2 = r4.mCropRect
            r0.setCaptureRequestOption(r1, r2)
        L_0x0056:
            androidx.camera.camera2.impl.Camera2ImplConfig r0 = r0.build()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.Camera2CameraControl.getSessionOptions():androidx.camera.core.impl.Config");
    }

    /* access modifiers changed from: package-private */
    public int getSupportedAfMode(int i) {
        int[] iArr = (int[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (isModeInList(i, iArr)) {
            return i;
        }
        if (isModeInList(4, iArr)) {
            return 4;
        }
        if (isModeInList(1, iArr)) {
            return 1;
        }
        return 0;
    }

    private int getSupportedAeMode(int i) {
        int[] iArr = (int[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (isModeInList(i, iArr)) {
            return i;
        }
        if (isModeInList(1, iArr)) {
            return 1;
        }
        return 0;
    }

    private int getSupportedAwbMode(int i) {
        int[] iArr = (int[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (isModeInList(i, iArr)) {
            return i;
        }
        if (isModeInList(1, iArr)) {
            return 1;
        }
        return 0;
    }

    private boolean isModeInList(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int getMaxAfRegionCount() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    public int getMaxAeRegionCount() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    public int getMaxAwbRegionCount() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    static final class CameraControlSessionCallback extends CameraCaptureSession.CaptureCallback {
        private final Executor mExecutor;
        final Set<CaptureResultListener> mResultListeners = new HashSet();

        CameraControlSessionCallback(Executor executor) {
            this.mExecutor = executor;
        }

        /* access modifiers changed from: package-private */
        public void addListener(CaptureResultListener captureResultListener) {
            this.mResultListeners.add(captureResultListener);
        }

        /* access modifiers changed from: package-private */
        public void removeListener(CaptureResultListener captureResultListener) {
            this.mResultListeners.remove(captureResultListener);
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            this.mExecutor.execute(new Runnable(totalCaptureResult) {
                /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraControl$CameraControlSessionCallback$D22IA_eQmzTWvkNwlgaZNWM8E8 */
                private final /* synthetic */ TotalCaptureResult f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    Camera2CameraControl.CameraControlSessionCallback.this.lambda$onCaptureCompleted$0$Camera2CameraControl$CameraControlSessionCallback(this.f$1);
                }
            });
        }

        public /* synthetic */ void lambda$onCaptureCompleted$0$Camera2CameraControl$CameraControlSessionCallback(TotalCaptureResult totalCaptureResult) {
            HashSet hashSet = new HashSet();
            for (CaptureResultListener next : this.mResultListeners) {
                if (next.onCaptureResult(totalCaptureResult)) {
                    hashSet.add(next);
                }
            }
            if (!hashSet.isEmpty()) {
                this.mResultListeners.removeAll(hashSet);
            }
        }
    }
}

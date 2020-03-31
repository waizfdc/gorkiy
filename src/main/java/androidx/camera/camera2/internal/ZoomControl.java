package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Looper;
import androidx.camera.camera2.internal.Camera2CameraControl;
import androidx.camera.core.CameraControl;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.ImmutableZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;

final class ZoomControl {
    public static final float DEFAULT_ZOOM_RATIO = 1.0f;
    public static final float MIN_ZOOM = 1.0f;
    private static final String TAG = "ZoomControl";
    final Object mActiveLock = new Object();
    private final Camera2CameraControl mCamera2CameraControl;
    private Camera2CameraControl.CaptureResultListener mCaptureResultListener = new Camera2CameraControl.CaptureResultListener() {
        /* class androidx.camera.camera2.internal.ZoomControl.AnonymousClass1 */

        public boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
            CallbackToFutureAdapter.Completer<Void> completer;
            Rect rect;
            synchronized (ZoomControl.this.mCompleterLock) {
                if (ZoomControl.this.mPendingZoomRatioCompleter != null) {
                    CaptureRequest request = totalCaptureResult.getRequest();
                    if (request == null) {
                        rect = null;
                    } else {
                        rect = (Rect) request.get(CaptureRequest.SCALER_CROP_REGION);
                    }
                    if (ZoomControl.this.mPendingZoomCropRegion != null && ZoomControl.this.mPendingZoomCropRegion.equals(rect)) {
                        completer = ZoomControl.this.mPendingZoomRatioCompleter;
                        ZoomControl.this.mPendingZoomRatioCompleter = null;
                        ZoomControl.this.mPendingZoomCropRegion = null;
                    }
                }
                completer = null;
            }
            if (completer == null) {
                return false;
            }
            completer.set(null);
            return false;
        }
    };
    final Object mCompleterLock = new Object();
    private final ZoomStateImpl mCurrentZoomState;
    private boolean mIsActive = false;
    Rect mPendingZoomCropRegion = null;
    CallbackToFutureAdapter.Completer<Void> mPendingZoomRatioCompleter;
    private final MutableLiveData<ZoomState> mZoomStateLiveData;

    ZoomControl(Camera2CameraControl camera2CameraControl, CameraCharacteristics cameraCharacteristics) {
        this.mCamera2CameraControl = camera2CameraControl;
        ZoomStateImpl zoomStateImpl = new ZoomStateImpl(getMaxDigitalZoom(cameraCharacteristics), 1.0f);
        this.mCurrentZoomState = zoomStateImpl;
        zoomStateImpl.setZoomRatio(1.0f);
        this.mZoomStateLiveData = new MutableLiveData<>(ImmutableZoomState.create(this.mCurrentZoomState));
        camera2CameraControl.addCaptureResultListener(this.mCaptureResultListener);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0036, code lost:
        if (r6 == false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0038, code lost:
        r5.mCamera2CameraControl.setCropRegion(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003d, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x003f, code lost:
        r2.setException(new androidx.camera.core.CameraControl.OperationCanceledException("Camera is not active."));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setActive(boolean r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mActiveLock
            monitor-enter(r0)
            boolean r1 = r5.mIsActive     // Catch:{ all -> 0x004a }
            if (r1 != r6) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return
        L_0x0009:
            r5.mIsActive = r6     // Catch:{ all -> 0x004a }
            r1 = 0
            if (r6 != 0) goto L_0x0033
            java.lang.Object r6 = r5.mCompleterLock     // Catch:{ all -> 0x004a }
            monitor-enter(r6)     // Catch:{ all -> 0x004a }
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r2 = r5.mPendingZoomRatioCompleter     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x001c
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r2 = r5.mPendingZoomRatioCompleter     // Catch:{ all -> 0x0030 }
            r5.mPendingZoomRatioCompleter = r1     // Catch:{ all -> 0x0030 }
            r5.mPendingZoomCropRegion = r1     // Catch:{ all -> 0x0030 }
            goto L_0x001d
        L_0x001c:
            r2 = r1
        L_0x001d:
            monitor-exit(r6)     // Catch:{ all -> 0x0030 }
            r6 = 1
            androidx.camera.camera2.internal.ZoomStateImpl r3 = r5.mCurrentZoomState     // Catch:{ all -> 0x004a }
            r4 = 1065353216(0x3f800000, float:1.0)
            r3.setZoomRatio(r4)     // Catch:{ all -> 0x004a }
            androidx.camera.camera2.internal.ZoomStateImpl r3 = r5.mCurrentZoomState     // Catch:{ all -> 0x004a }
            androidx.camera.core.ZoomState r3 = androidx.camera.core.internal.ImmutableZoomState.create(r3)     // Catch:{ all -> 0x004a }
            r5.updateLiveData(r3)     // Catch:{ all -> 0x004a }
            goto L_0x0035
        L_0x0030:
            r1 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0030 }
            throw r1     // Catch:{ all -> 0x004a }
        L_0x0033:
            r6 = 0
            r2 = r1
        L_0x0035:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            if (r6 == 0) goto L_0x003d
            androidx.camera.camera2.internal.Camera2CameraControl r6 = r5.mCamera2CameraControl
            r6.setCropRegion(r1)
        L_0x003d:
            if (r2 == 0) goto L_0x0049
            androidx.camera.core.CameraControl$OperationCanceledException r6 = new androidx.camera.core.CameraControl$OperationCanceledException
            java.lang.String r0 = "Camera is not active."
            r6.<init>(r0)
            r2.setException(r6)
        L_0x0049:
            return
        L_0x004a:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.ZoomControl.setActive(boolean):void");
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> setZoomRatio(float f) {
        synchronized (this.mActiveLock) {
            if (!this.mIsActive) {
                ListenableFuture<Void> immediateFailedFuture = Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
                return immediateFailedFuture;
            }
            try {
                this.mCurrentZoomState.setZoomRatio(f);
                updateLiveData(ImmutableZoomState.create(this.mCurrentZoomState));
                ListenableFuture<Void> submitCameraZoomRatio = submitCameraZoomRatio(f);
                return submitCameraZoomRatio;
            } catch (IllegalArgumentException e) {
                return Futures.immediateFailedFuture(e);
            }
        }
    }

    static Rect getCropRectByRatio(Rect rect, float f) {
        float width = ((float) rect.width()) / f;
        float height = ((float) rect.height()) / f;
        float width2 = (((float) rect.width()) - width) / 2.0f;
        float height2 = (((float) rect.height()) - height) / 2.0f;
        return new Rect((int) width2, (int) height2, (int) (width2 + width), (int) (height2 + height));
    }

    private ListenableFuture<Void> submitCameraZoomRatio(float f) {
        Rect cropRectByRatio = getCropRectByRatio(this.mCamera2CameraControl.getSensorRect(), f);
        this.mCamera2CameraControl.setCropRegion(cropRectByRatio);
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(cropRectByRatio) {
            /* class androidx.camera.camera2.internal.$$Lambda$ZoomControl$Drb7VorNRO23tcp0rNs8amFoh4 */
            private final /* synthetic */ Rect f$1;

            {
                this.f$1 = r2;
            }

            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return ZoomControl.this.lambda$submitCameraZoomRatio$0$ZoomControl(this.f$1, completer);
            }
        });
    }

    public /* synthetic */ Object lambda$submitCameraZoomRatio$0$ZoomControl(Rect rect, CallbackToFutureAdapter.Completer completer) throws Exception {
        CallbackToFutureAdapter.Completer<Void> completer2;
        synchronized (this.mCompleterLock) {
            completer2 = null;
            if (this.mPendingZoomRatioCompleter != null) {
                CallbackToFutureAdapter.Completer<Void> completer3 = this.mPendingZoomRatioCompleter;
                this.mPendingZoomRatioCompleter = null;
                completer2 = completer3;
            }
            this.mPendingZoomCropRegion = rect;
            this.mPendingZoomRatioCompleter = completer;
        }
        if (completer2 == null) {
            return "setZoomRatio";
        }
        completer2.setException(new CameraControl.OperationCanceledException("There is a new zoomRatio being set"));
        return "setZoomRatio";
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> setLinearZoom(float f) {
        synchronized (this.mActiveLock) {
            if (!this.mIsActive) {
                ListenableFuture<Void> immediateFailedFuture = Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
                return immediateFailedFuture;
            }
            try {
                this.mCurrentZoomState.setLinearZoom(f);
                updateLiveData(ImmutableZoomState.create(this.mCurrentZoomState));
                ListenableFuture<Void> submitCameraZoomRatio = submitCameraZoomRatio(this.mCurrentZoomState.getZoomRatio());
                return submitCameraZoomRatio;
            } catch (IllegalArgumentException e) {
                return Futures.immediateFailedFuture(e);
            }
        }
    }

    private void updateLiveData(ZoomState zoomState) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.mZoomStateLiveData.setValue(zoomState);
        } else {
            this.mZoomStateLiveData.postValue(zoomState);
        }
    }

    /* access modifiers changed from: package-private */
    public LiveData<ZoomState> getZoomState() {
        return this.mZoomStateLiveData;
    }

    private static float getMaxDigitalZoom(CameraCharacteristics cameraCharacteristics) {
        Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f == null) {
            return 1.0f;
        }
        return f.floatValue();
    }
}

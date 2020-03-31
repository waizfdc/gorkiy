package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Log;
import androidx.camera.camera2.internal.Camera2CameraControl;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;

final class TorchControl {
    private static final String TAG = "TorchControl";
    private final Object mActiveLock = new Object();
    private final Camera2CameraControl mCamera2CameraControl;
    private final Camera2CameraControl.CaptureResultListener mCaptureResultListener = new Camera2CameraControl.CaptureResultListener() {
        /* class androidx.camera.camera2.internal.TorchControl.AnonymousClass1 */

        public boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
            CallbackToFutureAdapter.Completer<Void> completer;
            synchronized (TorchControl.this.mEnableTorchLock) {
                if (TorchControl.this.mEnableTorchCompleter != null) {
                    Integer num = (Integer) totalCaptureResult.getRequest().get(CaptureRequest.FLASH_MODE);
                    if ((num != null && num.intValue() == 2) == TorchControl.this.mTargetTorchEnabled) {
                        completer = TorchControl.this.mEnableTorchCompleter;
                        TorchControl.this.mEnableTorchCompleter = null;
                    }
                }
                completer = null;
            }
            if (completer != null) {
                completer.set(null);
            }
            return false;
        }
    };
    CallbackToFutureAdapter.Completer<Void> mEnableTorchCompleter;
    final Object mEnableTorchLock = new Object();
    private final boolean mHasFlashUnit;
    private boolean mIsActive;
    boolean mTargetTorchEnabled;
    private final MutableLiveData<Integer> mTorchState;

    TorchControl(Camera2CameraControl camera2CameraControl, CameraCharacteristics cameraCharacteristics) {
        this.mCamera2CameraControl = camera2CameraControl;
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        this.mHasFlashUnit = bool != null && bool.booleanValue();
        this.mTorchState = new MutableLiveData<>(0);
        this.mCamera2CameraControl.addCaptureResultListener(this.mCaptureResultListener);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setActive(boolean r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mActiveLock
            monitor-enter(r0)
            boolean r1 = r5.mIsActive     // Catch:{ all -> 0x0046 }
            if (r1 != r6) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            return
        L_0x0009:
            r5.mIsActive = r6     // Catch:{ all -> 0x0046 }
            java.lang.Object r1 = r5.mEnableTorchLock     // Catch:{ all -> 0x0046 }
            monitor-enter(r1)     // Catch:{ all -> 0x0046 }
            r2 = 0
            r3 = 0
            if (r6 != 0) goto L_0x0028
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r6 = r5.mEnableTorchCompleter     // Catch:{ all -> 0x0043 }
            if (r6 == 0) goto L_0x001b
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r6 = r5.mEnableTorchCompleter     // Catch:{ all -> 0x0043 }
            r5.mEnableTorchCompleter = r2     // Catch:{ all -> 0x0043 }
            r2 = r6
        L_0x001b:
            boolean r6 = r5.mTargetTorchEnabled     // Catch:{ all -> 0x0043 }
            if (r6 == 0) goto L_0x0028
            r6 = 1
            r5.mTargetTorchEnabled = r3     // Catch:{ all -> 0x0043 }
            androidx.camera.camera2.internal.Camera2CameraControl r4 = r5.mCamera2CameraControl     // Catch:{ all -> 0x0043 }
            r4.enableTorchInternal(r3)     // Catch:{ all -> 0x0043 }
            goto L_0x0029
        L_0x0028:
            r6 = r3
        L_0x0029:
            monitor-exit(r1)     // Catch:{ all -> 0x0043 }
            if (r6 == 0) goto L_0x0035
            androidx.lifecycle.MutableLiveData<java.lang.Integer> r6 = r5.mTorchState     // Catch:{ all -> 0x0046 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0046 }
            r5.setLiveDataValue(r6, r1)     // Catch:{ all -> 0x0046 }
        L_0x0035:
            if (r2 == 0) goto L_0x0041
            androidx.camera.core.CameraControl$OperationCanceledException r6 = new androidx.camera.core.CameraControl$OperationCanceledException     // Catch:{ all -> 0x0046 }
            java.lang.String r1 = "Camera is not active."
            r6.<init>(r1)     // Catch:{ all -> 0x0046 }
            r2.setException(r6)     // Catch:{ all -> 0x0046 }
        L_0x0041:
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            return
        L_0x0043:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0043 }
            throw r6     // Catch:{ all -> 0x0046 }
        L_0x0046:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.TorchControl.setActive(boolean):void");
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> enableTorch(boolean z) {
        if (!this.mHasFlashUnit) {
            Log.d(TAG, "Unable to enableTorch due to there is no flash unit.");
            return Futures.immediateFailedFuture(new IllegalStateException("No flash unit"));
        }
        synchronized (this.mActiveLock) {
            if (!this.mIsActive) {
                ListenableFuture<Void> immediateFailedFuture = Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
                return immediateFailedFuture;
            }
            ListenableFuture<Void> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(z) {
                /* class androidx.camera.camera2.internal.$$Lambda$TorchControl$yfLA642SB9aJ7gO5KSM5aWHWKK4 */
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return TorchControl.this.lambda$enableTorch$0$TorchControl(this.f$1, completer);
                }
            });
            return future;
        }
    }

    public /* synthetic */ Object lambda$enableTorch$0$TorchControl(boolean z, CallbackToFutureAdapter.Completer completer) throws Exception {
        CallbackToFutureAdapter.Completer<Void> completer2;
        synchronized (this.mEnableTorchLock) {
            completer2 = this.mEnableTorchCompleter != null ? this.mEnableTorchCompleter : null;
            this.mEnableTorchCompleter = completer;
            this.mTargetTorchEnabled = z;
            this.mCamera2CameraControl.enableTorchInternal(z);
        }
        setLiveDataValue(this.mTorchState, Integer.valueOf(z ? 1 : 0));
        if (completer2 != null) {
            completer2.setException(new CameraControl.OperationCanceledException("There is a new enableTorch being set"));
        }
        return "enableTorch: " + z;
    }

    /* access modifiers changed from: package-private */
    public LiveData<Integer> getTorchState() {
        return this.mTorchState;
    }

    private <T> void setLiveDataValue(MutableLiveData<T> mutableLiveData, T t) {
        if (Threads.isMainThread()) {
            mutableLiveData.setValue(t);
        } else {
            mutableLiveData.postValue(t);
        }
    }
}

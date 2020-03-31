package androidx.camera.camera2.internal;

import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

final class CameraAvailabilityRegistry {
    private static final boolean DEBUG = false;
    private static final String TAG = "AvailabilityRegistry";
    private final LiveDataObservable<Integer> mAvailableCameras;
    private final Map<CameraInternal, CameraInternal.State> mCameraStates = new HashMap();
    private StringBuilder mDebugString = null;
    private final Executor mExecutor;
    private final Object mLock = new Object();
    final int mMaxAllowedOpenedCameras;

    CameraAvailabilityRegistry(int i, Executor executor) {
        this.mMaxAllowedOpenedCameras = i;
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        LiveDataObservable<Integer> liveDataObservable = new LiveDataObservable<>();
        this.mAvailableCameras = liveDataObservable;
        liveDataObservable.postValue(Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    public void registerCamera(final CameraInternal cameraInternal) {
        synchronized (this.mLock) {
            if (!this.mCameraStates.containsKey(cameraInternal)) {
                this.mCameraStates.put(cameraInternal, null);
                cameraInternal.getCameraState().addObserver(this.mExecutor, new Observable.Observer<CameraInternal.State>() {
                    /* class androidx.camera.camera2.internal.CameraAvailabilityRegistry.AnonymousClass1 */

                    public void onError(Throwable th) {
                    }

                    public void onNewData(CameraInternal.State state) {
                        if (state == CameraInternal.State.RELEASED) {
                            CameraAvailabilityRegistry.this.unregisterCamera(cameraInternal, this);
                        } else {
                            CameraAvailabilityRegistry.this.updateState(cameraInternal, state);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Observable<Integer> getAvailableCameraCount() {
        return this.mAvailableCameras;
    }

    /* access modifiers changed from: package-private */
    public void unregisterCamera(CameraInternal cameraInternal, Observable.Observer<CameraInternal.State> observer) {
        synchronized (this.mLock) {
            cameraInternal.getCameraState().removeObserver(observer);
            if (this.mCameraStates.remove(cameraInternal) != null) {
                int recalculateAvailableCameras = recalculateAvailableCameras();
                this.mAvailableCameras.postValue(Integer.valueOf(recalculateAvailableCameras));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateState(CameraInternal cameraInternal, CameraInternal.State state) {
        synchronized (this.mLock) {
            if (this.mCameraStates.containsKey(cameraInternal)) {
                if (this.mCameraStates.put(cameraInternal, state) != state) {
                    int recalculateAvailableCameras = recalculateAvailableCameras();
                    this.mAvailableCameras.postValue(Integer.valueOf(recalculateAvailableCameras));
                }
            }
        }
    }

    private int recalculateAvailableCameras() {
        int i = 0;
        for (Map.Entry next : this.mCameraStates.entrySet()) {
            if (!(next.getValue() == CameraInternal.State.CLOSED || next.getValue() == CameraInternal.State.OPENING || next.getValue() == CameraInternal.State.PENDING_OPEN)) {
                i++;
            }
        }
        return Math.max(this.mMaxAllowedOpenedCameras - i, 0);
    }
}

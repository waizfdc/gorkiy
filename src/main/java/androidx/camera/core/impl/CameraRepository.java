package androidx.camera.core.impl;

import android.util.Log;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.UseCaseGroup;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class CameraRepository implements UseCaseGroup.StateChangeCallback {
    private static final String TAG = "CameraRepository";
    private final Map<String, CameraInternal> mCameras = new HashMap();
    private final Object mCamerasLock = new Object();
    private CallbackToFutureAdapter.Completer<Void> mDeinitCompleter;
    private ListenableFuture<Void> mDeinitFuture;
    private final Set<CameraInternal> mReleasingCameras = new HashSet();

    public void init(CameraFactory cameraFactory) {
        synchronized (this.mCamerasLock) {
            try {
                for (String next : cameraFactory.getAvailableCameraIds()) {
                    Log.d(TAG, "Added camera: " + next);
                    this.mCameras.put(next, cameraFactory.getCamera(next));
                }
            } catch (Exception e) {
                throw new IllegalStateException("Unable to enumerate cameras", e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.common.util.concurrent.ListenableFuture<java.lang.Void> deinit() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mCamerasLock
            monitor-enter(r0)
            java.util.Map<java.lang.String, androidx.camera.core.impl.CameraInternal> r1 = r6.mCameras     // Catch:{ all -> 0x0061 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0061 }
            if (r1 == 0) goto L_0x0019
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r1 = r6.mDeinitFuture     // Catch:{ all -> 0x0061 }
            if (r1 != 0) goto L_0x0015
            r1 = 0
            com.google.common.util.concurrent.ListenableFuture r1 = androidx.camera.core.impl.utils.futures.Futures.immediateFuture(r1)     // Catch:{ all -> 0x0061 }
            goto L_0x0017
        L_0x0015:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r1 = r6.mDeinitFuture     // Catch:{ all -> 0x0061 }
        L_0x0017:
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            return r1
        L_0x0019:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r1 = r6.mDeinitFuture     // Catch:{ all -> 0x0061 }
            if (r1 != 0) goto L_0x0028
            androidx.camera.core.impl.-$$Lambda$CameraRepository$GfCuwjwqCywAr4DgCn1JSOYgBEg r1 = new androidx.camera.core.impl.-$$Lambda$CameraRepository$GfCuwjwqCywAr4DgCn1JSOYgBEg     // Catch:{ all -> 0x0061 }
            r1.<init>()     // Catch:{ all -> 0x0061 }
            com.google.common.util.concurrent.ListenableFuture r1 = androidx.concurrent.futures.CallbackToFutureAdapter.getFuture(r1)     // Catch:{ all -> 0x0061 }
            r6.mDeinitFuture = r1     // Catch:{ all -> 0x0061 }
        L_0x0028:
            java.util.Set<androidx.camera.core.impl.CameraInternal> r2 = r6.mReleasingCameras     // Catch:{ all -> 0x0061 }
            java.util.Map<java.lang.String, androidx.camera.core.impl.CameraInternal> r3 = r6.mCameras     // Catch:{ all -> 0x0061 }
            java.util.Collection r3 = r3.values()     // Catch:{ all -> 0x0061 }
            r2.addAll(r3)     // Catch:{ all -> 0x0061 }
            java.util.Map<java.lang.String, androidx.camera.core.impl.CameraInternal> r2 = r6.mCameras     // Catch:{ all -> 0x0061 }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x0061 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0061 }
        L_0x003d:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0061 }
            if (r3 == 0) goto L_0x005a
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0061 }
            androidx.camera.core.impl.CameraInternal r3 = (androidx.camera.core.impl.CameraInternal) r3     // Catch:{ all -> 0x0061 }
            com.google.common.util.concurrent.ListenableFuture r4 = r3.release()     // Catch:{ all -> 0x0061 }
            androidx.camera.core.impl.-$$Lambda$CameraRepository$vZy2hmnvCLGH5kuV_-iaqXOZ0ng r5 = new androidx.camera.core.impl.-$$Lambda$CameraRepository$vZy2hmnvCLGH5kuV_-iaqXOZ0ng     // Catch:{ all -> 0x0061 }
            r5.<init>(r3)     // Catch:{ all -> 0x0061 }
            java.util.concurrent.Executor r3 = androidx.camera.core.impl.utils.executor.CameraXExecutors.directExecutor()     // Catch:{ all -> 0x0061 }
            r4.addListener(r5, r3)     // Catch:{ all -> 0x0061 }
            goto L_0x003d
        L_0x005a:
            java.util.Map<java.lang.String, androidx.camera.core.impl.CameraInternal> r2 = r6.mCameras     // Catch:{ all -> 0x0061 }
            r2.clear()     // Catch:{ all -> 0x0061 }
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            return r1
        L_0x0061:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.CameraRepository.deinit():com.google.common.util.concurrent.ListenableFuture");
    }

    public /* synthetic */ Object lambda$deinit$0$CameraRepository(CallbackToFutureAdapter.Completer completer) throws Exception {
        Preconditions.checkState(Thread.holdsLock(this.mCamerasLock));
        this.mDeinitCompleter = completer;
        return "CameraRepository-deinit";
    }

    public /* synthetic */ void lambda$deinit$1$CameraRepository(CameraInternal cameraInternal) {
        synchronized (this.mCamerasLock) {
            this.mReleasingCameras.remove(cameraInternal);
            if (this.mReleasingCameras.isEmpty()) {
                Preconditions.checkNotNull(this.mDeinitCompleter);
                this.mDeinitCompleter.set(null);
                this.mDeinitCompleter = null;
                this.mDeinitFuture = null;
            }
        }
    }

    public CameraInternal getCamera(String str) {
        CameraInternal cameraInternal;
        synchronized (this.mCamerasLock) {
            cameraInternal = this.mCameras.get(str);
            if (cameraInternal == null) {
                throw new IllegalArgumentException("Invalid camera: " + str);
            }
        }
        return cameraInternal;
    }

    /* access modifiers changed from: package-private */
    public Set<String> getCameraIds() {
        HashSet hashSet;
        synchronized (this.mCamerasLock) {
            hashSet = new HashSet(this.mCameras.keySet());
        }
        return hashSet;
    }

    public void onGroupActive(UseCaseGroup useCaseGroup) {
        synchronized (this.mCamerasLock) {
            for (Map.Entry next : useCaseGroup.getCameraIdToUseCaseMap().entrySet()) {
                attachUseCasesToCamera(getCamera((String) next.getKey()), (Set) next.getValue());
            }
        }
    }

    private void attachUseCasesToCamera(CameraInternal cameraInternal, Set<UseCase> set) {
        cameraInternal.addOnlineUseCase(set);
    }

    public void onGroupInactive(UseCaseGroup useCaseGroup) {
        synchronized (this.mCamerasLock) {
            for (Map.Entry next : useCaseGroup.getCameraIdToUseCaseMap().entrySet()) {
                detachUseCasesFromCamera(getCamera((String) next.getKey()), (Set) next.getValue());
            }
        }
    }

    private void detachUseCasesFromCamera(CameraInternal cameraInternal, Set<UseCase> set) {
        cameraInternal.removeOnlineUseCase(set);
    }
}

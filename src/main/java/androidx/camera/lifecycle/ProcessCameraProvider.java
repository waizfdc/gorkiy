package androidx.camera.lifecycle;

import android.content.Context;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;

public final class ProcessCameraProvider implements LifecycleCameraProvider {
    /* access modifiers changed from: private */
    public static final ProcessCameraProvider sAppInstance = new ProcessCameraProvider();

    public static ListenableFuture<ProcessCameraProvider> getInstance(Context context) {
        Preconditions.checkNotNull(context);
        return Futures.transform(CameraX.getOrCreateInstance(context), $$Lambda$ProcessCameraProvider$TYjfluwv4_m1lcHTHHt4JLTu5vc.INSTANCE, CameraXExecutors.directExecutor());
    }

    public static void initializeInstance(Context context, CameraXConfig cameraXConfig) {
        Futures.addCallback(CameraX.initialize(context, cameraXConfig), new FutureCallback<Void>() {
            /* class androidx.camera.lifecycle.ProcessCameraProvider.AnonymousClass1 */

            public void onSuccess(Void voidR) {
            }

            public void onFailure(Throwable th) {
                throw new RuntimeException(th);
            }
        }, CameraXExecutors.directExecutor());
    }

    public ListenableFuture<Void> shutdown() {
        return CameraX.shutdown();
    }

    public Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCase... useCaseArr) {
        return CameraX.bindToLifecycle(lifecycleOwner, cameraSelector, useCaseArr);
    }

    public boolean isBound(UseCase useCase) {
        return CameraX.isBound(useCase);
    }

    public void unbind(UseCase... useCaseArr) {
        CameraX.unbind(useCaseArr);
    }

    public void unbindAll() {
        CameraX.unbindAll();
    }

    public boolean hasCamera(CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        return CameraX.hasCamera(cameraSelector);
    }

    private ProcessCameraProvider() {
    }
}

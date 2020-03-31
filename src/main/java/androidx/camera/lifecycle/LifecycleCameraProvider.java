package androidx.camera.lifecycle;

import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;

interface LifecycleCameraProvider {
    boolean hasCamera(CameraSelector cameraSelector) throws CameraInfoUnavailableException;

    boolean isBound(UseCase useCase);

    void unbind(UseCase... useCaseArr);

    void unbindAll();
}

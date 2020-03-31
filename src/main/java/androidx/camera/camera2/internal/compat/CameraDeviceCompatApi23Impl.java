package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import androidx.core.util.Preconditions;
import java.util.List;

class CameraDeviceCompatApi23Impl extends CameraDeviceCompatBaseImpl {
    CameraDeviceCompatApi23Impl() {
    }

    public void createCaptureSession(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessException {
        checkPreconditions(cameraDevice, sessionConfigurationCompat);
        CameraCaptureSessionCompat.StateCallbackExecutorWrapper stateCallbackExecutorWrapper = new CameraCaptureSessionCompat.StateCallbackExecutorWrapper(sessionConfigurationCompat.getExecutor(), sessionConfigurationCompat.getStateCallback());
        List<Surface> unpackSurfaces = unpackSurfaces(sessionConfigurationCompat.getOutputConfigurations());
        Handler instance = MainThreadAsyncHandler.getInstance();
        InputConfigurationCompat inputConfiguration = sessionConfigurationCompat.getInputConfiguration();
        if (inputConfiguration != null) {
            InputConfiguration inputConfiguration2 = (InputConfiguration) inputConfiguration.unwrap();
            Preconditions.checkNotNull(inputConfiguration2);
            cameraDevice.createReprocessableCaptureSession(inputConfiguration2, unpackSurfaces, stateCallbackExecutorWrapper, instance);
        } else if (sessionConfigurationCompat.getSessionType() == 1) {
            cameraDevice.createConstrainedHighSpeedCaptureSession(unpackSurfaces, stateCallbackExecutorWrapper, instance);
        } else {
            createBaseCaptureSession(cameraDevice, unpackSurfaces, stateCallbackExecutorWrapper, instance);
        }
    }
}

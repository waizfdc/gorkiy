package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.concurrent.Executor;

class CameraCaptureSessionCompatApi28Impl extends CameraCaptureSessionCompatBaseImpl {
    CameraCaptureSessionCompatApi28Impl() {
    }

    public int captureBurstRequests(CameraCaptureSession cameraCaptureSession, List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(cameraCaptureSession);
        return cameraCaptureSession.captureBurstRequests(list, executor, captureCallback);
    }

    public int captureSingleRequest(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(cameraCaptureSession);
        return cameraCaptureSession.captureSingleRequest(captureRequest, executor, captureCallback);
    }

    public int setRepeatingBurstRequests(CameraCaptureSession cameraCaptureSession, List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(cameraCaptureSession);
        return cameraCaptureSession.setRepeatingBurstRequests(list, executor, captureCallback);
    }

    public int setSingleRepeatingRequest(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(cameraCaptureSession);
        return cameraCaptureSession.setSingleRepeatingRequest(captureRequest, executor, captureCallback);
    }
}

package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.concurrent.Executor;

class CameraCaptureSessionCompatBaseImpl implements CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl {
    CameraCaptureSessionCompatBaseImpl() {
    }

    public int captureBurstRequests(CameraCaptureSession cameraCaptureSession, List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(cameraCaptureSession);
        return cameraCaptureSession.captureBurst(list, new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(executor, captureCallback), MainThreadAsyncHandler.getInstance());
    }

    public int captureSingleRequest(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(cameraCaptureSession);
        return cameraCaptureSession.capture(captureRequest, new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(executor, captureCallback), MainThreadAsyncHandler.getInstance());
    }

    public int setRepeatingBurstRequests(CameraCaptureSession cameraCaptureSession, List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(cameraCaptureSession);
        return cameraCaptureSession.setRepeatingBurst(list, new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(executor, captureCallback), MainThreadAsyncHandler.getInstance());
    }

    public int setSingleRepeatingRequest(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(cameraCaptureSession);
        return cameraCaptureSession.setRepeatingRequest(captureRequest, new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(executor, captureCallback), MainThreadAsyncHandler.getInstance());
    }
}

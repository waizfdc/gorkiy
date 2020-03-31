package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.CameraInfoUnavailableException;
import java.util.Set;

public interface CameraFactory {

    public interface Provider {
        CameraFactory newInstance(Context context);
    }

    String cameraIdForLensFacing(int i) throws CameraInfoUnavailableException;

    Set<String> getAvailableCameraIds() throws CameraInfoUnavailableException;

    CameraInternal getCamera(String str) throws CameraInfoUnavailableException;

    LensFacingCameraIdFilter getLensFacingCameraIdFilter(int i);
}

package androidx.camera.extensions;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.util.Log;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import java.util.Set;

class CameraUtil {
    private static final String TAG = "CameraUtil";

    static String getCameraIdUnchecked(CameraSelector cameraSelector) {
        try {
            return CameraX.getCameraWithCameraSelector(cameraSelector);
        } catch (IllegalArgumentException unused) {
            Log.w(TAG, "Unable to get camera id for the camera selector.");
            return null;
        }
    }

    static Set<String> getCameraIdSetWithLensFacing(Integer num) throws CameraInfoUnavailableException {
        return CameraX.getCameraFactory().getLensFacingCameraIdFilter(num.intValue()).filter(CameraX.getCameraFactory().getAvailableCameraIds());
    }

    static CameraCharacteristics getCameraCharacteristics(String str) {
        try {
            return ((CameraManager) CameraX.getContext().getSystemService("camera")).getCameraCharacteristics(str);
        } catch (CameraAccessException e) {
            throw new IllegalArgumentException("Unable to retrieve info for camera with id " + str + ".", e);
        }
    }

    private CameraUtil() {
    }
}

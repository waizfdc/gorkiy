package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.util.Log;
import androidx.camera.core.impl.LensFacingCameraIdFilter;
import java.util.LinkedHashSet;
import java.util.Set;

final class Camera2LensFacingCameraIdFilter extends LensFacingCameraIdFilter {
    private static final String TAG = "Camera2LensFacingCIF";
    private CameraManager mCameraManager;

    Camera2LensFacingCameraIdFilter(int i, CameraManager cameraManager) {
        super(i);
        this.mCameraManager = cameraManager;
    }

    public Set<String> filter(Set<String> set) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String next : set) {
            Integer num = null;
            try {
                num = (Integer) this.mCameraManager.getCameraCharacteristics(next).get(CameraCharacteristics.LENS_FACING);
            } catch (CameraAccessException e) {
                Log.e(TAG, "Unable to retrieve info for camera with id " + next + ".", e);
            }
            if (num != null && num.equals(cameraXLensFacingToCamera2LensFacing(getLensFacing()))) {
                linkedHashSet.add(next);
            }
        }
        return linkedHashSet;
    }

    private Integer cameraXLensFacingToCamera2LensFacing(int i) {
        if (i == 0) {
            return 0;
        }
        if (i != 1) {
            return -1;
        }
        return 1;
    }
}

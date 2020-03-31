package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Log;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;

public final class Camera2CameraInfoImpl implements CameraInfoInternal {
    private static final String TAG = "Camera2CameraInfo";
    private final CameraCharacteristics mCameraCharacteristics;
    private final String mCameraId;
    private final TorchControl mTorchControl;
    private final ZoomControl mZoomControl;

    Camera2CameraInfoImpl(String str, CameraCharacteristics cameraCharacteristics, ZoomControl zoomControl, TorchControl torchControl) {
        Preconditions.checkNotNull(cameraCharacteristics, "Camera characteristics map is missing");
        this.mCameraId = (String) Preconditions.checkNotNull(str);
        this.mCameraCharacteristics = cameraCharacteristics;
        this.mZoomControl = zoomControl;
        this.mTorchControl = torchControl;
        logDeviceInfo();
    }

    public String getCameraId() {
        return this.mCameraId;
    }

    public Integer getLensFacing() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
        Preconditions.checkNotNull(num);
        int intValue = num.intValue();
        if (intValue == 0) {
            return 0;
        }
        if (intValue != 1) {
            return null;
        }
        return 1;
    }

    public int getSensorRotationDegrees(int i) {
        Integer valueOf = Integer.valueOf(getSensorOrientation());
        int surfaceRotationToDegrees = CameraOrientationUtil.surfaceRotationToDegrees(i);
        Integer lensFacing = getLensFacing();
        boolean z = true;
        if (lensFacing == null || 1 != lensFacing.intValue()) {
            z = false;
        }
        return CameraOrientationUtil.getRelativeImageRotation(surfaceRotationToDegrees, valueOf.intValue(), z);
    }

    /* access modifiers changed from: package-private */
    public int getSensorOrientation() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
        Preconditions.checkNotNull(num);
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    public int getSupportedHardwareLevel() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        Preconditions.checkNotNull(num);
        return num.intValue();
    }

    public int getSensorRotationDegrees() {
        return getSensorRotationDegrees(0);
    }

    private void logDeviceInfo() {
        logDeviceLevel();
    }

    private void logDeviceLevel() {
        String str;
        int supportedHardwareLevel = getSupportedHardwareLevel();
        if (supportedHardwareLevel == 0) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED";
        } else if (supportedHardwareLevel == 1) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_FULL";
        } else if (supportedHardwareLevel == 2) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY";
        } else if (supportedHardwareLevel == 3) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_3";
        } else if (supportedHardwareLevel != 4) {
            str = "Unknown value: " + supportedHardwareLevel;
        } else {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL";
        }
        Log.i(TAG, "Device Level: " + str);
    }

    public boolean hasFlashUnit() {
        Boolean bool = (Boolean) this.mCameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        Preconditions.checkNotNull(bool);
        return bool.booleanValue();
    }

    public LiveData<Integer> getTorchState() {
        return this.mTorchControl.getTorchState();
    }

    public LiveData<ZoomState> getZoomState() {
        return this.mZoomControl.getZoomState();
    }

    public String getImplementationType() {
        return getSupportedHardwareLevel() == 2 ? CameraInfo.IMPLEMENTATION_TYPE_CAMERA2_LEGACY : CameraInfo.IMPLEMENTATION_TYPE_CAMERA2;
    }
}

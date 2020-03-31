package androidx.camera.core.impl.utils;

public final class CameraOrientationUtil {
    private static final boolean DEBUG = false;
    private static final String TAG = "CameraOrientationUtil";

    private CameraOrientationUtil() {
    }

    public static int getRelativeImageRotation(int i, int i2, boolean z) {
        if (z) {
            return ((i2 - i) + 360) % 360;
        }
        return (i2 + i) % 360;
    }

    public static int surfaceRotationToDegrees(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 90;
        }
        if (i == 2) {
            return 180;
        }
        if (i == 3) {
            return 270;
        }
        throw new IllegalArgumentException("Unsupported surface rotation: " + i);
    }
}

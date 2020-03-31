package androidx.camera.view.preview.transform;

import android.view.Display;
import android.view.View;

final class RotationTransform {
    private RotationTransform() {
    }

    static float getRotationDegrees(View view) {
        Display display = view.getDisplay();
        if (display == null) {
            return 0.0f;
        }
        return (float) SurfaceRotation.rotationDegreesFromSurfaceRotation(display.getRotation());
    }
}

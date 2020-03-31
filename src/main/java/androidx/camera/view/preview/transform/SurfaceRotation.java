package androidx.camera.view.preview.transform;

final class SurfaceRotation {
    private SurfaceRotation() {
    }

    static int rotationDegreesFromSurfaceRotation(int i) {
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
        throw new UnsupportedOperationException("Unsupported surface rotation constant: " + i);
    }
}

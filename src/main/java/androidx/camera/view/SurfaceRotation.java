package androidx.camera.view;

final class SurfaceRotation {
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

    private SurfaceRotation() {
    }
}

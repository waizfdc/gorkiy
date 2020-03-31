package androidx.camera.core.impl;

import androidx.camera.core.CameraX;
import java.util.Set;

public class LensFacingCameraIdFilter implements CameraIdFilter {
    private int mLensFacing;

    public LensFacingCameraIdFilter(int i) {
        this.mLensFacing = i;
    }

    public Set<String> filter(Set<String> set) {
        return CameraX.getCameraFactory().getLensFacingCameraIdFilter(this.mLensFacing).filter(set);
    }

    public int getLensFacing() {
        return this.mLensFacing;
    }
}

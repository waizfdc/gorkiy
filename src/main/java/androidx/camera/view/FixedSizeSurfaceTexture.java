package androidx.camera.view;

import android.graphics.SurfaceTexture;
import android.util.Size;

final class FixedSizeSurfaceTexture extends SurfaceTexture {
    public void setDefaultBufferSize(int i, int i2) {
    }

    FixedSizeSurfaceTexture(int i, Size size) {
        super(i);
        super.setDefaultBufferSize(size.getWidth(), size.getHeight());
    }

    FixedSizeSurfaceTexture(int i, boolean z, Size size) {
        super(i, z);
        super.setDefaultBufferSize(size.getWidth(), size.getHeight());
    }

    FixedSizeSurfaceTexture(boolean z, Size size) {
        super(z);
        super.setDefaultBufferSize(size.getWidth(), size.getHeight());
    }
}

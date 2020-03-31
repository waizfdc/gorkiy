package androidx.camera.core.impl;

import android.util.Size;

public abstract class SurfaceSizeDefinition {
    public abstract Size getAnalysisSize();

    public abstract Size getPreviewSize();

    public abstract Size getRecordSize();

    SurfaceSizeDefinition() {
    }

    public static SurfaceSizeDefinition create(Size size, Size size2, Size size3) {
        return new AutoValue_SurfaceSizeDefinition(size, size2, size3);
    }
}

package androidx.camera.core;

abstract class ImmutableImageInfo implements ImageInfo {
    public abstract int getRotationDegrees();

    public abstract Object getTag();

    public abstract long getTimestamp();

    ImmutableImageInfo() {
    }

    public static ImageInfo create(Object obj, long j, int i) {
        return new AutoValue_ImmutableImageInfo(obj, j, i);
    }
}

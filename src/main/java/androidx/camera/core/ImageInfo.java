package androidx.camera.core;

public interface ImageInfo {
    int getRotationDegrees();

    Object getTag();

    long getTimestamp();
}

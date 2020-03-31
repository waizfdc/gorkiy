package androidx.camera.core;

final class SettableImageProxy extends ForwardingImageProxy {
    private final ImageInfo mImageInfo;

    SettableImageProxy(ImageProxy imageProxy, ImageInfo imageInfo) {
        super(imageProxy);
        this.mImageInfo = imageInfo;
    }

    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }
}

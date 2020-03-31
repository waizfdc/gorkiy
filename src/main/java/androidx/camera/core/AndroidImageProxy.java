package androidx.camera.core;

import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.ImageProxy;
import java.nio.ByteBuffer;

final class AndroidImageProxy implements ImageProxy {
    private final Image mImage;
    private final ImageInfo mImageInfo;
    private final PlaneProxy[] mPlanes;

    AndroidImageProxy(Image image) {
        this.mImage = image;
        Image.Plane[] planes = image.getPlanes();
        if (planes != null) {
            this.mPlanes = new PlaneProxy[planes.length];
            for (int i = 0; i < planes.length; i++) {
                this.mPlanes[i] = new PlaneProxy(planes[i]);
            }
        } else {
            this.mPlanes = new PlaneProxy[0];
        }
        this.mImageInfo = ImmutableImageInfo.create(null, image.getTimestamp(), 0);
    }

    public synchronized void close() {
        this.mImage.close();
    }

    public synchronized Rect getCropRect() {
        return this.mImage.getCropRect();
    }

    public synchronized void setCropRect(Rect rect) {
        this.mImage.setCropRect(rect);
    }

    public synchronized int getFormat() {
        return this.mImage.getFormat();
    }

    public synchronized int getHeight() {
        return this.mImage.getHeight();
    }

    public synchronized int getWidth() {
        return this.mImage.getWidth();
    }

    public synchronized ImageProxy.PlaneProxy[] getPlanes() {
        return this.mPlanes;
    }

    private static final class PlaneProxy implements ImageProxy.PlaneProxy {
        private final Image.Plane mPlane;

        PlaneProxy(Image.Plane plane) {
            this.mPlane = plane;
        }

        public synchronized int getRowStride() {
            return this.mPlane.getRowStride();
        }

        public synchronized int getPixelStride() {
            return this.mPlane.getPixelStride();
        }

        public synchronized ByteBuffer getBuffer() {
            return this.mPlane.getBuffer();
        }
    }

    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    public synchronized Image getImage() {
        return this.mImage;
    }
}

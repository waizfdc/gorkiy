package androidx.camera.core;

import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.ImageProxy;
import java.util.HashSet;
import java.util.Set;

abstract class ForwardingImageProxy implements ImageProxy {
    protected final ImageProxy mImage;
    private final Set<OnImageCloseListener> mOnImageCloseListeners = new HashSet();

    interface OnImageCloseListener {
        void onImageClose(ImageProxy imageProxy);
    }

    protected ForwardingImageProxy(ImageProxy imageProxy) {
        this.mImage = imageProxy;
    }

    public void close() {
        this.mImage.close();
        notifyOnImageCloseListeners();
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
        return this.mImage.getPlanes();
    }

    public synchronized ImageInfo getImageInfo() {
        return this.mImage.getImageInfo();
    }

    public synchronized Image getImage() {
        return this.mImage.getImage();
    }

    /* access modifiers changed from: package-private */
    public synchronized void addOnImageCloseListener(OnImageCloseListener onImageCloseListener) {
        this.mOnImageCloseListeners.add(onImageCloseListener);
    }

    /* access modifiers changed from: protected */
    public void notifyOnImageCloseListeners() {
        HashSet<OnImageCloseListener> hashSet;
        synchronized (this) {
            hashSet = new HashSet<>(this.mOnImageCloseListeners);
        }
        for (OnImageCloseListener onImageClose : hashSet) {
            onImageClose.onImageClose(this);
        }
    }
}

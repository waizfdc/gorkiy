package androidx.camera.core;

import android.os.Handler;
import android.view.Surface;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

final class QueuedImageReaderProxy implements ImageReaderProxy, ForwardingImageProxy.OnImageCloseListener {
    private final Set<ImageProxy> mAcquiredImages = new HashSet();
    private boolean mClosed;
    private int mCurrentPosition;
    private final int mFormat;
    private final int mHeight;
    private final List<ImageProxy> mImages;
    private final int mMaxImages;
    private Executor mOnImageAvailableExecutor;
    private ImageReaderProxy.OnImageAvailableListener mOnImageAvailableListener;
    private final Set<OnReaderCloseListener> mOnReaderCloseListeners = new HashSet();
    private final Surface mSurface;
    private final int mWidth;

    interface OnReaderCloseListener {
        void onReaderClose(ImageReaderProxy imageReaderProxy);
    }

    QueuedImageReaderProxy(int i, int i2, int i3, int i4, Surface surface) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mFormat = i3;
        this.mMaxImages = i4;
        this.mSurface = surface;
        this.mImages = new ArrayList(i4);
        this.mCurrentPosition = 0;
        this.mClosed = false;
    }

    public synchronized ImageProxy acquireLatestImage() {
        throwExceptionIfClosed();
        if (this.mImages.isEmpty()) {
            return null;
        }
        if (this.mCurrentPosition < this.mImages.size()) {
            ArrayList<ImageProxy> arrayList = new ArrayList<>();
            for (int i = 0; i < this.mImages.size() - 1; i++) {
                if (!this.mAcquiredImages.contains(this.mImages.get(i))) {
                    arrayList.add(this.mImages.get(i));
                }
            }
            for (ImageProxy close : arrayList) {
                close.close();
            }
            int size = this.mImages.size() - 1;
            this.mCurrentPosition = size;
            List<ImageProxy> list = this.mImages;
            this.mCurrentPosition = size + 1;
            ImageProxy imageProxy = list.get(size);
            this.mAcquiredImages.add(imageProxy);
            return imageProxy;
        }
        throw new IllegalStateException("Max images have already been acquired without close.");
    }

    public synchronized ImageProxy acquireNextImage() {
        throwExceptionIfClosed();
        if (this.mImages.isEmpty()) {
            return null;
        }
        if (this.mCurrentPosition < this.mImages.size()) {
            List<ImageProxy> list = this.mImages;
            int i = this.mCurrentPosition;
            this.mCurrentPosition = i + 1;
            ImageProxy imageProxy = list.get(i);
            this.mAcquiredImages.add(imageProxy);
            return imageProxy;
        }
        throw new IllegalStateException("Max images have already been acquired without close.");
    }

    /* access modifiers changed from: package-private */
    public synchronized void enqueueImage(ForwardingImageProxy forwardingImageProxy) {
        throwExceptionIfClosed();
        if (this.mImages.size() < this.mMaxImages) {
            this.mImages.add(forwardingImageProxy);
            forwardingImageProxy.addOnImageCloseListener(this);
            if (!(this.mOnImageAvailableListener == null || this.mOnImageAvailableExecutor == null)) {
                final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener = this.mOnImageAvailableListener;
                this.mOnImageAvailableExecutor.execute(new Runnable() {
                    /* class androidx.camera.core.QueuedImageReaderProxy.AnonymousClass1 */

                    public void run() {
                        if (!QueuedImageReaderProxy.this.isClosed()) {
                            onImageAvailableListener.onImageAvailable(QueuedImageReaderProxy.this);
                        }
                    }
                });
            }
        } else {
            forwardingImageProxy.close();
        }
    }

    public synchronized void close() {
        if (!this.mClosed) {
            this.mOnImageAvailableExecutor = null;
            this.mOnImageAvailableListener = null;
            for (ImageProxy close : new ArrayList(this.mImages)) {
                close.close();
            }
            this.mImages.clear();
            this.mClosed = true;
            notifyOnReaderCloseListeners();
        }
    }

    public int getHeight() {
        throwExceptionIfClosed();
        return this.mHeight;
    }

    public int getWidth() {
        throwExceptionIfClosed();
        return this.mWidth;
    }

    public int getImageFormat() {
        throwExceptionIfClosed();
        return this.mFormat;
    }

    public int getMaxImages() {
        throwExceptionIfClosed();
        return this.mMaxImages;
    }

    public synchronized Surface getSurface() {
        throwExceptionIfClosed();
        return this.mSurface;
    }

    public synchronized void setOnImageAvailableListener(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, Handler handler) {
        setOnImageAvailableListener(onImageAvailableListener, handler == null ? null : CameraXExecutors.newHandlerExecutor(handler));
    }

    public synchronized void setOnImageAvailableListener(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, Executor executor) {
        throwExceptionIfClosed();
        this.mOnImageAvailableListener = onImageAvailableListener;
        this.mOnImageAvailableExecutor = executor;
    }

    public synchronized void onImageClose(ImageProxy imageProxy) {
        int indexOf = this.mImages.indexOf(imageProxy);
        if (indexOf >= 0) {
            this.mImages.remove(indexOf);
            if (indexOf <= this.mCurrentPosition) {
                this.mCurrentPosition--;
            }
        }
        this.mAcquiredImages.remove(imageProxy);
    }

    /* access modifiers changed from: package-private */
    public synchronized int getCurrentImages() {
        throwExceptionIfClosed();
        return this.mImages.size();
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean isClosed() {
        return this.mClosed;
    }

    /* access modifiers changed from: package-private */
    public synchronized void addOnReaderCloseListener(OnReaderCloseListener onReaderCloseListener) {
        this.mOnReaderCloseListeners.add(onReaderCloseListener);
    }

    private synchronized void throwExceptionIfClosed() {
        if (this.mClosed) {
            throw new IllegalStateException("This reader is already closed.");
        }
    }

    private synchronized void notifyOnReaderCloseListeners() {
        for (OnReaderCloseListener onReaderClose : this.mOnReaderCloseListeners) {
            onReaderClose.onReaderClose(this);
        }
    }
}

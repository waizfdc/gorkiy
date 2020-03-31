package androidx.camera.core;

final class ReferenceCountedImageProxy extends ForwardingImageProxy {
    private int mReferenceCount = 1;

    ReferenceCountedImageProxy(ImageProxy imageProxy) {
        super(imageProxy);
    }

    /* access modifiers changed from: package-private */
    public synchronized ImageProxy fork() {
        if (this.mReferenceCount <= 0) {
            return null;
        }
        this.mReferenceCount++;
        return new SingleCloseImageProxy(this);
    }

    public synchronized void close() {
        if (this.mReferenceCount > 0) {
            int i = this.mReferenceCount - 1;
            this.mReferenceCount = i;
            if (i <= 0) {
                super.close();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized int getReferenceCount() {
        return this.mReferenceCount;
    }
}

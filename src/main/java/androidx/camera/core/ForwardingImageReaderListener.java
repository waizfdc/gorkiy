package androidx.camera.core;

import androidx.camera.core.ImageProxyDownsampler;
import androidx.camera.core.impl.ImageReaderProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class ForwardingImageReaderListener implements ImageReaderProxy.OnImageAvailableListener {
    private final List<QueuedImageReaderProxy> mImageReaders;

    ForwardingImageReaderListener(List<QueuedImageReaderProxy> list) {
        this.mImageReaders = Collections.unmodifiableList(new ArrayList(list));
    }

    public synchronized void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        ImageProxy acquireNextImage = imageReaderProxy.acquireNextImage();
        if (acquireNextImage != null) {
            ReferenceCountedImageProxy referenceCountedImageProxy = new ReferenceCountedImageProxy(acquireNextImage);
            for (QueuedImageReaderProxy next : this.mImageReaders) {
                synchronized (next) {
                    if (!next.isClosed()) {
                        next.enqueueImage(ImageProxyDownsampler.downsample(referenceCountedImageProxy.fork(), next.getWidth(), next.getHeight(), ImageProxyDownsampler.DownsamplingMethod.AVERAGING));
                    }
                }
            }
            referenceCountedImageProxy.close();
        }
    }
}

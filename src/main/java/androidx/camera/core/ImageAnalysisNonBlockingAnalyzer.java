package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

final class ImageAnalysisNonBlockingAnalyzer extends ImageAnalysisAbstractAnalyzer {
    private static final String TAG = "NonBlockingCallback";
    final Executor mBackgroundExecutor;
    private ImageProxy mCachedImage;
    private final AtomicReference<CacheAnalyzingImageProxy> mPostedImage = new AtomicReference<>();
    private final AtomicLong mPostedImageTimestamp = new AtomicLong();

    ImageAnalysisNonBlockingAnalyzer(Executor executor) {
        this.mBackgroundExecutor = executor;
        open();
    }

    public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
        if (acquireLatestImage != null) {
            analyze(acquireLatestImage);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void open() {
        super.open();
        this.mCachedImage = null;
        this.mPostedImageTimestamp.set(-1);
        this.mPostedImage.set(null);
    }

    /* access modifiers changed from: package-private */
    public synchronized void close() {
        super.close();
        if (this.mCachedImage != null) {
            this.mCachedImage.close();
            this.mCachedImage = null;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void analyzeCachedImage() {
        if (this.mCachedImage != null) {
            ImageProxy imageProxy = this.mCachedImage;
            this.mCachedImage = null;
            analyze(imageProxy);
        }
    }

    private synchronized void analyze(final ImageProxy imageProxy) {
        if (isClosed()) {
            imageProxy.close();
            return;
        }
        CacheAnalyzingImageProxy cacheAnalyzingImageProxy = this.mPostedImage.get();
        if (cacheAnalyzingImageProxy == null || imageProxy.getImageInfo().getTimestamp() > this.mPostedImageTimestamp.get()) {
            if (cacheAnalyzingImageProxy != null) {
                if (!cacheAnalyzingImageProxy.isClosed()) {
                    if (this.mCachedImage != null) {
                        this.mCachedImage.close();
                    }
                    this.mCachedImage = imageProxy;
                    return;
                }
            }
            CacheAnalyzingImageProxy cacheAnalyzingImageProxy2 = new CacheAnalyzingImageProxy(imageProxy, this);
            this.mPostedImage.set(cacheAnalyzingImageProxy2);
            this.mPostedImageTimestamp.set(cacheAnalyzingImageProxy2.getImageInfo().getTimestamp());
            Futures.addCallback(analyzeImage(cacheAnalyzingImageProxy2), new FutureCallback<Void>() {
                /* class androidx.camera.core.ImageAnalysisNonBlockingAnalyzer.AnonymousClass1 */

                public void onSuccess(Void voidR) {
                }

                public void onFailure(Throwable th) {
                    imageProxy.close();
                }
            }, CameraXExecutors.directExecutor());
            return;
        }
        imageProxy.close();
    }

    static class CacheAnalyzingImageProxy extends ForwardingImageProxy {
        private boolean mClosed = false;
        WeakReference<ImageAnalysisNonBlockingAnalyzer> mNonBlockingAnalyzerWeakReference;

        CacheAnalyzingImageProxy(ImageProxy imageProxy, ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer) {
            super(imageProxy);
            this.mNonBlockingAnalyzerWeakReference = new WeakReference<>(imageAnalysisNonBlockingAnalyzer);
            addOnImageCloseListener(new ForwardingImageProxy.OnImageCloseListener() {
                /* class androidx.camera.core.$$Lambda$ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy$Pq3gquMkypA8mh_f3dMKr3oV0M8 */

                public final void onImageClose(ImageProxy imageProxy) {
                    ImageAnalysisNonBlockingAnalyzer.CacheAnalyzingImageProxy.this.lambda$new$0$ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy(imageProxy);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy(ImageProxy imageProxy) {
            this.mClosed = true;
            ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer = this.mNonBlockingAnalyzerWeakReference.get();
            if (imageAnalysisNonBlockingAnalyzer != null) {
                Executor executor = imageAnalysisNonBlockingAnalyzer.mBackgroundExecutor;
                imageAnalysisNonBlockingAnalyzer.getClass();
                executor.execute(new Runnable() {
                    /* class androidx.camera.core.$$Lambda$XqijcvI3c7o9krbxaHVHifcwgaY */

                    public final void run() {
                        ImageAnalysisNonBlockingAnalyzer.this.analyzeCachedImage();
                    }
                });
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isClosed() {
            return this.mClosed;
        }
    }
}

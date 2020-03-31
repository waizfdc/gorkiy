package androidx.camera.core;

import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;

final class ImageAnalysisBlockingAnalyzer extends ImageAnalysisAbstractAnalyzer {
    ImageAnalysisBlockingAnalyzer() {
    }

    public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        final ImageProxy acquireNextImage = imageReaderProxy.acquireNextImage();
        if (acquireNextImage != null) {
            Futures.addCallback(analyzeImage(acquireNextImage), new FutureCallback<Void>() {
                /* class androidx.camera.core.ImageAnalysisBlockingAnalyzer.AnonymousClass1 */

                public void onSuccess(Void voidR) {
                }

                public void onFailure(Throwable th) {
                    acquireNextImage.close();
                }
            }, CameraXExecutors.directExecutor());
        }
    }
}

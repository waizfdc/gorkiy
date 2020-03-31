package androidx.camera.core;

import android.media.ImageReader;
import android.os.Handler;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

class ProcessingImageReader implements ImageReaderProxy {
    private static final String TAG = "ProcessingImageReader";
    private final List<Integer> mCaptureIdList = new ArrayList();
    CaptureProcessor mCaptureProcessor;
    private FutureCallback<List<ImageProxy>> mCaptureStageReadyCallback = new FutureCallback<List<ImageProxy>>() {
        /* class androidx.camera.core.ProcessingImageReader.AnonymousClass3 */

        public void onFailure(Throwable th) {
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            onSuccess((List<ImageProxy>) ((List) obj));
        }

        public void onSuccess(List<ImageProxy> list) {
            ProcessingImageReader.this.mCaptureProcessor.process(ProcessingImageReader.this.mSettableImageProxyBundle);
        }
    };
    private boolean mClosed = false;
    Executor mExecutor;
    private ImageReaderProxy.OnImageAvailableListener mImageProcessedListener = new ImageReaderProxy.OnImageAvailableListener() {
        /* class androidx.camera.core.ProcessingImageReader.AnonymousClass2 */

        public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
            if (ProcessingImageReader.this.mExecutor != null) {
                ProcessingImageReader.this.mExecutor.execute(new Runnable() {
                    /* class androidx.camera.core.ProcessingImageReader.AnonymousClass2.AnonymousClass1 */

                    public void run() {
                        ProcessingImageReader.this.mListener.onImageAvailable(ProcessingImageReader.this);
                    }
                });
            } else {
                ProcessingImageReader.this.mListener.onImageAvailable(ProcessingImageReader.this);
            }
            ProcessingImageReader.this.mSettableImageProxyBundle.reset();
            ProcessingImageReader.this.setupSettableImageProxyBundleCallbacks();
        }
    };
    private final ImageReaderProxy mInputImageReader;
    ImageReaderProxy.OnImageAvailableListener mListener;
    private final Object mLock = new Object();
    private final ImageReaderProxy mOutputImageReader;
    SettableImageProxyBundle mSettableImageProxyBundle = null;
    private ImageReaderProxy.OnImageAvailableListener mTransformedListener = new ImageReaderProxy.OnImageAvailableListener() {
        /* class androidx.camera.core.ProcessingImageReader.AnonymousClass1 */

        public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
            ProcessingImageReader.this.imageIncoming(imageReaderProxy);
        }
    };

    ProcessingImageReader(int i, int i2, int i3, int i4, Handler handler, CaptureBundle captureBundle, CaptureProcessor captureProcessor) {
        this.mInputImageReader = new MetadataImageReader(i, i2, i3, i4, handler);
        this.mOutputImageReader = new AndroidImageReaderProxy(ImageReader.newInstance(i, i2, i3, i4));
        init(CameraXExecutors.newHandlerExecutor(handler), captureBundle, captureProcessor);
    }

    ProcessingImageReader(ImageReaderProxy imageReaderProxy, Handler handler, CaptureBundle captureBundle, CaptureProcessor captureProcessor) {
        if (imageReaderProxy.getMaxImages() >= captureBundle.getCaptureStages().size()) {
            this.mInputImageReader = imageReaderProxy;
            this.mOutputImageReader = new AndroidImageReaderProxy(ImageReader.newInstance(imageReaderProxy.getWidth(), imageReaderProxy.getHeight(), imageReaderProxy.getImageFormat(), imageReaderProxy.getMaxImages()));
            init(CameraXExecutors.newHandlerExecutor(handler), captureBundle, captureProcessor);
            return;
        }
        throw new IllegalArgumentException("MetadataImageReader is smaller than CaptureBundle.");
    }

    private void init(Executor executor, CaptureBundle captureBundle, CaptureProcessor captureProcessor) {
        this.mExecutor = executor;
        this.mInputImageReader.setOnImageAvailableListener(this.mTransformedListener, executor);
        this.mOutputImageReader.setOnImageAvailableListener(this.mImageProcessedListener, executor);
        this.mCaptureProcessor = captureProcessor;
        captureProcessor.onOutputSurface(this.mOutputImageReader.getSurface(), getImageFormat());
        this.mCaptureProcessor.onResolutionUpdate(new Size(this.mInputImageReader.getWidth(), this.mInputImageReader.getHeight()));
        setCaptureBundle(captureBundle);
    }

    public ImageProxy acquireLatestImage() {
        ImageProxy acquireLatestImage;
        synchronized (this.mLock) {
            acquireLatestImage = this.mOutputImageReader.acquireLatestImage();
        }
        return acquireLatestImage;
    }

    public ImageProxy acquireNextImage() {
        ImageProxy acquireNextImage;
        synchronized (this.mLock) {
            acquireNextImage = this.mOutputImageReader.acquireNextImage();
        }
        return acquireNextImage;
    }

    public void close() {
        synchronized (this.mLock) {
            if (!this.mClosed) {
                this.mInputImageReader.close();
                this.mOutputImageReader.close();
                this.mSettableImageProxyBundle.close();
                this.mClosed = true;
            }
        }
    }

    public int getHeight() {
        int height;
        synchronized (this.mLock) {
            height = this.mInputImageReader.getHeight();
        }
        return height;
    }

    public int getWidth() {
        int width;
        synchronized (this.mLock) {
            width = this.mInputImageReader.getWidth();
        }
        return width;
    }

    public int getImageFormat() {
        int imageFormat;
        synchronized (this.mLock) {
            imageFormat = this.mInputImageReader.getImageFormat();
        }
        return imageFormat;
    }

    public int getMaxImages() {
        int maxImages;
        synchronized (this.mLock) {
            maxImages = this.mInputImageReader.getMaxImages();
        }
        return maxImages;
    }

    public Surface getSurface() {
        Surface surface;
        synchronized (this.mLock) {
            surface = this.mInputImageReader.getSurface();
        }
        return surface;
    }

    public void setOnImageAvailableListener(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, Handler handler) {
        setOnImageAvailableListener(onImageAvailableListener, CameraXExecutors.newHandlerExecutor(handler));
    }

    public void setOnImageAvailableListener(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, Executor executor) {
        synchronized (this.mLock) {
            this.mListener = onImageAvailableListener;
            this.mExecutor = executor;
            this.mInputImageReader.setOnImageAvailableListener(this.mTransformedListener, executor);
            this.mOutputImageReader.setOnImageAvailableListener(this.mImageProcessedListener, executor);
        }
    }

    public void setCaptureBundle(CaptureBundle captureBundle) {
        synchronized (this.mLock) {
            if (captureBundle.getCaptureStages() != null) {
                if (this.mInputImageReader.getMaxImages() >= captureBundle.getCaptureStages().size()) {
                    this.mCaptureIdList.clear();
                    for (CaptureStage next : captureBundle.getCaptureStages()) {
                        if (next != null) {
                            this.mCaptureIdList.add(Integer.valueOf(next.getId()));
                        }
                    }
                } else {
                    throw new IllegalArgumentException("CaptureBundle is lager than InputImageReader.");
                }
            }
            this.mSettableImageProxyBundle = new SettableImageProxyBundle(this.mCaptureIdList);
            setupSettableImageProxyBundleCallbacks();
        }
    }

    /* access modifiers changed from: package-private */
    public CameraCaptureCallback getCameraCaptureCallback() {
        ImageReaderProxy imageReaderProxy = this.mInputImageReader;
        if (imageReaderProxy instanceof MetadataImageReader) {
            return ((MetadataImageReader) imageReaderProxy).getCameraCaptureCallback();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void setupSettableImageProxyBundleCallbacks() {
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : this.mCaptureIdList) {
            arrayList.add(this.mSettableImageProxyBundle.getImageProxy(intValue.intValue()));
        }
        Futures.addCallback(Futures.allAsList(arrayList), this.mCaptureStageReadyCallback, CameraXExecutors.directExecutor());
    }

    /* access modifiers changed from: package-private */
    public void imageIncoming(ImageReaderProxy imageReaderProxy) {
        synchronized (this.mLock) {
            if (!this.mClosed) {
                try {
                    ImageProxy acquireNextImage = imageReaderProxy.acquireNextImage();
                    if (acquireNextImage != null) {
                        Integer num = (Integer) acquireNextImage.getImageInfo().getTag();
                        if (!this.mCaptureIdList.contains(num)) {
                            Log.w(TAG, "ImageProxyBundle does not contain this id: " + num);
                            acquireNextImage.close();
                        } else {
                            this.mSettableImageProxyBundle.addImageProxy(acquireNextImage);
                        }
                    }
                } catch (IllegalStateException e) {
                    Log.e(TAG, "Failed to acquire latest image.", e);
                }
                return;
            }
            return;
        }
    }
}

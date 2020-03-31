package androidx.camera.core;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.SingleImageProxyBundle;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

final class ProcessingSurface extends DeferrableSurface {
    private static final int MAX_IMAGES = 2;
    private static final String TAG = "ProcessingSurfaceTextur";
    private final CameraCaptureCallback mCameraCaptureCallback;
    final CaptureProcessor mCaptureProcessor;
    final CaptureStage mCaptureStage;
    private final Handler mImageReaderHandler;
    final MetadataImageReader mInputImageReader;
    final Surface mInputSurface;
    final Object mLock = new Object();
    private final DeferrableSurface mOutputDeferrableSurface;
    boolean mReleased = false;
    private final Size mResolution;
    private final ImageReaderProxy.OnImageAvailableListener mTransformedListener = new ImageReaderProxy.OnImageAvailableListener() {
        /* class androidx.camera.core.ProcessingSurface.AnonymousClass1 */

        public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
            synchronized (ProcessingSurface.this.mLock) {
                ProcessingSurface.this.imageIncoming(imageReaderProxy);
            }
        }
    };

    ProcessingSurface(int i, int i2, int i3, Handler handler, CaptureStage captureStage, CaptureProcessor captureProcessor, DeferrableSurface deferrableSurface) {
        this.mResolution = new Size(i, i2);
        if (handler != null) {
            this.mImageReaderHandler = handler;
        } else {
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                this.mImageReaderHandler = new Handler(myLooper);
            } else {
                throw new IllegalStateException("Creating a ProcessingSurface requires a non-null Handler, or be created  on a thread with a Looper.");
            }
        }
        MetadataImageReader metadataImageReader = new MetadataImageReader(i, i2, i3, 2, this.mImageReaderHandler);
        this.mInputImageReader = metadataImageReader;
        metadataImageReader.setOnImageAvailableListener(this.mTransformedListener, this.mImageReaderHandler);
        this.mInputSurface = this.mInputImageReader.getSurface();
        this.mCameraCaptureCallback = this.mInputImageReader.getCameraCaptureCallback();
        this.mCaptureProcessor = captureProcessor;
        captureProcessor.onResolutionUpdate(this.mResolution);
        this.mCaptureStage = captureStage;
        this.mOutputDeferrableSurface = super;
        Futures.addCallback(super.getSurface(), new FutureCallback<Surface>() {
            /* class androidx.camera.core.ProcessingSurface.AnonymousClass2 */

            public void onSuccess(Surface surface) {
                synchronized (ProcessingSurface.this.mLock) {
                    ProcessingSurface.this.mCaptureProcessor.onOutputSurface(surface, 1);
                }
            }

            public void onFailure(Throwable th) {
                Log.e(ProcessingSurface.TAG, "Failed to extract Listenable<Surface>.", th);
            }
        }, CameraXExecutors.directExecutor());
        getTerminationFuture().addListener(new Runnable() {
            /* class androidx.camera.core.$$Lambda$ProcessingSurface$fleJ7Fv2BvhRan9diypF10B_VWk */

            public final void run() {
                ProcessingSurface.this.release();
            }
        }, CameraXExecutors.directExecutor());
    }

    public ListenableFuture<Surface> provideSurface() {
        return Futures.immediateFuture(this.mInputSurface);
    }

    /* access modifiers changed from: package-private */
    public CameraCaptureCallback getCameraCaptureCallback() {
        CameraCaptureCallback cameraCaptureCallback;
        synchronized (this.mLock) {
            if (!this.mReleased) {
                cameraCaptureCallback = this.mCameraCaptureCallback;
            } else {
                throw new IllegalStateException("ProcessingSurface already released!");
            }
        }
        return cameraCaptureCallback;
    }

    /* access modifiers changed from: private */
    public void release() {
        synchronized (this.mLock) {
            if (!this.mReleased) {
                this.mInputImageReader.close();
                this.mInputSurface.release();
                this.mOutputDeferrableSurface.close();
                this.mReleased = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void imageIncoming(ImageReaderProxy imageReaderProxy) {
        if (!this.mReleased) {
            ImageProxy imageProxy = null;
            try {
                imageProxy = imageReaderProxy.acquireNextImage();
            } catch (IllegalStateException e) {
                Log.e(TAG, "Failed to acquire next image.", e);
            }
            if (imageProxy != null) {
                ImageInfo imageInfo = imageProxy.getImageInfo();
                if (imageInfo == null) {
                    imageProxy.close();
                    return;
                }
                Object tag = imageInfo.getTag();
                if (tag == null) {
                    imageProxy.close();
                } else if (!(tag instanceof Integer)) {
                    imageProxy.close();
                } else {
                    Integer num = (Integer) tag;
                    if (this.mCaptureStage.getId() != num.intValue()) {
                        Log.w(TAG, "ImageProxyBundle does not contain this id: " + num);
                        imageProxy.close();
                        return;
                    }
                    SingleImageProxyBundle singleImageProxyBundle = new SingleImageProxyBundle(imageProxy);
                    this.mCaptureProcessor.process(singleImageProxyBundle);
                    singleImageProxyBundle.close();
                }
            }
        }
    }
}

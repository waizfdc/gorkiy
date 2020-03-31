package androidx.camera.core;

import android.util.SparseArray;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class SettableImageProxyBundle implements ImageProxyBundle {
    private final List<Integer> mCaptureIdList;
    private boolean mClosed = false;
    final SparseArray<CallbackToFutureAdapter.Completer<ImageProxy>> mCompleters = new SparseArray<>();
    private final SparseArray<ListenableFuture<ImageProxy>> mFutureResults = new SparseArray<>();
    final Object mLock = new Object();
    private final List<ImageProxy> mOwnedImageProxies = new ArrayList();

    SettableImageProxyBundle(List<Integer> list) {
        this.mCaptureIdList = list;
        setup();
    }

    public ListenableFuture<ImageProxy> getImageProxy(int i) {
        ListenableFuture<ImageProxy> listenableFuture;
        synchronized (this.mLock) {
            if (!this.mClosed) {
                listenableFuture = this.mFutureResults.get(i);
                if (listenableFuture == null) {
                    throw new IllegalArgumentException("ImageProxyBundle does not contain this id: " + i);
                }
            } else {
                throw new IllegalStateException("ImageProxyBundle already closed.");
            }
        }
        return listenableFuture;
    }

    public List<Integer> getCaptureIds() {
        return Collections.unmodifiableList(this.mCaptureIdList);
    }

    /* access modifiers changed from: package-private */
    public void addImageProxy(ImageProxy imageProxy) {
        synchronized (this.mLock) {
            if (!this.mClosed) {
                Integer num = (Integer) imageProxy.getImageInfo().getTag();
                if (num != null) {
                    CallbackToFutureAdapter.Completer completer = this.mCompleters.get(num.intValue());
                    if (completer != null) {
                        this.mOwnedImageProxies.add(imageProxy);
                        completer.set(imageProxy);
                        return;
                    }
                    throw new IllegalArgumentException("ImageProxyBundle does not contain this id: " + num);
                }
                throw new IllegalArgumentException("CaptureId is null.");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void close() {
        synchronized (this.mLock) {
            if (!this.mClosed) {
                for (ImageProxy close : this.mOwnedImageProxies) {
                    close.close();
                }
                this.mOwnedImageProxies.clear();
                this.mFutureResults.clear();
                this.mCompleters.clear();
                this.mClosed = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        synchronized (this.mLock) {
            if (!this.mClosed) {
                for (ImageProxy close : this.mOwnedImageProxies) {
                    close.close();
                }
                this.mOwnedImageProxies.clear();
                this.mFutureResults.clear();
                this.mCompleters.clear();
                setup();
            }
        }
    }

    private void setup() {
        synchronized (this.mLock) {
            for (Integer intValue : this.mCaptureIdList) {
                final int intValue2 = intValue.intValue();
                this.mFutureResults.put(intValue2, CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<ImageProxy>() {
                    /* class androidx.camera.core.SettableImageProxyBundle.AnonymousClass1 */

                    public Object attachCompleter(CallbackToFutureAdapter.Completer<ImageProxy> completer) {
                        synchronized (SettableImageProxyBundle.this.mLock) {
                            SettableImageProxyBundle.this.mCompleters.put(intValue2, completer);
                        }
                        return "getImageProxy(id: " + intValue2 + ")";
                    }
                }));
            }
        }
    }
}

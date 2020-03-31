package androidx.camera.core.impl;

import android.util.Log;
import android.view.Surface;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class DeferrableSurface {
    private static final boolean DEBUG = false;
    protected static final String TAG = "DeferrableSurface";
    private static AtomicInteger sTotalCount = new AtomicInteger(0);
    private static AtomicInteger sUsedCount = new AtomicInteger(0);
    private boolean mClosed = false;
    private final Object mLock = new Object();
    private CallbackToFutureAdapter.Completer<Void> mTerminationCompleter;
    private final ListenableFuture<Void> mTerminationFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() {
        /* class androidx.camera.core.impl.$$Lambda$DeferrableSurface$4AwivYkWbX9ifTwpoNEQg994K4I */

        public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
            return DeferrableSurface.this.lambda$new$0$DeferrableSurface(completer);
        }
    });
    private int mUseCount = 0;

    /* access modifiers changed from: protected */
    public abstract ListenableFuture<Surface> provideSurface();

    public static final class SurfaceUnavailableException extends Exception {
        public SurfaceUnavailableException(String str) {
            super(str);
        }
    }

    public static final class SurfaceClosedException extends Exception {
        DeferrableSurface mDeferrableSurface;

        public SurfaceClosedException(String str, DeferrableSurface deferrableSurface) {
            super(str);
            this.mDeferrableSurface = deferrableSurface;
        }

        public DeferrableSurface getDeferrableSurface() {
            return this.mDeferrableSurface;
        }
    }

    public /* synthetic */ Object lambda$new$0$DeferrableSurface(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mLock) {
            this.mTerminationCompleter = completer;
        }
        return "DeferrableSurface-termination(" + this + ")";
    }

    private /* synthetic */ void lambda$new$1(String str) {
        try {
            this.mTerminationFuture.get();
            printGlobalDebugCounts("Surface terminated", sTotalCount.decrementAndGet(), sUsedCount.get());
        } catch (Exception e) {
            Log.e(TAG, "Unexpected surface termination for " + this + "\nStack Trace:\n" + str);
            throw new IllegalArgumentException("DeferrableSurface terminated with unexpected exception.", e);
        }
    }

    private void printGlobalDebugCounts(String str, int i, int i2) {
        Log.d(TAG, str + "[total_surfaces=" + i + ", used_surfaces=" + i2 + "](" + this + "}");
    }

    public final ListenableFuture<Surface> getSurface() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                ListenableFuture<Surface> immediateFailedFuture = Futures.immediateFailedFuture(new SurfaceClosedException("DeferrableSurface already closed.", this));
                return immediateFailedFuture;
            }
            ListenableFuture<Surface> provideSurface = provideSurface();
            return provideSurface;
        }
    }

    public ListenableFuture<Void> getTerminationFuture() {
        return Futures.nonCancellationPropagating(this.mTerminationFuture);
    }

    public void incrementUseCount() throws SurfaceClosedException {
        synchronized (this.mLock) {
            if (this.mUseCount == 0) {
                if (this.mClosed) {
                    throw new SurfaceClosedException("Cannot begin use on a closed surface.", this);
                }
            }
            this.mUseCount++;
        }
    }

    public final void close() {
        CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.mLock) {
            if (!this.mClosed) {
                this.mClosed = true;
                if (this.mUseCount == 0) {
                    completer = this.mTerminationCompleter;
                    this.mTerminationCompleter = null;
                }
            }
            completer = null;
        }
        if (completer != null) {
            completer.set(null);
        }
    }

    public void decrementUseCount() {
        CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.mLock) {
            if (this.mUseCount != 0) {
                int i = this.mUseCount - 1;
                this.mUseCount = i;
                if (i != 0 || !this.mClosed) {
                    completer = null;
                } else {
                    completer = this.mTerminationCompleter;
                    this.mTerminationCompleter = null;
                }
            } else {
                throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
            }
        }
        if (completer != null) {
            completer.set(null);
        }
    }

    public int getUseCount() {
        int i;
        synchronized (this.mLock) {
            i = this.mUseCount;
        }
        return i;
    }
}

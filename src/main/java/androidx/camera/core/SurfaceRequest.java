package androidx.camera.core;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class SurfaceRequest {
    private DeferrableSurface mInternalDeferrableSurface;
    private final CallbackToFutureAdapter.Completer<Void> mRequestCancellationCompleter;
    private final Size mResolution;
    private final ListenableFuture<Void> mSessionStatusFuture;
    private final CallbackToFutureAdapter.Completer<Surface> mSurfaceCompleter;
    final ListenableFuture<Surface> mSurfaceFuture;

    public SurfaceRequest(Size size) {
        this.mResolution = size;
        final String str = "SurfaceRequest[size: " + size + ", id: " + hashCode() + "]";
        AtomicReference atomicReference = new AtomicReference(null);
        final ListenableFuture future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(atomicReference, str) {
            /* class androidx.camera.core.$$Lambda$SurfaceRequest$odG17THPHlbCF8n40ySxsMVBMjU */
            private final /* synthetic */ AtomicReference f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f$0.set(completer);
            }
        });
        final CallbackToFutureAdapter.Completer<Void> completer = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull(atomicReference.get());
        this.mRequestCancellationCompleter = completer;
        AtomicReference atomicReference2 = new AtomicReference(null);
        ListenableFuture<Void> future2 = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(atomicReference2, str) {
            /* class androidx.camera.core.$$Lambda$SurfaceRequest$sEXLWXS66apbUecgY06U3wMjup4 */
            private final /* synthetic */ AtomicReference f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f$0.set(completer);
            }
        });
        this.mSessionStatusFuture = future2;
        Futures.addCallback(future2, new FutureCallback<Void>() {
            /* class androidx.camera.core.SurfaceRequest.AnonymousClass1 */

            public void onSuccess(Void voidR) {
                Preconditions.checkState(completer.set(null));
            }

            public void onFailure(Throwable th) {
                if (th instanceof RequestCancelledException) {
                    Preconditions.checkState(future.cancel(false));
                } else {
                    Preconditions.checkState(completer.set(null));
                }
            }
        }, CameraXExecutors.directExecutor());
        final CallbackToFutureAdapter.Completer completer2 = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull(atomicReference2.get());
        AtomicReference atomicReference3 = new AtomicReference(null);
        this.mSurfaceFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(atomicReference3, str) {
            /* class androidx.camera.core.$$Lambda$SurfaceRequest$izJhW7Kwab2vgiWRDUyBSJPuRwo */
            private final /* synthetic */ AtomicReference f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f$0.set(completer);
            }
        });
        this.mSurfaceCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull(atomicReference3.get());
        AnonymousClass2 r1 = new DeferrableSurface() {
            /* class androidx.camera.core.SurfaceRequest.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public ListenableFuture<Surface> provideSurface() {
                return SurfaceRequest.this.mSurfaceFuture;
            }
        };
        this.mInternalDeferrableSurface = r1;
        final ListenableFuture<Void> terminationFuture = r1.getTerminationFuture();
        Futures.addCallback(this.mSurfaceFuture, new FutureCallback<Surface>() {
            /* class androidx.camera.core.SurfaceRequest.AnonymousClass3 */

            public void onSuccess(Surface surface) {
                Futures.propagate(terminationFuture, completer2);
            }

            public void onFailure(Throwable th) {
                if (th instanceof CancellationException) {
                    CallbackToFutureAdapter.Completer completer = completer2;
                    Preconditions.checkState(completer.setException(new RequestCancelledException(str + " cancelled.", th)));
                    return;
                }
                completer2.set(null);
            }
        }, CameraXExecutors.directExecutor());
        terminationFuture.addListener(new Runnable() {
            /* class androidx.camera.core.$$Lambda$SurfaceRequest$ngtA0g5dJH3w7teLIgUUOnvVWD4 */

            public final void run() {
                SurfaceRequest.this.lambda$new$3$SurfaceRequest();
            }
        }, CameraXExecutors.directExecutor());
    }

    public /* synthetic */ void lambda$new$3$SurfaceRequest() {
        this.mSurfaceFuture.cancel(true);
    }

    public DeferrableSurface getDeferrableSurface() {
        return this.mInternalDeferrableSurface;
    }

    public Size getResolution() {
        return this.mResolution;
    }

    public void provideSurface(final Surface surface, Executor executor, final Consumer<Result> consumer) {
        if (this.mSurfaceCompleter.set(surface) || this.mSurfaceFuture.isCancelled()) {
            Futures.addCallback(this.mSessionStatusFuture, new FutureCallback<Void>() {
                /* class androidx.camera.core.SurfaceRequest.AnonymousClass4 */

                public void onSuccess(Void voidR) {
                    consumer.accept(Result.of(0, surface));
                }

                public void onFailure(Throwable th) {
                    Preconditions.checkState(th instanceof RequestCancelledException, "Camera surface session should only fail with request cancellation. Instead failed due to:\n" + th);
                    consumer.accept(Result.of(1, surface));
                }
            }, executor);
            return;
        }
        Preconditions.checkState(this.mSurfaceFuture.isDone());
        try {
            this.mSurfaceFuture.get();
            executor.execute(new Runnable(surface) {
                /* class androidx.camera.core.$$Lambda$SurfaceRequest$aC9bT1pfUxuJxiP2CHR2nby0fcw */
                private final /* synthetic */ Surface f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    Consumer.this.accept(SurfaceRequest.Result.of(3, this.f$1));
                }
            });
        } catch (InterruptedException | ExecutionException unused) {
            executor.execute(new Runnable(surface) {
                /* class androidx.camera.core.$$Lambda$SurfaceRequest$1BFEIX2iizhnKAclUlsKNJ3zuM */
                private final /* synthetic */ Surface f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    Consumer.this.accept(SurfaceRequest.Result.of(4, this.f$1));
                }
            });
        }
    }

    public boolean willNotProvideSurface() {
        return this.mSurfaceCompleter.setException(new DeferrableSurface.SurfaceUnavailableException("Surface request will not complete."));
    }

    public void addRequestCancellationListener(Executor executor, Runnable runnable) {
        this.mRequestCancellationCompleter.addCancellationListener(runnable, executor);
    }

    private static final class RequestCancelledException extends RuntimeException {
        RequestCancelledException(String str, Throwable th) {
            super(str, th);
        }
    }

    public static abstract class Result {
        public static final int RESULT_INVALID_SURFACE = 2;
        public static final int RESULT_REQUEST_CANCELLED = 1;
        public static final int RESULT_SURFACE_ALREADY_PROVIDED = 3;
        public static final int RESULT_SURFACE_USED_SUCCESSFULLY = 0;
        public static final int RESULT_WILL_NOT_PROVIDE_SURFACE = 4;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ResultCode {
        }

        public abstract int getResultCode();

        public abstract Surface getSurface();

        static Result of(int i, Surface surface) {
            return new AutoValue_SurfaceRequest_Result(i, surface);
        }

        Result() {
        }
    }
}

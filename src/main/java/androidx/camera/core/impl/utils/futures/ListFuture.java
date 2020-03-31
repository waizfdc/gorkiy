package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

class ListFuture<V> implements ListenableFuture<List<V>> {
    private final boolean mAllMustSucceed;
    List<? extends ListenableFuture<? extends V>> mFutures;
    private final AtomicInteger mRemaining;
    private final ListenableFuture<List<V>> mResult = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<List<V>>() {
        /* class androidx.camera.core.impl.utils.futures.ListFuture.AnonymousClass1 */

        public Object attachCompleter(CallbackToFutureAdapter.Completer<List<V>> completer) {
            Preconditions.checkState(ListFuture.this.mResultNotifier == null, "The result can only set once!");
            ListFuture.this.mResultNotifier = completer;
            return "ListFuture[" + this + "]";
        }
    });
    CallbackToFutureAdapter.Completer<List<V>> mResultNotifier;
    List<V> mValues;

    ListFuture(List<? extends ListenableFuture<? extends V>> list, boolean z, Executor executor) {
        this.mFutures = (List) Preconditions.checkNotNull(list);
        this.mValues = new ArrayList(list.size());
        this.mAllMustSucceed = z;
        this.mRemaining = new AtomicInteger(list.size());
        init(executor);
    }

    private void init(Executor executor) {
        addListener(new Runnable() {
            /* class androidx.camera.core.impl.utils.futures.ListFuture.AnonymousClass2 */

            public void run() {
                ListFuture.this.mValues = null;
                ListFuture.this.mFutures = null;
            }
        }, CameraXExecutors.directExecutor());
        if (this.mFutures.isEmpty()) {
            this.mResultNotifier.set(new ArrayList(this.mValues));
            return;
        }
        for (int i = 0; i < this.mFutures.size(); i++) {
            this.mValues.add(null);
        }
        List<? extends ListenableFuture<? extends V>> list = this.mFutures;
        for (final int i2 = 0; i2 < list.size(); i2++) {
            final ListenableFuture listenableFuture = (ListenableFuture) list.get(i2);
            listenableFuture.addListener(new Runnable() {
                /* class androidx.camera.core.impl.utils.futures.ListFuture.AnonymousClass3 */

                public void run() {
                    ListFuture.this.setOneValue(i2, listenableFuture);
                }
            }, executor);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x00ba */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setOneValue(int r7, java.util.concurrent.Future<? extends V> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Less than 0 remaining futures"
            java.util.List<V> r1 = r6.mValues
            boolean r2 = r6.isDone()
            if (r2 != 0) goto L_0x0104
            if (r1 != 0) goto L_0x000e
            goto L_0x0104
        L_0x000e:
            r2 = 1
            r3 = 0
            boolean r4 = r8.isDone()     // Catch:{ CancellationException -> 0x00ba, ExecutionException -> 0x0091, RuntimeException -> 0x006c, Error -> 0x004b }
            java.lang.String r5 = "Tried to set value from future which is not done"
            androidx.core.util.Preconditions.checkState(r4, r5)     // Catch:{ CancellationException -> 0x00ba, ExecutionException -> 0x0091, RuntimeException -> 0x006c, Error -> 0x004b }
            java.lang.Object r8 = androidx.camera.core.impl.utils.futures.Futures.getUninterruptibly(r8)     // Catch:{ CancellationException -> 0x00ba, ExecutionException -> 0x0091, RuntimeException -> 0x006c, Error -> 0x004b }
            r1.set(r7, r8)     // Catch:{ CancellationException -> 0x00ba, ExecutionException -> 0x0091, RuntimeException -> 0x006c, Error -> 0x004b }
            java.util.concurrent.atomic.AtomicInteger r7 = r6.mRemaining
            int r7 = r7.decrementAndGet()
            if (r7 < 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r2 = r3
        L_0x002a:
            androidx.core.util.Preconditions.checkState(r2, r0)
            if (r7 != 0) goto L_0x00dd
            java.util.List<V> r7 = r6.mValues
            if (r7 == 0) goto L_0x003f
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r8 = r6.mResultNotifier
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r7)
        L_0x003a:
            r8.set(r0)
            goto L_0x00dd
        L_0x003f:
            boolean r7 = r6.isDone()
            androidx.core.util.Preconditions.checkState(r7)
            goto L_0x00dd
        L_0x0048:
            r7 = move-exception
            goto L_0x00de
        L_0x004b:
            r7 = move-exception
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r8 = r6.mResultNotifier     // Catch:{ all -> 0x0048 }
            r8.setException(r7)     // Catch:{ all -> 0x0048 }
            java.util.concurrent.atomic.AtomicInteger r7 = r6.mRemaining
            int r7 = r7.decrementAndGet()
            if (r7 < 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r2 = r3
        L_0x005b:
            androidx.core.util.Preconditions.checkState(r2, r0)
            if (r7 != 0) goto L_0x00dd
            java.util.List<V> r7 = r6.mValues
            if (r7 == 0) goto L_0x003f
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r8 = r6.mResultNotifier
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r7)
            goto L_0x003a
        L_0x006c:
            r7 = move-exception
            boolean r8 = r6.mAllMustSucceed     // Catch:{ all -> 0x0048 }
            if (r8 == 0) goto L_0x0076
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r8 = r6.mResultNotifier     // Catch:{ all -> 0x0048 }
            r8.setException(r7)     // Catch:{ all -> 0x0048 }
        L_0x0076:
            java.util.concurrent.atomic.AtomicInteger r7 = r6.mRemaining
            int r7 = r7.decrementAndGet()
            if (r7 < 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            r2 = r3
        L_0x0080:
            androidx.core.util.Preconditions.checkState(r2, r0)
            if (r7 != 0) goto L_0x00dd
            java.util.List<V> r7 = r6.mValues
            if (r7 == 0) goto L_0x003f
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r8 = r6.mResultNotifier
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r7)
            goto L_0x003a
        L_0x0091:
            r7 = move-exception
            boolean r8 = r6.mAllMustSucceed     // Catch:{ all -> 0x0048 }
            if (r8 == 0) goto L_0x009f
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r8 = r6.mResultNotifier     // Catch:{ all -> 0x0048 }
            java.lang.Throwable r7 = r7.getCause()     // Catch:{ all -> 0x0048 }
            r8.setException(r7)     // Catch:{ all -> 0x0048 }
        L_0x009f:
            java.util.concurrent.atomic.AtomicInteger r7 = r6.mRemaining
            int r7 = r7.decrementAndGet()
            if (r7 < 0) goto L_0x00a8
            goto L_0x00a9
        L_0x00a8:
            r2 = r3
        L_0x00a9:
            androidx.core.util.Preconditions.checkState(r2, r0)
            if (r7 != 0) goto L_0x00dd
            java.util.List<V> r7 = r6.mValues
            if (r7 == 0) goto L_0x003f
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r8 = r6.mResultNotifier
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r7)
            goto L_0x003a
        L_0x00ba:
            boolean r7 = r6.mAllMustSucceed     // Catch:{ all -> 0x0048 }
            if (r7 == 0) goto L_0x00c1
            r6.cancel(r3)     // Catch:{ all -> 0x0048 }
        L_0x00c1:
            java.util.concurrent.atomic.AtomicInteger r7 = r6.mRemaining
            int r7 = r7.decrementAndGet()
            if (r7 < 0) goto L_0x00ca
            goto L_0x00cb
        L_0x00ca:
            r2 = r3
        L_0x00cb:
            androidx.core.util.Preconditions.checkState(r2, r0)
            if (r7 != 0) goto L_0x00dd
            java.util.List<V> r7 = r6.mValues
            if (r7 == 0) goto L_0x003f
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r8 = r6.mResultNotifier
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r7)
            goto L_0x003a
        L_0x00dd:
            return
        L_0x00de:
            java.util.concurrent.atomic.AtomicInteger r8 = r6.mRemaining
            int r8 = r8.decrementAndGet()
            if (r8 < 0) goto L_0x00e7
            goto L_0x00e8
        L_0x00e7:
            r2 = r3
        L_0x00e8:
            androidx.core.util.Preconditions.checkState(r2, r0)
            if (r8 != 0) goto L_0x0103
            java.util.List<V> r8 = r6.mValues
            if (r8 == 0) goto L_0x00fc
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r0 = r6.mResultNotifier
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r8)
            r0.set(r1)
            goto L_0x0103
        L_0x00fc:
            boolean r8 = r6.isDone()
            androidx.core.util.Preconditions.checkState(r8)
        L_0x0103:
            throw r7
        L_0x0104:
            boolean r7 = r6.mAllMustSucceed
            java.lang.String r8 = "Future was done before all dependencies completed"
            androidx.core.util.Preconditions.checkState(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.futures.ListFuture.setOneValue(int, java.util.concurrent.Future):void");
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.mResult.addListener(runnable, executor);
    }

    public boolean cancel(boolean z) {
        List<? extends ListenableFuture<? extends V>> list = this.mFutures;
        if (list != null) {
            for (ListenableFuture cancel : list) {
                cancel.cancel(z);
            }
        }
        return this.mResult.cancel(z);
    }

    public boolean isCancelled() {
        return this.mResult.isCancelled();
    }

    public boolean isDone() {
        return this.mResult.isDone();
    }

    public List<V> get() throws InterruptedException, ExecutionException {
        callAllGets();
        return this.mResult.get();
    }

    public List<V> get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mResult.get(j, timeUnit);
    }

    private void callAllGets() throws InterruptedException {
        List<? extends ListenableFuture<? extends V>> list = this.mFutures;
        if (list != null && !isDone()) {
            for (ListenableFuture listenableFuture : list) {
                while (true) {
                    if (!listenableFuture.isDone()) {
                        try {
                            listenableFuture.get();
                        } catch (Error e) {
                            throw e;
                        } catch (InterruptedException e2) {
                            throw e2;
                        } catch (Throwable unused) {
                            if (this.mAllMustSucceed) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}

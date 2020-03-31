package androidx.camera.core.impl;

import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class DeferrableSurfaces {
    private DeferrableSurfaces() {
    }

    public static ListenableFuture<List<Surface>> surfaceListWithTimeout(Collection<DeferrableSurface> collection, boolean z, long j, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        ArrayList arrayList = new ArrayList();
        for (DeferrableSurface surface : collection) {
            arrayList.add(surface.getSurface());
        }
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(arrayList, scheduledExecutorService, executor, j, z) {
            /* class androidx.camera.core.impl.$$Lambda$DeferrableSurfaces$_eJ7iY3oHlcbhnrK9kAok8keF3w */
            private final /* synthetic */ List f$0;
            private final /* synthetic */ ScheduledExecutorService f$1;
            private final /* synthetic */ Executor f$2;
            private final /* synthetic */ long f$3;
            private final /* synthetic */ boolean f$4;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r6;
            }

            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return DeferrableSurfaces.lambda$surfaceListWithTimeout$3(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, completer);
            }
        });
    }

    static /* synthetic */ Object lambda$surfaceListWithTimeout$3(List list, ScheduledExecutorService scheduledExecutorService, Executor executor, long j, final boolean z, final CallbackToFutureAdapter.Completer completer) throws Exception {
        ListenableFuture successfulAsList = Futures.successfulAsList(list);
        final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable(executor, successfulAsList, completer, j) {
            /* class androidx.camera.core.impl.$$Lambda$DeferrableSurfaces$Iu0_LdlVD0cvWCILdpisJjMYZYU */
            private final /* synthetic */ Executor f$0;
            private final /* synthetic */ ListenableFuture f$1;
            private final /* synthetic */ CallbackToFutureAdapter.Completer f$2;
            private final /* synthetic */ long f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                this.f$0.execute(new Runnable(this.f$2, this.f$3) {
                    /* class androidx.camera.core.impl.$$Lambda$DeferrableSurfaces$efdnlIE5QUEPOM65jm9Mf9p62tc */
                    private final /* synthetic */ CallbackToFutureAdapter.Completer f$1;
                    private final /* synthetic */ long f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        DeferrableSurfaces.lambda$null$0(ListenableFuture.this, this.f$1, this.f$2);
                    }
                });
            }
        }, j, TimeUnit.MILLISECONDS);
        completer.addCancellationListener(new Runnable() {
            /* class androidx.camera.core.impl.$$Lambda$DeferrableSurfaces$ZAQS8uZG8X_s5qAl3JBKnur219g */

            public final void run() {
                ListenableFuture.this.cancel(true);
            }
        }, executor);
        Futures.addCallback(successfulAsList, new FutureCallback<List<Surface>>() {
            /* class androidx.camera.core.impl.DeferrableSurfaces.AnonymousClass1 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<Surface>) ((List) obj));
            }

            public void onSuccess(List<Surface> list) {
                ArrayList arrayList = new ArrayList(list);
                if (z) {
                    arrayList.removeAll(Collections.singleton(null));
                }
                completer.set(arrayList);
                schedule.cancel(true);
            }

            public void onFailure(Throwable th) {
                completer.set(Collections.unmodifiableList(Collections.emptyList()));
                schedule.cancel(true);
            }
        }, executor);
        return "surfaceList";
    }

    static /* synthetic */ void lambda$null$0(ListenableFuture listenableFuture, CallbackToFutureAdapter.Completer completer, long j) {
        if (!listenableFuture.isDone()) {
            completer.setException(new TimeoutException("Cannot complete surfaceList within " + j));
            listenableFuture.cancel(true);
        }
    }

    public static boolean tryIncrementAll(List<DeferrableSurface> list) {
        try {
            incrementAll(list);
            return true;
        } catch (DeferrableSurface.SurfaceClosedException unused) {
            return false;
        }
    }

    public static void incrementAll(List<DeferrableSurface> list) throws DeferrableSurface.SurfaceClosedException {
        if (!list.isEmpty()) {
            int i = 0;
            do {
                try {
                    list.get(i).incrementUseCount();
                    i++;
                } catch (DeferrableSurface.SurfaceClosedException e) {
                    for (int i2 = i - 1; i2 >= 0; i2--) {
                        list.get(i2).decrementUseCount();
                    }
                    throw e;
                }
            } while (i < list.size());
        }
    }

    public static void decrementAll(List<DeferrableSurface> list) {
        for (DeferrableSurface decrementUseCount : list) {
            decrementUseCount.decrementUseCount();
        }
    }
}

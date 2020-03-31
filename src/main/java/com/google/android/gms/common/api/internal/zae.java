package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
abstract class zae<T> extends zab {
    protected final TaskCompletionSource<T> zacq;

    public zae(int i, TaskCompletionSource<T> taskCompletionSource) {
        super(i);
        this.zacq = taskCompletionSource;
    }

    public void zaa(zaz zaz, boolean z) {
    }

    /* access modifiers changed from: protected */
    public abstract void zad(GoogleApiManager.zaa<?> zaa) throws RemoteException;

    public void zaa(Status status) {
        this.zacq.trySetException(new ApiException(status));
    }

    public void zaa(RuntimeException runtimeException) {
        this.zacq.trySetException(runtimeException);
    }

    public final void zac(GoogleApiManager.zaa<?> zaa) throws DeadObjectException {
        try {
            zad(zaa);
        } catch (DeadObjectException e) {
            zaa(zac.zaa(e));
            throw e;
        } catch (RemoteException e2) {
            zaa(zac.zaa(e2));
        } catch (RuntimeException e3) {
            zaa(e3);
        }
    }
}

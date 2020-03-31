package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zag extends zae<Void> {
    private final RegisterListenerMethod<Api.AnyClient, ?> zact;
    private final UnregisterListenerMethod<Api.AnyClient, ?> zacu;

    public zag(zabv zabv, TaskCompletionSource<Void> taskCompletionSource) {
        super(3, taskCompletionSource);
        this.zact = zabv.zakc;
        this.zacu = zabv.zakd;
    }

    public final /* bridge */ /* synthetic */ void zaa(zaz zaz, boolean z) {
    }

    public final void zad(GoogleApiManager.zaa<?> zaa) throws RemoteException {
        this.zact.registerListener(zaa.zaad(), this.zacq);
        if (this.zact.getListenerKey() != null) {
            zaa.zabi().put(this.zact.getListenerKey(), new zabv(this.zact, this.zacu));
        }
    }

    public final Feature[] zaa(GoogleApiManager.zaa<?> zaa) {
        return this.zact.getRequiredFeatures();
    }

    public final boolean zab(GoogleApiManager.zaa<?> zaa) {
        return this.zact.shouldAutoResolveMissingFeatures();
    }

    public final /* bridge */ /* synthetic */ void zaa(RuntimeException runtimeException) {
        super.zaa(runtimeException);
    }

    public final /* bridge */ /* synthetic */ void zaa(Status status) {
        super.zaa(status);
    }
}

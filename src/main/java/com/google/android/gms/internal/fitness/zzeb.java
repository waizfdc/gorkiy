package com.google.android.gms.internal.fitness;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.zzu;
import com.google.android.gms.fitness.request.zzas;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzeb extends zzav {
    private final /* synthetic */ PendingIntent zznk;
    private final /* synthetic */ zzu zznx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeb(zzdw zzdw, GoogleApiClient googleApiClient, zzu zzu, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.zznx = zzu;
        this.zznk = pendingIntent;
    }

    /* access modifiers changed from: protected */
    public final Status zza(Status status) {
        return status;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzcb) ((zzao) anyClient).getService()).zza(new zzas(this.zznx, this.zznk, new zzel(this)));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return createFailedResult(status);
    }
}

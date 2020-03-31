package com.google.android.gms.internal.fitness;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.zzx;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzdk extends zzaj {
    private final /* synthetic */ PendingIntent zznk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdk(zzdh zzdh, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.zznk = pendingIntent;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbx) ((zzac) anyClient).getService()).zza(new zzx(this.zznk, new zzel(this)));
    }
}

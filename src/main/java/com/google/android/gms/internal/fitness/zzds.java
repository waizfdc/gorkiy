package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.zzbk;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzds extends zzap {
    private final /* synthetic */ Subscription zzns;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzds(zzdr zzdr, GoogleApiClient googleApiClient, Subscription subscription) {
        super(googleApiClient);
        this.zzns = subscription;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.fitness.request.zzbk.<init>(com.google.android.gms.fitness.data.Subscription, boolean, com.google.android.gms.internal.fitness.zzcm):void
     arg types: [com.google.android.gms.fitness.data.Subscription, int, com.google.android.gms.internal.fitness.zzel]
     candidates:
      com.google.android.gms.fitness.request.zzbk.<init>(com.google.android.gms.fitness.data.Subscription, boolean, android.os.IBinder):void
      com.google.android.gms.fitness.request.zzbk.<init>(com.google.android.gms.fitness.data.Subscription, boolean, com.google.android.gms.internal.fitness.zzcm):void */
    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbz) ((zzai) anyClient).getService()).zza(new zzbk(this.zzns, false, (zzcm) new zzel(this)));
    }
}

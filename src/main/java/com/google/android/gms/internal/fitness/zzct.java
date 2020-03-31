package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.zzaf;
import com.google.android.gms.fitness.request.zzbi;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzct extends zzq {
    private final /* synthetic */ zzaf zzmz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzct(zzcr zzcr, GoogleApiClient googleApiClient, zzaf zzaf) {
        super(googleApiClient);
        this.zzmz = zzaf;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbr) ((zzn) anyClient).getService()).zza(new zzbi(this.zzmz, new zzel(this)));
    }
}

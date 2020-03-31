package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.zzab;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzda extends zzw {
    zzda(zzcz zzcz, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbt) ((zzt) anyClient).getService()).zza(new zzab((zzcm) new zzel(this)));
    }
}

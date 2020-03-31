package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzdl extends zzaj {
    private final /* synthetic */ DataUpdateListenerRegistrationRequest zznl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdl(zzdh zzdh, GoogleApiClient googleApiClient, DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) {
        super(googleApiClient);
        this.zznl = dataUpdateListenerRegistrationRequest;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbx) ((zzac) anyClient).getService()).zza(new DataUpdateListenerRegistrationRequest(this.zznl, new zzel(this)));
    }
}

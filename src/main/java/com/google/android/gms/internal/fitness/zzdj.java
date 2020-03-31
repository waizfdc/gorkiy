package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.DataDeleteRequest;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzdj extends zzaj {
    private final /* synthetic */ DataDeleteRequest zznj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdj(zzdh zzdh, GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest) {
        super(googleApiClient);
        this.zznj = dataDeleteRequest;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbx) ((zzac) anyClient).getService()).zza(new DataDeleteRequest(this.zznj, new zzel(this)));
    }
}

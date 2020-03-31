package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzdn extends zzah<DataReadResult> {
    private final /* synthetic */ DataReadRequest zzno;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdn(zzdh zzdh, GoogleApiClient googleApiClient, DataReadRequest dataReadRequest) {
        super(googleApiClient);
        this.zzno = dataReadRequest;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbx) ((zzac) anyClient).getService()).zza(new DataReadRequest(this.zzno, new zzdo(this, null)));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return DataReadResult.zza(status, this.zzno.getDataTypes(), this.zzno.getDataSources());
    }
}

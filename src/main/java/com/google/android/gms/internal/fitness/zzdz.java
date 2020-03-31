package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzdz extends zzat<DataSourcesResult> {
    private final /* synthetic */ DataSourcesRequest zznw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdz(zzdw zzdw, GoogleApiClient googleApiClient, DataSourcesRequest dataSourcesRequest) {
        super(googleApiClient);
        this.zznw = dataSourcesRequest;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzcb) ((zzao) anyClient).getService()).zza(new DataSourcesRequest(this.zznw, new zzk(this)));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new DataSourcesResult(Collections.emptyList(), status);
    }
}

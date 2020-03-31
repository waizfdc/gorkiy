package com.google.android.gms.internal.auth;

import android.os.RemoteException;
import com.google.android.gms.auth.account.zzc;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

final class zzi extends BaseImplementation.ApiMethodImpl<Result, zzr> {
    private final /* synthetic */ boolean zzae;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzi(zzh zzh, Api api, GoogleApiClient googleApiClient, boolean z) {
        super(api, googleApiClient);
        this.zzae = z;
    }

    /* access modifiers changed from: protected */
    public final Result createFailedResult(Status status) {
        return new zzp(status);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzc) ((zzr) anyClient).getService()).zzb(this.zzae);
        setResult((Result) new zzp(Status.RESULT_SUCCESS));
    }
}

package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.SessionInsertRequest;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzef extends zzbb {
    private final /* synthetic */ SessionInsertRequest zzoc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzef(zzea zzea, GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest) {
        super(googleApiClient);
        this.zzoc = sessionInsertRequest;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzcd) ((zzau) anyClient).getService()).zza(new SessionInsertRequest(this.zzoc, new zzel(this)));
    }
}

package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.zzbc;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzec extends zzaz<SessionStopResult> {
    private final /* synthetic */ String zzny = null;
    private final /* synthetic */ String zznz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzec(zzea zzea, GoogleApiClient googleApiClient, String str, String str2) {
        super(googleApiClient);
        this.zznz = str2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.fitness.request.zzbc.<init>(java.lang.String, java.lang.String, com.google.android.gms.internal.fitness.zzcl):void
     arg types: [java.lang.String, java.lang.String, com.google.android.gms.internal.fitness.zzei]
     candidates:
      com.google.android.gms.fitness.request.zzbc.<init>(java.lang.String, java.lang.String, android.os.IBinder):void
      com.google.android.gms.fitness.request.zzbc.<init>(java.lang.String, java.lang.String, com.google.android.gms.internal.fitness.zzcl):void */
    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzcd) ((zzau) anyClient).getService()).zza(new zzbc(this.zzny, this.zznz, (zzcl) new zzei(this, null)));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new SessionStopResult(status, Collections.emptyList());
    }
}

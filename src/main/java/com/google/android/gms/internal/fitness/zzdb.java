package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.zzt;
import com.google.android.gms.fitness.result.DataTypeResult;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzdb extends zzu<DataTypeResult> {
    private final /* synthetic */ String zznd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdb(zzcz zzcz, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zznd = str;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.fitness.request.zzt.<init>(java.lang.String, com.google.android.gms.internal.fitness.zzbl):void
     arg types: [java.lang.String, com.google.android.gms.internal.fitness.zzdd]
     candidates:
      com.google.android.gms.fitness.request.zzt.<init>(java.lang.String, android.os.IBinder):void
      com.google.android.gms.fitness.request.zzt.<init>(java.lang.String, com.google.android.gms.internal.fitness.zzbl):void */
    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbt) ((zzt) anyClient).getService()).zza(new zzt(this.zznd, (zzbl) new zzdd(this, null)));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return DataTypeResult.zzc(status);
    }
}

package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.zzbm;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzcu extends zzq {
    private final /* synthetic */ String zzna;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcu(zzcr zzcr, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zzna = str;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.fitness.request.zzbm.<init>(java.lang.String, com.google.android.gms.internal.fitness.zzcm):void
     arg types: [java.lang.String, com.google.android.gms.internal.fitness.zzel]
     candidates:
      com.google.android.gms.fitness.request.zzbm.<init>(java.lang.String, android.os.IBinder):void
      com.google.android.gms.fitness.request.zzbm.<init>(java.lang.String, com.google.android.gms.internal.fitness.zzcm):void */
    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbr) ((zzn) anyClient).getService()).zza(new zzbm(this.zzna, (zzcm) new zzel(this)));
    }
}

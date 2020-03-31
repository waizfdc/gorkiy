package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.zzba;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzed extends zzbb {
    private final /* synthetic */ Session zzoa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzed(zzea zzea, GoogleApiClient googleApiClient, Session session) {
        super(googleApiClient);
        this.zzoa = session;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.fitness.request.zzba.<init>(com.google.android.gms.fitness.data.Session, com.google.android.gms.internal.fitness.zzcm):void
     arg types: [com.google.android.gms.fitness.data.Session, com.google.android.gms.internal.fitness.zzel]
     candidates:
      com.google.android.gms.fitness.request.zzba.<init>(com.google.android.gms.fitness.data.Session, android.os.IBinder):void
      com.google.android.gms.fitness.request.zzba.<init>(com.google.android.gms.fitness.data.Session, com.google.android.gms.internal.fitness.zzcm):void */
    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzcd) ((zzau) anyClient).getService()).zza(new zzba(this.zzoa, (zzcm) new zzel(this)));
    }
}

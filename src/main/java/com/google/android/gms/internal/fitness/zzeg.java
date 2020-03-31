package com.google.android.gms.internal.fitness;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.zzbe;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzeg extends zzbb {
    private final /* synthetic */ PendingIntent zznv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeg(zzea zzea, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.zznv = pendingIntent;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.fitness.request.zzbe.<init>(android.app.PendingIntent, com.google.android.gms.internal.fitness.zzcm):void
     arg types: [android.app.PendingIntent, com.google.android.gms.internal.fitness.zzel]
     candidates:
      com.google.android.gms.fitness.request.zzbe.<init>(android.app.PendingIntent, android.os.IBinder):void
      com.google.android.gms.fitness.request.zzbe.<init>(android.app.PendingIntent, com.google.android.gms.internal.fitness.zzcm):void */
    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzcd) ((zzau) anyClient).getService()).zza(new zzbe(this.zznv, (zzcm) new zzel(this)));
    }
}

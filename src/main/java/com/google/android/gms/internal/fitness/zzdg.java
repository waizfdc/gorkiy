package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.zzl;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzdg extends zzaj {
    private final /* synthetic */ DataSet zzng;
    private final /* synthetic */ boolean zznh = false;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdg(zzdh zzdh, GoogleApiClient googleApiClient, DataSet dataSet, boolean z) {
        super(googleApiClient);
        this.zzng = dataSet;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.fitness.request.zzl.<init>(com.google.android.gms.fitness.data.DataSet, com.google.android.gms.internal.fitness.zzcm, boolean):void
     arg types: [com.google.android.gms.fitness.data.DataSet, com.google.android.gms.internal.fitness.zzel, boolean]
     candidates:
      com.google.android.gms.fitness.request.zzl.<init>(com.google.android.gms.fitness.data.DataSet, android.os.IBinder, boolean):void
      com.google.android.gms.fitness.request.zzl.<init>(com.google.android.gms.fitness.data.DataSet, com.google.android.gms.internal.fitness.zzcm, boolean):void */
    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbx) ((zzac) anyClient).getService()).zza(new zzl(this.zzng, (zzcm) new zzel(this), this.zznh));
    }
}

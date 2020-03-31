package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.zzf;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzcv extends zzq {
    private final /* synthetic */ BleDevice zznb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcv(zzcr zzcr, GoogleApiClient googleApiClient, BleDevice bleDevice) {
        super(googleApiClient);
        this.zznb = bleDevice;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.fitness.request.zzf.<init>(java.lang.String, com.google.android.gms.fitness.data.BleDevice, com.google.android.gms.internal.fitness.zzcm):void
     arg types: [java.lang.String, com.google.android.gms.fitness.data.BleDevice, com.google.android.gms.internal.fitness.zzel]
     candidates:
      com.google.android.gms.fitness.request.zzf.<init>(java.lang.String, com.google.android.gms.fitness.data.BleDevice, android.os.IBinder):void
      com.google.android.gms.fitness.request.zzf.<init>(java.lang.String, com.google.android.gms.fitness.data.BleDevice, com.google.android.gms.internal.fitness.zzcm):void */
    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbr) ((zzn) anyClient).getService()).zza(new zzf(this.zznb.getAddress(), this.zznb, (zzcm) new zzel(this)));
    }
}

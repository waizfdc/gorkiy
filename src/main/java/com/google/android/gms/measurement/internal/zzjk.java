package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzjk implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzix zzb;

    zzjk(zzix zzix, zzm zzm) {
        this.zzb = zzix;
        this.zza = zzm;
    }

    public final void run() {
        zzfc zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzr().zzf().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzd.zzb(this.zza);
            this.zzb.zzaj();
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to send measurementEnabled to the service", e);
        }
    }
}

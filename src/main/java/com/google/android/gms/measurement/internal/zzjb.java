package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzjb implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzix zzb;

    zzjb(zzix zzix, zzm zzm) {
        this.zzb = zzix;
        this.zza = zzm;
    }

    public final void run() {
        zzfc zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            zzd.zzd(this.zza);
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service: remote exception", e);
        }
        this.zzb.zzaj();
    }
}

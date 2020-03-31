package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzn;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzjd implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzix zzc;

    zzjd(zzix zzix, zzm zzm, zzn zzn) {
        this.zzc = zzix;
        this.zza = zzm;
        this.zzb = zzn;
    }

    public final void run() {
        try {
            zzfc zzd = this.zzc.zzb;
            if (zzd == null) {
                this.zzc.zzr().zzf().zza("Failed to get app instance id");
                return;
            }
            String zzc2 = zzd.zzc(this.zza);
            if (zzc2 != null) {
                this.zzc.zzf().zza(zzc2);
                this.zzc.zzs().zzj.zza(zzc2);
            }
            this.zzc.zzaj();
            this.zzc.zzp().zza(this.zzb, zzc2);
        } catch (RemoteException e) {
            this.zzc.zzr().zzf().zza("Failed to get app instance id", e);
        } finally {
            this.zzc.zzp().zza(this.zzb, (String) null);
        }
    }
}

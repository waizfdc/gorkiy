package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zziz implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzkz zzb;
    private final /* synthetic */ zzm zzc;
    private final /* synthetic */ zzix zzd;

    zziz(zzix zzix, boolean z, zzkz zzkz, zzm zzm) {
        this.zzd = zzix;
        this.zza = z;
        this.zzb = zzkz;
        this.zzc = zzm;
    }

    public final void run() {
        zzfc zzd2 = this.zzd.zzb;
        if (zzd2 == null) {
            this.zzd.zzr().zzf().zza("Discarding data. Failed to set user property");
            return;
        }
        this.zzd.zza(zzd2, this.zza ? null : this.zzb, this.zzc);
        this.zzd.zzaj();
    }
}

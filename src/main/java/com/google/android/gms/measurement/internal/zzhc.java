package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzhc implements Runnable {
    private final /* synthetic */ zzkz zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zzgp zzc;

    zzhc(zzgp zzgp, zzkz zzkz, zzm zzm) {
        this.zzc = zzgp;
        this.zza = zzkz;
        this.zzb = zzm;
    }

    public final void run() {
        this.zzc.zza.zzo();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzb(this.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}

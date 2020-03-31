package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzgr implements Runnable {
    private final /* synthetic */ zzv zza;
    private final /* synthetic */ zzgp zzb;

    zzgr(zzgp zzgp, zzv zzv) {
        this.zzb = zzgp;
        this.zza = zzv;
    }

    public final void run() {
        this.zzb.zza.zzo();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzb(this.zza);
        } else {
            this.zzb.zza.zza(this.zza);
        }
    }
}

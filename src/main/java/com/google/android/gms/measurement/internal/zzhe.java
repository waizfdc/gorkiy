package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzhe implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgp zzb;

    zzhe(zzgp zzgp, zzm zzm) {
        this.zzb = zzgp;
        this.zza = zzm;
    }

    public final void run() {
        this.zzb.zza.zzo();
        this.zzb.zza.zzb(this.zza);
    }
}

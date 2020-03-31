package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzgy implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgp zzb;

    zzgy(zzgp zzgp, zzm zzm) {
        this.zzb = zzgp;
        this.zza = zzm;
    }

    public final void run() {
        this.zzb.zza.zzo();
        this.zzb.zza.zza(this.zza);
    }
}

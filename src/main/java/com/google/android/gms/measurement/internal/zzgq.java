package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzgq implements Runnable {
    private final /* synthetic */ zzhq zza;
    private final /* synthetic */ zzgo zzb;

    zzgq(zzgo zzgo, zzhq zzhq) {
        this.zzb = zzgo;
        this.zza = zzhq;
    }

    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}

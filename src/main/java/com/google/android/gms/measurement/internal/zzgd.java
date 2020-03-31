package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzgd implements Runnable {
    private final /* synthetic */ zzgo zza;
    private final /* synthetic */ zzfk zzb;

    zzgd(zzge zzge, zzgo zzgo, zzfk zzfk) {
        this.zza = zzgo;
        this.zzb = zzfk;
    }

    public final void run() {
        if (this.zza.zzf() == null) {
            this.zzb.zzf().zza("Install Referrer Reporter is null");
        } else {
            this.zza.zzf().zza();
        }
    }
}

package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzik implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhp zzb;

    zzik(zzhp zzhp, long j) {
        this.zzb = zzhp;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzs().zzk.zza(this.zza);
        this.zzb.zzr().zzw().zza("Minimum session duration set", Long.valueOf(this.zza));
    }
}

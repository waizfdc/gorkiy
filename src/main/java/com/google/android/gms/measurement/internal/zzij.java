package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzij implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhp zzb;

    zzij(zzhp zzhp, long j) {
        this.zzb = zzhp;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzs().zzl.zza(this.zza);
        this.zzb.zzr().zzw().zza("Session timeout duration set", Long.valueOf(this.zza));
    }
}

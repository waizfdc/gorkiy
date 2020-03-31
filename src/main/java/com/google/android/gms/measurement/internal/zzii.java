package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzii implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhp zzb;

    zzii(zzhp zzhp, boolean z) {
        this.zzb = zzhp;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzd(this.zza);
    }
}

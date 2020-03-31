package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzhx implements Runnable {
    private final /* synthetic */ zzho zza;
    private final /* synthetic */ zzhp zzb;

    zzhx(zzhp zzhp, zzho zzho) {
        this.zzb = zzhp;
        this.zza = zzho;
    }

    public final void run() {
        this.zzb.zza(this.zza);
    }
}

package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzfu implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzfr zzb;

    zzfu(zzfr zzfr, boolean z) {
        this.zzb = zzfr;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzb.zza(this.zza);
    }
}

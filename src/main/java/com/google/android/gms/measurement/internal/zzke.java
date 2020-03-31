package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzke implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzkc zzb;

    zzke(zzkc zzkc, long j) {
        this.zzb = zzkc;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzb(this.zza);
    }
}

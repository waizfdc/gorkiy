package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzkb implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzkc zzb;

    zzkb(zzkc zzkc, long j) {
        this.zzb = zzkc;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zza(this.zza);
    }
}

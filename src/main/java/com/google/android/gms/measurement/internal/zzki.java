package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzki implements Runnable {
    long zza;
    final /* synthetic */ zzkd zzb;

    zzki(zzkd zzkd, long j) {
        this.zzb = zzkd;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zza.zzq().zza(new zzkh(this));
    }
}

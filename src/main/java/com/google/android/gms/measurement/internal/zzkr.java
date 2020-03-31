package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzkr implements Runnable {
    private final /* synthetic */ zzkx zza;
    private final /* synthetic */ zzks zzb;

    zzkr(zzks zzks, zzkx zzkx) {
        this.zzb = zzks;
        this.zza = zzkx;
    }

    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}

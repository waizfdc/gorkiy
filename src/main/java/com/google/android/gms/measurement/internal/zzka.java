package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzka implements Runnable {
    private final /* synthetic */ zzks zza;
    private final /* synthetic */ Runnable zzb;

    zzka(zzjv zzjv, zzks zzks, Runnable runnable) {
        this.zza = zzks;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzo();
        this.zza.zza(this.zzb);
        this.zza.zzl();
    }
}

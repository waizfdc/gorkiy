package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zziy implements Runnable {
    private final /* synthetic */ zzit zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zziw zzc;

    zziy(zziw zziw, zzit zzit, long j) {
        this.zzc = zziw;
        this.zza = zzit;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zza(this.zza, false, this.zzb);
        this.zzc.zza = null;
        this.zzc.zzh().zza((zzit) null);
    }
}

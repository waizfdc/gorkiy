package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzjs implements Runnable {
    private final /* synthetic */ zzfc zza;
    private final /* synthetic */ zzjp zzb;

    zzjs(zzjp zzjp, zzfc zzfc) {
        this.zzb = zzjp;
        this.zza = zzfc;
    }

    public final void run() {
        synchronized (this.zzb) {
            boolean unused = this.zzb.zzb = false;
            if (!this.zzb.zza.zzab()) {
                this.zzb.zza.zzr().zzx().zza("Connected to service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}

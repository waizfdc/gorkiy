package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzju implements Runnable {
    private final /* synthetic */ zzfc zza;
    private final /* synthetic */ zzjp zzb;

    zzju(zzjp zzjp, zzfc zzfc) {
        this.zzb = zzjp;
        this.zza = zzfc;
    }

    public final void run() {
        synchronized (this.zzb) {
            boolean unused = this.zzb.zzb = false;
            if (!this.zzb.zza.zzab()) {
                this.zzb.zza.zzr().zzw().zza("Connected to remote service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}

package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzai implements Runnable {
    private final /* synthetic */ zzhh zza;
    private final /* synthetic */ zzaf zzb;

    zzai(zzaf zzaf, zzhh zzhh) {
        this.zzb = zzaf;
        this.zza = zzhh;
    }

    public final void run() {
        this.zza.zzu();
        if (zzw.zza()) {
            this.zza.zzq().zza(this);
            return;
        }
        boolean zzb2 = this.zzb.zzb();
        long unused = this.zzb.zzd = 0;
        if (zzb2) {
            this.zzb.zza();
        }
    }
}

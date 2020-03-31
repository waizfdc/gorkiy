package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzkn extends zzaf {
    private final /* synthetic */ zzks zza;
    private final /* synthetic */ zzko zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzkn(zzko zzko, zzhh zzhh, zzks zzks) {
        super(zzhh);
        this.zzb = zzko;
        this.zza = zzks;
    }

    public final void zza() {
        this.zzb.zzf();
        this.zzb.zzr().zzx().zza("Starting upload from DelayedRunnable");
        this.zza.zzl();
    }
}

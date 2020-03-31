package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzhd implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzgp zze;

    zzhd(zzgp zzgp, String str, String str2, String str3, long j) {
        this.zze = zzgp;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    public final void run() {
        String str = this.zza;
        if (str == null) {
            this.zze.zza.zzs().zzv().zza(this.zzb, (zzit) null);
            return;
        }
        this.zze.zza.zzs().zzv().zza(this.zzb, new zzit(this.zzc, str, this.zzd));
    }
}

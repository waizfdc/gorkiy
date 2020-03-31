package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final /* synthetic */ class zzhs implements Runnable {
    private final zzhp zza;

    zzhs(zzhp zzhp) {
        this.zza = zzhp;
    }

    public final void run() {
        zzhp zzhp = this.zza;
        zzhp.zzd();
        if (zzhp.zzs().zzu.zza()) {
            zzhp.zzr().zzw().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long zza2 = zzhp.zzs().zzv.zza();
        zzhp.zzs().zzv.zza(1 + zza2);
        if (zza2 >= 5) {
            zzhp.zzr().zzi().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzhp.zzs().zzu.zza(true);
            return;
        }
        zzhp.zzx.zzai();
    }
}

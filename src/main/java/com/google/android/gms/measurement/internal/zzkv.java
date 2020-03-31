package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzkv implements Callable<String> {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzks zzb;

    zzkv(zzks zzks, zzm zzm) {
        this.zzb = zzks;
        this.zza = zzm;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzg zzc = this.zzb.zzc(this.zza);
        if (zzc != null) {
            return zzc.zzd();
        }
        this.zzb.zzr().zzi().zza("App info was null when attempting to get app instance id");
        return null;
    }
}

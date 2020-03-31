package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzgs implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgp zzb;

    zzgs(zzgp zzgp, zzm zzm) {
        this.zzb = zzgp;
        this.zza = zzm;
    }

    public final void run() {
        this.zzb.zza.zzo();
        zzks zza2 = this.zzb.zza;
        zzm zzm = this.zza;
        zza2.zzq().zzd();
        zza2.zzk();
        Preconditions.checkNotEmpty(zzm.zza);
        zza2.zzc(zzm);
    }
}

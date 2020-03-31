package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzle;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzhy implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhp zzb;

    zzhy(zzhp zzhp, long j) {
        this.zzb = zzhp;
        this.zza = j;
    }

    public final void run() {
        zzhp zzhp = this.zzb;
        long j = this.zza;
        zzhp.zzd();
        zzhp.zzb();
        zzhp.zzw();
        zzhp.zzr().zzw().zza("Resetting analytics data (FE)");
        zzkc zzk = zzhp.zzk();
        zzk.zzd();
        zzk.zzb.zza();
        boolean zzab = zzhp.zzx.zzab();
        zzft zzs = zzhp.zzs();
        zzs.zzh.zza(j);
        if (!TextUtils.isEmpty(zzs.zzs().zzw.zza())) {
            zzs.zzw.zza(null);
        }
        if (zzle.zzb() && zzs.zzt().zza(zzap.zzcr)) {
            zzs.zzq.zza(0);
        }
        if (!zzs.zzt().zzg()) {
            zzs.zzc(!zzab);
        }
        zzhp.zzh().zzad();
        if (zzle.zzb() && zzhp.zzt().zza(zzap.zzcr)) {
            zzhp.zzk().zza.zza();
        }
        zzhp.zzb = !zzab;
        this.zzb.zzh().zza(new AtomicReference());
    }
}

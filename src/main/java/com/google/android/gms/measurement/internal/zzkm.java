package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzka;
import com.google.android.gms.internal.measurement.zzle;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzkm {
    final /* synthetic */ zzkc zza;

    zzkm(zzkc zzkc) {
        this.zza = zzkc;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        if (zzle.zzb() && this.zza.zzt().zza(zzap.zzay)) {
            this.zza.zzd();
            if (this.zza.zzs().zza(this.zza.zzm().currentTimeMillis())) {
                this.zza.zzs().zzm.zza(true);
                if (Build.VERSION.SDK_INT >= 16) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                    ActivityManager.getMyMemoryState(runningAppProcessInfo);
                    if (runningAppProcessInfo.importance == 100) {
                        this.zza.zzr().zzx().zza("Detected application was in foreground");
                        zzb(this.zza.zzm().currentTimeMillis(), false);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j, boolean z) {
        this.zza.zzd();
        this.zza.zzac();
        if (this.zza.zzs().zza(j)) {
            this.zza.zzs().zzm.zza(true);
            this.zza.zzs().zzr.zza(0);
        }
        if (z && this.zza.zzt().zza(zzap.zzat)) {
            this.zza.zzs().zzq.zza(j);
        }
        if (this.zza.zzs().zzm.zza()) {
            zzb(j, z);
        }
    }

    private final void zzb(long j, boolean z) {
        this.zza.zzd();
        if (zzle.zzb() && this.zza.zzt().zza(zzap.zzay)) {
            if (this.zza.zzx.zzab()) {
                this.zza.zzs().zzq.zza(j);
            } else {
                return;
            }
        }
        this.zza.zzr().zzx().zza("Session started, time", Long.valueOf(this.zza.zzm().elapsedRealtime()));
        Long l = null;
        if (this.zza.zzt().zza(zzap.zzar)) {
            l = Long.valueOf(j / 1000);
        }
        this.zza.zzf().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", l, j);
        this.zza.zzs().zzm.zza(false);
        Bundle bundle = new Bundle();
        if (this.zza.zzt().zza(zzap.zzar)) {
            bundle.putLong("_sid", l.longValue());
        }
        if (this.zza.zzt().zza(zzap.zzcj) && z) {
            bundle.putLong("_aib", 1);
        }
        this.zza.zzf().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_s", j, bundle);
        if (zzka.zzb() && this.zza.zzt().zza(zzap.zzcq)) {
            String zza2 = this.zza.zzs().zzw.zza();
            if (!TextUtils.isEmpty(zza2)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", zza2);
                this.zza.zzf().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ssr", j, bundle2);
            }
        }
        if (!zzle.zzb() || !this.zza.zzt().zza(zzap.zzay)) {
            this.zza.zzs().zzq.zza(j);
        }
    }
}

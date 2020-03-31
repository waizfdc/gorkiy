package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzkm;
import com.google.android.gms.internal.measurement.zzle;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzkk {
    private long zza;
    private long zzb;
    private final zzaf zzc = new zzkj(this, this.zzd.zzx);
    private final /* synthetic */ zzkc zzd;

    public zzkk(zzkc zzkc) {
        this.zzd = zzkc;
        long elapsedRealtime = zzkc.zzm().elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzd.zzd();
        this.zzc.zzc();
        this.zza = j;
        this.zzb = j;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(long j) {
        this.zzc.zzc();
        if (this.zza != 0) {
            this.zzd.zzs().zzr.zza(this.zzd.zzs().zzr.zza() + (j - this.zza));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zzc();
        this.zza = 0;
        this.zzb = 0;
    }

    /* access modifiers changed from: private */
    public final void zzc() {
        this.zzd.zzd();
        zza(false, false, this.zzd.zzm().elapsedRealtime());
        this.zzd.zze().zza(this.zzd.zzm().elapsedRealtime());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, android.os.Bundle, boolean):void
     arg types: [com.google.android.gms.measurement.internal.zzit, android.os.Bundle, int]
     candidates:
      com.google.android.gms.measurement.internal.zziw.zza(android.app.Activity, com.google.android.gms.measurement.internal.zzit, boolean):void
      com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, boolean, long):void
      com.google.android.gms.measurement.internal.zziw.zza(android.app.Activity, java.lang.String, java.lang.String):void
      com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, android.os.Bundle, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    public final boolean zza(boolean z, boolean z2, long j) {
        this.zzd.zzd();
        this.zzd.zzw();
        if (!zzkm.zzb() || !this.zzd.zzt().zza(zzap.zzcw)) {
            j = this.zzd.zzm().elapsedRealtime();
        }
        if (!zzle.zzb() || !this.zzd.zzt().zza(zzap.zzcr) || this.zzd.zzx.zzab()) {
            this.zzd.zzs().zzq.zza(this.zzd.zzm().currentTimeMillis());
        }
        long j2 = j - this.zza;
        if (z || j2 >= 1000) {
            if (this.zzd.zzt().zza(zzap.zzba) && !z2) {
                j2 = zzb();
            }
            this.zzd.zzs().zzr.zza(j2);
            this.zzd.zzr().zzx().zza("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            zziw.zza(this.zzd.zzi().zzab(), bundle, true);
            if (this.zzd.zzt().zza(zzap.zzba) && !this.zzd.zzt().zza(zzap.zzbb) && z2) {
                bundle.putLong("_fr", 1);
            }
            if (!this.zzd.zzt().zza(zzap.zzbb) || !z2) {
                this.zzd.zzf().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_e", bundle);
            }
            this.zza = j;
            this.zzc.zzc();
            this.zzc.zza(Math.max(0L, 3600000 - this.zzd.zzs().zzr.zza()));
            return true;
        }
        this.zzd.zzr().zzx().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }

    /* access modifiers changed from: package-private */
    public final long zzb() {
        long elapsedRealtime = this.zzd.zzm().elapsedRealtime();
        long j = elapsedRealtime - this.zzb;
        this.zzb = elapsedRealtime;
        return j;
    }
}

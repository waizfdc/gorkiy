package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzb extends zzf {
    private final Map<String, Long> zza = new ArrayMap();
    private final Map<String, Integer> zzb = new ArrayMap();
    private long zzc;

    public zzb(zzgo zzgo) {
        super(zzgo);
    }

    public final void zza(String str, long j) {
        if (str == null || str.length() == 0) {
            zzr().zzf().zza("Ad unit id must be a non-empty string");
        } else {
            zzq().zza(new zza(this, str, j));
        }
    }

    /* access modifiers changed from: private */
    public final void zzc(String str, long j) {
        zzb();
        zzd();
        Preconditions.checkNotEmpty(str);
        if (this.zzb.isEmpty()) {
            this.zzc = j;
        }
        Integer num = this.zzb.get(str);
        if (num != null) {
            this.zzb.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.zzb.size() >= 100) {
            zzr().zzi().zza("Too many ads visible");
        } else {
            this.zzb.put(str, 1);
            this.zza.put(str, Long.valueOf(j));
        }
    }

    public final void zzb(String str, long j) {
        if (str == null || str.length() == 0) {
            zzr().zzf().zza("Ad unit id must be a non-empty string");
        } else {
            zzq().zza(new zzd(this, str, j));
        }
    }

    /* access modifiers changed from: private */
    public final void zzd(String str, long j) {
        zzb();
        zzd();
        Preconditions.checkNotEmpty(str);
        Integer num = this.zzb.get(str);
        if (num != null) {
            zzit zzab = zzi().zzab();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.zzb.remove(str);
                Long l = this.zza.get(str);
                if (l == null) {
                    zzr().zzf().zza("First ad unit exposure time was never set");
                } else {
                    this.zza.remove(str);
                    zza(str, j - l.longValue(), zzab);
                }
                if (this.zzb.isEmpty()) {
                    long j2 = this.zzc;
                    if (j2 == 0) {
                        zzr().zzf().zza("First ad exposure time was never set");
                        return;
                    }
                    zza(j - j2, zzab);
                    this.zzc = 0;
                    return;
                }
                return;
            }
            this.zzb.put(str, Integer.valueOf(intValue));
            return;
        }
        zzr().zzf().zza("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, android.os.Bundle, boolean):void
     arg types: [com.google.android.gms.measurement.internal.zzit, android.os.Bundle, int]
     candidates:
      com.google.android.gms.measurement.internal.zziw.zza(android.app.Activity, com.google.android.gms.measurement.internal.zzit, boolean):void
      com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, boolean, long):void
      com.google.android.gms.measurement.internal.zziw.zza(android.app.Activity, java.lang.String, java.lang.String):void
      com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, android.os.Bundle, boolean):void */
    private final void zza(long j, zzit zzit) {
        if (zzit == null) {
            zzr().zzx().zza("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            zzr().zzx().zza("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zziw.zza(zzit, bundle, true);
            zzf().zza("am", "_xa", bundle);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, android.os.Bundle, boolean):void
     arg types: [com.google.android.gms.measurement.internal.zzit, android.os.Bundle, int]
     candidates:
      com.google.android.gms.measurement.internal.zziw.zza(android.app.Activity, com.google.android.gms.measurement.internal.zzit, boolean):void
      com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, boolean, long):void
      com.google.android.gms.measurement.internal.zziw.zza(android.app.Activity, java.lang.String, java.lang.String):void
      com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, android.os.Bundle, boolean):void */
    private final void zza(String str, long j, zzit zzit) {
        if (zzit == null) {
            zzr().zzx().zza("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            zzr().zzx().zza("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            zziw.zza(zzit, bundle, true);
            zzf().zza("am", "_xu", bundle);
        }
    }

    public final void zza(long j) {
        zzit zzab = zzi().zzab();
        for (String next : this.zza.keySet()) {
            zza(next, j - this.zza.get(next).longValue(), zzab);
        }
        if (!this.zza.isEmpty()) {
            zza(j - this.zzc, zzab);
        }
        zzb(j);
    }

    /* access modifiers changed from: private */
    public final void zzb(long j) {
        for (String put : this.zza.keySet()) {
            this.zza.put(put, Long.valueOf(j));
        }
        if (!this.zza.isEmpty()) {
            this.zzc = j;
        }
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzhp zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzfd zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzix zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zziw zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfg zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzkc zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ zzah zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzfi zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzla zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzgh zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfk zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzft zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzw zzu() {
        return super.zzu();
    }
}

package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zziw extends zze {
    protected zzit zza;
    private volatile zzit zzb;
    private zzit zzc;
    private final Map<Activity, zzit> zzd = new ConcurrentHashMap();
    private zzit zze;
    private String zzf;

    public zziw(zzgo zzgo) {
        super(zzgo);
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    public final zzit zzab() {
        zzw();
        zzd();
        return this.zza;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zziw.zza(android.app.Activity, com.google.android.gms.measurement.internal.zzit, boolean):void
     arg types: [android.app.Activity, com.google.android.gms.measurement.internal.zzit, int]
     candidates:
      com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, android.os.Bundle, boolean):void
      com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, boolean, long):void
      com.google.android.gms.measurement.internal.zziw.zza(android.app.Activity, java.lang.String, java.lang.String):void
      com.google.android.gms.measurement.internal.zziw.zza(android.app.Activity, com.google.android.gms.measurement.internal.zzit, boolean):void */
    public final void zza(Activity activity, String str, String str2) {
        if (this.zzb == null) {
            zzr().zzk().zza("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzd.get(activity) == null) {
            zzr().zzk().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zza(activity.getClass().getCanonicalName());
            }
            boolean equals = this.zzb.zzb.equals(str2);
            boolean zzc2 = zzla.zzc(this.zzb.zza, str);
            if (equals && zzc2) {
                zzr().zzk().zza("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzr().zzk().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                zzr().zzx().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzit zzit = new zzit(str, str2, zzp().zzg());
                this.zzd.put(activity, zzit);
                zza(activity, zzit, true);
            } else {
                zzr().zzk().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    public final zzit zzac() {
        zzb();
        return this.zzb;
    }

    private final void zza(Activity activity, zzit zzit, boolean z) {
        zzit zzit2 = this.zzb == null ? this.zzc : this.zzb;
        zzit zzit3 = zzit.zzb == null ? new zzit(zzit.zza, zza(activity.getClass().getCanonicalName()), zzit.zzc) : zzit;
        this.zzc = this.zzb;
        this.zzb = zzit3;
        zzq().zza(new zziv(this, z, zzm().elapsedRealtime(), zzit2, zzit3));
    }

    /* access modifiers changed from: private */
    public final void zza(zzit zzit, boolean z, long j) {
        zze().zza(zzm().elapsedRealtime());
        if (zzk().zza(zzit.zzd, z, j)) {
            zzit.zzd = false;
        }
    }

    public static void zza(zzit zzit, Bundle bundle, boolean z) {
        if (bundle != null && zzit != null && (!bundle.containsKey("_sc") || z)) {
            if (zzit.zza != null) {
                bundle.putString("_sn", zzit.zza);
            } else {
                bundle.remove("_sn");
            }
            bundle.putString("_sc", zzit.zzb);
            bundle.putLong("_si", zzit.zzc);
        } else if (bundle != null && zzit == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public final void zza(String str, zzit zzit) {
        zzd();
        synchronized (this) {
            if (this.zzf == null || this.zzf.equals(str) || zzit != null) {
                this.zzf = str;
                this.zze = zzit;
            }
        }
    }

    private static String zza(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    private final zzit zzd(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzit zzit = this.zzd.get(activity);
        if (zzit != null) {
            return zzit;
        }
        zzit zzit2 = new zzit(null, zza(activity.getClass().getCanonicalName()), zzp().zzg());
        this.zzd.put(activity, zzit2);
        return zzit2;
    }

    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzd.put(activity, new zzit(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zziw.zza(android.app.Activity, com.google.android.gms.measurement.internal.zzit, boolean):void
     arg types: [android.app.Activity, com.google.android.gms.measurement.internal.zzit, int]
     candidates:
      com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, android.os.Bundle, boolean):void
      com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, boolean, long):void
      com.google.android.gms.measurement.internal.zziw.zza(android.app.Activity, java.lang.String, java.lang.String):void
      com.google.android.gms.measurement.internal.zziw.zza(android.app.Activity, com.google.android.gms.measurement.internal.zzit, boolean):void */
    public final void zza(Activity activity) {
        zza(activity, zzd(activity), false);
        zzb zze2 = zze();
        zze2.zzq().zza(new zzc(zze2, zze2.zzm().elapsedRealtime()));
    }

    public final void zzb(Activity activity) {
        zzit zzd2 = zzd(activity);
        this.zzc = this.zzb;
        this.zzb = null;
        zzq().zza(new zziy(this, zzd2, zzm().elapsedRealtime()));
    }

    public final void zzb(Activity activity, Bundle bundle) {
        zzit zzit;
        if (bundle != null && (zzit = this.zzd.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzit.zzc);
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, zzit.zza);
            bundle2.putString("referrer_name", zzit.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    public final void zzc(Activity activity) {
        this.zzd.remove(activity);
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

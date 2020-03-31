package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzka;
import com.google.android.gms.internal.measurement.zzkt;
import com.google.android.gms.internal.measurement.zzv;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.DebugKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public class zzgo implements zzhh {
    private static volatile zzgo zza;
    private long zzaa;
    private volatile Boolean zzab;
    private Boolean zzac;
    private Boolean zzad;
    private int zzae;
    private AtomicInteger zzaf = new AtomicInteger(0);
    private final long zzag;
    private final Context zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final boolean zzf;
    private final zzw zzg;
    private final zzx zzh;
    private final zzft zzi;
    private final zzfk zzj;
    private final zzgh zzk;
    private final zzkc zzl;
    private final zzla zzm;
    private final zzfi zzn;
    private final Clock zzo;
    private final zziw zzp;
    private final zzhp zzq;
    private final zzb zzr;
    private final zzin zzs;
    private zzfg zzt;
    private zzix zzu;
    private zzah zzv;
    private zzfd zzw;
    private zzfz zzx;
    private boolean zzy = false;
    private Boolean zzz;

    private zzgo(zzhq zzhq) {
        boolean z = false;
        Preconditions.checkNotNull(zzhq);
        zzw zzw2 = new zzw(zzhq.zza);
        this.zzg = zzw2;
        zzfa.zza = zzw2;
        this.zzb = zzhq.zza;
        this.zzc = zzhq.zzb;
        this.zzd = zzhq.zzc;
        this.zze = zzhq.zzd;
        this.zzf = zzhq.zzh;
        this.zzab = zzhq.zze;
        zzv zzv2 = zzhq.zzg;
        if (!(zzv2 == null || zzv2.zzg == null)) {
            Object obj = zzv2.zzg.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzac = (Boolean) obj;
            }
            Object obj2 = zzv2.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzad = (Boolean) obj2;
            }
        }
        zzcl.zza(this.zzb);
        Clock instance = DefaultClock.getInstance();
        this.zzo = instance;
        this.zzag = instance.currentTimeMillis();
        this.zzh = new zzx(this);
        zzft zzft = new zzft(this);
        zzft.zzab();
        this.zzi = zzft;
        zzfk zzfk = new zzfk(this);
        zzfk.zzab();
        this.zzj = zzfk;
        zzla zzla = new zzla(this);
        zzla.zzab();
        this.zzm = zzla;
        zzfi zzfi = new zzfi(this);
        zzfi.zzab();
        this.zzn = zzfi;
        this.zzr = new zzb(this);
        zziw zziw = new zziw(this);
        zziw.zzx();
        this.zzp = zziw;
        zzhp zzhp = new zzhp(this);
        zzhp.zzx();
        this.zzq = zzhp;
        zzkc zzkc = new zzkc(this);
        zzkc.zzx();
        this.zzl = zzkc;
        zzin zzin = new zzin(this);
        zzin.zzab();
        this.zzs = zzin;
        zzgh zzgh = new zzgh(this);
        zzgh.zzab();
        this.zzk = zzgh;
        if (!(zzhq.zzg == null || zzhq.zzg.zzb == 0)) {
            z = true;
        }
        boolean z2 = !z;
        if (this.zzb.getApplicationContext() instanceof Application) {
            zzhp zzh2 = zzh();
            if (zzh2.zzn().getApplicationContext() instanceof Application) {
                Application application = (Application) zzh2.zzn().getApplicationContext();
                if (zzh2.zza == null) {
                    zzh2.zza = new zzim(zzh2, null);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(zzh2.zza);
                    application.registerActivityLifecycleCallbacks(zzh2.zza);
                    zzh2.zzr().zzx().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzr().zzi().zza("Application context is not an Application");
        }
        this.zzk.zza(new zzgq(this, zzhq));
    }

    /* access modifiers changed from: package-private */
    public final void zzae() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzhq zzhq) {
        zzfm zzfm;
        String str;
        zzq().zzd();
        zzah zzah = new zzah(this);
        zzah.zzab();
        this.zzv = zzah;
        zzfd zzfd = new zzfd(this, zzhq.zzf);
        zzfd.zzx();
        this.zzw = zzfd;
        zzfg zzfg = new zzfg(this);
        zzfg.zzx();
        this.zzt = zzfg;
        zzix zzix = new zzix(this);
        zzix.zzx();
        this.zzu = zzix;
        this.zzm.zzac();
        this.zzi.zzac();
        this.zzx = new zzfz(this);
        this.zzw.zzy();
        zzr().zzv().zza("App measurement initialized, version", Long.valueOf(this.zzh.zze()));
        zzr().zzv().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzab2 = zzfd.zzab();
        if (TextUtils.isEmpty(this.zzc)) {
            if (zzi().zzf(zzab2)) {
                zzfm = zzr().zzv();
                str = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzfm zzv2 = zzr().zzv();
                String valueOf = String.valueOf(zzab2);
                zzfm zzfm2 = zzv2;
                str = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
                zzfm = zzfm2;
            }
            zzfm.zza(str);
        }
        zzr().zzw().zza("Debug-level message logging enabled");
        if (this.zzae != this.zzaf.get()) {
            zzr().zzf().zza("Not all components initialized", Integer.valueOf(this.zzae), Integer.valueOf(this.zzaf.get()));
        }
        this.zzy = true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzla.zza(android.content.Context, boolean):boolean
     arg types: [android.content.Context, int]
     candidates:
      com.google.android.gms.measurement.internal.zzla.zza(long, long):long
      com.google.android.gms.measurement.internal.zzla.zza(android.os.Bundle, int):boolean
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.Boolean, java.lang.Boolean):boolean
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, java.lang.String[]):boolean
      com.google.android.gms.measurement.internal.zzla.zza(java.util.List<java.lang.String>, java.util.List<java.lang.String>):boolean
      com.google.android.gms.measurement.internal.zzla.zza(android.content.Context, java.lang.String):long
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, java.lang.Object):java.lang.Object
      com.google.android.gms.measurement.internal.zzla.zza(android.os.Bundle, long):void
      com.google.android.gms.measurement.internal.zzla.zza(com.google.android.gms.internal.measurement.zzn, int):void
      com.google.android.gms.measurement.internal.zzla.zza(com.google.android.gms.internal.measurement.zzn, long):void
      com.google.android.gms.measurement.internal.zzla.zza(com.google.android.gms.internal.measurement.zzn, android.os.Bundle):void
      com.google.android.gms.measurement.internal.zzla.zza(com.google.android.gms.internal.measurement.zzn, java.lang.String):void
      com.google.android.gms.measurement.internal.zzla.zza(com.google.android.gms.internal.measurement.zzn, java.util.ArrayList<android.os.Bundle>):void
      com.google.android.gms.measurement.internal.zzla.zza(com.google.android.gms.internal.measurement.zzn, boolean):void
      com.google.android.gms.measurement.internal.zzla.zza(com.google.android.gms.internal.measurement.zzn, byte[]):void
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, double):boolean
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, java.lang.String):boolean
      com.google.android.gms.measurement.internal.zzla.zza(android.content.Context, boolean):boolean */
    /* access modifiers changed from: protected */
    public final void zza() {
        zzq().zzd();
        if (zzc().zzc.zza() == 0) {
            zzc().zzc.zza(this.zzo.currentTimeMillis());
        }
        if (Long.valueOf(zzc().zzh.zza()).longValue() == 0) {
            zzr().zzx().zza("Persisting first open", Long.valueOf(this.zzag));
            zzc().zzh.zza(this.zzag);
        }
        if (zzah()) {
            if (!TextUtils.isEmpty(zzy().zzac()) || !TextUtils.isEmpty(zzy().zzad())) {
                zzi();
                if (zzla.zza(zzy().zzac(), zzc().zzh(), zzy().zzad(), zzc().zzi())) {
                    zzr().zzv().zza("Rechecking which service to use due to a GMP App Id change");
                    zzc().zzk();
                    zzk().zzab();
                    this.zzu.zzah();
                    this.zzu.zzaf();
                    zzc().zzh.zza(this.zzag);
                    zzc().zzj.zza(null);
                }
                zzc().zzc(zzy().zzac());
                zzc().zzd(zzy().zzad());
            }
            zzh().zza(zzc().zzj.zza());
            if (zzka.zzb() && this.zzh.zza(zzap.zzcq) && !zzi().zzv() && !TextUtils.isEmpty(zzc().zzw.zza())) {
                zzr().zzi().zza("Remote config removed with active feature rollouts");
                zzc().zzw.zza(null);
            }
            if (!TextUtils.isEmpty(zzy().zzac()) || !TextUtils.isEmpty(zzy().zzad())) {
                boolean zzab2 = zzab();
                if (!zzc().zzx() && !this.zzh.zzg()) {
                    zzc().zzc(!zzab2);
                }
                if (zzab2) {
                    zzh().zzai();
                }
                zze().zza.zza();
                zzw().zza(new AtomicReference());
            }
        } else if (zzab()) {
            if (!zzi().zzd("android.permission.INTERNET")) {
                zzr().zzf().zza("App is missing INTERNET permission");
            }
            if (!zzi().zzd("android.permission.ACCESS_NETWORK_STATE")) {
                zzr().zzf().zza("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!Wrappers.packageManager(this.zzb).isCallerInstantApp() && !this.zzh.zzx()) {
                if (!zzge.zza(this.zzb)) {
                    zzr().zzf().zza("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzla.zza(this.zzb, false)) {
                    zzr().zzf().zza("AppMeasurementService not registered/enabled");
                }
            }
            zzr().zzf().zza("Uploading is not possible. App measurement disabled");
        }
        zzc().zzo.zza(this.zzh.zza(zzap.zzbi));
        zzc().zzp.zza(this.zzh.zza(zzap.zzbj));
    }

    public final zzw zzu() {
        return this.zzg;
    }

    public final zzx zzb() {
        return this.zzh;
    }

    public final zzft zzc() {
        zza((zzhf) this.zzi);
        return this.zzi;
    }

    public final zzfk zzr() {
        zzb(this.zzj);
        return this.zzj;
    }

    public final zzfk zzd() {
        zzfk zzfk = this.zzj;
        if (zzfk == null || !zzfk.zzz()) {
            return null;
        }
        return this.zzj;
    }

    public final zzgh zzq() {
        zzb(this.zzk);
        return this.zzk;
    }

    public final zzkc zze() {
        zzb(this.zzl);
        return this.zzl;
    }

    public final zzfz zzf() {
        return this.zzx;
    }

    /* access modifiers changed from: package-private */
    public final zzgh zzg() {
        return this.zzk;
    }

    public final zzhp zzh() {
        zzb(this.zzq);
        return this.zzq;
    }

    public final zzla zzi() {
        zza((zzhf) this.zzm);
        return this.zzm;
    }

    public final zzfi zzj() {
        zza((zzhf) this.zzn);
        return this.zzn;
    }

    public final zzfg zzk() {
        zzb(this.zzt);
        return this.zzt;
    }

    private final zzin zzaj() {
        zzb(this.zzs);
        return this.zzs;
    }

    public final Context zzn() {
        return this.zzb;
    }

    public final boolean zzl() {
        return TextUtils.isEmpty(this.zzc);
    }

    public final String zzo() {
        return this.zzc;
    }

    public final String zzp() {
        return this.zzd;
    }

    public final String zzs() {
        return this.zze;
    }

    public final boolean zzt() {
        return this.zzf;
    }

    public final Clock zzm() {
        return this.zzo;
    }

    public final zziw zzv() {
        zzb(this.zzp);
        return this.zzp;
    }

    public final zzix zzw() {
        zzb(this.zzu);
        return this.zzu;
    }

    public final zzah zzx() {
        zzb(this.zzv);
        return this.zzv;
    }

    public final zzfd zzy() {
        zzb(this.zzw);
        return this.zzw;
    }

    public final zzb zzz() {
        zzb zzb2 = this.zzr;
        if (zzb2 != null) {
            return zzb2;
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzgo zza(Context context, String str, String str2, Bundle bundle) {
        return zza(context, new zzv(0, 0, true, null, null, null, bundle));
    }

    public static zzgo zza(Context context, zzv zzv2) {
        if (zzv2 != null && (zzv2.zze == null || zzv2.zzf == null)) {
            zzv2 = new zzv(zzv2.zza, zzv2.zzb, zzv2.zzc, zzv2.zzd, null, null, zzv2.zzg);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzgo.class) {
                if (zza == null) {
                    zza = new zzgo(new zzhq(context, zzv2));
                }
            }
        } else if (!(zzv2 == null || zzv2.zzg == null || !zzv2.zzg.containsKey("dataCollectionDefaultEnabled"))) {
            zza.zza(zzv2.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        return zza;
    }

    private final void zzak() {
        if (!this.zzy) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    private static void zzb(zzhi zzhi) {
        if (zzhi == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzhi.zzz()) {
            String valueOf = String.valueOf(zzhi.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static void zzb(zze zze2) {
        if (zze2 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zze2.zzv()) {
            String valueOf = String.valueOf(zze2.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static void zza(zzhf zzhf) {
        if (zzhf == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        this.zzab = Boolean.valueOf(z);
    }

    public final boolean zzaa() {
        return this.zzab != null && this.zzab.booleanValue();
    }

    public final boolean zzab() {
        if (zzkt.zzb() && this.zzh.zza(zzap.zzcy)) {
            return zzac() == 0;
        }
        zzq().zzd();
        zzak();
        if (this.zzh.zzg()) {
            return false;
        }
        Boolean bool = this.zzad;
        if (bool != null && bool.booleanValue()) {
            return false;
        }
        Boolean zzv2 = zzc().zzv();
        if (zzv2 != null) {
            return zzv2.booleanValue();
        }
        Boolean zzh2 = this.zzh.zzh();
        if (zzh2 != null) {
            return zzh2.booleanValue();
        }
        Boolean bool2 = this.zzac;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        if (GoogleServices.isMeasurementExplicitlyDisabled()) {
            return false;
        }
        if (!this.zzh.zza(zzap.zzaz) || this.zzab == null) {
            return true;
        }
        return this.zzab.booleanValue();
    }

    public final int zzac() {
        zzq().zzd();
        if (this.zzh.zzg()) {
            return 1;
        }
        Boolean bool = this.zzad;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        Boolean zzv2 = zzc().zzv();
        if (zzv2 == null) {
            Boolean zzh2 = this.zzh.zzh();
            if (zzh2 == null) {
                Boolean bool2 = this.zzac;
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        return 0;
                    }
                    return 5;
                } else if (GoogleServices.isMeasurementExplicitlyDisabled()) {
                    return 6;
                } else {
                    if (!this.zzh.zza(zzap.zzaz) || this.zzab == null || this.zzab.booleanValue()) {
                        return 0;
                    }
                    return 7;
                }
            } else if (zzh2.booleanValue()) {
                return 0;
            } else {
                return 4;
            }
        } else if (zzv2.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    /* access modifiers changed from: package-private */
    public final long zzad() {
        Long valueOf = Long.valueOf(zzc().zzh.zza());
        if (valueOf.longValue() == 0) {
            return this.zzag;
        }
        return Math.min(this.zzag, valueOf.longValue());
    }

    /* access modifiers changed from: package-private */
    public final void zzaf() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzhi zzhi) {
        this.zzae++;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zze zze2) {
        this.zzae++;
    }

    /* access modifiers changed from: package-private */
    public final void zzag() {
        this.zzaf.incrementAndGet();
    }

    /* access modifiers changed from: protected */
    public final boolean zzah() {
        zzak();
        zzq().zzd();
        Boolean bool = this.zzz;
        if (bool == null || this.zzaa == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzo.elapsedRealtime() - this.zzaa) > 1000)) {
            this.zzaa = this.zzo.elapsedRealtime();
            boolean z = true;
            Boolean valueOf = Boolean.valueOf(zzi().zzd("android.permission.INTERNET") && zzi().zzd("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzb).isCallerInstantApp() || this.zzh.zzx() || (zzge.zza(this.zzb) && zzla.zza(this.zzb, false))));
            this.zzz = valueOf;
            if (valueOf.booleanValue()) {
                if (!zzi().zza(zzy().zzac(), zzy().zzad(), zzy().zzae()) && TextUtils.isEmpty(zzy().zzad())) {
                    z = false;
                }
                this.zzz = Boolean.valueOf(z);
            }
        }
        return this.zzz.booleanValue();
    }

    public final void zzai() {
        zzq().zzd();
        zzb(zzaj());
        String zzab2 = zzy().zzab();
        Pair<String, Boolean> zza2 = zzc().zza(zzab2);
        if (!this.zzh.zzi().booleanValue() || ((Boolean) zza2.second).booleanValue() || TextUtils.isEmpty((CharSequence) zza2.first)) {
            zzr().zzw().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
        } else if (!zzaj().zzg()) {
            zzr().zzi().zza("Network is not available for Deferred Deep Link request. Skipping");
        } else {
            zzla zzi2 = zzi();
            URL zza3 = zzi2.zza(zzy().zzt().zze(), zzab2, (String) zza2.first, zzc().zzv.zza() - 1);
            zzin zzaj = zzaj();
            zzgn zzgn = new zzgn(this);
            zzaj.zzd();
            zzaj.zzaa();
            Preconditions.checkNotNull(zza3);
            Preconditions.checkNotNull(zzgn);
            zzaj.zzq().zzb(new zzip(zzaj, zzab2, zza3, null, null, zzgn));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        boolean z = true;
        if (!((i == 200 || i == 204 || i == 304) && th == null)) {
            zzr().zzi().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        zzc().zzu.zza(true);
        if (bArr.length == 0) {
            zzr().zzw().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            String optString2 = jSONObject.optString("gclid", "");
            double optDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(optString)) {
                zzr().zzw().zza("Deferred Deep Link is empty.");
                return;
            }
            zzla zzi2 = zzi();
            zzi2.zzb();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = zzi2.zzn().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                zzr().zzi().zza("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            this.zzq.zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_cmp", bundle);
            zzla zzi3 = zzi();
            if (!TextUtils.isEmpty(optString) && zzi3.zza(optString, optDouble)) {
                zzi3.zzn().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
            }
        } catch (JSONException e) {
            zzr().zzf().zza("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }
}

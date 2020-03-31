package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzjp;
import com.google.android.gms.internal.measurement.zzka;
import com.google.android.gms.internal.measurement.zzkh;
import com.google.android.gms.internal.measurement.zzkt;
import com.google.android.gms.internal.measurement.zzle;
import com.google.android.gms.internal.measurement.zzmv;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzhp extends zze {
    protected zzim zza;
    protected boolean zzb = true;
    private zzho zzc;
    private final Set<zzhn> zzd = new CopyOnWriteArraySet();
    private boolean zze;
    private final AtomicReference<String> zzf = new AtomicReference<>();

    protected zzhp(zzgo zzgo) {
        super(zzgo);
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    public final void zzab() {
        if (zzn().getApplicationContext() instanceof Application) {
            ((Application) zzn().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzq().zza(atomicReference, 15000, "boolean test flag value", new zzhr(this, atomicReference));
    }

    public final String zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzq().zza(atomicReference, 15000, "String test flag value", new zzib(this, atomicReference));
    }

    public final Long zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzq().zza(atomicReference, 15000, "long test flag value", new zzid(this, atomicReference));
    }

    public final Integer zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzq().zza(atomicReference, 15000, "int test flag value", new zzig(this, atomicReference));
    }

    public final Double zzag() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzq().zza(atomicReference, 15000, "double test flag value", new zzif(this, atomicReference));
    }

    public final void zza(boolean z) {
        zzw();
        zzb();
        zzq().zza(new zzii(this, z));
    }

    public final void zzb(boolean z) {
        zzw();
        zzb();
        zzq().zza(new zzih(this, z));
    }

    /* access modifiers changed from: private */
    public final void zzd(boolean z) {
        zzd();
        zzb();
        zzw();
        zzr().zzw().zza("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzs().zzb(z);
        zzam();
    }

    /* access modifiers changed from: private */
    public final void zzam() {
        if (zzt().zza(zzap.zzbd)) {
            zzd();
            String zza2 = zzs().zzn.zza();
            if (zza2 != null) {
                if ("unset".equals(zza2)) {
                    zza(SettingsJsonConstants.APP_KEY, "_npa", (Object) null, zzm().currentTimeMillis());
                } else {
                    zza(SettingsJsonConstants.APP_KEY, "_npa", Long.valueOf("true".equals(zza2) ? 1 : 0), zzm().currentTimeMillis());
                }
            }
        }
        if (!this.zzx.zzab() || !this.zzb) {
            zzr().zzw().zza("Updating Scion state (FE)");
            zzh().zzac();
            return;
        }
        zzr().zzw().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzai();
        if (zzle.zzb() && zzt().zza(zzap.zzcr)) {
            zzk().zza.zza();
        }
        if (zzkh.zzb() && zzt().zza(zzap.zzcx)) {
            if (!(this.zzx.zzf().zza.zzc().zzi.zza() > 0)) {
                this.zzx.zzf().zza();
            }
        }
    }

    public final void zza(long j) {
        zzb();
        zzq().zza(new zzik(this, j));
    }

    public final void zzb(long j) {
        zzb();
        zzq().zza(new zzij(this, j));
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        zza(str, str2, bundle, false, true, zzm().currentTimeMillis());
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzm().currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, String str2, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, zzm().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, j, bundle, true, this.zzc == null || zzla.zze(str2), false, null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, int, boolean):java.lang.String
     arg types: [java.lang.String, int, int]
     candidates:
      com.google.android.gms.measurement.internal.zzla.zza(android.os.Bundle, java.lang.String, java.lang.Object):void
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, int, java.lang.String):boolean
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, java.lang.String, java.lang.String):boolean
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, java.lang.String[], java.lang.String):boolean
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, int, boolean):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, java.lang.String, android.os.Bundle, java.util.List<java.lang.String>, boolean, boolean):android.os.Bundle
     arg types: [java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean, int]
     candidates:
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, java.lang.String, java.lang.String, android.os.Bundle, java.util.List<java.lang.String>, boolean):void
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, java.lang.String, android.os.Bundle, java.util.List<java.lang.String>, boolean, boolean):android.os.Bundle */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, android.os.Bundle, boolean):void
     arg types: [com.google.android.gms.measurement.internal.zzit, android.os.Bundle, int]
     candidates:
      com.google.android.gms.measurement.internal.zziw.zza(android.app.Activity, com.google.android.gms.measurement.internal.zzit, boolean):void
      com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, boolean, long):void
      com.google.android.gms.measurement.internal.zziw.zza(android.app.Activity, java.lang.String, java.lang.String):void
      com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, android.os.Bundle, boolean):void */
    /* access modifiers changed from: protected */
    public final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        String str4;
        boolean z4;
        String str5;
        boolean z5;
        String str6;
        ArrayList arrayList;
        String str7;
        String str8;
        String str9;
        zzit zzit;
        int i;
        long j2;
        ArrayList arrayList2;
        Bundle bundle2;
        String str10;
        boolean z6;
        Class<?> cls;
        List<String> zzah;
        String str11 = str;
        String str12 = str2;
        Bundle bundle3 = bundle;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzd();
        zzw();
        if (!this.zzx.zzab()) {
            zzr().zzw().zza("Event not sent since app measurement is disabled");
        } else if (!zzt().zza(zzap.zzbl) || (zzah = zzg().zzah()) == null || zzah.contains(str12)) {
            int i2 = 0;
            if (!this.zze) {
                this.zze = true;
                try {
                    if (!this.zzx.zzt()) {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zzn().getClassLoader());
                    } else {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                    }
                    try {
                        cls.getDeclaredMethod("initialize", Context.class).invoke(null, zzn());
                    } catch (Exception e) {
                        zzr().zzi().zza("Failed to invoke Tag Manager's initialize() method", e);
                    }
                } catch (ClassNotFoundException unused) {
                    zzr().zzv().zza("Tag Manager is not found and thus will not be used");
                }
            }
            if (zzt().zza(zzap.zzca) && "_cmp".equals(str12) && bundle3.containsKey("gclid")) {
                zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lgclid", bundle3.getString("gclid"), zzm().currentTimeMillis());
            }
            if (z3) {
                zzu();
                if (!"_iap".equals(str12)) {
                    zzla zzi = this.zzx.zzi();
                    int i3 = 2;
                    if (zzi.zza(NotificationCompat.CATEGORY_EVENT, str12)) {
                        if (!zzi.zza(NotificationCompat.CATEGORY_EVENT, zzhj.zza, str12)) {
                            i3 = 13;
                        } else if (zzi.zza(NotificationCompat.CATEGORY_EVENT, 40, str12)) {
                            i3 = 0;
                        }
                    }
                    if (i3 != 0) {
                        zzr().zzh().zza("Invalid public event name. Event will not be logged (FE)", zzo().zza(str12));
                        this.zzx.zzi();
                        String zza2 = zzla.zza(str12, 40, true);
                        if (str12 != null) {
                            i2 = str2.length();
                        }
                        this.zzx.zzi().zza(i3, "_ev", zza2, i2);
                        return;
                    }
                }
            }
            zzu();
            zzit zzab = zzi().zzab();
            if (zzab != null && !bundle3.containsKey("_sc")) {
                zzab.zzd = true;
            }
            zziw.zza(zzab, bundle3, z && z3);
            boolean equals = "am".equals(str11);
            boolean zze2 = zzla.zze(str2);
            if (z && this.zzc != null && !zze2 && !equals) {
                zzr().zzw().zza("Passing event to registered event handler (FE)", zzo().zza(str12), zzo().zza(bundle3));
                this.zzc.interceptEvent(str, str2, bundle, j);
            } else if (this.zzx.zzah()) {
                int zzb2 = zzp().zzb(str12);
                if (zzb2 != 0) {
                    zzr().zzh().zza("Invalid event name. Event will not be logged (FE)", zzo().zza(str12));
                    zzp();
                    String zza3 = zzla.zza(str12, 40, true);
                    if (str12 != null) {
                        i2 = str2.length();
                    }
                    this.zzx.zzi().zza(str3, zzb2, "_ev", zza3, i2);
                    return;
                }
                List listOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
                String str13 = str12;
                Bundle zza4 = zzp().zza(str3, str2, bundle, (List<String>) listOf, z3, true);
                zzit zzit2 = (zza4 == null || !zza4.containsKey("_sc") || !zza4.containsKey("_si")) ? null : new zzit(zza4.getString("_sn"), zza4.getString("_sc"), Long.valueOf(zza4.getLong("_si")).longValue());
                zzit zzit3 = zzit2 == null ? zzab : zzit2;
                String str14 = "_ae";
                if (zzt().zza(zzap.zzba)) {
                    zzu();
                    if (zzi().zzab() != null && str14.equals(str13)) {
                        long zzb3 = zzk().zzb.zzb();
                        if (zzb3 > 0) {
                            zzp().zza(zza4, zzb3);
                        }
                    }
                }
                if (zzka.zzb() && zzt().zza(zzap.zzcq)) {
                    if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(str11) && "_ssr".equals(str13)) {
                        zzla zzp = zzp();
                        String string = zza4.getString("_ffr");
                        if (Strings.isEmptyOrWhitespace(string)) {
                            str10 = null;
                        } else {
                            str10 = string.trim();
                        }
                        if (zzla.zzc(str10, zzp.zzs().zzw.zza())) {
                            zzp.zzr().zzw().zza("Not logging duplicate session_start_with_rollout event");
                            z6 = false;
                        } else {
                            zzp.zzs().zzw.zza(str10);
                            z6 = true;
                        }
                        if (!z6) {
                            return;
                        }
                    } else if (str14.equals(str13)) {
                        String zza5 = zzp().zzs().zzw.zza();
                        if (!TextUtils.isEmpty(zza5)) {
                            zza4.putString("_ffr", zza5);
                        }
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(zza4);
                long nextLong = zzp().zzh().nextLong();
                if (!zzt().zza(zzap.zzau) || zzs().zzq.zza() <= 0 || !zzs().zza(j) || !zzs().zzt.zza()) {
                    str4 = "_o";
                } else {
                    zzr().zzx().zza("Current session is expired, remove the session number, ID, and engagement time");
                    if (zzt().zza(zzap.zzar)) {
                        str4 = "_o";
                        zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", (Object) null, zzm().currentTimeMillis());
                    } else {
                        str4 = "_o";
                    }
                    if (zzt().zza(zzap.zzas)) {
                        zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sno", (Object) null, zzm().currentTimeMillis());
                    }
                    if (zzmv.zzb() && zzt().zza(zzap.zzbq)) {
                        zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_se", (Object) null, zzm().currentTimeMillis());
                    }
                }
                if (!zzt().zza(zzap.zzat) || zza4.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, 0) != 1) {
                    z4 = true;
                    str5 = str13;
                } else {
                    zzr().zzx().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                    str5 = str13;
                    z4 = true;
                    this.zzx.zze().zza.zza(j, true);
                }
                String[] strArr = (String[]) zza4.keySet().toArray(new String[zza4.size()]);
                Arrays.sort(strArr);
                if (!zzjp.zzb() || !zzt().zza(zzap.zzdd) || !zzt().zza(zzap.zzdc)) {
                    int length = strArr.length;
                    int i4 = 0;
                    int i5 = 0;
                    while (i5 < length) {
                        int i6 = length;
                        String str15 = strArr[i5];
                        Object obj = zza4.get(str15);
                        zzp();
                        String[] strArr2 = strArr;
                        Bundle[] zza6 = zzla.zza(obj);
                        if (zza6 != null) {
                            zza4.putInt(str15, zza6.length);
                            int i7 = 0;
                            while (i7 < zza6.length) {
                                Bundle bundle4 = zza6[i7];
                                zziw.zza(zzit3, bundle4, true);
                                int i8 = i4;
                                long j3 = nextLong;
                                Bundle bundle5 = bundle4;
                                ArrayList arrayList4 = arrayList3;
                                Bundle zza7 = zzp().zza(str3, "_ep", bundle5, (List<String>) listOf, z3, false);
                                zza7.putString("_en", str5);
                                zza7.putLong("_eid", j3);
                                zza7.putString("_gn", str15);
                                zza7.putInt("_ll", zza6.length);
                                zza7.putInt("_i", i7);
                                arrayList4.add(zza7);
                                i7++;
                                zza4 = zza4;
                                arrayList3 = arrayList4;
                                nextLong = j3;
                                i5 = i5;
                                zzit3 = zzit3;
                                str14 = str14;
                                i4 = i8;
                            }
                            zzit = zzit3;
                            i = i5;
                            j2 = nextLong;
                            arrayList2 = arrayList3;
                            str9 = str14;
                            bundle2 = zza4;
                            i4 += zza6.length;
                        } else {
                            zzit = zzit3;
                            i = i5;
                            j2 = nextLong;
                            arrayList2 = arrayList3;
                            str9 = str14;
                            bundle2 = zza4;
                        }
                        i5 = i + 1;
                        strArr = strArr2;
                        zza4 = bundle2;
                        arrayList3 = arrayList2;
                        nextLong = j2;
                        length = i6;
                        zzit3 = zzit;
                        str14 = str9;
                    }
                    int i9 = i4;
                    long j4 = nextLong;
                    arrayList = arrayList3;
                    str6 = str14;
                    Bundle bundle6 = zza4;
                    z5 = true;
                    if (i9 != 0) {
                        bundle6.putLong("_eid", j4);
                        bundle6.putInt("_epc", i9);
                    }
                } else {
                    for (String str16 : strArr) {
                        zzp();
                        Bundle[] zza8 = zzla.zza(zza4.get(str16));
                        if (zza8 != null) {
                            zza4.putParcelableArray(str16, zza8);
                        }
                    }
                    z5 = z4;
                    arrayList = arrayList3;
                    str6 = str14;
                }
                int i10 = 0;
                while (i10 < arrayList.size()) {
                    Bundle bundle7 = (Bundle) arrayList.get(i10);
                    if (i10 != 0 ? z5 : false) {
                        str8 = "_ep";
                        str7 = str;
                    } else {
                        str7 = str;
                        str8 = str5;
                    }
                    String str17 = str4;
                    bundle7.putString(str17, str7);
                    if (z2) {
                        bundle7 = zzp().zza(bundle7);
                    }
                    Bundle bundle8 = bundle7;
                    if (!zzkt.zzb() || !zzt().zza(zzap.zzcy)) {
                        zzr().zzw().zza("Logging event (FE)", zzo().zza(str5), zzo().zza(bundle8));
                    }
                    ArrayList arrayList5 = arrayList;
                    String str18 = str5;
                    boolean z7 = z5;
                    zzh().zza(new zzan(str8, new zzam(bundle8), str, j), str3);
                    if (!equals) {
                        for (zzhn onEvent : this.zzd) {
                            onEvent.onEvent(str, str2, new Bundle(bundle8), j);
                        }
                    }
                    i10++;
                    str4 = str17;
                    arrayList = arrayList5;
                    str5 = str18;
                    z5 = z7;
                }
                String str19 = str5;
                boolean z8 = z5;
                zzu();
                if (zzi().zzab() != null && str6.equals(str19)) {
                    zzk().zza(z8, z8, zzm().elapsedRealtime());
                }
            }
        } else {
            zzr().zzw().zza("Dropping non-safelisted event. event name, origin", str12, str11);
        }
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        zzb();
        zzb(str == null ? SettingsJsonConstants.APP_KEY : str, str2, j, bundle == null ? new Bundle() : bundle, z2, !z2 || this.zzc == null || zzla.zze(str2), !z, null);
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzq().zza(new zzhu(this, str, str2, j, zzla.zzb(bundle), z, z2, z3, str3));
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzm().currentTimeMillis());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, int, boolean):java.lang.String
     arg types: [java.lang.String, int, int]
     candidates:
      com.google.android.gms.measurement.internal.zzla.zza(android.os.Bundle, java.lang.String, java.lang.Object):void
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, int, java.lang.String):boolean
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, java.lang.String, java.lang.String):boolean
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, java.lang.String[], java.lang.String):boolean
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, int, boolean):java.lang.String */
    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        if (str == null) {
            str = SettingsJsonConstants.APP_KEY;
        }
        String str3 = str;
        int i = 6;
        int i2 = 0;
        if (z) {
            i = zzp().zzc(str2);
        } else {
            zzla zzp = zzp();
            if (zzp.zza("user property", str2)) {
                if (!zzp.zza("user property", zzhl.zza, str2)) {
                    i = 15;
                } else if (zzp.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
        }
        if (i != 0) {
            zzp();
            String zza2 = zzla.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzx.zzi().zza(i, "_ev", zza2, i2);
        } else if (obj != null) {
            int zzb2 = zzp().zzb(str2, obj);
            if (zzb2 != 0) {
                zzp();
                String zza3 = zzla.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzx.zzi().zza(zzb2, "_ev", zza3, i2);
                return;
            }
            Object zzc2 = zzp().zzc(str2, obj);
            if (zzc2 != null) {
                zza(str3, str2, j, zzc2);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzq().zza(new zzht(this, str, str2, obj, j));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzd()
            r8.zzb()
            r8.zzw()
            com.google.android.gms.measurement.internal.zzx r0 = r8.zzt()
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzap.zzbd
            boolean r0 = r0.zza(r1)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0072
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0072
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0062
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0062
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L_0x0044
            r4 = r2
            goto L_0x0046
        L_0x0044:
            r4 = 0
        L_0x0046:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzft r0 = r8.zzs()
            com.google.android.gms.measurement.internal.zzga r0 = r0.zzn
            r4 = r10
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x005d
            java.lang.String r11 = "true"
        L_0x005d:
            r0.zza(r11)
            r6 = r10
            goto L_0x0070
        L_0x0062:
            if (r11 != 0) goto L_0x0072
            com.google.android.gms.measurement.internal.zzft r10 = r8.zzs()
            com.google.android.gms.measurement.internal.zzga r10 = r10.zzn
            java.lang.String r0 = "unset"
            r10.zza(r0)
            r6 = r11
        L_0x0070:
            r3 = r1
            goto L_0x0074
        L_0x0072:
            r3 = r10
            r6 = r11
        L_0x0074:
            com.google.android.gms.measurement.internal.zzgo r10 = r8.zzx
            boolean r10 = r10.zzab()
            if (r10 != 0) goto L_0x008a
            com.google.android.gms.measurement.internal.zzfk r9 = r8.zzr()
            com.google.android.gms.measurement.internal.zzfm r9 = r9.zzx()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L_0x008a:
            com.google.android.gms.measurement.internal.zzgo r10 = r8.zzx
            boolean r10 = r10.zzah()
            if (r10 != 0) goto L_0x0093
            return
        L_0x0093:
            com.google.android.gms.measurement.internal.zzkz r10 = new com.google.android.gms.measurement.internal.zzkz
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzix r9 = r8.zzh()
            r9.zza(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final List<zzkz> zzc(boolean z) {
        zzb();
        zzw();
        zzr().zzx().zza("Getting user properties (FE)");
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzw.zza()) {
            zzr().zzf().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzx.zzq().zza(atomicReference, 5000, "get user properties", new zzhw(this, atomicReference, z));
            List<zzkz> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzr().zzf().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
    }

    public final String zzah() {
        zzb();
        return this.zzf.get();
    }

    public final String zzc(long j) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot retrieve app instance id from analytics worker thread");
            return null;
        } else if (zzw.zza()) {
            zzr().zzf().zza("Cannot retrieve app instance id from main thread");
            return null;
        } else {
            long elapsedRealtime = zzm().elapsedRealtime();
            String zze2 = zze(120000);
            long elapsedRealtime2 = zzm().elapsedRealtime() - elapsedRealtime;
            return (zze2 != null || elapsedRealtime2 >= 120000) ? zze2 : zze(120000 - elapsedRealtime2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str) {
        this.zzf.set(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        zzr().zzi().zza("Interrupted waiting for app instance id");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zze(long r4) {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            monitor-enter(r0)
            com.google.android.gms.measurement.internal.zzgh r1 = r3.zzq()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.zzhv r2 = new com.google.android.gms.measurement.internal.zzhv     // Catch:{ all -> 0x002d }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x002d }
            r1.zza(r2)     // Catch:{ all -> 0x002d }
            r0.wait(r4)     // Catch:{ InterruptedException -> 0x001d }
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            java.lang.Object r4 = r0.get()
            java.lang.String r4 = (java.lang.String) r4
            return r4
        L_0x001d:
            com.google.android.gms.measurement.internal.zzfk r4 = r3.zzr()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzi()     // Catch:{ all -> 0x002d }
            java.lang.String r5 = "Interrupted waiting for app instance id"
            r4.zza(r5)     // Catch:{ all -> 0x002d }
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r4
        L_0x002d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhp.zze(long):java.lang.String");
    }

    public final void zzd(long j) {
        zza((String) null);
        zzq().zza(new zzhy(this, j));
    }

    public final void zzai() {
        zzd();
        zzb();
        zzw();
        if (this.zzx.zzah()) {
            if (zzt().zza(zzap.zzby)) {
                zzx zzt = zzt();
                zzt.zzu();
                Boolean zzd2 = zzt.zzd("google_analytics_deferred_deep_link_enabled");
                if (zzd2 != null && zzd2.booleanValue()) {
                    zzr().zzw().zza("Deferred Deep Link feature enabled.");
                    zzq().zza(new zzhs(this));
                }
            }
            zzh().zzae();
            this.zzb = false;
            String zzw = zzs().zzw();
            if (!TextUtils.isEmpty(zzw)) {
                zzl().zzaa();
                if (!zzw.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzw);
                    zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ou", bundle);
                }
            }
        }
    }

    public final void zza(zzho zzho) {
        zzho zzho2;
        zzd();
        zzb();
        zzw();
        if (!(zzho == null || zzho == (zzho2 = this.zzc))) {
            Preconditions.checkState(zzho2 == null, "EventInterceptor already set.");
        }
        this.zzc = zzho;
    }

    public final void zza(zzhn zzhn) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzhn);
        if (!this.zzd.add(zzhn)) {
            zzr().zzi().zza("OnEventListener already registered");
        }
    }

    public final void zzb(zzhn zzhn) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzhn);
        if (!this.zzd.remove(zzhn)) {
            zzr().zzi().zza("OnEventListener had not been registered");
        }
    }

    public final void zza(Bundle bundle) {
        zza(bundle, zzm().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzb();
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzr().zzi().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        zzb(bundle2, j);
    }

    public final void zzb(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("app_id"));
        zza();
        zzb(new Bundle(bundle), zzm().currentTimeMillis());
    }

    private final void zzb(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzhk.zza(bundle, "app_id", String.class, null);
        zzhk.zza(bundle, "origin", String.class, null);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.NAME, String.class, null);
        zzhk.zza(bundle, "value", Object.class, null);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        Object obj = bundle.get("value");
        if (zzp().zzc(string) != 0) {
            zzr().zzf().zza("Invalid conditional user property name", zzo().zzc(string));
        } else if (zzp().zzb(string, obj) != 0) {
            zzr().zzf().zza("Invalid conditional user property value", zzo().zzc(string), obj);
        } else {
            Object zzc2 = zzp().zzc(string, obj);
            if (zzc2 == null) {
                zzr().zzf().zza("Unable to normalize conditional user property value", zzo().zzc(string), obj);
                return;
            }
            zzhk.zza(bundle, zzc2);
            long j2 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (TextUtils.isEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                if (j3 > 15552000000L || j3 < 1) {
                    zzr().zzf().zza("Invalid conditional user property time to live", zzo().zzc(string), Long.valueOf(j3));
                } else {
                    zzq().zza(new zzia(this, bundle));
                }
            } else {
                zzr().zzf().zza("Invalid conditional user property timeout", zzo().zzc(string), Long.valueOf(j2));
            }
        }
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        zzb();
        zzb((String) null, str, str2, bundle);
    }

    public final void zza(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zza();
        zzb(str, str2, str3, bundle);
    }

    private final void zzb(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzm().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str3 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str3);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzq().zza(new zzhz(this, bundle2));
    }

    /* access modifiers changed from: private */
    public final void zzc(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        if (!this.zzx.zzab()) {
            zzr().zzx().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkz zzkz = new zzkz(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle2.get("value"), bundle2.getString("origin"));
        try {
            zzan zza2 = zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false);
            zzh().zza(new zzv(bundle2.getString("app_id"), bundle2.getString("origin"), zzkz, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zza2, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* access modifiers changed from: private */
    public final void zzd(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        if (!this.zzx.zzab()) {
            zzr().zzx().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzkz zzkz = new zzkz(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), 0, null, null);
        try {
            zzan zza2 = zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false);
            zzkz zzkz2 = zzkz;
            zzh().zza(new zzv(bundle2.getString("app_id"), bundle2.getString("origin"), zzkz2, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle2.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zza2));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        zzb();
        return zzb((String) null, str, str2);
    }

    public final ArrayList<Bundle> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3);
    }

    private final ArrayList<Bundle> zzb(String str, String str2, String str3) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzw.zza()) {
            zzr().zzf().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzx.zzq().zza(atomicReference, 5000, "get conditional user properties", new zzic(this, atomicReference, str, str2, str3));
            List list = (List) atomicReference.get();
            if (list != null) {
                return zzla.zzb((List<zzv>) list);
            }
            zzr().zzf().zza("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzb();
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> zza(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3, z);
    }

    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzw.zza()) {
            zzr().zzf().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzx.zzq().zza(atomicReference, 5000, "get user properties", new zzie(this, atomicReference, str, str2, str3, z));
            List<zzkz> list = (List) atomicReference.get();
            if (list == null) {
                zzr().zzf().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzkz zzkz : list) {
                arrayMap.put(zzkz.zza, zzkz.zza());
            }
            return arrayMap;
        }
    }

    public final String zzaj() {
        zzit zzac = this.zzx.zzv().zzac();
        if (zzac != null) {
            return zzac.zza;
        }
        return null;
    }

    public final String zzak() {
        zzit zzac = this.zzx.zzv().zzac();
        if (zzac != null) {
            return zzac.zzb;
        }
        return null;
    }

    public final String zzal() {
        if (this.zzx.zzo() != null) {
            return this.zzx.zzo();
        }
        try {
            return GoogleServices.getGoogleAppId();
        } catch (IllegalStateException e) {
            this.zzx.zzr().zzf().zza("getGoogleAppId failed with exception", e);
            return null;
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

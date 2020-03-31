package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzle;
import com.google.android.gms.internal.measurement.zzlr;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzim implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzhp zza;

    private zzim(zzhp zzhp) {
        this.zza = zzhp;
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.zza.zzr().zzx().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.isHierarchical()) {
                        this.zza.zzp();
                        String str = zzla.zza(intent) ? "gs" : DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
                        String queryParameter = data.getQueryParameter("referrer");
                        boolean z = bundle == null;
                        if (!zzlr.zzb() || !zzap.zzcd.zza(null).booleanValue()) {
                            zza(z, data, str, queryParameter);
                        } else {
                            this.zza.zzq().zza(new zzil(this, z, data, str, queryParameter));
                        }
                        this.zza.zzi().zza(activity, bundle);
                        return;
                    }
                }
                this.zza.zzi().zza(activity, bundle);
            }
        } catch (Exception e) {
            this.zza.zzr().zzf().zza("Throwable caught in onActivityCreated", e);
        } finally {
            this.zza.zzi().zza(activity, bundle);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.Object, boolean):void
     arg types: [java.lang.String, java.lang.String, java.lang.String, int]
     candidates:
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, long, java.lang.Object):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.String, boolean):java.util.Map<java.lang.String, java.lang.Object>
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, long, android.os.Bundle):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, android.os.Bundle, boolean):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.Object, long):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.String, android.os.Bundle):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.Object, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.Object, boolean):void
     arg types: [java.lang.String, java.lang.String, ?[OBJECT, ARRAY], int]
     candidates:
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, long, java.lang.Object):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.String, boolean):java.util.Map<java.lang.String, java.lang.Object>
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, long, android.os.Bundle):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, android.os.Bundle, boolean):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.Object, long):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.String, android.os.Bundle):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.Object, boolean):void */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009c A[SYNTHETIC, Splitter:B:33:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e4 A[Catch:{ Exception -> 0x01a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f5 A[SYNTHETIC, Splitter:B:49:0x00f5] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0124 A[Catch:{ Exception -> 0x01a7 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0125 A[Catch:{ Exception -> 0x01a7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r18, android.net.Uri r19, java.lang.String r20, java.lang.String r21) {
        /*
            r17 = this;
            r1 = r17
            r0 = r20
            r2 = r21
            com.google.android.gms.measurement.internal.zzhp r3 = r1.zza     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzx r3 = r3.zzt()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzap.zzca     // Catch:{ Exception -> 0x01a7 }
            boolean r3 = r3.zza(r4)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r4 = "Activity created with data 'referrer' without required params"
            java.lang.String r5 = "utm_medium"
            java.lang.String r6 = "_cis"
            java.lang.String r7 = "utm_source"
            java.lang.String r8 = "utm_campaign"
            java.lang.String r10 = "gclid"
            if (r3 != 0) goto L_0x003f
            com.google.android.gms.measurement.internal.zzhp r3 = r1.zza     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzx r3 = r3.zzt()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzap.zzcc     // Catch:{ Exception -> 0x01a7 }
            boolean r3 = r3.zza(r11)     // Catch:{ Exception -> 0x01a7 }
            if (r3 != 0) goto L_0x003f
            com.google.android.gms.measurement.internal.zzhp r3 = r1.zza     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzx r3 = r3.zzt()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzap.zzcb     // Catch:{ Exception -> 0x01a7 }
            boolean r3 = r3.zza(r11)     // Catch:{ Exception -> 0x01a7 }
            if (r3 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r3 = 0
            goto L_0x0096
        L_0x003f:
            com.google.android.gms.measurement.internal.zzhp r3 = r1.zza     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzla r3 = r3.zzp()     // Catch:{ Exception -> 0x01a7 }
            boolean r11 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x01a7 }
            if (r11 == 0) goto L_0x004c
            goto L_0x003d
        L_0x004c:
            boolean r11 = r2.contains(r10)     // Catch:{ Exception -> 0x01a7 }
            if (r11 != 0) goto L_0x0070
            boolean r11 = r2.contains(r8)     // Catch:{ Exception -> 0x01a7 }
            if (r11 != 0) goto L_0x0070
            boolean r11 = r2.contains(r7)     // Catch:{ Exception -> 0x01a7 }
            if (r11 != 0) goto L_0x0070
            boolean r11 = r2.contains(r5)     // Catch:{ Exception -> 0x01a7 }
            if (r11 != 0) goto L_0x0070
            com.google.android.gms.measurement.internal.zzfk r3 = r3.zzr()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzfm r3 = r3.zzw()     // Catch:{ Exception -> 0x01a7 }
            r3.zza(r4)     // Catch:{ Exception -> 0x01a7 }
            goto L_0x003d
        L_0x0070:
            java.lang.String r11 = "https://google.com/search?"
            java.lang.String r12 = java.lang.String.valueOf(r21)     // Catch:{ Exception -> 0x01a7 }
            int r13 = r12.length()     // Catch:{ Exception -> 0x01a7 }
            if (r13 == 0) goto L_0x0081
            java.lang.String r11 = r11.concat(r12)     // Catch:{ Exception -> 0x01a7 }
            goto L_0x0087
        L_0x0081:
            java.lang.String r12 = new java.lang.String     // Catch:{ Exception -> 0x01a7 }
            r12.<init>(r11)     // Catch:{ Exception -> 0x01a7 }
            r11 = r12
        L_0x0087:
            android.net.Uri r11 = android.net.Uri.parse(r11)     // Catch:{ Exception -> 0x01a7 }
            android.os.Bundle r3 = r3.zza(r11)     // Catch:{ Exception -> 0x01a7 }
            if (r3 == 0) goto L_0x0096
            java.lang.String r11 = "referrer"
            r3.putString(r6, r11)     // Catch:{ Exception -> 0x01a7 }
        L_0x0096:
            r11 = 0
            java.lang.String r12 = "_cmp"
            r13 = 1
            if (r18 == 0) goto L_0x00e4
            com.google.android.gms.measurement.internal.zzhp r14 = r1.zza     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzla r14 = r14.zzp()     // Catch:{ Exception -> 0x01a7 }
            r15 = r19
            android.os.Bundle r14 = r14.zza(r15)     // Catch:{ Exception -> 0x01a7 }
            if (r14 == 0) goto L_0x00e5
            java.lang.String r15 = "intent"
            r14.putString(r6, r15)     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzhp r6 = r1.zza     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzt()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzap.zzca     // Catch:{ Exception -> 0x01a7 }
            boolean r6 = r6.zza(r15)     // Catch:{ Exception -> 0x01a7 }
            if (r6 == 0) goto L_0x00de
            boolean r6 = r14.containsKey(r10)     // Catch:{ Exception -> 0x01a7 }
            if (r6 != 0) goto L_0x00de
            if (r3 == 0) goto L_0x00de
            boolean r6 = r3.containsKey(r10)     // Catch:{ Exception -> 0x01a7 }
            if (r6 == 0) goto L_0x00de
            java.lang.String r6 = "_cer"
            java.lang.String r15 = "gclid=%s"
            java.lang.Object[] r9 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r16 = r3.getString(r10)     // Catch:{ Exception -> 0x01a7 }
            r9[r11] = r16     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r9 = java.lang.String.format(r15, r9)     // Catch:{ Exception -> 0x01a7 }
            r14.putString(r6, r9)     // Catch:{ Exception -> 0x01a7 }
        L_0x00de:
            com.google.android.gms.measurement.internal.zzhp r6 = r1.zza     // Catch:{ Exception -> 0x01a7 }
            r6.zza(r0, r12, r14)     // Catch:{ Exception -> 0x01a7 }
            goto L_0x00e5
        L_0x00e4:
            r14 = 0
        L_0x00e5:
            com.google.android.gms.measurement.internal.zzhp r6 = r1.zza     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzt()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzap.zzcc     // Catch:{ Exception -> 0x01a7 }
            boolean r6 = r6.zza(r9)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r9 = "auto"
            if (r6 == 0) goto L_0x011e
            com.google.android.gms.measurement.internal.zzhp r6 = r1.zza     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzt()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzap.zzcb     // Catch:{ Exception -> 0x01a7 }
            boolean r6 = r6.zza(r15)     // Catch:{ Exception -> 0x01a7 }
            if (r6 != 0) goto L_0x011e
            if (r3 == 0) goto L_0x011e
            boolean r6 = r3.containsKey(r10)     // Catch:{ Exception -> 0x01a7 }
            if (r6 == 0) goto L_0x011e
            if (r14 == 0) goto L_0x0113
            boolean r6 = r14.containsKey(r10)     // Catch:{ Exception -> 0x01a7 }
            if (r6 != 0) goto L_0x011e
        L_0x0113:
            com.google.android.gms.measurement.internal.zzhp r6 = r1.zza     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r14 = "_lgclid"
            java.lang.String r15 = r3.getString(r10)     // Catch:{ Exception -> 0x01a7 }
            r6.zza(r9, r14, r15, r13)     // Catch:{ Exception -> 0x01a7 }
        L_0x011e:
            boolean r6 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x01a7 }
            if (r6 == 0) goto L_0x0125
            return
        L_0x0125:
            com.google.android.gms.measurement.internal.zzhp r6 = r1.zza     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzfk r6 = r6.zzr()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzw()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r14 = "Activity created with referrer"
            r6.zza(r14, r2)     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzhp r6 = r1.zza     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzt()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzap.zzcb     // Catch:{ Exception -> 0x01a7 }
            boolean r6 = r6.zza(r14)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r14 = "_ldl"
            if (r6 == 0) goto L_0x0162
            if (r3 == 0) goto L_0x014c
            com.google.android.gms.measurement.internal.zzhp r2 = r1.zza     // Catch:{ Exception -> 0x01a7 }
            r2.zza(r0, r12, r3)     // Catch:{ Exception -> 0x01a7 }
            goto L_0x015b
        L_0x014c:
            com.google.android.gms.measurement.internal.zzhp r0 = r1.zza     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzfk r0 = r0.zzr()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzw()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r3 = "Referrer does not contain valid parameters"
            r0.zza(r3, r2)     // Catch:{ Exception -> 0x01a7 }
        L_0x015b:
            com.google.android.gms.measurement.internal.zzhp r0 = r1.zza     // Catch:{ Exception -> 0x01a7 }
            r2 = 0
            r0.zza(r9, r14, r2, r13)     // Catch:{ Exception -> 0x01a7 }
            return
        L_0x0162:
            boolean r0 = r2.contains(r10)     // Catch:{ Exception -> 0x01a7 }
            if (r0 == 0) goto L_0x018b
            boolean r0 = r2.contains(r8)     // Catch:{ Exception -> 0x01a7 }
            if (r0 != 0) goto L_0x018a
            boolean r0 = r2.contains(r7)     // Catch:{ Exception -> 0x01a7 }
            if (r0 != 0) goto L_0x018a
            boolean r0 = r2.contains(r5)     // Catch:{ Exception -> 0x01a7 }
            if (r0 != 0) goto L_0x018a
            java.lang.String r0 = "utm_term"
            boolean r0 = r2.contains(r0)     // Catch:{ Exception -> 0x01a7 }
            if (r0 != 0) goto L_0x018a
            java.lang.String r0 = "utm_content"
            boolean r0 = r2.contains(r0)     // Catch:{ Exception -> 0x01a7 }
            if (r0 == 0) goto L_0x018b
        L_0x018a:
            r11 = r13
        L_0x018b:
            if (r11 != 0) goto L_0x019b
            com.google.android.gms.measurement.internal.zzhp r0 = r1.zza     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzfk r0 = r0.zzr()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzw()     // Catch:{ Exception -> 0x01a7 }
            r0.zza(r4)     // Catch:{ Exception -> 0x01a7 }
            return
        L_0x019b:
            boolean r0 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x01a7 }
            if (r0 != 0) goto L_0x01a6
            com.google.android.gms.measurement.internal.zzhp r0 = r1.zza     // Catch:{ Exception -> 0x01a7 }
            r0.zza(r9, r14, r2, r13)     // Catch:{ Exception -> 0x01a7 }
        L_0x01a6:
            return
        L_0x01a7:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzhp r2 = r1.zza
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()
            java.lang.String r3 = "Throwable caught in handleReferrerForOnActivityCreated"
            r2.zza(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzim.zza(boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzi().zzc(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzi().zzb(activity);
        zzkc zzk = this.zza.zzk();
        zzk.zzq().zza(new zzke(zzk, zzk.zzm().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        if (!zzle.zzb() || !zzap.zzax.zza(null).booleanValue()) {
            this.zza.zzi().zza(activity);
            this.zza.zzk().zzab();
            return;
        }
        this.zza.zzk().zzab();
        this.zza.zzi().zza(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzi().zzb(activity, bundle);
    }

    /* synthetic */ zzim(zzhp zzhp, zzhr zzhr) {
        this(zzhp);
    }
}

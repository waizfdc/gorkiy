package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zznh;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzfd extends zze {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private List<String> zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;

    zzfd(zzgo zzgo, long j) {
        super(zzgo);
        this.zzg = j;
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01a4, code lost:
        if (r2 == 0) goto L_0x01a6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x027b A[Catch:{ IllegalStateException -> 0x02a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x028c A[Catch:{ IllegalStateException -> 0x02a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0230 A[Catch:{ IllegalStateException -> 0x02a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0232 A[Catch:{ IllegalStateException -> 0x02a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x023d A[SYNTHETIC, Splitter:B:90:0x023d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzaa() {
        /*
            r11 = this;
            android.content.Context r0 = r11.zzn()
            java.lang.String r0 = r0.getPackageName()
            android.content.Context r1 = r11.zzn()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.lang.String r2 = "Unknown"
            java.lang.String r3 = ""
            r4 = 0
            java.lang.String r5 = "unknown"
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != 0) goto L_0x002e
            com.google.android.gms.measurement.internal.zzfk r7 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzf()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfk.zza(r0)
            java.lang.String r9 = "PackageManager is null, app identity information might be inaccurate. appId"
            r7.zza(r9, r8)
        L_0x002c:
            r8 = r2
            goto L_0x008e
        L_0x002e:
            java.lang.String r5 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x0033 }
            goto L_0x0044
        L_0x0033:
            com.google.android.gms.measurement.internal.zzfk r7 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzf()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfk.zza(r0)
            java.lang.String r9 = "Error retrieving app installer package name. appId"
            r7.zza(r9, r8)
        L_0x0044:
            if (r5 != 0) goto L_0x0049
            java.lang.String r5 = "manual_install"
            goto L_0x0052
        L_0x0049:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L_0x0052
            r5 = r3
        L_0x0052:
            android.content.Context r7 = r11.zzn()     // Catch:{ NameNotFoundException -> 0x007a }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x007a }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r4)     // Catch:{ NameNotFoundException -> 0x007a }
            if (r7 == 0) goto L_0x002c
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x007a }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x007a }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x007a }
            if (r9 != 0) goto L_0x0071
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x007a }
            goto L_0x0072
        L_0x0071:
            r8 = r2
        L_0x0072:
            java.lang.String r2 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0077 }
            int r6 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0077 }
            goto L_0x008e
        L_0x0077:
            r7 = r2
            r2 = r8
            goto L_0x007b
        L_0x007a:
            r7 = r2
        L_0x007b:
            com.google.android.gms.measurement.internal.zzfk r8 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r8 = r8.zzf()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza(r0)
            java.lang.String r10 = "Error retrieving package info. appId, appName"
            r8.zza(r10, r9, r2)
            r8 = r2
            r2 = r7
        L_0x008e:
            r11.zza = r0
            r11.zzd = r5
            r11.zzb = r2
            r11.zzc = r6
            r11.zze = r8
            r5 = 0
            r11.zzf = r5
            r11.zzu()
            android.content.Context r2 = r11.zzn()
            com.google.android.gms.common.api.Status r2 = com.google.android.gms.common.api.internal.GoogleServices.initialize(r2)
            r5 = 1
            if (r2 == 0) goto L_0x00b2
            boolean r6 = r2.isSuccess()
            if (r6 == 0) goto L_0x00b2
            r6 = r5
            goto L_0x00b3
        L_0x00b2:
            r6 = r4
        L_0x00b3:
            com.google.android.gms.measurement.internal.zzgo r7 = r11.zzx
            java.lang.String r7 = r7.zzo()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00cf
            com.google.android.gms.measurement.internal.zzgo r7 = r11.zzx
            java.lang.String r7 = r7.zzp()
            java.lang.String r8 = "am"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x00cf
            r7 = r5
            goto L_0x00d0
        L_0x00cf:
            r7 = r4
        L_0x00d0:
            r6 = r6 | r7
            if (r6 != 0) goto L_0x00fc
            if (r2 != 0) goto L_0x00e3
            com.google.android.gms.measurement.internal.zzfk r2 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzg()
            java.lang.String r8 = "GoogleService failed to initialize (no status)"
            r2.zza(r8)
            goto L_0x00fc
        L_0x00e3:
            com.google.android.gms.measurement.internal.zzfk r8 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r8 = r8.zzg()
            int r9 = r2.getStatusCode()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = r2.getStatusMessage()
            java.lang.String r10 = "GoogleService failed to initialize, status"
            r8.zza(r10, r9, r2)
        L_0x00fc:
            if (r6 == 0) goto L_0x0212
            boolean r2 = com.google.android.gms.internal.measurement.zzkt.zzb()
            if (r2 == 0) goto L_0x01a8
            com.google.android.gms.measurement.internal.zzx r2 = r11.zzt()
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzap.zzcy
            boolean r2 = r2.zza(r6)
            if (r2 == 0) goto L_0x01a8
            com.google.android.gms.measurement.internal.zzgo r2 = r11.zzx
            int r2 = r2.zzac()
            switch(r2) {
                case 0: goto L_0x0197;
                case 1: goto L_0x0189;
                case 2: goto L_0x017b;
                case 3: goto L_0x016d;
                case 4: goto L_0x015f;
                case 5: goto L_0x0151;
                case 6: goto L_0x0143;
                case 7: goto L_0x0135;
                default: goto L_0x0119;
            }
        L_0x0119:
            com.google.android.gms.measurement.internal.zzfk r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzv()
            java.lang.String r8 = "App measurement disabled"
            r6.zza(r8)
            com.google.android.gms.measurement.internal.zzfk r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzg()
            java.lang.String r8 = "Invalid scion state in identity"
            r6.zza(r8)
            goto L_0x01a4
        L_0x0135:
            com.google.android.gms.measurement.internal.zzfk r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzv()
            java.lang.String r8 = "App measurement disabled via the global data collection setting"
            r6.zza(r8)
            goto L_0x01a4
        L_0x0143:
            com.google.android.gms.measurement.internal.zzfk r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzk()
            java.lang.String r8 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r6.zza(r8)
            goto L_0x01a4
        L_0x0151:
            com.google.android.gms.measurement.internal.zzfk r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzx()
            java.lang.String r8 = "App measurement disabled via the init parameters"
            r6.zza(r8)
            goto L_0x01a4
        L_0x015f:
            com.google.android.gms.measurement.internal.zzfk r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzv()
            java.lang.String r8 = "App measurement disabled via the manifest"
            r6.zza(r8)
            goto L_0x01a4
        L_0x016d:
            com.google.android.gms.measurement.internal.zzfk r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzv()
            java.lang.String r8 = "App measurement disabled by setMeasurementEnabled(false)"
            r6.zza(r8)
            goto L_0x01a4
        L_0x017b:
            com.google.android.gms.measurement.internal.zzfk r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzx()
            java.lang.String r8 = "App measurement deactivated via the init parameters"
            r6.zza(r8)
            goto L_0x01a4
        L_0x0189:
            com.google.android.gms.measurement.internal.zzfk r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzv()
            java.lang.String r8 = "App measurement deactivated via the manifest"
            r6.zza(r8)
            goto L_0x01a4
        L_0x0197:
            com.google.android.gms.measurement.internal.zzfk r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzx()
            java.lang.String r8 = "App measurement collection enabled"
            r6.zza(r8)
        L_0x01a4:
            if (r2 != 0) goto L_0x0212
        L_0x01a6:
            r2 = r5
            goto L_0x0213
        L_0x01a8:
            com.google.android.gms.measurement.internal.zzx r2 = r11.zzt()
            java.lang.Boolean r2 = r2.zzh()
            com.google.android.gms.measurement.internal.zzx r6 = r11.zzt()
            boolean r6 = r6.zzg()
            if (r6 == 0) goto L_0x01d0
            com.google.android.gms.measurement.internal.zzgo r2 = r11.zzx
            boolean r2 = r2.zzl()
            if (r2 == 0) goto L_0x0212
            com.google.android.gms.measurement.internal.zzfk r2 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzv()
            java.lang.String r6 = "Collection disabled with firebase_analytics_collection_deactivated=1"
            r2.zza(r6)
            goto L_0x0212
        L_0x01d0:
            if (r2 == 0) goto L_0x01ee
            boolean r6 = r2.booleanValue()
            if (r6 != 0) goto L_0x01ee
            com.google.android.gms.measurement.internal.zzgo r2 = r11.zzx
            boolean r2 = r2.zzl()
            if (r2 == 0) goto L_0x0212
            com.google.android.gms.measurement.internal.zzfk r2 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzv()
            java.lang.String r6 = "Collection disabled with firebase_analytics_collection_enabled=0"
            r2.zza(r6)
            goto L_0x0212
        L_0x01ee:
            if (r2 != 0) goto L_0x0204
            boolean r2 = com.google.android.gms.common.api.internal.GoogleServices.isMeasurementExplicitlyDisabled()
            if (r2 == 0) goto L_0x0204
            com.google.android.gms.measurement.internal.zzfk r2 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzv()
            java.lang.String r6 = "Collection disabled with google_app_measurement_enable=0"
            r2.zza(r6)
            goto L_0x0212
        L_0x0204:
            com.google.android.gms.measurement.internal.zzfk r2 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzx()
            java.lang.String r6 = "Collection enabled"
            r2.zza(r6)
            goto L_0x01a6
        L_0x0212:
            r2 = r4
        L_0x0213:
            r11.zzj = r3
            r11.zzk = r3
            r11.zzl = r3
            r11.zzu()
            if (r7 == 0) goto L_0x0226
            com.google.android.gms.measurement.internal.zzgo r6 = r11.zzx
            java.lang.String r6 = r6.zzo()
            r11.zzk = r6
        L_0x0226:
            java.lang.String r6 = com.google.android.gms.common.api.internal.GoogleServices.getGoogleAppId()     // Catch:{ IllegalStateException -> 0x02a9 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalStateException -> 0x02a9 }
            if (r7 == 0) goto L_0x0232
            r7 = r3
            goto L_0x0233
        L_0x0232:
            r7 = r6
        L_0x0233:
            r11.zzj = r7     // Catch:{ IllegalStateException -> 0x02a9 }
            boolean r7 = com.google.android.gms.internal.measurement.zzll.zzb()     // Catch:{ IllegalStateException -> 0x02a9 }
            java.lang.String r8 = "admob_app_id"
            if (r7 == 0) goto L_0x0275
            com.google.android.gms.measurement.internal.zzx r7 = r11.zzt()     // Catch:{ IllegalStateException -> 0x02a9 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzap.zzch     // Catch:{ IllegalStateException -> 0x02a9 }
            boolean r7 = r7.zza(r9)     // Catch:{ IllegalStateException -> 0x02a9 }
            if (r7 == 0) goto L_0x0275
            com.google.android.gms.common.internal.StringResourceValueReader r7 = new com.google.android.gms.common.internal.StringResourceValueReader     // Catch:{ IllegalStateException -> 0x02a9 }
            android.content.Context r9 = r11.zzn()     // Catch:{ IllegalStateException -> 0x02a9 }
            r7.<init>(r9)     // Catch:{ IllegalStateException -> 0x02a9 }
            java.lang.String r9 = "ga_app_id"
            java.lang.String r9 = r7.getString(r9)     // Catch:{ IllegalStateException -> 0x02a9 }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ IllegalStateException -> 0x02a9 }
            if (r10 == 0) goto L_0x025f
            goto L_0x0260
        L_0x025f:
            r3 = r9
        L_0x0260:
            r11.zzl = r3     // Catch:{ IllegalStateException -> 0x02a9 }
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalStateException -> 0x02a9 }
            if (r3 == 0) goto L_0x026e
            boolean r3 = android.text.TextUtils.isEmpty(r9)     // Catch:{ IllegalStateException -> 0x02a9 }
            if (r3 != 0) goto L_0x028a
        L_0x026e:
            java.lang.String r3 = r7.getString(r8)     // Catch:{ IllegalStateException -> 0x02a9 }
            r11.zzk = r3     // Catch:{ IllegalStateException -> 0x02a9 }
            goto L_0x028a
        L_0x0275:
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalStateException -> 0x02a9 }
            if (r3 != 0) goto L_0x028a
            com.google.android.gms.common.internal.StringResourceValueReader r3 = new com.google.android.gms.common.internal.StringResourceValueReader     // Catch:{ IllegalStateException -> 0x02a9 }
            android.content.Context r6 = r11.zzn()     // Catch:{ IllegalStateException -> 0x02a9 }
            r3.<init>(r6)     // Catch:{ IllegalStateException -> 0x02a9 }
            java.lang.String r3 = r3.getString(r8)     // Catch:{ IllegalStateException -> 0x02a9 }
            r11.zzk = r3     // Catch:{ IllegalStateException -> 0x02a9 }
        L_0x028a:
            if (r2 == 0) goto L_0x02bb
            com.google.android.gms.measurement.internal.zzfk r2 = r11.zzr()     // Catch:{ IllegalStateException -> 0x02a9 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzx()     // Catch:{ IllegalStateException -> 0x02a9 }
            java.lang.String r3 = "App measurement enabled for app package, google app id"
            java.lang.String r6 = r11.zza     // Catch:{ IllegalStateException -> 0x02a9 }
            java.lang.String r7 = r11.zzj     // Catch:{ IllegalStateException -> 0x02a9 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x02a9 }
            if (r7 == 0) goto L_0x02a3
            java.lang.String r7 = r11.zzk     // Catch:{ IllegalStateException -> 0x02a9 }
            goto L_0x02a5
        L_0x02a3:
            java.lang.String r7 = r11.zzj     // Catch:{ IllegalStateException -> 0x02a9 }
        L_0x02a5:
            r2.zza(r3, r6, r7)     // Catch:{ IllegalStateException -> 0x02a9 }
            goto L_0x02bb
        L_0x02a9:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfk r3 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r3 = r3.zzf()
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzfk.zza(r0)
            java.lang.String r6 = "Fetching Google App Id failed with exception. appId"
            r3.zza(r6, r0, r2)
        L_0x02bb:
            r0 = 0
            r11.zzh = r0
            com.google.android.gms.measurement.internal.zzx r0 = r11.zzt()
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzap.zzbl
            boolean r0 = r0.zza(r2)
            if (r0 == 0) goto L_0x030f
            r11.zzu()
            com.google.android.gms.measurement.internal.zzx r0 = r11.zzt()
            java.lang.String r2 = "analytics.safelisted_events"
            java.util.List r0 = r0.zze(r2)
            if (r0 == 0) goto L_0x030b
            int r2 = r0.size()
            if (r2 != 0) goto L_0x02ee
            com.google.android.gms.measurement.internal.zzfk r2 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzk()
            java.lang.String r3 = "Safelisted event list is empty. Ignoring"
            r2.zza(r3)
        L_0x02ec:
            r5 = r4
            goto L_0x030b
        L_0x02ee:
            java.util.Iterator r2 = r0.iterator()
        L_0x02f2:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x030b
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.gms.measurement.internal.zzla r6 = r11.zzp()
            java.lang.String r7 = "safelisted event"
            boolean r3 = r6.zzb(r7, r3)
            if (r3 != 0) goto L_0x02f2
            goto L_0x02ec
        L_0x030b:
            if (r5 == 0) goto L_0x030f
            r11.zzh = r0
        L_0x030f:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r0 < r2) goto L_0x0325
            if (r1 == 0) goto L_0x0322
            android.content.Context r0 = r11.zzn()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r11.zzi = r0
            return
        L_0x0322:
            r11.zzi = r4
            return
        L_0x0325:
            r11.zzi = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfd.zzaa():void");
    }

    /* access modifiers changed from: package-private */
    public final zzm zza(String str) {
        String str2;
        boolean z;
        Boolean bool;
        Boolean zzd2;
        zzd();
        zzb();
        String zzab = zzab();
        String zzac = zzac();
        zzw();
        String str3 = this.zzb;
        long zzaf = (long) zzaf();
        zzw();
        String str4 = this.zzd;
        long zze2 = zzt().zze();
        zzw();
        zzd();
        if (this.zzf == 0) {
            this.zzf = this.zzx.zzi().zza(zzn(), zzn().getPackageName());
        }
        long j = this.zzf;
        boolean zzab2 = this.zzx.zzab();
        boolean z2 = !zzs().zzs;
        zzd();
        zzb();
        if (!this.zzx.zzab()) {
            str2 = null;
        } else {
            str2 = zzai();
        }
        long zzad = this.zzx.zzad();
        int zzag = zzag();
        boolean booleanValue = zzt().zzi().booleanValue();
        zzx zzt = zzt();
        zzt.zzb();
        Boolean zzd3 = zzt.zzd("google_analytics_ssaid_collection_enabled");
        boolean booleanValue2 = Boolean.valueOf(zzd3 == null || zzd3.booleanValue()).booleanValue();
        zzft zzs = zzs();
        zzs.zzd();
        boolean z3 = zzs.zzg().getBoolean("deferred_analytics_collection", false);
        String zzad2 = zzad();
        if (!zzt().zza(zzap.zzbc) || (zzd2 = zzt().zzd("google_analytics_default_allow_ad_personalization_signals")) == null) {
            z = z2;
            bool = null;
        } else {
            bool = Boolean.valueOf(!zzd2.booleanValue());
            z = z2;
        }
        return new zzm(zzab, zzac, str3, zzaf, str4, zze2, j, str, zzab2, z, str2, 0, zzad, zzag, booleanValue, booleanValue2, z3, zzad2, bool, this.zzg, zzt().zza(zzap.zzbl) ? this.zzh : null, (!zzll.zzb() || !zzt().zza(zzap.zzch)) ? null : zzae());
    }

    private final String zzai() {
        if (!zznh.zzb() || !zzt().zza(zzap.zzck)) {
            try {
                Class<?> loadClass = zzn().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                if (loadClass == null) {
                    return null;
                }
                try {
                    Object invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, zzn());
                    if (invoke == null) {
                        return null;
                    }
                    try {
                        return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                    } catch (Exception unused) {
                        zzr().zzk().zza("Failed to retrieve Firebase Instance Id");
                        return null;
                    }
                } catch (Exception unused2) {
                    zzr().zzj().zza("Failed to obtain Firebase Analytics instance");
                    return null;
                }
            } catch (ClassNotFoundException unused3) {
                return null;
            }
        } else {
            zzr().zzx().zza("Disabled IID for tests.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzab() {
        zzw();
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final String zzac() {
        zzw();
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    public final String zzad() {
        zzw();
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final String zzae() {
        zzw();
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    public final int zzaf() {
        zzw();
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzag() {
        zzw();
        return this.zzi;
    }

    /* access modifiers changed from: package-private */
    public final List<String> zzah() {
        return this.zzh;
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

package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public abstract class zzcl<T> {
    private static final Object zza = new Object();
    private static Context zzb = null;
    private static boolean zzc = false;
    private static zzcz<zzcy<zzch>> zzd;
    private static final AtomicInteger zzh = new AtomicInteger();
    private final zzcr zze;
    private final String zzf;
    private final T zzg;
    private volatile int zzi;
    private volatile T zzj;

    public static void zza(Context context) {
        synchronized (zza) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzb != context) {
                zzbx.zzc();
                zzcu.zza();
                zzcg.zza();
                zzh.incrementAndGet();
                zzb = context;
                zzd = zzdc.zza(zzco.zza);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(Object obj);

    static void zza() {
        zzh.incrementAndGet();
    }

    private zzcl(zzcr zzcr, String str, T t) {
        this.zzi = -1;
        if (zzcr.zzb != null) {
            this.zze = zzcr;
            this.zzf = str;
            this.zzg = t;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzf;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.zzf);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String zzb() {
        return zza(this.zze.zzd);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zzc() {
        /*
            r6 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = com.google.android.gms.internal.measurement.zzcl.zzh
            int r0 = r0.get()
            int r1 = r6.zzi
            if (r1 >= r0) goto L_0x00f8
            monitor-enter(r6)
            int r1 = r6.zzi     // Catch:{ all -> 0x00f5 }
            if (r1 >= r0) goto L_0x00f3
            android.content.Context r1 = com.google.android.gms.internal.measurement.zzcl.zzb     // Catch:{ all -> 0x00f5 }
            if (r1 == 0) goto L_0x00eb
            android.content.Context r1 = com.google.android.gms.internal.measurement.zzcl.zzb     // Catch:{ all -> 0x00f5 }
            com.google.android.gms.internal.measurement.zzcg r1 = com.google.android.gms.internal.measurement.zzcg.zza(r1)     // Catch:{ all -> 0x00f5 }
            java.lang.String r2 = "gms:phenotype:phenotype_flag:debug_bypass_phenotype"
            java.lang.Object r1 = r1.zza(r2)     // Catch:{ all -> 0x00f5 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00f5 }
            if (r1 == 0) goto L_0x0031
            java.util.regex.Pattern r2 = com.google.android.gms.internal.measurement.zzbw.zzb     // Catch:{ all -> 0x00f5 }
            java.util.regex.Matcher r1 = r2.matcher(r1)     // Catch:{ all -> 0x00f5 }
            boolean r1 = r1.matches()     // Catch:{ all -> 0x00f5 }
            if (r1 == 0) goto L_0x0031
            r1 = 1
            goto L_0x0032
        L_0x0031:
            r1 = 0
        L_0x0032:
            r2 = 0
            if (r1 != 0) goto L_0x006f
            com.google.android.gms.internal.measurement.zzcr r1 = r6.zze     // Catch:{ all -> 0x00f5 }
            android.net.Uri r1 = r1.zzb     // Catch:{ all -> 0x00f5 }
            if (r1 == 0) goto L_0x0058
            android.content.Context r1 = com.google.android.gms.internal.measurement.zzcl.zzb     // Catch:{ all -> 0x00f5 }
            com.google.android.gms.internal.measurement.zzcr r3 = r6.zze     // Catch:{ all -> 0x00f5 }
            android.net.Uri r3 = r3.zzb     // Catch:{ all -> 0x00f5 }
            boolean r1 = com.google.android.gms.internal.measurement.zzcj.zza(r1, r3)     // Catch:{ all -> 0x00f5 }
            if (r1 == 0) goto L_0x0056
            android.content.Context r1 = com.google.android.gms.internal.measurement.zzcl.zzb     // Catch:{ all -> 0x00f5 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x00f5 }
            com.google.android.gms.internal.measurement.zzcr r3 = r6.zze     // Catch:{ all -> 0x00f5 }
            android.net.Uri r3 = r3.zzb     // Catch:{ all -> 0x00f5 }
            com.google.android.gms.internal.measurement.zzbx r1 = com.google.android.gms.internal.measurement.zzbx.zza(r1, r3)     // Catch:{ all -> 0x00f5 }
            goto L_0x005e
        L_0x0056:
            r1 = r2
            goto L_0x005e
        L_0x0058:
            android.content.Context r1 = com.google.android.gms.internal.measurement.zzcl.zzb     // Catch:{ all -> 0x00f5 }
            com.google.android.gms.internal.measurement.zzcu r1 = com.google.android.gms.internal.measurement.zzcu.zza(r1, r2)     // Catch:{ all -> 0x00f5 }
        L_0x005e:
            if (r1 == 0) goto L_0x0098
            java.lang.String r3 = r6.zzb()     // Catch:{ all -> 0x00f5 }
            java.lang.Object r1 = r1.zza(r3)     // Catch:{ all -> 0x00f5 }
            if (r1 == 0) goto L_0x0098
            java.lang.Object r1 = r6.zza(r1)     // Catch:{ all -> 0x00f5 }
            goto L_0x0099
        L_0x006f:
            java.lang.String r1 = "PhenotypeFlag"
            r3 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r3)     // Catch:{ all -> 0x00f5 }
            if (r1 == 0) goto L_0x0098
            java.lang.String r1 = "PhenotypeFlag"
            java.lang.String r3 = "Bypass reading Phenotype values for flag: "
            java.lang.String r4 = r6.zzb()     // Catch:{ all -> 0x00f5 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00f5 }
            int r5 = r4.length()     // Catch:{ all -> 0x00f5 }
            if (r5 == 0) goto L_0x008f
            java.lang.String r3 = r3.concat(r4)     // Catch:{ all -> 0x00f5 }
            goto L_0x0095
        L_0x008f:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x00f5 }
            r4.<init>(r3)     // Catch:{ all -> 0x00f5 }
            r3 = r4
        L_0x0095:
            android.util.Log.d(r1, r3)     // Catch:{ all -> 0x00f5 }
        L_0x0098:
            r1 = r2
        L_0x0099:
            if (r1 == 0) goto L_0x009c
            goto L_0x00bb
        L_0x009c:
            android.content.Context r1 = com.google.android.gms.internal.measurement.zzcl.zzb     // Catch:{ all -> 0x00f5 }
            com.google.android.gms.internal.measurement.zzcg r1 = com.google.android.gms.internal.measurement.zzcg.zza(r1)     // Catch:{ all -> 0x00f5 }
            com.google.android.gms.internal.measurement.zzcr r3 = r6.zze     // Catch:{ all -> 0x00f5 }
            java.lang.String r3 = r3.zzc     // Catch:{ all -> 0x00f5 }
            java.lang.String r3 = r6.zza(r3)     // Catch:{ all -> 0x00f5 }
            java.lang.Object r1 = r1.zza(r3)     // Catch:{ all -> 0x00f5 }
            if (r1 == 0) goto L_0x00b5
            java.lang.Object r1 = r6.zza(r1)     // Catch:{ all -> 0x00f5 }
            goto L_0x00b6
        L_0x00b5:
            r1 = r2
        L_0x00b6:
            if (r1 == 0) goto L_0x00b9
            goto L_0x00bb
        L_0x00b9:
            T r1 = r6.zzg     // Catch:{ all -> 0x00f5 }
        L_0x00bb:
            com.google.android.gms.internal.measurement.zzcz<com.google.android.gms.internal.measurement.zzcy<com.google.android.gms.internal.measurement.zzch>> r3 = com.google.android.gms.internal.measurement.zzcl.zzd     // Catch:{ all -> 0x00f5 }
            java.lang.Object r3 = r3.zza()     // Catch:{ all -> 0x00f5 }
            com.google.android.gms.internal.measurement.zzcy r3 = (com.google.android.gms.internal.measurement.zzcy) r3     // Catch:{ all -> 0x00f5 }
            boolean r4 = r3.zza()     // Catch:{ all -> 0x00f5 }
            if (r4 == 0) goto L_0x00e6
            java.lang.Object r1 = r3.zzb()     // Catch:{ all -> 0x00f5 }
            com.google.android.gms.internal.measurement.zzch r1 = (com.google.android.gms.internal.measurement.zzch) r1     // Catch:{ all -> 0x00f5 }
            com.google.android.gms.internal.measurement.zzcr r3 = r6.zze     // Catch:{ all -> 0x00f5 }
            android.net.Uri r3 = r3.zzb     // Catch:{ all -> 0x00f5 }
            com.google.android.gms.internal.measurement.zzcr r4 = r6.zze     // Catch:{ all -> 0x00f5 }
            java.lang.String r4 = r4.zzd     // Catch:{ all -> 0x00f5 }
            java.lang.String r5 = r6.zzf     // Catch:{ all -> 0x00f5 }
            java.lang.String r1 = r1.zza(r3, r2, r4, r5)     // Catch:{ all -> 0x00f5 }
            if (r1 != 0) goto L_0x00e2
            T r1 = r6.zzg     // Catch:{ all -> 0x00f5 }
            goto L_0x00e6
        L_0x00e2:
            java.lang.Object r1 = r6.zza(r1)     // Catch:{ all -> 0x00f5 }
        L_0x00e6:
            r6.zzj = r1     // Catch:{ all -> 0x00f5 }
            r6.zzi = r0     // Catch:{ all -> 0x00f5 }
            goto L_0x00f3
        L_0x00eb:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f5 }
            java.lang.String r1 = "Must call PhenotypeFlag.init() first"
            r0.<init>(r1)     // Catch:{ all -> 0x00f5 }
            throw r0     // Catch:{ all -> 0x00f5 }
        L_0x00f3:
            monitor-exit(r6)     // Catch:{ all -> 0x00f5 }
            goto L_0x00f8
        L_0x00f5:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00f5 }
            throw r0
        L_0x00f8:
            T r0 = r6.zzj
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcl.zzc():java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static zzcl<Long> zzb(zzcr zzcr, String str, long j) {
        return new zzcn(zzcr, str, Long.valueOf(j));
    }

    /* access modifiers changed from: private */
    public static zzcl<Boolean> zzb(zzcr zzcr, String str, boolean z) {
        return new zzcq(zzcr, str, Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public static zzcl<Double> zzb(zzcr zzcr, String str, double d) {
        return new zzcp(zzcr, str, Double.valueOf(d));
    }

    /* access modifiers changed from: private */
    public static zzcl<String> zzb(zzcr zzcr, String str, String str2) {
        return new zzcs(zzcr, str, str2);
    }

    static final /* synthetic */ zzcy zzd() {
        new zzck();
        return zzck.zza(zzb);
    }

    /* synthetic */ zzcl(zzcr zzcr, String str, Object obj, zzcn zzcn) {
        this(zzcr, str, obj);
    }
}

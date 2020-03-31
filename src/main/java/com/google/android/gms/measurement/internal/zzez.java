package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzez<V> {
    private static final Object zzf = new Object();
    private final String zza;
    private final zzex<V> zzb;
    private final V zzc;
    private final V zzd;
    private final Object zze;
    private volatile V zzg;
    private volatile V zzh;

    private zzez(String str, V v, V v2, zzex<V> zzex) {
        this.zze = new Object();
        this.zzg = null;
        this.zzh = null;
        this.zza = str;
        this.zzc = v;
        this.zzd = v2;
        this.zzb = zzex;
    }

    public final String zza() {
        return this.zza;
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 171 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:28|29|30|(1:32)|33|34|4c) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0023, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r4 = com.google.android.gms.measurement.internal.zzap.zzdh.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r0.zzh = r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x004a */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x004d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0065 A[SYNTHETIC, Splitter:B:51:0x0065] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V zza(V r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zze
            monitor-enter(r0)
            monitor-exit(r0)     // Catch:{ all -> 0x0079 }
            if (r4 == 0) goto L_0x0007
            return r4
        L_0x0007:
            com.google.android.gms.measurement.internal.zzw r4 = com.google.android.gms.measurement.internal.zzfa.zza
            if (r4 != 0) goto L_0x000e
            V r4 = r3.zzc
            return r4
        L_0x000e:
            com.google.android.gms.measurement.internal.zzw r4 = com.google.android.gms.measurement.internal.zzfa.zza
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zzf
            monitor-enter(r4)
            boolean r0 = com.google.android.gms.measurement.internal.zzw.zza()     // Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x0024
            V r0 = r3.zzh     // Catch:{ all -> 0x0074 }
            if (r0 != 0) goto L_0x0020
            V r0 = r3.zzc     // Catch:{ all -> 0x0074 }
            goto L_0x0022
        L_0x0020:
            V r0 = r3.zzh     // Catch:{ all -> 0x0074 }
        L_0x0022:
            monitor-exit(r4)     // Catch:{ all -> 0x0074 }
            return r0
        L_0x0024:
            monitor-exit(r4)     // Catch:{ all -> 0x0074 }
            java.util.List r4 = com.google.android.gms.measurement.internal.zzap.zzdh     // Catch:{ SecurityException -> 0x005c }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ SecurityException -> 0x005c }
        L_0x002d:
            boolean r0 = r4.hasNext()     // Catch:{ SecurityException -> 0x005c }
            if (r0 == 0) goto L_0x005c
            java.lang.Object r0 = r4.next()     // Catch:{ SecurityException -> 0x005c }
            com.google.android.gms.measurement.internal.zzez r0 = (com.google.android.gms.measurement.internal.zzez) r0     // Catch:{ SecurityException -> 0x005c }
            boolean r1 = com.google.android.gms.measurement.internal.zzw.zza()     // Catch:{ SecurityException -> 0x005c }
            if (r1 != 0) goto L_0x0054
            r1 = 0
            com.google.android.gms.measurement.internal.zzex<V> r2 = r0.zzb     // Catch:{ IllegalStateException -> 0x004a }
            if (r2 == 0) goto L_0x004a
            com.google.android.gms.measurement.internal.zzex<V> r2 = r0.zzb     // Catch:{ IllegalStateException -> 0x004a }
            java.lang.Object r1 = r2.zza()     // Catch:{ IllegalStateException -> 0x004a }
        L_0x004a:
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzez.zzf     // Catch:{ SecurityException -> 0x005c }
            monitor-enter(r2)     // Catch:{ SecurityException -> 0x005c }
            r0.zzh = r1     // Catch:{ all -> 0x0051 }
            monitor-exit(r2)     // Catch:{ all -> 0x0051 }
            goto L_0x002d
        L_0x0051:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0051 }
            throw r4     // Catch:{ SecurityException -> 0x005c }
        L_0x0054:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ SecurityException -> 0x005c }
            java.lang.String r0 = "Refreshing flag cache must be done on a worker thread."
            r4.<init>(r0)     // Catch:{ SecurityException -> 0x005c }
            throw r4     // Catch:{ SecurityException -> 0x005c }
        L_0x005c:
            com.google.android.gms.measurement.internal.zzex<V> r4 = r3.zzb
            if (r4 != 0) goto L_0x0065
            com.google.android.gms.measurement.internal.zzw r4 = com.google.android.gms.measurement.internal.zzfa.zza
            V r4 = r3.zzc
            return r4
        L_0x0065:
            java.lang.Object r4 = r4.zza()     // Catch:{ SecurityException -> 0x006f, IllegalStateException -> 0x006a }
            return r4
        L_0x006a:
            com.google.android.gms.measurement.internal.zzw r4 = com.google.android.gms.measurement.internal.zzfa.zza
            V r4 = r3.zzc
            return r4
        L_0x006f:
            com.google.android.gms.measurement.internal.zzw r4 = com.google.android.gms.measurement.internal.zzfa.zza
            V r4 = r3.zzc
            return r4
        L_0x0074:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0074 }
            throw r0
        L_0x0077:
            monitor-exit(r0)     // Catch:{ all -> 0x0079 }
            throw r4
        L_0x0079:
            r4 = move-exception
            goto L_0x0077
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzez.zza(java.lang.Object):java.lang.Object");
    }
}

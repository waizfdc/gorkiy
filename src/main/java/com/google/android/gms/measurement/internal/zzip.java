package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzip implements Runnable {
    private final URL zza;
    private final byte[] zzb = null;
    private final zziq zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzin zzf;

    public zzip(zzin zzin, String str, URL url, byte[] bArr, Map<String, String> map, zziq zziq) {
        this.zzf = zzin;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zziq);
        this.zza = url;
        this.zzc = zziq;
        this.zzd = str;
        this.zze = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.zzin r0 = r7.zzf
            r0.zzc()
            r0 = 0
            r1 = 0
            com.google.android.gms.measurement.internal.zzin r2 = r7.zzf     // Catch:{ IOException -> 0x006c, all -> 0x0060 }
            java.net.URL r3 = r7.zza     // Catch:{ IOException -> 0x006c, all -> 0x0060 }
            java.net.HttpURLConnection r2 = r2.zza(r3)     // Catch:{ IOException -> 0x006c, all -> 0x0060 }
            java.util.Map<java.lang.String, java.lang.String> r3 = r7.zze     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            if (r3 == 0) goto L_0x0039
            java.util.Map<java.lang.String, java.lang.String> r3 = r7.zze     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            java.util.Set r3 = r3.entrySet()     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ IOException -> 0x005d, all -> 0x005a }
        L_0x001d:
            boolean r4 = r3.hasNext()     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            if (r4 == 0) goto L_0x0039
            java.lang.Object r4 = r3.next()     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            java.lang.Object r5 = r4.getKey()     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            java.lang.Object r4 = r4.getValue()     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            r2.addRequestProperty(r5, r4)     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            goto L_0x001d
        L_0x0039:
            int r1 = r2.getResponseCode()     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            java.util.Map r3 = r2.getHeaderFields()     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            com.google.android.gms.measurement.internal.zzin r4 = r7.zzf     // Catch:{ IOException -> 0x0055, all -> 0x0050 }
            byte[] r4 = com.google.android.gms.measurement.internal.zzin.zza(r2)     // Catch:{ IOException -> 0x0055, all -> 0x0050 }
            if (r2 == 0) goto L_0x004c
            r2.disconnect()
        L_0x004c:
            r7.zzb(r1, r0, r4, r3)
            return
        L_0x0050:
            r4 = move-exception
            r6 = r4
            r4 = r3
            r3 = r6
            goto L_0x0063
        L_0x0055:
            r4 = move-exception
            r6 = r4
            r4 = r3
            r3 = r6
            goto L_0x006f
        L_0x005a:
            r3 = move-exception
            r4 = r0
            goto L_0x0063
        L_0x005d:
            r3 = move-exception
            r4 = r0
            goto L_0x006f
        L_0x0060:
            r3 = move-exception
            r2 = r0
            r4 = r2
        L_0x0063:
            if (r2 == 0) goto L_0x0068
            r2.disconnect()
        L_0x0068:
            r7.zzb(r1, r0, r0, r4)
            throw r3
        L_0x006c:
            r3 = move-exception
            r2 = r0
            r4 = r2
        L_0x006f:
            if (r2 == 0) goto L_0x0074
            r2.disconnect()
        L_0x0074:
            r7.zzb(r1, r3, r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzip.run():void");
    }

    private final void zzb(int i, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        this.zzf.zzq().zza(new zzis(this, i, exc, bArr, map));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        this.zzc.zza(this.zzd, i, exc, bArr, map);
    }
}

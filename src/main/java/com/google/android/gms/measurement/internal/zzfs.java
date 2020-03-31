package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzfs implements Runnable {
    private final URL zza;
    private final byte[] zzb;
    private final zzfq zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzfo zzf;

    public zzfs(zzfo zzfo, String str, URL url, byte[] bArr, Map<String, String> map, zzfq zzfq) {
        this.zzf = zzfo;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzfq);
        this.zza = url;
        this.zzb = bArr;
        this.zzc = zzfq;
        this.zzd = str;
        this.zze = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2 A[SYNTHETIC, Splitter:B:45:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x010d A[SYNTHETIC, Splitter:B:58:0x010d] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r13 = this;
            java.lang.String r0 = "Error closing HTTP compressed POST connection output stream. appId"
            com.google.android.gms.measurement.internal.zzfo r1 = r13.zzf
            r1.zzc()
            r1 = 0
            r2 = 0
            com.google.android.gms.measurement.internal.zzfo r3 = r13.zzf     // Catch:{ IOException -> 0x0106, all -> 0x00cb }
            java.net.URL r4 = r13.zza     // Catch:{ IOException -> 0x0106, all -> 0x00cb }
            java.net.HttpURLConnection r3 = r3.zza(r4)     // Catch:{ IOException -> 0x0106, all -> 0x00cb }
            java.util.Map<java.lang.String, java.lang.String> r4 = r13.zze     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            if (r4 == 0) goto L_0x003b
            java.util.Map<java.lang.String, java.lang.String> r4 = r13.zze     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
        L_0x001f:
            boolean r5 = r4.hasNext()     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            if (r5 == 0) goto L_0x003b
            java.lang.Object r5 = r4.next()     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            java.lang.Object r6 = r5.getKey()     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            r3.addRequestProperty(r6, r5)     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            goto L_0x001f
        L_0x003b:
            byte[] r4 = r13.zzb     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            if (r4 == 0) goto L_0x008a
            com.google.android.gms.measurement.internal.zzfo r4 = r13.zzf     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzkw r4 = r4.zzg()     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            byte[] r5 = r13.zzb     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            byte[] r4 = r4.zzc(r5)     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzfo r5 = r13.zzf     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzfk r5 = r5.zzr()     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzfm r5 = r5.zzx()     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            java.lang.String r6 = "Uploading data. size"
            int r7 = r4.length     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            r5.zza(r6, r7)     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            r5 = 1
            r3.setDoOutput(r5)     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r3.addRequestProperty(r5, r6)     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            int r5 = r4.length     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            r3.setFixedLengthStreamingMode(r5)     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            r3.connect()     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            java.io.OutputStream r5 = r3.getOutputStream()     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            r5.write(r4)     // Catch:{ IOException -> 0x0083, all -> 0x007c }
            r5.close()     // Catch:{ IOException -> 0x0083, all -> 0x007c }
            goto L_0x008a
        L_0x007c:
            r4 = move-exception
            r10 = r1
            r7 = r2
            r2 = r4
            r1 = r5
            goto L_0x00d0
        L_0x0083:
            r4 = move-exception
            r10 = r1
            r7 = r2
            r8 = r4
            r1 = r5
            goto L_0x010b
        L_0x008a:
            int r8 = r3.getResponseCode()     // Catch:{ IOException -> 0x00c8, all -> 0x00c5 }
            java.util.Map r11 = r3.getHeaderFields()     // Catch:{ IOException -> 0x00c1, all -> 0x00bc }
            com.google.android.gms.measurement.internal.zzfo r2 = r13.zzf     // Catch:{ IOException -> 0x00b8, all -> 0x00b3 }
            byte[] r10 = com.google.android.gms.measurement.internal.zzfo.zza(r3)     // Catch:{ IOException -> 0x00b8, all -> 0x00b3 }
            if (r3 == 0) goto L_0x009d
            r3.disconnect()
        L_0x009d:
            com.google.android.gms.measurement.internal.zzfo r0 = r13.zzf
            com.google.android.gms.measurement.internal.zzgh r0 = r0.zzq()
            com.google.android.gms.measurement.internal.zzfp r1 = new com.google.android.gms.measurement.internal.zzfp
            java.lang.String r6 = r13.zzd
            com.google.android.gms.measurement.internal.zzfq r7 = r13.zzc
            r9 = 0
            r12 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0.zza(r1)
            return
        L_0x00b3:
            r4 = move-exception
            r2 = r4
            r7 = r8
            r10 = r11
            goto L_0x00d0
        L_0x00b8:
            r4 = move-exception
            r7 = r8
            r10 = r11
            goto L_0x010a
        L_0x00bc:
            r4 = move-exception
            r10 = r1
            r2 = r4
            r7 = r8
            goto L_0x00d0
        L_0x00c1:
            r4 = move-exception
            r10 = r1
            r7 = r8
            goto L_0x010a
        L_0x00c5:
            r4 = move-exception
            r10 = r1
            goto L_0x00ce
        L_0x00c8:
            r4 = move-exception
            r10 = r1
            goto L_0x0109
        L_0x00cb:
            r4 = move-exception
            r3 = r1
            r10 = r3
        L_0x00ce:
            r7 = r2
            r2 = r4
        L_0x00d0:
            if (r1 == 0) goto L_0x00ea
            r1.close()     // Catch:{ IOException -> 0x00d6 }
            goto L_0x00ea
        L_0x00d6:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzfo r4 = r13.zzf
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzf()
            java.lang.String r5 = r13.zzd
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfk.zza(r5)
            r4.zza(r0, r5, r1)
        L_0x00ea:
            if (r3 == 0) goto L_0x00ef
            r3.disconnect()
        L_0x00ef:
            com.google.android.gms.measurement.internal.zzfo r0 = r13.zzf
            com.google.android.gms.measurement.internal.zzgh r0 = r0.zzq()
            com.google.android.gms.measurement.internal.zzfp r1 = new com.google.android.gms.measurement.internal.zzfp
            java.lang.String r5 = r13.zzd
            com.google.android.gms.measurement.internal.zzfq r6 = r13.zzc
            r8 = 0
            r9 = 0
            r11 = 0
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r0.zza(r1)
            throw r2
        L_0x0106:
            r4 = move-exception
            r3 = r1
            r10 = r3
        L_0x0109:
            r7 = r2
        L_0x010a:
            r8 = r4
        L_0x010b:
            if (r1 == 0) goto L_0x0125
            r1.close()     // Catch:{ IOException -> 0x0111 }
            goto L_0x0125
        L_0x0111:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzfo r2 = r13.zzf
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()
            java.lang.String r4 = r13.zzd
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfk.zza(r4)
            r2.zza(r0, r4, r1)
        L_0x0125:
            if (r3 == 0) goto L_0x012a
            r3.disconnect()
        L_0x012a:
            com.google.android.gms.measurement.internal.zzfo r0 = r13.zzf
            com.google.android.gms.measurement.internal.zzgh r0 = r0.zzq()
            com.google.android.gms.measurement.internal.zzfp r1 = new com.google.android.gms.measurement.internal.zzfp
            java.lang.String r5 = r13.zzd
            com.google.android.gms.measurement.internal.zzfq r6 = r13.zzc
            r9 = 0
            r11 = 0
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r0.zza(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfs.run():void");
    }
}

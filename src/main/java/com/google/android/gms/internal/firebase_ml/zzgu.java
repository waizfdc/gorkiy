package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.fitness.FitnessStatusCodes;
import io.fabric.sdk.android.services.common.AbstractSpiCall;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzgu {
    private boolean zzaaa = true;
    private boolean zzaab = true;
    @Deprecated
    private boolean zzaac = false;
    private zzjk zzaad = zzjk.zzaft;
    private final zzhd zzya;
    private zzji zzyd;
    private String zzyp;
    private zzgo zzzj;
    private zzgq zzzo;
    private zzgt zzzp = new zzgt();
    private zzgt zzzq = new zzgt();
    private int zzzr = 10;
    private int zzzs = 16384;
    private boolean zzzt = true;
    private boolean zzzu = true;
    private zzgp zzzv;
    private zzgm zzzw;
    private int zzzx = 20000;
    private int zzzy = 20000;
    private zzha zzzz;

    zzgu(zzhd zzhd, String str) {
        this.zzya = zzhd;
        zzae((String) null);
    }

    public final zzhd zzfr() {
        return this.zzya;
    }

    public final String getRequestMethod() {
        return this.zzyp;
    }

    public final zzgu zzae(String str) {
        zzmf.checkArgument(str == null || zzgv.zzaf(str));
        this.zzyp = str;
        return this;
    }

    public final zzgm zzfs() {
        return this.zzzw;
    }

    public final zzgu zza(zzgm zzgm) {
        this.zzzw = (zzgm) zzmf.checkNotNull(zzgm);
        return this;
    }

    public final zzgp zzft() {
        return this.zzzv;
    }

    public final zzgu zza(zzgp zzgp) {
        this.zzzv = zzgp;
        return this;
    }

    public final zzgu zza(zzgo zzgo) {
        this.zzzj = zzgo;
        return this;
    }

    public final int zzfu() {
        return this.zzzs;
    }

    public final boolean zzfv() {
        return this.zzzt;
    }

    public final zzgu zzad(int i) {
        zzmf.checkArgument(true);
        this.zzzx = FitnessStatusCodes.NEEDS_OAUTH_PERMISSIONS;
        return this;
    }

    public final zzgu zzae(int i) {
        zzmf.checkArgument(true);
        this.zzzy = AbstractSpiCall.DEFAULT_TIMEOUT;
        return this;
    }

    public final zzgt zzfw() {
        return this.zzzp;
    }

    public final zzgt zzfx() {
        return this.zzzq;
    }

    public final zzgu zza(zzgq zzgq) {
        this.zzzo = zzgq;
        return this;
    }

    public final zzha zzfy() {
        return this.zzzz;
    }

    public final zzgu zza(zzha zzha) {
        this.zzzz = zzha;
        return this;
    }

    public final zzgu zza(zzji zzji) {
        this.zzyd = zzji;
        return this;
    }

    public final zzji zzfz() {
        return this.zzyd;
    }

    public final boolean zzga() {
        return this.zzaab;
    }

    /* JADX WARN: Type inference failed for: r3v16, types: [com.google.android.gms.internal.firebase_ml.zzgr, com.google.android.gms.internal.firebase_ml.zzjm] */
    /* JADX WARN: Type inference failed for: r15v1, types: [com.google.android.gms.internal.firebase_ml.zzjg] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0280 A[Catch:{ all -> 0x02ab }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02a8 A[LOOP:0: B:5:0x0019->B:122:0x02a8, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x028a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0221 A[Catch:{ all -> 0x02ab }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0251 A[Catch:{ all -> 0x02ab }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x025a A[Catch:{ all -> 0x02ab }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.firebase_ml.zzgz zzgb() throws java.io.IOException {
        /*
            r18 = this;
            r1 = r18
            int r0 = r1.zzzr
            if (r0 < 0) goto L_0x0008
            r0 = 1
            goto L_0x0009
        L_0x0008:
            r0 = 0
        L_0x0009:
            com.google.android.gms.internal.firebase_ml.zzmf.checkArgument(r0)
            int r0 = r1.zzzr
            java.lang.String r4 = r1.zzyp
            com.google.android.gms.internal.firebase_ml.zzmf.checkNotNull(r4)
            com.google.android.gms.internal.firebase_ml.zzgm r4 = r1.zzzw
            com.google.android.gms.internal.firebase_ml.zzmf.checkNotNull(r4)
            r5 = 0
        L_0x0019:
            if (r5 == 0) goto L_0x001e
            r5.ignore()
        L_0x001e:
            com.google.android.gms.internal.firebase_ml.zzgq r5 = r1.zzzo
            if (r5 == 0) goto L_0x0025
            r5.zzb(r1)
        L_0x0025:
            com.google.android.gms.internal.firebase_ml.zzgm r5 = r1.zzzw
            java.lang.String r5 = r5.zzfq()
            com.google.android.gms.internal.firebase_ml.zzhd r6 = r1.zzya
            java.lang.String r7 = r1.zzyp
            com.google.android.gms.internal.firebase_ml.zzhc r6 = r6.zzc(r7, r5)
            java.util.logging.Logger r7 = com.google.android.gms.internal.firebase_ml.zzhd.zzaav
            boolean r8 = r1.zzzt
            if (r8 == 0) goto L_0x0043
            java.util.logging.Level r8 = java.util.logging.Level.CONFIG
            boolean r8 = r7.isLoggable(r8)
            if (r8 == 0) goto L_0x0043
            r8 = 1
            goto L_0x0044
        L_0x0043:
            r8 = 0
        L_0x0044:
            java.lang.String r9 = "GET"
            if (r8 == 0) goto L_0x0087
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "-------------- REQUEST  --------------"
            r10.append(r11)
            java.lang.String r11 = com.google.android.gms.internal.firebase_ml.zzjl.zzafu
            r10.append(r11)
            java.lang.String r11 = r1.zzyp
            r10.append(r11)
            r11 = 32
            r10.append(r11)
            r10.append(r5)
            java.lang.String r11 = com.google.android.gms.internal.firebase_ml.zzjl.zzafu
            r10.append(r11)
            boolean r11 = r1.zzzu
            if (r11 == 0) goto L_0x0088
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "curl -v --compressed"
            r11.<init>(r12)
            java.lang.String r12 = r1.zzyp
            boolean r12 = r12.equals(r9)
            if (r12 != 0) goto L_0x0089
            java.lang.String r12 = " -X "
            r11.append(r12)
            java.lang.String r12 = r1.zzyp
            r11.append(r12)
            goto L_0x0089
        L_0x0087:
            r10 = 0
        L_0x0088:
            r11 = 0
        L_0x0089:
            com.google.android.gms.internal.firebase_ml.zzgt r12 = r1.zzzp
            java.lang.String r12 = r12.getUserAgent()
            if (r12 != 0) goto L_0x0099
            com.google.android.gms.internal.firebase_ml.zzgt r13 = r1.zzzp
            java.lang.String r14 = "Google-HTTP-Java-Client/1.26.0-SNAPSHOT (gzip)"
            r13.zzad(r14)
            goto L_0x00b9
        L_0x0099:
            com.google.android.gms.internal.firebase_ml.zzgt r13 = r1.zzzp
            java.lang.String r14 = java.lang.String.valueOf(r12)
            int r14 = r14.length()
            int r14 = r14 + 47
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r14)
            r15.append(r12)
            java.lang.String r14 = " Google-HTTP-Java-Client/1.26.0-SNAPSHOT (gzip)"
            r15.append(r14)
            java.lang.String r14 = r15.toString()
            r13.zzad(r14)
        L_0x00b9:
            com.google.android.gms.internal.firebase_ml.zzgt r13 = r1.zzzp
            com.google.android.gms.internal.firebase_ml.zzgt.zza(r13, r10, r11, r7, r6)
            com.google.android.gms.internal.firebase_ml.zzgt r13 = r1.zzzp
            r13.zzad(r12)
            com.google.android.gms.internal.firebase_ml.zzgp r12 = r1.zzzv
            if (r12 == 0) goto L_0x00ca
            r12.zzfp()
        L_0x00ca:
            java.lang.String r13 = "'"
            if (r12 == 0) goto L_0x01ce
            com.google.android.gms.internal.firebase_ml.zzgp r14 = r1.zzzv
            java.lang.String r14 = r14.getType()
            if (r8 == 0) goto L_0x00e2
            com.google.android.gms.internal.firebase_ml.zzjg r15 = new com.google.android.gms.internal.firebase_ml.zzjg
            java.util.logging.Logger r2 = com.google.android.gms.internal.firebase_ml.zzhd.zzaav
            java.util.logging.Level r3 = java.util.logging.Level.CONFIG
            int r4 = r1.zzzs
            r15.<init>(r12, r2, r3, r4)
            r12 = r15
        L_0x00e2:
            com.google.android.gms.internal.firebase_ml.zzgo r2 = r1.zzzj
            if (r2 != 0) goto L_0x00ee
            com.google.android.gms.internal.firebase_ml.zzgp r2 = r1.zzzv
            long r2 = r2.getLength()
            r4 = 0
            goto L_0x0101
        L_0x00ee:
            java.lang.String r2 = r2.getName()
            com.google.android.gms.internal.firebase_ml.zzgr r3 = new com.google.android.gms.internal.firebase_ml.zzgr
            com.google.android.gms.internal.firebase_ml.zzgo r4 = r1.zzzj
            r3.<init>(r12, r4)
            long r16 = com.google.android.gms.internal.firebase_ml.zzja.zzb(r3)
            r4 = r2
            r12 = r3
            r2 = r16
        L_0x0101:
            if (r8 == 0) goto L_0x01b6
            java.lang.String r15 = " -H '"
            if (r14 == 0) goto L_0x014e
            r16 = r9
            java.lang.String r9 = "Content-Type: "
            java.lang.String r1 = java.lang.String.valueOf(r14)
            int r17 = r1.length()
            if (r17 == 0) goto L_0x011a
            java.lang.String r1 = r9.concat(r1)
            goto L_0x011f
        L_0x011a:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r9)
        L_0x011f:
            r10.append(r1)
            java.lang.String r9 = com.google.android.gms.internal.firebase_ml.zzjl.zzafu
            r10.append(r9)
            if (r11 == 0) goto L_0x014b
            java.lang.String r9 = java.lang.String.valueOf(r1)
            int r9 = r9.length()
            int r9 = r9 + 6
            r17 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r9)
            r0.append(r15)
            r0.append(r1)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            r11.append(r0)
            goto L_0x0152
        L_0x014b:
            r17 = r0
            goto L_0x0152
        L_0x014e:
            r17 = r0
            r16 = r9
        L_0x0152:
            if (r4 == 0) goto L_0x0194
            java.lang.String r0 = "Content-Encoding: "
            java.lang.String r1 = java.lang.String.valueOf(r4)
            int r9 = r1.length()
            if (r9 == 0) goto L_0x0165
            java.lang.String r0 = r0.concat(r1)
            goto L_0x016b
        L_0x0165:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r0)
            r0 = r1
        L_0x016b:
            r10.append(r0)
            java.lang.String r1 = com.google.android.gms.internal.firebase_ml.zzjl.zzafu
            r10.append(r1)
            if (r11 == 0) goto L_0x0194
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            int r1 = r1 + 6
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r1)
            r9.append(r15)
            r9.append(r0)
            r9.append(r13)
            java.lang.String r0 = r9.toString()
            r11.append(r0)
        L_0x0194:
            r0 = 0
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x01ba
            r0 = 36
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Content-Length: "
            r1.append(r0)
            r1.append(r2)
            java.lang.String r0 = r1.toString()
            r10.append(r0)
            java.lang.String r0 = com.google.android.gms.internal.firebase_ml.zzjl.zzafu
            r10.append(r0)
            goto L_0x01ba
        L_0x01b6:
            r17 = r0
            r16 = r9
        L_0x01ba:
            if (r11 == 0) goto L_0x01c1
            java.lang.String r0 = " -d '@-'"
            r11.append(r0)
        L_0x01c1:
            r6.setContentType(r14)
            r6.setContentEncoding(r4)
            r6.setContentLength(r2)
            r6.zza(r12)
            goto L_0x01d2
        L_0x01ce:
            r17 = r0
            r16 = r9
        L_0x01d2:
            if (r8 == 0) goto L_0x0204
            java.util.logging.Level r0 = java.util.logging.Level.CONFIG
            java.lang.String r1 = r10.toString()
            java.lang.String r2 = "execute"
            java.lang.String r3 = "com.google.api.client.http.HttpRequest"
            r7.logp(r0, r3, r2, r1)
            if (r11 == 0) goto L_0x0204
            java.lang.String r0 = " -- '"
            r11.append(r0)
            java.lang.String r0 = "'\"'\"'"
            java.lang.String r0 = r5.replaceAll(r13, r0)
            r11.append(r0)
            r11.append(r13)
            if (r12 == 0) goto L_0x01fb
            java.lang.String r0 = " << $$$"
            r11.append(r0)
        L_0x01fb:
            java.util.logging.Level r0 = java.util.logging.Level.CONFIG
            java.lang.String r1 = r11.toString()
            r7.logp(r0, r3, r2, r1)
        L_0x0204:
            if (r17 <= 0) goto L_0x0208
            r0 = 1
            goto L_0x0209
        L_0x0208:
            r0 = 0
        L_0x0209:
            r1 = r18
            int r2 = r1.zzzx
            int r3 = r1.zzzy
            r6.zza(r2, r3)
            com.google.android.gms.internal.firebase_ml.zzhf r2 = r6.zzgh()     // Catch:{ IOException -> 0x02bb }
            com.google.android.gms.internal.firebase_ml.zzgz r5 = new com.google.android.gms.internal.firebase_ml.zzgz     // Catch:{ all -> 0x02b0 }
            r5.<init>(r1, r2)     // Catch:{ all -> 0x02b0 }
            boolean r2 = r5.zzgd()     // Catch:{ all -> 0x02ab }
            if (r2 != 0) goto L_0x0284
            int r2 = r5.getStatusCode()     // Catch:{ all -> 0x02ab }
            com.google.android.gms.internal.firebase_ml.zzgt r3 = r5.zzfw()     // Catch:{ all -> 0x02ab }
            java.lang.String r3 = r3.getLocation()     // Catch:{ all -> 0x02ab }
            boolean r4 = r1.zzaaa     // Catch:{ all -> 0x02ab }
            if (r4 == 0) goto L_0x027b
            r4 = 307(0x133, float:4.3E-43)
            if (r2 == r4) goto L_0x023a
            switch(r2) {
                case 301: goto L_0x023a;
                case 302: goto L_0x023a;
                case 303: goto L_0x023a;
                default: goto L_0x0238;
            }     // Catch:{ all -> 0x02ab }
        L_0x0238:
            r4 = 0
            goto L_0x023b
        L_0x023a:
            r4 = 1
        L_0x023b:
            if (r4 == 0) goto L_0x027b
            if (r3 == 0) goto L_0x027b
            com.google.android.gms.internal.firebase_ml.zzgm r4 = new com.google.android.gms.internal.firebase_ml.zzgm     // Catch:{ all -> 0x02ab }
            com.google.android.gms.internal.firebase_ml.zzgm r6 = r1.zzzw     // Catch:{ all -> 0x02ab }
            java.net.URL r3 = r6.zzt(r3)     // Catch:{ all -> 0x02ab }
            r4.<init>(r3)     // Catch:{ all -> 0x02ab }
            r1.zza(r4)     // Catch:{ all -> 0x02ab }
            r3 = 303(0x12f, float:4.25E-43)
            if (r2 != r3) goto L_0x025a
            r2 = r16
            r1.zzae(r2)     // Catch:{ all -> 0x02ab }
            r2 = 0
            r1.zzzv = r2     // Catch:{ all -> 0x02ab }
            goto L_0x025b
        L_0x025a:
            r2 = 0
        L_0x025b:
            com.google.android.gms.internal.firebase_ml.zzgt r3 = r1.zzzp     // Catch:{ all -> 0x02ab }
            r3.zzx(r2)     // Catch:{ all -> 0x02ab }
            com.google.android.gms.internal.firebase_ml.zzgt r3 = r1.zzzp     // Catch:{ all -> 0x02ab }
            r3.zzz(r2)     // Catch:{ all -> 0x02ab }
            com.google.android.gms.internal.firebase_ml.zzgt r3 = r1.zzzp     // Catch:{ all -> 0x02ab }
            r3.zzaa(r2)     // Catch:{ all -> 0x02ab }
            com.google.android.gms.internal.firebase_ml.zzgt r3 = r1.zzzp     // Catch:{ all -> 0x02ab }
            r3.zzy(r2)     // Catch:{ all -> 0x02ab }
            com.google.android.gms.internal.firebase_ml.zzgt r3 = r1.zzzp     // Catch:{ all -> 0x02ab }
            r3.zzab(r2)     // Catch:{ all -> 0x02ab }
            com.google.android.gms.internal.firebase_ml.zzgt r3 = r1.zzzp     // Catch:{ all -> 0x02ab }
            r3.zzac(r2)     // Catch:{ all -> 0x02ab }
            r3 = 1
            goto L_0x027d
        L_0x027b:
            r2 = 0
            r3 = 0
        L_0x027d:
            r0 = r0 & r3
            if (r0 == 0) goto L_0x0286
            r5.ignore()     // Catch:{ all -> 0x02ab }
            goto L_0x0286
        L_0x0284:
            r2 = 0
            r0 = 0
        L_0x0286:
            int r3 = r17 + -1
            if (r0 != 0) goto L_0x02a8
            com.google.android.gms.internal.firebase_ml.zzha r0 = r1.zzzz
            if (r0 == 0) goto L_0x0291
            r0.zza(r5)
        L_0x0291:
            boolean r0 = r1.zzaab
            if (r0 == 0) goto L_0x02a7
            boolean r0 = r5.zzgd()
            if (r0 == 0) goto L_0x029c
            goto L_0x02a7
        L_0x029c:
            com.google.android.gms.internal.firebase_ml.zzgy r0 = new com.google.android.gms.internal.firebase_ml.zzgy     // Catch:{ all -> 0x02a2 }
            r0.<init>(r5)     // Catch:{ all -> 0x02a2 }
            throw r0     // Catch:{ all -> 0x02a2 }
        L_0x02a2:
            r0 = move-exception
            r5.disconnect()
            throw r0
        L_0x02a7:
            return r5
        L_0x02a8:
            r0 = r3
            goto L_0x0019
        L_0x02ab:
            r0 = move-exception
            r5.disconnect()
            throw r0
        L_0x02b0:
            r0 = move-exception
            java.io.InputStream r2 = r2.getContent()     // Catch:{ IOException -> 0x02bb }
            if (r2 == 0) goto L_0x02ba
            r2.close()     // Catch:{ IOException -> 0x02bb }
        L_0x02ba:
            throw r0     // Catch:{ IOException -> 0x02bb }
        L_0x02bb:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzgu.zzgb():com.google.android.gms.internal.firebase_ml.zzgz");
    }
}

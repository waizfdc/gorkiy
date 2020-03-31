package com.google.android.gms.internal.firebase_ml;

import okio.Utf8;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzii extends zzih {
    private static final byte[] zzadc = {13, 10};
    private static final byte[] zzadd = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] zzade = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] zzadf = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    private final byte[] zzadg;
    private final byte[] zzadh;
    private final byte[] zzadi;
    private final int zzadj;
    private final int zzadk;

    public zzii() {
        this(0);
    }

    private zzii(int i) {
        this(0, zzadc);
    }

    private zzii(int i, byte[] bArr) {
        this(0, bArr, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzii(int r9, byte[] r10, boolean r11) {
        /*
            r8 = this;
            r0 = 0
            if (r10 != 0) goto L_0x0005
            r1 = r0
            goto L_0x0006
        L_0x0005:
            int r1 = r10.length
        L_0x0006:
            r2 = 4
            r3 = 3
            r8.<init>(r3, r2, r9, r1)
            byte[] r1 = com.google.android.gms.internal.firebase_ml.zzii.zzadf
            r8.zzadh = r1
            r1 = 0
            r3 = 1
            if (r10 == 0) goto L_0x0060
            if (r10 == 0) goto L_0x002b
            int r4 = r10.length
            r5 = r0
        L_0x0017:
            if (r5 >= r4) goto L_0x002b
            byte r6 = r10[r5]
            byte r7 = r8.zzacx
            if (r7 == r6) goto L_0x0029
            boolean r6 = r8.zza(r6)
            if (r6 == 0) goto L_0x0026
            goto L_0x0029
        L_0x0026:
            int r5 = r5 + 1
            goto L_0x0017
        L_0x0029:
            r4 = r3
            goto L_0x002c
        L_0x002b:
            r4 = r0
        L_0x002c:
            if (r4 != 0) goto L_0x0043
            if (r9 <= 0) goto L_0x003e
            int r9 = r10.length
            int r9 = r9 + r2
            r8.zzadk = r9
            int r9 = r10.length
            byte[] r9 = new byte[r9]
            r8.zzadi = r9
            int r1 = r10.length
            java.lang.System.arraycopy(r10, r0, r9, r0, r1)
            goto L_0x0064
        L_0x003e:
            r8.zzadk = r2
            r8.zzadi = r1
            goto L_0x0064
        L_0x0043:
            java.lang.String r9 = com.google.android.gms.internal.firebase_ml.zzij.zzd(r10)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r0 = "lineSeparator must not contain base64 characters: ["
            r11.<init>(r0)
            r11.append(r9)
            java.lang.String r9 = "]"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r10.<init>(r9)
            throw r10
        L_0x0060:
            r8.zzadk = r2
            r8.zzadi = r1
        L_0x0064:
            int r9 = r8.zzadk
            int r9 = r9 - r3
            r8.zzadj = r9
            if (r11 == 0) goto L_0x006e
            byte[] r9 = com.google.android.gms.internal.firebase_ml.zzii.zzade
            goto L_0x0070
        L_0x006e:
            byte[] r9 = com.google.android.gms.internal.firebase_ml.zzii.zzadd
        L_0x0070:
            r8.zzadg = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzii.<init>(int, byte[], boolean):void");
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v27, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(byte[] r8, int r9, int r10, com.google.android.gms.internal.firebase_ml.zzik r11) {
        /*
            r7 = this;
            boolean r0 = r11.eof
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r10 >= 0) goto L_0x00e3
            r11.eof = r1
            int r8 = r11.zzado
            if (r8 != 0) goto L_0x0014
            int r8 = r7.zzada
            if (r8 != 0) goto L_0x0014
            return
        L_0x0014:
            int r8 = r7.zzadk
            byte[] r8 = r7.zza(r8, r11)
            int r9 = r11.pos
            int r10 = r11.zzado
            if (r10 == 0) goto L_0x00c0
            r2 = 2
            if (r10 == r1) goto L_0x0082
            if (r10 != r2) goto L_0x006c
            int r10 = r11.pos
            int r1 = r10 + 1
            r11.pos = r1
            byte[] r1 = r7.zzadg
            int r3 = r11.zzadl
            int r3 = r3 >> 10
            r3 = r3 & 63
            byte r1 = r1[r3]
            r8[r10] = r1
            int r10 = r11.pos
            int r1 = r10 + 1
            r11.pos = r1
            byte[] r1 = r7.zzadg
            int r3 = r11.zzadl
            int r3 = r3 >> 4
            r3 = r3 & 63
            byte r1 = r1[r3]
            r8[r10] = r1
            int r10 = r11.pos
            int r1 = r10 + 1
            r11.pos = r1
            byte[] r1 = r7.zzadg
            int r3 = r11.zzadl
            int r2 = r3 << 2
            r2 = r2 & 63
            byte r1 = r1[r2]
            r8[r10] = r1
            byte[] r10 = r7.zzadg
            byte[] r1 = com.google.android.gms.internal.firebase_ml.zzii.zzadd
            if (r10 != r1) goto L_0x00c0
            int r10 = r11.pos
            int r1 = r10 + 1
            r11.pos = r1
            byte r1 = r7.zzacx
            r8[r10] = r1
            goto L_0x00c0
        L_0x006c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Impossible modulus "
            r9.<init>(r10)
            int r10 = r11.zzado
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x0082:
            int r10 = r11.pos
            int r1 = r10 + 1
            r11.pos = r1
            byte[] r1 = r7.zzadg
            int r3 = r11.zzadl
            int r2 = r3 >> 2
            r2 = r2 & 63
            byte r1 = r1[r2]
            r8[r10] = r1
            int r10 = r11.pos
            int r1 = r10 + 1
            r11.pos = r1
            byte[] r1 = r7.zzadg
            int r2 = r11.zzadl
            int r2 = r2 << 4
            r2 = r2 & 63
            byte r1 = r1[r2]
            r8[r10] = r1
            byte[] r10 = r7.zzadg
            byte[] r1 = com.google.android.gms.internal.firebase_ml.zzii.zzadd
            if (r10 != r1) goto L_0x00c0
            int r10 = r11.pos
            int r1 = r10 + 1
            r11.pos = r1
            byte r1 = r7.zzacx
            r8[r10] = r1
            int r10 = r11.pos
            int r1 = r10 + 1
            r11.pos = r1
            byte r1 = r7.zzacx
            r8[r10] = r1
        L_0x00c0:
            int r10 = r11.zzadn
            int r1 = r11.pos
            int r1 = r1 - r9
            int r10 = r10 + r1
            r11.zzadn = r10
            int r9 = r7.zzada
            if (r9 <= 0) goto L_0x00e2
            int r9 = r11.zzadn
            if (r9 <= 0) goto L_0x00e2
            byte[] r9 = r7.zzadi
            int r10 = r11.pos
            byte[] r1 = r7.zzadi
            int r1 = r1.length
            java.lang.System.arraycopy(r9, r0, r8, r10, r1)
            int r8 = r11.pos
            byte[] r9 = r7.zzadi
            int r9 = r9.length
            int r8 = r8 + r9
            r11.pos = r8
        L_0x00e2:
            return
        L_0x00e3:
            r2 = r0
        L_0x00e4:
            if (r2 >= r10) goto L_0x0175
            int r3 = r7.zzadk
            byte[] r3 = r7.zza(r3, r11)
            int r4 = r11.zzado
            int r4 = r4 + r1
            int r4 = r4 % 3
            r11.zzado = r4
            int r4 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x00fb
            int r9 = r9 + 256
        L_0x00fb:
            int r5 = r11.zzadl
            int r5 = r5 << 8
            int r5 = r5 + r9
            r11.zzadl = r5
            int r9 = r11.zzado
            if (r9 != 0) goto L_0x0170
            int r9 = r11.pos
            int r5 = r9 + 1
            r11.pos = r5
            byte[] r5 = r7.zzadg
            int r6 = r11.zzadl
            int r6 = r6 >> 18
            r6 = r6 & 63
            byte r5 = r5[r6]
            r3[r9] = r5
            int r9 = r11.pos
            int r5 = r9 + 1
            r11.pos = r5
            byte[] r5 = r7.zzadg
            int r6 = r11.zzadl
            int r6 = r6 >> 12
            r6 = r6 & 63
            byte r5 = r5[r6]
            r3[r9] = r5
            int r9 = r11.pos
            int r5 = r9 + 1
            r11.pos = r5
            byte[] r5 = r7.zzadg
            int r6 = r11.zzadl
            int r6 = r6 >> 6
            r6 = r6 & 63
            byte r5 = r5[r6]
            r3[r9] = r5
            int r9 = r11.pos
            int r5 = r9 + 1
            r11.pos = r5
            byte[] r5 = r7.zzadg
            int r6 = r11.zzadl
            r6 = r6 & 63
            byte r5 = r5[r6]
            r3[r9] = r5
            int r9 = r11.zzadn
            int r9 = r9 + 4
            r11.zzadn = r9
            int r9 = r7.zzada
            if (r9 <= 0) goto L_0x0170
            int r9 = r7.zzada
            int r5 = r11.zzadn
            if (r9 > r5) goto L_0x0170
            byte[] r9 = r7.zzadi
            int r5 = r11.pos
            byte[] r6 = r7.zzadi
            int r6 = r6.length
            java.lang.System.arraycopy(r9, r0, r3, r5, r6)
            int r9 = r11.pos
            byte[] r3 = r7.zzadi
            int r3 = r3.length
            int r9 = r9 + r3
            r11.pos = r9
            r11.zzadn = r0
        L_0x0170:
            int r2 = r2 + 1
            r9 = r4
            goto L_0x00e4
        L_0x0175:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzii.zza(byte[], int, int, com.google.android.gms.internal.firebase_ml.zzik):void");
    }

    public static String zzc(byte[] bArr) {
        if (!(bArr == null || bArr.length == 0)) {
            zzii zzii = new zzii(0, zzadc, true);
            long zzb = super.zzb(bArr);
            if (zzb > 2147483647L) {
                throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + zzb + ") than the specified maximum size of 2147483647");
            } else if (!(bArr == null || bArr.length == 0)) {
                zzik zzik = new zzik();
                super.zza(bArr, 0, bArr.length, zzik);
                super.zza(bArr, 0, -1, zzik);
                int i = zzik.pos - zzik.zzadm;
                byte[] bArr2 = new byte[i];
                if (zzik.buffer != null) {
                    int min = Math.min(zzik.buffer != null ? zzik.pos - zzik.zzadm : 0, i);
                    System.arraycopy(zzik.buffer, zzik.zzadm, bArr2, 0, min);
                    zzik.zzadm += min;
                    if (zzik.zzadm >= zzik.pos) {
                        zzik.buffer = null;
                    }
                } else {
                    boolean z = zzik.eof;
                }
                bArr = bArr2;
            }
        }
        return zzij.zzd(bArr);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(byte b) {
        if (b < 0) {
            return false;
        }
        byte[] bArr = this.zzadh;
        return b < bArr.length && bArr[b] != -1;
    }
}

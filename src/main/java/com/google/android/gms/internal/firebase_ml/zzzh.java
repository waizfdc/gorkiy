package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzzh extends zzzc {
    zzzh() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r8) > -65) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r8) > -65) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00f9, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0120, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(int r22, byte[] r23, int r24, int r25) {
        /*
            r21 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r2 | r3
            int r5 = r1.length
            int r5 = r5 - r3
            r4 = r4 | r5
            r7 = 0
            if (r4 < 0) goto L_0x0153
            long r8 = (long) r2
            long r2 = (long) r3
            r4 = -19
            r10 = -62
            r11 = -16
            r12 = 16
            r13 = -96
            r14 = -32
            r15 = -1
            r6 = -65
            r16 = 1
            if (r0 == 0) goto L_0x00b0
            int r18 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r18 < 0) goto L_0x002a
            return r0
        L_0x002a:
            byte r5 = (byte) r0
            if (r5 >= r14) goto L_0x003d
            if (r5 < r10) goto L_0x003c
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r8)
            if (r0 <= r6) goto L_0x0038
            goto L_0x003c
        L_0x0038:
            r8 = r19
            goto L_0x00b0
        L_0x003c:
            return r15
        L_0x003d:
            if (r5 >= r11) goto L_0x0069
            int r0 = r0 >> 8
            int r0 = ~r0
            byte r0 = (byte) r0
            if (r0 != 0) goto L_0x0056
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r8)
            int r8 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
            if (r8 < 0) goto L_0x0054
            int r0 = com.google.android.gms.internal.firebase_ml.zzzb.zzw(r5, r0)
            return r0
        L_0x0054:
            r8 = r19
        L_0x0056:
            if (r0 > r6) goto L_0x0068
            if (r5 != r14) goto L_0x005c
            if (r0 < r13) goto L_0x0068
        L_0x005c:
            if (r5 != r4) goto L_0x0060
            if (r0 >= r13) goto L_0x0068
        L_0x0060:
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r8)
            if (r0 <= r6) goto L_0x0038
        L_0x0068:
            return r15
        L_0x0069:
            int r4 = r0 >> 8
            int r4 = ~r4
            byte r4 = (byte) r4
            if (r4 != 0) goto L_0x0082
            long r19 = r8 + r16
            byte r4 = com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r8)
            int r0 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x007e
            int r0 = com.google.android.gms.internal.firebase_ml.zzzb.zzw(r5, r4)
            return r0
        L_0x007e:
            r0 = r7
            r8 = r19
            goto L_0x0084
        L_0x0082:
            int r0 = r0 >> r12
            byte r0 = (byte) r0
        L_0x0084:
            if (r0 != 0) goto L_0x0097
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r8)
            int r8 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
            if (r8 < 0) goto L_0x0095
            int r0 = com.google.android.gms.internal.firebase_ml.zzzb.zze(r5, r4, r0)
            return r0
        L_0x0095:
            r8 = r19
        L_0x0097:
            if (r4 > r6) goto L_0x00af
            int r5 = r5 << 28
            int r4 = r4 + 112
            int r5 = r5 + r4
            int r4 = r5 >> 30
            if (r4 != 0) goto L_0x00af
            if (r0 > r6) goto L_0x00af
            long r4 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r8)
            if (r0 <= r6) goto L_0x00ad
            goto L_0x00af
        L_0x00ad:
            r8 = r4
            goto L_0x00b0
        L_0x00af:
            return r15
        L_0x00b0:
            long r2 = r2 - r8
            int r0 = (int) r2
            if (r0 >= r12) goto L_0x00b6
            r2 = r7
            goto L_0x00c9
        L_0x00b6:
            r2 = r7
            r3 = r8
        L_0x00b8:
            if (r2 >= r0) goto L_0x00c8
            long r19 = r3 + r16
            byte r3 = com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r3)
            if (r3 >= 0) goto L_0x00c3
            goto L_0x00c9
        L_0x00c3:
            int r2 = r2 + 1
            r3 = r19
            goto L_0x00b8
        L_0x00c8:
            r2 = r0
        L_0x00c9:
            int r0 = r0 - r2
            long r2 = (long) r2
            long r8 = r8 + r2
        L_0x00cc:
            r2 = r7
        L_0x00cd:
            if (r0 <= 0) goto L_0x00de
            long r2 = r8 + r16
            byte r4 = com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r8)
            if (r4 < 0) goto L_0x00dc
            int r0 = r0 + -1
            r8 = r2
            r2 = r4
            goto L_0x00cd
        L_0x00dc:
            r8 = r2
            r2 = r4
        L_0x00de:
            if (r0 != 0) goto L_0x00e1
            return r7
        L_0x00e1:
            int r0 = r0 + -1
            if (r2 >= r14) goto L_0x00fa
            if (r0 != 0) goto L_0x00e8
            return r2
        L_0x00e8:
            int r0 = r0 + -1
            if (r2 < r10) goto L_0x00f9
            long r2 = r8 + r16
            byte r4 = com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r8)
            if (r4 <= r6) goto L_0x00f5
            goto L_0x00f9
        L_0x00f5:
            r8 = r2
            r12 = -19
            goto L_0x00cc
        L_0x00f9:
            return r15
        L_0x00fa:
            if (r2 >= r11) goto L_0x0121
            r3 = 2
            if (r0 >= r3) goto L_0x0104
            int r0 = zza(r1, r2, r8, r0)
            return r0
        L_0x0104:
            int r0 = r0 + -2
            long r3 = r8 + r16
            byte r5 = com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r8)
            if (r5 > r6) goto L_0x0120
            if (r2 != r14) goto L_0x0112
            if (r5 < r13) goto L_0x0120
        L_0x0112:
            r12 = -19
            if (r2 != r12) goto L_0x0118
            if (r5 >= r13) goto L_0x0120
        L_0x0118:
            long r8 = r3 + r16
            byte r2 = com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r3)
            if (r2 <= r6) goto L_0x00cc
        L_0x0120:
            return r15
        L_0x0121:
            r3 = 3
            r12 = -19
            if (r0 >= r3) goto L_0x012b
            int r0 = zza(r1, r2, r8, r0)
            return r0
        L_0x012b:
            int r0 = r0 + -3
            long r3 = r8 + r16
            byte r5 = com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r8)
            if (r5 > r6) goto L_0x0152
            int r2 = r2 << 28
            int r5 = r5 + 112
            int r2 = r2 + r5
            int r2 = r2 >> 30
            if (r2 != 0) goto L_0x0152
            long r8 = r3 + r16
            byte r2 = com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r3)
            if (r2 > r6) goto L_0x0152
            long r2 = r8 + r16
            byte r4 = com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r8)
            if (r4 <= r6) goto L_0x014f
            goto L_0x0152
        L_0x014f:
            r8 = r2
            goto L_0x00cc
        L_0x0152:
            return r15
        L_0x0153:
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            int r1 = r1.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4[r7] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r24)
            r2 = 1
            r4[r2] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r25)
            r2 = 2
            r4[r2] = r1
            java.lang.String r1 = "Array length=%d, index=%d, limit=%d"
            java.lang.String r1 = java.lang.String.format(r1, r4)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzzh.zzb(int, byte[], int, int):int");
    }

    /* access modifiers changed from: package-private */
    public final String zzh(byte[] bArr, int i, int i2) throws zzwg {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (r13 < i3) {
                byte zza = zzyy.zza(bArr, (long) r13);
                if (!zzzd.zze(zza)) {
                    break;
                }
                i = r13 + 1;
                zzzd.zza(zza, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (r13 < i3) {
                int i6 = r13 + 1;
                byte zza2 = zzyy.zza(bArr, (long) r13);
                if (zzzd.zze(zza2)) {
                    int i7 = i5 + 1;
                    zzzd.zza(zza2, cArr, i5);
                    while (i6 < i3) {
                        byte zza3 = zzyy.zza(bArr, (long) i6);
                        if (!zzzd.zze(zza3)) {
                            break;
                        }
                        i6++;
                        zzzd.zza(zza3, cArr, i7);
                        i7++;
                    }
                    r13 = i6;
                    i5 = i7;
                } else if (zzzd.zzf(zza2)) {
                    if (i6 < i3) {
                        zzzd.zza(zza2, zzyy.zza(bArr, (long) i6), cArr, i5);
                        r13 = i6 + 1;
                        i5++;
                    } else {
                        throw zzwg.zzun();
                    }
                } else if (zzzd.zzg(zza2)) {
                    if (i6 < i3 - 1) {
                        int i8 = i6 + 1;
                        zzzd.zza(zza2, zzyy.zza(bArr, (long) i6), zzyy.zza(bArr, (long) i8), cArr, i5);
                        r13 = i8 + 1;
                        i5++;
                    } else {
                        throw zzwg.zzun();
                    }
                } else if (i6 < i3 - 2) {
                    int i9 = i6 + 1;
                    byte zza4 = zzyy.zza(bArr, (long) i6);
                    int i10 = i9 + 1;
                    zzzd.zza(zza2, zza4, zzyy.zza(bArr, (long) i9), zzyy.zza(bArr, (long) i10), cArr, i5);
                    r13 = i10 + 1;
                    i5 = i5 + 1 + 1;
                } else {
                    throw zzwg.zzun();
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:37:0x00fc, LOOP_START, PHI: r2 r3 r4 r11 10  PHI: (r2v4 int) = (r2v3 int), (r2v6 int) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r3v3 char) = (r3v2 char), (r3v4 char) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r4v3 long) = (r4v2 long), (r4v5 long) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r11v3 long) = (r11v2 long), (r11v5 long) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.CharSequence r22, byte[] r23, int r24, int r25) {
        /*
            r21 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            long r4 = (long) r2
            long r6 = (long) r3
            long r6 = r6 + r4
            int r8 = r22.length()
            java.lang.String r9 = " at index "
            java.lang.String r10 = "Failed writing "
            if (r8 > r3) goto L_0x0146
            int r11 = r1.length
            int r11 = r11 - r3
            if (r11 < r2) goto L_0x0146
            r2 = 0
        L_0x001a:
            r3 = 128(0x80, float:1.794E-43)
            r11 = 1
            if (r2 >= r8) goto L_0x002f
            char r13 = r0.charAt(r2)
            if (r13 >= r3) goto L_0x002f
            long r11 = r11 + r4
            byte r3 = (byte) r13
            com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r4, r3)
            int r2 = r2 + 1
            r4 = r11
            goto L_0x001a
        L_0x002f:
            if (r2 != r8) goto L_0x0033
            int r0 = (int) r4
            return r0
        L_0x0033:
            if (r2 >= r8) goto L_0x0144
            char r13 = r0.charAt(r2)
            if (r13 >= r3) goto L_0x004a
            int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r14 >= 0) goto L_0x004a
            long r14 = r4 + r11
            byte r13 = (byte) r13
            com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r4, r13)
            r4 = r11
            r12 = r14
            r11 = r3
            goto L_0x00fc
        L_0x004a:
            r14 = 2048(0x800, float:2.87E-42)
            if (r13 >= r14) goto L_0x0074
            r14 = 2
            long r14 = r6 - r14
            int r14 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x0074
            long r14 = r4 + r11
            int r3 = r13 >>> 6
            r3 = r3 | 960(0x3c0, float:1.345E-42)
            byte r3 = (byte) r3
            com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r4, r3)
            long r3 = r14 + r11
            r5 = r13 & 63
            r13 = 128(0x80, float:1.794E-43)
            r5 = r5 | r13
            byte r5 = (byte) r5
            com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r14, r5)
            r19 = r11
            r11 = 128(0x80, float:1.794E-43)
            r12 = r3
            r4 = r19
            goto L_0x00fc
        L_0x0074:
            r3 = 57343(0xdfff, float:8.0355E-41)
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r13 < r14) goto L_0x007e
            if (r3 >= r13) goto L_0x00af
        L_0x007e:
            r15 = 3
            long r15 = r6 - r15
            int r15 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
            if (r15 > 0) goto L_0x00af
            long r14 = r4 + r11
            int r3 = r13 >>> 12
            r3 = r3 | 480(0x1e0, float:6.73E-43)
            byte r3 = (byte) r3
            com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r4, r3)
            long r3 = r14 + r11
            int r5 = r13 >>> 6
            r5 = r5 & 63
            r11 = 128(0x80, float:1.794E-43)
            r5 = r5 | r11
            byte r5 = (byte) r5
            com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r14, r5)
            r14 = 1
            long r17 = r3 + r14
            r5 = r13 & 63
            r5 = r5 | r11
            byte r5 = (byte) r5
            com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r3, r5)
            r12 = r17
            r4 = 1
            r11 = 128(0x80, float:1.794E-43)
            goto L_0x00fc
        L_0x00af:
            r11 = 4
            long r11 = r6 - r11
            int r11 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r11 > 0) goto L_0x010f
            int r3 = r2 + 1
            if (r3 == r8) goto L_0x0107
            char r2 = r0.charAt(r3)
            boolean r11 = java.lang.Character.isSurrogatePair(r13, r2)
            if (r11 == 0) goto L_0x0106
            int r2 = java.lang.Character.toCodePoint(r13, r2)
            r11 = 1
            long r13 = r4 + r11
            int r15 = r2 >>> 18
            r15 = r15 | 240(0xf0, float:3.36E-43)
            byte r15 = (byte) r15
            com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r4, r15)
            long r4 = r13 + r11
            int r15 = r2 >>> 12
            r15 = r15 & 63
            r11 = 128(0x80, float:1.794E-43)
            r12 = r15 | 128(0x80, float:1.794E-43)
            byte r12 = (byte) r12
            com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r13, r12)
            r12 = 1
            long r14 = r4 + r12
            int r16 = r2 >>> 6
            r12 = r16 & 63
            r12 = r12 | r11
            byte r12 = (byte) r12
            com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r4, r12)
            r4 = 1
            long r12 = r14 + r4
            r2 = r2 & 63
            r2 = r2 | r11
            byte r2 = (byte) r2
            com.google.android.gms.internal.firebase_ml.zzyy.zza(r1, r14, r2)
            r2 = r3
        L_0x00fc:
            int r2 = r2 + 1
            r3 = r11
            r19 = r4
            r4 = r12
            r11 = r19
            goto L_0x0033
        L_0x0106:
            r2 = r3
        L_0x0107:
            com.google.android.gms.internal.firebase_ml.zzze r0 = new com.google.android.gms.internal.firebase_ml.zzze
            int r2 = r2 + -1
            r0.<init>(r2, r8)
            throw r0
        L_0x010f:
            if (r14 > r13) goto L_0x0127
            if (r13 > r3) goto L_0x0127
            int r1 = r2 + 1
            if (r1 == r8) goto L_0x0121
            char r0 = r0.charAt(r1)
            boolean r0 = java.lang.Character.isSurrogatePair(r13, r0)
            if (r0 != 0) goto L_0x0127
        L_0x0121:
            com.google.android.gms.internal.firebase_ml.zzze r0 = new com.google.android.gms.internal.firebase_ml.zzze
            r0.<init>(r2, r8)
            throw r0
        L_0x0127:
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            r1 = 46
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r2.append(r10)
            r2.append(r13)
            r2.append(r9)
            r2.append(r4)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0144:
            int r0 = (int) r4
            return r0
        L_0x0146:
            java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
            int r8 = r8 + -1
            char r0 = r0.charAt(r8)
            int r2 = r2 + r3
            r3 = 37
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r4.append(r10)
            r4.append(r0)
            r4.append(r9)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzzh.zzb(java.lang.CharSequence, byte[], int, int):int");
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zzzb.zzdz(i);
        }
        if (i2 == 1) {
            return zzzb.zzw(i, zzyy.zza(bArr, j));
        }
        if (i2 == 2) {
            return zzzb.zze(i, zzyy.zza(bArr, j), zzyy.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }
}

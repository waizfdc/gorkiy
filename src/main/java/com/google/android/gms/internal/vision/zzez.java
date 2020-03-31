package com.google.android.gms.internal.vision;

import java.io.IOException;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzez {
    static int zza(byte[] bArr, int i, zzfb zzfb) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza(b, bArr, i2, zzfb);
        }
        zzfb.zzro = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzfb zzfb) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzfb.zzro = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzfb.zzro = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzfb.zzro = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzfb.zzro = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzfb.zzro = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zzfb zzfb) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzfb.zzrp = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & ByteCompanionObject.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & ByteCompanionObject.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zzfb.zzrp = j2;
        return i3;
    }

    static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static long zzb(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    static int zzc(byte[] bArr, int i, zzfb zzfb) throws zzhc {
        int zza = zza(bArr, i, zzfb);
        int i2 = zzfb.zzro;
        if (i2 < 0) {
            throw zzhc.zzgn();
        } else if (i2 == 0) {
            zzfb.zzrq = "";
            return zza;
        } else {
            zzfb.zzrq = new String(bArr, zza, i2, zzgt.UTF_8);
            return zza + i2;
        }
    }

    static int zzd(byte[] bArr, int i, zzfb zzfb) throws zzhc {
        int zza = zza(bArr, i, zzfb);
        int i2 = zzfb.zzro;
        if (i2 < 0) {
            throw zzhc.zzgn();
        } else if (i2 == 0) {
            zzfb.zzrq = "";
            return zza;
        } else {
            zzfb.zzrq = zzjs.zzh(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zze(byte[] bArr, int i, zzfb zzfb) throws zzhc {
        int zza = zza(bArr, i, zzfb);
        int i2 = zzfb.zzro;
        if (i2 < 0) {
            throw zzhc.zzgn();
        } else if (i2 > bArr.length - zza) {
            throw zzhc.zzgm();
        } else if (i2 == 0) {
            zzfb.zzrq = zzfh.zzrx;
            return zza;
        } else {
            zzfb.zzrq = zzfh.zza(bArr, zza, i2);
            return zza + i2;
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r8v4, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zza(com.google.android.gms.internal.vision.zzir r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.vision.zzfb r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zza(r8, r7, r0, r10)
            int r8 = r10.zzro
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.newInstance()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zza(r1, r2, r3, r4, r5)
            r6.zzg(r9)
            r10.zzrq = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.vision.zzhc r6 = com.google.android.gms.internal.vision.zzhc.zzgm()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzez.zza(com.google.android.gms.internal.vision.zzir, byte[], int, int, com.google.android.gms.internal.vision.zzfb):int");
    }

    static int zza(zzir zzir, byte[] bArr, int i, int i2, int i3, zzfb zzfb) throws IOException {
        zzig zzig = (zzig) zzir;
        Object newInstance = zzig.newInstance();
        int zza = zzig.zza(newInstance, bArr, i, i2, i3, zzfb);
        zzig.zzg(newInstance);
        zzfb.zzrq = newInstance;
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzgz<?> zzgz, zzfb zzfb) {
        zzgu zzgu = (zzgu) zzgz;
        int zza = zza(bArr, i2, zzfb);
        zzgu.zzbl(zzfb.zzro);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzfb);
            if (i != zzfb.zzro) {
                break;
            }
            zza = zza(bArr, zza2, zzfb);
            zzgu.zzbl(zzfb.zzro);
        }
        return zza;
    }

    static int zza(byte[] bArr, int i, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        zzgu zzgu = (zzgu) zzgz;
        int zza = zza(bArr, i, zzfb);
        int i2 = zzfb.zzro + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzfb);
            zzgu.zzbl(zzfb.zzro);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    static int zzb(byte[] bArr, int i, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        zzhq zzhq = (zzhq) zzgz;
        int zza = zza(bArr, i, zzfb);
        int i2 = zzfb.zzro + zza;
        while (zza < i2) {
            zza = zzb(bArr, zza, zzfb);
            zzhq.zzac(zzfb.zzrp);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    static int zzc(byte[] bArr, int i, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        zzgu zzgu = (zzgu) zzgz;
        int zza = zza(bArr, i, zzfb);
        int i2 = zzfb.zzro + zza;
        while (zza < i2) {
            zzgu.zzbl(zza(bArr, zza));
            zza += 4;
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    static int zzd(byte[] bArr, int i, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        zzhq zzhq = (zzhq) zzgz;
        int zza = zza(bArr, i, zzfb);
        int i2 = zzfb.zzro + zza;
        while (zza < i2) {
            zzhq.zzac(zzb(bArr, zza));
            zza += 8;
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    static int zze(byte[] bArr, int i, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        zzgo zzgo = (zzgo) zzgz;
        int zza = zza(bArr, i, zzfb);
        int i2 = zzfb.zzro + zza;
        while (zza < i2) {
            zzgo.zzu(zzd(bArr, zza));
            zza += 4;
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    static int zzf(byte[] bArr, int i, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        zzgb zzgb = (zzgb) zzgz;
        int zza = zza(bArr, i, zzfb);
        int i2 = zzfb.zzro + zza;
        while (zza < i2) {
            zzgb.zzc(zzc(bArr, zza));
            zza += 8;
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    static int zzg(byte[] bArr, int i, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        zzff zzff = (zzff) zzgz;
        int zza = zza(bArr, i, zzfb);
        int i2 = zzfb.zzro + zza;
        while (zza < i2) {
            zza = zzb(bArr, zza, zzfb);
            zzff.addBoolean(zzfb.zzrp != 0);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    static int zzh(byte[] bArr, int i, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        zzgu zzgu = (zzgu) zzgz;
        int zza = zza(bArr, i, zzfb);
        int i2 = zzfb.zzro + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzfb);
            zzgu.zzbl(zzft.zzau(zzfb.zzro));
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    static int zzi(byte[] bArr, int i, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        zzhq zzhq = (zzhq) zzgz;
        int zza = zza(bArr, i, zzfb);
        int i2 = zzfb.zzro + zza;
        while (zza < i2) {
            zza = zzb(bArr, zza, zzfb);
            zzhq.zzac(zzft.zzr(zzfb.zzrp));
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    static int zza(zzir<?> zzir, int i, byte[] bArr, int i2, int i3, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        int zza = zza(zzir, bArr, i2, i3, zzfb);
        zzgz.add(zzfb.zzrq);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzfb);
            if (i != zzfb.zzro) {
                break;
            }
            zza = zza(zzir, bArr, zza2, i3, zzfb);
            zzgz.add(zzfb.zzrq);
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzjm zzjm, zzfb zzfb) throws zzhc {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzfb);
                zzjm.zzb(i, Long.valueOf(zzfb.zzrp));
                return zzb;
            } else if (i4 == 1) {
                zzjm.zzb(i, Long.valueOf(zzb(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzfb);
                int i5 = zzfb.zzro;
                if (i5 < 0) {
                    throw zzhc.zzgn();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzjm.zzb(i, zzfh.zzrx);
                    } else {
                        zzjm.zzb(i, zzfh.zza(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzhc.zzgm();
                }
            } else if (i4 == 3) {
                zzjm zzih = zzjm.zzih();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzfb);
                    int i8 = zzfb.zzro;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zza2;
                        break;
                    }
                    int zza3 = zza(i7, bArr, zza2, i3, zzih, zzfb);
                    i7 = i8;
                    i2 = zza3;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzhc.zzgs();
                }
                zzjm.zzb(i, zzih);
                return i2;
            } else if (i4 == 5) {
                zzjm.zzb(i, Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzhc.zzgp();
            }
        } else {
            throw zzhc.zzgp();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzfb zzfb) throws zzhc {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zzfb);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzfb) + zzfb.zzro;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzfb);
                    i6 = zzfb.zzro;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzfb);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzhc.zzgs();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzhc.zzgp();
            }
        } else {
            throw zzhc.zzgp();
        }
    }
}

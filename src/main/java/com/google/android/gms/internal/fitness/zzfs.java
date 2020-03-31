package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public abstract class zzfs extends zzfc {
    private static final Logger logger = Logger.getLogger(zzfs.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzrt = zzja.zzdf();
    zzfv zzru;

    public static zzfs zza(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzb(boolean z) {
        return 1;
    }

    public static int zzc(double d) {
        return 8;
    }

    public static int zzc(float f) {
        return 4;
    }

    public static int zze(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int zzg(long j) {
        return 8;
    }

    public static int zzh(long j) {
        return 8;
    }

    private static long zzi(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzr(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzt(int i) {
        return 4;
    }

    public static int zzu(int i) {
        return 4;
    }

    private static int zzw(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzff zzff) throws IOException;

    public abstract void zza(int i, zzho zzho) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(int i, zzho zzho, zzic zzic) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(int i, boolean z) throws IOException;

    public abstract void zza(long j) throws IOException;

    public abstract void zza(zzff zzff) throws IOException;

    public abstract int zzaw();

    public abstract void zzb(int i, int i2) throws IOException;

    public abstract void zzb(int i, zzff zzff) throws IOException;

    public abstract void zzb(zzho zzho) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzb(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzc(byte b) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzc(long j) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzl(int i) throws IOException;

    public abstract void zzm(int i) throws IOException;

    public abstract void zzm(String str) throws IOException;

    public abstract void zzo(int i) throws IOException;

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        zzb(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L_0x0011
                java.lang.String r3 = r1.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L_0x0016:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fitness.zzfs.zzb.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzfs() {
    }

    public final void zze(int i, int i2) throws IOException {
        zzd(i, zzw(i2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzi(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzf(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzn(int i) throws IOException {
        zzm(zzw(i));
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    static class zza extends zzfs {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i2 + 0;
                if ((i2 | 0 | (bArr.length - i3)) >= 0) {
                    this.buffer = bArr;
                    this.offset = 0;
                    this.position = 0;
                    this.limit = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            throw new NullPointerException("buffer");
        }

        public final void zzb(int i, int i2) throws IOException {
            zzm((i << 3) | i2);
        }

        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzl(i2);
        }

        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzm(i2);
        }

        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzo(i2);
        }

        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zza(j);
        }

        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzc(j);
        }

        public final void zza(int i, boolean z) throws IOException {
            zzb(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        public final void zza(int i, String str) throws IOException {
            zzb(i, 2);
            zzm(str);
        }

        public final void zza(int i, zzff zzff) throws IOException {
            zzb(i, 2);
            zza(zzff);
        }

        public final void zza(zzff zzff) throws IOException {
            zzm(zzff.size());
            zzff.zza(this);
        }

        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzm(i2);
            write(bArr, 0, i2);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzho zzho, zzic zzic) throws IOException {
            zzb(i, 2);
            zzex zzex = (zzex) zzho;
            int zzah = zzex.zzah();
            if (zzah == -1) {
                zzah = zzic.zzk(zzex);
                zzex.zzg(zzah);
            }
            zzm(zzah);
            zzic.zza(zzho, this.zzru);
        }

        public final void zza(int i, zzho zzho) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zzb(3, 2);
            zzb(zzho);
            zzb(1, 4);
        }

        public final void zzb(int i, zzff zzff) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzff);
            zzb(1, 4);
        }

        public final void zzb(zzho zzho) throws IOException {
            zzm(zzho.zzbk());
            zzho.zzb(super);
        }

        public final void zzc(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        public final void zzl(int i) throws IOException {
            if (i >= 0) {
                zzm(i);
            } else {
                zza((long) i);
            }
        }

        public final void zzm(int i) throws IOException {
            if (!zzfs.zzrt || zzfd.zzan() || zzaw() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzja.zza(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzja.zza(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zzja.zza(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zzja.zza(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zzja.zza(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zzja.zza(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzja.zza(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzja.zza(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzja.zza(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        public final void zzo(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i4 = i3 + 1;
                this.position = i4;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i5 = i4 + 1;
                this.position = i5;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                this.position = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        public final void zza(long j) throws IOException {
            if (!zzfs.zzrt || zzaw() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zzja.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzja.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzc(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                int i2 = i + 1;
                this.position = i2;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.buffer;
                int i3 = i2 + 1;
                this.position = i3;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.buffer;
                int i4 = i3 + 1;
                this.position = i4;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.buffer;
                int i5 = i4 + 1;
                this.position = i5;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.buffer;
                int i6 = i5 + 1;
                this.position = i6;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.buffer;
                int i7 = i6 + 1;
                this.position = i7;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.buffer;
                int i8 = i7 + 1;
                this.position = i8;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.buffer;
                this.position = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        private final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)), e);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzm(String str) throws IOException {
            int i = this.position;
            try {
                int zzr = zzr(str.length() * 3);
                int zzr2 = zzr(str.length());
                if (zzr2 == zzr) {
                    int i2 = i + zzr2;
                    this.position = i2;
                    int zzb = zzjc.zzb(str, this.buffer, i2, zzaw());
                    this.position = i;
                    zzm((zzb - i) - zzr2);
                    this.position = zzb;
                    return;
                }
                zzm(zzjc.zza(str));
                this.position = zzjc.zzb(str, this.buffer, this.position, zzaw());
            } catch (zzjd e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        public final int zzaw() {
            return this.limit - this.position;
        }
    }

    public final void zzb(long j) throws IOException {
        zza(zzi(j));
    }

    public final void zzb(float f) throws IOException {
        zzo(Float.floatToRawIntBits(f));
    }

    public final void zzb(double d) throws IOException {
        zzc(Double.doubleToRawLongBits(d));
    }

    public final void zza(boolean z) throws IOException {
        zzc(z ? (byte) 1 : 0);
    }

    public static int zzg(int i, int i2) {
        return zzp(i) + zzq(i2);
    }

    public static int zzh(int i, int i2) {
        return zzp(i) + zzr(i2);
    }

    public static int zzi(int i, int i2) {
        return zzp(i) + zzr(zzw(i2));
    }

    public static int zzj(int i, int i2) {
        return zzp(i) + 4;
    }

    public static int zzk(int i, int i2) {
        return zzp(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzp(i) + zze(j);
    }

    public static int zze(int i, long j) {
        return zzp(i) + zze(j);
    }

    public static int zzf(int i, long j) {
        return zzp(i) + zze(zzi(j));
    }

    public static int zzg(int i, long j) {
        return zzp(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzp(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzp(i) + 4;
    }

    public static int zzb(int i, double d) {
        return zzp(i) + 8;
    }

    public static int zzb(int i, boolean z) {
        return zzp(i) + 1;
    }

    public static int zzl(int i, int i2) {
        return zzp(i) + zzq(i2);
    }

    public static int zzb(int i, String str) {
        return zzp(i) + zzn(str);
    }

    public static int zzc(int i, zzff zzff) {
        int zzp = zzp(i);
        int size = zzff.size();
        return zzp + zzr(size) + size;
    }

    public static int zza(int i, zzgt zzgt) {
        int zzp = zzp(i);
        int zzbk = zzgt.zzbk();
        return zzp + zzr(zzbk) + zzbk;
    }

    static int zzb(int i, zzho zzho, zzic zzic) {
        return zzp(i) + zza(zzho, zzic);
    }

    public static int zzb(int i, zzho zzho) {
        return (zzp(1) << 1) + zzh(2, i) + zzp(3) + zzc(zzho);
    }

    public static int zzd(int i, zzff zzff) {
        return (zzp(1) << 1) + zzh(2, i) + zzc(3, zzff);
    }

    public static int zzb(int i, zzgt zzgt) {
        return (zzp(1) << 1) + zzh(2, i) + zza(3, zzgt);
    }

    public static int zzp(int i) {
        return zzr(i << 3);
    }

    public static int zzq(int i) {
        if (i >= 0) {
            return zzr(i);
        }
        return 10;
    }

    public static int zzs(int i) {
        return zzr(zzw(i));
    }

    public static int zzd(long j) {
        return zze(j);
    }

    public static int zzf(long j) {
        return zze(zzi(j));
    }

    public static int zzv(int i) {
        return zzq(i);
    }

    public static int zzn(String str) {
        int i;
        try {
            i = zzjc.zza(str);
        } catch (zzjd unused) {
            i = str.getBytes(zzgk.UTF_8).length;
        }
        return zzr(i) + i;
    }

    public static int zza(zzgt zzgt) {
        int zzbk = zzgt.zzbk();
        return zzr(zzbk) + zzbk;
    }

    public static int zzb(zzff zzff) {
        int size = zzff.size();
        return zzr(size) + size;
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        return zzr(length) + length;
    }

    public static int zzc(zzho zzho) {
        int zzbk = zzho.zzbk();
        return zzr(zzbk) + zzbk;
    }

    static int zza(zzho zzho, zzic zzic) {
        zzex zzex = (zzex) zzho;
        int zzah = zzex.zzah();
        if (zzah == -1) {
            zzah = zzic.zzk(zzex);
            zzex.zzg(zzah);
        }
        return zzr(zzah) + zzah;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.logp(java.util.logging.Level, java.lang.String, java.lang.String, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.fitness.zzjd]
     candidates:
      ClspMth{java.util.logging.Logger.logp(java.util.logging.Level, java.lang.String, java.lang.String, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.logp(java.util.logging.Level, java.lang.String, java.lang.String, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.logp(java.util.logging.Level, java.lang.String, java.lang.String, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.logp(java.util.logging.Level, java.lang.String, java.lang.String, java.lang.String, java.lang.Throwable):void} */
    /* access modifiers changed from: package-private */
    public final void zza(String str, zzjd zzjd) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzjd);
        byte[] bytes = str.getBytes(zzgk.UTF_8);
        try {
            zzm(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzb(e);
        } catch (zzb e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzho zzho, zzic zzic) {
        int zzp = zzp(i) << 1;
        zzex zzex = (zzex) zzho;
        int zzah = zzex.zzah();
        if (zzah == -1) {
            zzah = zzic.zzk(zzex);
            zzex.zzg(zzah);
        }
        return zzp + zzah;
    }

    @Deprecated
    public static int zzd(zzho zzho) {
        return zzho.zzbk();
    }

    @Deprecated
    public static int zzx(int i) {
        return zzr(i);
    }
}

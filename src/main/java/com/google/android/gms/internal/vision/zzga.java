package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public abstract class zzga extends zzfi {
    private static final Logger logger = Logger.getLogger(zzga.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzsr = zzjp.zzij();
    zzgc zzss;

    private static long zzaa(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzb(double d) {
        return 8;
    }

    public static int zzbc(int i) {
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

    public static int zzbe(int i) {
        return 4;
    }

    public static int zzbf(int i) {
        return 4;
    }

    private static int zzbh(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static zzga zze(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zzl(boolean z) {
        return 1;
    }

    public static int zzt(float f) {
        return 4;
    }

    public static int zzw(long j) {
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

    public static int zzy(long j) {
        return 8;
    }

    public static int zzz(long j) {
        return 8;
    }

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzfh zzfh) throws IOException;

    public abstract void zza(int i, zzic zzic) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(int i, zzic zzic, zzir zzir) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(int i, boolean z) throws IOException;

    public abstract void zza(zzfh zzfh) throws IOException;

    public abstract void zzaw(int i) throws IOException;

    public abstract void zzax(int i) throws IOException;

    public abstract void zzaz(int i) throws IOException;

    public abstract void zzb(int i, zzfh zzfh) throws IOException;

    public abstract void zzb(zzic zzic) throws IOException;

    public abstract void zzc(byte b) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zze(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzfg();

    public abstract void zzg(int i, int i2) throws IOException;

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzi(int i, int i2) throws IOException;

    public abstract void zzk(int i, int i2) throws IOException;

    public abstract void zzs(long j) throws IOException;

    public abstract void zzu(long j) throws IOException;

    public abstract void zzx(String str) throws IOException;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        zza(java.lang.String r3, java.lang.Throwable r4) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzga.zza.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzga() {
    }

    public final void zzj(int i, int i2) throws IOException {
        zzi(i, zzbh(i2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzaa(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzk(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzay(int i) throws IOException {
        zzax(zzbh(i));
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    static class zzb extends zzga {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zzb(byte[] bArr, int i, int i2) {
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

        public final void zzg(int i, int i2) throws IOException {
            zzax((i << 3) | i2);
        }

        public final void zzh(int i, int i2) throws IOException {
            zzg(i, 0);
            zzaw(i2);
        }

        public final void zzi(int i, int i2) throws IOException {
            zzg(i, 0);
            zzax(i2);
        }

        public final void zzk(int i, int i2) throws IOException {
            zzg(i, 5);
            zzaz(i2);
        }

        public final void zza(int i, long j) throws IOException {
            zzg(i, 0);
            zzs(j);
        }

        public final void zzc(int i, long j) throws IOException {
            zzg(i, 1);
            zzu(j);
        }

        public final void zza(int i, boolean z) throws IOException {
            zzg(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        public final void zza(int i, String str) throws IOException {
            zzg(i, 2);
            zzx(str);
        }

        public final void zza(int i, zzfh zzfh) throws IOException {
            zzg(i, 2);
            zza(zzfh);
        }

        public final void zza(zzfh zzfh) throws IOException {
            zzax(zzfh.size());
            zzfh.zza(this);
        }

        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzax(i2);
            write(bArr, 0, i2);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzic zzic, zzir zzir) throws IOException {
            zzg(i, 2);
            zzet zzet = (zzet) zzic;
            int zzdl = zzet.zzdl();
            if (zzdl == -1) {
                zzdl = zzir.zzr(zzet);
                zzet.zzad(zzdl);
            }
            zzax(zzdl);
            zzir.zza(zzic, this.zzss);
        }

        public final void zza(int i, zzic zzic) throws IOException {
            zzg(1, 3);
            zzi(2, i);
            zzg(3, 2);
            zzb(zzic);
            zzg(1, 4);
        }

        public final void zzb(int i, zzfh zzfh) throws IOException {
            zzg(1, 3);
            zzi(2, i);
            zza(3, zzfh);
            zzg(1, 4);
        }

        public final void zzb(zzic zzic) throws IOException {
            zzax(zzic.zzgf());
            zzic.zzb(super);
        }

        public final void zzc(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        public final void zzaw(int i) throws IOException {
            if (i >= 0) {
                zzax(i);
            } else {
                zzs((long) i);
            }
        }

        public final void zzax(int i) throws IOException {
            if (!zzga.zzsr || zzfa.zzdr() || zzfg() < 5) {
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
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzjp.zza(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzjp.zza(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zzjp.zza(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zzjp.zza(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zzjp.zza(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zzjp.zza(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzjp.zza(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzjp.zza(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzjp.zza(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        public final void zzaz(int i) throws IOException {
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
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        public final void zzs(long j) throws IOException {
            if (!zzga.zzsr || zzfg() < 10) {
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
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zzjp.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzjp.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzu(long j) throws IOException {
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
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        private final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)), e);
            }
        }

        public final void zzc(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzx(String str) throws IOException {
            int i = this.position;
            try {
                int zzbc = zzbc(str.length() * 3);
                int zzbc2 = zzbc(str.length());
                if (zzbc2 == zzbc) {
                    int i2 = i + zzbc2;
                    this.position = i2;
                    int zza = zzjs.zza(str, this.buffer, i2, zzfg());
                    this.position = i;
                    zzax((zza - i) - zzbc2);
                    this.position = zza;
                    return;
                }
                zzax(zzjs.zza(str));
                this.position = zzjs.zza(str, this.buffer, this.position, zzfg());
            } catch (zzjv e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(e2);
            }
        }

        public final int zzfg() {
            return this.limit - this.position;
        }
    }

    public final void zzt(long j) throws IOException {
        zzs(zzaa(j));
    }

    public final void zzs(float f) throws IOException {
        zzaz(Float.floatToRawIntBits(f));
    }

    public final void zza(double d) throws IOException {
        zzu(Double.doubleToRawLongBits(d));
    }

    public final void zzk(boolean z) throws IOException {
        zzc(z ? (byte) 1 : 0);
    }

    public static int zzl(int i, int i2) {
        return zzba(i) + zzbb(i2);
    }

    public static int zzm(int i, int i2) {
        return zzba(i) + zzbc(i2);
    }

    public static int zzn(int i, int i2) {
        return zzba(i) + zzbc(zzbh(i2));
    }

    public static int zzo(int i, int i2) {
        return zzba(i) + 4;
    }

    public static int zzp(int i, int i2) {
        return zzba(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzba(i) + zzw(j);
    }

    public static int zze(int i, long j) {
        return zzba(i) + zzw(j);
    }

    public static int zzf(int i, long j) {
        return zzba(i) + zzw(zzaa(j));
    }

    public static int zzg(int i, long j) {
        return zzba(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzba(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzba(i) + 4;
    }

    public static int zzb(int i, double d) {
        return zzba(i) + 8;
    }

    public static int zzb(int i, boolean z) {
        return zzba(i) + 1;
    }

    public static int zzq(int i, int i2) {
        return zzba(i) + zzbb(i2);
    }

    public static int zzb(int i, String str) {
        return zzba(i) + zzy(str);
    }

    public static int zzc(int i, zzfh zzfh) {
        int zzba = zzba(i);
        int size = zzfh.size();
        return zzba + zzbc(size) + size;
    }

    public static int zza(int i, zzhh zzhh) {
        int zzba = zzba(i);
        int zzgf = zzhh.zzgf();
        return zzba + zzbc(zzgf) + zzgf;
    }

    static int zzb(int i, zzic zzic, zzir zzir) {
        return zzba(i) + zza(zzic, zzir);
    }

    public static int zzb(int i, zzic zzic) {
        return (zzba(1) << 1) + zzm(2, i) + zzba(3) + zzc(zzic);
    }

    public static int zzd(int i, zzfh zzfh) {
        return (zzba(1) << 1) + zzm(2, i) + zzc(3, zzfh);
    }

    public static int zzb(int i, zzhh zzhh) {
        return (zzba(1) << 1) + zzm(2, i) + zza(3, zzhh);
    }

    public static int zzba(int i) {
        return zzbc(i << 3);
    }

    public static int zzbb(int i) {
        if (i >= 0) {
            return zzbc(i);
        }
        return 10;
    }

    public static int zzbd(int i) {
        return zzbc(zzbh(i));
    }

    public static int zzv(long j) {
        return zzw(j);
    }

    public static int zzx(long j) {
        return zzw(zzaa(j));
    }

    public static int zzbg(int i) {
        return zzbb(i);
    }

    public static int zzy(String str) {
        int i;
        try {
            i = zzjs.zza(str);
        } catch (zzjv unused) {
            i = str.getBytes(zzgt.UTF_8).length;
        }
        return zzbc(i) + i;
    }

    public static int zza(zzhh zzhh) {
        int zzgf = zzhh.zzgf();
        return zzbc(zzgf) + zzgf;
    }

    public static int zzb(zzfh zzfh) {
        int size = zzfh.size();
        return zzbc(size) + size;
    }

    public static int zzf(byte[] bArr) {
        int length = bArr.length;
        return zzbc(length) + length;
    }

    public static int zzc(zzic zzic) {
        int zzgf = zzic.zzgf();
        return zzbc(zzgf) + zzgf;
    }

    static int zza(zzic zzic, zzir zzir) {
        zzet zzet = (zzet) zzic;
        int zzdl = zzet.zzdl();
        if (zzdl == -1) {
            zzdl = zzir.zzr(zzet);
            zzet.zzad(zzdl);
        }
        return zzbc(zzdl) + zzdl;
    }

    public final void zzfh() {
        if (zzfg() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.logp(java.util.logging.Level, java.lang.String, java.lang.String, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.vision.zzjv]
     candidates:
      ClspMth{java.util.logging.Logger.logp(java.util.logging.Level, java.lang.String, java.lang.String, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.logp(java.util.logging.Level, java.lang.String, java.lang.String, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.logp(java.util.logging.Level, java.lang.String, java.lang.String, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.logp(java.util.logging.Level, java.lang.String, java.lang.String, java.lang.String, java.lang.Throwable):void} */
    /* access modifiers changed from: package-private */
    public final void zza(String str, zzjv zzjv) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzjv);
        byte[] bytes = str.getBytes(zzgt.UTF_8);
        try {
            zzax(bytes.length);
            zzc(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zza(e);
        } catch (zza e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzic zzic, zzir zzir) {
        int zzba = zzba(i) << 1;
        zzet zzet = (zzet) zzic;
        int zzdl = zzet.zzdl();
        if (zzdl == -1) {
            zzdl = zzir.zzr(zzet);
            zzet.zzad(zzdl);
        }
        return zzba + zzdl;
    }

    @Deprecated
    public static int zzd(zzic zzic) {
        return zzic.zzgf();
    }

    @Deprecated
    public static int zzbi(int i) {
        return zzbc(i);
    }
}

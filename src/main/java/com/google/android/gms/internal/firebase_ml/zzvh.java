package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public abstract class zzvh extends zzur {
    private static final Logger logger = Logger.getLogger(zzvh.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzbzv = zzyy.zzwf();
    zzvj zzbzw;

    public static int zzaa(long j) {
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

    public static int zzac(long j) {
        return 8;
    }

    public static int zzad(long j) {
        return 8;
    }

    private static long zzae(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzay(boolean z) {
        return 1;
    }

    public static int zzd(double d) {
        return 8;
    }

    public static int zzdd(int i) {
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

    public static int zzdf(int i) {
        return 4;
    }

    public static int zzdg(int i) {
        return 4;
    }

    private static int zzdj(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static zzvh zzg(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zzr(float f) {
        return 4;
    }

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzuq zzuq) throws IOException;

    public abstract void zza(int i, zzxg zzxg) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(int i, zzxg zzxg, zzya zzya) throws IOException;

    public abstract void zza(int i, boolean z) throws IOException;

    public abstract void zzb(int i, zzuq zzuq) throws IOException;

    public abstract void zzb(int i, String str) throws IOException;

    public abstract void zzb(zzxg zzxg) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzc(zzuq zzuq) throws IOException;

    public abstract void zzcj(String str) throws IOException;

    public abstract void zzcx(int i) throws IOException;

    public abstract void zzcy(int i) throws IOException;

    public abstract void zzd(byte b) throws IOException;

    public abstract void zzda(int i) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zze(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzi(int i, int i2) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    public abstract void zzl(int i, int i2) throws IOException;

    public abstract int zztd();

    public abstract void zzw(long j) throws IOException;

    public abstract void zzy(long j) throws IOException;

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzvh.zza.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzvh() {
    }

    public final void zzk(int i, int i2) throws IOException {
        zzj(i, zzdj(i2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzae(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzl(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzcz(int i) throws IOException {
        zzcy(zzdj(i));
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    static class zzb extends zzvh {
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

        public final void zzh(int i, int i2) throws IOException {
            zzcy((i << 3) | i2);
        }

        public final void zzi(int i, int i2) throws IOException {
            zzh(i, 0);
            zzcx(i2);
        }

        public final void zzj(int i, int i2) throws IOException {
            zzh(i, 0);
            zzcy(i2);
        }

        public final void zzl(int i, int i2) throws IOException {
            zzh(i, 5);
            zzda(i2);
        }

        public final void zza(int i, long j) throws IOException {
            zzh(i, 0);
            zzw(j);
        }

        public final void zzc(int i, long j) throws IOException {
            zzh(i, 1);
            zzy(j);
        }

        public final void zza(int i, boolean z) throws IOException {
            zzh(i, 0);
            zzd(z ? (byte) 1 : 0);
        }

        public final void zzb(int i, String str) throws IOException {
            zzh(i, 2);
            zzcj(str);
        }

        public final void zza(int i, zzuq zzuq) throws IOException {
            zzh(i, 2);
            zzc(zzuq);
        }

        public final void zzc(zzuq zzuq) throws IOException {
            zzcy(zzuq.size());
            zzuq.zza(this);
        }

        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzcy(i2);
            write(bArr, 0, i2);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzxg zzxg, zzya zzya) throws IOException {
            zzh(i, 2);
            zzug zzug = (zzug) zzxg;
            int zzsl = zzug.zzsl();
            if (zzsl == -1) {
                zzsl = zzya.zzaa(zzug);
                zzug.zzco(zzsl);
            }
            zzcy(zzsl);
            zzya.zza(zzxg, this.zzbzw);
        }

        public final void zza(int i, zzxg zzxg) throws IOException {
            zzh(1, 3);
            zzj(2, i);
            zzh(3, 2);
            zzb(zzxg);
            zzh(1, 4);
        }

        public final void zzb(int i, zzuq zzuq) throws IOException {
            zzh(1, 3);
            zzj(2, i);
            zza(3, zzuq);
            zzh(1, 4);
        }

        public final void zzb(zzxg zzxg) throws IOException {
            zzcy(zzxg.zzua());
            zzxg.zzb(super);
        }

        public final void zzd(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        public final void zzcx(int i) throws IOException {
            if (i >= 0) {
                zzcy(i);
            } else {
                zzw((long) i);
            }
        }

        public final void zzcy(int i) throws IOException {
            if (!zzvh.zzbzv || zzun.zzsr() || zztd() < 5) {
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
                zzyy.zza(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzyy.zza(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zzyy.zza(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zzyy.zza(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zzyy.zza(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zzyy.zza(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzyy.zza(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzyy.zza(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzyy.zza(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        public final void zzda(int i) throws IOException {
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

        public final void zzw(long j) throws IOException {
            if (!zzvh.zzbzv || zztd() < 10) {
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
                    zzyy.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzyy.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzy(long j) throws IOException {
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

        public final void zzcj(String str) throws IOException {
            int i = this.position;
            try {
                int zzdd = zzdd(str.length() * 3);
                int zzdd2 = zzdd(str.length());
                if (zzdd2 == zzdd) {
                    int i2 = i + zzdd2;
                    this.position = i2;
                    int zza = zzzb.zza(str, this.buffer, i2, zztd());
                    this.position = i;
                    zzcy((zza - i) - zzdd2);
                    this.position = zza;
                    return;
                }
                zzcy(zzzb.zzb(str));
                this.position = zzzb.zza(str, this.buffer, this.position, zztd());
            } catch (zzze e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(e2);
            }
        }

        public final int zztd() {
            return this.limit - this.position;
        }
    }

    public final void zzx(long j) throws IOException {
        zzw(zzae(j));
    }

    public final void zzq(float f) throws IOException {
        zzda(Float.floatToRawIntBits(f));
    }

    public final void zzc(double d) throws IOException {
        zzy(Double.doubleToRawLongBits(d));
    }

    public final void zzax(boolean z) throws IOException {
        zzd(z ? (byte) 1 : 0);
    }

    public static int zzm(int i, int i2) {
        return zzdb(i) + zzdc(i2);
    }

    public static int zzn(int i, int i2) {
        return zzdb(i) + zzdd(i2);
    }

    public static int zzo(int i, int i2) {
        return zzdb(i) + zzdd(zzdj(i2));
    }

    public static int zzp(int i, int i2) {
        return zzdb(i) + 4;
    }

    public static int zzq(int i, int i2) {
        return zzdb(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzdb(i) + zzaa(j);
    }

    public static int zze(int i, long j) {
        return zzdb(i) + zzaa(j);
    }

    public static int zzf(int i, long j) {
        return zzdb(i) + zzaa(zzae(j));
    }

    public static int zzg(int i, long j) {
        return zzdb(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzdb(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzdb(i) + 4;
    }

    public static int zzb(int i, double d) {
        return zzdb(i) + 8;
    }

    public static int zzb(int i, boolean z) {
        return zzdb(i) + 1;
    }

    public static int zzr(int i, int i2) {
        return zzdb(i) + zzdc(i2);
    }

    public static int zzc(int i, String str) {
        return zzdb(i) + zzck(str);
    }

    public static int zzc(int i, zzuq zzuq) {
        int zzdb = zzdb(i);
        int size = zzuq.size();
        return zzdb + zzdd(size) + size;
    }

    public static int zza(int i, zzwp zzwp) {
        int zzdb = zzdb(i);
        int zzua = zzwp.zzua();
        return zzdb + zzdd(zzua) + zzua;
    }

    static int zzb(int i, zzxg zzxg, zzya zzya) {
        return zzdb(i) + zza(zzxg, zzya);
    }

    public static int zzb(int i, zzxg zzxg) {
        return (zzdb(1) << 1) + zzn(2, i) + zzdb(3) + zzc(zzxg);
    }

    public static int zzd(int i, zzuq zzuq) {
        return (zzdb(1) << 1) + zzn(2, i) + zzc(3, zzuq);
    }

    public static int zzb(int i, zzwp zzwp) {
        return (zzdb(1) << 1) + zzn(2, i) + zza(3, zzwp);
    }

    public static int zzdb(int i) {
        return zzdd(i << 3);
    }

    public static int zzdc(int i) {
        if (i >= 0) {
            return zzdd(i);
        }
        return 10;
    }

    public static int zzde(int i) {
        return zzdd(zzdj(i));
    }

    public static int zzz(long j) {
        return zzaa(j);
    }

    public static int zzab(long j) {
        return zzaa(zzae(j));
    }

    public static int zzdh(int i) {
        return zzdc(i);
    }

    public static int zzck(String str) {
        int i;
        try {
            i = zzzb.zzb(str);
        } catch (zzze unused) {
            i = str.getBytes(zzvy.UTF_8).length;
        }
        return zzdd(i) + i;
    }

    public static int zza(zzwp zzwp) {
        int zzua = zzwp.zzua();
        return zzdd(zzua) + zzua;
    }

    public static int zzd(zzuq zzuq) {
        int size = zzuq.size();
        return zzdd(size) + size;
    }

    public static int zzh(byte[] bArr) {
        int length = bArr.length;
        return zzdd(length) + length;
    }

    public static int zzc(zzxg zzxg) {
        int zzua = zzxg.zzua();
        return zzdd(zzua) + zzua;
    }

    static int zza(zzxg zzxg, zzya zzya) {
        zzug zzug = (zzug) zzxg;
        int zzsl = zzug.zzsl();
        if (zzsl == -1) {
            zzsl = zzya.zzaa(zzug);
            zzug.zzco(zzsl);
        }
        return zzdd(zzsl) + zzsl;
    }

    static int zzdi(int i) {
        return zzdd(i) + i;
    }

    public final void zzte() {
        if (zztd() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.logp(java.util.logging.Level, java.lang.String, java.lang.String, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.firebase_ml.zzze]
     candidates:
      ClspMth{java.util.logging.Logger.logp(java.util.logging.Level, java.lang.String, java.lang.String, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.logp(java.util.logging.Level, java.lang.String, java.lang.String, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.logp(java.util.logging.Level, java.lang.String, java.lang.String, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.logp(java.util.logging.Level, java.lang.String, java.lang.String, java.lang.String, java.lang.Throwable):void} */
    /* access modifiers changed from: package-private */
    public final void zza(String str, zzze zzze) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzze);
        byte[] bytes = str.getBytes(zzvy.UTF_8);
        try {
            zzcy(bytes.length);
            zzc(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zza(e);
        } catch (zza e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzxg zzxg, zzya zzya) {
        int zzdb = zzdb(i) << 1;
        zzug zzug = (zzug) zzxg;
        int zzsl = zzug.zzsl();
        if (zzsl == -1) {
            zzsl = zzya.zzaa(zzug);
            zzug.zzco(zzsl);
        }
        return zzdb + zzsl;
    }

    @Deprecated
    public static int zzd(zzxg zzxg) {
        return zzxg.zzua();
    }

    @Deprecated
    public static int zzdk(int i) {
        return zzdd(i);
    }
}

package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public abstract class zzvc {
    private int zzbzo;
    private int zzbzp;
    private boolean zzbzq;

    static zzvc zza(byte[] bArr, int i, int i2, boolean z) {
        zzve zzve = new zzve(bArr, 0, i2, false);
        try {
            zzve.zzcv(i2);
            return zzve;
        } catch (zzwg e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zzcw(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zzv(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public abstract int zzcv(int i) throws zzwg;

    public abstract int zztc();

    private zzvc() {
        this.zzbzo = 100;
        this.zzbzp = Integer.MAX_VALUE;
        this.zzbzq = false;
    }
}

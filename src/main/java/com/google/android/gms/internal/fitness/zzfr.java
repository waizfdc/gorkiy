package com.google.android.gms.internal.fitness;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public abstract class zzfr {
    private int zzrq;
    private int zzrr;
    private boolean zzrs;

    static zzfr zza(byte[] bArr, int i, int i2, boolean z) {
        zzft zzft = new zzft(bArr, 0, i2, false);
        try {
            zzft.zzk(i2);
            return zzft;
        } catch (zzgo e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract int zzav();

    public abstract int zzk(int i) throws zzgo;

    private zzfr() {
        this.zzrq = 100;
        this.zzrr = Integer.MAX_VALUE;
        this.zzrs = false;
    }
}

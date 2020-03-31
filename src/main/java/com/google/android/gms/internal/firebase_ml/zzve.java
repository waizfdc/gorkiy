package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzve extends zzvc {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzbzr;
    private int zzbzs;
    private int zzbzt;
    private int zzbzu;

    private zzve(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzbzu = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzbzt = i;
        this.zzbzr = z;
    }

    public final int zzcv(int i) throws zzwg {
        if (i >= 0) {
            int zztc = i + zztc();
            int i2 = this.zzbzu;
            if (zztc <= i2) {
                this.zzbzu = zztc;
                int i3 = this.limit + this.zzbzs;
                this.limit = i3;
                int i4 = i3 - this.zzbzt;
                if (i4 > zztc) {
                    int i5 = i4 - zztc;
                    this.zzbzs = i5;
                    this.limit = i3 - i5;
                } else {
                    this.zzbzs = 0;
                }
                return i2;
            }
            throw zzwg.zzui();
        }
        throw zzwg.zzuj();
    }

    public final int zztc() {
        return this.pos - this.zzbzt;
    }
}

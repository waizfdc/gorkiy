package com.google.android.gms.internal.fitness;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzft extends zzfr {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzrv;
    private int zzrw;
    private int zzrx;
    private int zzry;

    private zzft(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzry = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzrx = i;
        this.zzrv = z;
    }

    public final int zzk(int i) throws zzgo {
        if (i >= 0) {
            int zzav = i + zzav();
            int i2 = this.zzry;
            if (zzav <= i2) {
                this.zzry = zzav;
                int i3 = this.limit + this.zzrw;
                this.limit = i3;
                int i4 = i3 - this.zzrx;
                if (i4 > zzav) {
                    int i5 = i4 - zzav;
                    this.zzrw = i5;
                    this.limit = i3 - i5;
                } else {
                    this.zzrw = 0;
                }
                return i2;
            }
            throw new zzgo("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzgo("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final int zzav() {
        return this.pos - this.zzrx;
    }
}

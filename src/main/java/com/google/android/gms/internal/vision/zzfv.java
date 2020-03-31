package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzfv extends zzft {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzsk;
    private int zzsl;
    private int zzsm;
    private int zzsn;
    private int zzso;

    private zzfv(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzso = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzsm = i;
        this.zzsk = z;
    }

    public final int zzex() throws IOException {
        if (zzdt()) {
            this.zzsn = 0;
            return 0;
        }
        int zzfa = zzfa();
        this.zzsn = zzfa;
        if ((zzfa >>> 3) != 0) {
            return zzfa;
        }
        throw zzhc.zzgp();
    }

    public final void zzaq(int i) throws zzhc {
        if (this.zzsn != i) {
            throw zzhc.zzgq();
        }
    }

    public final boolean zzar(int i) throws IOException {
        int zzex;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.limit - this.pos >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.buffer;
                    int i4 = this.pos;
                    this.pos = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzhc.zzgo();
            }
            while (i3 < 10) {
                if (zzff() < 0) {
                    i3++;
                }
            }
            throw zzhc.zzgo();
            return true;
        } else if (i2 == 1) {
            zzav(8);
            return true;
        } else if (i2 == 2) {
            zzav(zzfa());
            return true;
        } else if (i2 == 3) {
            do {
                zzex = zzex();
                if (zzex == 0) {
                    break;
                }
            } while (zzar(zzex));
            zzaq(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzav(4);
                return true;
            }
            throw zzhc.zzgr();
        }
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzfd());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzfc());
    }

    public final long zzdw() throws IOException {
        return zzfb();
    }

    public final long zzdx() throws IOException {
        return zzfb();
    }

    public final int zzdy() throws IOException {
        return zzfa();
    }

    public final long zzdz() throws IOException {
        return zzfd();
    }

    public final int zzea() throws IOException {
        return zzfc();
    }

    public final boolean zzeb() throws IOException {
        return zzfb() != 0;
    }

    public final String readString() throws IOException {
        int zzfa = zzfa();
        if (zzfa > 0 && zzfa <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzfa, zzgt.UTF_8);
            this.pos += zzfa;
            return str;
        } else if (zzfa == 0) {
            return "";
        } else {
            if (zzfa < 0) {
                throw zzhc.zzgn();
            }
            throw zzhc.zzgm();
        }
    }

    public final String zzec() throws IOException {
        int zzfa = zzfa();
        if (zzfa > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzfa <= i - i2) {
                String zzh = zzjs.zzh(this.buffer, i2, zzfa);
                this.pos += zzfa;
                return zzh;
            }
        }
        if (zzfa == 0) {
            return "";
        }
        if (zzfa <= 0) {
            throw zzhc.zzgn();
        }
        throw zzhc.zzgm();
    }

    public final zzfh zzed() throws IOException {
        byte[] bArr;
        int zzfa = zzfa();
        if (zzfa > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzfa <= i - i2) {
                zzfh zza = zzfh.zza(this.buffer, i2, zzfa);
                this.pos += zzfa;
                return zza;
            }
        }
        if (zzfa == 0) {
            return zzfh.zzrx;
        }
        if (zzfa > 0) {
            int i3 = this.limit;
            int i4 = this.pos;
            if (zzfa <= i3 - i4) {
                int i5 = zzfa + i4;
                this.pos = i5;
                bArr = Arrays.copyOfRange(this.buffer, i4, i5);
                return zzfh.zzd(bArr);
            }
        }
        if (zzfa > 0) {
            throw zzhc.zzgm();
        } else if (zzfa == 0) {
            bArr = zzgt.zzxc;
            return zzfh.zzd(bArr);
        } else {
            throw zzhc.zzgn();
        }
    }

    public final int zzee() throws IOException {
        return zzfa();
    }

    public final int zzef() throws IOException {
        return zzfa();
    }

    public final int zzeg() throws IOException {
        return zzfc();
    }

    public final long zzeh() throws IOException {
        return zzfd();
    }

    public final int zzei() throws IOException {
        return zzau(zzfa());
    }

    public final long zzej() throws IOException {
        return zzr(zzfb());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzfa() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.limit
            if (r1 == r0) goto L_0x006b
            byte[] r2 = r5.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r3
            return r0
        L_0x0011:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006b
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0022
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0068
        L_0x0022:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x002f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002d:
            r1 = r3
            goto L_0x0068
        L_0x002f:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0068
        L_0x003d:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006b
        L_0x0068:
            r5.pos = r1
            return r0
        L_0x006b:
            long r0 = r5.zzey()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfv.zzfa():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzfb() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.pos
            int r1 = r11.limit
            if (r1 == r0) goto L_0x00b8
            byte[] r2 = r11.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r11.pos = r3
            long r0 = (long) r0
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x00b8
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0025
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
        L_0x0022:
            long r2 = (long) r0
            goto L_0x00b5
        L_0x0025:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0036
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r2 = r9
            goto L_0x00b5
        L_0x0036:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0044
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0022
        L_0x0044:
            long r3 = (long) r0
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x005b
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
        L_0x0057:
            long r2 = r3 ^ r1
            r1 = r0
            goto L_0x00b5
        L_0x005b:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0070
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L_0x006d:
            long r2 = r3 ^ r5
            goto L_0x00b5
        L_0x0070:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0083
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L_0x0057
        L_0x0083:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0096
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L_0x006d
        L_0x0096:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b3
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x00b8
            goto L_0x00b4
        L_0x00b3:
            r1 = r0
        L_0x00b4:
            r2 = r3
        L_0x00b5:
            r11.pos = r1
            return r2
        L_0x00b8:
            long r0 = r11.zzey()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfv.zzfb():long");
    }

    /* access modifiers changed from: package-private */
    public final long zzey() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzff = zzff();
            j |= ((long) (zzff & ByteCompanionObject.MAX_VALUE)) << i;
            if ((zzff & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw zzhc.zzgo();
    }

    private final int zzfc() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzhc.zzgm();
    }

    private final long zzfd() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzhc.zzgm();
    }

    public final int zzas(int i) throws zzhc {
        if (i >= 0) {
            int zzez = i + zzez();
            int i2 = this.zzso;
            if (zzez <= i2) {
                this.zzso = zzez;
                zzfe();
                return i2;
            }
            throw zzhc.zzgm();
        }
        throw zzhc.zzgn();
    }

    private final void zzfe() {
        int i = this.limit + this.zzsl;
        this.limit = i;
        int i2 = i - this.zzsm;
        int i3 = this.zzso;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzsl = i4;
            this.limit = i - i4;
            return;
        }
        this.zzsl = 0;
    }

    public final void zzat(int i) {
        this.zzso = i;
        zzfe();
    }

    public final boolean zzdt() throws IOException {
        return this.pos == this.limit;
    }

    public final int zzez() {
        return this.pos - this.zzsm;
    }

    private final byte zzff() throws IOException {
        int i = this.pos;
        if (i != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzhc.zzgm();
    }

    private final void zzav(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzhc.zzgn();
        }
        throw zzhc.zzgm();
    }
}

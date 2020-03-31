package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzxw extends zzuq {
    static final int[] zzcgq = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzcgr;
    /* access modifiers changed from: private */
    public final zzuq zzcgs;
    /* access modifiers changed from: private */
    public final zzuq zzcgt;
    private final int zzcgu;
    private final int zzcgv;

    private zzxw(zzuq zzuq, zzuq zzuq2) {
        this.zzcgs = super;
        this.zzcgt = super;
        int size = super.size();
        this.zzcgu = size;
        this.zzcgr = size + super.size();
        this.zzcgv = Math.max(super.zzsw(), super.zzsw()) + 1;
    }

    static zzuq zza(zzuq zzuq, zzuq zzuq2) {
        if (super.size() == 0) {
            return super;
        }
        if (super.size() == 0) {
            return super;
        }
        int size = super.size() + super.size();
        if (size < 128) {
            return zzb(super, super);
        }
        if (zzuq instanceof zzxw) {
            zzxw zzxw = (zzxw) zzuq;
            if (zzxw.zzcgt.size() + super.size() < 128) {
                return new zzxw(zzxw.zzcgs, zzb(zzxw.zzcgt, super));
            } else if (zzxw.zzcgs.zzsw() > zzxw.zzcgt.zzsw() && super.zzsw() > super.zzsw()) {
                return new zzxw(zzxw.zzcgs, new zzxw(zzxw.zzcgt, super));
            }
        }
        if (size >= zzcgq[Math.max(super.zzsw(), super.zzsw()) + 1]) {
            return new zzxw(super, super);
        }
        return new zzxy(null).zzc(super, super);
    }

    private static zzuq zzb(zzuq zzuq, zzuq zzuq2) {
        int size = super.size();
        int size2 = super.size();
        byte[] bArr = new byte[(size + size2)];
        super.zza(bArr, 0, 0, size);
        super.zza(bArr, 0, size, size2);
        return new zzva(bArr);
    }

    public final byte zzcs(int i) {
        zzg(i, this.zzcgr);
        return zzct(i);
    }

    /* access modifiers changed from: package-private */
    public final byte zzct(int i) {
        int i2 = this.zzcgu;
        if (i < i2) {
            return this.zzcgs.zzct(i);
        }
        return this.zzcgt.zzct(i - i2);
    }

    public final int size() {
        return this.zzcgr;
    }

    public final zzuz zzst() {
        return new zzxz(this);
    }

    /* access modifiers changed from: protected */
    public final int zzsw() {
        return this.zzcgv;
    }

    /* access modifiers changed from: protected */
    public final boolean zzsx() {
        return this.zzcgr >= zzcgq[this.zzcgv];
    }

    public final zzuq zzf(int i, int i2) {
        int zzd = zzd(i, i2, this.zzcgr);
        if (zzd == 0) {
            return zzuq.zzbzh;
        }
        if (zzd == this.zzcgr) {
            return super;
        }
        int i3 = this.zzcgu;
        if (i2 <= i3) {
            return this.zzcgs.zzf(i, i2);
        }
        if (i >= i3) {
            return this.zzcgt.zzf(i - i3, i2 - i3);
        }
        zzuq zzuq = this.zzcgs;
        return new zzxw(super.zzf(i, super.size()), this.zzcgt.zzf(0, i2 - this.zzcgu));
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzcgu;
        if (i4 <= i5) {
            this.zzcgs.zzb(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.zzcgt.zzb(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.zzcgs.zzb(bArr, i, i2, i6);
            this.zzcgt.zzb(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzur zzur) throws IOException {
        this.zzcgs.zza(zzur);
        this.zzcgt.zza(zzur);
    }

    /* access modifiers changed from: protected */
    public final String zzb(Charset charset) {
        byte[] bArr;
        int size = size();
        if (size == 0) {
            bArr = zzvy.zzcdy;
        } else {
            byte[] bArr2 = new byte[size];
            zzb(bArr2, 0, 0, size);
            bArr = bArr2;
        }
        return new String(bArr, charset);
    }

    public final boolean zzsv() {
        int zzb = this.zzcgs.zzb(0, 0, this.zzcgu);
        zzuq zzuq = this.zzcgt;
        if (super.zzb(zzb, 0, super.size()) == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final int zzb(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzcgu;
        if (i4 <= i5) {
            return this.zzcgs.zzb(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzcgt.zzb(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzcgt.zzb(this.zzcgs.zzb(i, i2, i6), 0, i3 - i6);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzuq)) {
            return false;
        }
        zzuq zzuq = (zzuq) obj;
        if (this.zzcgr != super.size()) {
            return false;
        }
        if (this.zzcgr == 0) {
            return true;
        }
        int zzsy = zzsy();
        int zzsy2 = super.zzsy();
        if (zzsy != 0 && zzsy2 != 0 && zzsy != zzsy2) {
            return false;
        }
        zzyb zzyb = new zzyb(super, null);
        zzvb zzvb = (zzvb) zzyb.next();
        zzyb zzyb2 = new zzyb(super, null);
        zzvb zzvb2 = (zzvb) zzyb2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = super.size() - i;
            int size2 = super.size() - i2;
            int min = Math.min(size, size2);
            if (i == 0) {
                z = zzvb.zza(super, i2, min);
            } else {
                z = zzvb2.zza(super, i, min);
            }
            if (!z) {
                return false;
            }
            i3 += min;
            int i4 = this.zzcgr;
            if (i3 < i4) {
                if (min == size) {
                    zzvb = (zzvb) zzyb.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    zzvb2 = (zzvb) zzyb2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == i4) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final int zzc(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzcgu;
        if (i4 <= i5) {
            return this.zzcgs.zzc(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzcgt.zzc(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzcgt.zzc(this.zzcgs.zzc(i, i2, i6), 0, i3 - i6);
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    /* synthetic */ zzxw(zzuq zzuq, zzuq zzuq2, zzxz zzxz) {
        this(super, super);
    }
}

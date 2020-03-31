package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
class zzfp extends zzfm {
    protected final byte[] zzrp;

    zzfp(byte[] bArr) {
        if (bArr != null) {
            this.zzrp = bArr;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public int zzas() {
        return 0;
    }

    public byte zzh(int i) {
        return this.zzrp[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzi(int i) {
        return this.zzrp[i];
    }

    public int size() {
        return this.zzrp.length;
    }

    public final zzff zza(int i, int i2) {
        int zzb = zzb(0, i2, size());
        if (zzb == 0) {
            return zzff.zzri;
        }
        return new zzfi(this.zzrp, zzas(), zzb);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzfc zzfc) throws IOException {
        zzfc.zza(this.zzrp, zzas(), size());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzrp, zzas(), size(), charset);
    }

    public final boolean zzaq() {
        int zzas = zzas();
        return zzjc.zzc(this.zzrp, zzas, size() + zzas);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzff) || size() != ((zzff) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzfp)) {
            return obj.equals(this);
        }
        zzfp zzfp = (zzfp) obj;
        int zzar = zzar();
        int zzar2 = zzfp.zzar();
        if (zzar == 0 || zzar2 == 0 || zzar == zzar2) {
            return zza(zzfp, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzff zzff, int i, int i2) {
        if (i2 > zzff.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzff.size()) {
            int size2 = zzff.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzff instanceof zzfp)) {
            return zzff.zza(0, i2).equals(zza(0, i2));
        } else {
            zzfp zzfp = (zzfp) zzff;
            byte[] bArr = this.zzrp;
            byte[] bArr2 = zzfp.zzrp;
            int zzas = zzas() + i2;
            int zzas2 = zzas();
            int zzas3 = zzfp.zzas();
            while (zzas2 < zzas) {
                if (bArr[zzas2] != bArr2[zzas3]) {
                    return false;
                }
                zzas2++;
                zzas3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final int zza(int i, int i2, int i3) {
        return zzgk.zza(i, this.zzrp, zzas(), i3);
    }
}

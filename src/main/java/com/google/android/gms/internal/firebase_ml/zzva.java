package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
class zzva extends zzvb {
    protected final byte[] bytes;

    zzva(byte[] bArr) {
        if (bArr != null) {
            this.bytes = bArr;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public int zzsz() {
        return 0;
    }

    public byte zzcs(int i) {
        return this.bytes[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzct(int i) {
        return this.bytes[i];
    }

    public int size() {
        return this.bytes.length;
    }

    public final zzuq zzf(int i, int i2) {
        int zzd = zzd(i, i2, size());
        if (zzd == 0) {
            return zzuq.zzbzh;
        }
        return new zzux(this.bytes, zzsz() + i, zzd);
    }

    /* access modifiers changed from: protected */
    public void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.bytes, i, bArr, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzur zzur) throws IOException {
        zzur.zzc(this.bytes, zzsz(), size());
    }

    /* access modifiers changed from: protected */
    public final String zzb(Charset charset) {
        return new String(this.bytes, zzsz(), size(), charset);
    }

    public final boolean zzsv() {
        int zzsz = zzsz();
        return zzzb.zzf(this.bytes, zzsz, size() + zzsz);
    }

    /* access modifiers changed from: protected */
    public final int zzb(int i, int i2, int i3) {
        int zzsz = zzsz() + i2;
        return zzzb.zzb(i, this.bytes, zzsz, i3 + zzsz);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzuq) || size() != ((zzuq) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzva)) {
            return obj.equals(this);
        }
        zzva zzva = (zzva) obj;
        int zzsy = zzsy();
        int zzsy2 = zzva.zzsy();
        if (zzsy == 0 || zzsy2 == 0 || zzsy == zzsy2) {
            return zza(zzva, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzuq zzuq, int i, int i2) {
        if (i2 <= zzuq.size()) {
            int i3 = i + i2;
            if (i3 > zzuq.size()) {
                int size = zzuq.size();
                StringBuilder sb = new StringBuilder(59);
                sb.append("Ran off end of other: ");
                sb.append(i);
                sb.append(", ");
                sb.append(i2);
                sb.append(", ");
                sb.append(size);
                throw new IllegalArgumentException(sb.toString());
            } else if (!(zzuq instanceof zzva)) {
                return zzuq.zzf(i, i3).equals(zzf(0, i2));
            } else {
                zzva zzva = (zzva) zzuq;
                byte[] bArr = this.bytes;
                byte[] bArr2 = zzva.bytes;
                int zzsz = zzsz() + i2;
                int zzsz2 = zzsz();
                int zzsz3 = zzva.zzsz() + i;
                while (zzsz2 < zzsz) {
                    if (bArr[zzsz2] != bArr2[zzsz3]) {
                        return false;
                    }
                    zzsz2++;
                    zzsz3++;
                }
                return true;
            }
        } else {
            int size2 = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i2);
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    public final int zzc(int i, int i2, int i3) {
        return zzvy.zza(i, this.bytes, zzsz() + i2, i3);
    }
}

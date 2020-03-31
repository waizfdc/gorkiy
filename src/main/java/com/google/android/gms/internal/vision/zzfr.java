package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
class zzfr extends zzfs {
    protected final byte[] zzse;

    zzfr(byte[] bArr) {
        if (bArr != null) {
            this.zzse = bArr;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public int zzeu() {
        return 0;
    }

    public byte zzan(int i) {
        return this.zzse[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzao(int i) {
        return this.zzse[i];
    }

    public int size() {
        return this.zzse.length;
    }

    public final zzfh zzf(int i, int i2) {
        int zzc = zzc(0, i2, size());
        if (zzc == 0) {
            return zzfh.zzrx;
        }
        return new zzfo(this.zzse, zzeu(), zzc);
    }

    /* access modifiers changed from: protected */
    public void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzse, 0, bArr, 0, i3);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzfi zzfi) throws IOException {
        zzfi.zzc(this.zzse, zzeu(), size());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzse, zzeu(), size(), charset);
    }

    public final boolean zzes() {
        int zzeu = zzeu();
        return zzjs.zzf(this.zzse, zzeu, size() + zzeu);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfh) || size() != ((zzfh) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzfr)) {
            return obj.equals(this);
        }
        zzfr zzfr = (zzfr) obj;
        int zzet = zzet();
        int zzet2 = zzfr.zzet();
        if (zzet == 0 || zzet2 == 0 || zzet == zzet2) {
            return zza(zzfr, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzfh zzfh, int i, int i2) {
        if (i2 > zzfh.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzfh.size()) {
            int size2 = zzfh.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzfh instanceof zzfr)) {
            return zzfh.zzf(0, i2).equals(zzf(0, i2));
        } else {
            zzfr zzfr = (zzfr) zzfh;
            byte[] bArr = this.zzse;
            byte[] bArr2 = zzfr.zzse;
            int zzeu = zzeu() + i2;
            int zzeu2 = zzeu();
            int zzeu3 = zzfr.zzeu();
            while (zzeu2 < zzeu) {
                if (bArr[zzeu2] != bArr2[zzeu3]) {
                    return false;
                }
                zzeu2++;
                zzeu3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final int zzb(int i, int i2, int i3) {
        return zzgt.zza(i, this.zzse, zzeu(), i3);
    }
}

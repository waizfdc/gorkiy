package com.google.android.gms.internal.fitness;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzfi extends zzfp {
    private final int zzrm;
    private final int zzrn;

    zzfi(byte[] bArr, int i, int i2) {
        super(bArr);
        zzb(i, i + i2, bArr.length);
        this.zzrm = i;
        this.zzrn = i2;
    }

    public final byte zzh(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzrp[this.zzrm + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: package-private */
    public final byte zzi(int i) {
        return this.zzrp[this.zzrm + i];
    }

    public final int size() {
        return this.zzrn;
    }

    /* access modifiers changed from: protected */
    public final int zzas() {
        return this.zzrm;
    }
}

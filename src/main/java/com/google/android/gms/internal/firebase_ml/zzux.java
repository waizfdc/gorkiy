package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzux extends zzva {
    private final int zzbzl;
    private final int zzbzm;

    zzux(byte[] bArr, int i, int i2) {
        super(bArr);
        zzd(i, i + i2, bArr.length);
        this.zzbzl = i;
        this.zzbzm = i2;
    }

    public final byte zzcs(int i) {
        zzg(i, size());
        return this.bytes[this.zzbzl + i];
    }

    /* access modifiers changed from: package-private */
    public final byte zzct(int i) {
        return this.bytes[this.zzbzl + i];
    }

    public final int size() {
        return this.zzbzm;
    }

    /* access modifiers changed from: protected */
    public final int zzsz() {
        return this.zzbzl;
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.bytes, zzsz() + i, bArr, i2, i3);
    }
}

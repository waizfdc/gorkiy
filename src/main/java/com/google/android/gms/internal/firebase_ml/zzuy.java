package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzuy {
    private final byte[] buffer;
    private final zzvh zzbzn;

    private zzuy(int i) {
        byte[] bArr = new byte[i];
        this.buffer = bArr;
        this.zzbzn = zzvh.zzg(bArr);
    }

    public final zzuq zzta() {
        this.zzbzn.zzte();
        return new zzva(this.buffer);
    }

    public final zzvh zztb() {
        return this.zzbzn;
    }

    /* synthetic */ zzuy(int i, zzut zzut) {
        this(i);
    }
}

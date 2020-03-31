package com.google.android.gms.internal.firebase_ml;

import java.util.NoSuchElementException;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzut extends zzuv {
    private final int limit = this.zzbzk.size();
    private int position = 0;
    private final /* synthetic */ zzuq zzbzk;

    zzut(zzuq zzuq) {
        this.zzbzk = zzuq;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzbzk.zzct(i);
        }
        throw new NoSuchElementException();
    }
}

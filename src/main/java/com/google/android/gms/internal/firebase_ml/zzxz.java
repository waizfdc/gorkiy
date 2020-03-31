package com.google.android.gms.internal.firebase_ml;

import java.util.NoSuchElementException;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzxz extends zzuv {
    private final zzyb zzcgx = new zzyb(this.zzcgz, null);
    private zzuz zzcgy = zzvn();
    private final /* synthetic */ zzxw zzcgz;

    zzxz(zzxw zzxw) {
        this.zzcgz = zzxw;
    }

    private final zzuz zzvn() {
        if (this.zzcgx.hasNext()) {
            return (zzuz) ((zzvb) this.zzcgx.next()).iterator();
        }
        return null;
    }

    public final boolean hasNext() {
        return this.zzcgy != null;
    }

    public final byte nextByte() {
        zzuz zzuz = this.zzcgy;
        if (zzuz != null) {
            byte nextByte = zzuz.nextByte();
            if (!this.zzcgy.hasNext()) {
                this.zzcgy = zzvn();
            }
            return nextByte;
        }
        throw new NoSuchElementException();
    }
}

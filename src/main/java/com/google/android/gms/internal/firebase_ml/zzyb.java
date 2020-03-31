package com.google.android.gms.internal.firebase_ml;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzyb implements Iterator<zzvb> {
    private final ArrayDeque<zzxw> zzcha;
    private zzvb zzchb;

    private zzyb(zzuq zzuq) {
        if (zzuq instanceof zzxw) {
            zzxw zzxw = (zzxw) zzuq;
            ArrayDeque<zzxw> arrayDeque = new ArrayDeque<>(zzxw.zzsw());
            this.zzcha = arrayDeque;
            arrayDeque.push(zzxw);
            this.zzchb = zzg(zzxw.zzcgs);
            return;
        }
        this.zzcha = null;
        this.zzchb = (zzvb) zzuq;
    }

    private final zzvb zzg(zzuq zzuq) {
        while (zzuq instanceof zzxw) {
            zzxw zzxw = (zzxw) zzuq;
            this.zzcha.push(zzxw);
            zzuq = zzxw.zzcgs;
        }
        return (zzvb) zzuq;
    }

    public final boolean hasNext() {
        return this.zzchb != null;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        zzvb zzvb;
        boolean z;
        zzvb zzvb2 = this.zzchb;
        if (zzvb2 != null) {
            while (true) {
                ArrayDeque<zzxw> arrayDeque = this.zzcha;
                if (arrayDeque != null && !arrayDeque.isEmpty()) {
                    zzvb = zzg(this.zzcha.pop().zzcgt);
                    if (zzvb.size() == 0) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        break;
                    }
                } else {
                    zzvb = null;
                }
            }
            zzvb = null;
            this.zzchb = zzvb;
            return zzvb2;
        }
        throw new NoSuchElementException();
    }

    /* synthetic */ zzyb(zzuq zzuq, zzxz zzxz) {
        this(zzuq);
    }
}

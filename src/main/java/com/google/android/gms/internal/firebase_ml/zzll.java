package com.google.android.gms.internal.firebase_ml;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
abstract class zzll<T> implements Iterator<T> {
    private int zzagi = zzln.zzagm;
    @NullableDecl
    private T zzagj;

    protected zzll() {
    }

    /* access modifiers changed from: protected */
    public abstract T zziw();

    /* access modifiers changed from: protected */
    @NullableDecl
    public final T zzix() {
        this.zzagi = zzln.zzagn;
        return null;
    }

    public final boolean hasNext() {
        zzmf.checkState(this.zzagi != zzln.zzago);
        int i = zzlo.zzagq[this.zzagi - 1];
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        this.zzagi = zzln.zzago;
        this.zzagj = zziw();
        if (this.zzagi == zzln.zzagn) {
            return false;
        }
        this.zzagi = zzln.zzagl;
        return true;
    }

    public final T next() {
        if (hasNext()) {
            this.zzagi = zzln.zzagm;
            T t = this.zzagj;
            this.zzagj = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

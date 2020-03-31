package com.google.android.gms.internal.firebase_ml;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzjq implements Iterator<T> {
    private int index = 0;
    private final int length = Array.getLength(this.zzafw.zzafv);
    private final /* synthetic */ zzjn zzafw;

    zzjq(zzjn zzjn) {
        this.zzafw = zzjn;
    }

    public final boolean hasNext() {
        return this.index < this.length;
    }

    public final T next() {
        if (hasNext()) {
            Object obj = this.zzafw.zzafv;
            int i = this.index;
            this.index = i + 1;
            return Array.get(obj, i);
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

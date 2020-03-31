package com.google.android.gms.internal.firebase_ml;

import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzyz implements Iterator<String> {
    private final /* synthetic */ zzyx zzchy;
    private Iterator<String> zzciu = this.zzchy.zzchz.iterator();

    zzyz(zzyx zzyx) {
        this.zzchy = zzyx;
    }

    public final boolean hasNext() {
        return this.zzciu.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.zzciu.next();
    }
}

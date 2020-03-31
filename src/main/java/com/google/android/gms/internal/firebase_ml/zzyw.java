package com.google.android.gms.internal.firebase_ml;

import java.util.ListIterator;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzyw implements ListIterator<String> {
    private ListIterator<String> zzchw = this.zzchy.zzchz.listIterator(this.zzchx);
    private final /* synthetic */ int zzchx;
    private final /* synthetic */ zzyx zzchy;

    zzyw(zzyx zzyx, int i) {
        this.zzchy = zzyx;
        this.zzchx = i;
    }

    public final boolean hasNext() {
        return this.zzchw.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzchw.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzchw.nextIndex();
    }

    public final int previousIndex() {
        return this.zzchw.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object previous() {
        return this.zzchw.previous();
    }

    public final /* synthetic */ Object next() {
        return this.zzchw.next();
    }
}

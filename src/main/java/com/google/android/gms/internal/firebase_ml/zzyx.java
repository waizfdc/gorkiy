package com.google.android.gms.internal.firebase_ml;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzyx extends AbstractList<String> implements zzwr, RandomAccess {
    /* access modifiers changed from: private */
    public final zzwr zzchz;

    public zzyx(zzwr zzwr) {
        this.zzchz = zzwr;
    }

    public final zzwr zzus() {
        return this;
    }

    public final Object getRaw(int i) {
        return this.zzchz.getRaw(i);
    }

    public final int size() {
        return this.zzchz.size();
    }

    public final void zze(zzuq zzuq) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzyw(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzyz(this);
    }

    public final List<?> zzur() {
        return this.zzchz.zzur();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzchz.get(i);
    }
}

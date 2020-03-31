package com.google.android.gms.internal.firebase_ml;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
abstract class zzuk<E> extends AbstractList<E> implements zzwh<E> {
    private boolean zzbyx = true;

    zzuk() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public boolean add(E e) {
        zzsq();
        return super.add(e);
    }

    public void add(int i, E e) {
        zzsq();
        super.add(i, e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzsq();
        return super.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzsq();
        return super.addAll(i, collection);
    }

    public void clear() {
        zzsq();
        super.clear();
    }

    public boolean zzso() {
        return this.zzbyx;
    }

    public final void zzsp() {
        this.zzbyx = false;
    }

    public E remove(int i) {
        zzsq();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        zzsq();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        zzsq();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzsq();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        zzsq();
        return super.set(i, e);
    }

    /* access modifiers changed from: protected */
    public final void zzsq() {
        if (!this.zzbyx) {
            throw new UnsupportedOperationException();
        }
    }
}

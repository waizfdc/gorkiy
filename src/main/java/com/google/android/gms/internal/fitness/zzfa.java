package com.google.android.gms.internal.fitness;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
abstract class zzfa<E> extends AbstractList<E> implements zzgl<E> {
    private boolean zzrc = true;

    zzfa() {
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
        zzam();
        return super.add(e);
    }

    public void add(int i, E e) {
        zzam();
        super.add(i, e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzam();
        return super.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzam();
        return super.addAll(i, collection);
    }

    public void clear() {
        zzam();
        super.clear();
    }

    public boolean zzak() {
        return this.zzrc;
    }

    public final void zzal() {
        this.zzrc = false;
    }

    public E remove(int i) {
        zzam();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        zzam();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        zzam();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzam();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        zzam();
        return super.set(i, e);
    }

    /* access modifiers changed from: protected */
    public final void zzam() {
        if (!this.zzrc) {
            throw new UnsupportedOperationException();
        }
    }
}

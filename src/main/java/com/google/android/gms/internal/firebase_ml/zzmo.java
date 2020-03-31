package com.google.android.gms.internal.firebase_ml;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public abstract class zzmo<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzail = new Object[0];

    zzmo() {
    }

    /* renamed from: zzjc */
    public abstract zzmu<E> iterator();

    /* access modifiers changed from: package-private */
    public Object[] zzjd() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean zzjh();

    public final Object[] toArray() {
        return toArray(zzail);
    }

    public final <T> T[] toArray(T[] tArr) {
        zzmf.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzjd = zzjd();
            if (zzjd != null) {
                return Arrays.copyOfRange(zzjd, zzje(), zzjf(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: package-private */
    public int zzje() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zzjf() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public zzmr<E> zzjg() {
        return isEmpty() ? zzmr.zzji() : zzmr.zza(toArray());
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        zzmu zzmu = (zzmu) iterator();
        while (zzmu.hasNext()) {
            objArr[i] = zzmu.next();
            i++;
        }
        return i;
    }
}

package com.google.android.gms.internal.firebase_ml;

import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzxu<E> extends zzuk<E> implements RandomAccess {
    private static final zzxu<Object> zzcgm;
    private int size;
    private E[] zzaiq;

    public static <E> zzxu<E> zzvj() {
        return zzcgm;
    }

    zzxu() {
        this(new Object[10], 0);
    }

    private zzxu(E[] eArr, int i) {
        this.zzaiq = eArr;
        this.size = i;
    }

    public final boolean add(E e) {
        zzsq();
        int i = this.size;
        E[] eArr = this.zzaiq;
        if (i == eArr.length) {
            this.zzaiq = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzaiq;
        int i2 = this.size;
        this.size = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }

    public final void add(int i, E e) {
        int i2;
        zzsq();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzcq(i));
        }
        E[] eArr = this.zzaiq;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = new Object[(((i2 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.zzaiq, i, eArr2, i + 1, this.size - i);
            this.zzaiq = eArr2;
        }
        this.zzaiq[i] = e;
        this.size++;
        this.modCount++;
    }

    public final E get(int i) {
        zzcp(i);
        return this.zzaiq[i];
    }

    public final E remove(int i) {
        zzsq();
        zzcp(i);
        E[] eArr = this.zzaiq;
        E e = eArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return e;
    }

    public final E set(int i, E e) {
        zzsq();
        zzcp(i);
        E[] eArr = this.zzaiq;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.size;
    }

    private final void zzcp(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzcq(i));
        }
    }

    private final String zzcq(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ zzwh zzcr(int i) {
        if (i >= this.size) {
            return new zzxu(Arrays.copyOf(this.zzaiq, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    static {
        zzxu<Object> zzxu = new zzxu<>(new Object[0], 0);
        zzcgm = zzxu;
        super.zzsp();
    }
}

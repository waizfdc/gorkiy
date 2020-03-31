package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zziq<E> extends zzex<E> implements RandomAccess {
    private static final zziq<Object> zzzq;
    private int size;
    private E[] zzlu;

    public static <E> zziq<E> zzhr() {
        return zzzq;
    }

    zziq() {
        this(new Object[10], 0);
    }

    private zziq(E[] eArr, int i) {
        this.zzlu = eArr;
        this.size = i;
    }

    public final boolean add(E e) {
        zzdq();
        int i = this.size;
        E[] eArr = this.zzlu;
        if (i == eArr.length) {
            this.zzlu = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzlu;
        int i2 = this.size;
        this.size = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }

    public final void add(int i, E e) {
        int i2;
        zzdq();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzaf(i));
        }
        E[] eArr = this.zzlu;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = new Object[(((i2 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.zzlu, i, eArr2, i + 1, this.size - i);
            this.zzlu = eArr2;
        }
        this.zzlu[i] = e;
        this.size++;
        this.modCount++;
    }

    public final E get(int i) {
        zzae(i);
        return this.zzlu[i];
    }

    public final E remove(int i) {
        zzdq();
        zzae(i);
        E[] eArr = this.zzlu;
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
        zzdq();
        zzae(i);
        E[] eArr = this.zzlu;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.size;
    }

    private final void zzae(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzaf(i));
        }
    }

    private final String zzaf(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ zzgz zzag(int i) {
        if (i >= this.size) {
            return new zziq(Arrays.copyOf(this.zzlu, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    static {
        zziq<Object> zziq = new zziq<>(new Object[0], 0);
        zzzq = zziq;
        super.zzdp();
    }
}

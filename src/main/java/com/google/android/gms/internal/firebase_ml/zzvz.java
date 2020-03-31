package com.google.android.gms.internal.firebase_ml;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzvz extends zzuk<Integer> implements zzwf, zzxs, RandomAccess {
    private static final zzvz zzceb;
    private int size;
    private int[] zzcec;

    public static zzvz zzuh() {
        return zzceb;
    }

    zzvz() {
        this(new int[10], 0);
    }

    private zzvz(int[] iArr, int i) {
        this.zzcec = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzsq();
        if (i2 >= i) {
            int[] iArr = this.zzcec;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzvz)) {
            return super.equals(obj);
        }
        zzvz zzvz = (zzvz) obj;
        if (this.size != zzvz.size) {
            return false;
        }
        int[] iArr = zzvz.zzcec;
        for (int i = 0; i < this.size; i++) {
            if (this.zzcec[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzcec[i2];
        }
        return i;
    }

    /* renamed from: zzdn */
    public final zzwf zzcr(int i) {
        if (i >= this.size) {
            return new zzvz(Arrays.copyOf(this.zzcec, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final int getInt(int i) {
        zzcp(i);
        return this.zzcec[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzdo(int i) {
        zzsq();
        int i2 = this.size;
        int[] iArr = this.zzcec;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.zzcec = iArr2;
        }
        int[] iArr3 = this.zzcec;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr3[i3] = i;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzsq();
        zzvy.checkNotNull(collection);
        if (!(collection instanceof zzvz)) {
            return super.addAll(collection);
        }
        zzvz zzvz = (zzvz) collection;
        int i = zzvz.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzcec;
            if (i3 > iArr.length) {
                this.zzcec = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzvz.zzcec, 0, this.zzcec, this.size, zzvz.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzsq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzcec[i]))) {
                int[] iArr = this.zzcec;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
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

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzsq();
        zzcp(i);
        int[] iArr = this.zzcec;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzsq();
        zzcp(i);
        int[] iArr = this.zzcec;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        zzsq();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzcq(i));
        }
        int[] iArr = this.zzcec;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zzcec, i, iArr2, i + 1, this.size - i);
            this.zzcec = iArr2;
        }
        this.zzcec[i] = intValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzdo(((Integer) obj).intValue());
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzvz zzvz = new zzvz(new int[0], 0);
        zzceb = zzvz;
        super.zzsp();
    }
}

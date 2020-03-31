package com.google.android.gms.internal.firebase_ml;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzuo extends zzuk<Boolean> implements zzwh<Boolean>, zzxs, RandomAccess {
    private static final zzuo zzbzc;
    private int size;
    private boolean[] zzbzd;

    zzuo() {
        this(new boolean[10], 0);
    }

    private zzuo(boolean[] zArr, int i) {
        this.zzbzd = zArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzsq();
        if (i2 >= i) {
            boolean[] zArr = this.zzbzd;
            System.arraycopy(zArr, i2, zArr, i, this.size - i2);
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
        if (!(obj instanceof zzuo)) {
            return super.equals(obj);
        }
        zzuo zzuo = (zzuo) obj;
        if (this.size != zzuo.size) {
            return false;
        }
        boolean[] zArr = zzuo.zzbzd;
        for (int i = 0; i < this.size; i++) {
            if (this.zzbzd[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzvy.zzaz(this.zzbzd[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void addBoolean(boolean z) {
        zzsq();
        int i = this.size;
        boolean[] zArr = this.zzbzd;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[(((i * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.zzbzd = zArr2;
        }
        boolean[] zArr3 = this.zzbzd;
        int i2 = this.size;
        this.size = i2 + 1;
        zArr3[i2] = z;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzsq();
        zzvy.checkNotNull(collection);
        if (!(collection instanceof zzuo)) {
            return super.addAll(collection);
        }
        zzuo zzuo = (zzuo) collection;
        int i = zzuo.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.zzbzd;
            if (i3 > zArr.length) {
                this.zzbzd = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(zzuo.zzbzd, 0, this.zzbzd, this.size, zzuo.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzsq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zzbzd[i]))) {
                boolean[] zArr = this.zzbzd;
                System.arraycopy(zArr, i + 1, zArr, i, (this.size - i) - 1);
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzsq();
        zzcp(i);
        boolean[] zArr = this.zzbzd;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ Object remove(int i) {
        zzsq();
        zzcp(i);
        boolean[] zArr = this.zzbzd;
        boolean z = zArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzsq();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzcq(i));
        }
        boolean[] zArr = this.zzbzd;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zzbzd, i, zArr2, i + 1, this.size - i);
            this.zzbzd = zArr2;
        }
        this.zzbzd[i] = booleanValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        addBoolean(((Boolean) obj).booleanValue());
        return true;
    }

    public final /* synthetic */ zzwh zzcr(int i) {
        if (i >= this.size) {
            return new zzuo(Arrays.copyOf(this.zzbzd, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzcp(i);
        return Boolean.valueOf(this.zzbzd[i]);
    }

    static {
        zzuo zzuo = new zzuo(new boolean[0], 0);
        zzbzc = zzuo;
        super.zzsp();
    }
}

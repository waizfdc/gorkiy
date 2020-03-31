package com.google.android.gms.internal.firebase_ml;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzvi extends zzuk<Double> implements zzwh<Double>, zzxs, RandomAccess {
    private static final zzvi zzbzx;
    private int size;
    private double[] zzbzy;

    zzvi() {
        this(new double[10], 0);
    }

    private zzvi(double[] dArr, int i) {
        this.zzbzy = dArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzsq();
        if (i2 >= i) {
            double[] dArr = this.zzbzy;
            System.arraycopy(dArr, i2, dArr, i, this.size - i2);
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
        if (!(obj instanceof zzvi)) {
            return super.equals(obj);
        }
        zzvi zzvi = (zzvi) obj;
        if (this.size != zzvi.size) {
            return false;
        }
        double[] dArr = zzvi.zzbzy;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzbzy[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzvy.zzaf(Double.doubleToLongBits(this.zzbzy[i2]));
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zze(double d) {
        zzsq();
        int i = this.size;
        double[] dArr = this.zzbzy;
        if (i == dArr.length) {
            double[] dArr2 = new double[(((i * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.zzbzy = dArr2;
        }
        double[] dArr3 = this.zzbzy;
        int i2 = this.size;
        this.size = i2 + 1;
        dArr3[i2] = d;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzsq();
        zzvy.checkNotNull(collection);
        if (!(collection instanceof zzvi)) {
            return super.addAll(collection);
        }
        zzvi zzvi = (zzvi) collection;
        int i = zzvi.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.zzbzy;
            if (i3 > dArr.length) {
                this.zzbzy = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(zzvi.zzbzy, 0, this.zzbzy, this.size, zzvi.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzsq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzbzy[i]))) {
                double[] dArr = this.zzbzy;
                System.arraycopy(dArr, i + 1, dArr, i, (this.size - i) - 1);
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
        double doubleValue = ((Double) obj).doubleValue();
        zzsq();
        zzcp(i);
        double[] dArr = this.zzbzy;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final /* synthetic */ Object remove(int i) {
        zzsq();
        zzcp(i);
        double[] dArr = this.zzbzy;
        double d = dArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
        zzsq();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzcq(i));
        }
        double[] dArr = this.zzbzy;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.zzbzy, i, dArr2, i + 1, this.size - i);
            this.zzbzy = dArr2;
        }
        this.zzbzy[i] = doubleValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zze(((Double) obj).doubleValue());
        return true;
    }

    public final /* synthetic */ zzwh zzcr(int i) {
        if (i >= this.size) {
            return new zzvi(Arrays.copyOf(this.zzbzy, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzcp(i);
        return Double.valueOf(this.zzbzy[i]);
    }

    static {
        zzvi zzvi = new zzvi(new double[0], 0);
        zzbzx = zzvi;
        super.zzsp();
    }
}

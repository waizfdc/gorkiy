package com.google.android.gms.internal.firebase_ml;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzvw extends zzuk<Float> implements zzwh<Float>, zzxs, RandomAccess {
    private static final zzvw zzcdb;
    private int size;
    private float[] zzcdc;

    public static zzvw zzts() {
        return zzcdb;
    }

    zzvw() {
        this(new float[10], 0);
    }

    private zzvw(float[] fArr, int i) {
        this.zzcdc = fArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzsq();
        if (i2 >= i) {
            float[] fArr = this.zzcdc;
            System.arraycopy(fArr, i2, fArr, i, this.size - i2);
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
        if (!(obj instanceof zzvw)) {
            return super.equals(obj);
        }
        zzvw zzvw = (zzvw) obj;
        if (this.size != zzvw.size) {
            return false;
        }
        float[] fArr = zzvw.zzcdc;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzcdc[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzcdc[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzs(float f) {
        zzsq();
        int i = this.size;
        float[] fArr = this.zzcdc;
        if (i == fArr.length) {
            float[] fArr2 = new float[(((i * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.zzcdc = fArr2;
        }
        float[] fArr3 = this.zzcdc;
        int i2 = this.size;
        this.size = i2 + 1;
        fArr3[i2] = f;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzsq();
        zzvy.checkNotNull(collection);
        if (!(collection instanceof zzvw)) {
            return super.addAll(collection);
        }
        zzvw zzvw = (zzvw) collection;
        int i = zzvw.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zzcdc;
            if (i3 > fArr.length) {
                this.zzcdc = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zzvw.zzcdc, 0, this.zzcdc, this.size, zzvw.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzsq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzcdc[i]))) {
                float[] fArr = this.zzcdc;
                System.arraycopy(fArr, i + 1, fArr, i, (this.size - i) - 1);
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
        float floatValue = ((Float) obj).floatValue();
        zzsq();
        zzcp(i);
        float[] fArr = this.zzcdc;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    public final /* synthetic */ Object remove(int i) {
        zzsq();
        zzcp(i);
        float[] fArr = this.zzcdc;
        float f = fArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        float floatValue = ((Float) obj).floatValue();
        zzsq();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzcq(i));
        }
        float[] fArr = this.zzcdc;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.zzcdc, i, fArr2, i + 1, this.size - i);
            this.zzcdc = fArr2;
        }
        this.zzcdc[i] = floatValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzs(((Float) obj).floatValue());
        return true;
    }

    public final /* synthetic */ zzwh zzcr(int i) {
        if (i >= this.size) {
            return new zzvw(Arrays.copyOf(this.zzcdc, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzcp(i);
        return Float.valueOf(this.zzcdc[i]);
    }

    static {
        zzvw zzvw = new zzvw(new float[0], 0);
        zzcdb = zzvw;
        super.zzsp();
    }
}

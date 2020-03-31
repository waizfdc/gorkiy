package com.google.android.gms.internal.firebase_ml;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzwu extends zzuk<Long> implements zzwh<Long>, zzxs, RandomAccess {
    private static final zzwu zzcfd;
    private int size;
    private long[] zzcfe;

    zzwu() {
        this(new long[10], 0);
    }

    private zzwu(long[] jArr, int i) {
        this.zzcfe = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzsq();
        if (i2 >= i) {
            long[] jArr = this.zzcfe;
            System.arraycopy(jArr, i2, jArr, i, this.size - i2);
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
        if (!(obj instanceof zzwu)) {
            return super.equals(obj);
        }
        zzwu zzwu = (zzwu) obj;
        if (this.size != zzwu.size) {
            return false;
        }
        long[] jArr = zzwu.zzcfe;
        for (int i = 0; i < this.size; i++) {
            if (this.zzcfe[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzvy.zzaf(this.zzcfe[i2]);
        }
        return i;
    }

    public final long getLong(int i) {
        zzcp(i);
        return this.zzcfe[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzag(long j) {
        zzsq();
        int i = this.size;
        long[] jArr = this.zzcfe;
        if (i == jArr.length) {
            long[] jArr2 = new long[(((i * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.zzcfe = jArr2;
        }
        long[] jArr3 = this.zzcfe;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr3[i2] = j;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzsq();
        zzvy.checkNotNull(collection);
        if (!(collection instanceof zzwu)) {
            return super.addAll(collection);
        }
        zzwu zzwu = (zzwu) collection;
        int i = zzwu.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzcfe;
            if (i3 > jArr.length) {
                this.zzcfe = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzwu.zzcfe, 0, this.zzcfe, this.size, zzwu.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzsq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzcfe[i]))) {
                long[] jArr = this.zzcfe;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
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
        long longValue = ((Long) obj).longValue();
        zzsq();
        zzcp(i);
        long[] jArr = this.zzcfe;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i) {
        zzsq();
        zzcp(i);
        long[] jArr = this.zzcfe;
        long j = jArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        zzsq();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzcq(i));
        }
        long[] jArr = this.zzcfe;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zzcfe, i, jArr2, i + 1, this.size - i);
            this.zzcfe = jArr2;
        }
        this.zzcfe[i] = longValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzag(((Long) obj).longValue());
        return true;
    }

    public final /* synthetic */ zzwh zzcr(int i) {
        if (i >= this.size) {
            return new zzwu(Arrays.copyOf(this.zzcfe, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        zzwu zzwu = new zzwu(new long[0], 0);
        zzcfd = zzwu;
        super.zzsp();
    }
}

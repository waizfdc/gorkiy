package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzhq extends zzex<Long> implements zzgz<Long>, zzio, RandomAccess {
    private static final zzhq zzyj;
    private int size;
    private long[] zzyk;

    zzhq() {
        this(new long[10], 0);
    }

    private zzhq(long[] jArr, int i) {
        this.zzyk = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzdq();
        if (i2 >= i) {
            long[] jArr = this.zzyk;
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
        if (!(obj instanceof zzhq)) {
            return super.equals(obj);
        }
        zzhq zzhq = (zzhq) obj;
        if (this.size != zzhq.size) {
            return false;
        }
        long[] jArr = zzhq.zzyk;
        for (int i = 0; i < this.size; i++) {
            if (this.zzyk[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzgt.zzab(this.zzyk[i2]);
        }
        return i;
    }

    public final long getLong(int i) {
        zzae(i);
        return this.zzyk[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzac(long j) {
        zzdq();
        int i = this.size;
        long[] jArr = this.zzyk;
        if (i == jArr.length) {
            long[] jArr2 = new long[(((i * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.zzyk = jArr2;
        }
        long[] jArr3 = this.zzyk;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr3[i2] = j;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzdq();
        zzgt.checkNotNull(collection);
        if (!(collection instanceof zzhq)) {
            return super.addAll(collection);
        }
        zzhq zzhq = (zzhq) collection;
        int i = zzhq.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzyk;
            if (i3 > jArr.length) {
                this.zzyk = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzhq.zzyk, 0, this.zzyk, this.size, zzhq.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzdq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzyk[i]))) {
                long[] jArr = this.zzyk;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
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

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzdq();
        zzae(i);
        long[] jArr = this.zzyk;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i) {
        zzdq();
        zzae(i);
        long[] jArr = this.zzyk;
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
        zzdq();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzaf(i));
        }
        long[] jArr = this.zzyk;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zzyk, i, jArr2, i + 1, this.size - i);
            this.zzyk = jArr2;
        }
        this.zzyk[i] = longValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzac(((Long) obj).longValue());
        return true;
    }

    public final /* synthetic */ zzgz zzag(int i) {
        if (i >= this.size) {
            return new zzhq(Arrays.copyOf(this.zzyk, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        zzhq zzhq = new zzhq(new long[0], 0);
        zzyj = zzhq;
        super.zzdp();
    }
}

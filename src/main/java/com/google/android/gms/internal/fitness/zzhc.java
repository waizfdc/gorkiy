package com.google.android.gms.internal.fitness;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzhc extends zzfa<Long> implements zzgl<Long>, zzhx, RandomAccess {
    private static final zzhc zzxe;
    private int size;
    private long[] zzxf;

    zzhc() {
        this(new long[10], 0);
    }

    private zzhc(long[] jArr, int i) {
        this.zzxf = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzam();
        if (i2 >= i) {
            long[] jArr = this.zzxf;
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
        if (!(obj instanceof zzhc)) {
            return super.equals(obj);
        }
        zzhc zzhc = (zzhc) obj;
        if (this.size != zzhc.size) {
            return false;
        }
        long[] jArr = zzhc.zzxf;
        for (int i = 0; i < this.size; i++) {
            if (this.zzxf[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzgk.zzj(this.zzxf[i2]);
        }
        return i;
    }

    public final long getLong(int i) {
        zzaa(i);
        return this.zzxf[i];
    }

    public final int size() {
        return this.size;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzam();
        zzgk.checkNotNull(collection);
        if (!(collection instanceof zzhc)) {
            return super.addAll(collection);
        }
        zzhc zzhc = (zzhc) collection;
        int i = zzhc.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzxf;
            if (i3 > jArr.length) {
                this.zzxf = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzhc.zzxf, 0, this.zzxf, this.size, zzhc.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzam();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzxf[i]))) {
                long[] jArr = this.zzxf;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzaa(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzab(i));
        }
    }

    private final String zzab(int i) {
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
        zzam();
        zzaa(i);
        long[] jArr = this.zzxf;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i) {
        zzam();
        zzaa(i);
        long[] jArr = this.zzxf;
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
        zzam();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzab(i));
        }
        long[] jArr = this.zzxf;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zzxf, i, jArr2, i + 1, this.size - i);
            this.zzxf = jArr2;
        }
        this.zzxf[i] = longValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        long longValue = ((Long) obj).longValue();
        zzam();
        int i = this.size;
        long[] jArr = this.zzxf;
        if (i == jArr.length) {
            long[] jArr2 = new long[(((i * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.zzxf = jArr2;
        }
        long[] jArr3 = this.zzxf;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr3[i2] = longValue;
        return true;
    }

    public final /* synthetic */ zzgl zzac(int i) {
        if (i >= this.size) {
            return new zzhc(Arrays.copyOf(this.zzxf, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        zzhc zzhc = new zzhc(new long[0], 0);
        zzxe = zzhc;
        super.zzal();
    }
}

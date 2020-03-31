package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzgu extends zzex<Integer> implements zzgz<Integer>, zzio, RandomAccess {
    private static final zzgu zzxf;
    private int size;
    private int[] zzxg;

    public static zzgu zzgl() {
        return zzxf;
    }

    zzgu() {
        this(new int[10], 0);
    }

    private zzgu(int[] iArr, int i) {
        this.zzxg = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzdq();
        if (i2 >= i) {
            int[] iArr = this.zzxg;
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
        if (!(obj instanceof zzgu)) {
            return super.equals(obj);
        }
        zzgu zzgu = (zzgu) obj;
        if (this.size != zzgu.size) {
            return false;
        }
        int[] iArr = zzgu.zzxg;
        for (int i = 0; i < this.size; i++) {
            if (this.zzxg[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzxg[i2];
        }
        return i;
    }

    public final int getInt(int i) {
        zzae(i);
        return this.zzxg[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzbl(int i) {
        zzdq();
        int i2 = this.size;
        int[] iArr = this.zzxg;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.zzxg = iArr2;
        }
        int[] iArr3 = this.zzxg;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr3[i3] = i;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzdq();
        zzgt.checkNotNull(collection);
        if (!(collection instanceof zzgu)) {
            return super.addAll(collection);
        }
        zzgu zzgu = (zzgu) collection;
        int i = zzgu.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzxg;
            if (i3 > iArr.length) {
                this.zzxg = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzgu.zzxg, 0, this.zzxg, this.size, zzgu.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzdq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzxg[i]))) {
                int[] iArr = this.zzxg;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
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
        int intValue = ((Integer) obj).intValue();
        zzdq();
        zzae(i);
        int[] iArr = this.zzxg;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzdq();
        zzae(i);
        int[] iArr = this.zzxg;
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
        zzdq();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzaf(i));
        }
        int[] iArr = this.zzxg;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zzxg, i, iArr2, i + 1, this.size - i);
            this.zzxg = iArr2;
        }
        this.zzxg[i] = intValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzbl(((Integer) obj).intValue());
        return true;
    }

    public final /* synthetic */ zzgz zzag(int i) {
        if (i >= this.size) {
            return new zzgu(Arrays.copyOf(this.zzxg, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzgu zzgu = new zzgu(new int[0], 0);
        zzxf = zzgu;
        super.zzdp();
    }
}

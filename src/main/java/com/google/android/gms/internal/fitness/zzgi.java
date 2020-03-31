package com.google.android.gms.internal.fitness;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzgi extends zzfa<Integer> implements zzgl<Integer>, zzhx, RandomAccess {
    private static final zzgi zzvj;
    private int size;
    private int[] zzvk;

    zzgi() {
        this(new int[10], 0);
    }

    private zzgi(int[] iArr, int i) {
        this.zzvk = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzam();
        if (i2 >= i) {
            int[] iArr = this.zzvk;
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
        if (!(obj instanceof zzgi)) {
            return super.equals(obj);
        }
        zzgi zzgi = (zzgi) obj;
        if (this.size != zzgi.size) {
            return false;
        }
        int[] iArr = zzgi.zzvk;
        for (int i = 0; i < this.size; i++) {
            if (this.zzvk[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzvk[i2];
        }
        return i;
    }

    public final int getInt(int i) {
        zzaa(i);
        return this.zzvk[i];
    }

    public final int size() {
        return this.size;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzam();
        zzgk.checkNotNull(collection);
        if (!(collection instanceof zzgi)) {
            return super.addAll(collection);
        }
        zzgi zzgi = (zzgi) collection;
        int i = zzgi.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzvk;
            if (i3 > iArr.length) {
                this.zzvk = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzgi.zzvk, 0, this.zzvk, this.size, zzgi.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzam();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzvk[i]))) {
                int[] iArr = this.zzvk;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
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
        int intValue = ((Integer) obj).intValue();
        zzam();
        zzaa(i);
        int[] iArr = this.zzvk;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzam();
        zzaa(i);
        int[] iArr = this.zzvk;
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
        zzam();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzab(i));
        }
        int[] iArr = this.zzvk;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zzvk, i, iArr2, i + 1, this.size - i);
            this.zzvk = iArr2;
        }
        this.zzvk[i] = intValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzam();
        int i = this.size;
        int[] iArr = this.zzvk;
        if (i == iArr.length) {
            int[] iArr2 = new int[(((i * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            this.zzvk = iArr2;
        }
        int[] iArr3 = this.zzvk;
        int i2 = this.size;
        this.size = i2 + 1;
        iArr3[i2] = intValue;
        return true;
    }

    public final /* synthetic */ zzgl zzac(int i) {
        if (i >= this.size) {
            return new zzgi(Arrays.copyOf(this.zzvk, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzgi zzgi = new zzgi(new int[0], 0);
        zzvj = zzgi;
        super.zzal();
    }
}

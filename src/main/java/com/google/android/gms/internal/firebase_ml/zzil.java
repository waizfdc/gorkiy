package com.google.android.gms.internal.firebase_ml;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public class zzil<K, V> extends AbstractMap<K, V> implements Cloneable {
    int size;
    private Object[] zzadq;

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    final class zzb extends AbstractSet<Map.Entry<K, V>> {
        zzb() {
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return new zzc();
        }

        public final int size() {
            return zzil.this.size;
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    final class zzc implements Iterator<Map.Entry<K, V>> {
        private boolean zzadr;
        private int zzads;

        zzc() {
        }

        public final boolean hasNext() {
            return this.zzads < zzil.this.size;
        }

        public final void remove() {
            int i = this.zzads - 1;
            if (this.zzadr || i < 0) {
                throw new IllegalArgumentException();
            }
            zzil.this.remove(i);
            this.zzads--;
            this.zzadr = true;
        }

        public final /* synthetic */ Object next() {
            int i = this.zzads;
            if (i != zzil.this.size) {
                this.zzads++;
                this.zzadr = false;
                return new zza(i);
            }
            throw new NoSuchElementException();
        }
    }

    public final int size() {
        return this.size;
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    final class zza implements Map.Entry<K, V> {
        private int index;

        zza(int i) {
            this.index = i;
        }

        public final K getKey() {
            return zzil.this.zzai(this.index);
        }

        public final V getValue() {
            return zzil.this.zzaj(this.index);
        }

        public final V setValue(V v) {
            return zzil.this.set(this.index, v);
        }

        public final int hashCode() {
            Object key = getKey();
            Object value = getValue();
            int i = 0;
            int hashCode = key != null ? key.hashCode() : 0;
            if (value != null) {
                i = value.hashCode();
            }
            return hashCode ^ i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return zzma.equal(getKey(), entry.getKey()) && zzma.equal(getValue(), entry.getValue());
        }
    }

    public final K zzai(int i) {
        if (i < 0 || i >= this.size) {
            return null;
        }
        return this.zzadq[i << 1];
    }

    public final V zzaj(int i) {
        if (i < 0 || i >= this.size) {
            return null;
        }
        return zzak((i << 1) + 1);
    }

    public final V set(int i, V v) {
        int i2 = this.size;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = (i << 1) + 1;
        V zzak = zzak(i3);
        this.zzadq[i3] = v;
        return zzak;
    }

    public final V remove(int i) {
        return zzal(i << 1);
    }

    public final boolean containsKey(Object obj) {
        return -2 != zze(obj);
    }

    public final V get(Object obj) {
        return zzak(zze(obj) + 1);
    }

    public final V put(K k, V v) {
        int i;
        int zze = zze(k) >> 1;
        if (zze == -1) {
            zze = this.size;
        }
        if (zze >= 0) {
            int i2 = zze + 1;
            if (i2 >= 0) {
                Object[] objArr = this.zzadq;
                int i3 = i2 << 1;
                if (objArr == null) {
                    i = 0;
                } else {
                    i = objArr.length;
                }
                if (i3 > i) {
                    int i4 = ((i / 2) * 3) + 1;
                    if (i4 % 2 != 0) {
                        i4++;
                    }
                    if (i4 >= i3) {
                        i3 = i4;
                    }
                    if (i3 == 0) {
                        this.zzadq = null;
                    } else {
                        int i5 = this.size;
                        Object[] objArr2 = this.zzadq;
                        if (i5 == 0 || i3 != objArr2.length) {
                            Object[] objArr3 = new Object[i3];
                            this.zzadq = objArr3;
                            if (i5 != 0) {
                                System.arraycopy(objArr2, 0, objArr3, 0, i5 << 1);
                            }
                        }
                    }
                }
                int i6 = zze << 1;
                V zzak = zzak(i6 + 1);
                zzb(i6, k, v);
                if (i2 > this.size) {
                    this.size = i2;
                }
                return zzak;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IndexOutOfBoundsException();
    }

    public final V remove(Object obj) {
        return zzal(zze(obj));
    }

    private final void zzb(int i, K k, V v) {
        Object[] objArr = this.zzadq;
        objArr[i] = k;
        objArr[i + 1] = v;
    }

    private final V zzak(int i) {
        if (i < 0) {
            return null;
        }
        return this.zzadq[i];
    }

    private final int zze(Object obj) {
        int i = this.size << 1;
        Object[] objArr = this.zzadq;
        int i2 = 0;
        while (i2 < i) {
            Object obj2 = objArr[i2];
            if (obj == null) {
                if (obj2 != null) {
                    i2 += 2;
                }
            } else if (!obj.equals(obj2)) {
                i2 += 2;
            }
            return i2;
        }
        return -2;
    }

    private final V zzal(int i) {
        int i2 = this.size << 1;
        if (i < 0 || i >= i2) {
            return null;
        }
        V zzak = zzak(i + 1);
        Object[] objArr = this.zzadq;
        int i3 = (i2 - i) - 2;
        if (i3 != 0) {
            System.arraycopy(objArr, i + 2, objArr, i, i3);
        }
        this.size--;
        zzb(i2 - 2, null, null);
        return zzak;
    }

    public void clear() {
        this.size = 0;
        this.zzadq = null;
    }

    public final boolean containsValue(Object obj) {
        int i = this.size << 1;
        Object[] objArr = this.zzadq;
        int i2 = 1;
        while (i2 < i) {
            Object obj2 = objArr[i2];
            if (obj == null) {
                if (obj2 != null) {
                    i2 += 2;
                }
            } else if (!obj.equals(obj2)) {
                i2 += 2;
            }
            return true;
        }
        return false;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return new zzb();
    }

    /* access modifiers changed from: private */
    /* renamed from: zzhs */
    public final zzil<K, V> clone() {
        try {
            zzil<K, V> zzil = (zzil) super.clone();
            Object[] objArr = this.zzadq;
            if (objArr != null) {
                int length = objArr.length;
                Object[] objArr2 = new Object[length];
                zzil.zzadq = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
            }
            return zzil;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}

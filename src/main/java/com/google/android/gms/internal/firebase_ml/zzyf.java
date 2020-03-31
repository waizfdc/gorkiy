package com.google.android.gms.internal.firebase_ml;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
class zzyf<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzcaj;
    private final int zzchg;
    /* access modifiers changed from: private */
    public List<zzyk> zzchh;
    /* access modifiers changed from: private */
    public Map<K, V> zzchi;
    private volatile zzym zzchj;
    /* access modifiers changed from: private */
    public Map<K, V> zzchk;
    private volatile zzyg zzchl;

    static <FieldDescriptorType extends zzvs<FieldDescriptorType>> zzyf<FieldDescriptorType, Object> zzdw(int i) {
        return new zzye(i);
    }

    private zzyf(int i) {
        this.zzchg = i;
        this.zzchh = Collections.emptyList();
        this.zzchi = Collections.emptyMap();
        this.zzchk = Collections.emptyMap();
    }

    public void zzsp() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzcaj) {
            if (this.zzchi.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzchi);
            }
            this.zzchi = map;
            if (this.zzchk.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzchk);
            }
            this.zzchk = map2;
            this.zzcaj = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzcaj;
    }

    public final int zzvt() {
        return this.zzchh.size();
    }

    public final Map.Entry<K, V> zzdx(int i) {
        return this.zzchh.get(i);
    }

    public final Iterable<Map.Entry<K, V>> zzvu() {
        if (this.zzchi.isEmpty()) {
            return zzyj.zzvz();
        }
        return this.zzchi.entrySet();
    }

    public int size() {
        return this.zzchh.size() + this.zzchi.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzchi.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return this.zzchh.get(zza).getValue();
        }
        return this.zzchi.get(comparable);
    }

    /* renamed from: zza */
    public final V put(Comparable comparable, Object obj) {
        zzvw();
        int zza = zza(comparable);
        if (zza >= 0) {
            return this.zzchh.get(zza).setValue(obj);
        }
        zzvw();
        if (this.zzchh.isEmpty() && !(this.zzchh instanceof ArrayList)) {
            this.zzchh = new ArrayList(this.zzchg);
        }
        int i = -(zza + 1);
        if (i >= this.zzchg) {
            return zzvx().put(comparable, obj);
        }
        int size = this.zzchh.size();
        int i2 = this.zzchg;
        if (size == i2) {
            zzyk remove = this.zzchh.remove(i2 - 1);
            zzvx().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzchh.add(i, new zzyk(this, comparable, obj));
        return null;
    }

    public void clear() {
        zzvw();
        if (!this.zzchh.isEmpty()) {
            this.zzchh.clear();
        }
        if (!this.zzchi.isEmpty()) {
            this.zzchi.clear();
        }
    }

    public V remove(Object obj) {
        zzvw();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzdy(zza);
        }
        if (this.zzchi.isEmpty()) {
            return null;
        }
        return this.zzchi.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V zzdy(int i) {
        zzvw();
        V value = this.zzchh.remove(i).getValue();
        if (!this.zzchi.isEmpty()) {
            Iterator it = zzvx().entrySet().iterator();
            this.zzchh.add(new zzyk(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final int zza(K k) {
        int size = this.zzchh.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzchh.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzchh.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzchj == null) {
            this.zzchj = new zzym(this, null);
        }
        return this.zzchj;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzvv() {
        if (this.zzchl == null) {
            this.zzchl = new zzyg(this, null);
        }
        return this.zzchl;
    }

    /* access modifiers changed from: private */
    public final void zzvw() {
        if (this.zzcaj) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzvx() {
        zzvw();
        if (this.zzchi.isEmpty() && !(this.zzchi instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzchi = treeMap;
            this.zzchk = treeMap.descendingMap();
        }
        return (SortedMap) this.zzchi;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzyf)) {
            return super.equals(obj);
        }
        zzyf zzyf = (zzyf) obj;
        int size = size();
        if (size != zzyf.size()) {
            return false;
        }
        int zzvt = zzvt();
        if (zzvt != zzyf.zzvt()) {
            return entrySet().equals(zzyf.entrySet());
        }
        for (int i = 0; i < zzvt; i++) {
            if (!zzdx(i).equals(zzyf.zzdx(i))) {
                return false;
            }
        }
        if (zzvt != size) {
            return this.zzchi.equals(zzyf.zzchi);
        }
        return true;
    }

    public int hashCode() {
        int zzvt = zzvt();
        int i = 0;
        for (int i2 = 0; i2 < zzvt; i2++) {
            i += this.zzchh.get(i2).hashCode();
        }
        return this.zzchi.size() > 0 ? i + this.zzchi.hashCode() : i;
    }

    /* synthetic */ zzyf(int i, zzye zzye) {
        this(i);
    }
}

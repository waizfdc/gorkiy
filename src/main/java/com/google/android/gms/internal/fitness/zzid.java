package com.google.android.gms.internal.fitness;

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

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
class zzid<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzsk;
    private final int zzyk;
    /* access modifiers changed from: private */
    public List<zzim> zzyl;
    /* access modifiers changed from: private */
    public Map<K, V> zzym;
    private volatile zzio zzyn;
    /* access modifiers changed from: private */
    public Map<K, V> zzyo;
    private volatile zzii zzyp;

    static <FieldDescriptorType extends zzgd<FieldDescriptorType>> zzid<FieldDescriptorType, Object> zzai(int i) {
        return new zzig(i);
    }

    private zzid(int i) {
        this.zzyk = i;
        this.zzyl = Collections.emptyList();
        this.zzym = Collections.emptyMap();
        this.zzyo = Collections.emptyMap();
    }

    public void zzal() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzsk) {
            if (this.zzym.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzym);
            }
            this.zzym = map;
            if (this.zzyo.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzyo);
            }
            this.zzyo = map2;
            this.zzsk = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzsk;
    }

    public final int zzcq() {
        return this.zzyl.size();
    }

    public final Map.Entry<K, V> zzaj(int i) {
        return this.zzyl.get(i);
    }

    public final Iterable<Map.Entry<K, V>> zzcr() {
        if (this.zzym.isEmpty()) {
            return zzih.zzdb();
        }
        return this.zzym.entrySet();
    }

    public int size() {
        return this.zzyl.size() + this.zzym.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzym.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return this.zzyl.get(zza).getValue();
        }
        return this.zzym.get(comparable);
    }

    /* renamed from: zza */
    public final V put(Comparable comparable, Object obj) {
        zzct();
        int zza = zza(comparable);
        if (zza >= 0) {
            return this.zzyl.get(zza).setValue(obj);
        }
        zzct();
        if (this.zzyl.isEmpty() && !(this.zzyl instanceof ArrayList)) {
            this.zzyl = new ArrayList(this.zzyk);
        }
        int i = -(zza + 1);
        if (i >= this.zzyk) {
            return zzcu().put(comparable, obj);
        }
        int size = this.zzyl.size();
        int i2 = this.zzyk;
        if (size == i2) {
            zzim remove = this.zzyl.remove(i2 - 1);
            zzcu().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzyl.add(i, new zzim(this, comparable, obj));
        return null;
    }

    public void clear() {
        zzct();
        if (!this.zzyl.isEmpty()) {
            this.zzyl.clear();
        }
        if (!this.zzym.isEmpty()) {
            this.zzym.clear();
        }
    }

    public V remove(Object obj) {
        zzct();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzak(zza);
        }
        if (this.zzym.isEmpty()) {
            return null;
        }
        return this.zzym.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V zzak(int i) {
        zzct();
        V value = this.zzyl.remove(i).getValue();
        if (!this.zzym.isEmpty()) {
            Iterator it = zzcu().entrySet().iterator();
            this.zzyl.add(new zzim(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final int zza(K k) {
        int size = this.zzyl.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzyl.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.zzyl.get(i2).getKey());
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
        if (this.zzyn == null) {
            this.zzyn = new zzio(this, null);
        }
        return this.zzyn;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzcs() {
        if (this.zzyp == null) {
            this.zzyp = new zzii(this, null);
        }
        return this.zzyp;
    }

    /* access modifiers changed from: private */
    public final void zzct() {
        if (this.zzsk) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzcu() {
        zzct();
        if (this.zzym.isEmpty() && !(this.zzym instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzym = treeMap;
            this.zzyo = treeMap.descendingMap();
        }
        return (SortedMap) this.zzym;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzid)) {
            return super.equals(obj);
        }
        zzid zzid = (zzid) obj;
        int size = size();
        if (size != zzid.size()) {
            return false;
        }
        int zzcq = zzcq();
        if (zzcq != zzid.zzcq()) {
            return entrySet().equals(zzid.entrySet());
        }
        for (int i = 0; i < zzcq; i++) {
            if (!zzaj(i).equals(zzid.zzaj(i))) {
                return false;
            }
        }
        if (zzcq != size) {
            return this.zzym.equals(zzid.zzym);
        }
        return true;
    }

    public int hashCode() {
        int zzcq = zzcq();
        int i = 0;
        for (int i2 = 0; i2 < zzcq; i2++) {
            i += this.zzyl.get(i2).hashCode();
        }
        return this.zzym.size() > 0 ? i + this.zzym.hashCode() : i;
    }

    /* synthetic */ zzid(int i, zzig zzig) {
        this(i);
    }
}

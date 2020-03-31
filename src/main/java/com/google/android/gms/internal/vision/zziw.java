package com.google.android.gms.internal.vision;

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

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
class zziw<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private volatile zzix zzaaa;
    private boolean zztc;
    private final int zzzv;
    /* access modifiers changed from: private */
    public List<zzjb> zzzw;
    /* access modifiers changed from: private */
    public Map<K, V> zzzx;
    private volatile zzjd zzzy;
    /* access modifiers changed from: private */
    public Map<K, V> zzzz;

    static <FieldDescriptorType extends zzgk<FieldDescriptorType>> zziw<FieldDescriptorType, Object> zzbt(int i) {
        return new zziv(i);
    }

    private zziw(int i) {
        this.zzzv = i;
        this.zzzw = Collections.emptyList();
        this.zzzx = Collections.emptyMap();
        this.zzzz = Collections.emptyMap();
    }

    public void zzdp() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zztc) {
            if (this.zzzx.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzzx);
            }
            this.zzzx = map;
            if (this.zzzz.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzzz);
            }
            this.zzzz = map2;
            this.zztc = true;
        }
    }

    public final boolean isImmutable() {
        return this.zztc;
    }

    public final int zzhx() {
        return this.zzzw.size();
    }

    public final Map.Entry<K, V> zzbu(int i) {
        return this.zzzw.get(i);
    }

    public final Iterable<Map.Entry<K, V>> zzhy() {
        if (this.zzzx.isEmpty()) {
            return zzja.zzid();
        }
        return this.zzzx.entrySet();
    }

    public int size() {
        return this.zzzw.size() + this.zzzx.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzzx.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return this.zzzw.get(zza).getValue();
        }
        return this.zzzx.get(comparable);
    }

    /* renamed from: zza */
    public final V put(Comparable comparable, Object obj) {
        zzia();
        int zza = zza(comparable);
        if (zza >= 0) {
            return this.zzzw.get(zza).setValue(obj);
        }
        zzia();
        if (this.zzzw.isEmpty() && !(this.zzzw instanceof ArrayList)) {
            this.zzzw = new ArrayList(this.zzzv);
        }
        int i = -(zza + 1);
        if (i >= this.zzzv) {
            return zzib().put(comparable, obj);
        }
        int size = this.zzzw.size();
        int i2 = this.zzzv;
        if (size == i2) {
            zzjb remove = this.zzzw.remove(i2 - 1);
            zzib().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzzw.add(i, new zzjb(this, comparable, obj));
        return null;
    }

    public void clear() {
        zzia();
        if (!this.zzzw.isEmpty()) {
            this.zzzw.clear();
        }
        if (!this.zzzx.isEmpty()) {
            this.zzzx.clear();
        }
    }

    public V remove(Object obj) {
        zzia();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzbv(zza);
        }
        if (this.zzzx.isEmpty()) {
            return null;
        }
        return this.zzzx.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V zzbv(int i) {
        zzia();
        V value = this.zzzw.remove(i).getValue();
        if (!this.zzzx.isEmpty()) {
            Iterator it = zzib().entrySet().iterator();
            this.zzzw.add(new zzjb(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final int zza(K k) {
        int size = this.zzzw.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzzw.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.zzzw.get(i2).getKey());
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
        if (this.zzzy == null) {
            this.zzzy = new zzjd(this, null);
        }
        return this.zzzy;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzhz() {
        if (this.zzaaa == null) {
            this.zzaaa = new zzix(this, null);
        }
        return this.zzaaa;
    }

    /* access modifiers changed from: private */
    public final void zzia() {
        if (this.zztc) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzib() {
        zzia();
        if (this.zzzx.isEmpty() && !(this.zzzx instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzzx = treeMap;
            this.zzzz = treeMap.descendingMap();
        }
        return (SortedMap) this.zzzx;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zziw)) {
            return super.equals(obj);
        }
        zziw zziw = (zziw) obj;
        int size = size();
        if (size != zziw.size()) {
            return false;
        }
        int zzhx = zzhx();
        if (zzhx != zziw.zzhx()) {
            return entrySet().equals(zziw.entrySet());
        }
        for (int i = 0; i < zzhx; i++) {
            if (!zzbu(i).equals(zziw.zzbu(i))) {
                return false;
            }
        }
        if (zzhx != size) {
            return this.zzzx.equals(zziw.zzzx);
        }
        return true;
    }

    public int hashCode() {
        int zzhx = zzhx();
        int i = 0;
        for (int i2 = 0; i2 < zzhx; i2++) {
            i += this.zzzw.get(i2).hashCode();
        }
        return this.zzzx.size() > 0 ? i + this.zzzx.hashCode() : i;
    }

    /* synthetic */ zziw(int i, zziv zziv) {
        this(i);
    }
}

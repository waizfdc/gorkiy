package com.google.android.gms.internal.vision;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
class zzjd extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zziw zzaab;

    private zzjd(zziw zziw) {
        this.zzaab = zziw;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzje(this.zzaab, null);
    }

    public int size() {
        return this.zzaab.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzaab.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzaab.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzaab.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzaab.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzjd(zziw zziw, zziv zziv) {
        this(zziw);
    }
}

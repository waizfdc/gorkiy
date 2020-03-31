package com.google.android.gms.internal.firebase_ml;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
class zzym extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzyf zzchm;

    private zzym(zzyf zzyf) {
        this.zzchm = zzyf;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzyn(this.zzchm, null);
    }

    public int size() {
        return this.zzchm.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzchm.get(entry.getKey());
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
        this.zzchm.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzchm.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzchm.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzym(zzyf zzyf, zzye zzye) {
        this(zzyf);
    }
}

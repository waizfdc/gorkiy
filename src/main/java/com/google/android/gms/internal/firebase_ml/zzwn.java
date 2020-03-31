package com.google.android.gms.internal.firebase_ml;

import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzwn<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzwl> zzcet;

    private zzwn(Map.Entry<K, zzwl> entry) {
        this.zzcet = entry;
    }

    public final K getKey() {
        return this.zzcet.getKey();
    }

    public final Object getValue() {
        if (this.zzcet.getValue() == null) {
            return null;
        }
        return zzwl.zzup();
    }

    public final zzwl zzuq() {
        return this.zzcet.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzxg) {
            return this.zzcet.getValue().zzi((zzxg) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}

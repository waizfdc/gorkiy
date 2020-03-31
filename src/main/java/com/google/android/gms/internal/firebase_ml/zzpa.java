package com.google.android.gms.internal.firebase_ml;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public abstract class zzpa<K, V> {
    private final Map<K, V> zzbbn = new HashMap();

    /* access modifiers changed from: protected */
    public abstract V create(K k);

    public final V get(K k) {
        synchronized (this.zzbbn) {
            if (this.zzbbn.containsKey(k)) {
                V v = this.zzbbn.get(k);
                return v;
            }
            V create = create(k);
            this.zzbbn.put(k, create);
            return create;
        }
    }
}

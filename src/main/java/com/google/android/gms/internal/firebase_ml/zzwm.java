package com.google.android.gms.internal.firebase_ml;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzwm<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzces;

    public zzwm(Iterator<Map.Entry<K, Object>> it) {
        this.zzces = it;
    }

    public final boolean hasNext() {
        return this.zzces.hasNext();
    }

    public final void remove() {
        this.zzces.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzces.next();
        return next.getValue() instanceof zzwl ? new zzwn(next) : next;
    }
}

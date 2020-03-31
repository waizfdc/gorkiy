package com.google.android.gms.internal.fitness;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzgu<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzwv;

    public zzgu(Iterator<Map.Entry<K, Object>> it) {
        this.zzwv = it;
    }

    public final boolean hasNext() {
        return this.zzwv.hasNext();
    }

    public final void remove() {
        this.zzwv.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzwv.next();
        return next.getValue() instanceof zzgp ? new zzgr(next) : next;
    }
}

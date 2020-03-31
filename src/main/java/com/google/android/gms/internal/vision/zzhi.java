package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzhi<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzya;

    public zzhi(Iterator<Map.Entry<K, Object>> it) {
        this.zzya = it;
    }

    public final boolean hasNext() {
        return this.zzya.hasNext();
    }

    public final void remove() {
        this.zzya.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzya.next();
        return next.getValue() instanceof zzhd ? new zzhf(next) : next;
    }
}

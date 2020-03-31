package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zziy implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zziw zzaab;
    private Iterator<Map.Entry<K, V>> zzaac;

    private zziy(zziw zziw) {
        this.zzaab = zziw;
        this.pos = this.zzaab.zzzw.size();
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzaab.zzzw.size()) || zzic().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zzic() {
        if (this.zzaac == null) {
            this.zzaac = this.zzaab.zzzz.entrySet().iterator();
        }
        return this.zzaac;
    }

    public final /* synthetic */ Object next() {
        if (zzic().hasNext()) {
            return (Map.Entry) zzic().next();
        }
        List zzb = this.zzaab.zzzw;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) zzb.get(i);
    }

    /* synthetic */ zziy(zziw zziw, zziv zziv) {
        this(zziw);
    }
}

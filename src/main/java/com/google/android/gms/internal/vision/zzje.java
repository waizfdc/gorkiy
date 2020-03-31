package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzje implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zziw zzaab;
    private Iterator<Map.Entry<K, V>> zzaac;
    private boolean zzaag;

    private zzje(zziw zziw) {
        this.zzaab = zziw;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zzaab.zzzw.size() || (!this.zzaab.zzzx.isEmpty() && zzic().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.zzaag) {
            this.zzaag = false;
            this.zzaab.zzia();
            if (this.pos < this.zzaab.zzzw.size()) {
                zziw zziw = this.zzaab;
                int i = this.pos;
                this.pos = i - 1;
                Object unused = zziw.zzbv(i);
                return;
            }
            zzic().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> zzic() {
        if (this.zzaac == null) {
            this.zzaac = this.zzaab.zzzx.entrySet().iterator();
        }
        return this.zzaac;
    }

    public final /* synthetic */ Object next() {
        this.zzaag = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zzaab.zzzw.size()) {
            return (Map.Entry) this.zzaab.zzzw.get(this.pos);
        }
        return (Map.Entry) zzic().next();
    }

    /* synthetic */ zzje(zziw zziw, zziv zziv) {
        this(zziw);
    }
}

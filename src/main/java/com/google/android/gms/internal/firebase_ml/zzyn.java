package com.google.android.gms.internal.firebase_ml;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzyn implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzyf zzchm;
    private Iterator<Map.Entry<K, V>> zzchn;
    private boolean zzchr;

    private zzyn(zzyf zzyf) {
        this.zzchm = zzyf;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zzchm.zzchh.size() || (!this.zzchm.zzchi.isEmpty() && zzvy().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.zzchr) {
            this.zzchr = false;
            this.zzchm.zzvw();
            if (this.pos < this.zzchm.zzchh.size()) {
                zzyf zzyf = this.zzchm;
                int i = this.pos;
                this.pos = i - 1;
                Object unused = zzyf.zzdy(i);
                return;
            }
            zzvy().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> zzvy() {
        if (this.zzchn == null) {
            this.zzchn = this.zzchm.zzchi.entrySet().iterator();
        }
        return this.zzchn;
    }

    public final /* synthetic */ Object next() {
        this.zzchr = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zzchm.zzchh.size()) {
            return (Map.Entry) this.zzchm.zzchh.get(this.pos);
        }
        return (Map.Entry) zzvy().next();
    }

    /* synthetic */ zzyn(zzyf zzyf, zzye zzye) {
        this(zzyf);
    }
}

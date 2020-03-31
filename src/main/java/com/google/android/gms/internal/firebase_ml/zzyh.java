package com.google.android.gms.internal.firebase_ml;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzyh implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzyf zzchm;
    private Iterator<Map.Entry<K, V>> zzchn;

    private zzyh(zzyf zzyf) {
        this.zzchm = zzyf;
        this.pos = this.zzchm.zzchh.size();
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzchm.zzchh.size()) || zzvy().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zzvy() {
        if (this.zzchn == null) {
            this.zzchn = this.zzchm.zzchk.entrySet().iterator();
        }
        return this.zzchn;
    }

    public final /* synthetic */ Object next() {
        if (zzvy().hasNext()) {
            return (Map.Entry) zzvy().next();
        }
        List zzb = this.zzchm.zzchh;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) zzb.get(i);
    }

    /* synthetic */ zzyh(zzyf zzyf, zzye zzye) {
        this(zzyf);
    }
}

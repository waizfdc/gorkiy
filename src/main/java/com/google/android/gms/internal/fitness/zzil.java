package com.google.android.gms.internal.fitness;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzil implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzyu;
    private final /* synthetic */ zzid zzyv;
    private boolean zzyy;

    private zzil(zzid zzid) {
        this.zzyv = zzid;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zzyv.zzyl.size() || (!this.zzyv.zzym.isEmpty() && zzda().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.zzyy) {
            this.zzyy = false;
            this.zzyv.zzct();
            if (this.pos < this.zzyv.zzyl.size()) {
                zzid zzid = this.zzyv;
                int i = this.pos;
                this.pos = i - 1;
                Object unused = zzid.zzak(i);
                return;
            }
            zzda().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> zzda() {
        if (this.zzyu == null) {
            this.zzyu = this.zzyv.zzym.entrySet().iterator();
        }
        return this.zzyu;
    }

    public final /* synthetic */ Object next() {
        this.zzyy = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zzyv.zzyl.size()) {
            return (Map.Entry) this.zzyv.zzyl.get(this.pos);
        }
        return (Map.Entry) zzda().next();
    }

    /* synthetic */ zzil(zzid zzid, zzig zzig) {
        this(zzid);
    }
}

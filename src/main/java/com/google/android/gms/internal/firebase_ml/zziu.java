package com.google.android.gms.internal.firebase_ml;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zziu implements Iterator<Map.Entry<String, Object>> {
    private int zzaes = -1;
    private zziz zzaet;
    private Object zzaeu;
    private boolean zzaev;
    private boolean zzaew;
    private zziz zzaex;
    private final /* synthetic */ zzis zzaey;

    zziu(zzis zzis) {
        this.zzaey = zzis;
    }

    public final boolean hasNext() {
        if (!this.zzaew) {
            this.zzaew = true;
            this.zzaeu = null;
            while (this.zzaeu == null) {
                int i = this.zzaes + 1;
                this.zzaes = i;
                if (i >= this.zzaey.zzzm.zzaee.size()) {
                    break;
                }
                zziz zzan = this.zzaey.zzzm.zzan(this.zzaey.zzzm.zzaee.get(this.zzaes));
                this.zzaet = zzan;
                this.zzaeu = zzan.zzh(this.zzaey.object);
            }
        }
        if (this.zzaeu != null) {
            return true;
        }
        return false;
    }

    public final void remove() {
        zzmf.checkState(this.zzaex != null && !this.zzaev);
        this.zzaev = true;
        this.zzaex.zzb(this.zzaey.object, null);
    }

    public final /* synthetic */ Object next() {
        if (hasNext()) {
            zziz zziz = this.zzaet;
            this.zzaex = zziz;
            Object obj = this.zzaeu;
            this.zzaew = false;
            this.zzaev = false;
            this.zzaet = null;
            this.zzaeu = null;
            return new zziv(this.zzaey, zziz, obj);
        }
        throw new NoSuchElementException();
    }
}

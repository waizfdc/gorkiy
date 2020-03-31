package com.google.android.gms.internal.firebase_ml;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzix extends AbstractSet<Map.Entry<String, Object>> {
    private final /* synthetic */ zzis zzaey;

    zzix(zzis zzis) {
        this.zzaey = zzis;
    }

    public final int size() {
        int i = 0;
        for (String zzan : this.zzaey.zzzm.zzaee) {
            if (this.zzaey.zzzm.zzan(zzan).zzh(this.zzaey.object) != null) {
                i++;
            }
        }
        return i;
    }

    public final void clear() {
        for (String zzan : this.zzaey.zzzm.zzaee) {
            this.zzaey.zzzm.zzan(zzan).zzb(this.zzaey.object, null);
        }
    }

    public final boolean isEmpty() {
        for (String zzan : this.zzaey.zzzm.zzaee) {
            if (this.zzaey.zzzm.zzan(zzan).zzh(this.zzaey.object) != null) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Iterator iterator() {
        return new zziu(this.zzaey);
    }
}

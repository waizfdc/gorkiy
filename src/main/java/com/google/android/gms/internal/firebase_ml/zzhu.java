package com.google.android.gms.internal.firebase_ml;

import java.util.Collection;
import java.util.HashSet;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzhu {
    final zzht zzabs;
    Collection<String> zzabw = new HashSet();

    public zzhu(zzht zzht) {
        this.zzabs = (zzht) zzmf.checkNotNull(zzht);
    }

    public final zzhv zzgx() {
        return new zzhv(this);
    }

    public final zzhu zza(Collection<String> collection) {
        this.zzabw = collection;
        return this;
    }
}

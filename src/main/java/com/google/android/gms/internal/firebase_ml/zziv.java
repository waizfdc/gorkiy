package com.google.android.gms.internal.firebase_ml;

import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zziv implements Map.Entry<String, Object> {
    private final /* synthetic */ zzis zzaey;
    private Object zzaez;
    private final zziz zzafa;

    zziv(zzis zzis, zziz zziz, Object obj) {
        this.zzaey = zzis;
        this.zzafa = zziz;
        this.zzaez = zzmf.checkNotNull(obj);
    }

    public final Object getValue() {
        return this.zzaez;
    }

    public final Object setValue(Object obj) {
        Object obj2 = this.zzaez;
        this.zzaez = zzmf.checkNotNull(obj);
        this.zzafa.zzb(this.zzaey.object, obj);
        return obj2;
    }

    public final int hashCode() {
        return ((String) getKey()).hashCode() ^ getValue().hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return ((String) getKey()).equals(entry.getKey()) && getValue().equals(entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        String name = this.zzafa.getName();
        return this.zzaey.zzzm.zzhv() ? name.toLowerCase(Locale.US) : name;
    }
}

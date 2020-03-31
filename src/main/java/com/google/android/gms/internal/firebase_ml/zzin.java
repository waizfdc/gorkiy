package com.google.android.gms.internal.firebase_ml;

import java.lang.reflect.Field;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzin {
    private final Map<String, zzim> zzadv = new zzil();
    private final Map<Field, zzim> zzadw = new zzil();
    private final Object zzadx;

    public zzin(Object obj) {
        this.zzadx = obj;
    }

    public final void zzhu() {
        for (Map.Entry next : this.zzadv.entrySet()) {
            ((Map) this.zzadx).put((String) next.getKey(), ((zzim) next.getValue()).zzht());
        }
        for (Map.Entry next2 : this.zzadw.entrySet()) {
            zziz.zza((Field) next2.getKey(), this.zzadx, ((zzim) next2.getValue()).zzht());
        }
    }

    public final void zza(Field field, Class<?> cls, Object obj) {
        zzim zzim = this.zzadw.get(field);
        if (zzim == null) {
            zzim = new zzim(cls);
            this.zzadw.put(field, zzim);
        }
        zzmf.checkArgument(cls == zzim.zzadt);
        zzim.zzadu.add(obj);
    }
}

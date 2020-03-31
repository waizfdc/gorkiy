package com.google.android.gms.internal.firebase_ml;

import java.util.AbstractMap;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzis extends AbstractMap<String, Object> {
    final Object object;
    final zzir zzzm;

    zzis(Object obj, boolean z) {
        this.object = obj;
        zzir zza = zzir.zza(obj.getClass(), z);
        this.zzzm = zza;
        zzmf.checkArgument(!zza.isEnum());
    }

    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public final Object get(Object obj) {
        zziz zzan;
        if ((obj instanceof String) && (zzan = this.zzzm.zzan((String) obj)) != null) {
            return zzan.zzh(this.object);
        }
        return null;
    }

    public final /* synthetic */ Set entrySet() {
        return new zzix(this);
    }

    public final /* synthetic */ Object put(Object obj, Object obj2) {
        String str = (String) obj;
        zziz zzan = this.zzzm.zzan(str);
        String valueOf = String.valueOf(str);
        zzmf.checkNotNull(zzan, valueOf.length() != 0 ? "no field of key ".concat(valueOf) : new String("no field of key "));
        Object zzh = zzan.zzh(this.object);
        zzan.zzb(this.object, zzmf.checkNotNull(obj2));
        return zzh;
    }
}

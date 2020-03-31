package com.google.android.gms.internal.fitness;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzhk implements zzhh {
    zzhk() {
    }

    public final zzhf<?, ?> zzh(Object obj) {
        zzhg zzhg = (zzhg) obj;
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzf(Object obj) {
        return (zzhi) obj;
    }

    public final Object zzg(Object obj) {
        ((zzhi) obj).zzal();
        return obj;
    }

    public final Object zzc(Object obj, Object obj2) {
        zzhi zzhi = (zzhi) obj;
        zzhi zzhi2 = (zzhi) obj2;
        if (!zzhi2.isEmpty()) {
            if (!zzhi.isMutable()) {
                zzhi = zzhi.zzcc();
            }
            zzhi.zza(zzhi2);
        }
        return zzhi;
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzhi zzhi = (zzhi) obj;
        zzhg zzhg = (zzhg) obj2;
        if (zzhi.isEmpty()) {
            return 0;
        }
        Iterator it = zzhi.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}

package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
final class zzgk implements zzgh {
    zzgk() {
    }

    public final Map<?, ?> zza(Object obj) {
        return (zzgi) obj;
    }

    public final zzgf<?, ?> zzf(Object obj) {
        zzgg zzgg = (zzgg) obj;
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzb(Object obj) {
        return (zzgi) obj;
    }

    public final boolean zzc(Object obj) {
        return !((zzgi) obj).zzd();
    }

    public final Object zzd(Object obj) {
        ((zzgi) obj).zzc();
        return obj;
    }

    public final Object zze(Object obj) {
        return zzgi.zza().zzb();
    }

    public final Object zza(Object obj, Object obj2) {
        zzgi zzgi = (zzgi) obj;
        zzgi zzgi2 = (zzgi) obj2;
        if (!zzgi2.isEmpty()) {
            if (!zzgi.zzd()) {
                zzgi = zzgi.zzb();
            }
            zzgi.zza(zzgi2);
        }
        return zzgi;
    }

    public final int zza(int i, Object obj, Object obj2) {
        zzgi zzgi = (zzgi) obj;
        zzgg zzgg = (zzgg) obj2;
        if (zzgi.isEmpty()) {
            return 0;
        }
        Iterator it = zzgi.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}

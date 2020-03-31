package com.google.android.gms.internal.vision;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzin {
    private static final zzin zzzn = new zzin();
    private final zziu zzzo = new zzhp();
    private final ConcurrentMap<Class<?>, zzir<?>> zzzp = new ConcurrentHashMap();

    public static zzin zzho() {
        return zzzn;
    }

    public final <T> zzir<T> zzf(Class<T> cls) {
        zzgt.zza(cls, "messageType");
        zzir<T> zzir = this.zzzp.get(cls);
        if (zzir != null) {
            return zzir;
        }
        zzir<T> zze = this.zzzo.zze(cls);
        zzgt.zza(cls, "messageType");
        zzgt.zza(zze, "schema");
        zzir<T> putIfAbsent = this.zzzp.putIfAbsent(cls, zze);
        return putIfAbsent != null ? putIfAbsent : zze;
    }

    public final <T> zzir<T> zzu(T t) {
        return zzf(t.getClass());
    }

    private zzin() {
    }
}

package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
final class zzgz {
    private static final zzgz zza = new zzgz();
    private final zzhg zzb = new zzgb();
    private final ConcurrentMap<Class<?>, zzhd<?>> zzc = new ConcurrentHashMap();

    public static zzgz zza() {
        return zza;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzff.zza(java.lang.Object, java.lang.String):T
     arg types: [java.lang.Class, java.lang.String]
     candidates:
      com.google.android.gms.internal.measurement.zzff.zza(java.lang.Object, java.lang.Object):java.lang.Object
      com.google.android.gms.internal.measurement.zzff.zza(java.lang.Object, java.lang.String):T */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzff.zza(java.lang.Object, java.lang.String):T
     arg types: [com.google.android.gms.internal.measurement.zzhd<T>, java.lang.String]
     candidates:
      com.google.android.gms.internal.measurement.zzff.zza(java.lang.Object, java.lang.Object):java.lang.Object
      com.google.android.gms.internal.measurement.zzff.zza(java.lang.Object, java.lang.String):T */
    public final <T> zzhd<T> zza(Class cls) {
        zzff.zza((Object) cls, "messageType");
        zzhd<T> zzhd = this.zzc.get(cls);
        if (zzhd != null) {
            return zzhd;
        }
        zzhd<T> zza2 = this.zzb.zza(cls);
        zzff.zza((Object) cls, "messageType");
        zzff.zza((Object) zza2, "schema");
        zzhd<T> putIfAbsent = this.zzc.putIfAbsent(cls, zza2);
        return putIfAbsent != null ? putIfAbsent : zza2;
    }

    public final <T> zzhd<T> zza(Object obj) {
        return zza((Class) obj.getClass());
    }

    private zzgz() {
    }
}

package com.google.android.gms.internal.fitness;

import com.google.android.gms.internal.fitness.zzgg;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzgh implements zzhl {
    private static final zzgh zzve = new zzgh();

    private zzgh() {
    }

    public static zzgh zzbn() {
        return zzve;
    }

    public final boolean zzb(Class<?> cls) {
        return zzgg.class.isAssignableFrom(cls);
    }

    public final zzhm zzc(Class<?> cls) {
        if (!zzgg.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzhm) zzgg.zza(cls.asSubclass(zzgg.class)).zza(zzgg.zze.zzvn, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}

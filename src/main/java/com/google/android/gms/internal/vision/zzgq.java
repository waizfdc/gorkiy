package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzgq implements zzhz {
    private static final zzgq zzvy = new zzgq();

    private zzgq() {
    }

    public static zzgq zzfw() {
        return zzvy;
    }

    public final boolean zza(Class<?> cls) {
        return zzgs.class.isAssignableFrom(cls);
    }

    public final zzia zzb(Class<?> cls) {
        if (!zzgs.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzia) zzgs.zzd(cls.asSubclass(zzgs.class)).zza(zzgs.zzf.zzwn, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}

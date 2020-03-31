package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzhr implements zzhz {
    private zzhz[] zzyl;

    zzhr(zzhz... zzhzArr) {
        this.zzyl = zzhzArr;
    }

    public final boolean zza(Class<?> cls) {
        for (zzhz zza : this.zzyl) {
            if (zza.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzia zzb(Class<?> cls) {
        for (zzhz zzhz : this.zzyl) {
            if (zzhz.zza(cls)) {
                return zzhz.zzb(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}

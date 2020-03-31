package com.google.android.gms.internal.fitness;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzhd implements zzhl {
    private zzhl[] zzxg;

    zzhd(zzhl... zzhlArr) {
        this.zzxg = zzhlArr;
    }

    public final boolean zzb(Class<?> cls) {
        for (zzhl zzb : this.zzxg) {
            if (zzb.zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzhm zzc(Class<?> cls) {
        for (zzhl zzhl : this.zzxg) {
            if (zzhl.zzb(cls)) {
                return zzhl.zzc(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}

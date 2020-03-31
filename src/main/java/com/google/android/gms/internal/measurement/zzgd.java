package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
final class zzgd implements zzgl {
    private zzgl[] zza;

    zzgd(zzgl... zzglArr) {
        this.zza = zzglArr;
    }

    public final boolean zza(Class<?> cls) {
        for (zzgl zza2 : this.zza) {
            if (zza2.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzgm zzb(Class<?> cls) {
        for (zzgl zzgl : this.zza) {
            if (zzgl.zza(cls)) {
                return zzgl.zzb(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}

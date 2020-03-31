package com.google.android.gms.internal.fitness;

import com.google.android.gms.internal.fitness.zzgg;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzhb implements zzib {
    private static final zzhl zzxd = new zzhe();
    private final zzhl zzxc;

    public zzhb() {
        this(new zzhd(zzgh.zzbn(), zzcb()));
    }

    private zzhb(zzhl zzhl) {
        this.zzxc = (zzhl) zzgk.zza(zzhl, "messageInfoFactory");
    }

    public final <T> zzic<T> zzd(Class<T> cls) {
        zzie.zzf((Class<?>) cls);
        zzhm zzc = this.zzxc.zzc(cls);
        if (zzc.zzci()) {
            if (zzgg.class.isAssignableFrom(cls)) {
                return zzhr.zza(zzie.zzcx(), zzfy.zzbc(), zzc.zzcj());
            }
            return zzhr.zza(zzie.zzcv(), zzfy.zzbd(), zzc.zzcj());
        } else if (zzgg.class.isAssignableFrom(cls)) {
            if (zza(zzc)) {
                return zzhs.zza(cls, zzc, zzhv.zzcl(), zzgy.zzca(), zzie.zzcx(), zzfy.zzbc(), zzhj.zzcf());
            }
            return zzhs.zza(cls, zzc, zzhv.zzcl(), zzgy.zzca(), zzie.zzcx(), null, zzhj.zzcf());
        } else if (zza(zzc)) {
            return zzhs.zza(cls, zzc, zzhv.zzck(), zzgy.zzbz(), zzie.zzcv(), zzfy.zzbd(), zzhj.zzce());
        } else {
            return zzhs.zza(cls, zzc, zzhv.zzck(), zzgy.zzbz(), zzie.zzcw(), null, zzhj.zzce());
        }
    }

    private static boolean zza(zzhm zzhm) {
        return zzhm.zzch() == zzgg.zze.zzvt;
    }

    private static zzhl zzcb() {
        try {
            return (zzhl) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzxd;
        }
    }
}

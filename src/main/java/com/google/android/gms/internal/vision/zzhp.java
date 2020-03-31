package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzhp implements zziu {
    private static final zzhz zzyi = new zzhs();
    private final zzhz zzyh;

    public zzhp() {
        this(new zzhr(zzgq.zzfw(), zzhb()));
    }

    private zzhp(zzhz zzhz) {
        this.zzyh = (zzhz) zzgt.zza(zzhz, "messageInfoFactory");
    }

    public final <T> zzir<T> zze(Class<T> cls) {
        zzit.zzg(cls);
        zzia zzb = this.zzyh.zzb(cls);
        if (zzb.zzhj()) {
            if (zzgs.class.isAssignableFrom(cls)) {
                return zzii.zza(zzit.zzhu(), zzgj.zzfq(), zzb.zzhk());
            }
            return zzii.zza(zzit.zzhs(), zzgj.zzfr(), zzb.zzhk());
        } else if (zzgs.class.isAssignableFrom(cls)) {
            if (zza(zzb)) {
                return zzig.zza(cls, zzb, zzim.zzhm(), zzhm.zzha(), zzit.zzhu(), zzgj.zzfq(), zzhx.zzhg());
            }
            return zzig.zza(cls, zzb, zzim.zzhm(), zzhm.zzha(), zzit.zzhu(), (zzgf<?>) null, zzhx.zzhg());
        } else if (zza(zzb)) {
            return zzig.zza(cls, zzb, zzim.zzhl(), zzhm.zzgz(), zzit.zzhs(), zzgj.zzfr(), zzhx.zzhf());
        } else {
            return zzig.zza(cls, zzb, zzim.zzhl(), zzhm.zzgz(), zzit.zzht(), (zzgf<?>) null, zzhx.zzhf());
        }
    }

    private static boolean zza(zzia zzia) {
        return zzia.zzhi() == zzgs.zzf.zzwt;
    }

    private static zzhz zzhb() {
        try {
            return (zzhz) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzyi;
        }
    }
}

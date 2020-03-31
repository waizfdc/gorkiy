package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zzvx;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzwx implements zzyd {
    private static final zzxh zzcfg = new zzww();
    private final zzxh zzcff;

    public zzwx() {
        this(new zzwz(zzvv.zztr(), zzuv()));
    }

    private zzwx(zzxh zzxh) {
        this.zzcff = (zzxh) zzvy.zza(zzxh, "messageInfoFactory");
    }

    public final <T> zzya<T> zzk(Class<T> cls) {
        zzyc.zzm((Class<?>) cls);
        zzxe zzi = this.zzcff.zzi(cls);
        if (zzi.zzvb()) {
            if (zzvx.class.isAssignableFrom(cls)) {
                return zzxm.zza(zzyc.zzvq(), zzvn.zztj(), zzi.zzvc());
            }
            return zzxm.zza(zzyc.zzvo(), zzvn.zztk(), zzi.zzvc());
        } else if (zzvx.class.isAssignableFrom(cls)) {
            if (zza(zzi)) {
                return zzxk.zza(cls, zzi, zzxq.zzvh(), zzwq.zzuu(), zzyc.zzvq(), zzvn.zztj(), zzxf.zzve());
            }
            return zzxk.zza(cls, zzi, zzxq.zzvh(), zzwq.zzuu(), zzyc.zzvq(), (zzvm<?>) null, zzxf.zzve());
        } else if (zza(zzi)) {
            return zzxk.zza(cls, zzi, zzxq.zzvg(), zzwq.zzut(), zzyc.zzvo(), zzvn.zztk(), zzxf.zzvd());
        } else {
            return zzxk.zza(cls, zzi, zzxq.zzvg(), zzwq.zzut(), zzyc.zzvp(), (zzvm<?>) null, zzxf.zzvd());
        }
    }

    private static boolean zza(zzxe zzxe) {
        return zzxe.zzva() == zzvx.zzf.zzcds;
    }

    private static zzxh zzuv() {
        try {
            return (zzxh) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzcfg;
        }
    }
}

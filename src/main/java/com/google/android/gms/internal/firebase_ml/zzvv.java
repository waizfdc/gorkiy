package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zzvx;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzvv implements zzxh {
    private static final zzvv zzcda = new zzvv();

    private zzvv() {
    }

    public static zzvv zztr() {
        return zzcda;
    }

    public final boolean zzh(Class<?> cls) {
        return zzvx.class.isAssignableFrom(cls);
    }

    public final zzxe zzi(Class<?> cls) {
        if (!zzvx.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzxe) zzvx.zzj(cls.asSubclass(zzvx.class)).zza(zzvx.zzf.zzcdm, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}

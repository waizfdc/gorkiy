package com.google.android.gms.internal.firebase_ml;

import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzxc implements zzxd {
    zzxc() {
    }

    public final Map<?, ?> zzu(Object obj) {
        return (zzxa) obj;
    }

    public final zzxb<?, ?> zzv(Object obj) {
        return ((zzwy) obj).zzuw();
    }

    public final Map<?, ?> zzw(Object obj) {
        return (zzxa) obj;
    }

    public final boolean zzx(Object obj) {
        return !((zzxa) obj).isMutable();
    }

    public final Object zzy(Object obj) {
        ((zzxa) obj).zzsp();
        return obj;
    }

    public final Object zzz(Object obj) {
        return zzxa.zzux().zzuy();
    }

    public final Object zzd(Object obj, Object obj2) {
        zzxa zzxa = (zzxa) obj;
        zzxa zzxa2 = (zzxa) obj2;
        if (!zzxa2.isEmpty()) {
            if (!zzxa.isMutable()) {
                zzxa = zzxa.zzuy();
            }
            zzxa.zza(zzxa2);
        }
        return zzxa;
    }

    public final int zzd(int i, Object obj, Object obj2) {
        zzxa zzxa = (zzxa) obj;
        zzwy zzwy = (zzwy) obj2;
        int i2 = 0;
        if (zzxa.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : zzxa.entrySet()) {
            i2 += zzwy.zzc(i, entry.getKey(), entry.getValue());
        }
        return i2;
    }
}

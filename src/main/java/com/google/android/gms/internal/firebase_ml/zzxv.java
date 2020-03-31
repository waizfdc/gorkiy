package com.google.android.gms.internal.firebase_ml;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzxv {
    private static final zzxv zzcgn = new zzxv();
    private final zzyd zzcgo = new zzwx();
    private final ConcurrentMap<Class<?>, zzya<?>> zzcgp = new ConcurrentHashMap();

    public static zzxv zzvk() {
        return zzcgn;
    }

    public final <T> zzya<T> zzl(Class<T> cls) {
        zzvy.zza(cls, "messageType");
        zzya<T> zzya = this.zzcgp.get(cls);
        if (zzya != null) {
            return zzya;
        }
        zzya<T> zzk = this.zzcgo.zzk(cls);
        zzvy.zza(cls, "messageType");
        zzvy.zza(zzk, "schema");
        zzya<T> putIfAbsent = this.zzcgp.putIfAbsent(cls, zzk);
        return putIfAbsent != null ? putIfAbsent : zzk;
    }

    public final <T> zzya<T> zzad(T t) {
        return zzl(t.getClass());
    }

    private zzxv() {
    }
}

package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzwy<K, V> {
    private final V value;
    private final zzxb<K, V> zzcfh;
    private final K zzcfi;

    private zzwy(zzzj zzzj, K k, zzzj zzzj2, V v) {
        this.zzcfh = new zzxb<>(zzzj, k, zzzj2, v);
        this.zzcfi = k;
        this.value = v;
    }

    public static <K, V> zzwy<K, V> zza(zzzj zzzj, Object obj, zzzj zzzj2, Object obj2) {
        return new zzwy<>(zzzj, obj, zzzj2, obj2);
    }

    static <K, V> void zza(zzvh zzvh, zzxb zzxb, Object obj, Object obj2) throws IOException {
        zzvq.zza(zzvh, zzxb.zzcfl, 1, obj);
        zzvq.zza(zzvh, zzxb.zzcfn, 2, obj2);
    }

    static <K, V> int zza(zzxb<K, V> zzxb, K k, V v) {
        return zzvq.zza(zzxb.zzcfl, 1, k) + zzvq.zza(zzxb.zzcfn, 2, v);
    }

    public final int zzc(int i, K k, V v) {
        return zzvh.zzdb(i) + zzvh.zzdi(zza(this.zzcfh, k, v));
    }

    /* access modifiers changed from: package-private */
    public final zzxb<K, V> zzuw() {
        return this.zzcfh;
    }
}

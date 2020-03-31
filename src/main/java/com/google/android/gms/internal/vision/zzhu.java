package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public final class zzhu<K, V> {
    static <K, V> void zza(zzga zzga, zzht<K, V> zzht, K k, V v) throws IOException {
        zzgi.zza(zzga, zzht.zzym, 1, k);
        zzgi.zza(zzga, zzht.zzyo, 2, v);
    }

    static <K, V> int zza(zzht<K, V> zzht, K k, V v) {
        return zzgi.zza(zzht.zzym, 1, k) + zzgi.zza(zzht.zzyo, 2, v);
    }
}

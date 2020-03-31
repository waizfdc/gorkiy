package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
public final class zzgg<K, V> {
    static <K, V> void zza(zzen zzen, zzgf<K, V> zzgf, K k, V v) throws IOException {
        zzew.zza(zzen, zzgf.zza, 1, k);
        zzew.zza(zzen, zzgf.zzc, 2, v);
    }

    static <K, V> int zza(zzgf<K, V> zzgf, K k, V v) {
        return zzew.zza(zzgf.zza, 1, k) + zzew.zza(zzgf.zzc, 2, v);
    }
}

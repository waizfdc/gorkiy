package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzdc {
    public static <T> zzcz<T> zza(zzcz zzcz) {
        if ((zzcz instanceof zzde) || (zzcz instanceof zzdb)) {
            return zzcz;
        }
        if (zzcz instanceof Serializable) {
            return new zzdb(zzcz);
        }
        return new zzde(zzcz);
    }

    public static <T> zzcz<T> zza(@NullableDecl Object obj) {
        return new zzdd(obj);
    }
}

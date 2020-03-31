package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
interface zzir<T> {
    boolean equals(T t, T t2);

    int hashCode(T t);

    T newInstance();

    void zza(Object obj, zzis zzis, zzgd zzgd) throws IOException;

    void zza(Object obj, zzkg zzkg) throws IOException;

    void zza(T t, byte[] bArr, int i, int i2, zzfb zzfb) throws IOException;

    void zzd(T t, T t2);

    void zzg(T t);

    int zzr(T t);

    boolean zzt(T t);
}

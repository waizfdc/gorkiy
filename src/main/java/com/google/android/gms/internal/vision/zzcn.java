package com.google.android.gms.internal.vision;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public abstract class zzcn<T> implements Serializable {
    public static <T> zzcn<T> zzbx() {
        return zzck.zzlf;
    }

    public abstract T get();

    public abstract boolean isPresent();

    public static <T> zzcn<T> zzb(T t) {
        return new zzcs(zzct.checkNotNull(t));
    }

    zzcn() {
    }
}

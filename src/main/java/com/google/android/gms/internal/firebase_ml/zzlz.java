package com.google.android.gms.internal.firebase_ml;

import java.io.Serializable;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public abstract class zzlz<T> implements Serializable {
    public static <T> zzlz<T> zziz() {
        return zzlm.zzagk;
    }

    public abstract T get();

    public abstract boolean isPresent();

    public static <T> zzlz<T> zzj(T t) {
        return new zzme(zzmf.checkNotNull(t));
    }

    zzlz() {
    }
}

package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzun {
    private static final Class<?> zzbza = zzch("libcore.io.Memory");
    private static final boolean zzbzb = (zzch("org.robolectric.Robolectric") != null);

    static boolean zzsr() {
        return zzbza != null && !zzbzb;
    }

    static Class<?> zzss() {
        return zzbza;
    }

    private static <T> Class<T> zzch(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}

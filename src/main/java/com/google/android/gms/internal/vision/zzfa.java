package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzfa {
    private static final Class<?> zzrm = zzv("libcore.io.Memory");
    private static final boolean zzrn = (zzv("org.robolectric.Robolectric") != null);

    static boolean zzdr() {
        return zzrm != null && !zzrn;
    }

    static Class<?> zzds() {
        return zzrm;
    }

    private static <T> Class<T> zzv(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}

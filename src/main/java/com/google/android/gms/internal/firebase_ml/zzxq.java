package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzxq {
    private static final zzxo zzcgk = zzvi();
    private static final zzxo zzcgl = new zzxr();

    static zzxo zzvg() {
        return zzcgk;
    }

    static zzxo zzvh() {
        return zzcgl;
    }

    private static zzxo zzvi() {
        try {
            return (zzxo) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}

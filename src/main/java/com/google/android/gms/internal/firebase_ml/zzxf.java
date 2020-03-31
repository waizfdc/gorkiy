package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzxf {
    private static final zzxd zzcfp = zzvf();
    private static final zzxd zzcfq = new zzxc();

    static zzxd zzvd() {
        return zzcfp;
    }

    static zzxd zzve() {
        return zzcfq;
    }

    private static zzxd zzvf() {
        try {
            return (zzxd) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}

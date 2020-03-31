package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzvn {
    private static final zzvm<?> zzcae = new zzvo();
    private static final zzvm<?> zzcaf = zzti();

    private static zzvm<?> zzti() {
        try {
            return (zzvm) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzvm<?> zztj() {
        return zzcae;
    }

    static zzvm<?> zztk() {
        zzvm<?> zzvm = zzcaf;
        if (zzvm != null) {
            return zzvm;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}

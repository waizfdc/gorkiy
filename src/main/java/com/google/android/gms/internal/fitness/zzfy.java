package com.google.android.gms.internal.fitness;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzfy {
    private static final zzfw<?> zzsf = new zzfz();
    private static final zzfw<?> zzsg = zzbb();

    private static zzfw<?> zzbb() {
        try {
            return (zzfw) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzfw<?> zzbc() {
        return zzsf;
    }

    static zzfw<?> zzbd() {
        zzfw<?> zzfw = zzsg;
        if (zzfw != null) {
            return zzfw;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}

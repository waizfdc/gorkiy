package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzgj {
    private static final zzgf<?> zztf = new zzgh();
    private static final zzgf<?> zztg = zzfp();

    private static zzgf<?> zzfp() {
        try {
            return (zzgf) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzgf<?> zzfq() {
        return zztf;
    }

    static zzgf<?> zzfr() {
        zzgf<?> zzgf = zztg;
        if (zzgf != null) {
            return zzgf;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}

package com.google.android.gms.internal.fitness;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzhv {
    private static final zzht zzyf = zzcm();
    private static final zzht zzyg = new zzhw();

    static zzht zzck() {
        return zzyf;
    }

    static zzht zzcl() {
        return zzyg;
    }

    private static zzht zzcm() {
        try {
            return (zzht) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}

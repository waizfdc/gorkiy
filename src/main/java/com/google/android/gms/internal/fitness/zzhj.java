package com.google.android.gms.internal.fitness;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzhj {
    private static final zzhh zzxk = zzcg();
    private static final zzhh zzxl = new zzhk();

    static zzhh zzce() {
        return zzxk;
    }

    static zzhh zzcf() {
        return zzxl;
    }

    private static zzhh zzcg() {
        try {
            return (zzhh) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}

package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzhx {
    private static final zzhv zzyq = zzhh();
    private static final zzhv zzyr = new zzhy();

    static zzhv zzhf() {
        return zzyq;
    }

    static zzhv zzhg() {
        return zzyr;
    }

    private static zzhv zzhh() {
        try {
            return (zzhv) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}

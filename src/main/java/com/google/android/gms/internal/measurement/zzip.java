package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
public enum zzip {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzdu.zza),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzj;

    private zzip(Object obj) {
        this.zzj = obj;
    }
}

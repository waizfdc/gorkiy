package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public enum zzhe {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzfh.class, zzfh.class, zzfh.zzrx),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzxs;
    private final Class<?> zzxt;
    private final Object zzxu;

    private zzhe(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzxs = cls;
        this.zzxt = cls2;
        this.zzxu = obj;
    }

    public final Class<?> zzgv() {
        return this.zzxt;
    }
}

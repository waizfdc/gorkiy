package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public enum zzwi {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzuq.class, zzuq.class, zzuq.zzbzh),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzceo;
    private final Class<?> zzcep;
    private final Object zzceq;

    private zzwi(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzceo = cls;
        this.zzcep = cls2;
        this.zzceq = obj;
    }

    public final Class<?> zzuo() {
        return this.zzcep;
    }
}

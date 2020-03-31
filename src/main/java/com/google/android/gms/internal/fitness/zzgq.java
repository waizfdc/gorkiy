package com.google.android.gms.internal.fitness;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public enum zzgq {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzff.class, zzff.class, zzff.zzri),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzwn;
    private final Class<?> zzwo;
    private final Object zzwp;

    private zzgq(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzwn = cls;
        this.zzwo = cls2;
        this.zzwp = obj;
    }

    public final Class<?> zzbv() {
        return this.zzwo;
    }
}

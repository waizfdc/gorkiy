package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public abstract class zzhs {
    public abstract void flush() throws IOException;

    public abstract void writeBoolean(boolean z) throws IOException;

    public abstract void writeString(String str) throws IOException;

    public abstract void zza(double d) throws IOException;

    public abstract void zza(BigDecimal bigDecimal) throws IOException;

    public abstract void zza(BigInteger bigInteger) throws IOException;

    public abstract void zzah(int i) throws IOException;

    public abstract void zzal(String str) throws IOException;

    public abstract void zze(long j) throws IOException;

    public abstract void zzgr() throws IOException;

    public abstract void zzgs() throws IOException;

    public abstract void zzgt() throws IOException;

    public abstract void zzgu() throws IOException;

    public abstract void zzgv() throws IOException;

    public void zzgw() throws IOException {
    }

    public abstract void zzj(float f) throws IOException;

    public final void zzc(Object obj) throws IOException {
        zza(false, obj);
    }

    private final void zza(boolean z, Object obj) throws IOException {
        zzir zzir;
        boolean z2;
        Field field;
        if (obj != null) {
            Class<?> cls = obj.getClass();
            if (zzit.isNull(obj)) {
                zzgv();
            } else if (obj instanceof String) {
                writeString((String) obj);
            } else {
                boolean z3 = true;
                if (obj instanceof Number) {
                    if (z) {
                        writeString(obj.toString());
                    } else if (obj instanceof BigDecimal) {
                        zza((BigDecimal) obj);
                    } else if (obj instanceof BigInteger) {
                        zza((BigInteger) obj);
                    } else if (obj instanceof Long) {
                        zze(((Long) obj).longValue());
                    } else if (obj instanceof Float) {
                        float floatValue = ((Number) obj).floatValue();
                        if (Float.isInfinite(floatValue) || Float.isNaN(floatValue)) {
                            z3 = false;
                        }
                        zzmf.checkArgument(z3);
                        zzj(floatValue);
                    } else if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                        zzah(((Number) obj).intValue());
                    } else {
                        double doubleValue = ((Number) obj).doubleValue();
                        if (Double.isInfinite(doubleValue) || Double.isNaN(doubleValue)) {
                            z3 = false;
                        }
                        zzmf.checkArgument(z3);
                        zza(doubleValue);
                    }
                } else if (obj instanceof Boolean) {
                    writeBoolean(((Boolean) obj).booleanValue());
                } else if (obj instanceof zziw) {
                    writeString(((zziw) obj).zzhx());
                } else if ((obj instanceof Iterable) || cls.isArray()) {
                    zzgr();
                    for (Object zza : zzjo.zzi(obj)) {
                        zza(z, zza);
                    }
                    zzgs();
                } else if (cls.isEnum()) {
                    String name = zziz.zza((Enum) obj).getName();
                    if (name == null) {
                        zzgv();
                    } else {
                        writeString(name);
                    }
                } else {
                    zzgt();
                    boolean z4 = (obj instanceof Map) && !(obj instanceof zziy);
                    if (z4) {
                        zzir = null;
                    } else {
                        zzir = zzir.zzc(cls);
                    }
                    for (Map.Entry next : zzit.zzf(obj).entrySet()) {
                        Object value = next.getValue();
                        if (value != null) {
                            String str = (String) next.getKey();
                            if (z4) {
                                z2 = z;
                            } else {
                                zziz zzan = zzir.zzan(str);
                                if (zzan == null) {
                                    field = null;
                                } else {
                                    field = zzan.zzhz();
                                }
                                z2 = (field == null || field.getAnnotation(zzia.class) == null) ? false : true;
                            }
                            zzal(str);
                            zza(z2, value);
                        }
                    }
                    zzgu();
                }
            }
        }
    }
}

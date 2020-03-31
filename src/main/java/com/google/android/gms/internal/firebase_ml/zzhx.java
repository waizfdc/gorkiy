package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zzhy;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public abstract class zzhx {
    private static WeakHashMap<Class<?>, Field> zzabz = new WeakHashMap<>();
    private static final Lock zzaca = new ReentrantLock();

    public abstract void close() throws IOException;

    public abstract int getIntValue() throws IOException;

    public abstract String getText() throws IOException;

    public abstract zzht zzgz();

    public abstract zzhz zzha() throws IOException;

    public abstract zzhz zzhb();

    public abstract String zzhc() throws IOException;

    public abstract zzhx zzhd() throws IOException;

    public abstract byte zzhe() throws IOException;

    public abstract short zzhf() throws IOException;

    public abstract float zzhg() throws IOException;

    public abstract long zzhh() throws IOException;

    public abstract double zzhi() throws IOException;

    public abstract BigInteger zzhj() throws IOException;

    public abstract BigDecimal zzhk() throws IOException;

    public final <T> T zza(Class<T> cls, zzhr zzhr) throws IOException {
        try {
            return zza(cls, false, null);
        } finally {
            close();
        }
    }

    public final String zza(Set<String> set) throws IOException {
        zzhz zzhm = zzhm();
        while (zzhm == zzhz.FIELD_NAME) {
            String text = getText();
            zzha();
            if (set.contains(text)) {
                return text;
            }
            zzhd();
            zzhm = zzha();
        }
        return null;
    }

    private final zzhz zzhl() throws IOException {
        zzhz zzhb = zzhb();
        if (zzhb == null) {
            zzhb = zzha();
        }
        zzmf.checkArgument(zzhb != null, "no JSON input found");
        return zzhb;
    }

    private final zzhz zzhm() throws IOException {
        zzhz zzhl = zzhl();
        int i = zzhw.zzaby[zzhl.ordinal()];
        boolean z = true;
        if (i == 1) {
            zzhz zzha = zzha();
            if (!(zzha == zzhz.FIELD_NAME || zzha == zzhz.END_OBJECT)) {
                z = false;
            }
            zzmf.checkArgument(z, zzha);
            return zzha;
        } else if (i != 2) {
            return zzhl;
        } else {
            return zzha();
        }
    }

    public final Object zza(Type type, boolean z, zzhr zzhr) throws IOException {
        try {
            if (!Void.class.equals(type)) {
                zzhl();
            }
            return zza(null, type, new ArrayList(), null, null, true);
        } finally {
            if (z) {
                close();
            }
        }
    }

    private final void zza(Field field, Map<String, Object> map, Type type, ArrayList<Type> arrayList, zzhr zzhr) throws IOException {
        zzhz zzhm = zzhm();
        while (zzhm == zzhz.FIELD_NAME) {
            String text = getText();
            zzha();
            if (zzhr == null) {
                map.put(text, zza(field, type, arrayList, map, zzhr, true));
                zzhm = zzha();
            } else {
                throw new NoSuchMethodError();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzit.zza(java.util.List<java.lang.reflect.Type>, java.lang.reflect.Type):java.lang.reflect.Type
     arg types: [java.util.ArrayList<java.lang.reflect.Type>, java.lang.reflect.Type]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzit.zza(java.lang.reflect.Type, java.lang.String):java.lang.Object
      com.google.android.gms.internal.firebase_ml.zzit.zza(java.lang.Object, java.lang.Object):void
      com.google.android.gms.internal.firebase_ml.zzit.zza(java.util.List<java.lang.reflect.Type>, java.lang.reflect.Type):java.lang.reflect.Type */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01bd A[Catch:{ IllegalArgumentException -> 0x043d }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01c7 A[Catch:{ IllegalArgumentException -> 0x043d }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01ef A[Catch:{ IllegalArgumentException -> 0x043d }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0242 A[Catch:{ IllegalArgumentException -> 0x043d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object zza(java.lang.reflect.Field r20, java.lang.reflect.Type r21, java.util.ArrayList<java.lang.reflect.Type> r22, java.lang.Object r23, com.google.android.gms.internal.firebase_ml.zzhr r24, boolean r25) throws java.io.IOException {
        /*
            r19 = this;
            r8 = r20
            r0 = r22
            r1 = r21
            java.lang.reflect.Type r9 = com.google.android.gms.internal.firebase_ml.zzit.zza(r0, r1)
            boolean r1 = r9 instanceof java.lang.Class
            r10 = 0
            if (r1 == 0) goto L_0x0013
            r1 = r9
            java.lang.Class r1 = (java.lang.Class) r1
            goto L_0x0014
        L_0x0013:
            r1 = r10
        L_0x0014:
            boolean r2 = r9 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L_0x001f
            r1 = r9
            java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1
            java.lang.Class r1 = com.google.android.gms.internal.firebase_ml.zzjo.zza(r1)
        L_0x001f:
            java.lang.Class<java.lang.Void> r2 = java.lang.Void.class
            if (r1 != r2) goto L_0x0027
            r19.zzhd()
            return r10
        L_0x0027:
            com.google.android.gms.internal.firebase_ml.zzhz r2 = r19.zzhb()
            int[] r3 = com.google.android.gms.internal.firebase_ml.zzhw.zzaby     // Catch:{ IllegalArgumentException -> 0x043d }
            com.google.android.gms.internal.firebase_ml.zzhz r4 = r19.zzhb()     // Catch:{ IllegalArgumentException -> 0x043d }
            int r4 = r4.ordinal()     // Catch:{ IllegalArgumentException -> 0x043d }
            r3 = r3[r4]     // Catch:{ IllegalArgumentException -> 0x043d }
            r11 = 0
            r12 = 1
            switch(r3) {
                case 1: goto L_0x024c;
                case 2: goto L_0x01d1;
                case 3: goto L_0x01d1;
                case 4: goto L_0x024c;
                case 5: goto L_0x024c;
                case 6: goto L_0x01a1;
                case 7: goto L_0x01a1;
                case 8: goto L_0x00e4;
                case 9: goto L_0x00e4;
                case 10: goto L_0x008b;
                case 11: goto L_0x0040;
                default: goto L_0x003c;
            }     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x003c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x043d }
            goto L_0x041a
        L_0x0040:
            if (r1 == 0) goto L_0x0048
            boolean r2 = r1.isPrimitive()     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r2 != 0) goto L_0x0049
        L_0x0048:
            r11 = r12
        L_0x0049:
            java.lang.String r2 = "primitive number field but found a JSON null"
            com.google.android.gms.internal.firebase_ml.zzmf.checkArgument(r11, r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 == 0) goto L_0x0082
            int r2 = r1.getModifiers()     // Catch:{ IllegalArgumentException -> 0x043d }
            r2 = r2 & 1536(0x600, float:2.152E-42)
            if (r2 == 0) goto L_0x0082
            java.lang.Class<java.util.Collection> r2 = java.util.Collection.class
            boolean r2 = com.google.android.gms.internal.firebase_ml.zzjo.zza(r1, r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r2 == 0) goto L_0x006d
            java.util.Collection r0 = com.google.android.gms.internal.firebase_ml.zzit.zzb(r9)     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Class r0 = r0.getClass()     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Object r0 = com.google.android.gms.internal.firebase_ml.zzit.zzd(r0)     // Catch:{ IllegalArgumentException -> 0x043d }
            return r0
        L_0x006d:
            java.lang.Class<java.util.Map> r2 = java.util.Map.class
            boolean r2 = com.google.android.gms.internal.firebase_ml.zzjo.zza(r1, r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r2 == 0) goto L_0x0082
            java.util.Map r0 = com.google.android.gms.internal.firebase_ml.zzit.zze(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Class r0 = r0.getClass()     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Object r0 = com.google.android.gms.internal.firebase_ml.zzit.zzd(r0)     // Catch:{ IllegalArgumentException -> 0x043d }
            return r0
        L_0x0082:
            java.lang.Class r0 = com.google.android.gms.internal.firebase_ml.zzjo.zzb(r0, r9)     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Object r0 = com.google.android.gms.internal.firebase_ml.zzit.zzd(r0)     // Catch:{ IllegalArgumentException -> 0x043d }
            return r0
        L_0x008b:
            java.lang.String r0 = r19.getText()     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.String r0 = r0.trim()     // Catch:{ IllegalArgumentException -> 0x043d }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.String r0 = r0.toLowerCase(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Class r2 = java.lang.Float.TYPE     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 == r2) goto L_0x00a9
            java.lang.Class<java.lang.Float> r2 = java.lang.Float.class
            if (r1 == r2) goto L_0x00a9
            java.lang.Class r2 = java.lang.Double.TYPE     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 == r2) goto L_0x00a9
            java.lang.Class<java.lang.Double> r2 = java.lang.Double.class
            if (r1 != r2) goto L_0x00c1
        L_0x00a9:
            java.lang.String r2 = "nan"
            boolean r2 = r0.equals(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r2 != 0) goto L_0x00db
            java.lang.String r2 = "infinity"
            boolean r2 = r0.equals(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r2 != 0) goto L_0x00db
            java.lang.String r2 = "-infinity"
            boolean r0 = r0.equals(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r0 != 0) goto L_0x00db
        L_0x00c1:
            if (r1 == 0) goto L_0x00d5
            java.lang.Class<java.lang.Number> r0 = java.lang.Number.class
            boolean r0 = r0.isAssignableFrom(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r0 == 0) goto L_0x00d5
            if (r8 == 0) goto L_0x00d6
            java.lang.Class<com.google.android.gms.internal.firebase_ml.zzia> r0 = com.google.android.gms.internal.firebase_ml.zzia.class
            java.lang.annotation.Annotation r0 = r8.getAnnotation(r0)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r0 == 0) goto L_0x00d6
        L_0x00d5:
            r11 = r12
        L_0x00d6:
            java.lang.String r0 = "number field formatted as a JSON string must use the @JsonString annotation"
            com.google.android.gms.internal.firebase_ml.zzmf.checkArgument(r11, r0)     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x00db:
            java.lang.String r0 = r19.getText()     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Object r0 = com.google.android.gms.internal.firebase_ml.zzit.zza(r9, r0)     // Catch:{ IllegalArgumentException -> 0x043d }
            return r0
        L_0x00e4:
            if (r8 == 0) goto L_0x00ee
            java.lang.Class<com.google.android.gms.internal.firebase_ml.zzia> r0 = com.google.android.gms.internal.firebase_ml.zzia.class
            java.lang.annotation.Annotation r0 = r8.getAnnotation(r0)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r0 != 0) goto L_0x00ef
        L_0x00ee:
            r11 = r12
        L_0x00ef:
            java.lang.String r0 = "number type formatted as a JSON number cannot use @JsonString annotation"
            com.google.android.gms.internal.firebase_ml.zzmf.checkArgument(r11, r0)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 == 0) goto L_0x019c
            java.lang.Class<java.math.BigDecimal> r0 = java.math.BigDecimal.class
            boolean r0 = r1.isAssignableFrom(r0)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r0 == 0) goto L_0x0100
            goto L_0x019c
        L_0x0100:
            java.lang.Class<java.math.BigInteger> r0 = java.math.BigInteger.class
            if (r1 != r0) goto L_0x0109
            java.math.BigInteger r0 = r19.zzhj()     // Catch:{ IllegalArgumentException -> 0x043d }
            return r0
        L_0x0109:
            java.lang.Class<java.lang.Double> r0 = java.lang.Double.class
            if (r1 == r0) goto L_0x0193
            java.lang.Class r0 = java.lang.Double.TYPE     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 != r0) goto L_0x0113
            goto L_0x0193
        L_0x0113:
            java.lang.Class<java.lang.Long> r0 = java.lang.Long.class
            if (r1 == r0) goto L_0x018a
            java.lang.Class r0 = java.lang.Long.TYPE     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 != r0) goto L_0x011d
            goto L_0x018a
        L_0x011d:
            java.lang.Class<java.lang.Float> r0 = java.lang.Float.class
            if (r1 == r0) goto L_0x0181
            java.lang.Class r0 = java.lang.Float.TYPE     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 != r0) goto L_0x0126
            goto L_0x0181
        L_0x0126:
            java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
            if (r1 == r0) goto L_0x0178
            java.lang.Class r0 = java.lang.Integer.TYPE     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 != r0) goto L_0x012f
            goto L_0x0178
        L_0x012f:
            java.lang.Class<java.lang.Short> r0 = java.lang.Short.class
            if (r1 == r0) goto L_0x016f
            java.lang.Class r0 = java.lang.Short.TYPE     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 != r0) goto L_0x0138
            goto L_0x016f
        L_0x0138:
            java.lang.Class<java.lang.Byte> r0 = java.lang.Byte.class
            if (r1 == r0) goto L_0x0166
            java.lang.Class r0 = java.lang.Byte.TYPE     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 != r0) goto L_0x0141
            goto L_0x0166
        L_0x0141:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.String r1 = java.lang.String.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            int r2 = r2.length()     // Catch:{ IllegalArgumentException -> 0x043d }
            int r2 = r2 + 30
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x043d }
            r3.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.String r2 = "expected numeric type but got "
            r3.append(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            r3.append(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.String r1 = r3.toString()     // Catch:{ IllegalArgumentException -> 0x043d }
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            throw r0     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x0166:
            byte r0 = r19.zzhe()     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Byte r0 = java.lang.Byte.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x043d }
            return r0
        L_0x016f:
            short r0 = r19.zzhf()     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Short r0 = java.lang.Short.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x043d }
            return r0
        L_0x0178:
            int r0 = r19.getIntValue()     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x043d }
            return r0
        L_0x0181:
            float r0 = r19.zzhg()     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x043d }
            return r0
        L_0x018a:
            long r0 = r19.zzhh()     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x043d }
            return r0
        L_0x0193:
            double r0 = r19.zzhi()     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x043d }
            return r0
        L_0x019c:
            java.math.BigDecimal r0 = r19.zzhk()     // Catch:{ IllegalArgumentException -> 0x043d }
            return r0
        L_0x01a1:
            if (r9 == 0) goto L_0x01b4
            java.lang.Class r0 = java.lang.Boolean.TYPE     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 == r0) goto L_0x01b4
            if (r1 == 0) goto L_0x01b2
            java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
            boolean r0 = r1.isAssignableFrom(r0)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r0 == 0) goto L_0x01b2
            goto L_0x01b4
        L_0x01b2:
            r0 = r11
            goto L_0x01b5
        L_0x01b4:
            r0 = r12
        L_0x01b5:
            java.lang.String r1 = "expected type Boolean or boolean but got %s"
            java.lang.Object[] r3 = new java.lang.Object[r12]     // Catch:{ IllegalArgumentException -> 0x043d }
            r3[r11] = r9     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r0 == 0) goto L_0x01c7
            com.google.android.gms.internal.firebase_ml.zzhz r0 = com.google.android.gms.internal.firebase_ml.zzhz.VALUE_TRUE     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r2 != r0) goto L_0x01c4
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ IllegalArgumentException -> 0x043d }
            return r0
        L_0x01c4:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ IllegalArgumentException -> 0x043d }
            return r0
        L_0x01c7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.String r1 = com.google.android.gms.internal.firebase_ml.zzmn.zzb(r1, r3)     // Catch:{ IllegalArgumentException -> 0x043d }
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            throw r0     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x01d1:
            boolean r13 = com.google.android.gms.internal.firebase_ml.zzjo.zzc(r9)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r9 == 0) goto L_0x01e6
            if (r13 != 0) goto L_0x01e6
            if (r1 == 0) goto L_0x01e4
            java.lang.Class<java.util.Collection> r2 = java.util.Collection.class
            boolean r2 = com.google.android.gms.internal.firebase_ml.zzjo.zza(r1, r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r2 == 0) goto L_0x01e4
            goto L_0x01e6
        L_0x01e4:
            r2 = r11
            goto L_0x01e7
        L_0x01e6:
            r2 = r12
        L_0x01e7:
            java.lang.String r3 = "expected collection or array type but got %s"
            java.lang.Object[] r4 = new java.lang.Object[r12]     // Catch:{ IllegalArgumentException -> 0x043d }
            r4[r11] = r9     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r2 == 0) goto L_0x0242
            if (r24 == 0) goto L_0x01fa
            if (r8 != 0) goto L_0x01f4
            goto L_0x01fa
        L_0x01f4:
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError     // Catch:{ IllegalArgumentException -> 0x043d }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x043d }
            throw r0     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x01fa:
            java.util.Collection r11 = com.google.android.gms.internal.firebase_ml.zzit.zzb(r9)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r13 == 0) goto L_0x0205
            java.lang.reflect.Type r10 = com.google.android.gms.internal.firebase_ml.zzjo.zzd(r9)     // Catch:{ IllegalArgumentException -> 0x043d }
            goto L_0x0213
        L_0x0205:
            if (r1 == 0) goto L_0x0213
            java.lang.Class<java.lang.Iterable> r2 = java.lang.Iterable.class
            boolean r1 = r2.isAssignableFrom(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 == 0) goto L_0x0213
            java.lang.reflect.Type r10 = com.google.android.gms.internal.firebase_ml.zzjo.zze(r9)     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x0213:
            java.lang.reflect.Type r9 = com.google.android.gms.internal.firebase_ml.zzit.zza(r0, r10)     // Catch:{ IllegalArgumentException -> 0x043d }
            com.google.android.gms.internal.firebase_ml.zzhz r1 = r19.zzhm()     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x021b:
            com.google.android.gms.internal.firebase_ml.zzhz r2 = com.google.android.gms.internal.firebase_ml.zzhz.END_ARRAY     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 == r2) goto L_0x0236
            r7 = 1
            r1 = r19
            r2 = r20
            r3 = r9
            r4 = r22
            r5 = r11
            r6 = r24
            java.lang.Object r1 = r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ IllegalArgumentException -> 0x043d }
            r11.add(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            com.google.android.gms.internal.firebase_ml.zzhz r1 = r19.zzha()     // Catch:{ IllegalArgumentException -> 0x043d }
            goto L_0x021b
        L_0x0236:
            if (r13 == 0) goto L_0x0241
            java.lang.Class r0 = com.google.android.gms.internal.firebase_ml.zzjo.zzb(r0, r9)     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Object r0 = com.google.android.gms.internal.firebase_ml.zzjo.zza(r11, r0)     // Catch:{ IllegalArgumentException -> 0x043d }
            return r0
        L_0x0241:
            return r11
        L_0x0242:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.String r1 = com.google.android.gms.internal.firebase_ml.zzmn.zzb(r3, r4)     // Catch:{ IllegalArgumentException -> 0x043d }
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            throw r0     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x024c:
            boolean r2 = com.google.android.gms.internal.firebase_ml.zzjo.zzc(r9)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r2 != 0) goto L_0x0254
            r2 = r12
            goto L_0x0255
        L_0x0254:
            r2 = r11
        L_0x0255:
            java.lang.String r3 = "expected object or map type but got %s"
            java.lang.Object[] r4 = new java.lang.Object[r12]     // Catch:{ IllegalArgumentException -> 0x043d }
            r4[r11] = r9     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r2 == 0) goto L_0x0410
            if (r25 == 0) goto L_0x0265
            java.lang.reflect.Field r2 = zzb(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            r13 = r2
            goto L_0x0266
        L_0x0265:
            r13 = r10
        L_0x0266:
            if (r1 == 0) goto L_0x0271
            if (r24 != 0) goto L_0x026b
            goto L_0x0271
        L_0x026b:
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError     // Catch:{ IllegalArgumentException -> 0x043d }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x043d }
            throw r0     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x0271:
            if (r1 == 0) goto L_0x027d
            java.lang.Class<java.util.Map> r2 = java.util.Map.class
            boolean r2 = com.google.android.gms.internal.firebase_ml.zzjo.zza(r1, r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r2 == 0) goto L_0x027d
            r2 = r12
            goto L_0x027e
        L_0x027d:
            r2 = r11
        L_0x027e:
            if (r13 == 0) goto L_0x0286
            com.google.android.gms.internal.firebase_ml.zzhq r3 = new com.google.android.gms.internal.firebase_ml.zzhq     // Catch:{ IllegalArgumentException -> 0x043d }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x043d }
            goto L_0x0294
        L_0x0286:
            if (r2 != 0) goto L_0x0290
            if (r1 != 0) goto L_0x028b
            goto L_0x0290
        L_0x028b:
            java.lang.Object r3 = com.google.android.gms.internal.firebase_ml.zzjo.zzf(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            goto L_0x0294
        L_0x0290:
            java.util.Map r3 = com.google.android.gms.internal.firebase_ml.zzit.zze(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x0294:
            r14 = r3
            int r15 = r22.size()     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r9 == 0) goto L_0x029e
            r0.add(r9)     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x029e:
            if (r2 == 0) goto L_0x02c8
            java.lang.Class<com.google.android.gms.internal.firebase_ml.zziy> r2 = com.google.android.gms.internal.firebase_ml.zziy.class
            boolean r2 = r2.isAssignableFrom(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r2 != 0) goto L_0x02c8
            java.lang.Class<java.util.Map> r2 = java.util.Map.class
            boolean r1 = r2.isAssignableFrom(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 == 0) goto L_0x02b6
            java.lang.reflect.Type r1 = com.google.android.gms.internal.firebase_ml.zzjo.zzf(r9)     // Catch:{ IllegalArgumentException -> 0x043d }
            r4 = r1
            goto L_0x02b7
        L_0x02b6:
            r4 = r10
        L_0x02b7:
            if (r4 == 0) goto L_0x02c8
            r3 = r14
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ IllegalArgumentException -> 0x043d }
            r1 = r19
            r2 = r20
            r5 = r22
            r6 = r24
            r1.zza(r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x043d }
            return r14
        L_0x02c8:
            boolean r1 = r14 instanceof com.google.android.gms.internal.firebase_ml.zzhq     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 == 0) goto L_0x02d6
            r1 = r14
            com.google.android.gms.internal.firebase_ml.zzhq r1 = (com.google.android.gms.internal.firebase_ml.zzhq) r1     // Catch:{ IllegalArgumentException -> 0x043d }
            com.google.android.gms.internal.firebase_ml.zzht r2 = r19.zzgz()     // Catch:{ IllegalArgumentException -> 0x043d }
            r1.zza(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x02d6:
            com.google.android.gms.internal.firebase_ml.zzhz r1 = r19.zzhm()     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Class r2 = r14.getClass()     // Catch:{ IllegalArgumentException -> 0x043d }
            com.google.android.gms.internal.firebase_ml.zzir r7 = com.google.android.gms.internal.firebase_ml.zzir.zzc(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Class<com.google.android.gms.internal.firebase_ml.zziy> r3 = com.google.android.gms.internal.firebase_ml.zziy.class
            boolean r16 = r3.isAssignableFrom(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r16 != 0) goto L_0x0307
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            boolean r3 = r3.isAssignableFrom(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r3 == 0) goto L_0x0307
            r3 = r14
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ IllegalArgumentException -> 0x043d }
            r4 = 0
            java.lang.reflect.Type r5 = com.google.android.gms.internal.firebase_ml.zzjo.zzf(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            r1 = r19
            r2 = r4
            r4 = r5
            r5 = r22
            r6 = r24
            r1.zza(r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x043d }
            goto L_0x0390
        L_0x0307:
            com.google.android.gms.internal.firebase_ml.zzhz r2 = com.google.android.gms.internal.firebase_ml.zzhz.FIELD_NAME     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 != r2) goto L_0x0390
            java.lang.String r6 = r19.getText()     // Catch:{ IllegalArgumentException -> 0x043d }
            r19.zzha()     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r24 != 0) goto L_0x038a
            com.google.android.gms.internal.firebase_ml.zziz r5 = r7.zzan(r6)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r5 == 0) goto L_0x035c
            boolean r1 = r5.zzia()     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 == 0) goto L_0x032f
            boolean r1 = r5.isPrimitive()     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 == 0) goto L_0x0327
            goto L_0x032f
        L_0x0327:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.String r1 = "final array/object fields are not supported"
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            throw r0     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x032f:
            java.lang.reflect.Field r2 = r5.zzhz()     // Catch:{ IllegalArgumentException -> 0x043d }
            int r6 = r22.size()     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.reflect.Type r1 = r2.getGenericType()     // Catch:{ IllegalArgumentException -> 0x043d }
            r0.add(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.reflect.Type r3 = r5.getGenericType()     // Catch:{ IllegalArgumentException -> 0x043d }
            r17 = 1
            r1 = r19
            r4 = r22
            r10 = r5
            r5 = r14
            r11 = r6
            r6 = r24
            r18 = r7
            r7 = r17
            java.lang.Object r1 = r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ IllegalArgumentException -> 0x043d }
            r0.remove(r11)     // Catch:{ IllegalArgumentException -> 0x043d }
            r10.zzb(r14, r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            goto L_0x037b
        L_0x035c:
            r18 = r7
            if (r16 == 0) goto L_0x0376
            r10 = r14
            com.google.android.gms.internal.firebase_ml.zziy r10 = (com.google.android.gms.internal.firebase_ml.zziy) r10     // Catch:{ IllegalArgumentException -> 0x043d }
            r2 = 0
            r3 = 0
            r7 = 1
            r1 = r19
            r4 = r22
            r5 = r14
            r11 = r6
            r6 = r24
            java.lang.Object r1 = r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ IllegalArgumentException -> 0x043d }
            r10.zzb(r11, r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            goto L_0x037b
        L_0x0376:
            if (r24 != 0) goto L_0x0384
            r19.zzhd()     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x037b:
            com.google.android.gms.internal.firebase_ml.zzhz r1 = r19.zzha()     // Catch:{ IllegalArgumentException -> 0x043d }
            r7 = r18
            r10 = 0
            r11 = 0
            goto L_0x0307
        L_0x0384:
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError     // Catch:{ IllegalArgumentException -> 0x043d }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x043d }
            throw r0     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x038a:
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError     // Catch:{ IllegalArgumentException -> 0x043d }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x043d }
            throw r0     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x0390:
            if (r9 == 0) goto L_0x0395
            r0.remove(r15)     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x0395:
            if (r13 != 0) goto L_0x0398
            return r14
        L_0x0398:
            r1 = r14
            com.google.android.gms.internal.firebase_ml.zzhq r1 = (com.google.android.gms.internal.firebase_ml.zzhq) r1     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.String r2 = r13.getName()     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r1 == 0) goto L_0x03a7
            r2 = r12
            goto L_0x03a8
        L_0x03a7:
            r2 = 0
        L_0x03a8:
            java.lang.String r3 = "No value specified for @JsonPolymorphicTypeMap field"
            com.google.android.gms.internal.firebase_ml.zzmf.checkArgument(r2, r3)     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.String r1 = r1.toString()     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.Class<com.google.android.gms.internal.firebase_ml.zzhy> r2 = com.google.android.gms.internal.firebase_ml.zzhy.class
            java.lang.annotation.Annotation r2 = r13.getAnnotation(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            com.google.android.gms.internal.firebase_ml.zzhy r2 = (com.google.android.gms.internal.firebase_ml.zzhy) r2     // Catch:{ IllegalArgumentException -> 0x043d }
            com.google.android.gms.internal.firebase_ml.zzhy$zza[] r2 = r2.zzhp()     // Catch:{ IllegalArgumentException -> 0x043d }
            int r3 = r2.length     // Catch:{ IllegalArgumentException -> 0x043d }
            r4 = 0
        L_0x03bf:
            if (r4 >= r3) goto L_0x03d6
            r5 = r2[r4]     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.String r6 = r5.zzhn()     // Catch:{ IllegalArgumentException -> 0x043d }
            boolean r6 = r6.equals(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r6 == 0) goto L_0x03d3
            java.lang.Class r2 = r5.zzho()     // Catch:{ IllegalArgumentException -> 0x043d }
            r3 = r2
            goto L_0x03d7
        L_0x03d3:
            int r4 = r4 + 1
            goto L_0x03bf
        L_0x03d6:
            r3 = 0
        L_0x03d7:
            if (r3 == 0) goto L_0x03db
            r11 = r12
            goto L_0x03dc
        L_0x03db:
            r11 = 0
        L_0x03dc:
            java.lang.String r2 = "No TypeDef annotation found with key: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            int r4 = r1.length()     // Catch:{ IllegalArgumentException -> 0x043d }
            if (r4 == 0) goto L_0x03ed
            java.lang.String r1 = r2.concat(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            goto L_0x03f2
        L_0x03ed:
            java.lang.String r1 = new java.lang.String     // Catch:{ IllegalArgumentException -> 0x043d }
            r1.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x03f2:
            com.google.android.gms.internal.firebase_ml.zzmf.checkArgument(r11, r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            com.google.android.gms.internal.firebase_ml.zzht r1 = r19.zzgz()     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.String r2 = r1.toString(r14)     // Catch:{ IllegalArgumentException -> 0x043d }
            com.google.android.gms.internal.firebase_ml.zzhx r1 = r1.zzam(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            r1.zzhl()     // Catch:{ IllegalArgumentException -> 0x043d }
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r20
            r4 = r22
            java.lang.Object r0 = r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ IllegalArgumentException -> 0x043d }
            return r0
        L_0x0410:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.String r1 = com.google.android.gms.internal.firebase_ml.zzmn.zzb(r3, r4)     // Catch:{ IllegalArgumentException -> 0x043d }
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            throw r0     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x041a:
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            int r2 = r2.length()     // Catch:{ IllegalArgumentException -> 0x043d }
            int r2 = r2 + 27
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x043d }
            r3.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.String r2 = "unexpected JSON node type: "
            r3.append(r2)     // Catch:{ IllegalArgumentException -> 0x043d }
            r3.append(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            java.lang.String r1 = r3.toString()     // Catch:{ IllegalArgumentException -> 0x043d }
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x043d }
            throw r0     // Catch:{ IllegalArgumentException -> 0x043d }
        L_0x043d:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r19.zzhc()
            if (r2 == 0) goto L_0x0451
            java.lang.String r3 = "key "
            r1.append(r3)
            r1.append(r2)
        L_0x0451:
            if (r8 == 0) goto L_0x0462
            if (r2 == 0) goto L_0x045a
            java.lang.String r2 = ", "
            r1.append(r2)
        L_0x045a:
            java.lang.String r2 = "field "
            r1.append(r2)
            r1.append(r8)
        L_0x0462:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r1.toString()
            r2.<init>(r1, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzhx.zza(java.lang.reflect.Field, java.lang.reflect.Type, java.util.ArrayList, java.lang.Object, com.google.android.gms.internal.firebase_ml.zzhr, boolean):java.lang.Object");
    }

    private static Field zzb(Class<?> cls) {
        Field field = null;
        if (cls == null) {
            return null;
        }
        zzaca.lock();
        try {
            if (zzabz.containsKey(cls)) {
                return zzabz.get(cls);
            }
            for (zziz zzhz : zzir.zzc(cls).zzhw()) {
                Field zzhz2 = zzhz.zzhz();
                zzhy zzhy = (zzhy) zzhz2.getAnnotation(zzhy.class);
                if (zzhy != null) {
                    Object[] objArr = {cls};
                    if (field == null) {
                        boolean zza = zzit.zza(zzhz2.getType());
                        Object[] objArr2 = {cls, zzhz2.getType()};
                        if (zza) {
                            zzhy.zza[] zzhp = zzhy.zzhp();
                            HashSet hashSet = new HashSet();
                            zzmf.checkArgument(zzhp.length > 0, "@JsonPolymorphicTypeMap must have at least one @TypeDef");
                            int length = zzhp.length;
                            int i = 0;
                            while (i < length) {
                                zzhy.zza zza2 = zzhp[i];
                                boolean add = hashSet.add(zza2.zzhn());
                                Object[] objArr3 = {zza2.zzhn()};
                                if (add) {
                                    i++;
                                } else {
                                    throw new IllegalArgumentException(zzmn.zzb("Class contains two @TypeDef annotations with identical key: %s", objArr3));
                                }
                            }
                            field = zzhz2;
                        } else {
                            throw new IllegalArgumentException(zzmn.zzb("Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", objArr2));
                        }
                    } else {
                        throw new IllegalArgumentException(zzmn.zzb("Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", objArr));
                    }
                }
            }
            zzabz.put(cls, field);
            zzaca.unlock();
            return field;
        } finally {
            zzaca.unlock();
        }
    }
}

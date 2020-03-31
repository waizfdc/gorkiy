package com.google.android.gms.internal.firebase_ml;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzit {
    private static final Boolean zzaef = new Boolean(true);
    private static final String zzaeg = new String();
    private static final Character zzaeh = new Character(0);
    private static final Byte zzaei = new Byte((byte) 0);
    private static final Short zzaej = new Short((short) 0);
    private static final Integer zzaek = new Integer(0);
    private static final Float zzael = new Float(0.0f);
    private static final Long zzaem = new Long(0);
    private static final Double zzaen = new Double(0.0d);
    private static final BigInteger zzaeo = new BigInteger("0");
    private static final BigDecimal zzaep = new BigDecimal("0");
    private static final zziw zzaeq = new zziw(0);
    private static final ConcurrentHashMap<Class<?>, Object> zzaer;

    public static <T> T zzd(Class<?> cls) {
        T t;
        T t2 = zzaer.get(cls);
        if (t2 != null) {
            return t2;
        }
        int i = 0;
        if (cls.isArray()) {
            Class<?> cls2 = cls;
            do {
                cls2 = cls2.getComponentType();
                i++;
            } while (cls2.isArray());
            t = Array.newInstance(cls2, new int[i]);
        } else if (cls.isEnum()) {
            zziz zzan = zzir.zzc(cls).zzan(null);
            Object[] objArr = {cls};
            if (zzan != null) {
                t = zzan.zzib();
            } else {
                throw new NullPointerException(zzmn.zzb("enum missing constant with @NullValue annotation: %s", objArr));
            }
        } else {
            t = zzjo.zzf((Class) cls);
        }
        T putIfAbsent = zzaer.putIfAbsent(cls, t);
        return putIfAbsent == null ? t : putIfAbsent;
    }

    public static boolean isNull(Object obj) {
        return obj != null && obj == zzaer.get(obj.getClass());
    }

    public static Map<String, Object> zzf(Object obj) {
        if (obj == null || isNull(obj)) {
            return Collections.emptyMap();
        }
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return new zzis(obj, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzit.zza(java.lang.Object, java.lang.Object):void
     arg types: [T, T]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzit.zza(java.lang.reflect.Type, java.lang.String):java.lang.Object
      com.google.android.gms.internal.firebase_ml.zzit.zza(java.util.List<java.lang.reflect.Type>, java.lang.reflect.Type):java.lang.reflect.Type
      com.google.android.gms.internal.firebase_ml.zzit.zza(java.lang.Object, java.lang.Object):void */
    public static <T> T clone(T t) {
        T t2;
        if (t == null || zza(t.getClass())) {
            return t;
        }
        if (t instanceof zziy) {
            return (zziy) ((zziy) t).clone();
        }
        Class<?> cls = t.getClass();
        if (cls.isArray()) {
            t2 = Array.newInstance(cls.getComponentType(), Array.getLength(t));
        } else if (t instanceof zzil) {
            t2 = (zzil) ((zzil) t).clone();
        } else if ("java.util.Arrays$ArrayList".equals(cls.getName())) {
            Object[] array = ((List) t).toArray();
            zza(array, array);
            return Arrays.asList(array);
        } else {
            t2 = zzjo.zzf((Class) cls);
        }
        zza((Object) t, (Object) t2);
        return t2;
    }

    public static void zza(Object obj, Object obj2) {
        Object zzh;
        Class<?> cls = obj.getClass();
        boolean z = true;
        int i = 0;
        zzmf.checkArgument(cls == obj2.getClass());
        if (cls.isArray()) {
            if (Array.getLength(obj) != Array.getLength(obj2)) {
                z = false;
            }
            zzmf.checkArgument(z);
            for (Object clone : zzjo.zzi(obj)) {
                Array.set(obj2, i, clone(clone));
                i++;
            }
        } else if (Collection.class.isAssignableFrom(cls)) {
            Collection<Object> collection = (Collection) obj;
            if (ArrayList.class.isAssignableFrom(cls)) {
                ((ArrayList) obj2).ensureCapacity(collection.size());
            }
            Collection collection2 = (Collection) obj2;
            for (Object clone2 : collection) {
                collection2.add(clone(clone2));
            }
        } else {
            boolean isAssignableFrom = zziy.class.isAssignableFrom(cls);
            if (isAssignableFrom || !Map.class.isAssignableFrom(cls)) {
                zzir zzc = isAssignableFrom ? ((zziy) obj).zzzm : zzir.zzc(cls);
                for (String zzan : zzc.zzaee) {
                    zziz zzan2 = zzc.zzan(zzan);
                    if (!zzan2.zzia() && ((!isAssignableFrom || !zzan2.isPrimitive()) && (zzh = zzan2.zzh(obj)) != null)) {
                        zzan2.zzb(obj2, clone(zzh));
                    }
                }
            } else if (zzil.class.isAssignableFrom(cls)) {
                zzil zzil = (zzil) obj2;
                zzil zzil2 = (zzil) obj;
                int size = zzil2.size();
                while (i < size) {
                    zzil.set(i, clone(zzil2.zzaj(i)));
                    i++;
                }
            } else {
                Map map = (Map) obj2;
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    map.put((String) entry.getKey(), clone(entry.getValue()));
                }
            }
        }
    }

    public static boolean zza(Type type) {
        if (type instanceof WildcardType) {
            type = zzjo.zza((WildcardType) type);
        }
        if (!(type instanceof Class)) {
            return false;
        }
        Class<Boolean> cls = (Class) type;
        if (cls.isPrimitive() || cls == Character.class || cls == String.class || cls == Integer.class || cls == Long.class || cls == Short.class || cls == Byte.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == zziw.class || cls == Boolean.class) {
            return true;
        }
        return false;
    }

    public static boolean zzg(Object obj) {
        return obj == null || zza(obj.getClass());
    }

    public static Object zza(Type type, String str) {
        Class<BigDecimal> cls = type instanceof Class ? (Class) type : null;
        if (type == null || cls != null) {
            if (cls == Void.class) {
                return null;
            }
            if (str == null || cls == null || cls.isAssignableFrom(String.class)) {
                return str;
            }
            if (cls == Character.class || cls == Character.TYPE) {
                if (str.length() == 1) {
                    return Character.valueOf(str.charAt(0));
                }
                String valueOf = String.valueOf(cls);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 37);
                sb.append("expected type Character/char but got ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            } else if (cls == Boolean.class || cls == Boolean.TYPE) {
                return Boolean.valueOf(str);
            } else {
                if (cls == Byte.class || cls == Byte.TYPE) {
                    return Byte.valueOf(str);
                }
                if (cls == Short.class || cls == Short.TYPE) {
                    return Short.valueOf(str);
                }
                if (cls == Integer.class || cls == Integer.TYPE) {
                    return Integer.valueOf(str);
                }
                if (cls == Long.class || cls == Long.TYPE) {
                    return Long.valueOf(str);
                }
                if (cls == Float.class || cls == Float.TYPE) {
                    return Float.valueOf(str);
                }
                if (cls == Double.class || cls == Double.TYPE) {
                    return Double.valueOf(str);
                }
                if (cls == zziw.class) {
                    return zziw.zzao(str);
                }
                if (cls == BigInteger.class) {
                    return new BigInteger(str);
                }
                if (cls == BigDecimal.class) {
                    return new BigDecimal(str);
                }
                if (cls.isEnum()) {
                    if (zzir.zzc(cls).zzaee.contains(str)) {
                        return zzir.zzc(cls).zzan(str).zzib();
                    }
                    throw new IllegalArgumentException(String.format("given enum name %s not part of enumeration", str));
                }
            }
        }
        String valueOf2 = String.valueOf(type);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 35);
        sb2.append("expected primitive class, but got: ");
        sb2.append(valueOf2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static Collection<Object> zzb(Type type) {
        if (type instanceof WildcardType) {
            type = zzjo.zza((WildcardType) type);
        }
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
        }
        Class cls = type instanceof Class ? (Class) type : null;
        if (type == null || (type instanceof GenericArrayType) || (cls != null && (cls.isArray() || cls.isAssignableFrom(ArrayList.class)))) {
            return new ArrayList();
        }
        if (cls == null) {
            String valueOf = String.valueOf(type);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
            sb.append("unable to create new instance of type: ");
            sb.append(valueOf);
            throw new IllegalArgumentException(sb.toString());
        } else if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        } else {
            if (cls.isAssignableFrom(TreeSet.class)) {
                return new TreeSet();
            }
            return (Collection) zzjo.zzf(cls);
        }
    }

    public static Map<String, Object> zze(Class<?> cls) {
        if (cls == null || cls.isAssignableFrom(zzil.class)) {
            return new zzil();
        }
        if (cls.isAssignableFrom(TreeMap.class)) {
            return new TreeMap();
        }
        return (Map) zzjo.zzf((Class) cls);
    }

    public static Type zza(List<Type> list, Type type) {
        if (type instanceof WildcardType) {
            type = zzjo.zza((WildcardType) type);
        }
        while (type instanceof TypeVariable) {
            Type zza = zzjo.zza(list, (TypeVariable) type);
            if (zza != null) {
                type = zza;
            }
            if (type instanceof TypeVariable) {
                type = ((TypeVariable) type).getBounds()[0];
            }
        }
        return type;
    }

    static {
        ConcurrentHashMap<Class<?>, Object> concurrentHashMap = new ConcurrentHashMap<>();
        zzaer = concurrentHashMap;
        concurrentHashMap.put(Boolean.class, zzaef);
        zzaer.put(String.class, zzaeg);
        zzaer.put(Character.class, zzaeh);
        zzaer.put(Byte.class, zzaei);
        zzaer.put(Short.class, zzaej);
        zzaer.put(Integer.class, zzaek);
        zzaer.put(Float.class, zzael);
        zzaer.put(Long.class, zzaem);
        zzaer.put(Double.class, zzaen);
        zzaer.put(BigInteger.class, zzaeo);
        zzaer.put(BigDecimal.class, zzaep);
        zzaer.put(zziw.class, zzaeq);
    }
}

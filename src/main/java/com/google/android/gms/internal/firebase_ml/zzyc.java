package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzyc {
    private static final Class<?> zzchc = zzvr();
    private static final zzys<?, ?> zzchd = zzba(false);
    private static final zzys<?, ?> zzche = zzba(true);
    private static final zzys<?, ?> zzchf = new zzyu();

    public static void zzm(Class<?> cls) {
        Class<?> cls2;
        if (!zzvx.class.isAssignableFrom(cls) && (cls2 = zzchc) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzzp zzzp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzzp zzzp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzzp zzzp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzzp zzzp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzzp zzzp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzzp zzzp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzzp zzzp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzzp zzzp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzzp zzzp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzzp zzzp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzzp zzzp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzzp zzzp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzzp zzzp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzzp zzzp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzzp zzzp) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzuq> list, zzzp zzzp) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzzp zzzp, zzya zzya) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zza(i, list, zzya);
        }
    }

    public static void zzb(int i, List<?> list, zzzp zzzp, zzya zzya) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzp.zzb(i, list, zzya);
        }
    }

    static int zzi(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzwu) {
            zzwu zzwu = (zzwu) list;
            i = 0;
            while (i2 < size) {
                i += zzvh.zzz(zzwu.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzvh.zzz(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzi(list) + (list.size() * zzvh.zzdb(i));
    }

    static int zzj(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzwu) {
            zzwu zzwu = (zzwu) list;
            i = 0;
            while (i2 < size) {
                i += zzvh.zzaa(zzwu.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzvh.zzaa(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzvh.zzdb(i));
    }

    static int zzk(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzwu) {
            zzwu zzwu = (zzwu) list;
            i = 0;
            while (i2 < size) {
                i += zzvh.zzab(zzwu.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzvh.zzab(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzvh.zzdb(i));
    }

    static int zzl(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            i = 0;
            while (i2 < size) {
                i += zzvh.zzdh(zzvz.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzvh.zzdh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzvh.zzdb(i));
    }

    static int zzm(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            i = 0;
            while (i2 < size) {
                i += zzvh.zzdc(zzvz.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzvh.zzdc(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzm(list) + (size * zzvh.zzdb(i));
    }

    static int zzn(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            i = 0;
            while (i2 < size) {
                i += zzvh.zzdd(zzvz.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzvh.zzdd(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzn(list) + (size * zzvh.zzdb(i));
    }

    static int zzo(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            i = 0;
            while (i2 < size) {
                i += zzvh.zzde(zzvz.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzvh.zzde(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzo(list) + (size * zzvh.zzdb(i));
    }

    static int zzp(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzvh.zzp(i, 0);
    }

    static int zzq(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzvh.zzg(i, 0);
    }

    static int zzr(List<?> list) {
        return list.size();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, boolean):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, double):int
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, float):int
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, com.google.android.gms.internal.firebase_ml.zzwp):int
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, com.google.android.gms.internal.firebase_ml.zzxg):int
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, long):void
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, com.google.android.gms.internal.firebase_ml.zzuq):void
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, java.lang.String):void
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, boolean):int */
    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzvh.zzb(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzdb = zzvh.zzdb(i) * size;
        if (list instanceof zzwr) {
            zzwr zzwr = (zzwr) list;
            while (i4 < size) {
                Object raw = zzwr.getRaw(i4);
                if (raw instanceof zzuq) {
                    i3 = zzvh.zzd((zzuq) raw);
                } else {
                    i3 = zzvh.zzck((String) raw);
                }
                zzdb += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzuq) {
                    i2 = zzvh.zzd((zzuq) obj);
                } else {
                    i2 = zzvh.zzck((String) obj);
                }
                zzdb += i2;
                i4++;
            }
        }
        return zzdb;
    }

    static int zzc(int i, Object obj, zzya zzya) {
        if (obj instanceof zzwp) {
            return zzvh.zza(i, (zzwp) obj);
        }
        return zzvh.zzb(i, (zzxg) obj, zzya);
    }

    static int zzc(int i, List<?> list, zzya zzya) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzdb = zzvh.zzdb(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzwp) {
                i2 = zzvh.zza((zzwp) obj);
            } else {
                i2 = zzvh.zza((zzxg) obj, zzya);
            }
            zzdb += i2;
        }
        return zzdb;
    }

    static int zzd(int i, List<zzuq> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzdb = size * zzvh.zzdb(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzdb += zzvh.zzd(list.get(i2));
        }
        return zzdb;
    }

    static int zzd(int i, List<zzxg> list, zzya zzya) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzvh.zzc(i, list.get(i3), zzya);
        }
        return i2;
    }

    public static zzys<?, ?> zzvo() {
        return zzchd;
    }

    public static zzys<?, ?> zzvp() {
        return zzche;
    }

    public static zzys<?, ?> zzvq() {
        return zzchf;
    }

    private static zzys<?, ?> zzba(boolean z) {
        try {
            Class<?> zzvs = zzvs();
            if (zzvs == null) {
                return null;
            }
            return (zzys) zzvs.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzvr() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzvs() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzf(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzxd zzxd, Object obj, Object obj2, long j) {
        zzyy.zza(obj, j, zzxd.zzd(zzyy.zzp(obj, j), zzyy.zzp(obj2, j)));
    }

    static <T, FT extends zzvs<FT>> void zza(zzvm zzvm, Object obj, Object obj2) {
        zzvq zzo = zzvm.zzo(obj2);
        if (!zzo.zzcai.isEmpty()) {
            zzvm.zzp(obj).zza(zzo);
        }
    }

    static <T, UT, UB> void zza(zzys zzys, Object obj, Object obj2) {
        zzys.zzg(obj, zzys.zzi(zzys.zzae(obj), zzys.zzae(obj2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzwd zzwd, UB ub, zzys<UT, UB> zzys) {
        if (zzwd == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzwd.zzb(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zza(i, intValue, ub, zzys);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzwd.zzb(intValue2)) {
                    ub = zza(i, intValue2, ub, zzys);
                    it.remove();
                }
            }
        }
        return ub;
    }

    private static <UT, UB> UB zza(int i, int i2, Object obj, zzys zzys) {
        if (obj == null) {
            obj = zzys.zzwb();
        }
        zzys.zza(obj, i, (long) i2);
        return obj;
    }
}

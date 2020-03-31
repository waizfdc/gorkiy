package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
final class zzhf {
    private static final Class<?> zza = zzd();
    private static final zzhv<?, ?> zzb = zza(false);
    private static final zzhv<?, ?> zzc = zza(true);
    private static final zzhv<?, ?> zzd = new zzhx();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzfd.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzis zzis, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzis zzis, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzis zzis, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzis zzis, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzis zzis, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzis zzis, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzis zzis, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzis zzis, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzis zzis, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzis zzis, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzis zzis, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzis zzis, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzis zzis, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzis zzis, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzis zzis) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzdu> list, zzis zzis) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzis zzis, zzhd zzhd) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zza(i, list, zzhd);
        }
    }

    public static void zzb(int i, List<?> list, zzis zzis, zzhd zzhd) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzis.zzb(i, list, zzhd);
        }
    }

    static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgc) {
            zzgc zzgc = (zzgc) list;
            i = 0;
            while (i2 < size) {
                i += zzen.zzd(zzgc.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzen.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzen.zze(i));
    }

    static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgc) {
            zzgc zzgc = (zzgc) list;
            i = 0;
            while (i2 < size) {
                i += zzen.zze(zzgc.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzen.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzen.zze(i));
    }

    static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgc) {
            zzgc zzgc = (zzgc) list;
            i = 0;
            while (i2 < size) {
                i += zzen.zzf(zzgc.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzen.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzen.zze(i));
    }

    static int zzd(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfg) {
            zzfg zzfg = (zzfg) list;
            i = 0;
            while (i2 < size) {
                i += zzen.zzk(zzfg.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzen.zzk(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzen.zze(i));
    }

    static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfg) {
            zzfg zzfg = (zzfg) list;
            i = 0;
            while (i2 < size) {
                i += zzen.zzf(zzfg.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzen.zzf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzen.zze(i));
    }

    static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfg) {
            zzfg zzfg = (zzfg) list;
            i = 0;
            while (i2 < size) {
                i += zzen.zzg(zzfg.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzen.zzg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzen.zze(i));
    }

    static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfg) {
            zzfg zzfg = (zzfg) list;
            i = 0;
            while (i2 < size) {
                i += zzen.zzh(zzfg.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzen.zzh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzen.zze(i));
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzen.zzi(i, 0);
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzen.zzg(int, long):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.measurement.zzen.zzg(int, int):int
      com.google.android.gms.internal.measurement.zzen.zzg(int, long):int */
    static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzen.zzg(i, 0L);
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzen.zzb(int, boolean):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.measurement.zzen.zzb(int, double):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, float):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, com.google.android.gms.internal.measurement.zzft):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, com.google.android.gms.internal.measurement.zzgo):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, java.lang.String):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, int):void
      com.google.android.gms.internal.measurement.zzen.zzb(int, long):void
      com.google.android.gms.internal.measurement.zzen.zzb(int, com.google.android.gms.internal.measurement.zzdu):void
      com.google.android.gms.internal.measurement.zzen.zzb(int, boolean):int */
    static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzen.zzb(i, true);
    }

    static int zza(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zze = zzen.zze(i) * size;
        if (list instanceof zzfv) {
            zzfv zzfv = (zzfv) list;
            while (i4 < size) {
                Object zzb2 = zzfv.zzb(i4);
                if (zzb2 instanceof zzdu) {
                    i3 = zzen.zzb((zzdu) zzb2);
                } else {
                    i3 = zzen.zzb((String) zzb2);
                }
                zze += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzdu) {
                    i2 = zzen.zzb((zzdu) obj);
                } else {
                    i2 = zzen.zzb((String) obj);
                }
                zze += i2;
                i4++;
            }
        }
        return zze;
    }

    static int zza(int i, Object obj, zzhd zzhd) {
        if (obj instanceof zzft) {
            return zzen.zza(i, (zzft) obj);
        }
        return zzen.zzb(i, (zzgo) obj, zzhd);
    }

    static int zza(int i, List<?> list, zzhd zzhd) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzen.zze(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzft) {
                i2 = zzen.zza((zzft) obj);
            } else {
                i2 = zzen.zza((zzgo) obj, zzhd);
            }
            zze += i2;
        }
        return zze;
    }

    static int zzb(int i, List<zzdu> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = size * zzen.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzen.zzb(list.get(i2));
        }
        return zze;
    }

    static int zzb(int i, List<zzgo> list, zzhd zzhd) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzen.zzc(i, list.get(i3), zzhd);
        }
        return i2;
    }

    public static zzhv<?, ?> zza() {
        return zzb;
    }

    public static zzhv<?, ?> zzb() {
        return zzc;
    }

    public static zzhv<?, ?> zzc() {
        return zzd;
    }

    private static zzhv<?, ?> zza(boolean z) {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzhv) zze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzgh zzgh, Object obj, Object obj2, long j) {
        zzib.zza(obj, j, zzgh.zza(zzib.zzf(obj, j), zzib.zzf(obj2, j)));
    }

    static <T, FT extends zzey<FT>> void zza(zzes zzes, Object obj, Object obj2) {
        zzew zza2 = zzes.zza(obj2);
        if (!zza2.zza.isEmpty()) {
            zzes.zzb(obj).zza(zza2);
        }
    }

    static <T, UT, UB> void zza(zzhv zzhv, Object obj, Object obj2) {
        zzhv.zza(obj, zzhv.zzc(zzhv.zzb(obj), zzhv.zzb(obj2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzfk zzfk, UB ub, zzhv<UT, UB> zzhv) {
        if (zzfk == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzfk.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zza(i, intValue, ub, zzhv);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzfk.zza(intValue2)) {
                    ub = zza(i, intValue2, ub, zzhv);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(int i, int i2, Object obj, zzhv zzhv) {
        if (obj == null) {
            obj = zzhv.zza();
        }
        zzhv.zza(obj, i, (long) i2);
        return obj;
    }
}

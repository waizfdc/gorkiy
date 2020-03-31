package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzit {
    private static final Class<?> zzzr = zzhv();
    private static final zzjj<?, ?> zzzs = zzn(false);
    private static final zzjj<?, ?> zzzt = zzn(true);
    private static final zzjj<?, ?> zzzu = new zzjl();

    public static void zzg(Class<?> cls) {
        Class<?> cls2;
        if (!zzgs.class.isAssignableFrom(cls) && (cls2 = zzzr) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzkg zzkg, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzkg zzkg, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzkg zzkg, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzkg zzkg, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzkg zzkg, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzkg zzkg, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzkg zzkg, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzkg zzkg, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzkg zzkg, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzkg zzkg, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzkg zzkg, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzkg zzkg, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzkg zzkg, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzkg zzkg, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzkg zzkg) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzfh> list, zzkg zzkg) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzkg zzkg, zzir zzir) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zza(i, list, zzir);
        }
    }

    public static void zzb(int i, List<?> list, zzkg zzkg, zzir zzir) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzb(i, list, zzir);
        }
    }

    static int zzq(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            i = 0;
            while (i2 < size) {
                i += zzga.zzv(zzhq.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzga.zzv(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzq(list) + (list.size() * zzga.zzba(i));
    }

    static int zzr(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            i = 0;
            while (i2 < size) {
                i += zzga.zzw(zzhq.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzga.zzw(list.get(i2).longValue());
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
        return zzr(list) + (size * zzga.zzba(i));
    }

    static int zzs(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            i = 0;
            while (i2 < size) {
                i += zzga.zzx(zzhq.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzga.zzx(list.get(i2).longValue());
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
        return zzs(list) + (size * zzga.zzba(i));
    }

    static int zzt(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            i = 0;
            while (i2 < size) {
                i += zzga.zzbg(zzgu.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzga.zzbg(list.get(i2).intValue());
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
        return zzt(list) + (size * zzga.zzba(i));
    }

    static int zzu(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            i = 0;
            while (i2 < size) {
                i += zzga.zzbb(zzgu.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzga.zzbb(list.get(i2).intValue());
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
        return zzu(list) + (size * zzga.zzba(i));
    }

    static int zzv(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            i = 0;
            while (i2 < size) {
                i += zzga.zzbc(zzgu.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzga.zzbc(list.get(i2).intValue());
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
        return zzv(list) + (size * zzga.zzba(i));
    }

    static int zzw(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            i = 0;
            while (i2 < size) {
                i += zzga.zzbd(zzgu.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzga.zzbd(list.get(i2).intValue());
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
        return zzw(list) + (size * zzga.zzba(i));
    }

    static int zzx(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzga.zzo(i, 0);
    }

    static int zzy(List<?> list) {
        return list.size() << 3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzga.zzg(int, long):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.vision.zzga.zzg(int, int):void
      com.google.android.gms.internal.vision.zzga.zzg(int, long):int */
    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzga.zzg(i, 0L);
    }

    static int zzz(List<?> list) {
        return list.size();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzga.zzb(int, boolean):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.vision.zzga.zzb(int, double):int
      com.google.android.gms.internal.vision.zzga.zzb(int, float):int
      com.google.android.gms.internal.vision.zzga.zzb(int, com.google.android.gms.internal.vision.zzhh):int
      com.google.android.gms.internal.vision.zzga.zzb(int, com.google.android.gms.internal.vision.zzic):int
      com.google.android.gms.internal.vision.zzga.zzb(int, java.lang.String):int
      com.google.android.gms.internal.vision.zzga.zzb(int, long):void
      com.google.android.gms.internal.vision.zzga.zzb(int, com.google.android.gms.internal.vision.zzfh):void
      com.google.android.gms.internal.vision.zzga.zzb(int, boolean):int */
    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzga.zzb(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzba = zzga.zzba(i) * size;
        if (list instanceof zzhj) {
            zzhj zzhj = (zzhj) list;
            while (i4 < size) {
                Object raw = zzhj.getRaw(i4);
                if (raw instanceof zzfh) {
                    i3 = zzga.zzb((zzfh) raw);
                } else {
                    i3 = zzga.zzy((String) raw);
                }
                zzba += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzfh) {
                    i2 = zzga.zzb((zzfh) obj);
                } else {
                    i2 = zzga.zzy((String) obj);
                }
                zzba += i2;
                i4++;
            }
        }
        return zzba;
    }

    static int zzc(int i, Object obj, zzir zzir) {
        if (obj instanceof zzhh) {
            return zzga.zza(i, (zzhh) obj);
        }
        return zzga.zzb(i, (zzic) obj, zzir);
    }

    static int zzc(int i, List<?> list, zzir zzir) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzba = zzga.zzba(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzhh) {
                i2 = zzga.zza((zzhh) obj);
            } else {
                i2 = zzga.zza((zzic) obj, zzir);
            }
            zzba += i2;
        }
        return zzba;
    }

    static int zzd(int i, List<zzfh> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzba = size * zzga.zzba(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzba += zzga.zzb(list.get(i2));
        }
        return zzba;
    }

    static int zzd(int i, List<zzic> list, zzir zzir) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzga.zzc(i, list.get(i3), zzir);
        }
        return i2;
    }

    public static zzjj<?, ?> zzhs() {
        return zzzs;
    }

    public static zzjj<?, ?> zzht() {
        return zzzt;
    }

    public static zzjj<?, ?> zzhu() {
        return zzzu;
    }

    private static zzjj<?, ?> zzn(boolean z) {
        try {
            Class<?> zzhw = zzhw();
            if (zzhw == null) {
                return null;
            }
            return (zzjj) zzhw.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzhv() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzhw() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zze(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzhv zzhv, Object obj, Object obj2, long j) {
        zzjp.zza(obj, j, zzhv.zzc(zzjp.zzp(obj, j), zzjp.zzp(obj2, j)));
    }

    static <T, FT extends zzgk<FT>> void zza(zzgf zzgf, Object obj, Object obj2) {
        zzgi zze = zzgf.zze(obj2);
        if (!zze.zztb.isEmpty()) {
            zzgf.zzf(obj).zza(zze);
        }
    }

    static <T, UT, UB> void zza(zzjj zzjj, Object obj, Object obj2) {
        zzjj.zzf(obj, zzjj.zzh(zzjj.zzv(obj), zzjj.zzv(obj2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzgv<?> zzgv, Object obj, zzjj zzjj) {
        if (zzgv == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzgv.zzg(intValue) != null) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj = zza(i, intValue, obj, zzjj);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (zzgv.zzg(intValue2) == null) {
                    obj = zza(i, intValue2, obj, zzjj);
                    it.remove();
                }
            }
        }
        return obj;
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzgy zzgy, Object obj, zzjj zzjj) {
        if (zzgy == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzgy.zzf(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj = zza(i, intValue, obj, zzjj);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzgy.zzf(intValue2)) {
                    obj = zza(i, intValue2, obj, zzjj);
                    it.remove();
                }
            }
        }
        return obj;
    }

    static <UT, UB> UB zza(int i, int i2, Object obj, zzjj zzjj) {
        if (obj == null) {
            obj = zzjj.zzif();
        }
        zzjj.zza(obj, i, (long) i2);
        return obj;
    }
}

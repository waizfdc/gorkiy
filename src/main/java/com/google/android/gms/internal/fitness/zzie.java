package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzie {
    private static final Class<?> zzyq = zzcy();
    private static final zziu<?, ?> zzyr = zzd(false);
    private static final zziu<?, ?> zzys = zzd(true);
    private static final zziu<?, ?> zzyt = new zziw();

    public static void zzf(Class<?> cls) {
        Class<?> cls2;
        if (!zzgg.class.isAssignableFrom(cls) && (cls2 = zzyq) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzjo zzjo) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzff> list, zzjo zzjo) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzjo zzjo, zzic zzic) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zza(i, list, zzic);
        }
    }

    public static void zzb(int i, List<?> list, zzjo zzjo, zzic zzic) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzb(i, list, zzic);
        }
    }

    static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhc) {
            zzhc zzhc = (zzhc) list;
            i = 0;
            while (i2 < size) {
                i += zzfs.zzd(zzhc.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfs.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzb(list) + (list.size() * zzfs.zzp(i));
    }

    static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhc) {
            zzhc zzhc = (zzhc) list;
            i = 0;
            while (i2 < size) {
                i += zzfs.zze(zzhc.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfs.zze(list.get(i2).longValue());
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
        return zzc(list) + (size * zzfs.zzp(i));
    }

    static int zzd(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhc) {
            zzhc zzhc = (zzhc) list;
            i = 0;
            while (i2 < size) {
                i += zzfs.zzf(zzhc.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfs.zzf(list.get(i2).longValue());
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
        return zzd(list) + (size * zzfs.zzp(i));
    }

    static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgi) {
            zzgi zzgi = (zzgi) list;
            i = 0;
            while (i2 < size) {
                i += zzfs.zzv(zzgi.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfs.zzv(list.get(i2).intValue());
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
        return zze(list) + (size * zzfs.zzp(i));
    }

    static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgi) {
            zzgi zzgi = (zzgi) list;
            i = 0;
            while (i2 < size) {
                i += zzfs.zzq(zzgi.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfs.zzq(list.get(i2).intValue());
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
        return zzf(list) + (size * zzfs.zzp(i));
    }

    static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgi) {
            zzgi zzgi = (zzgi) list;
            i = 0;
            while (i2 < size) {
                i += zzfs.zzr(zzgi.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfs.zzr(list.get(i2).intValue());
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
        return zzg(list) + (size * zzfs.zzp(i));
    }

    static int zzh(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgi) {
            zzgi zzgi = (zzgi) list;
            i = 0;
            while (i2 < size) {
                i += zzfs.zzs(zzgi.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfs.zzs(list.get(i2).intValue());
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
        return zzh(list) + (size * zzfs.zzp(i));
    }

    static int zzi(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfs.zzj(i, 0);
    }

    static int zzj(List<?> list) {
        return list.size() << 3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzfs.zzg(int, long):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.fitness.zzfs.zzg(int, int):int
      com.google.android.gms.internal.fitness.zzfs.zzg(int, long):int */
    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfs.zzg(i, 0L);
    }

    static int zzk(List<?> list) {
        return list.size();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzfs.zzb(int, boolean):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.fitness.zzfs.zzb(int, double):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, float):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, com.google.android.gms.internal.fitness.zzgt):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, com.google.android.gms.internal.fitness.zzho):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, java.lang.String):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, int):void
      com.google.android.gms.internal.fitness.zzfs.zzb(int, long):void
      com.google.android.gms.internal.fitness.zzfs.zzb(int, com.google.android.gms.internal.fitness.zzff):void
      com.google.android.gms.internal.fitness.zzfs.zzb(int, boolean):int */
    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfs.zzb(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzp = zzfs.zzp(i) * size;
        if (list instanceof zzgv) {
            zzgv zzgv = (zzgv) list;
            while (i4 < size) {
                Object zzad = zzgv.zzad(i4);
                if (zzad instanceof zzff) {
                    i3 = zzfs.zzb((zzff) zzad);
                } else {
                    i3 = zzfs.zzn((String) zzad);
                }
                zzp += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzff) {
                    i2 = zzfs.zzb((zzff) obj);
                } else {
                    i2 = zzfs.zzn((String) obj);
                }
                zzp += i2;
                i4++;
            }
        }
        return zzp;
    }

    static int zzc(int i, Object obj, zzic zzic) {
        if (obj instanceof zzgt) {
            return zzfs.zza(i, (zzgt) obj);
        }
        return zzfs.zzb(i, (zzho) obj, zzic);
    }

    static int zzc(int i, List<?> list, zzic zzic) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzp = zzfs.zzp(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzgt) {
                i2 = zzfs.zza((zzgt) obj);
            } else {
                i2 = zzfs.zza((zzho) obj, zzic);
            }
            zzp += i2;
        }
        return zzp;
    }

    static int zzd(int i, List<zzff> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzp = size * zzfs.zzp(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzp += zzfs.zzb(list.get(i2));
        }
        return zzp;
    }

    static int zzd(int i, List<zzho> list, zzic zzic) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzfs.zzc(i, list.get(i3), zzic);
        }
        return i2;
    }

    public static zziu<?, ?> zzcv() {
        return zzyr;
    }

    public static zziu<?, ?> zzcw() {
        return zzys;
    }

    public static zziu<?, ?> zzcx() {
        return zzyt;
    }

    private static zziu<?, ?> zzd(boolean z) {
        try {
            Class<?> zzcz = zzcz();
            if (zzcz == null) {
                return null;
            }
            return (zziu) zzcz.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzcy() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzcz() {
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

    static <T> void zza(zzhh zzhh, Object obj, Object obj2, long j) {
        zzja.zza(obj, j, zzhh.zzc(zzja.zzo(obj, j), zzja.zzo(obj2, j)));
    }

    static <T, FT extends zzgd<FT>> void zza(zzfw zzfw, Object obj, Object obj2) {
        zzgb zza = zzfw.zza(obj2);
        if (!zza.zzsj.isEmpty()) {
            zzfw.zzb(obj).zza(zza);
        }
    }

    static <T, UT, UB> void zza(zziu zziu, Object obj, Object obj2) {
        zziu.zzf(obj, zziu.zzg(zziu.zzm(obj), zziu.zzm(obj2)));
    }
}

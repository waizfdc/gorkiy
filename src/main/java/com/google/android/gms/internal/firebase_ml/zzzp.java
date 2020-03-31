package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
interface zzzp {
    void zza(int i, double d) throws IOException;

    void zza(int i, float f) throws IOException;

    void zza(int i, long j) throws IOException;

    void zza(int i, zzuq zzuq) throws IOException;

    <K, V> void zza(int i, zzxb zzxb, Map map) throws IOException;

    void zza(int i, Object obj) throws IOException;

    void zza(int i, Object obj, zzya zzya) throws IOException;

    void zza(int i, List<String> list) throws IOException;

    void zza(int i, List<?> list, zzya zzya) throws IOException;

    void zza(int i, List<Integer> list, boolean z) throws IOException;

    void zza(int i, boolean z) throws IOException;

    void zzb(int i, long j) throws IOException;

    @Deprecated
    void zzb(int i, Object obj, zzya zzya) throws IOException;

    void zzb(int i, String str) throws IOException;

    void zzb(int i, List<zzuq> list) throws IOException;

    @Deprecated
    void zzb(int i, List<?> list, zzya zzya) throws IOException;

    void zzb(int i, List<Integer> list, boolean z) throws IOException;

    void zzc(int i, long j) throws IOException;

    void zzc(int i, List<Long> list, boolean z) throws IOException;

    void zzd(int i, List<Long> list, boolean z) throws IOException;

    @Deprecated
    void zzdl(int i) throws IOException;

    @Deprecated
    void zzdm(int i) throws IOException;

    void zze(int i, List<Long> list, boolean z) throws IOException;

    void zzf(int i, List<Float> list, boolean z) throws IOException;

    void zzg(int i, List<Double> list, boolean z) throws IOException;

    void zzh(int i, List<Integer> list, boolean z) throws IOException;

    void zzi(int i, int i2) throws IOException;

    void zzi(int i, long j) throws IOException;

    void zzi(int i, List<Boolean> list, boolean z) throws IOException;

    void zzj(int i, int i2) throws IOException;

    void zzj(int i, long j) throws IOException;

    void zzj(int i, List<Integer> list, boolean z) throws IOException;

    void zzk(int i, int i2) throws IOException;

    void zzk(int i, List<Integer> list, boolean z) throws IOException;

    void zzl(int i, int i2) throws IOException;

    void zzl(int i, List<Long> list, boolean z) throws IOException;

    void zzm(int i, List<Integer> list, boolean z) throws IOException;

    void zzn(int i, List<Long> list, boolean z) throws IOException;

    void zzs(int i, int i2) throws IOException;

    void zzt(int i, int i2) throws IOException;

    int zztg();
}

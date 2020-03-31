package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
interface zzis {
    int getTag();

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    String readString() throws IOException;

    void readStringList(List<String> list) throws IOException;

    <T> T zza(zzir zzir, zzgd zzgd) throws IOException;

    <T> T zza(Class cls, zzgd zzgd) throws IOException;

    void zza(List<Double> list) throws IOException;

    <T> void zza(List list, zzir zzir, zzgd zzgd) throws IOException;

    <K, V> void zza(Map map, zzht zzht, zzgd zzgd) throws IOException;

    @Deprecated
    <T> T zzb(Class<T> cls, zzgd zzgd) throws IOException;

    void zzb(List<Float> list) throws IOException;

    @Deprecated
    <T> void zzb(List<T> list, zzir<T> zzir, zzgd zzgd) throws IOException;

    @Deprecated
    <T> T zzc(zzir<T> zzir, zzgd zzgd) throws IOException;

    void zzc(List<Long> list) throws IOException;

    void zzd(List<Long> list) throws IOException;

    int zzdu() throws IOException;

    boolean zzdv() throws IOException;

    long zzdw() throws IOException;

    long zzdx() throws IOException;

    int zzdy() throws IOException;

    long zzdz() throws IOException;

    void zze(List<Integer> list) throws IOException;

    int zzea() throws IOException;

    boolean zzeb() throws IOException;

    String zzec() throws IOException;

    zzfh zzed() throws IOException;

    int zzee() throws IOException;

    int zzef() throws IOException;

    int zzeg() throws IOException;

    long zzeh() throws IOException;

    int zzei() throws IOException;

    long zzej() throws IOException;

    void zzf(List<Long> list) throws IOException;

    void zzg(List<Integer> list) throws IOException;

    void zzh(List<Boolean> list) throws IOException;

    void zzi(List<String> list) throws IOException;

    void zzj(List<zzfh> list) throws IOException;

    void zzk(List<Integer> list) throws IOException;

    void zzl(List<Integer> list) throws IOException;

    void zzm(List<Integer> list) throws IOException;

    void zzn(List<Long> list) throws IOException;

    void zzo(List<Integer> list) throws IOException;

    void zzp(List<Long> list) throws IOException;
}

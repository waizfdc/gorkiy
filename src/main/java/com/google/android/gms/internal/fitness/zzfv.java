package com.google.android.gms.internal.fitness;

import com.google.android.gms.internal.fitness.zzgg;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzfv implements zzjo {
    private final zzfs zzro;

    public static zzfv zza(zzfs zzfs) {
        if (zzfs.zzru != null) {
            return zzfs.zzru;
        }
        return new zzfv(zzfs);
    }

    private zzfv(zzfs zzfs) {
        zzfs zzfs2 = (zzfs) zzgk.zza(zzfs, "output");
        this.zzro = zzfs2;
        zzfs2.zzru = this;
    }

    public final int zzay() {
        return zzgg.zze.zzvw;
    }

    public final void zzm(int i, int i2) throws IOException {
        this.zzro.zzf(i, i2);
    }

    public final void zzi(int i, long j) throws IOException {
        this.zzro.zza(i, j);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zzro.zzc(i, j);
    }

    public final void zza(int i, float f) throws IOException {
        this.zzro.zza(i, f);
    }

    public final void zza(int i, double d) throws IOException {
        this.zzro.zza(i, d);
    }

    public final void zzn(int i, int i2) throws IOException {
        this.zzro.zzc(i, i2);
    }

    public final void zza(int i, long j) throws IOException {
        this.zzro.zza(i, j);
    }

    public final void zzc(int i, int i2) throws IOException {
        this.zzro.zzc(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zzro.zzc(i, j);
    }

    public final void zzf(int i, int i2) throws IOException {
        this.zzro.zzf(i, i2);
    }

    public final void zza(int i, boolean z) throws IOException {
        this.zzro.zza(i, z);
    }

    public final void zza(int i, String str) throws IOException {
        this.zzro.zza(i, str);
    }

    public final void zza(int i, zzff zzff) throws IOException {
        this.zzro.zza(i, zzff);
    }

    public final void zzd(int i, int i2) throws IOException {
        this.zzro.zzd(i, i2);
    }

    public final void zze(int i, int i2) throws IOException {
        this.zzro.zze(i, i2);
    }

    public final void zzb(int i, long j) throws IOException {
        this.zzro.zzb(i, j);
    }

    public final void zza(int i, Object obj, zzic zzic) throws IOException {
        this.zzro.zza(i, (zzho) obj, zzic);
    }

    public final void zzb(int i, Object obj, zzic zzic) throws IOException {
        zzfs zzfs = this.zzro;
        zzfs.zzb(i, 3);
        zzic.zza((zzho) obj, zzfs.zzru);
        zzfs.zzb(i, 4);
    }

    public final void zzy(int i) throws IOException {
        this.zzro.zzb(i, 3);
    }

    public final void zzz(int i) throws IOException {
        this.zzro.zzb(i, 4);
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzff) {
            this.zzro.zzb(i, (zzff) obj);
        } else {
            this.zzro.zza(i, (zzho) obj);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzro.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfs.zzq(list.get(i4).intValue());
            }
            this.zzro.zzm(i3);
            while (i2 < list.size()) {
                this.zzro.zzl(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzro.zzc(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzro.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfs.zzt(list.get(i4).intValue());
            }
            this.zzro.zzm(i3);
            while (i2 < list.size()) {
                this.zzro.zzo(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzro.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzro.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfs.zzd(list.get(i4).longValue());
            }
            this.zzro.zzm(i3);
            while (i2 < list.size()) {
                this.zzro.zza(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzro.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzro.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfs.zze(list.get(i4).longValue());
            }
            this.zzro.zzm(i3);
            while (i2 < list.size()) {
                this.zzro.zza(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzro.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzro.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfs.zzg(list.get(i4).longValue());
            }
            this.zzro.zzm(i3);
            while (i2 < list.size()) {
                this.zzro.zzc(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzro.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzro.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfs.zzc(list.get(i4).floatValue());
            }
            this.zzro.zzm(i3);
            while (i2 < list.size()) {
                this.zzro.zzb(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzro.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzro.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfs.zzc(list.get(i4).doubleValue());
            }
            this.zzro.zzm(i3);
            while (i2 < list.size()) {
                this.zzro.zzb(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzro.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzro.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfs.zzv(list.get(i4).intValue());
            }
            this.zzro.zzm(i3);
            while (i2 < list.size()) {
                this.zzro.zzl(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzro.zzc(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzro.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfs.zzb(list.get(i4).booleanValue());
            }
            this.zzro.zzm(i3);
            while (i2 < list.size()) {
                this.zzro.zza(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzro.zza(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzgv) {
            zzgv zzgv = (zzgv) list;
            while (i2 < list.size()) {
                Object zzad = zzgv.zzad(i2);
                if (zzad instanceof String) {
                    this.zzro.zza(i, (String) zzad);
                } else {
                    this.zzro.zza(i, (zzff) zzad);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzro.zza(i, list.get(i2));
            i2++;
        }
    }

    public final void zzb(int i, List<zzff> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzro.zza(i, list.get(i2));
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzro.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfs.zzr(list.get(i4).intValue());
            }
            this.zzro.zzm(i3);
            while (i2 < list.size()) {
                this.zzro.zzm(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzro.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzro.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfs.zzu(list.get(i4).intValue());
            }
            this.zzro.zzm(i3);
            while (i2 < list.size()) {
                this.zzro.zzo(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzro.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzro.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfs.zzh(list.get(i4).longValue());
            }
            this.zzro.zzm(i3);
            while (i2 < list.size()) {
                this.zzro.zzc(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzro.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzro.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfs.zzs(list.get(i4).intValue());
            }
            this.zzro.zzm(i3);
            while (i2 < list.size()) {
                this.zzro.zzn(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzro.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzro.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfs.zzf(list.get(i4).longValue());
            }
            this.zzro.zzm(i3);
            while (i2 < list.size()) {
                this.zzro.zzb(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzro.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzic zzic) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzic);
        }
    }

    public final void zzb(int i, List<?> list, zzic zzic) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzic);
        }
    }

    public final <K, V> void zza(int i, zzhf<K, V> zzhf, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zzro.zzb(i, 2);
            this.zzro.zzm(zzgb.zza(zzhf.zzxh, 1, next.getKey()) + zzgb.zza(zzhf.zzxi, 2, next.getValue()));
            zzfs zzfs = this.zzro;
            Object key = next.getKey();
            Object value = next.getValue();
            zzgb.zza(zzfs, zzhf.zzxh, 1, key);
            zzgb.zza(zzfs, zzhf.zzxi, 2, value);
        }
    }
}

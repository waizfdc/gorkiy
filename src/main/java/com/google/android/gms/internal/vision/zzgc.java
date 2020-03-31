package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzgc implements zzkg {
    private final zzga zzsd;

    public static zzgc zza(zzga zzga) {
        if (zzga.zzss != null) {
            return zzga.zzss;
        }
        return new zzgc(zzga);
    }

    private zzgc(zzga zzga) {
        zzga zzga2 = (zzga) zzgt.zza(zzga, "output");
        this.zzsd = zzga2;
        zzga2.zzss = this;
    }

    public final int zzfj() {
        return zzgs.zzf.zzww;
    }

    public final void zzr(int i, int i2) throws IOException {
        this.zzsd.zzk(i, i2);
    }

    public final void zzi(int i, long j) throws IOException {
        this.zzsd.zza(i, j);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zzsd.zzc(i, j);
    }

    public final void zza(int i, float f) throws IOException {
        this.zzsd.zza(i, f);
    }

    public final void zza(int i, double d) throws IOException {
        this.zzsd.zza(i, d);
    }

    public final void zzs(int i, int i2) throws IOException {
        this.zzsd.zzh(i, i2);
    }

    public final void zza(int i, long j) throws IOException {
        this.zzsd.zza(i, j);
    }

    public final void zzh(int i, int i2) throws IOException {
        this.zzsd.zzh(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zzsd.zzc(i, j);
    }

    public final void zzk(int i, int i2) throws IOException {
        this.zzsd.zzk(i, i2);
    }

    public final void zza(int i, boolean z) throws IOException {
        this.zzsd.zza(i, z);
    }

    public final void zza(int i, String str) throws IOException {
        this.zzsd.zza(i, str);
    }

    public final void zza(int i, zzfh zzfh) throws IOException {
        this.zzsd.zza(i, zzfh);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zzsd.zzi(i, i2);
    }

    public final void zzj(int i, int i2) throws IOException {
        this.zzsd.zzj(i, i2);
    }

    public final void zzb(int i, long j) throws IOException {
        this.zzsd.zzb(i, j);
    }

    public final void zza(int i, Object obj, zzir zzir) throws IOException {
        this.zzsd.zza(i, (zzic) obj, zzir);
    }

    public final void zzb(int i, Object obj, zzir zzir) throws IOException {
        zzga zzga = this.zzsd;
        zzga.zzg(i, 3);
        zzir.zza((zzic) obj, zzga.zzss);
        zzga.zzg(i, 4);
    }

    public final void zzbj(int i) throws IOException {
        this.zzsd.zzg(i, 3);
    }

    public final void zzbk(int i) throws IOException {
        this.zzsd.zzg(i, 4);
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzfh) {
            this.zzsd.zzb(i, (zzfh) obj);
        } else {
            this.zzsd.zza(i, (zzic) obj);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzg(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzga.zzbb(list.get(i4).intValue());
            }
            this.zzsd.zzax(i3);
            while (i2 < list.size()) {
                this.zzsd.zzaw(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzg(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzga.zzbe(list.get(i4).intValue());
            }
            this.zzsd.zzax(i3);
            while (i2 < list.size()) {
                this.zzsd.zzaz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zzk(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzg(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzga.zzv(list.get(i4).longValue());
            }
            this.zzsd.zzax(i3);
            while (i2 < list.size()) {
                this.zzsd.zzs(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzg(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzga.zzw(list.get(i4).longValue());
            }
            this.zzsd.zzax(i3);
            while (i2 < list.size()) {
                this.zzsd.zzs(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzg(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzga.zzy(list.get(i4).longValue());
            }
            this.zzsd.zzax(i3);
            while (i2 < list.size()) {
                this.zzsd.zzu(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzg(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzga.zzt(list.get(i4).floatValue());
            }
            this.zzsd.zzax(i3);
            while (i2 < list.size()) {
                this.zzsd.zzs(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzg(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzga.zzb(list.get(i4).doubleValue());
            }
            this.zzsd.zzax(i3);
            while (i2 < list.size()) {
                this.zzsd.zza(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzg(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzga.zzbg(list.get(i4).intValue());
            }
            this.zzsd.zzax(i3);
            while (i2 < list.size()) {
                this.zzsd.zzaw(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzg(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzga.zzl(list.get(i4).booleanValue());
            }
            this.zzsd.zzax(i3);
            while (i2 < list.size()) {
                this.zzsd.zzk(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zza(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzhj) {
            zzhj zzhj = (zzhj) list;
            while (i2 < list.size()) {
                Object raw = zzhj.getRaw(i2);
                if (raw instanceof String) {
                    this.zzsd.zza(i, (String) raw);
                } else {
                    this.zzsd.zza(i, (zzfh) raw);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zza(i, list.get(i2));
            i2++;
        }
    }

    public final void zzb(int i, List<zzfh> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzsd.zza(i, list.get(i2));
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzg(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzga.zzbc(list.get(i4).intValue());
            }
            this.zzsd.zzax(i3);
            while (i2 < list.size()) {
                this.zzsd.zzax(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zzi(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzg(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzga.zzbf(list.get(i4).intValue());
            }
            this.zzsd.zzax(i3);
            while (i2 < list.size()) {
                this.zzsd.zzaz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zzk(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzg(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzga.zzz(list.get(i4).longValue());
            }
            this.zzsd.zzax(i3);
            while (i2 < list.size()) {
                this.zzsd.zzu(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzg(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzga.zzbd(list.get(i4).intValue());
            }
            this.zzsd.zzax(i3);
            while (i2 < list.size()) {
                this.zzsd.zzay(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zzj(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzg(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzga.zzx(list.get(i4).longValue());
            }
            this.zzsd.zzax(i3);
            while (i2 < list.size()) {
                this.zzsd.zzt(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzir zzir) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzir);
        }
    }

    public final void zzb(int i, List<?> list, zzir zzir) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzir);
        }
    }

    public final <K, V> void zza(int i, zzht<K, V> zzht, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zzsd.zzg(i, 2);
            this.zzsd.zzax(zzhu.zza(zzht, next.getKey(), next.getValue()));
            zzhu.zza(this.zzsd, zzht, next.getKey(), next.getValue());
        }
    }
}

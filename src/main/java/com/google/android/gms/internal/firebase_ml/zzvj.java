package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zzvx;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzvj implements zzzp {
    private final zzvh zzbzn;

    public static zzvj zza(zzvh zzvh) {
        if (zzvh.zzbzw != null) {
            return zzvh.zzbzw;
        }
        return new zzvj(zzvh);
    }

    private zzvj(zzvh zzvh) {
        zzvh zzvh2 = (zzvh) zzvy.zza(zzvh, "output");
        this.zzbzn = zzvh2;
        zzvh2.zzbzw = this;
    }

    public final int zztg() {
        return zzvx.zzf.zzcdv;
    }

    public final void zzs(int i, int i2) throws IOException {
        this.zzbzn.zzl(i, i2);
    }

    public final void zzi(int i, long j) throws IOException {
        this.zzbzn.zza(i, j);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zzbzn.zzc(i, j);
    }

    public final void zza(int i, float f) throws IOException {
        this.zzbzn.zza(i, f);
    }

    public final void zza(int i, double d) throws IOException {
        this.zzbzn.zza(i, d);
    }

    public final void zzt(int i, int i2) throws IOException {
        this.zzbzn.zzi(i, i2);
    }

    public final void zza(int i, long j) throws IOException {
        this.zzbzn.zza(i, j);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zzbzn.zzi(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zzbzn.zzc(i, j);
    }

    public final void zzl(int i, int i2) throws IOException {
        this.zzbzn.zzl(i, i2);
    }

    public final void zza(int i, boolean z) throws IOException {
        this.zzbzn.zza(i, z);
    }

    public final void zzb(int i, String str) throws IOException {
        this.zzbzn.zzb(i, str);
    }

    public final void zza(int i, zzuq zzuq) throws IOException {
        this.zzbzn.zza(i, zzuq);
    }

    public final void zzj(int i, int i2) throws IOException {
        this.zzbzn.zzj(i, i2);
    }

    public final void zzk(int i, int i2) throws IOException {
        this.zzbzn.zzk(i, i2);
    }

    public final void zzb(int i, long j) throws IOException {
        this.zzbzn.zzb(i, j);
    }

    public final void zza(int i, Object obj, zzya zzya) throws IOException {
        this.zzbzn.zza(i, (zzxg) obj, zzya);
    }

    public final void zzb(int i, Object obj, zzya zzya) throws IOException {
        zzvh zzvh = this.zzbzn;
        zzvh.zzh(i, 3);
        zzya.zza((zzxg) obj, zzvh.zzbzw);
        zzvh.zzh(i, 4);
    }

    public final void zzdl(int i) throws IOException {
        this.zzbzn.zzh(i, 3);
    }

    public final void zzdm(int i) throws IOException {
        this.zzbzn.zzh(i, 4);
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzuq) {
            this.zzbzn.zzb(i, (zzuq) obj);
        } else {
            this.zzbzn.zza(i, (zzxg) obj);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbzn.zzh(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzvh.zzdc(list.get(i4).intValue());
            }
            this.zzbzn.zzcy(i3);
            while (i2 < list.size()) {
                this.zzbzn.zzcx(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbzn.zzi(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbzn.zzh(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzvh.zzdf(list.get(i4).intValue());
            }
            this.zzbzn.zzcy(i3);
            while (i2 < list.size()) {
                this.zzbzn.zzda(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbzn.zzl(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbzn.zzh(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzvh.zzz(list.get(i4).longValue());
            }
            this.zzbzn.zzcy(i3);
            while (i2 < list.size()) {
                this.zzbzn.zzw(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbzn.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbzn.zzh(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzvh.zzaa(list.get(i4).longValue());
            }
            this.zzbzn.zzcy(i3);
            while (i2 < list.size()) {
                this.zzbzn.zzw(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbzn.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbzn.zzh(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzvh.zzac(list.get(i4).longValue());
            }
            this.zzbzn.zzcy(i3);
            while (i2 < list.size()) {
                this.zzbzn.zzy(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbzn.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbzn.zzh(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzvh.zzr(list.get(i4).floatValue());
            }
            this.zzbzn.zzcy(i3);
            while (i2 < list.size()) {
                this.zzbzn.zzq(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbzn.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbzn.zzh(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzvh.zzd(list.get(i4).doubleValue());
            }
            this.zzbzn.zzcy(i3);
            while (i2 < list.size()) {
                this.zzbzn.zzc(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbzn.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbzn.zzh(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzvh.zzdh(list.get(i4).intValue());
            }
            this.zzbzn.zzcy(i3);
            while (i2 < list.size()) {
                this.zzbzn.zzcx(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbzn.zzi(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbzn.zzh(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzvh.zzay(list.get(i4).booleanValue());
            }
            this.zzbzn.zzcy(i3);
            while (i2 < list.size()) {
                this.zzbzn.zzax(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbzn.zza(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzwr) {
            zzwr zzwr = (zzwr) list;
            while (i2 < list.size()) {
                Object raw = zzwr.getRaw(i2);
                if (raw instanceof String) {
                    this.zzbzn.zzb(i, (String) raw);
                } else {
                    this.zzbzn.zza(i, (zzuq) raw);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbzn.zzb(i, list.get(i2));
            i2++;
        }
    }

    public final void zzb(int i, List<zzuq> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzbzn.zza(i, list.get(i2));
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbzn.zzh(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzvh.zzdd(list.get(i4).intValue());
            }
            this.zzbzn.zzcy(i3);
            while (i2 < list.size()) {
                this.zzbzn.zzcy(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbzn.zzj(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbzn.zzh(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzvh.zzdg(list.get(i4).intValue());
            }
            this.zzbzn.zzcy(i3);
            while (i2 < list.size()) {
                this.zzbzn.zzda(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbzn.zzl(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbzn.zzh(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzvh.zzad(list.get(i4).longValue());
            }
            this.zzbzn.zzcy(i3);
            while (i2 < list.size()) {
                this.zzbzn.zzy(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbzn.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbzn.zzh(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzvh.zzde(list.get(i4).intValue());
            }
            this.zzbzn.zzcy(i3);
            while (i2 < list.size()) {
                this.zzbzn.zzcz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbzn.zzk(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbzn.zzh(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzvh.zzab(list.get(i4).longValue());
            }
            this.zzbzn.zzcy(i3);
            while (i2 < list.size()) {
                this.zzbzn.zzx(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbzn.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzya zzya) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzya);
        }
    }

    public final void zzb(int i, List<?> list, zzya zzya) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzya);
        }
    }

    public final <K, V> void zza(int i, zzxb<K, V> zzxb, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zzbzn.zzh(i, 2);
            this.zzbzn.zzcy(zzwy.zza(zzxb, next.getKey(), next.getValue()));
            zzwy.zza(this.zzbzn, zzxb, next.getKey(), next.getValue());
        }
    }
}

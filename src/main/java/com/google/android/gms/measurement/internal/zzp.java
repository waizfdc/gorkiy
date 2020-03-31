package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzmv;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzp {
    private String zza;
    private boolean zzb;
    private zzbr.zzi zzc;
    /* access modifiers changed from: private */
    public BitSet zzd;
    private BitSet zze;
    private Map<Integer, Long> zzf;
    private Map<Integer, List<Long>> zzg;
    private final /* synthetic */ zzn zzh;

    private zzp(zzn zzn, String str) {
        this.zzh = zzn;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
    }

    private zzp(zzn zzn, String str, zzbr.zzi zzi, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.zzh = zzn;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new ArrayMap();
        if (map2 != null) {
            for (Integer next : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(next));
                this.zzg.put(next, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zzi;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzu zzu) {
        int zza2 = zzu.zza();
        if (zzu.zzc != null) {
            this.zze.set(zza2, zzu.zzc.booleanValue());
        }
        if (zzu.zzd != null) {
            this.zzd.set(zza2, zzu.zzd.booleanValue());
        }
        if (zzu.zze != null) {
            Long l = this.zzf.get(Integer.valueOf(zza2));
            long longValue = zzu.zze.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.zzf.put(Integer.valueOf(zza2), Long.valueOf(longValue));
            }
        }
        if (zzu.zzf != null) {
            List list = this.zzg.get(Integer.valueOf(zza2));
            if (list == null) {
                list = new ArrayList();
                this.zzg.put(Integer.valueOf(zza2), list);
            }
            if (zzmv.zzb() && this.zzh.zzt().zzd(this.zza, zzap.zzbt) && zzu.zzb()) {
                list.clear();
            }
            if (zzkb.zzb() && this.zzh.zzt().zzd(this.zza, zzap.zzbx) && zzu.zzc()) {
                list.clear();
            }
            if (!zzkb.zzb() || !this.zzh.zzt().zzd(this.zza, zzap.zzbx)) {
                list.add(Long.valueOf(zzu.zzf.longValue() / 1000));
                return;
            }
            long longValue2 = zzu.zzf.longValue() / 1000;
            if (!list.contains(Long.valueOf(longValue2))) {
                list.add(Long.valueOf(longValue2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzbr.zza zza(int i, List<Integer> list) {
        ArrayList arrayList;
        ArrayList arrayList2;
        zzbr.zza.C0023zza zzh2 = zzbr.zza.zzh();
        zzh2.zza(i);
        zzh2.zza(this.zzb);
        zzbr.zzi zzi = this.zzc;
        if (zzi != null) {
            zzh2.zza(zzi);
        }
        zzbr.zzi.zza zza2 = zzbr.zzi.zzi().zzb(zzkw.zza(this.zzd)).zza(zzkw.zza(this.zze));
        if (this.zzf == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.zzf.size());
            for (Integer intValue : this.zzf.keySet()) {
                int intValue2 = intValue.intValue();
                arrayList.add((zzbr.zzb) ((zzfd) zzbr.zzb.zze().zza(intValue2).zza(this.zzf.get(Integer.valueOf(intValue2)).longValue()).zzu()));
            }
        }
        zza2.zzc(arrayList);
        if (this.zzg == null) {
            arrayList2 = Collections.emptyList();
        } else {
            arrayList2 = new ArrayList(this.zzg.size());
            for (Integer next : this.zzg.keySet()) {
                zzbr.zzj.zza zza3 = zzbr.zzj.zze().zza(next.intValue());
                List list2 = this.zzg.get(next);
                if (list2 != null) {
                    Collections.sort(list2);
                    zza3.zza(list2);
                }
                arrayList2.add((zzbr.zzj) ((zzfd) zza3.zzu()));
            }
        }
        if ((!zzmv.zzb() || !this.zzh.zzt().zzd(this.zza, zzap.zzbt)) && zzh2.zza()) {
            List<zzbr.zzj> zzg2 = zzh2.zzb().zzg();
            if (!zzg2.isEmpty()) {
                ArrayList arrayList3 = new ArrayList(arrayList2);
                ArrayMap arrayMap = new ArrayMap();
                for (zzbr.zzj next2 : zzg2) {
                    if (next2.zza() && next2.zzd() > 0) {
                        arrayMap.put(Integer.valueOf(next2.zzb()), Long.valueOf(next2.zza(next2.zzd() - 1)));
                    }
                }
                for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                    zzbr.zzj zzj = (zzbr.zzj) arrayList3.get(i2);
                    Long l = (Long) arrayMap.remove(zzj.zza() ? Integer.valueOf(zzj.zzb()) : null);
                    if (l != null && (list == null || !list.contains(Integer.valueOf(zzj.zzb())))) {
                        ArrayList arrayList4 = new ArrayList();
                        if (l.longValue() < zzj.zza(0)) {
                            arrayList4.add(l);
                        }
                        arrayList4.addAll(zzj.zzc());
                        arrayList3.set(i2, (zzbr.zzj) ((zzfd) ((zzbr.zzj.zza) zzj.zzbm()).zza().zza(arrayList4).zzu()));
                    }
                }
                for (Integer num : arrayMap.keySet()) {
                    arrayList3.add((zzbr.zzj) ((zzfd) zzbr.zzj.zze().zza(num.intValue()).zza(((Long) arrayMap.get(num)).longValue()).zzu()));
                }
                arrayList2 = arrayList3;
            }
        }
        zza2.zzd(arrayList2);
        zzh2.zza(zza2);
        return (zzbr.zza) ((zzfd) zzh2.zzu());
    }

    /* synthetic */ zzp(zzn zzn, String str, zzbr.zzi zzi, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzq zzq) {
        this(zzn, str, zzi, bitSet, bitSet2, map, map2);
    }

    /* synthetic */ zzp(zzn zzn, String str, zzq zzq) {
        this(zzn, str);
    }
}

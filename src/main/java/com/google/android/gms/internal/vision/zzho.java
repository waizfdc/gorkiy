package com.google.android.gms.internal.vision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzho extends zzhm {
    private static final Class<?> zzyg = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzho() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzjp.zzp(obj, j);
        if (list instanceof zzhj) {
            obj2 = ((zzhj) list).zzgy();
        } else if (!zzyg.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzio) || !(list instanceof zzgz)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzgz zzgz = (zzgz) list;
                if (zzgz.zzdo()) {
                    zzgz.zzdp();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzjp.zza(obj, j, obj2);
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        List<L> zzhk;
        List<L> list;
        List<L> zzd = zzd(obj, j);
        if (zzd.isEmpty()) {
            if (zzd instanceof zzhj) {
                list = new zzhk(i);
            } else if (!(zzd instanceof zzio) || !(zzd instanceof zzgz)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzgz) zzd).zzag(i);
            }
            zzjp.zza(obj, j, list);
            return list;
        }
        if (zzyg.isAssignableFrom(zzd.getClass())) {
            zzhk = new ArrayList<>(zzd.size() + i);
            zzhk.addAll(zzd);
            zzjp.zza(obj, j, zzhk);
        } else if (zzd instanceof zzjo) {
            zzhk = new zzhk(zzd.size() + i);
            zzhk.addAll((zzjo) zzd);
            zzjp.zza(obj, j, zzhk);
        } else if (!(zzd instanceof zzio) || !(zzd instanceof zzgz)) {
            return zzd;
        } else {
            zzgz zzgz = (zzgz) zzd;
            if (zzgz.zzdo()) {
                return zzd;
            }
            zzgz zzag = zzgz.zzag(zzd.size() + i);
            zzjp.zza(obj, j, zzag);
            return zzag;
        }
        return zzhk;
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzd = zzd(obj2, j);
        List zza = zza(obj, j, zzd.size());
        int size = zza.size();
        int size2 = zzd.size();
        if (size > 0 && size2 > 0) {
            zza.addAll(zzd);
        }
        if (size > 0) {
            zzd = zza;
        }
        zzjp.zza(obj, j, zzd);
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzjp.zzp(obj, j);
    }
}

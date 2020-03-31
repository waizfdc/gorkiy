package com.google.android.gms.internal.firebase_ml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzws extends zzwq {
    private static final Class<?> zzcfc = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzws() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzyy.zzp(obj, j);
        if (list instanceof zzwr) {
            obj2 = ((zzwr) list).zzus();
        } else if (!zzcfc.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzxs) || !(list instanceof zzwh)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzwh zzwh = (zzwh) list;
                if (zzwh.zzso()) {
                    zzwh.zzsp();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzyy.zza(obj, j, obj2);
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzwo;
        List zzc = zzc(obj2, j);
        int size = zzc.size();
        List zzc2 = zzc(obj, j);
        if (zzc2.isEmpty()) {
            if (zzc2 instanceof zzwr) {
                zzc2 = new zzwo(size);
            } else if (!(zzc2 instanceof zzxs) || !(zzc2 instanceof zzwh)) {
                zzc2 = new ArrayList(size);
            } else {
                zzc2 = ((zzwh) zzc2).zzcr(size);
            }
            zzyy.zza(obj, j, zzc2);
        } else {
            if (zzcfc.isAssignableFrom(zzc2.getClass())) {
                zzwo = new ArrayList(zzc2.size() + size);
                zzwo.addAll(zzc2);
                zzyy.zza(obj, j, zzwo);
            } else if (zzc2 instanceof zzyx) {
                zzwo = new zzwo(zzc2.size() + size);
                zzwo.addAll((zzyx) zzc2);
                zzyy.zza(obj, j, zzwo);
            } else if ((zzc2 instanceof zzxs) && (zzc2 instanceof zzwh)) {
                zzwh zzwh = (zzwh) zzc2;
                if (!zzwh.zzso()) {
                    zzc2 = zzwh.zzcr(zzc2.size() + size);
                    zzyy.zza(obj, j, zzc2);
                }
            }
            zzc2 = zzwo;
        }
        int size2 = zzc2.size();
        int size3 = zzc.size();
        if (size2 > 0 && size3 > 0) {
            zzc2.addAll(zzc);
        }
        if (size2 > 0) {
            zzc = zzc2;
        }
        zzyy.zza(obj, j, zzc);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzyy.zzp(obj, j);
    }
}

package com.google.android.gms.internal.fitness;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzha extends zzgy {
    private static final Class<?> zzxb = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzha() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j) {
        Object obj2;
        List list = (List) zzja.zzo(obj, j);
        if (list instanceof zzgv) {
            obj2 = ((zzgv) list).zzby();
        } else if (!zzxb.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzhx) || !(list instanceof zzgl)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzgl zzgl = (zzgl) list;
                if (zzgl.zzak()) {
                    zzgl.zzal();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzja.zza(obj, j, obj2);
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzgw;
        List zzc = zzc(obj2, j);
        int size = zzc.size();
        List zzc2 = zzc(obj, j);
        if (zzc2.isEmpty()) {
            if (zzc2 instanceof zzgv) {
                zzc2 = new zzgw(size);
            } else if (!(zzc2 instanceof zzhx) || !(zzc2 instanceof zzgl)) {
                zzc2 = new ArrayList(size);
            } else {
                zzc2 = ((zzgl) zzc2).zzac(size);
            }
            zzja.zza(obj, j, zzc2);
        } else {
            if (zzxb.isAssignableFrom(zzc2.getClass())) {
                zzgw = new ArrayList(zzc2.size() + size);
                zzgw.addAll(zzc2);
                zzja.zza(obj, j, zzgw);
            } else if (zzc2 instanceof zziv) {
                zzgw = new zzgw(zzc2.size() + size);
                zzgw.addAll((zziv) zzc2);
                zzja.zza(obj, j, zzgw);
            } else if ((zzc2 instanceof zzhx) && (zzc2 instanceof zzgl)) {
                zzgl zzgl = (zzgl) zzc2;
                if (!zzgl.zzak()) {
                    zzc2 = zzgl.zzac(zzc2.size() + size);
                    zzja.zza(obj, j, zzc2);
                }
            }
            zzc2 = zzgw;
        }
        int size2 = zzc2.size();
        int size3 = zzc.size();
        if (size2 > 0 && size3 > 0) {
            zzc2.addAll(zzc);
        }
        if (size2 > 0) {
            zzc = zzc2;
        }
        zzja.zza(obj, j, zzc);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzja.zzo(obj, j);
    }
}

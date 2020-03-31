package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
final class zzga extends zzfy {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzga() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzib.zzf(obj, j);
        if (list instanceof zzfv) {
            obj2 = ((zzfv) list).g_();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzha) || !(list instanceof zzfl)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzfl zzfl = (zzfl) list;
                if (zzfl.zza()) {
                    zzfl.h_();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzib.zza(obj, j, obj2);
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        List<L> zzfw;
        List<L> list;
        List<L> zzc = zzc(obj, j);
        if (zzc.isEmpty()) {
            if (zzc instanceof zzfv) {
                list = new zzfw(i);
            } else if (!(zzc instanceof zzha) || !(zzc instanceof zzfl)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzfl) zzc).zza(i);
            }
            zzib.zza(obj, j, list);
            return list;
        }
        if (zza.isAssignableFrom(zzc.getClass())) {
            zzfw = new ArrayList<>(zzc.size() + i);
            zzfw.addAll(zzc);
            zzib.zza(obj, j, zzfw);
        } else if (zzc instanceof zzia) {
            zzfw = new zzfw(zzc.size() + i);
            zzfw.addAll((zzia) zzc);
            zzib.zza(obj, j, zzfw);
        } else if (!(zzc instanceof zzha) || !(zzc instanceof zzfl)) {
            return zzc;
        } else {
            zzfl zzfl = (zzfl) zzc;
            if (zzfl.zza()) {
                return zzc;
            }
            zzfl zza2 = zzfl.zza(zzc.size() + i);
            zzib.zza(obj, j, zza2);
            return zza2;
        }
        return zzfw;
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza2 = zza(obj, j, zzc.size());
        int size = zza2.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza2.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza2;
        }
        zzib.zza(obj, j, zzc);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzib.zzf(obj, j);
    }
}

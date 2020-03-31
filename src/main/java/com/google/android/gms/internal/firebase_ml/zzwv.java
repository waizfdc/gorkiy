package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzwv extends zzwq {
    private zzwv() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        zzd(obj, j).zzsp();
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzwh zzd = zzd(obj, j);
        zzwh zzd2 = zzd(obj2, j);
        int size = zzd.size();
        int size2 = zzd2.size();
        if (size > 0 && size2 > 0) {
            if (!zzd.zzso()) {
                zzd = zzd.zzcr(size2 + size);
            }
            zzd.addAll(zzd2);
        }
        if (size > 0) {
            zzd2 = zzd;
        }
        zzyy.zza(obj, j, zzd2);
    }

    private static <E> zzwh<E> zzd(Object obj, long j) {
        return (zzwh) zzyy.zzp(obj, j);
    }
}

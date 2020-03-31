package com.google.firebase.ml.vision.barcode.internal;

import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zznq;
import com.google.android.gms.internal.firebase_ml.zzpw;
import com.google.android.gms.internal.firebase_ml.zzrl;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final /* synthetic */ class zzd implements zzpw {
    private final long zzbhi;
    private final zznq zzbhj;
    private final List zzbhl;
    private final zza zzbjw;
    private final List zzbjx;
    private final zzrl zzbjy;

    zzd(zza zza, long j, zznq zznq, List list, List list2, zzrl zzrl) {
        this.zzbjw = zza;
        this.zzbhi = j;
        this.zzbhj = zznq;
        this.zzbjx = list;
        this.zzbhl = list2;
        this.zzbjy = zzrl;
    }

    public final zzng.zzab.zza zznt() {
        return this.zzbjw.zza(this.zzbhi, this.zzbhj, this.zzbjx, this.zzbhl, this.zzbjy);
    }
}

package com.google.firebase.ml.vision.objects.internal;

import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zznq;
import com.google.android.gms.internal.firebase_ml.zzpw;
import com.google.android.gms.internal.firebase_ml.zzrl;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final /* synthetic */ class zzf implements zzpw {
    private final long zzbho;
    private final zzg zzbnl;
    private final List zzbnm;
    private final zznq zzbnn;
    private final zzrl zzbno;

    zzf(zzg zzg, List list, long j, zznq zznq, zzrl zzrl) {
        this.zzbnl = zzg;
        this.zzbnm = list;
        this.zzbho = j;
        this.zzbnn = zznq;
        this.zzbno = zzrl;
    }

    public final zzng.zzab.zza zznt() {
        return this.zzbnl.zza(this.zzbnm, this.zzbho, this.zzbnn, this.zzbno);
    }
}

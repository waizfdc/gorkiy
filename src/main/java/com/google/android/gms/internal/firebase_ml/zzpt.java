package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zzng;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final /* synthetic */ class zzpt implements Runnable {
    private final zzpo zzbcz;
    private final zzng.zzab.zza zzbda;
    private final zznu zzbdb;

    zzpt(zzpo zzpo, zzng.zzab.zza zza, zznu zznu) {
        this.zzbcz = zzpo;
        this.zzbda = zza;
        this.zzbdb = zznu;
    }

    public final void run() {
        this.zzbcz.zzb(this.zzbda, this.zzbdb);
    }
}

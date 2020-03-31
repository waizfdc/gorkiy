package com.google.android.gms.internal.firebase_ml;

import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final /* synthetic */ class zzpl implements Callable {
    private final zzpj zzbbw;
    private final zzpx zzbbx;
    private final zzpc zzbcc;
    private final zzpg zzbcd;

    zzpl(zzpj zzpj, zzpx zzpx, zzpc zzpc, zzpg zzpg) {
        this.zzbbw = zzpj;
        this.zzbbx = zzpx;
        this.zzbcc = zzpc;
        this.zzbcd = zzpg;
    }

    public final Object call() {
        return this.zzbbw.zza(this.zzbbx, this.zzbcc, this.zzbcd);
    }
}

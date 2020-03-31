package com.google.android.gms.internal.firebase_ml;

import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final /* synthetic */ class zzpi implements Callable {
    private final zzpj zzbbw;
    private final zzpx zzbbx;
    private final Callable zzbby;

    zzpi(zzpj zzpj, zzpx zzpx, Callable callable) {
        this.zzbbw = zzpj;
        this.zzbbx = zzpx;
        this.zzbby = callable;
    }

    public final Object call() {
        return this.zzbbw.zzb(this.zzbbx, this.zzbby);
    }
}

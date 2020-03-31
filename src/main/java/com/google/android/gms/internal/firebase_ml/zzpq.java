package com.google.android.gms.internal.firebase_ml;

import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final /* synthetic */ class zzpq implements Callable {
    private final zzqc zzbcx;

    private zzpq(zzqc zzqc) {
        this.zzbcx = zzqc;
    }

    static Callable zza(zzqc zzqc) {
        return new zzpq(zzqc);
    }

    public final Object call() {
        return this.zzbcx.zzob();
    }
}

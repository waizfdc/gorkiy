package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final class zzrb extends zzkb {
    private final /* synthetic */ zzrc zzbkk;

    zzrb(zzrc zzrc) {
        this.zzbkk = zzrc;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzkc<?> zzkc) throws IOException {
        super.zza(zzkc);
        zzkc.zzfi().put("X-Goog-Spatula", this.zzbkk.zzbkn);
    }
}

package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final class zzga implements zzha {
    private final /* synthetic */ zzha zzyl;
    private final /* synthetic */ zzgu zzym;
    private final /* synthetic */ zzgb zzyn;

    zzga(zzgb zzgb, zzha zzha, zzgu zzgu) {
        this.zzyn = zzgb;
        this.zzyl = zzha;
        this.zzym = zzgu;
    }

    public final void zza(zzgz zzgz) throws IOException {
        zzha zzha = this.zzyl;
        if (zzha != null) {
            zzha.zza(zzgz);
        }
        if (!zzgz.zzgd() && this.zzym.zzga()) {
            throw this.zzyn.zzb(zzgz);
        }
    }
}

package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzgx {
    private final zzgw zzaal;
    private final zzhd zzya;

    zzgx(zzhd zzhd, zzgw zzgw) {
        this.zzya = zzhd;
        this.zzaal = zzgw;
    }

    public final zzgu zza(String str, zzgm zzgm, zzgp zzgp) throws IOException {
        zzgu zzgu = new zzgu(this.zzya, null);
        zzgw zzgw = this.zzaal;
        if (zzgw != null) {
            zzgw.zza(zzgu);
        }
        zzgu.zzae(str);
        zzgu.zza(zzgm);
        if (zzgp != null) {
            zzgu.zza(zzgp);
        }
        return zzgu;
    }
}

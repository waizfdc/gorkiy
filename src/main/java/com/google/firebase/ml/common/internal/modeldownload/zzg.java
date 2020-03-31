package com.google.firebase.ml.common.internal.modeldownload;

import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.firebase.ml.common.FirebaseMLException;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzg {
    private final zzi zzbdp;

    public zzg(zzpn zzpn) {
        this.zzbdp = new zzi(zzpn);
    }

    public final void zza(String str, zzn zzn) throws FirebaseMLException {
        this.zzbdp.zza(str, zzn);
    }

    public final boolean zza(zzaa zzaa) throws FirebaseMLException {
        return this.zzbdp.zzb(zzaa.zzou(), zzaa.zzov());
    }

    public final boolean zzb(String str, zzn zzn) throws FirebaseMLException {
        return this.zzbdp.zzb(str, zzn);
    }
}

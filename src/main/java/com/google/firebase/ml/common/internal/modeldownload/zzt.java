package com.google.firebase.ml.common.internal.modeldownload;

import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zzvx;
import com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzt {
    public static zzng.zzai zza(FirebaseRemoteModel firebaseRemoteModel, zzn zzn) {
        String modelHash = firebaseRemoteModel.getModelHash();
        zzng.zzah.zza zzof = zzn.zzof();
        zzng.zzai.zzb zzma = zzng.zzai.zzma();
        zzng.zzah.zzb zzb = zzng.zzah.zzly().zzbe(firebaseRemoteModel.getModelNameForBackend()).zzb(zzng.zzah.zzc.CLOUD);
        if (modelHash == null) {
            modelHash = "";
        }
        return (zzng.zzai) ((zzvx) zzma.zza(zzb.zzbg(modelHash).zzd(zzof)).zztx());
    }
}

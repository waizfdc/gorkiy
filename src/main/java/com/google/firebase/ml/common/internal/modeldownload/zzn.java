package com.google.firebase.ml.common.internal.modeldownload;

import com.google.android.gms.internal.firebase_ml.zzng;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public enum zzn {
    UNKNOWN,
    BASE,
    AUTOML,
    CUSTOM,
    TRANSLATE;

    public final zzng.zzah.zza zzof() {
        int i = zzq.zzbdw[ordinal()];
        if (i == 1) {
            return zzng.zzah.zza.BASE_TRANSLATE;
        }
        if (i == 2) {
            return zzng.zzah.zza.CUSTOM;
        }
        if (i != 3) {
            return zzng.zzah.zza.TYPE_UNKNOWN;
        }
        return zzng.zzah.zza.AUTOML_IMAGE_LABELING;
    }
}

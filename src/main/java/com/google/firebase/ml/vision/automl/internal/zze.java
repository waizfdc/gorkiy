package com.google.firebase.ml.vision.automl.internal;

import com.google.firebase.ml.vision.automl.FirebaseAutoMLRemoteModel;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final /* synthetic */ class zze implements Callable {
    private final zza zzbit;
    private final FirebaseAutoMLRemoteModel zzbiu;

    zze(zza zza, FirebaseAutoMLRemoteModel firebaseAutoMLRemoteModel) {
        this.zzbit = zza;
        this.zzbiu = firebaseAutoMLRemoteModel;
    }

    public final Object call() {
        return this.zzbit.zza(this.zzbiu);
    }
}

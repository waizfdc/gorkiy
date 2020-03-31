package com.google.firebase.ml.vision.automl.internal;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.common.internal.modeldownload.zzv;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final /* synthetic */ class zzf implements SuccessContinuation {
    private final zzv zzbgz;

    zzf(zzv zzv) {
        this.zzbgz = zzv;
    }

    public final Task then(Object obj) {
        return this.zzbgz.zzop();
    }
}

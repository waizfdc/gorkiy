package com.google.firebase.ml.vision.automl.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final /* synthetic */ class zzd implements OnCompleteListener {
    private final zza zzbit;

    zzd(zza zza) {
        this.zzbit = zza;
    }

    public final void onComplete(Task task) {
        this.zzbit.zzc(task);
    }
}

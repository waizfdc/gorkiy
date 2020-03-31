package com.google.firebase.ml.vision.automl.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final /* synthetic */ class zzb implements OnCompleteListener {
    private final zza zzbit;

    zzb(zza zza) {
        this.zzbit = zza;
    }

    public final void onComplete(Task task) {
        this.zzbit.zzd(task);
    }
}

package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@20.1.1 */
final /* synthetic */ class zzc implements Continuation {
    private final Context zza;
    private final Intent zzb;

    zzc(Context context, Intent intent) {
        this.zza = context;
        this.zzb = intent;
    }

    public final Object then(Task task) {
        return zza.zza(this.zza, this.zzb, task);
    }
}

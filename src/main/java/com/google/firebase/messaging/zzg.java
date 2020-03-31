package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.2 */
final /* synthetic */ class zzg implements OnCompleteListener {
    private final zzc zza;
    private final Intent zzb;

    zzg(zzc zzc, Intent intent) {
        this.zza = zzc;
        this.zzb = intent;
    }

    public final void onComplete(Task task) {
        this.zza.zza(this.zzb, task);
    }
}

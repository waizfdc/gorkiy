package com.google.firebase.iid;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@20.1.1 */
final /* synthetic */ class zzn implements Continuation {
    private final FirebaseInstanceId zza;
    private final String zzb;
    private final String zzc;

    zzn(FirebaseInstanceId firebaseInstanceId, String str, String str2) {
        this.zza = firebaseInstanceId;
        this.zzb = str;
        this.zzc = str2;
    }

    public final Object then(Task task) {
        return this.zza.zza(this.zzb, this.zzc, task);
    }
}

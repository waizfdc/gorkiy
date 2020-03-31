package com.google.firebase.iid;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@20.1.1 */
final /* synthetic */ class zzbh implements OnCompleteListener {
    private final zzbi zza;

    zzbh(zzbi zzbi) {
        this.zza = zzbi;
    }

    public final void onComplete(Task task) {
        this.zza.zzb();
    }
}

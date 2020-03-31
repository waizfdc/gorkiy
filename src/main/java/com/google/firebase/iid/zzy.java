package com.google.firebase.iid;

import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-iid@@20.1.1 */
final class zzy implements zzb {
    private final ExecutorService zza;

    zzy(ExecutorService executorService) {
        this.zza = executorService;
    }

    public final Task<Integer> zza(Intent intent) {
        return Tasks.call(this.zza, new zzaa(intent));
    }
}

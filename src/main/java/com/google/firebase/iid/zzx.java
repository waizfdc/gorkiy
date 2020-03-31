package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-iid@@20.1.1 */
final class zzx implements Continuation<Bundle, String> {
    private final /* synthetic */ zzs zza;

    zzx(zzs zzs) {
        this.zza = zzs;
    }

    public final /* synthetic */ Object then(Task task) throws Exception {
        return zzs.zza((Bundle) task.getResult(IOException.class));
    }
}

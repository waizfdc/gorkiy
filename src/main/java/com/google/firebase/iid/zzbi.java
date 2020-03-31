package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-iid@@20.1.1 */
final class zzbi {
    final Intent zza;
    private final TaskCompletionSource<Void> zzb = new TaskCompletionSource<>();

    zzbi(Intent intent) {
        this.zza = intent;
    }

    /* access modifiers changed from: package-private */
    public final Task<Void> zza() {
        return this.zzb.getTask();
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        this.zzb.trySetResult(null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc() {
        String action = this.zza.getAction();
        StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        Log.w("FirebaseInstanceId", sb.toString());
        zzb();
    }
}

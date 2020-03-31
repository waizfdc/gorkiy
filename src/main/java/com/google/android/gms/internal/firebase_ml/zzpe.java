package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final /* synthetic */ class zzpe implements Runnable {
    private final Callable zzbbr;
    private final TaskCompletionSource zzbbs;

    zzpe(Callable callable, TaskCompletionSource taskCompletionSource) {
        this.zzbbr = callable;
        this.zzbbs = taskCompletionSource;
    }

    public final void run() {
        zzpf.zza(this.zzbbr, this.zzbbs);
    }
}

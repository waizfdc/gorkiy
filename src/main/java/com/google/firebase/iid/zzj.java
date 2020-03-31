package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@20.1.1 */
final /* synthetic */ class zzj implements Executor {
    static final Executor zza = new zzj();

    private zzj() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}

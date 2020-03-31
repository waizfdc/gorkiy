package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@20.1.1 */
final /* synthetic */ class zzm implements Executor {
    static final Executor zza = new zzm();

    private zzm() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}

package com.google.android.gms.internal.firebase_ml;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
enum zzph implements Executor {
    INSTANCE;

    public final void execute(Runnable runnable) {
        zzpf.zzno().handler.post(runnable);
    }
}

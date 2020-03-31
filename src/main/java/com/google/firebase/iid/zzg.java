package com.google.firebase.iid;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.firebase:firebase-iid@@20.1.1 */
final /* synthetic */ class zzg implements ThreadFactory {
    static final ThreadFactory zza = new zzg();

    private zzg() {
    }

    public final Thread newThread(Runnable runnable) {
        return zzh.zza(runnable);
    }
}

package com.google.android.gms.common;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final /* synthetic */ class zab implements SuccessContinuation {
    static final SuccessContinuation zaar = new zab();

    private zab() {
    }

    public final Task then(Object obj) {
        return Tasks.forResult(null);
    }
}

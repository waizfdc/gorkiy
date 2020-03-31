package com.google.firebase.iid;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.firebase:firebase-iid@@20.1.1 */
final /* synthetic */ class zzp implements OnCompleteListener {
    private final CountDownLatch zza;

    zzp(CountDownLatch countDownLatch) {
        this.zza = countDownLatch;
    }

    public final void onComplete(Task task) {
        this.zza.countDown();
    }
}

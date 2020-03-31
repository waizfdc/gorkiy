package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzel extends zzcp {
    private final BaseImplementation.ResultHolder<Status> zzmv;

    public zzel(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.zzmv = resultHolder;
    }

    public final void onResult(Status status) {
        this.zzmv.setResult(status);
    }

    public static zzel zza(TaskCompletionSource<Void> taskCompletionSource) {
        return new zzel(new zzek(taskCompletionSource));
    }

    public static zzel zzb(TaskCompletionSource<Boolean> taskCompletionSource) {
        return new zzel(new zzen(taskCompletionSource));
    }
}

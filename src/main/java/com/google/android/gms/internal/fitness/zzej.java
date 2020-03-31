package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.fitness.result.SessionReadResult;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzej extends zzcj {
    private final BaseImplementation.ResultHolder<SessionReadResult> zzmv;

    private zzej(BaseImplementation.ResultHolder<SessionReadResult> resultHolder) {
        this.zzmv = resultHolder;
    }

    public final void zza(SessionReadResult sessionReadResult) {
        this.zzmv.setResult(sessionReadResult);
    }

    /* synthetic */ zzej(BaseImplementation.ResultHolder resultHolder, zzed zzed) {
        this(resultHolder);
    }
}

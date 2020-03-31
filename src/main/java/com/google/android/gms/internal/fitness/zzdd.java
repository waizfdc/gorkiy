package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.fitness.result.DataTypeResult;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzdd extends zzbk {
    private final BaseImplementation.ResultHolder<DataTypeResult> zzmv;

    private zzdd(BaseImplementation.ResultHolder<DataTypeResult> resultHolder) {
        this.zzmv = resultHolder;
    }

    public final void zza(DataTypeResult dataTypeResult) {
        this.zzmv.setResult(dataTypeResult);
    }

    /* synthetic */ zzdd(BaseImplementation.ResultHolder resultHolder, zzcy zzcy) {
        this(resultHolder);
    }
}

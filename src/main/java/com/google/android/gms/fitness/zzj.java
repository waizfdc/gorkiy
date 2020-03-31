package com.google.android.gms.fitness;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.fitness.result.DailyTotalResult;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final /* synthetic */ class zzj implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzho = new zzj();

    private zzj() {
    }

    public final Object convert(Result result) {
        return ((DailyTotalResult) result).getTotal();
    }
}

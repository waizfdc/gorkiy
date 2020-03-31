package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.fitness.result.DailyTotalResult;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzdp extends zzbd {
    private final /* synthetic */ zzdm zznr;

    zzdp(zzdm zzdm) {
        this.zznr = zzdm;
    }

    public final void zza(DailyTotalResult dailyTotalResult) {
        this.zznr.setResult((Result) dailyTotalResult);
    }
}

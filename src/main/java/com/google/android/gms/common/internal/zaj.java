package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zaj implements PendingResultUtil.ResultConverter<R, T> {
    private final /* synthetic */ Response zapg;

    zaj(Response response) {
        this.zapg = response;
    }

    public final /* synthetic */ Object convert(Result result) {
        this.zapg.setResult(result);
        return this.zapg;
    }
}

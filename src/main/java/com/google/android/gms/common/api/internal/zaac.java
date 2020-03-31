package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zaac implements PendingResult.StatusListener {
    private final /* synthetic */ zaz zafq;
    private final /* synthetic */ BasePendingResult zafr;

    zaac(zaz zaz, BasePendingResult basePendingResult) {
        this.zafq = zaz;
        this.zafr = basePendingResult;
    }

    public final void onComplete(Status status) {
        this.zafq.zafm.remove(this.zafr);
    }
}

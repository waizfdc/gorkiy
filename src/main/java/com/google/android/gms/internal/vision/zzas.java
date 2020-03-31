package com.google.android.gms.internal.vision;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzas extends ContentObserver {
    private final /* synthetic */ zzaq zzfq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzas(zzaq zzaq, Handler handler) {
        super(null);
        this.zzfq = zzaq;
    }

    public final void onChange(boolean z) {
        this.zzfq.zzv();
    }
}

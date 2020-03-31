package com.google.android.gms.internal.vision;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzao extends ContentObserver {
    zzao(Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        zzal.zzew.set(true);
    }
}

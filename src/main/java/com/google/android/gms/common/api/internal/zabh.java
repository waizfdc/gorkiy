package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zabh implements BackgroundDetector.BackgroundStateChangeListener {
    private final /* synthetic */ GoogleApiManager zaia;

    zabh(GoogleApiManager googleApiManager) {
        this.zaia = googleApiManager;
    }

    public final void onBackgroundStateChanged(boolean z) {
        this.zaia.handler.sendMessage(this.zaia.handler.obtainMessage(1, Boolean.valueOf(z)));
    }
}

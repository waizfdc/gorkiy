package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final /* synthetic */ class zzpy implements BackgroundDetector.BackgroundStateChangeListener {
    private final zzpz zzbde;

    zzpy(zzpz zzpz) {
        this.zzbde = zzpz;
    }

    public final void onBackgroundStateChanged(boolean z) {
        this.zzbde.zzaq(z);
    }
}

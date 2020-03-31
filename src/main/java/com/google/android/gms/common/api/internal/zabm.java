package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zabm implements BaseGmsClient.SignOutCallbacks {
    final /* synthetic */ GoogleApiManager.zaa zaiq;

    zabm(GoogleApiManager.zaa zaa) {
        this.zaiq = zaa;
    }

    public final void onSignOutComplete() {
        GoogleApiManager.this.handler.post(new zabl(this));
    }
}

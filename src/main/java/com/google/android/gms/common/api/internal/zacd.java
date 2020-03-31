package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zacd implements Runnable {
    private final /* synthetic */ zace zakl;

    zacd(zace zace) {
        this.zakl = zace;
    }

    public final void run() {
        this.zakl.zakn.zag(new ConnectionResult(4));
    }
}

package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.auth.api.AuthProxy;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.ml.common.FirebaseMLException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzqz implements zzpc<ResultType, zzqx>, zzpx {
    private final zzrc zzbkf;
    private final GoogleApiClient zzbkg;
    private final /* synthetic */ zzra zzbkh;

    zzqz(zzra zzra, FirebaseApp firebaseApp, boolean z) {
        this.zzbkh = zzra;
        if (z) {
            GoogleApiClient build = new GoogleApiClient.Builder(firebaseApp.getApplicationContext()).addApi(AuthProxy.API).build();
            this.zzbkg = build;
            build.connect();
        } else {
            this.zzbkg = null;
        }
        this.zzbkf = zzrc.zza(firebaseApp, z, this.zzbkg);
    }

    public final zzpx zznl() {
        return this;
    }

    public final void zznu() throws FirebaseMLException {
        GoogleApiClient googleApiClient = this.zzbkg;
        if (googleApiClient != null && !zzma.equal(googleApiClient.blockingConnect(3, TimeUnit.SECONDS), ConnectionResult.RESULT_SUCCESS)) {
            throw new FirebaseMLException("Failed to contact Google Play services", 14);
        }
    }

    public final void release() {
        GoogleApiClient googleApiClient = this.zzbkg;
        if (googleApiClient != null) {
            googleApiClient.disconnect();
        }
    }

    public final /* synthetic */ Object zza(zzpg zzpg) throws FirebaseMLException {
        zzqx zzqx = (zzqx) zzpg;
        return this.zzbkh.zza(this.zzbkf.zza(zzqx), zzqx.zzbke);
    }
}

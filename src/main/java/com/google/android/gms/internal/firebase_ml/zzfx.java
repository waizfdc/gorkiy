package com.google.android.gms.internal.firebase_ml;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzfx implements zzgq, zzgw {
    private final boolean zzxy;

    public zzfx() {
        this(false);
    }

    private zzfx(boolean z) {
        this.zzxy = false;
    }

    public final void zza(zzgu zzgu) {
        zzgu.zza(this);
    }

    public final void zzb(zzgu zzgu) throws IOException {
        String requestMethod = zzgu.getRequestMethod();
        boolean z = true;
        if (requestMethod.equals(HttpRequest.METHOD_POST) || ((!requestMethod.equals(HttpRequest.METHOD_GET) || zzgu.zzfs().zzfq().length() <= 2048) && zzgu.zzfr().zzai(requestMethod))) {
            z = false;
        }
        if (z) {
            String requestMethod2 = zzgu.getRequestMethod();
            zzgu.zzae(HttpRequest.METHOD_POST);
            zzgt zzgt = (zzgt) zzgu.zzfw().zzb("X-HTTP-Method-Override", requestMethod2);
            if (requestMethod2.equals(HttpRequest.METHOD_GET)) {
                zzgu.zza(new zzhg((zzgm) zzgu.zzfs().clone()));
                zzgu.zzfs().clear();
            } else if (zzgu.zzft() == null) {
                zzgu.zza(new zzgl());
            }
        }
    }
}

package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzjy extends zzge {
    zzjy(zzjx zzjx) {
        super(zzjx);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzgb<?> zzgb) throws IOException {
        super.zza(zzgb);
    }

    static {
        boolean z = zzfu.zzxv.intValue() == 1 && zzfu.zzxw.intValue() >= 15;
        Object[] objArr = {zzfu.VERSION};
        if (!z) {
            throw new IllegalStateException(zzmn.zzb("You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.25.0-SNAPSHOT of the Cloud Vision API library.", objArr));
        }
    }
}

package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.fitness.FitnessStatusCodes;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final class zzrd implements zzgw {
    zzrd(zzrc zzrc) {
    }

    public final void zza(zzgu zzgu) throws IOException {
        zzgu.zzae((int) AbstractSpiCall.DEFAULT_TIMEOUT);
        zzgu.zzad(FitnessStatusCodes.NEEDS_OAUTH_PERMISSIONS);
    }
}

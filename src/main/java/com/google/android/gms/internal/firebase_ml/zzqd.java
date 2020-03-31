package com.google.android.gms.internal.firebase_ml;

import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zzpo;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzqd implements zzpo.zzb {
    private static final GmsLogger zzbbo = new GmsLogger("MlStatsLogger", "");
    private final ClearcutLogger zzbdq;

    public zzqd(Context context) {
        this.zzbdq = ClearcutLogger.anonymousLogger(context, "FIREBASE_ML_SDK");
    }

    public final void zza(zzng.zzab zzab) {
        GmsLogger gmsLogger = zzbbo;
        String valueOf = String.valueOf(zzab);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
        sb.append("Logging FirebaseMlSdkLogEvent ");
        sb.append(valueOf);
        gmsLogger.d("MlStatsLogger", sb.toString());
        this.zzbdq.newEvent(zzab.toByteArray()).log();
    }
}

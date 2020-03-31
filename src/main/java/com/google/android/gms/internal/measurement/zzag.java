package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.3 */
final class zzag extends zzx.zza {
    private final /* synthetic */ zzx zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzag(zzx zzx) {
        super(zzx);
        this.zzc = zzx;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzc.zzr.resetAnalyticsData(this.zza);
    }
}

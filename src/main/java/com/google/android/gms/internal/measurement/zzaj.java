package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.measurement.internal.zzho;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.3 */
final class zzaj extends zzx.zza {
    private final /* synthetic */ zzho zzc;
    private final /* synthetic */ zzx zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaj(zzx zzx, zzho zzho) {
        super(zzx);
        this.zzd = zzx;
        this.zzc = zzho;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzd.zzr.setEventInterceptor(new zzx.zzc(this.zzc));
    }
}

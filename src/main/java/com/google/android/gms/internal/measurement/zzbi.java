package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.3 */
final class zzbi extends zzx.zza {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzk zzd;
    private final /* synthetic */ zzx.zzd zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbi(zzx.zzd zzd2, Activity activity, zzk zzk) {
        super(zzx.this);
        this.zze = zzd2;
        this.zzc = activity;
        this.zzd = zzk;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzx.this.zzr.onActivitySaveInstanceState(ObjectWrapper.wrap(this.zzc), this.zzd, this.zzb);
    }
}

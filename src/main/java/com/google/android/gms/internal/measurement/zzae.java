package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.3 */
final class zzae extends zzx.zza {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzx zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzae(zzx zzx, Activity activity, String str, String str2) {
        super(zzx);
        this.zzf = zzx;
        this.zzc = activity;
        this.zzd = str;
        this.zze = str2;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzf.zzr.setCurrentScreen(ObjectWrapper.wrap(this.zzc), this.zzd, this.zze, this.zza);
    }
}

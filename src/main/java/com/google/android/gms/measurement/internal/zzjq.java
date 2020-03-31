package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzn;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzjq implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzm zzd;
    private final /* synthetic */ zzn zze;
    private final /* synthetic */ zzix zzf;

    zzjq(zzix zzix, String str, String str2, boolean z, zzm zzm, zzn zzn) {
        this.zzf = zzix;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = zzm;
        this.zze = zzn;
    }

    public final void run() {
        Bundle bundle = new Bundle();
        try {
            zzfc zzd2 = this.zzf.zzb;
            if (zzd2 == null) {
                this.zzf.zzr().zzf().zza("Failed to get user properties; not connected to service", this.zza, this.zzb);
                return;
            }
            bundle = zzla.zza(zzd2.zza(this.zza, this.zzb, this.zzc, this.zzd));
            this.zzf.zzaj();
            this.zzf.zzp().zza(this.zze, bundle);
        } catch (RemoteException e) {
            this.zzf.zzr().zzf().zza("Failed to get user properties; remote exception", this.zza, e);
        } finally {
            this.zzf.zzp().zza(this.zze, bundle);
        }
    }
}

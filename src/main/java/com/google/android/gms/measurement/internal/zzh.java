package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzn;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.2.3 */
final class zzh implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzan zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzh(AppMeasurementDynamiteService appMeasurementDynamiteService, zzn zzn, zzan zzan, String str) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzn;
        this.zzb = zzan;
        this.zzc = str;
    }

    public final void run() {
        this.zzd.zza.zzw().zza(this.zza, this.zzb, this.zzc);
    }
}

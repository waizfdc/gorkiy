package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zziv implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzit zzc;
    private final /* synthetic */ zzit zzd;
    private final /* synthetic */ zziw zze;

    zziv(zziw zziw, boolean z, long j, zzit zzit, zzit zzit2) {
        this.zze = zziw;
        this.zza = z;
        this.zzb = j;
        this.zzc = zzit;
        this.zzd = zzit2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, android.os.Bundle, boolean):void
     arg types: [com.google.android.gms.measurement.internal.zzit, android.os.Bundle, int]
     candidates:
      com.google.android.gms.measurement.internal.zziw.zza(android.app.Activity, com.google.android.gms.measurement.internal.zzit, boolean):void
      com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, boolean, long):void
      com.google.android.gms.measurement.internal.zziw.zza(android.app.Activity, java.lang.String, java.lang.String):void
      com.google.android.gms.measurement.internal.zziw.zza(com.google.android.gms.measurement.internal.zzit, android.os.Bundle, boolean):void */
    public final void run() {
        boolean z;
        boolean z2 = false;
        if (this.zze.zzt().zza(zzap.zzba)) {
            z = this.zza && this.zze.zza != null;
            if (z) {
                zziw zziw = this.zze;
                zziw.zza(zziw.zza, true, this.zzb);
            }
        } else {
            if (this.zza && this.zze.zza != null) {
                zziw zziw2 = this.zze;
                zziw2.zza(zziw2.zza, true, this.zzb);
            }
            z = false;
        }
        zzit zzit = this.zzc;
        if (zzit == null || zzit.zzc != this.zzd.zzc || !zzla.zzc(this.zzc.zzb, this.zzd.zzb) || !zzla.zzc(this.zzc.zza, this.zzd.zza)) {
            z2 = true;
        }
        if (z2) {
            Bundle bundle = new Bundle();
            zziw.zza(this.zzd, bundle, true);
            zzit zzit2 = this.zzc;
            if (zzit2 != null) {
                if (zzit2.zza != null) {
                    bundle.putString("_pn", this.zzc.zza);
                }
                bundle.putString("_pc", this.zzc.zzb);
                bundle.putLong("_pi", this.zzc.zzc);
            }
            if (this.zze.zzt().zza(zzap.zzba) && z) {
                long zzb2 = this.zze.zzk().zzb.zzb();
                if (zzb2 > 0) {
                    this.zze.zzp().zza(bundle, zzb2);
                }
            }
            this.zze.zzf().zzb(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_vs", bundle);
        }
        this.zze.zza = this.zzd;
        this.zze.zzh().zza(this.zzd);
    }
}

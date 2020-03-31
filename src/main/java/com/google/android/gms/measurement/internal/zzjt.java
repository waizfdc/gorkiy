package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzjt implements Runnable {
    private final /* synthetic */ zzjp zza;

    zzjt(zzjp zzjp) {
        this.zza = zzjp;
    }

    public final void run() {
        zzix zzix = this.zza.zza;
        Context zzn = this.zza.zza.zzn();
        this.zza.zza.zzu();
        zzix.zza(new ComponentName(zzn, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}

package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final /* synthetic */ class zzjy implements Runnable {
    private final zzjv zza;
    private final int zzb;
    private final zzfk zzc;
    private final Intent zzd;

    zzjy(zzjv zzjv, int i, zzfk zzfk, Intent intent) {
        this.zza = zzjv;
        this.zzb = i;
        this.zzc = zzfk;
        this.zzd = intent;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd);
    }
}

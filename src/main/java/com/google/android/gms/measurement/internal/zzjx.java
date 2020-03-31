package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final /* synthetic */ class zzjx implements Runnable {
    private final zzjv zza;
    private final zzfk zzb;
    private final JobParameters zzc;

    zzjx(zzjv zzjv, zzfk zzfk, JobParameters jobParameters) {
        this.zza = zzjv;
        this.zzb = zzfk;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc);
    }
}

package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzhv implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzhp zzb;

    zzhv(zzhp zzhp, AtomicReference atomicReference) {
        this.zzb = zzhp;
        this.zza = atomicReference;
    }

    public final void run() {
        this.zzb.zzh().zza(this.zza);
    }
}

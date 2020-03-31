package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzia implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzhp zzb;

    zzia(zzhp zzhp, Bundle bundle) {
        this.zzb = zzhp;
        this.zza = bundle;
    }

    public final void run() {
        this.zzb.zzc(this.zza);
    }
}

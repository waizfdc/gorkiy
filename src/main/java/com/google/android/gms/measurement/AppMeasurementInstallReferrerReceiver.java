package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzgf;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements zzgf {
    private zzge zza;

    public final void doStartService(Context context, Intent intent) {
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzge(this);
        }
        this.zza.zza(context, intent);
    }

    public final BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }
}

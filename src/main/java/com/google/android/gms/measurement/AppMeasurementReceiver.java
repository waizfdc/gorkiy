package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzgf;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzgf {
    private zzge zza;

    public final void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzge(this);
        }
        this.zza.zza(context, intent);
    }

    public final void doStartService(Context context, Intent intent) {
        startWakefulService(context, intent);
    }

    public final BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }
}

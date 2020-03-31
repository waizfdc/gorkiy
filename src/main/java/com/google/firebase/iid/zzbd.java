package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-iid@@20.1.1 */
final class zzbd extends BroadcastReceiver {
    @Nullable
    private zzba zza;

    public zzbd(zzba zzba) {
        this.zza = zzba;
    }

    public final void zza() {
        if (FirebaseInstanceId.zzd()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.zza.zza().registerReceiver(super, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final void onReceive(Context context, Intent intent) {
        zzba zzba = this.zza;
        if (zzba != null && zzba.zzb()) {
            if (FirebaseInstanceId.zzd()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.zza(this.zza, 0);
            this.zza.zza().unregisterReceiver(super);
            this.zza = null;
        }
    }
}

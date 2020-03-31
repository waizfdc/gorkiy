package com.google.android.gms.fitness.request;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.fitness.data.BleDevice;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zza implements ListenerHolder.Notifier<BleScanCallback> {
    private final /* synthetic */ BleDevice zzof;

    zza(zzb zzb, BleDevice bleDevice) {
        this.zzof = bleDevice;
    }

    public final void onNotifyListenerFailed() {
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        ((BleScanCallback) obj).onDeviceFound(this.zzof);
    }
}

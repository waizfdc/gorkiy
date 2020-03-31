package com.google.android.gms.fitness.request;

import com.google.android.gms.fitness.data.BleDevice;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public abstract class BleScanCallback {
    public abstract void onDeviceFound(BleDevice bleDevice);

    public abstract void onScanStopped();
}

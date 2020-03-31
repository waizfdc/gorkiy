package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.fitness.result.BleDevicesResult;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzcw extends zzeo {
    private final BaseImplementation.ResultHolder<BleDevicesResult> zzmv;

    private zzcw(BaseImplementation.ResultHolder<BleDevicesResult> resultHolder) {
        this.zzmv = resultHolder;
    }

    public final void zza(BleDevicesResult bleDevicesResult) {
        this.zzmv.setResult(bleDevicesResult);
    }

    /* synthetic */ zzcw(BaseImplementation.ResultHolder resultHolder, zzcq zzcq) {
        this(resultHolder);
    }
}

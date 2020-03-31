package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.BleDevicesResult;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzer extends zzb implements zzep {
    zzer(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
    }

    public final void zza(BleDevicesResult bleDevicesResult) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, bleDevicesResult);
        zzb(1, zza);
    }
}

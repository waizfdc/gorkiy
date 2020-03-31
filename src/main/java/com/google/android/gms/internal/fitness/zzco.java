package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzco extends zzb implements zzcm {
    zzco(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IStatusCallback");
    }

    public final void onResult(Status status) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, status);
        zzb(1, zza);
    }
}

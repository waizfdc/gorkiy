package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.zzab;
import com.google.android.gms.fitness.request.zzt;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzbs extends zzb implements zzbt {
    zzbs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
    }

    public final void zza(DataTypeCreateRequest dataTypeCreateRequest) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, dataTypeCreateRequest);
        zza(1, zza);
    }

    public final void zza(zzt zzt) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzt);
        zza(2, zza);
    }

    public final void zza(zzab zzab) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzab);
        zza(22, zza);
    }
}

package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.request.zzh;
import com.google.android.gms.fitness.request.zzl;
import com.google.android.gms.fitness.request.zzx;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzbw extends zzb implements zzbx {
    zzbw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
    }

    public final void zza(DataReadRequest dataReadRequest) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, dataReadRequest);
        zza(1, zza);
    }

    public final void zza(zzl zzl) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzl);
        zza(2, zza);
    }

    public final void zza(DataDeleteRequest dataDeleteRequest) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, dataDeleteRequest);
        zza(3, zza);
    }

    public final void zza(zzh zzh) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzh);
        zza(7, zza);
    }

    public final void zza(DataUpdateRequest dataUpdateRequest) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, dataUpdateRequest);
        zza(9, zza);
    }

    public final void zza(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, dataUpdateListenerRegistrationRequest);
        zza(10, zza);
    }

    public final void zza(zzx zzx) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzx);
        zza(11, zza);
    }
}

package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.zzai;
import com.google.android.gms.fitness.request.zzbk;
import com.google.android.gms.fitness.request.zzbo;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzby extends zzb implements zzbz {
    zzby(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
    }

    public final void zza(zzbk zzbk) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzbk);
        zza(1, zza);
    }

    public final void zza(zzbo zzbo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzbo);
        zza(2, zza);
    }

    public final void zza(zzai zzai) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzai);
        zza(3, zza);
    }
}

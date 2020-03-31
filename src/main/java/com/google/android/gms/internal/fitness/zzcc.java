package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.zzay;
import com.google.android.gms.fitness.request.zzba;
import com.google.android.gms.fitness.request.zzbc;
import com.google.android.gms.fitness.request.zzbe;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzcc extends zzb implements zzcd {
    zzcc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
    }

    public final void zza(zzba zzba) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzba);
        zza(1, zza);
    }

    public final void zza(zzbc zzbc) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzbc);
        zza(2, zza);
    }

    public final void zza(SessionInsertRequest sessionInsertRequest) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, sessionInsertRequest);
        zza(3, zza);
    }

    public final void zza(SessionReadRequest sessionReadRequest) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, sessionReadRequest);
        zza(4, zza);
    }

    public final void zza(zzay zzay) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzay);
        zza(5, zza);
    }

    public final void zza(zzbe zzbe) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzbe);
        zza(6, zza);
    }
}

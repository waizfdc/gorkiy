package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.zzao;
import com.google.android.gms.fitness.request.zzas;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzca extends zzb implements zzcb {
    zzca(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
    }

    public final void zza(DataSourcesRequest dataSourcesRequest) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, dataSourcesRequest);
        zza(1, zza);
    }

    public final void zza(zzao zzao) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzao);
        zza(2, zza);
    }

    public final void zza(zzas zzas) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzas);
        zza(3, zza);
    }
}

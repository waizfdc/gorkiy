package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.zzao;
import com.google.android.gms.fitness.request.zzas;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public interface zzcb extends IInterface {
    void zza(DataSourcesRequest dataSourcesRequest) throws RemoteException;

    void zza(zzao zzao) throws RemoteException;

    void zza(zzas zzas) throws RemoteException;
}

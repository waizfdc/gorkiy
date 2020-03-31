package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.request.zzh;
import com.google.android.gms.fitness.request.zzl;
import com.google.android.gms.fitness.request.zzx;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public interface zzbx extends IInterface {
    void zza(DataDeleteRequest dataDeleteRequest) throws RemoteException;

    void zza(DataReadRequest dataReadRequest) throws RemoteException;

    void zza(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) throws RemoteException;

    void zza(DataUpdateRequest dataUpdateRequest) throws RemoteException;

    void zza(zzh zzh) throws RemoteException;

    void zza(zzl zzl) throws RemoteException;

    void zza(zzx zzx) throws RemoteException;
}

package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.zzay;
import com.google.android.gms.fitness.request.zzba;
import com.google.android.gms.fitness.request.zzbc;
import com.google.android.gms.fitness.request.zzbe;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public interface zzcd extends IInterface {
    void zza(SessionInsertRequest sessionInsertRequest) throws RemoteException;

    void zza(SessionReadRequest sessionReadRequest) throws RemoteException;

    void zza(zzay zzay) throws RemoteException;

    void zza(zzba zzba) throws RemoteException;

    void zza(zzbc zzbc) throws RemoteException;

    void zza(zzbe zzbe) throws RemoteException;
}

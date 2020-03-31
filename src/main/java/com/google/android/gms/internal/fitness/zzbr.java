package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzag;
import com.google.android.gms.fitness.request.zzbi;
import com.google.android.gms.fitness.request.zzbm;
import com.google.android.gms.fitness.request.zzf;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public interface zzbr extends IInterface {
    void zza(StartBleScanRequest startBleScanRequest) throws RemoteException;

    void zza(zzag zzag) throws RemoteException;

    void zza(zzbi zzbi) throws RemoteException;

    void zza(zzbm zzbm) throws RemoteException;

    void zza(zzf zzf) throws RemoteException;
}

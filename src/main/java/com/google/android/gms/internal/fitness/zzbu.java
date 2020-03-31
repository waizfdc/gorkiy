package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.GoalsReadRequest;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzbu extends zzb implements zzbv {
    zzbu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitGoalsApi");
    }

    public final void zza(GoalsReadRequest goalsReadRequest) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, goalsReadRequest);
        zza(1, zza);
    }
}

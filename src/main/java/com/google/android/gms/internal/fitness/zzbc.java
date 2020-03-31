package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DailyTotalResult;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzbc extends zzb implements zzba {
    zzbc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IDailyTotalCallback");
    }

    public final void zza(DailyTotalResult dailyTotalResult) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, dailyTotalResult);
        zzb(1, zza);
    }
}

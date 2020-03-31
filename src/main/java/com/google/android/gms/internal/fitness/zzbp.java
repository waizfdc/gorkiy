package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.GoalsResult;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public abstract class zzbp extends zza implements zzbm {
    public zzbp() {
        super("com.google.android.gms.fitness.internal.IGoalsReadCallback");
    }

    public static zzbm zzf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoalsReadCallback");
        if (queryLocalInterface instanceof zzbm) {
            return (zzbm) queryLocalInterface;
        }
        return new zzbo(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zza((GoalsResult) zzd.zza(parcel, GoalsResult.CREATOR));
        return true;
    }
}

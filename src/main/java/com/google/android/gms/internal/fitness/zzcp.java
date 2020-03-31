package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public abstract class zzcp extends zza implements zzcm {
    public zzcp() {
        super("com.google.android.gms.fitness.internal.IStatusCallback");
    }

    public static zzcm zzj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IStatusCallback");
        if (queryLocalInterface instanceof zzcm) {
            return (zzcm) queryLocalInterface;
        }
        return new zzco(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        onResult((Status) zzd.zza(parcel, Status.CREATOR));
        return true;
    }
}

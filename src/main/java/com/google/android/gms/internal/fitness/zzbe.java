package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataReadResult;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public abstract class zzbe extends zza implements zzbf {
    public zzbe() {
        super("com.google.android.gms.fitness.internal.IDataReadCallback");
    }

    public static zzbf zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataReadCallback");
        if (queryLocalInterface instanceof zzbf) {
            return (zzbf) queryLocalInterface;
        }
        return new zzbh(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zza((DataReadResult) zzd.zza(parcel, DataReadResult.CREATOR));
        return true;
    }
}

package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionReadResult;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public abstract class zzcj extends zza implements zzcg {
    public zzcj() {
        super("com.google.android.gms.fitness.internal.ISessionReadCallback");
    }

    public static zzcg zzh(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionReadCallback");
        if (queryLocalInterface instanceof zzcg) {
            return (zzcg) queryLocalInterface;
        }
        return new zzci(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zza((SessionReadResult) zzd.zza(parcel, SessionReadResult.CREATOR));
        return true;
    }
}

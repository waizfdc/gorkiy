package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public abstract class zzew extends zza implements zzeu {
    public zzew() {
        super("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zza((zzeq) zzd.zza(parcel, zzeq.CREATOR), zzbj.zzd(parcel.readStrongBinder()));
        } else if (i == 2) {
            zza((FitnessSensorServiceRequest) zzd.zza(parcel, FitnessSensorServiceRequest.CREATOR), zzcp.zzj(parcel.readStrongBinder()));
        } else if (i != 3) {
            return false;
        } else {
            zza((zzes) zzd.zza(parcel, zzes.CREATOR), zzcp.zzj(parcel.readStrongBinder()));
        }
        return true;
    }
}

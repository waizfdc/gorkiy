package com.google.firebase.ml.vision.automl.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.firebase_ml.zza;
import com.google.android.gms.internal.firebase_ml.zzd;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public abstract class zzh extends zza implements zzi {
    public zzh() {
        super("com.google.firebase.ml.vision.automl.internal.IOnDeviceAutoMLImageLabelerCreator");
    }

    public static zzi asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.ml.vision.automl.internal.IOnDeviceAutoMLImageLabelerCreator");
        if (queryLocalInterface instanceof zzi) {
            return (zzi) queryLocalInterface;
        }
        return new zzk(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        IOnDeviceAutoMLImageLabeler newOnDeviceAutoMLImageLabeler = newOnDeviceAutoMLImageLabeler(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (OnDeviceAutoMLImageLabelerOptionsParcel) zzd.zza(parcel, OnDeviceAutoMLImageLabelerOptionsParcel.CREATOR));
        parcel2.writeNoException();
        zzd.zza(parcel2, newOnDeviceAutoMLImageLabeler);
        return true;
    }
}

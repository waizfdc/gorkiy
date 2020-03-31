package com.google.firebase.ml.vision.automl.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.firebase_ml.zzd;
import com.google.android.gms.internal.firebase_ml.zzrk;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public interface IOnDeviceAutoMLImageLabeler extends IInterface {
    void close() throws RemoteException;

    zzj[] zza(IObjectWrapper iObjectWrapper, zzrk zzrk) throws RemoteException;

    void zznu() throws RemoteException;

    boolean zzod() throws RemoteException;

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static abstract class zza extends com.google.android.gms.internal.firebase_ml.zza implements IOnDeviceAutoMLImageLabeler {
        public zza() {
            super("com.google.firebase.ml.vision.automl.internal.IOnDeviceAutoMLImageLabeler");
        }

        /* access modifiers changed from: protected */
        public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                zzj[] zza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzrk) zzd.zza(parcel, zzrk.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedArray(zza, 1);
            } else if (i == 2) {
                zznu();
                parcel2.writeNoException();
            } else if (i == 3) {
                close();
                parcel2.writeNoException();
            } else if (i != 4) {
                return false;
            } else {
                boolean zzod = zzod();
                parcel2.writeNoException();
                zzd.writeBoolean(parcel2, zzod);
            }
            return true;
        }
    }
}

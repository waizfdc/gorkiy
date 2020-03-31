package com.google.firebase.ml.vision.barcode.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.firebase_ml.zzd;
import com.google.android.gms.internal.firebase_ml.zzrk;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public interface IBarcodeDetector extends IInterface {
    void start() throws RemoteException;

    void stop() throws RemoteException;

    IObjectWrapper zzb(IObjectWrapper iObjectWrapper, zzrk zzrk) throws RemoteException;

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static abstract class zza extends com.google.android.gms.internal.firebase_ml.zza implements IBarcodeDetector {
        public zza() {
            super("com.google.firebase.ml.vision.barcode.internal.IBarcodeDetector");
        }

        /* access modifiers changed from: protected */
        public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                start();
                parcel2.writeNoException();
            } else if (i == 2) {
                IObjectWrapper zzb = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzrk) zzd.zza(parcel, zzrk.CREATOR));
                parcel2.writeNoException();
                zzd.zza(parcel2, zzb);
            } else if (i != 3) {
                return false;
            } else {
                stop();
                parcel2.writeNoException();
            }
            return true;
        }
    }
}

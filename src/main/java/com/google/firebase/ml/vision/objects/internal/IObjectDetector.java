package com.google.firebase.ml.vision.objects.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.firebase_ml.zzd;
import com.google.android.gms.internal.firebase_ml.zzrk;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public interface IObjectDetector extends IInterface {
    void start() throws RemoteException;

    void stop() throws RemoteException;

    zzh[] zzc(IObjectWrapper iObjectWrapper, zzrk zzrk) throws RemoteException;

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static abstract class zza extends com.google.android.gms.internal.firebase_ml.zza implements IObjectDetector {
        public zza() {
            super("com.google.firebase.ml.vision.objects.internal.IObjectDetector");
        }

        /* access modifiers changed from: protected */
        public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                zzh[] zzc = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzrk) zzd.zza(parcel, zzrk.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedArray(zzc, 1);
            } else if (i == 2) {
                start();
                parcel2.writeNoException();
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

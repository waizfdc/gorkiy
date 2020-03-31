package com.google.firebase.ml.vision.objects.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.firebase_ml.zza;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public abstract class zzd extends zza implements zza {
    public zzd() {
        super("com.google.firebase.ml.vision.objects.internal.IObjectDetectorCreator");
    }

    public static zza asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.ml.vision.objects.internal.IObjectDetectorCreator");
        if (queryLocalInterface instanceof zza) {
            return (zza) queryLocalInterface;
        }
        return new zzc(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        IObjectDetector newObjectDetector = newObjectDetector(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (ObjectDetectorOptionsParcel) com.google.android.gms.internal.firebase_ml.zzd.zza(parcel, ObjectDetectorOptionsParcel.CREATOR));
        parcel2.writeNoException();
        com.google.android.gms.internal.firebase_ml.zzd.zza(parcel2, newObjectDetector);
        return true;
    }
}

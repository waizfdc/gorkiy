package com.google.firebase.ml.vision.barcode.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.firebase_ml.zza;
import com.google.android.gms.internal.firebase_ml.zzd;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public abstract class zzj extends zza implements zzg {
    public zzj() {
        super("com.google.firebase.ml.vision.barcode.internal.IBarcodeDetectorCreator");
    }

    public static zzg asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.ml.vision.barcode.internal.IBarcodeDetectorCreator");
        if (queryLocalInterface instanceof zzg) {
            return (zzg) queryLocalInterface;
        }
        return new zzi(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        IBarcodeDetector newBarcodeDetector = newBarcodeDetector((BarcodeDetectorOptionsParcel) zzd.zza(parcel, BarcodeDetectorOptionsParcel.CREATOR));
        parcel2.writeNoException();
        zzd.zza(parcel2, newBarcodeDetector);
        return true;
    }
}

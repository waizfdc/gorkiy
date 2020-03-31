package com.google.firebase.ml.vision.barcode.internal;

import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public interface zzg extends IInterface {
    IBarcodeDetector newBarcodeDetector(BarcodeDetectorOptionsParcel barcodeDetectorOptionsParcel) throws RemoteException;
}

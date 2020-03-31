package com.google.firebase.ml.vision.objects.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public interface zza extends IInterface {
    IObjectDetector newObjectDetector(IObjectWrapper iObjectWrapper, ObjectDetectorOptionsParcel objectDetectorOptionsParcel) throws RemoteException;
}

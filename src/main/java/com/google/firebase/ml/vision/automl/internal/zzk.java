package com.google.firebase.ml.vision.automl.internal;

import android.os.IBinder;
import com.google.android.gms.internal.firebase_ml.zzb;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzk extends zzb implements zzi {
    zzk(IBinder iBinder) {
        super(iBinder, "com.google.firebase.ml.vision.automl.internal.IOnDeviceAutoMLImageLabelerCreator");
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.firebase.ml.vision.automl.internal.IOnDeviceAutoMLImageLabeler newOnDeviceAutoMLImageLabeler(com.google.android.gms.dynamic.IObjectWrapper r3, com.google.firebase.ml.vision.automl.internal.OnDeviceAutoMLImageLabelerOptionsParcel r4) throws android.os.RemoteException {
        /*
            r2 = this;
            android.os.Parcel r0 = r2.obtainAndWriteInterfaceToken()
            com.google.android.gms.internal.firebase_ml.zzd.zza(r0, r3)
            com.google.android.gms.internal.firebase_ml.zzd.zza(r0, r4)
            r3 = 1
            android.os.Parcel r3 = r2.transactAndReadException(r3, r0)
            android.os.IBinder r4 = r3.readStrongBinder()
            if (r4 != 0) goto L_0x0017
            r4 = 0
            goto L_0x002b
        L_0x0017:
            java.lang.String r0 = "com.google.firebase.ml.vision.automl.internal.IOnDeviceAutoMLImageLabeler"
            android.os.IInterface r0 = r4.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.firebase.ml.vision.automl.internal.IOnDeviceAutoMLImageLabeler
            if (r1 == 0) goto L_0x0025
            r4 = r0
            com.google.firebase.ml.vision.automl.internal.IOnDeviceAutoMLImageLabeler r4 = (com.google.firebase.ml.vision.automl.internal.IOnDeviceAutoMLImageLabeler) r4
            goto L_0x002b
        L_0x0025:
            com.google.firebase.ml.vision.automl.internal.zzg r0 = new com.google.firebase.ml.vision.automl.internal.zzg
            r0.<init>(r4)
            r4 = r0
        L_0x002b:
            r3.recycle()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.ml.vision.automl.internal.zzk.newOnDeviceAutoMLImageLabeler(com.google.android.gms.dynamic.IObjectWrapper, com.google.firebase.ml.vision.automl.internal.OnDeviceAutoMLImageLabelerOptionsParcel):com.google.firebase.ml.vision.automl.internal.IOnDeviceAutoMLImageLabeler");
    }
}

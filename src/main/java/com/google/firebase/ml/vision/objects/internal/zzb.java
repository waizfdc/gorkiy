package com.google.firebase.ml.vision.objects.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.firebase_ml.zzd;
import com.google.android.gms.internal.firebase_ml.zzrk;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzb extends com.google.android.gms.internal.firebase_ml.zzb implements IObjectDetector {
    zzb(IBinder iBinder) {
        super(iBinder, "com.google.firebase.ml.vision.objects.internal.IObjectDetector");
    }

    public final zzh[] zzc(IObjectWrapper iObjectWrapper, zzrk zzrk) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzd.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzd.zza(obtainAndWriteInterfaceToken, zzrk);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzh[] zzhArr = (zzh[]) transactAndReadException.createTypedArray(zzh.CREATOR);
        transactAndReadException.recycle();
        return zzhArr;
    }

    public final void start() throws RemoteException {
        transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken());
    }

    public final void stop() throws RemoteException {
        transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken());
    }
}

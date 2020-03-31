package com.google.firebase.ml.vision.automl.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.firebase_ml.zzb;
import com.google.android.gms.internal.firebase_ml.zzd;
import com.google.android.gms.internal.firebase_ml.zzrk;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzg extends zzb implements IOnDeviceAutoMLImageLabeler {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.firebase.ml.vision.automl.internal.IOnDeviceAutoMLImageLabeler");
    }

    public final zzj[] zza(IObjectWrapper iObjectWrapper, zzrk zzrk) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzd.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzd.zza(obtainAndWriteInterfaceToken, zzrk);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzj[] zzjArr = (zzj[]) transactAndReadException.createTypedArray(zzj.CREATOR);
        transactAndReadException.recycle();
        return zzjArr;
    }

    public final void zznu() throws RemoteException {
        transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken());
    }

    public final void close() throws RemoteException {
        transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken());
    }

    public final boolean zzod() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
        boolean zza = zzd.zza(transactAndReadException);
        transactAndReadException.recycle();
        return zza;
    }
}

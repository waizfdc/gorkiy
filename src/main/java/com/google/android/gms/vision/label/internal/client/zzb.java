package com.google.android.gms.vision.label.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzd;

/* compiled from: com.google.android.gms:play-services-vision-image-label@@18.0.1 */
public final class zzb extends com.google.android.gms.internal.vision.zzb implements INativeImageLabeler {
    zzb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.label.internal.client.INativeImageLabeler");
    }

    public final zzf[] zza(IObjectWrapper iObjectWrapper, LabelOptions labelOptions) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzd.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzd.zza(obtainAndWriteInterfaceToken, labelOptions);
        Parcel zza = zza(1, obtainAndWriteInterfaceToken);
        zzf[] zzfArr = (zzf[]) zza.createTypedArray(zzf.CREATOR);
        zza.recycle();
        return zzfArr;
    }

    public final void zzq() throws RemoteException {
        zzb(2, obtainAndWriteInterfaceToken());
    }
}

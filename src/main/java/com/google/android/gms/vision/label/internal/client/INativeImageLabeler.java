package com.google.android.gms.vision.label.internal.client;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzd;

/* compiled from: com.google.android.gms:play-services-vision-image-label@@18.0.1 */
public interface INativeImageLabeler extends IInterface {
    zzf[] zza(IObjectWrapper iObjectWrapper, LabelOptions labelOptions) throws RemoteException;

    void zzq() throws RemoteException;

    /* compiled from: com.google.android.gms:play-services-vision-image-label@@18.0.1 */
    public static abstract class zza extends com.google.android.gms.internal.vision.zza implements INativeImageLabeler {
        public zza() {
            super("com.google.android.gms.vision.label.internal.client.INativeImageLabeler");
        }

        /* access modifiers changed from: protected */
        public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                zzf[] zza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (LabelOptions) zzd.zza(parcel, LabelOptions.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedArray(zza, 1);
            } else if (i != 2) {
                return false;
            } else {
                zzq();
                parcel2.writeNoException();
            }
            return true;
        }
    }
}

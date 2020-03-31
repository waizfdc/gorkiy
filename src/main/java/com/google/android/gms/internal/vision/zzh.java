package com.google.android.gms.internal.vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.vision.barcode.Barcode;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-vision@@19.0.0 */
public final class zzh extends zzn<zzg> {
    private final zzf zzbl;

    public zzh(Context context, zzf zzf) {
        super(context, "BarcodeNativeHandle", "barcode");
        this.zzbl = zzf;
        zzp();
    }

    public final Barcode[] zza(ByteBuffer byteBuffer, zzp zzp) {
        if (!isOperational()) {
            return new Barcode[0];
        }
        try {
            return ((zzg) zzp()).zza(ObjectWrapper.wrap(byteBuffer), zzp);
        } catch (RemoteException e) {
            Log.e("BarcodeNativeHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    public final Barcode[] zza(Bitmap bitmap, zzp zzp) {
        if (!isOperational()) {
            return new Barcode[0];
        }
        try {
            return ((zzg) zzp()).zzb(ObjectWrapper.wrap(bitmap), zzp);
        } catch (RemoteException e) {
            Log.e("BarcodeNativeHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    /* access modifiers changed from: protected */
    public final void zzn() throws RemoteException {
        if (isOperational()) {
            ((zzg) zzp()).zzm();
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException {
        zzi zzi;
        IBinder instantiate = dynamiteModule.instantiate("com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator");
        if (instantiate == null) {
            zzi = null;
        } else {
            IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
            if (queryLocalInterface instanceof zzi) {
                zzi = (zzi) queryLocalInterface;
            } else {
                zzi = new zzk(instantiate);
            }
        }
        if (zzi == null) {
            return null;
        }
        return zzi.zza(ObjectWrapper.wrap(context), this.zzbl);
    }
}

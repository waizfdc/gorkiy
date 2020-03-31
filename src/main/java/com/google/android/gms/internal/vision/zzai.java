package com.google.android.gms.internal.vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-vision@@19.0.0 */
public final class zzai extends zzn<zzy> {
    private final zzah zzef;

    public zzai(Context context, zzah zzah) {
        super(context, "TextNativeHandle", "ocr");
        this.zzef = zzah;
        zzp();
    }

    public final zzac[] zza(Bitmap bitmap, zzp zzp, zzae zzae) {
        if (!isOperational()) {
            return new zzac[0];
        }
        try {
            return ((zzy) zzp()).zza(ObjectWrapper.wrap(bitmap), zzp, zzae);
        } catch (RemoteException e) {
            Log.e("TextNativeHandle", "Error calling native text recognizer", e);
            return new zzac[0];
        }
    }

    /* access modifiers changed from: protected */
    public final void zzn() throws RemoteException {
        ((zzy) zzp()).zzq();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException {
        zzaa zzaa;
        IBinder instantiate = dynamiteModule.instantiate("com.google.android.gms.vision.text.ChimeraNativeTextRecognizerCreator");
        if (instantiate == null) {
            zzaa = null;
        } else {
            IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
            if (queryLocalInterface instanceof zzaa) {
                zzaa = (zzaa) queryLocalInterface;
            } else {
                zzaa = new zzz(instantiate);
            }
        }
        if (zzaa == null) {
            return null;
        }
        return zzaa.zza(ObjectWrapper.wrap(context), this.zzef);
    }
}

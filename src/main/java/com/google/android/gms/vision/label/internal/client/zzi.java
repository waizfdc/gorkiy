package com.google.android.gms.vision.label.internal.client;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.vision.zzn;
import com.google.android.gms.internal.vision.zzr;
import com.google.android.gms.vision.label.ImageLabel;

/* compiled from: com.google.android.gms:play-services-vision-image-label@@18.0.1 */
public final class zzi extends zzn<INativeImageLabeler> {
    private ImageLabelerOptions zzdp;

    public zzi(Context context, ImageLabelerOptions imageLabelerOptions) {
        super(context, "LabelerNativeHandle", "ica");
        this.zzdp = imageLabelerOptions;
        zzp();
    }

    public final ImageLabel[] zza(Bitmap bitmap, LabelOptions labelOptions) {
        if (!isOperational()) {
            return new ImageLabel[0];
        }
        try {
            zzf[] zza = ((INativeImageLabeler) zzp()).zza(ObjectWrapper.wrap(bitmap), labelOptions);
            ImageLabel[] imageLabelArr = new ImageLabel[zza.length];
            for (int i = 0; i != zza.length; i++) {
                imageLabelArr[i] = new ImageLabel(zza[i].zzdn, zza[i].label, zza[i].zzdo);
            }
            return imageLabelArr;
        } catch (RemoteException e) {
            Log.e("LabelerNativeHandle", "Error calling native image labeler", e);
            return new ImageLabel[0];
        }
    }

    /* access modifiers changed from: protected */
    public final void zzn() throws RemoteException {
        ((INativeImageLabeler) zzp()).zzq();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException {
        zza zza;
        if (zzr.zza(context, "com.google.android.gms.vision.dynamite.ica")) {
            zza = zzd.asInterface(dynamiteModule.instantiate("com.google.android.gms.vision.label.NativeImageLabelerCreator"));
        } else {
            zza = zzd.asInterface(dynamiteModule.instantiate("com.google.android.gms.vision.label.ChimeraNativeImageLabelerCreator"));
        }
        if (zza == null) {
            return null;
        }
        return zza.newImageLabeler(ObjectWrapper.wrap(context), this.zzdp);
    }
}

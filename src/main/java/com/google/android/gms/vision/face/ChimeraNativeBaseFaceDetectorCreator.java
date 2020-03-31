package com.google.android.gms.vision.face;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.zzbe;
import com.google.android.gms.internal.vision.zzea;
import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.clearcut.LogUtils;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.internal.client.zzh;
import com.google.android.gms.vision.face.internal.client.zzl;

/* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
public abstract class ChimeraNativeBaseFaceDetectorCreator extends zzl {
    /* access modifiers changed from: protected */
    public abstract zzh zza(Context context, Context context2, DynamiteClearcutLogger dynamiteClearcutLogger, zzf zzf) throws RemoteException;

    public zzh newFaceDetector(IObjectWrapper iObjectWrapper, zzf zzf) throws RemoteException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzbe.maybeInit(context);
        DynamiteClearcutLogger dynamiteClearcutLogger = new DynamiteClearcutLogger(context);
        try {
            zzh zza = zza(context, context, dynamiteClearcutLogger, zzf);
            if (zza != null) {
                zza(dynamiteClearcutLogger, context, zzf, null, SystemClock.elapsedRealtime() - elapsedRealtime);
            }
            return zza;
        } catch (RemoteException e) {
            String message = e.getMessage();
            throw e;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (0 != 0) {
                zza(dynamiteClearcutLogger, context, zzf, null, SystemClock.elapsedRealtime() - elapsedRealtime);
            }
            throw th2;
        }
    }

    private static void zza(DynamiteClearcutLogger dynamiteClearcutLogger, Context context, zzf zzf, String str, long j) {
        zzea.zzg.zzb zzcs = zzea.zzg.zzcs();
        if (zzf.mode == 1) {
            zzcs.zzb(zzea.zzg.zzd.MODE_ACCURATE);
        } else if (zzf.mode == 0) {
            zzcs.zzb(zzea.zzg.zzd.MODE_FAST);
        } else if (zzf.mode == 2) {
            zzcs.zzb(zzea.zzg.zzd.MODE_SELFIE);
        }
        if (zzf.landmarkType == 1) {
            zzcs.zzb(zzea.zzg.zzc.LANDMARK_ALL);
        } else if (zzf.landmarkType == 0) {
            zzcs.zzb(zzea.zzg.zzc.LANDMARK_NONE);
        } else if (zzf.landmarkType == 2) {
            zzcs.zzb(zzea.zzg.zzc.LANDMARK_CONTOUR);
        }
        if (zzf.zzco == 1) {
            zzcs.zzb(zzea.zzg.zza.CLASSIFICATION_ALL);
        } else if (zzf.zzco == 0) {
            zzcs.zzb(zzea.zzg.zza.CLASSIFICATION_NONE);
        }
        zzcs.zzh(zzf.zzcn).zzi(zzf.trackingEnabled).zzf(zzf.proportionalMinFaceSize);
        zzea.zzk.zza zza = zzea.zzk.zzdb().zzt("face").zzq(j).zza(zzcs);
        if (str != null) {
            zza.zzu(str);
        }
        zza.zzb(LogUtils.zza(context));
        dynamiteClearcutLogger.zza(2, (zzea.zzo) ((zzgs) zzea.zzo.zzdi().zza(zza).zzgc()));
    }
}

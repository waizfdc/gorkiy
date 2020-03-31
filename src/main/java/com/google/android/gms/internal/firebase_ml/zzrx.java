package com.google.android.gms.internal.firebase_ml;

import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.vision.Frame;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.common.internal.modeldownload.zzn;
import com.google.firebase.ml.common.internal.modeldownload.zzt;
import com.google.firebase.ml.vision.automl.FirebaseAutoMLLocalModel;
import com.google.firebase.ml.vision.automl.FirebaseAutoMLRemoteModel;
import com.google.firebase.ml.vision.automl.internal.IOnDeviceAutoMLImageLabeler;
import com.google.firebase.ml.vision.automl.internal.OnDeviceAutoMLImageLabelerOptionsParcel;
import com.google.firebase.ml.vision.automl.internal.zzh;
import com.google.firebase.ml.vision.automl.internal.zzi;
import com.google.firebase.ml.vision.automl.internal.zzj;
import com.google.firebase.ml.vision.label.FirebaseVisionImageLabel;
import com.google.firebase.ml.vision.label.FirebaseVisionOnDeviceAutoMLImageLabelerOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzrx implements zzpc<List<FirebaseVisionImageLabel>, zzrl>, zzpx {
    private static final AtomicBoolean zzbhb = new AtomicBoolean(true);
    private final zzpn zzbdc;
    private final zzpo zzbfe;
    private final AtomicBoolean zzbhe = new AtomicBoolean(false);
    private final FirebaseAutoMLLocalModel zzbia;
    private final FirebaseAutoMLRemoteModel zzbiq;
    private final FirebaseVisionOnDeviceAutoMLImageLabelerOptions zzbnd;
    private IOnDeviceAutoMLImageLabeler zzbne;

    zzrx(zzpn zzpn, FirebaseVisionOnDeviceAutoMLImageLabelerOptions firebaseVisionOnDeviceAutoMLImageLabelerOptions) {
        this.zzbdc = zzpn;
        this.zzbnd = firebaseVisionOnDeviceAutoMLImageLabelerOptions;
        this.zzbfe = zzpo.zza(zzpn, 5);
        this.zzbiq = firebaseVisionOnDeviceAutoMLImageLabelerOptions.zzqd();
        this.zzbia = firebaseVisionOnDeviceAutoMLImageLabelerOptions.zzqc();
    }

    public final zzpx zznl() {
        return this;
    }

    /* access modifiers changed from: private */
    public final synchronized List<FirebaseVisionImageLabel> zza(zzrl zzrl) throws FirebaseMLException {
        zzrl zzrl2 = zzrl;
        synchronized (this) {
            Preconditions.checkNotNull(zzrl2, "Mobile vision input can not be null");
            Preconditions.checkNotNull(zzrl2.zzbkx, "Input frame can not be null");
            boolean z = this.zzbhe.get();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.zzbne == null) {
                zza(zznq.UNKNOWN_ERROR, elapsedRealtime, z, zzrl);
                Log.e("ODAutoMLImgLabelerTask", "On device AutoML Image Labeler is not initialized.");
                throw new FirebaseMLException("Image labeler not initialized.", 13);
            } else if (zzrl2.zzbkx.getBitmap() != null) {
                try {
                    IObjectWrapper wrap = ObjectWrapper.wrap(zzrl2.zzbkx.getBitmap());
                    IOnDeviceAutoMLImageLabeler iOnDeviceAutoMLImageLabeler = this.zzbne;
                    Frame.Metadata metadata = zzrl2.zzbkx.getMetadata();
                    zzrk zzrk = r9;
                    zzrk zzrk2 = new zzrk(metadata.getWidth(), metadata.getHeight(), metadata.getId(), metadata.getTimestampMillis(), metadata.getRotation());
                    zzj[] zza = iOnDeviceAutoMLImageLabeler.zza(wrap, zzrk);
                    zza(zznq.NO_ERROR, elapsedRealtime, z, zzrl);
                    if (zza == null) {
                        ArrayList arrayList = new ArrayList();
                        return arrayList;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (zzj zza2 : zza) {
                        arrayList2.add(FirebaseVisionImageLabel.zza(zza2));
                    }
                    zzbhb.set(false);
                    return arrayList2;
                } catch (RemoteException e) {
                    zza(zznq.UNKNOWN_ERROR, elapsedRealtime, z, zzrl);
                    Log.e("ODAutoMLImgLabelerTask", "Error calling on device auto ml inference.", e);
                    throw new FirebaseMLException("Cannot run on device automl image labeler.", 13, e);
                }
            } else {
                Log.e("ODAutoMLImgLabelerTask", "No image data found.");
                throw new FirebaseMLException("No image data found.", 3);
            }
        }
    }

    public final synchronized void zznu() throws FirebaseMLException {
        String str;
        try {
            if (this.zzbne == null) {
                zzi asInterface = zzh.asInterface(DynamiteModule.load(this.zzbdc.getApplicationContext(), DynamiteModule.PREFER_LOCAL, "com.google.firebase.ml.vision.dynamite.automl").instantiate("com.google.firebase.ml.vision.automl.OnDeviceAutoMLImageLabelerCreator"));
                if (asInterface != null) {
                    IObjectWrapper wrap = ObjectWrapper.wrap(this.zzbdc);
                    FirebaseVisionOnDeviceAutoMLImageLabelerOptions firebaseVisionOnDeviceAutoMLImageLabelerOptions = this.zzbnd;
                    String str2 = null;
                    String modelName = firebaseVisionOnDeviceAutoMLImageLabelerOptions.zzqd() != null ? firebaseVisionOnDeviceAutoMLImageLabelerOptions.zzqd().getModelName() : null;
                    if (firebaseVisionOnDeviceAutoMLImageLabelerOptions.zzqc() != null) {
                        if (firebaseVisionOnDeviceAutoMLImageLabelerOptions.zzqc().getAssetFilePath() != null) {
                            str = null;
                            str2 = firebaseVisionOnDeviceAutoMLImageLabelerOptions.zzqc().getAssetFilePath();
                        } else if (firebaseVisionOnDeviceAutoMLImageLabelerOptions.zzqc().getFilePath() != null) {
                            str = firebaseVisionOnDeviceAutoMLImageLabelerOptions.zzqc().getFilePath();
                        }
                        this.zzbne = asInterface.newOnDeviceAutoMLImageLabeler(wrap, new OnDeviceAutoMLImageLabelerOptionsParcel(firebaseVisionOnDeviceAutoMLImageLabelerOptions.getConfidenceThreshold(), modelName, str2, str));
                    }
                    str = null;
                    this.zzbne = asInterface.newOnDeviceAutoMLImageLabeler(wrap, new OnDeviceAutoMLImageLabelerOptionsParcel(firebaseVisionOnDeviceAutoMLImageLabelerOptions.getConfidenceThreshold(), modelName, str2, str));
                } else {
                    Log.e("ODAutoMLImgLabelerTask", "Error when creating on device AutoML Image Labeler creator.");
                    throw new FirebaseMLException("Can not create on device AutoML Image Labeler.", 14);
                }
            }
            this.zzbne.zznu();
            this.zzbhe.set(this.zzbne.zzod());
        } catch (DynamiteModule.LoadingException e) {
            Log.e("ODAutoMLImgLabelerTask", "Error when loading automl module.", e);
            throw new FirebaseMLException("Cannot load automl module. Please add dependency firebase-ml-vision-automl.", 14);
        } catch (RemoteException e2) {
            Log.e("ODAutoMLImgLabelerTask", "Error when creating on device AutoML Image Labeler.", e2);
            throw new FirebaseMLException("Can not create on device AutoML Image Labeler.", 14, e2);
        } catch (RemoteException e3) {
            Log.e("ODAutoMLImgLabelerTask", "Error while loading the AutoML image labeling model.", e3);
            throw new FirebaseMLException("Cannot load the AutoML image labeling model.", 14, e3);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void release() {
        try {
            if (this.zzbne != null) {
                this.zzbne.close();
            }
            zzbhb.set(true);
        } catch (RemoteException e) {
            Log.e("ODAutoMLImgLabelerTask", "Error closing on device AutoML Image Labeler", e);
        }
    }

    private final void zza(zznq zznq, long j, boolean z, zzrl zzrl) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zzbfe.zza(new zzrw(this, elapsedRealtime, zznq, zzrl, z), zznu.AUTOML_IMAGE_LABELING_RUN);
        zzpu zzpu = zzry.zzbhp;
        this.zzbfe.zza((zzng.zza.C0008zza) ((zzvx) zzng.zza.C0008zza.zzjo().zzb(zznq).zzn(zzbhb.get()).zzb(zzrf.zzb(zzrl)).zztx()), elapsedRealtime, zznu.AGGREGATED_AUTO_ML_IMAGE_LABELING_INFERENCE, zzpu);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzng.zzab.zza zza(long j, zznq zznq, zzrl zzrl, boolean z) {
        FirebaseAutoMLRemoteModel firebaseAutoMLRemoteModel;
        zzng.zzi.zza zzh = zzng.zzi.zzkk().zza(zzng.zzad.zzlr().zzj(j).zzk(zznq).zzae(zzbhb.get()).zzaf(true).zzag(true)).zzh(zzrf.zzb(zzrl));
        if (!z || (firebaseAutoMLRemoteModel = this.zzbiq) == null) {
            FirebaseAutoMLLocalModel firebaseAutoMLLocalModel = this.zzbia;
            if (firebaseAutoMLLocalModel != null) {
                zzh.zzd(firebaseAutoMLLocalModel.zza(zzn.AUTOML));
            }
        } else {
            zzh.zzd(zzt.zza(firebaseAutoMLRemoteModel, zzn.AUTOML));
        }
        return zzng.zzab.zzln().zza(zzh);
    }
}

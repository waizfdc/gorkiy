package com.google.firebase.ml.vision.objects.internal;

import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.firebase_ml.zzmr;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zznq;
import com.google.android.gms.internal.firebase_ml.zznu;
import com.google.android.gms.internal.firebase_ml.zzpc;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.android.gms.internal.firebase_ml.zzpo;
import com.google.android.gms.internal.firebase_ml.zzpu;
import com.google.android.gms.internal.firebase_ml.zzpx;
import com.google.android.gms.internal.firebase_ml.zzrf;
import com.google.android.gms.internal.firebase_ml.zzrk;
import com.google.android.gms.internal.firebase_ml.zzrl;
import com.google.android.gms.internal.firebase_ml.zzvx;
import com.google.android.gms.vision.Frame;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.vision.objects.FirebaseVisionObject;
import com.google.firebase.ml.vision.objects.FirebaseVisionObjectDetectorOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzg implements zzpc<List<FirebaseVisionObject>, zzrl>, zzpx {
    private static final AtomicBoolean zzbhb = new AtomicBoolean(true);
    private final zzpn zzbdc;
    private final zzpo zzbfe;
    private final FirebaseVisionObjectDetectorOptions zzbnp;
    private long zzbnq = -1;
    private final zzng.zzaq zzbnr;
    private IObjectDetector zzbns;

    public zzg(zzpn zzpn, FirebaseVisionObjectDetectorOptions firebaseVisionObjectDetectorOptions) {
        zzng.zzaq.zzb zzb;
        Preconditions.checkNotNull(zzpn, "Context can not be null");
        Preconditions.checkNotNull(firebaseVisionObjectDetectorOptions, "FirebaseVisionObjectDetectorOptions can not be null");
        this.zzbnp = firebaseVisionObjectDetectorOptions;
        this.zzbdc = zzpn;
        this.zzbfe = zzpo.zza(zzpn, 1);
        zzng.zzaq.zza zzmu = zzng.zzaq.zzmu();
        int zzqf = firebaseVisionObjectDetectorOptions.zzqf();
        if (zzqf == 1) {
            zzb = zzng.zzaq.zzb.STREAM;
        } else if (zzqf != 2) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Unexpected detector mode: ");
            sb.append(zzqf);
            Log.e("ObjectDetectorTask", sb.toString());
            zzb = zzng.zzaq.zzb.MODE_UNSPECIFIED;
        } else {
            zzb = zzng.zzaq.zzb.SINGLE_IMAGE;
        }
        this.zzbnr = (zzng.zzaq) ((zzvx) zzmu.zza(zzb).zzam(firebaseVisionObjectDetectorOptions.zzqh()).zzan(firebaseVisionObjectDetectorOptions.zzqg()).zztx());
        this.zzbfe.zza(zzng.zzab.zzln().zza(zzng.zzap.zzms().zzc(this.zzbnr).zzm(zznq.NO_ERROR)), zznu.ON_DEVICE_OBJECT_CREATE);
    }

    public final zzpx zznl() {
        return this;
    }

    /* access modifiers changed from: private */
    public final synchronized List<FirebaseVisionObject> zza(zzrl zzrl) throws FirebaseMLException {
        zzrl zzrl2 = zzrl;
        synchronized (this) {
            Preconditions.checkNotNull(zzrl2, "Mobile vision input can not bu null");
            Preconditions.checkNotNull(zzrl2.zzblk, "Input image can not be null");
            Preconditions.checkNotNull(zzrl2.zzbkx, "Input frame can not be null");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                if (this.zzbns == null) {
                    Log.e("ObjectDetectorTask", "Object detector is not initialized.");
                    zzmr zzji = zzmr.zzji();
                    return zzji;
                }
                boolean z = true;
                if (this.zzbnp.zzqf() == 1 && this.zzbnq > 0) {
                    if (elapsedRealtime - this.zzbnq <= 300) {
                        z = false;
                    }
                    if (z) {
                        Log.w("ObjectDetectorTask", "Object detector pipeline is reset.");
                        zzqj();
                    }
                }
                this.zzbnq = elapsedRealtime;
                IObjectWrapper wrap = ObjectWrapper.wrap(zzrl2.zzbkx);
                IObjectDetector iObjectDetector = this.zzbns;
                Frame.Metadata metadata = zzrl2.zzbkx.getMetadata();
                zzh[] zzc = iObjectDetector.zzc(wrap, new zzrk(metadata.getWidth(), metadata.getHeight(), metadata.getId(), metadata.getTimestampMillis(), metadata.getRotation()));
                ArrayList arrayList = new ArrayList();
                for (zzh firebaseVisionObject : zzc) {
                    arrayList.add(new FirebaseVisionObject(firebaseVisionObject));
                }
                zza(zznq.NO_ERROR, zzrl, arrayList, elapsedRealtime);
                zzbhb.set(false);
                return arrayList;
            } catch (RemoteException e) {
                Log.e("ObjectDetectorTask", "Error calling object detector inference", e);
                zza(zznq.UNKNOWN_ERROR, zzrl, zzmr.zzji(), elapsedRealtime);
                throw new FirebaseMLException("Cannot run object detector.", 14);
            }
        }
    }

    public final synchronized void zznu() throws FirebaseMLException {
        try {
            if (this.zzbns == null) {
                zza zzqi = zzqi();
                if (zzqi != null) {
                    IObjectWrapper wrap = ObjectWrapper.wrap(this.zzbdc.getApplicationContext());
                    FirebaseVisionObjectDetectorOptions firebaseVisionObjectDetectorOptions = this.zzbnp;
                    this.zzbns = zzqi.newObjectDetector(wrap, new ObjectDetectorOptionsParcel(firebaseVisionObjectDetectorOptions.zzqf(), firebaseVisionObjectDetectorOptions.zzqh(), firebaseVisionObjectDetectorOptions.zzqg()));
                    zzp(zznq.NO_ERROR);
                } else {
                    Log.e("ObjectDetectorTask", "Error when creating object detector creator");
                    zzp(zznq.UNKNOWN_ERROR);
                    throw new FirebaseMLException("Cannot load object detector module.", 14);
                }
            }
            this.zzbns.start();
        } catch (RemoteException e) {
            Log.e("ObjectDetectorTask", "Error when creating object detector");
            zzp(zznq.UNKNOWN_ERROR);
            throw new FirebaseMLException("Can not create ObjectDetector", 14, e);
        }
    }

    private final zza zzqi() throws FirebaseMLException {
        try {
            return zzd.asInterface(DynamiteModule.load(this.zzbdc.getApplicationContext(), DynamiteModule.PREFER_LOCAL, "com.google.firebase.ml.vision.dynamite.objects").instantiate("com.google.firebase.ml.vision.objects.ObjectDetectorCreator"));
        } catch (DynamiteModule.LoadingException e) {
            Log.e("ObjectDetectorTask", "Error when loading object detector module");
            throw new FirebaseMLException("Cannot load object detector module.", 14, e);
        }
    }

    private final synchronized void zzqj() {
        try {
            if (this.zzbns != null) {
                this.zzbns.stop();
            }
        } catch (RemoteException e) {
            Log.e("ObjectDetectorTask", "Error calling object detector stop", e);
        }
        try {
            if (this.zzbns != null) {
                this.zzbns.start();
            }
        } catch (RemoteException e2) {
            Log.e("ObjectDetectorTask", "Error calling object detector restart", e2);
        }
        zzbhb.set(true);
        return;
    }

    public final synchronized void release() {
        try {
            if (this.zzbns != null) {
                this.zzbns.stop();
            }
            zzbhb.set(true);
            this.zzbfe.zza(zzng.zzab.zzln(), zznu.ON_DEVICE_OBJECT_CLOSE);
        } catch (RemoteException e) {
            Log.e("ObjectDetectorTask", "Error calling object detector stop", e);
        }
    }

    private final void zzp(zznq zznq) {
        this.zzbfe.zza(zzng.zzab.zzln().zza(zzng.zzas.zzmy().zze(this.zzbnr).zzn(zznq)), zznu.ON_DEVICE_OBJECT_LOAD);
    }

    private final void zza(zznq zznq, zzrl zzrl, List<FirebaseVisionObject> list, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zzbfe.zza(new zzf(this, list, elapsedRealtime, zznq, zzrl), zznu.ON_DEVICE_OBJECT_INFERENCE);
        zzpu zzpu = zzi.zzbhp;
        this.zzbfe.zza((zzng.zzf.zza) ((zzvx) zzng.zzf.zza.zzkd().zzb(this.zzbnr).zzg(zznq).zzu(zzbhb.get()).zzf(zzrf.zzb(zzrl)).zzt(!list.isEmpty()).zztx()), elapsedRealtime, zznu.AGGREGATED_ON_DEVICE_OBJECT_INFERENCE, zzpu);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzng.zzab.zza zza(List list, long j, zznq zznq, zzrl zzrl) {
        zzng.zzaj.zza zza;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            FirebaseVisionObject firebaseVisionObject = (FirebaseVisionObject) it.next();
            zzng.zzaj.zzb zzme = zzng.zzaj.zzme();
            int classificationCategory = firebaseVisionObject.getClassificationCategory();
            if (classificationCategory == 0) {
                zza = zzng.zzaj.zza.CATEGORY_UNKNOWN;
            } else if (classificationCategory == 1) {
                zza = zzng.zzaj.zza.CATEGORY_HOME_GOOD;
            } else if (classificationCategory == 2) {
                zza = zzng.zzaj.zza.CATEGORY_FASHION_GOOD;
            } else if (classificationCategory == 3) {
                zza = zzng.zzaj.zza.CATEGORY_FOOD;
            } else if (classificationCategory == 4) {
                zza = zzng.zzaj.zza.CATEGORY_PLACE;
            } else if (classificationCategory != 5) {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Unexpected category: ");
                sb.append(classificationCategory);
                Log.e("ObjectDetectorTask", sb.toString());
                zza = zzng.zzaj.zza.CATEGORY_UNKNOWN;
            } else {
                zza = zzng.zzaj.zza.CATEGORY_PLANT;
            }
            zzng.zzaj.zzb zzb = zzme.zzb(zza);
            if (firebaseVisionObject.getClassificationConfidence() != null) {
                zzb.zzn(firebaseVisionObject.getClassificationConfidence().floatValue());
            }
            if (firebaseVisionObject.getTrackingId() != null) {
                zzb.zzbj(firebaseVisionObject.getTrackingId().intValue());
            }
            arrayList.add((zzng.zzaj) ((zzvx) zzb.zztx()));
        }
        return zzng.zzab.zzln().zza(zzng.zzar.zzmw().zzf(zzng.zzad.zzlr().zzj(j).zzk(zznq).zzae(zzbhb.get()).zzaf(true).zzag(true)).zzl(zzrf.zzb(zzrl)).zzd(this.zzbnr).zzv(arrayList));
    }
}

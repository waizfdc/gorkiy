package com.google.firebase.ml.vision.cloud.landmark;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzkd;
import com.google.android.gms.internal.firebase_ml.zzkn;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zznu;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.android.gms.internal.firebase_ml.zzpo;
import com.google.android.gms.internal.firebase_ml.zzpp;
import com.google.android.gms.internal.firebase_ml.zzra;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.cloud.FirebaseVisionCloudDetectorOptions;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionCloudLandmarkDetector extends zzra<List<FirebaseVisionCloudLandmark>> {
    private static final Map<zzpp<FirebaseVisionCloudDetectorOptions>, FirebaseVisionCloudLandmarkDetector> zzbbn = new HashMap();

    public static synchronized FirebaseVisionCloudLandmarkDetector zza(zzpn zzpn, FirebaseVisionCloudDetectorOptions firebaseVisionCloudDetectorOptions) {
        FirebaseVisionCloudLandmarkDetector firebaseVisionCloudLandmarkDetector;
        synchronized (FirebaseVisionCloudLandmarkDetector.class) {
            Preconditions.checkNotNull(zzpn, "MlKitContext must not be null");
            Preconditions.checkNotNull(zzpn.getPersistenceKey(), "Firebase app name must not be null");
            Preconditions.checkNotNull(firebaseVisionCloudDetectorOptions, "Options must not be null");
            zzpp zzj = zzpp.zzj(zzpn.getPersistenceKey(), firebaseVisionCloudDetectorOptions);
            firebaseVisionCloudLandmarkDetector = zzbbn.get(zzj);
            if (firebaseVisionCloudLandmarkDetector == null) {
                firebaseVisionCloudLandmarkDetector = new FirebaseVisionCloudLandmarkDetector(zzpn, firebaseVisionCloudDetectorOptions);
                zzbbn.put(zzj, firebaseVisionCloudLandmarkDetector);
            }
        }
        return firebaseVisionCloudLandmarkDetector;
    }

    /* access modifiers changed from: protected */
    public final int zzpt() {
        return 640;
    }

    /* access modifiers changed from: protected */
    public final int zzpu() {
        return 480;
    }

    private FirebaseVisionCloudLandmarkDetector(zzpn zzpn, FirebaseVisionCloudDetectorOptions firebaseVisionCloudDetectorOptions) {
        super(zzpn, "LANDMARK_DETECTION", firebaseVisionCloudDetectorOptions);
        zzpo.zza(zzpn, 1).zza(zzng.zzab.zzln(), zznu.CLOUD_LANDMARK_CREATE);
    }

    public Task<List<FirebaseVisionCloudLandmark>> detectInImage(FirebaseVisionImage firebaseVisionImage) {
        zzpo.zza(this.zzbdc, 1).zza(zzng.zzab.zzln(), zznu.CLOUD_LANDMARK_DETECT);
        return super.zza(firebaseVisionImage);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zza(zzkd zzkd, float f) {
        if (zzkd.zzih() == null) {
            return new ArrayList();
        }
        float f2 = 1.0f / f;
        List<zzkn> zzih = zzkd.zzih();
        ArrayList arrayList = new ArrayList();
        for (zzkn zza : zzih) {
            FirebaseVisionCloudLandmark zza2 = FirebaseVisionCloudLandmark.zza(zza, f2);
            if (zza2 != null) {
                arrayList.add(zza2);
            }
        }
        return arrayList;
    }
}

package com.google.firebase.ml.vision.face;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zznu;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.android.gms.internal.firebase_ml.zzpo;
import com.google.android.gms.internal.firebase_ml.zzpp;
import com.google.android.gms.internal.firebase_ml.zzri;
import com.google.android.gms.internal.firebase_ml.zzro;
import com.google.android.gms.internal.firebase_ml.zzvx;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionFaceDetector extends zzri<List<FirebaseVisionFace>> implements Closeable {
    private static final Map<zzpp<FirebaseVisionFaceDetectorOptions>, FirebaseVisionFaceDetector> zzbbn = new HashMap();

    public static synchronized FirebaseVisionFaceDetector zza(zzpn zzpn, FirebaseVisionFaceDetectorOptions firebaseVisionFaceDetectorOptions) {
        FirebaseVisionFaceDetector firebaseVisionFaceDetector;
        synchronized (FirebaseVisionFaceDetector.class) {
            Preconditions.checkNotNull(zzpn, "You must provide a valid MlKitContext.");
            Preconditions.checkNotNull(zzpn.getPersistenceKey(), "Persistence key must not be null");
            Preconditions.checkNotNull(zzpn.getApplicationContext(), "You must provide a valid Context.");
            Preconditions.checkNotNull(firebaseVisionFaceDetectorOptions, "You must provide a valid FirebaseVisionFaceDetectorOptions.");
            zzpp zzj = zzpp.zzj(zzpn.getPersistenceKey(), firebaseVisionFaceDetectorOptions);
            firebaseVisionFaceDetector = zzbbn.get(zzj);
            if (firebaseVisionFaceDetector == null) {
                firebaseVisionFaceDetector = new FirebaseVisionFaceDetector(zzpn, firebaseVisionFaceDetectorOptions);
                zzbbn.put(zzj, firebaseVisionFaceDetector);
            }
        }
        return firebaseVisionFaceDetector;
    }

    private FirebaseVisionFaceDetector(zzpn zzpn, FirebaseVisionFaceDetectorOptions firebaseVisionFaceDetectorOptions) {
        super(zzpn, new zzro(zzpn, firebaseVisionFaceDetectorOptions));
        zzpo.zza(zzpn, 1).zza(zzng.zzab.zzln().zzb((zzng.zzal) ((zzvx) zzng.zzal.zzmi().zzc(firebaseVisionFaceDetectorOptions.zzqb()).zztx())), zznu.ON_DEVICE_FACE_CREATE);
    }

    public Task<List<FirebaseVisionFace>> detectInImage(FirebaseVisionImage firebaseVisionImage) {
        return super.zza(firebaseVisionImage, false, true);
    }

    public void close() throws IOException {
        super.close();
    }
}

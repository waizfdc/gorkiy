package com.google.firebase.ml.vision.objects;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.android.gms.internal.firebase_ml.zzpp;
import com.google.android.gms.internal.firebase_ml.zzri;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.objects.internal.zzg;
import java.io.Closeable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionObjectDetector extends zzri<List<FirebaseVisionObject>> implements Closeable {
    private static final Map<zzpp<FirebaseVisionObjectDetectorOptions>, FirebaseVisionObjectDetector> zzbbn = new HashMap();

    public static synchronized FirebaseVisionObjectDetector zza(zzpn zzpn, FirebaseVisionObjectDetectorOptions firebaseVisionObjectDetectorOptions) {
        FirebaseVisionObjectDetector firebaseVisionObjectDetector;
        synchronized (FirebaseVisionObjectDetector.class) {
            Preconditions.checkNotNull(zzpn, "You must provide a valid MlKitContext.");
            Preconditions.checkNotNull(zzpn.getPersistenceKey(), "Firebase app name must not be null");
            Preconditions.checkNotNull(zzpn.getApplicationContext(), "You must provide a valid Context.");
            Preconditions.checkNotNull(firebaseVisionObjectDetectorOptions, "You must provide a valid FirebaseVisionObjectDetectorOptions.");
            zzpp zzj = zzpp.zzj(zzpn.getPersistenceKey(), firebaseVisionObjectDetectorOptions);
            firebaseVisionObjectDetector = zzbbn.get(zzj);
            if (firebaseVisionObjectDetector == null) {
                firebaseVisionObjectDetector = new FirebaseVisionObjectDetector(zzpn, firebaseVisionObjectDetectorOptions);
                zzbbn.put(zzj, firebaseVisionObjectDetector);
            }
        }
        return firebaseVisionObjectDetector;
    }

    private FirebaseVisionObjectDetector(zzpn zzpn, FirebaseVisionObjectDetectorOptions firebaseVisionObjectDetectorOptions) {
        super(zzpn, new zzg(zzpn, firebaseVisionObjectDetectorOptions));
    }

    public Task<List<FirebaseVisionObject>> processImage(FirebaseVisionImage firebaseVisionImage) {
        firebaseVisionImage.zzpw();
        return super.zza(firebaseVisionImage, false, true);
    }
}

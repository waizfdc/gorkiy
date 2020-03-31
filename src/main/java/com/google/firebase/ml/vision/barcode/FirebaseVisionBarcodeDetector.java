package com.google.firebase.ml.vision.barcode;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zznu;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.android.gms.internal.firebase_ml.zzpo;
import com.google.android.gms.internal.firebase_ml.zzpp;
import com.google.android.gms.internal.firebase_ml.zzri;
import com.google.android.gms.internal.firebase_ml.zzvx;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.barcode.internal.zza;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionBarcodeDetector extends zzri<List<FirebaseVisionBarcode>> implements Closeable {
    private static final Map<zzpp<FirebaseVisionBarcodeDetectorOptions>, FirebaseVisionBarcodeDetector> zzbbn = new HashMap();

    public static synchronized FirebaseVisionBarcodeDetector zza(zzpn zzpn, FirebaseVisionBarcodeDetectorOptions firebaseVisionBarcodeDetectorOptions) {
        FirebaseVisionBarcodeDetector firebaseVisionBarcodeDetector;
        synchronized (FirebaseVisionBarcodeDetector.class) {
            Preconditions.checkNotNull(zzpn, "You must provide a valid MlKitContext.");
            Preconditions.checkNotNull(zzpn.getPersistenceKey(), "Firebase app name must not be null");
            Preconditions.checkNotNull(zzpn.getApplicationContext(), "You must provide a valid Context.");
            Preconditions.checkNotNull(firebaseVisionBarcodeDetectorOptions, "You must provide a valid FirebaseVisionBarcodeDetectorOptions.");
            zzpp zzj = zzpp.zzj(zzpn.getPersistenceKey(), firebaseVisionBarcodeDetectorOptions);
            firebaseVisionBarcodeDetector = zzbbn.get(zzj);
            if (firebaseVisionBarcodeDetector == null) {
                firebaseVisionBarcodeDetector = new FirebaseVisionBarcodeDetector(zzpn, firebaseVisionBarcodeDetectorOptions);
                zzbbn.put(zzj, firebaseVisionBarcodeDetector);
            }
        }
        return firebaseVisionBarcodeDetector;
    }

    private FirebaseVisionBarcodeDetector(zzpn zzpn, FirebaseVisionBarcodeDetectorOptions firebaseVisionBarcodeDetectorOptions) {
        super(zzpn, new zza(zzpn, firebaseVisionBarcodeDetectorOptions));
        zzpo.zza(zzpn, 1).zza(zzng.zzab.zzln().zzb((zzng.zzak) ((zzvx) zzng.zzak.zzmg().zzc(firebaseVisionBarcodeDetectorOptions.zzpr()).zztx())), zznu.ON_DEVICE_BARCODE_CREATE);
    }

    public Task<List<FirebaseVisionBarcode>> detectInImage(FirebaseVisionImage firebaseVisionImage) {
        return super.zza(firebaseVisionImage, false, false);
    }

    public void close() throws IOException {
        super.close();
    }
}

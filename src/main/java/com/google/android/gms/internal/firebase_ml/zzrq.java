package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.label.FirebaseVisionImageLabel;
import com.google.firebase.ml.vision.label.FirebaseVisionOnDeviceImageLabelerOptions;
import java.io.Closeable;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzrq extends zzri<List<FirebaseVisionImageLabel>> implements Closeable {
    public zzrq(zzpn zzpn, FirebaseVisionOnDeviceImageLabelerOptions firebaseVisionOnDeviceImageLabelerOptions) {
        super(zzpn, new zzrt(zzpn, firebaseVisionOnDeviceImageLabelerOptions));
        zzpo.zza(zzpn, 1).zza(zzng.zzab.zzln(), zznu.ON_DEVICE_IMAGE_LABEL_CREATE);
    }

    public final Task<List<FirebaseVisionImageLabel>> detectInImage(FirebaseVisionImage firebaseVisionImage) {
        return zza(firebaseVisionImage, true, false);
    }
}

package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.label.FirebaseVisionImageLabel;
import com.google.firebase.ml.vision.label.FirebaseVisionOnDeviceAutoMLImageLabelerOptions;
import java.io.Closeable;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzru extends zzri<List<FirebaseVisionImageLabel>> implements Closeable {
    private final zzpo zzbfe;

    public zzru(zzpn zzpn, FirebaseVisionOnDeviceAutoMLImageLabelerOptions firebaseVisionOnDeviceAutoMLImageLabelerOptions) throws FirebaseMLException {
        super(zzpn, new zzrx(zzpn, firebaseVisionOnDeviceAutoMLImageLabelerOptions));
        this.zzbfe = zzpo.zza(zzpn, 5);
        this.zzbfe.zza(zzng.zzab.zzln().zzb((zzng.zzh) ((zzvx) zzng.zzh.zzki().zzi(zznq.NO_ERROR).zztx())), zznu.AUTOML_IMAGE_LABELING_CREATE);
    }

    public final Task<List<FirebaseVisionImageLabel>> detectInImage(FirebaseVisionImage firebaseVisionImage) {
        return zza(firebaseVisionImage, true, false);
    }
}

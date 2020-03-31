package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionCloudTextRecognizerOptions;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzsa extends zzra<FirebaseVisionText> {
    private static final Map<zzpp<FirebaseVisionCloudTextRecognizerOptions>, zzsa> zzbbn = new HashMap();
    private final FirebaseVisionCloudTextRecognizerOptions zzboc;

    public static synchronized zzsa zza(zzpn zzpn, FirebaseVisionCloudTextRecognizerOptions firebaseVisionCloudTextRecognizerOptions) {
        zzsa zzsa;
        synchronized (zzsa.class) {
            Preconditions.checkNotNull(zzpn, "MlKitContext must not be null");
            Preconditions.checkNotNull(zzpn.getPersistenceKey(), "Persistence key must not be null");
            Preconditions.checkNotNull(firebaseVisionCloudTextRecognizerOptions, "Options must not be null");
            zzpp zzj = zzpp.zzj(zzpn.getPersistenceKey(), firebaseVisionCloudTextRecognizerOptions);
            zzsa = zzbbn.get(zzj);
            if (zzsa == null) {
                zzsa = new zzsa(zzpn, firebaseVisionCloudTextRecognizerOptions);
                zzbbn.put(zzj, zzsa);
            }
        }
        return zzsa;
    }

    /* access modifiers changed from: protected */
    public final int zzpt() {
        return 1024;
    }

    /* access modifiers changed from: protected */
    public final int zzpu() {
        return 768;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzsa(zzpn zzpn, FirebaseVisionCloudTextRecognizerOptions firebaseVisionCloudTextRecognizerOptions) {
        super(zzpn, firebaseVisionCloudTextRecognizerOptions.getModelType() == 1 ? "TEXT_DETECTION" : "DOCUMENT_TEXT_DETECTION", new zzkr(), firebaseVisionCloudTextRecognizerOptions.isEnforceCertFingerprintMatch());
        this.zzboc = firebaseVisionCloudTextRecognizerOptions;
        zzpo.zza(zzpn, 1).zza(zzng.zzab.zzln(), firebaseVisionCloudTextRecognizerOptions.getModelType() == 2 ? zznu.CLOUD_DOCUMENT_TEXT_CREATE : zznu.CLOUD_TEXT_CREATE);
    }

    public final Task<FirebaseVisionText> processImage(FirebaseVisionImage firebaseVisionImage) {
        zznu zznu = zznu.CLOUD_TEXT_DETECT;
        if (this.zzboc.getModelType() == 2) {
            zznu = zznu.CLOUD_DOCUMENT_TEXT_DETECT;
        }
        zzpo.zza(this.zzbdc, 1).zza(zzng.zzab.zzln(), zznu);
        return super.zza(firebaseVisionImage);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zza(zzkd zzkd, float f) {
        return zzsd.zzb(zzkd.zzif(), 1.0f / f);
    }
}

package com.google.firebase.ml.vision.document;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzkd;
import com.google.android.gms.internal.firebase_ml.zzkr;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zznu;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.android.gms.internal.firebase_ml.zzpo;
import com.google.android.gms.internal.firebase_ml.zzpp;
import com.google.android.gms.internal.firebase_ml.zzra;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionDocumentTextRecognizer extends zzra<FirebaseVisionDocumentText> {
    private static final Map<zzpp<FirebaseVisionCloudDocumentRecognizerOptions>, FirebaseVisionDocumentTextRecognizer> zzbbn = new HashMap();

    public static synchronized FirebaseVisionDocumentTextRecognizer zza(zzpn zzpn, FirebaseVisionCloudDocumentRecognizerOptions firebaseVisionCloudDocumentRecognizerOptions) {
        FirebaseVisionDocumentTextRecognizer firebaseVisionDocumentTextRecognizer;
        synchronized (FirebaseVisionDocumentTextRecognizer.class) {
            Preconditions.checkNotNull(zzpn, "MlKitContext must not be null");
            Preconditions.checkNotNull(zzpn.getPersistenceKey(), "Persistence key must not be null");
            Preconditions.checkNotNull(firebaseVisionCloudDocumentRecognizerOptions, "Options must not be null");
            zzpp zzj = zzpp.zzj(zzpn.getPersistenceKey(), firebaseVisionCloudDocumentRecognizerOptions);
            firebaseVisionDocumentTextRecognizer = zzbbn.get(zzj);
            if (firebaseVisionDocumentTextRecognizer == null) {
                zzkr zzkr = new zzkr();
                zzkr.zzd(firebaseVisionCloudDocumentRecognizerOptions.getHintedLanguages());
                FirebaseVisionDocumentTextRecognizer firebaseVisionDocumentTextRecognizer2 = new FirebaseVisionDocumentTextRecognizer(zzpn, zzkr, firebaseVisionCloudDocumentRecognizerOptions.isEnforceCertFingerprintMatch());
                zzbbn.put(zzj, firebaseVisionDocumentTextRecognizer2);
                firebaseVisionDocumentTextRecognizer = firebaseVisionDocumentTextRecognizer2;
            }
        }
        return firebaseVisionDocumentTextRecognizer;
    }

    /* access modifiers changed from: protected */
    public final int zzpt() {
        return 1024;
    }

    /* access modifiers changed from: protected */
    public final int zzpu() {
        return 768;
    }

    private FirebaseVisionDocumentTextRecognizer(zzpn zzpn, zzkr zzkr, boolean z) {
        super(zzpn, "DOCUMENT_TEXT_DETECTION", zzkr, z);
        zzpo.zza(zzpn, 1).zza(zzng.zzab.zzln(), zznu.CLOUD_DOCUMENT_TEXT_CREATE);
    }

    public Task<FirebaseVisionDocumentText> processImage(FirebaseVisionImage firebaseVisionImage) {
        zzpo.zza(this.zzbdc, 1).zza(zzng.zzab.zzln(), zznu.CLOUD_DOCUMENT_TEXT_DETECT);
        return super.zza(firebaseVisionImage);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zza(zzkd zzkd, float f) {
        return FirebaseVisionDocumentText.zza(zzkd.zzif(), 1.0f / f);
    }
}

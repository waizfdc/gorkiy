package com.google.firebase.ml.vision.document;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionCloudDocumentRecognizerOptions {
    private final boolean zzbkc;
    private final List<String> zzblm;

    public List<String> getHintedLanguages() {
        return this.zzblm;
    }

    public final boolean isEnforceCertFingerprintMatch() {
        return this.zzbkc;
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Builder {
        private boolean zzbkc = false;
        private List<String> zzblm = new ArrayList();

        public Builder setLanguageHints(List<String> list) {
            Preconditions.checkNotNull(list, "Provided hinted languages can not be null");
            this.zzblm = list;
            Collections.sort(list);
            return this;
        }

        public Builder enforceCertFingerprintMatch() {
            this.zzbkc = true;
            return this;
        }

        public FirebaseVisionCloudDocumentRecognizerOptions build() {
            return new FirebaseVisionCloudDocumentRecognizerOptions(this.zzblm, this.zzbkc);
        }
    }

    private FirebaseVisionCloudDocumentRecognizerOptions(List<String> list, boolean z) {
        Preconditions.checkNotNull(list, "Provided hinted languages can not be null");
        this.zzblm = list;
        this.zzbkc = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirebaseVisionCloudDocumentRecognizerOptions)) {
            return false;
        }
        FirebaseVisionCloudDocumentRecognizerOptions firebaseVisionCloudDocumentRecognizerOptions = (FirebaseVisionCloudDocumentRecognizerOptions) obj;
        return this.zzblm.equals(firebaseVisionCloudDocumentRecognizerOptions.getHintedLanguages()) && this.zzbkc == firebaseVisionCloudDocumentRecognizerOptions.zzbkc;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzblm, Boolean.valueOf(this.zzbkc));
    }
}

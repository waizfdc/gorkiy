package com.google.firebase.ml.vision.text;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionCloudTextRecognizerOptions {
    public static final int DENSE_MODEL = 2;
    public static final int SPARSE_MODEL = 1;
    private final boolean zzbkc;
    private final List<String> zzblm;
    private final int zzbnu;

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public @interface CloudTextModelType {
    }

    public List<String> getHintedLanguages() {
        return this.zzblm;
    }

    public final boolean isEnforceCertFingerprintMatch() {
        return this.zzbkc;
    }

    public int getModelType() {
        return this.zzbnu;
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Builder {
        private boolean zzbkc = false;
        private List<String> zzblm = new ArrayList();
        private int zzbnu = 1;

        public Builder setLanguageHints(List<String> list) {
            Preconditions.checkNotNull(list, "Provided hinted languages can not be null");
            this.zzblm = list;
            Collections.sort(list);
            return this;
        }

        public Builder setModelType(int i) {
            boolean z = true;
            if (!(i == 1 || i == 2)) {
                z = false;
            }
            Preconditions.checkArgument(z, "modelType should be either SPARSE_MODEL or DENSE_MODEL");
            this.zzbnu = i;
            return this;
        }

        public Builder enforceCertFingerprintMatch() {
            this.zzbkc = true;
            return this;
        }

        public FirebaseVisionCloudTextRecognizerOptions build() {
            return new FirebaseVisionCloudTextRecognizerOptions(this.zzblm, this.zzbnu, this.zzbkc);
        }
    }

    private FirebaseVisionCloudTextRecognizerOptions(List<String> list, int i, boolean z) {
        Preconditions.checkNotNull(list, "Provided hinted languages can not be null");
        this.zzblm = list;
        this.zzbnu = i;
        this.zzbkc = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirebaseVisionCloudTextRecognizerOptions)) {
            return false;
        }
        FirebaseVisionCloudTextRecognizerOptions firebaseVisionCloudTextRecognizerOptions = (FirebaseVisionCloudTextRecognizerOptions) obj;
        return this.zzblm.equals(firebaseVisionCloudTextRecognizerOptions.getHintedLanguages()) && this.zzbnu == firebaseVisionCloudTextRecognizerOptions.zzbnu && this.zzbkc == firebaseVisionCloudTextRecognizerOptions.zzbkc;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzblm, Integer.valueOf(this.zzbnu), Boolean.valueOf(this.zzbkc));
    }
}

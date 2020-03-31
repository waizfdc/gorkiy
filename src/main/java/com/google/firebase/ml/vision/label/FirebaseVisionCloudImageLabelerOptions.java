package com.google.firebase.ml.vision.label;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionCloudImageLabelerOptions {
    private final float zzbix;
    private final boolean zzbkc;

    private FirebaseVisionCloudImageLabelerOptions(float f, boolean z) {
        this.zzbix = f;
        this.zzbkc = z;
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Builder {
        private float zzbix = 0.5f;
        private boolean zzbkc = false;

        public Builder setConfidenceThreshold(float f) {
            Preconditions.checkArgument(Float.compare(f, 0.0f) >= 0 && Float.compare(f, 1.0f) <= 0, "Confidence Threshold should be in range [0.0f, 1.0f].");
            this.zzbix = f;
            return this;
        }

        public Builder enforceCertFingerprintMatch() {
            this.zzbkc = true;
            return this;
        }

        public FirebaseVisionCloudImageLabelerOptions build() {
            return new FirebaseVisionCloudImageLabelerOptions(this.zzbix, this.zzbkc);
        }
    }

    public float getConfidenceThreshold() {
        return this.zzbix;
    }

    public boolean isEnforceCertFingerprintMatch() {
        return this.zzbkc;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirebaseVisionCloudImageLabelerOptions)) {
            return false;
        }
        FirebaseVisionCloudImageLabelerOptions firebaseVisionCloudImageLabelerOptions = (FirebaseVisionCloudImageLabelerOptions) obj;
        return Float.compare(this.zzbix, firebaseVisionCloudImageLabelerOptions.zzbix) == 0 && this.zzbkc == firebaseVisionCloudImageLabelerOptions.zzbkc;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.zzbix), Boolean.valueOf(this.zzbkc));
    }
}

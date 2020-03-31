package com.google.firebase.ml.vision.cloud;

import com.google.android.gms.common.internal.Objects;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionCloudDetectorOptions {
    public static final FirebaseVisionCloudDetectorOptions DEFAULT = new Builder().build();
    public static final int LATEST_MODEL = 2;
    public static final int STABLE_MODEL = 1;
    private final int zzbka;
    private final int zzbkb;
    private final boolean zzbkc;

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public @interface ModelType {
    }

    private FirebaseVisionCloudDetectorOptions(int i, int i2, boolean z) {
        this.zzbka = i;
        this.zzbkb = i2;
        this.zzbkc = z;
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Builder {
        private int zzbka = 10;
        private int zzbkb = 1;
        private boolean zzbkc = false;

        public Builder setMaxResults(int i) {
            this.zzbka = i;
            return this;
        }

        public Builder setModelType(int i) {
            this.zzbkb = i;
            return this;
        }

        public Builder enforceCertFingerprintMatch() {
            this.zzbkc = true;
            return this;
        }

        public FirebaseVisionCloudDetectorOptions build() {
            return new FirebaseVisionCloudDetectorOptions(this.zzbka, this.zzbkb, this.zzbkc);
        }
    }

    public int getMaxResults() {
        return this.zzbka;
    }

    public int getModelType() {
        return this.zzbkb;
    }

    public final boolean isEnforceCertFingerprintMatch() {
        return this.zzbkc;
    }

    public Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirebaseVisionCloudDetectorOptions)) {
            return false;
        }
        FirebaseVisionCloudDetectorOptions firebaseVisionCloudDetectorOptions = (FirebaseVisionCloudDetectorOptions) obj;
        return this.zzbka == firebaseVisionCloudDetectorOptions.zzbka && this.zzbkb == firebaseVisionCloudDetectorOptions.zzbkb && this.zzbkc == firebaseVisionCloudDetectorOptions.zzbkc;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzbka), Integer.valueOf(this.zzbkb), Boolean.valueOf(this.zzbkc));
    }
}

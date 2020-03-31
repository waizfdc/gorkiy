package com.google.firebase.ml.vision.objects;

import com.google.android.gms.common.internal.Objects;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionObjectDetectorOptions {
    public static final int SINGLE_IMAGE_MODE = 2;
    public static final int STREAM_MODE = 1;
    private final int zzbng;
    private final boolean zzbnh;
    private final boolean zzbni;

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public @interface DetectorMode {
    }

    private FirebaseVisionObjectDetectorOptions(int i, boolean z, boolean z2) {
        this.zzbng = i;
        this.zzbnh = z;
        this.zzbni = z2;
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Builder {
        private int zzbng = 1;
        private boolean zzbnh = false;
        private boolean zzbni = false;

        public Builder setDetectorMode(int i) {
            this.zzbng = i;
            return this;
        }

        public Builder enableMultipleObjects() {
            this.zzbnh = true;
            return this;
        }

        public Builder enableClassification() {
            this.zzbni = true;
            return this;
        }

        public FirebaseVisionObjectDetectorOptions build() {
            return new FirebaseVisionObjectDetectorOptions(this.zzbng, this.zzbnh, this.zzbni);
        }
    }

    public final int zzqf() {
        return this.zzbng;
    }

    public final boolean zzqg() {
        return this.zzbni;
    }

    public final boolean zzqh() {
        return this.zzbnh;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirebaseVisionObjectDetectorOptions)) {
            return false;
        }
        FirebaseVisionObjectDetectorOptions firebaseVisionObjectDetectorOptions = (FirebaseVisionObjectDetectorOptions) obj;
        return firebaseVisionObjectDetectorOptions.zzbng == this.zzbng && firebaseVisionObjectDetectorOptions.zzbni == this.zzbni && firebaseVisionObjectDetectorOptions.zzbnh == this.zzbnh;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzbng), Boolean.valueOf(this.zzbni), Boolean.valueOf(this.zzbnh));
    }
}

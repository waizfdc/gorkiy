package com.google.firebase.ml.vision.label;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zzvx;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionOnDeviceImageLabelerOptions {
    private final float zzbix;

    public float getConfidenceThreshold() {
        return this.zzbix;
    }

    private FirebaseVisionOnDeviceImageLabelerOptions(float f) {
        this.zzbix = f;
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Builder {
        private float zzbix = 0.5f;

        public Builder setConfidenceThreshold(float f) {
            Preconditions.checkArgument(Float.compare(f, 0.0f) >= 0 && Float.compare(f, 1.0f) <= 0, "Confidence Threshold should be in range [0.0f, 1.0f].");
            this.zzbix = f;
            return this;
        }

        public FirebaseVisionOnDeviceImageLabelerOptions build() {
            return new FirebaseVisionOnDeviceImageLabelerOptions(this.zzbix);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof FirebaseVisionOnDeviceImageLabelerOptions) && this.zzbix == ((FirebaseVisionOnDeviceImageLabelerOptions) obj).zzbix;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.zzbix));
    }

    public final zzng.zzan zzqe() {
        return (zzng.zzan) ((zzvx) zzng.zzan.zzmm().zzo(this.zzbix).zztx());
    }
}

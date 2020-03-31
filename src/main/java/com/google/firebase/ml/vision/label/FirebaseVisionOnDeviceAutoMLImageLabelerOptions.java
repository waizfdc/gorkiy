package com.google.firebase.ml.vision.label;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.ml.vision.automl.FirebaseAutoMLLocalModel;
import com.google.firebase.ml.vision.automl.FirebaseAutoMLRemoteModel;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionOnDeviceAutoMLImageLabelerOptions {
    @Nullable
    private final FirebaseAutoMLLocalModel zzbia;
    @Nullable
    private final FirebaseAutoMLRemoteModel zzbiq;
    private final float zzbix;

    public final float getConfidenceThreshold() {
        return this.zzbix;
    }

    public final FirebaseAutoMLLocalModel zzqc() {
        return this.zzbia;
    }

    public final FirebaseAutoMLRemoteModel zzqd() {
        return this.zzbiq;
    }

    private FirebaseVisionOnDeviceAutoMLImageLabelerOptions(float f, @Nullable FirebaseAutoMLLocalModel firebaseAutoMLLocalModel, @Nullable FirebaseAutoMLRemoteModel firebaseAutoMLRemoteModel) {
        this.zzbix = f;
        this.zzbia = firebaseAutoMLLocalModel;
        this.zzbiq = firebaseAutoMLRemoteModel;
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Builder {
        @Nullable
        private FirebaseAutoMLLocalModel zzbia;
        @Nullable
        private FirebaseAutoMLRemoteModel zzbiq;
        private float zzbix = 0.5f;

        public Builder(FirebaseAutoMLLocalModel firebaseAutoMLLocalModel) {
            Preconditions.checkNotNull(firebaseAutoMLLocalModel);
            this.zzbia = firebaseAutoMLLocalModel;
        }

        public Builder(FirebaseAutoMLRemoteModel firebaseAutoMLRemoteModel) {
            Preconditions.checkNotNull(firebaseAutoMLRemoteModel);
            this.zzbiq = firebaseAutoMLRemoteModel;
        }

        @Nonnull
        public Builder setConfidenceThreshold(float f) {
            Preconditions.checkArgument(Float.compare(f, 0.0f) >= 0 && Float.compare(f, 1.0f) <= 0, "Confidence Threshold should be in range [0.0f, 1.0f].");
            this.zzbix = f;
            return this;
        }

        @Nonnull
        public FirebaseVisionOnDeviceAutoMLImageLabelerOptions build() {
            Preconditions.checkArgument((this.zzbia == null && this.zzbiq == null) ? false : true, "Either a local model or remote model must be set.");
            return new FirebaseVisionOnDeviceAutoMLImageLabelerOptions(this.zzbix, this.zzbia, this.zzbiq);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirebaseVisionOnDeviceAutoMLImageLabelerOptions)) {
            return false;
        }
        FirebaseVisionOnDeviceAutoMLImageLabelerOptions firebaseVisionOnDeviceAutoMLImageLabelerOptions = (FirebaseVisionOnDeviceAutoMLImageLabelerOptions) obj;
        return Float.compare(this.zzbix, firebaseVisionOnDeviceAutoMLImageLabelerOptions.zzbix) == 0 && Objects.equal(this.zzbia, firebaseVisionOnDeviceAutoMLImageLabelerOptions.zzbia) && Objects.equal(this.zzbiq, firebaseVisionOnDeviceAutoMLImageLabelerOptions.zzbiq);
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.zzbix), this.zzbia, this.zzbiq);
    }
}

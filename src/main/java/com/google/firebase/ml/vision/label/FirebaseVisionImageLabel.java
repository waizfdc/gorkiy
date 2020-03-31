package com.google.firebase.ml.vision.label;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzkn;
import com.google.android.gms.internal.firebase_ml.zzmn;
import com.google.android.gms.internal.firebase_ml.zzqy;
import com.google.android.gms.vision.label.ImageLabel;
import com.google.firebase.ml.vision.automl.internal.zzj;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionImageLabel {
    private final String text;
    private final String zzbiv;
    private final float zzbiw;

    public FirebaseVisionImageLabel(ImageLabel imageLabel) {
        this(imageLabel.getLabel(), imageLabel.getConfidence(), imageLabel.getMid());
    }

    @Nullable
    public static FirebaseVisionImageLabel zza(@Nullable zzkn zzkn) {
        if (zzkn == null) {
            return null;
        }
        return new FirebaseVisionImageLabel(zzkn.getDescription(), zzqy.zza(zzkn.zzio()), zzkn.getMid());
    }

    public static FirebaseVisionImageLabel zza(zzj zzj) {
        Preconditions.checkNotNull(zzj, "Returned image label parcel can not be null");
        return new FirebaseVisionImageLabel(zzj.text, zzj.zzbiw, zzj.zzbiv);
    }

    private FirebaseVisionImageLabel(@Nullable String str, float f, @Nullable String str2) {
        this.text = zzmn.zzba(str);
        this.zzbiv = str2;
        if (Float.compare(f, 0.0f) < 0) {
            f = 0.0f;
        } else if (Float.compare(f, 1.0f) > 0) {
            f = 1.0f;
        }
        this.zzbiw = f;
    }

    @Nullable
    public String getEntityId() {
        return this.zzbiv;
    }

    public String getText() {
        return this.text;
    }

    public float getConfidence() {
        return this.zzbiw;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirebaseVisionImageLabel)) {
            return false;
        }
        FirebaseVisionImageLabel firebaseVisionImageLabel = (FirebaseVisionImageLabel) obj;
        return Objects.equal(this.zzbiv, firebaseVisionImageLabel.getEntityId()) && Objects.equal(this.text, firebaseVisionImageLabel.getText()) && Float.compare(this.zzbiw, firebaseVisionImageLabel.getConfidence()) == 0;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzbiv, this.text, Float.valueOf(this.zzbiw));
    }
}

package com.google.firebase.ml.vision.face;

import com.google.android.gms.internal.firebase_ml.zzlw;
import com.google.firebase.ml.vision.common.FirebaseVisionPoint;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionFaceLandmark {
    public static final int LEFT_CHEEK = 1;
    public static final int LEFT_EAR = 3;
    public static final int LEFT_EYE = 4;
    public static final int MOUTH_BOTTOM = 0;
    public static final int MOUTH_LEFT = 5;
    public static final int MOUTH_RIGHT = 11;
    public static final int NOSE_BASE = 6;
    public static final int RIGHT_CHEEK = 7;
    public static final int RIGHT_EAR = 9;
    public static final int RIGHT_EYE = 10;
    private final int type;
    private final FirebaseVisionPoint zzbmf;

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public @interface LandmarkType {
    }

    FirebaseVisionFaceLandmark(int i, FirebaseVisionPoint firebaseVisionPoint) {
        this.type = i;
        this.zzbmf = firebaseVisionPoint;
    }

    public int getLandmarkType() {
        return this.type;
    }

    public FirebaseVisionPoint getPosition() {
        return this.zzbmf;
    }

    public String toString() {
        return zzlw.zzay("FirebaseVisionFaceLandmark").zzb("type", this.type).zzh("position", this.zzbmf).toString();
    }
}

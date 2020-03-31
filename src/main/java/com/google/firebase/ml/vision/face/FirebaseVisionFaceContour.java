package com.google.firebase.ml.vision.face;

import com.google.android.gms.internal.firebase_ml.zzlw;
import com.google.firebase.ml.vision.common.FirebaseVisionPoint;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionFaceContour {
    public static final int ALL_POINTS = 1;
    public static final int FACE = 2;
    public static final int LEFT_EYE = 7;
    public static final int LEFT_EYEBROW_BOTTOM = 4;
    public static final int LEFT_EYEBROW_TOP = 3;
    public static final int LOWER_LIP_BOTTOM = 12;
    public static final int LOWER_LIP_TOP = 11;
    public static final int NOSE_BOTTOM = 14;
    public static final int NOSE_BRIDGE = 13;
    public static final int RIGHT_EYE = 8;
    public static final int RIGHT_EYEBROW_BOTTOM = 6;
    public static final int RIGHT_EYEBROW_TOP = 5;
    public static final int UPPER_LIP_BOTTOM = 10;
    public static final int UPPER_LIP_TOP = 9;
    private final int type;
    private final List<FirebaseVisionPoint> zzblz;

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public @interface ContourType {
    }

    public FirebaseVisionFaceContour(int i, List<FirebaseVisionPoint> list) {
        this.type = i;
        this.zzblz = list;
    }

    public int getFaceContourType() {
        return this.type;
    }

    public List<FirebaseVisionPoint> getPoints() {
        return this.zzblz;
    }

    public String toString() {
        return zzlw.zzay("FirebaseVisionFaceContour").zzb("type", this.type).zzh("points", this.zzblz.toArray()).toString();
    }
}

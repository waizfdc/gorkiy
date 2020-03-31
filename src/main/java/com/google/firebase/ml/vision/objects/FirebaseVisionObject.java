package com.google.firebase.ml.vision.objects;

import android.graphics.Rect;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.ml.vision.objects.internal.zzh;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionObject {
    public static final int CATEGORY_FASHION_GOOD = 2;
    public static final int CATEGORY_FOOD = 3;
    public static final int CATEGORY_HOME_GOOD = 1;
    public static final int CATEGORY_PLACE = 4;
    public static final int CATEGORY_PLANT = 5;
    public static final int CATEGORY_UNKNOWN = 0;
    private final int category;
    private final Float confidence;
    private final Rect zzbks;
    private final Integer zzbnf;

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public @interface Category {
    }

    public FirebaseVisionObject(zzh zzh) {
        Preconditions.checkNotNull(zzh, "Returned Object Detector Parcel can not be null");
        int[] iArr = zzh.zzbnt;
        Preconditions.checkArgument(iArr.length == 4);
        this.zzbks = new Rect(iArr[0], iArr[1], iArr[2], iArr[3]);
        this.zzbnf = zzh.zzbnf;
        this.confidence = zzh.confidence;
        this.category = zzh.category;
    }

    public int getClassificationCategory() {
        return this.category;
    }

    public Rect getBoundingBox() {
        return this.zzbks;
    }

    public Integer getTrackingId() {
        return this.zzbnf;
    }

    public Float getClassificationConfidence() {
        return this.confidence;
    }
}

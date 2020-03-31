package com.google.firebase.ml.vision.face;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.firebase_ml.zzlw;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zzvx;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionFaceDetectorOptions {
    public static final int ACCURATE = 2;
    public static final int ALL_CLASSIFICATIONS = 2;
    public static final int ALL_CONTOURS = 2;
    public static final int ALL_LANDMARKS = 2;
    public static final int FAST = 1;
    public static final int NO_CLASSIFICATIONS = 1;
    public static final int NO_CONTOURS = 1;
    public static final int NO_LANDMARKS = 1;
    private final boolean trackingEnabled;
    private final int zzbma;
    private final int zzbmb;
    private final int zzbmc;
    private final int zzbmd;
    private final float zzbme;

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public @interface ClassificationMode {
    }

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public @interface ContourMode {
    }

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public @interface LandmarkMode {
    }

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public @interface PerformanceMode {
    }

    public int getLandmarkMode() {
        return this.zzbma;
    }

    public int getContourMode() {
        return this.zzbmb;
    }

    public int getClassificationMode() {
        return this.zzbmc;
    }

    public int getPerformanceMode() {
        return this.zzbmd;
    }

    public boolean isTrackingEnabled() {
        return this.trackingEnabled;
    }

    public float getMinFaceSize() {
        return this.zzbme;
    }

    private FirebaseVisionFaceDetectorOptions(int i, int i2, int i3, int i4, boolean z, float f) {
        this.zzbma = i;
        this.zzbmb = i2;
        this.zzbmc = i3;
        this.zzbmd = i4;
        this.trackingEnabled = z;
        this.zzbme = f;
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Builder {
        private boolean trackingEnabled = false;
        private int zzbma = 1;
        private int zzbmb = 1;
        private int zzbmc = 1;
        private int zzbmd = 1;
        private float zzbme = 0.1f;

        public Builder setLandmarkMode(int i) {
            this.zzbma = i;
            return this;
        }

        public Builder setContourMode(int i) {
            this.zzbmb = i;
            return this;
        }

        public Builder setClassificationMode(int i) {
            this.zzbmc = i;
            return this;
        }

        public Builder enableTracking() {
            this.trackingEnabled = true;
            return this;
        }

        public Builder setPerformanceMode(int i) {
            this.zzbmd = i;
            return this;
        }

        public Builder setMinFaceSize(float f) {
            this.zzbme = f;
            return this;
        }

        public FirebaseVisionFaceDetectorOptions build() {
            return new FirebaseVisionFaceDetectorOptions(this.zzbma, this.zzbmb, this.zzbmc, this.zzbmd, this.trackingEnabled, this.zzbme);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirebaseVisionFaceDetectorOptions)) {
            return false;
        }
        FirebaseVisionFaceDetectorOptions firebaseVisionFaceDetectorOptions = (FirebaseVisionFaceDetectorOptions) obj;
        return Float.floatToIntBits(this.zzbme) == Float.floatToIntBits(firebaseVisionFaceDetectorOptions.zzbme) && this.zzbma == firebaseVisionFaceDetectorOptions.zzbma && this.zzbmb == firebaseVisionFaceDetectorOptions.zzbmb && this.zzbmd == firebaseVisionFaceDetectorOptions.zzbmd && this.trackingEnabled == firebaseVisionFaceDetectorOptions.trackingEnabled && this.zzbmc == firebaseVisionFaceDetectorOptions.zzbmc;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Float.floatToIntBits(this.zzbme)), Integer.valueOf(this.zzbma), Integer.valueOf(this.zzbmb), Integer.valueOf(this.zzbmd), Boolean.valueOf(this.trackingEnabled), Integer.valueOf(this.zzbmc));
    }

    public String toString() {
        return zzlw.zzay("FaceDetectorOptions").zzb("landmarkMode", this.zzbma).zzb("contourMode", this.zzbmb).zzb("classificationMode", this.zzbmc).zzb("performanceMode", this.zzbmd).zza("trackingEnabled", this.trackingEnabled).zza("minFaceSize", this.zzbme).toString();
    }

    public final zzng.zzaa zzqb() {
        zzng.zzaa.zzd zzd;
        zzng.zzaa.zza zza;
        zzng.zzaa.zze zze;
        zzng.zzaa.zzc zzc;
        zzng.zzaa.zzb zzlk = zzng.zzaa.zzlk();
        int i = this.zzbma;
        if (i == 1) {
            zzd = zzng.zzaa.zzd.NO_LANDMARKS;
        } else if (i != 2) {
            zzd = zzng.zzaa.zzd.UNKNOWN_LANDMARKS;
        } else {
            zzd = zzng.zzaa.zzd.ALL_LANDMARKS;
        }
        zzng.zzaa.zzb zzb = zzlk.zzb(zzd);
        int i2 = this.zzbmc;
        if (i2 == 1) {
            zza = zzng.zzaa.zza.NO_CLASSIFICATIONS;
        } else if (i2 != 2) {
            zza = zzng.zzaa.zza.UNKNOWN_CLASSIFICATIONS;
        } else {
            zza = zzng.zzaa.zza.ALL_CLASSIFICATIONS;
        }
        zzng.zzaa.zzb zzb2 = zzb.zzb(zza);
        int i3 = this.zzbmd;
        if (i3 == 1) {
            zze = zzng.zzaa.zze.FAST;
        } else if (i3 != 2) {
            zze = zzng.zzaa.zze.UNKNOWN_PERFORMANCE;
        } else {
            zze = zzng.zzaa.zze.ACCURATE;
        }
        zzng.zzaa.zzb zzb3 = zzb2.zzb(zze);
        int i4 = this.zzbmb;
        if (i4 == 1) {
            zzc = zzng.zzaa.zzc.NO_CONTOURS;
        } else if (i4 != 2) {
            zzc = zzng.zzaa.zzc.UNKNOWN_CONTOURS;
        } else {
            zzc = zzng.zzaa.zzc.ALL_CONTOURS;
        }
        return (zzng.zzaa) ((zzvx) zzb3.zzb(zzc).zzab(isTrackingEnabled()).zzl(this.zzbme).zztx());
    }
}

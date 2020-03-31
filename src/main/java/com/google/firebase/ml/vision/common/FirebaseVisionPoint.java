package com.google.firebase.ml.vision.common;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.firebase_ml.zzlw;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class FirebaseVisionPoint {
    private final Float zzbla;
    private final Float zzblb;
    private final Float zzblc = null;

    public final Float getX() {
        return this.zzbla;
    }

    public final Float getZ() {
        return null;
    }

    public final Float getY() {
        return this.zzblb;
    }

    public FirebaseVisionPoint(Float f, Float f2, Float f3) {
        this.zzbla = f;
        this.zzblb = f2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirebaseVisionPoint)) {
            return false;
        }
        FirebaseVisionPoint firebaseVisionPoint = (FirebaseVisionPoint) obj;
        return Objects.equal(this.zzbla, firebaseVisionPoint.zzbla) && Objects.equal(this.zzblb, firebaseVisionPoint.zzblb) && Objects.equal(null, null);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzbla, this.zzblb, null);
    }

    public final String toString() {
        return zzlw.zzay("FirebaseVisionPoint").zzh("x", this.zzbla).zzh("y", this.zzblb).zzh("z", null).toString();
    }
}

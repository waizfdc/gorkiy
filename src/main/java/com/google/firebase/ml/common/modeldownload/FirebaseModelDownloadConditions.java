package com.google.firebase.ml.common.modeldownload;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public class FirebaseModelDownloadConditions {
    private final boolean zzbfy;
    private final boolean zzbfz;
    private final boolean zzbga;

    private FirebaseModelDownloadConditions(boolean z, boolean z2, boolean z3) {
        this.zzbfy = z;
        this.zzbfz = z2;
        this.zzbga = z3;
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static class Builder {
        private boolean zzbfy = false;
        private boolean zzbfz = false;
        private boolean zzbga = false;

        public Builder requireCharging() {
            this.zzbfy = true;
            return this;
        }

        public Builder requireWifi() {
            this.zzbfz = true;
            return this;
        }

        public Builder requireDeviceIdle() {
            this.zzbga = true;
            return this;
        }

        public FirebaseModelDownloadConditions build() {
            return new FirebaseModelDownloadConditions(this.zzbfy, this.zzbfz, this.zzbga);
        }
    }

    public boolean isChargingRequired() {
        return this.zzbfy;
    }

    public boolean isWifiRequired() {
        return this.zzbfz;
    }

    public boolean isDeviceIdleRequired() {
        return this.zzbga;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirebaseModelDownloadConditions)) {
            return false;
        }
        FirebaseModelDownloadConditions firebaseModelDownloadConditions = (FirebaseModelDownloadConditions) obj;
        return this.zzbfy == firebaseModelDownloadConditions.zzbfy && this.zzbga == firebaseModelDownloadConditions.zzbga && this.zzbfz == firebaseModelDownloadConditions.zzbfz;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zzbfy), Boolean.valueOf(this.zzbfz), Boolean.valueOf(this.zzbga));
    }
}

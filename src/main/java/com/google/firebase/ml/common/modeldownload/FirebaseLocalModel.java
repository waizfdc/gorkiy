package com.google.firebase.ml.common.modeldownload;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zzvx;
import com.google.firebase.ml.common.internal.modeldownload.zzn;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public class FirebaseLocalModel {
    private final String zzbdo;
    private final String zzbfw;
    private final String zzbfx;

    public String getFilePath() {
        return this.zzbfw;
    }

    public String getAssetFilePath() {
        return this.zzbfx;
    }

    protected FirebaseLocalModel(String str, String str2, String str3) {
        this.zzbdo = str;
        this.zzbfw = str2;
        this.zzbfx = str3;
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static class Builder {
        private final String zzbdo;
        private String zzbfw = null;
        private String zzbfx = null;

        public Builder(String str) {
            Preconditions.checkNotEmpty(str, "Model name can not be empty");
            this.zzbdo = str;
        }

        public Builder setFilePath(String str) {
            Preconditions.checkNotEmpty(str, "Model Source file path can not be empty");
            Preconditions.checkArgument(this.zzbfx == null, "A local model source is either from local file or for asset, you can not set both.");
            this.zzbfw = str;
            return this;
        }

        public Builder setAssetFilePath(String str) {
            Preconditions.checkNotEmpty(str, "Model Source file path can not be empty");
            Preconditions.checkArgument(this.zzbfw == null, "A local model source is either from local file or for asset, you can not set both.");
            this.zzbfx = str;
            return this;
        }

        public FirebaseLocalModel build() {
            Preconditions.checkArgument((this.zzbfw != null && this.zzbfx == null) || (this.zzbfw == null && this.zzbfx != null), "Set either filePath or assetFilePath.");
            return new FirebaseLocalModel(this.zzbdo, this.zzbfw, this.zzbfx);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirebaseLocalModel)) {
            return false;
        }
        FirebaseLocalModel firebaseLocalModel = (FirebaseLocalModel) obj;
        return Objects.equal(this.zzbdo, firebaseLocalModel.zzbdo) && Objects.equal(this.zzbfw, firebaseLocalModel.zzbfw) && Objects.equal(this.zzbfx, firebaseLocalModel.zzbfx);
    }

    public int hashCode() {
        return Objects.hashCode(this.zzbdo, this.zzbfw, this.zzbfx);
    }

    public final zzng.zzai zza(zzn zzn) {
        zzng.zzah.zzc zzc;
        zzng.zzai.zzb zzma = zzng.zzai.zzma();
        zzng.zzah.zzb zzd = zzng.zzah.zzly().zzd(zzn.zzof());
        String str = this.zzbfw;
        if (str == null) {
            str = this.zzbfx;
        }
        zzng.zzah.zzb zzbf = zzd.zzbf(str);
        if (this.zzbfw != null) {
            zzc = zzng.zzah.zzc.LOCAL;
        } else if (this.zzbfx != null) {
            zzc = zzng.zzah.zzc.APP_ASSET;
        } else {
            zzc = zzng.zzah.zzc.SOURCE_UNKNOWN;
        }
        return (zzng.zzai) ((zzvx) zzma.zza(zzbf.zzb(zzc)).zztx());
    }
}

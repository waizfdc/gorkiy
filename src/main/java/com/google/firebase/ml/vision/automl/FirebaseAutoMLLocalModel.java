package com.google.firebase.ml.vision.automl;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.ml.common.modeldownload.FirebaseLocalModel;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseAutoMLLocalModel extends FirebaseLocalModel {
    private FirebaseAutoMLLocalModel(String str, String str2) {
        super(null, str, str2);
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Builder {
        private String zzbfw = null;
        private String zzbfx = null;

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

        public FirebaseAutoMLLocalModel build() {
            Preconditions.checkArgument((this.zzbfw != null && this.zzbfx == null) || (this.zzbfw == null && this.zzbfx != null), "Set either filePath or assetFilePath.");
            return new FirebaseAutoMLLocalModel(this.zzbfw, this.zzbfx);
        }
    }
}

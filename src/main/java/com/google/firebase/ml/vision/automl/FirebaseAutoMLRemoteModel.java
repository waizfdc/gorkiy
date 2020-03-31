package com.google.firebase.ml.vision.automl;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseAutoMLRemoteModel extends FirebaseRemoteModel {
    private FirebaseAutoMLRemoteModel(String str) {
        super(str, null);
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Builder {
        private final String zzbdo;

        public Builder(String str) {
            this.zzbdo = str;
        }

        public FirebaseAutoMLRemoteModel build() {
            Preconditions.checkArgument(!TextUtils.isEmpty(this.zzbdo), "Model name cannot be empty");
            return new FirebaseAutoMLRemoteModel(this.zzbdo);
        }
    }
}

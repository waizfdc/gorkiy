package com.google.firebase.ml.common.internal.modeldownload;

import android.net.Uri;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zznq;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel;
import io.fabric.sdk.android.services.network.HttpRequest;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzd {
    private static final GmsLogger zzbbo = new GmsLogger("BaseModelInfoRetriever", "");

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void
     arg types: [com.google.android.gms.internal.firebase_ml.zznq, int, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb]
     candidates:
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, java.lang.String, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn):void
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void */
    static zzaa zza(FirebaseRemoteModel firebaseRemoteModel, zzw zzw) throws FirebaseMLException {
        HttpsURLConnection zza = zzad.zza(String.format("https://mlkit.googleapis.com/_i/v1/1p/m?n=%s", firebaseRemoteModel.getModelNameForBackend()), zzw);
        if (zza == null) {
            return null;
        }
        String headerField = zza.getHeaderField("Content-Location");
        String headerField2 = zza.getHeaderField(HttpRequest.HEADER_ETAG);
        GmsLogger gmsLogger = zzbbo;
        String valueOf = String.valueOf(headerField);
        gmsLogger.d("BaseModelInfoRetriever", valueOf.length() != 0 ? "Received download URL: ".concat(valueOf) : new String("Received download URL: "));
        if (headerField == null) {
            return null;
        }
        if (headerField2 == null) {
            zzw.zza(zznq.MODEL_INFO_DOWNLOAD_NO_HASH, false, zzn.BASE, zzng.zzag.zzb.MODEL_INFO_RETRIEVAL_FAILED);
            throw new FirebaseMLException("No hash value for the base model", 13);
        } else if (firebaseRemoteModel.baseModelHashMatches(headerField2)) {
            firebaseRemoteModel.setModelHash(headerField2);
            return new zzaa(firebaseRemoteModel.getUniqueModelNameForPersist(), Uri.parse(headerField), headerField2, zzn.BASE);
        } else {
            throw new FirebaseMLException("Downloaded model hash doesn't match the expected. ", 13);
        }
    }
}

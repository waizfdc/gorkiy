package com.google.firebase.ml.common.internal.modeldownload;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zznq;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzu {
    private static final GmsLogger zzbbo = new GmsLogger("ModelInfoRetriever", "");

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void
     arg types: [com.google.android.gms.internal.firebase_ml.zznq, int, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb]
     candidates:
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, java.lang.String, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn):void
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void */
    static zzaa zza(zzpn zzpn, FirebaseApp firebaseApp, FirebaseRemoteModel firebaseRemoteModel, zzw zzw) throws FirebaseMLException {
        JSONObject jSONObject;
        HttpsURLConnection zza = zzad.zza(zza(firebaseApp, firebaseRemoteModel.getModelNameForBackend(), zzw), zzw);
        if (zza == null) {
            return null;
        }
        String headerField = zza.getHeaderField("Content-Location");
        String headerField2 = zza.getHeaderField(HttpRequest.HEADER_ETAG);
        GmsLogger gmsLogger = zzbbo;
        String valueOf = String.valueOf(headerField);
        gmsLogger.d("ModelInfoRetriever", valueOf.length() != 0 ? "Received download URL: ".concat(valueOf) : new String("Received download URL: "));
        if (headerField == null) {
            return null;
        }
        if (headerField2 != null) {
            firebaseRemoteModel.setModelHash(headerField2);
            try {
                String str = new String(IOUtils.readInputStreamFully(zza.getInputStream()));
                if (TextUtils.isEmpty(str)) {
                    str = "{}";
                }
                JSONObject jSONObject2 = new JSONObject(str);
                zzn zzn = jSONObject2.has("inferenceInfo") ? zzn.AUTOML : zzn.CUSTOM;
                if (zzn.equals(zzn.AUTOML) && (jSONObject = jSONObject2.getJSONObject("inferenceInfo")) != null) {
                    JSONArray jSONArray = jSONObject.getJSONArray("labels");
                    if (jSONArray == null || jSONArray.length() == 0) {
                        throw new FirebaseMLException("Cannot parse AutoML model's labels from model downloading backend.", 13);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                    zza.zza(zzpn, firebaseRemoteModel.getUniqueModelNameForPersist(), arrayList);
                }
                return new zzaa(firebaseRemoteModel.getUniqueModelNameForPersist(), Uri.parse(headerField), headerField2, zzn);
            } catch (IOException | JSONException e) {
                throw new FirebaseMLException("Failed to parse the model backend response message", 13, e);
            }
        } else {
            zzw.zza(zznq.MODEL_INFO_DOWNLOAD_NO_HASH, false, zzn.UNKNOWN, zzng.zzag.zzb.MODEL_INFO_RETRIEVAL_FAILED);
            throw new FirebaseMLException("No hash value for the custom model", 13);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void
     arg types: [com.google.android.gms.internal.firebase_ml.zznq, int, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb]
     candidates:
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, java.lang.String, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn):void
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void */
    private static String zza(FirebaseApp firebaseApp, String str, zzw zzw) throws FirebaseMLException {
        String str2;
        String gcmSenderId = firebaseApp.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            FirebaseInstanceId instance = FirebaseInstanceId.getInstance(firebaseApp);
            if (instance == null) {
                zzbbo.w("ModelInfoRetriever", "Cannot get a valid instance of FirebaseInstanceId. Cannot retrieve model info.");
                return null;
            }
            String id = instance.getId();
            if (id == null) {
                zzbbo.w("ModelInfoRetriever", "Firebase instance id is null. Cannot retrieve model info.");
                return null;
            }
            try {
                String token = instance.getToken(gcmSenderId, "*");
                if (token == null) {
                    zzbbo.w("ModelInfoRetriever", "Firebase instance token is null. Cannot retrieve model info.");
                    return null;
                }
                return String.format("https://mlkit.googleapis.com/v1beta1/projects/%s/models/%s/versions/active?key=%s&app_instance_id=%s&app_instance_token=%s", firebaseApp.getOptions().getProjectId(), str, firebaseApp.getOptions().getApiKey(), id, token);
            } catch (IOException e) {
                zznq zznq = zznq.MODEL_INFO_DOWNLOAD_CONNECTION_FAILED;
                if (e instanceof UnknownHostException) {
                    zznq = zznq.NO_NETWORK_CONNECTION;
                    str2 = "Failed to retrieve model info due to no internet connection.";
                } else {
                    str2 = "Failed to get model URL";
                }
                zzw.zza(zznq, false, zzn.UNKNOWN, zzng.zzag.zzb.MODEL_INFO_RETRIEVAL_FAILED);
                throw new FirebaseMLException(str2, 13, e);
            }
        } else {
            throw new FirebaseMLException("GCM sender id cannot be null in FirebaseOptions. Please configure FirebaseApp properly.", 9);
        }
    }
}

package com.google.firebase.ml.common.internal.modeldownload;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zznq;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzad {
    private static final GmsLogger zzbbo = new GmsLogger("RmModelInfoRetriever", "");

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void
     arg types: [com.google.android.gms.internal.firebase_ml.zznq, int, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb]
     candidates:
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, java.lang.String, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn):void
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void */
    static zzaa zza(zzpn zzpn, FirebaseRemoteModel firebaseRemoteModel, zzw zzw) throws FirebaseMLException {
        zzaa zzaa;
        if (firebaseRemoteModel.isBaseModel()) {
            zzaa = zzd.zza(firebaseRemoteModel, zzw);
        } else {
            zzaa = zzu.zza(zzpn, zzpn.zznq(), firebaseRemoteModel, zzw);
        }
        if (zzaa != null) {
            zzw.zza(zznq.NO_ERROR, false, zzaa.zzov(), zzng.zzag.zzb.MODEL_INFO_RETRIEVAL_SUCCEEDED);
        }
        return zzaa;
    }

    static HttpsURLConnection zza(String str, zzw zzw) throws FirebaseMLException {
        String str2;
        zznq zznq;
        String str3;
        if (str == null) {
            return null;
        }
        try {
            zzai zzai = new zzai(str);
            GmsLogger gmsLogger = zzbbo;
            String valueOf = String.valueOf(str);
            gmsLogger.d("RmModelInfoRetriever", valueOf.length() != 0 ? "Checking model URL: ".concat(valueOf) : new String("Checking model URL: "));
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) zzai.openConnection();
            httpsURLConnection.setConnectTimeout(CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
            httpsURLConnection.connect();
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode == 200 || responseCode == 304) {
                return httpsURLConnection;
            }
            if (responseCode == 408) {
                zznq = zznq.TIME_OUT_FETCHING_MODEL_METADATA;
            } else {
                zznq = zznq.MODEL_INFO_DOWNLOAD_UNSUCCESSFUL_HTTP_STATUS;
            }
            zzw.zza(zznq, httpsURLConnection.getResponseCode());
            InputStream errorStream = httpsURLConnection.getErrorStream();
            if (errorStream == null) {
                str3 = "";
            } else {
                str3 = new String(IOUtils.readInputStreamFully(errorStream));
            }
            throw new FirebaseMLException(String.format(Locale.getDefault(), "Failed to connect to Firebase ML console server with HTTP status code: %d and error message: %s", Integer.valueOf(httpsURLConnection.getResponseCode()), str3), 13);
        } catch (SocketTimeoutException e) {
            zzw.zzo(zznq.TIME_OUT_FETCHING_MODEL_METADATA);
            throw new FirebaseMLException("Failed to get model URL due to time out", 13, e);
        } catch (IOException e2) {
            zznq zznq2 = zznq.MODEL_INFO_DOWNLOAD_CONNECTION_FAILED;
            if (e2 instanceof UnknownHostException) {
                zznq2 = zznq.NO_NETWORK_CONNECTION;
                str2 = "Failed to retrieve model info due to no internet connection.";
            } else {
                str2 = "Failed to get model URL";
            }
            zzw.zzo(zznq2);
            throw new FirebaseMLException(str2, 13, e2);
        }
    }
}

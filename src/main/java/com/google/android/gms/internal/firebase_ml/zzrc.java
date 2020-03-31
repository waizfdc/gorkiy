package com.google.android.gms.internal.firebase_ml;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.api.AuthProxy;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.internal.firebase_ml.zzfw;
import com.google.firebase.FirebaseApp;
import com.google.firebase.ml.common.FirebaseMLException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzrc implements zzpc<zzkd, zzqx> {
    private static final Map<FirebaseApp, zzrc> zzbbn = new HashMap();
    private static final GmsLogger zzbbo = new GmsLogger("ImageAnnotatorTask", "");
    private static final zzhd zzbkl = new zzhp();
    private static final zzht zzbkm = zzic.zzhq();
    private final GoogleApiClient zzbkg;
    /* access modifiers changed from: private */
    public String zzbkn;
    private final boolean zzbko;
    private final zzkb zzbkp;
    private final String zzyh;

    public static synchronized zzrc zza(FirebaseApp firebaseApp, boolean z, GoogleApiClient googleApiClient) {
        zzrc zzrc;
        synchronized (zzrc.class) {
            zzrc = zzbbn.get(firebaseApp);
            if (zzrc == null) {
                zzrc = new zzrc(firebaseApp, z, googleApiClient);
                zzbbn.put(firebaseApp, zzrc);
            }
        }
        return zzrc;
    }

    public final zzpx zznl() {
        return null;
    }

    private zzrc(FirebaseApp firebaseApp, boolean z, GoogleApiClient googleApiClient) {
        this.zzbko = z;
        if (z) {
            this.zzbkg = googleApiClient;
            this.zzbkp = new zzrb(this);
        } else {
            this.zzbkg = null;
            this.zzbkp = new zzre(this, zza(firebaseApp), firebaseApp);
        }
        this.zzyh = String.format("FirebaseML_%s", firebaseApp.getName());
    }

    private static String zza(FirebaseApp firebaseApp) {
        Bundle bundle;
        String apiKey = firebaseApp.getOptions().getApiKey();
        Context applicationContext = firebaseApp.getApplicationContext();
        try {
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return apiKey;
            }
            String string = bundle.getString("com.firebase.ml.cloud.ApiKeyForDebug");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            return apiKey;
        } catch (PackageManager.NameNotFoundException e) {
            GmsLogger gmsLogger = zzbbo;
            String valueOf = String.valueOf(applicationContext.getPackageName());
            gmsLogger.e("ImageAnnotatorTask", valueOf.length() != 0 ? "No such package: ".concat(valueOf) : new String("No such package: "), e);
            return apiKey;
        }
    }

    /* access modifiers changed from: private */
    public static String zzb(Context context, String str) {
        try {
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, str);
            if (packageCertificateHashBytes != null) {
                return Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
            }
            GmsLogger gmsLogger = zzbbo;
            String valueOf = String.valueOf(str);
            gmsLogger.e("ImageAnnotatorTask", valueOf.length() != 0 ? "Could not get fingerprint hash: ".concat(valueOf) : new String("Could not get fingerprint hash: "));
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            GmsLogger gmsLogger2 = zzbbo;
            String valueOf2 = String.valueOf(str);
            gmsLogger2.e("ImageAnnotatorTask", valueOf2.length() != 0 ? "No such package: ".concat(valueOf2) : new String("No such package: "), e);
            return null;
        }
    }

    private final String getSpatulaHeader() throws FirebaseMLException {
        if (!this.zzbkg.isConnected()) {
            this.zzbkg.blockingConnect(3, TimeUnit.SECONDS);
        }
        try {
            return AuthProxy.ProxyApi.getSpatulaHeader(this.zzbkg).await(3, TimeUnit.SECONDS).getSpatulaHeader();
        } catch (SecurityException unused) {
            return null;
        }
    }

    public final zzkd zza(zzqx zzqx) throws FirebaseMLException {
        zzkg zzc = new zzkg().zzc(Collections.singletonList(new zzke().zzb(zzqx.features).zza(new zzkp().zze(zzqx.zzbkd)).zza(zzqx.imageContext)));
        int i = 14;
        try {
            zzjy zzie = ((zzjx) new zzjx(zzbkl, zzbkm, new zzrd(this)).zzk(this.zzyh)).zza(this.zzbkp).zzie();
            if (this.zzbko) {
                String spatulaHeader = getSpatulaHeader();
                this.zzbkn = spatulaHeader;
                if (TextUtils.isEmpty(spatulaHeader)) {
                    zzbbo.e("ImageAnnotatorTask", "Failed to contact Google Play services for certificate fingerprint matching. Please ensure you have latest Google Play services installed");
                    throw new FirebaseMLException("Failed to contact Google Play services for certificate fingerprint matching. Please ensure you have latest Google Play services installed", 14);
                }
            }
            List<zzkd> zzii = ((zzkf) new zzka(zzie).zza(zzc).zzfj()).zzii();
            if (zzii != null && !zzii.isEmpty()) {
                return zzii.get(0);
            }
            throw new FirebaseMLException("Empty response from cloud vision api.", 13);
        } catch (zzfy e) {
            GmsLogger gmsLogger = zzbbo;
            String valueOf = String.valueOf(e.zzfc());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 44);
            sb.append("batchAnnotateImages call failed with error: ");
            sb.append(valueOf);
            gmsLogger.e("ImageAnnotatorTask", sb.toString());
            if (this.zzbko) {
                Log.d("ImageAnnotatorTask", "If you are developing / testing on a simulator, either register your development app on Firebase console or turn off enforceCertFingerprintMatch()");
            }
            String message = e.getMessage();
            if (e.getStatusCode() != 400) {
                if (e.zzfc() != null && e.zzfc().zzez() != null) {
                    i = 13;
                    for (zzfw.zza reason : e.zzfc().zzez()) {
                        String reason2 = reason.getReason();
                        if (reason2 != null) {
                            if (reason2.equals("rateLimitExceeded") || reason2.equals("dailyLimitExceeded") || reason2.equals("userRateLimitExceeded")) {
                                i = 8;
                                continue;
                            } else {
                                if (!reason2.equals("accessNotConfigured")) {
                                    if (reason2.equals("forbidden") || reason2.equals("inactiveBillingState")) {
                                        message = String.format("If you haven't set up billing, please go to Firebase console to set up billing: %s. If you are specifying a debug Api Key override and turned on Api Key restrictions, make sure the restrictions are set up correctly", "https://console.firebase.google.com/u/0/project/_/overview?purchaseBillingPlan=true");
                                    }
                                }
                                i = 7;
                                continue;
                            }
                        }
                        if (i != 13) {
                            break;
                        }
                    }
                } else {
                    i = 13;
                }
            }
            throw new FirebaseMLException(message, i);
        } catch (IOException e2) {
            zzbbo.e("ImageAnnotatorTask", "batchAnnotateImages call failed with exception: ", e2);
            throw new FirebaseMLException("Cloud Vision batchAnnotateImages call failure", 13, e2);
        }
    }
}

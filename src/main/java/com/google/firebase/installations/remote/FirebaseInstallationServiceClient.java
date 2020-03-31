package com.google.firebase.installations.remote;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.JsonReader;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.FirebaseException;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-installations@@16.0.0 */
public class FirebaseInstallationServiceClient {
    private static final String ACCEPT_HEADER_KEY = "Accept";
    private static final String CONTENT_ENCODING_HEADER_KEY = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER_KEY = "Content-Type";
    private static final String CREATE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations";
    private static final String DELETE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s";
    private static final Pattern EXPIRATION_TIMESTAMP_PATTERN = Pattern.compile("[0-9]+s");
    private static final String FIREBASE_INSTALLATIONS_API_DOMAIN = "firebaseinstallations.googleapis.com";
    private static final String FIREBASE_INSTALLATIONS_API_VERSION = "v1";
    private static final String FIREBASE_INSTALLATIONS_ID_HEARTBEAT_TAG = "fire-installations-id";
    private static final String FIREBASE_INSTALLATION_AUTH_VERSION = "FIS_v2";
    private static final String GENERATE_AUTH_TOKEN_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s/authTokens:generate";
    private static final String GZIP_CONTENT_ENCODING = "gzip";
    private static final String HEART_BEAT_HEADER = "x-firebase-client-log-type";
    private static final String JSON_CONTENT_TYPE = "application/json";
    private static final int MAX_RETRIES = 1;
    private static final int NETWORK_TIMEOUT_MILLIS = 10000;
    static final String PARSING_EXPIRATION_TIME_ERROR_MESSAGE = "Invalid Expiration Timestamp.";
    private static final String SDK_VERSION_PREFIX = "a:";
    private static final String USER_AGENT_HEADER = "x-firebase-client";
    private static final Charset UTF_8 = Charset.forName(HttpRequest.CHARSET_UTF8);
    private static final String X_ANDROID_CERT_HEADER_KEY = "X-Android-Cert";
    private static final String X_ANDROID_IID_MIGRATION_KEY = "x-goog-fis-android-iid-migration-auth";
    private static final String X_ANDROID_PACKAGE_HEADER_KEY = "X-Android-Package";
    private final Context context;
    private final HeartBeatInfo heartbeatInfo;
    private final UserAgentPublisher userAgentPublisher;

    public FirebaseInstallationServiceClient(Context context2, UserAgentPublisher userAgentPublisher2, HeartBeatInfo heartBeatInfo) {
        this.context = context2;
        this.userAgentPublisher = userAgentPublisher2;
        this.heartbeatInfo = heartBeatInfo;
    }

    public InstallationResponse createFirebaseInstallation(String str, String str2, String str3, String str4, String str5) throws IOException {
        int i = 0;
        URL url = new URL(String.format("https://%s/%s/%s?key=%s", FIREBASE_INSTALLATIONS_API_DOMAIN, FIREBASE_INSTALLATIONS_API_VERSION, String.format(CREATE_REQUEST_RESOURCE_NAME_FORMAT, str3), str));
        while (i <= 1) {
            HttpURLConnection openHttpURLConnection = openHttpURLConnection(url);
            try {
                openHttpURLConnection.setRequestMethod(HttpRequest.METHOD_POST);
                openHttpURLConnection.setDoOutput(true);
                if (str5 != null) {
                    openHttpURLConnection.addRequestProperty(X_ANDROID_IID_MIGRATION_KEY, str5);
                }
                writeFIDCreateRequestBodyToOutputStream(openHttpURLConnection, str2, str4);
                int responseCode = openHttpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    InstallationResponse readCreateResponse = readCreateResponse(openHttpURLConnection);
                    openHttpURLConnection.disconnect();
                    return readCreateResponse;
                } else if (responseCode != 429 && (responseCode < 500 || responseCode >= 600)) {
                    return InstallationResponse.builder().setResponseCode(InstallationResponse.ResponseCode.BAD_CONFIG).build();
                } else {
                    i++;
                    openHttpURLConnection.disconnect();
                }
            } finally {
                openHttpURLConnection.disconnect();
            }
        }
        throw new IOException();
    }

    private void writeFIDCreateRequestBodyToOutputStream(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(httpURLConnection.getOutputStream());
        try {
            gZIPOutputStream.write(buildCreateFirebaseInstallationRequestBody(str, str2).toString().getBytes(HttpRequest.CHARSET_UTF8));
            gZIPOutputStream.close();
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        } catch (Throwable th) {
            gZIPOutputStream.close();
            throw th;
        }
    }

    private static JSONObject buildCreateFirebaseInstallationRequestBody(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("fid", str);
        jSONObject.put("appId", str2);
        jSONObject.put("authVersion", FIREBASE_INSTALLATION_AUTH_VERSION);
        jSONObject.put("sdkVersion", "a:16.0.0");
        return jSONObject;
    }

    private void writeGenerateAuthTokenRequestBodyToOutputStream(HttpURLConnection httpURLConnection) throws IOException {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(httpURLConnection.getOutputStream());
        try {
            gZIPOutputStream.write(buildGenerateAuthTokenRequestBody().toString().getBytes(HttpRequest.CHARSET_UTF8));
            gZIPOutputStream.close();
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        } catch (Throwable th) {
            gZIPOutputStream.close();
            throw th;
        }
    }

    private static JSONObject buildGenerateAuthTokenRequestBody() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sdkVersion", "a:16.0.0");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("installation", jSONObject);
        return jSONObject2;
    }

    public void deleteFirebaseInstallation(String str, String str2, String str3, String str4) throws FirebaseException, IOException {
        int i = 0;
        URL url = new URL(String.format("https://%s/%s/%s?key=%s", FIREBASE_INSTALLATIONS_API_DOMAIN, FIREBASE_INSTALLATIONS_API_VERSION, String.format(DELETE_REQUEST_RESOURCE_NAME_FORMAT, str3, str2), str));
        while (i <= 1) {
            HttpURLConnection openHttpURLConnection = openHttpURLConnection(url);
            openHttpURLConnection.setRequestMethod(HttpRequest.METHOD_DELETE);
            openHttpURLConnection.addRequestProperty(HttpRequest.HEADER_AUTHORIZATION, "FIS_v2 " + str4);
            int responseCode = openHttpURLConnection.getResponseCode();
            openHttpURLConnection.disconnect();
            if (responseCode != 200 && responseCode != 401 && responseCode != 404) {
                if (responseCode == 429 || (responseCode >= 500 && responseCode < 600)) {
                    i++;
                } else {
                    throw new FirebaseInstallationsException("bad config while trying to delete FID", FirebaseInstallationsException.Status.BAD_CONFIG);
                }
            } else {
                return;
            }
        }
        throw new IOException();
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0074=Splitter:B:19:0x0074, B:24:0x008c=Splitter:B:24:0x008c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.installations.remote.TokenResult generateAuthToken(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r8
            r8 = 1
            r1[r8] = r7
            java.lang.String r7 = "projects/%s/installations/%s/authTokens:generate"
            java.lang.String r7 = java.lang.String.format(r7, r1)
            java.net.URL r1 = new java.net.URL
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "firebaseinstallations.googleapis.com"
            r3[r2] = r4
            java.lang.String r4 = "v1"
            r3[r8] = r4
            r3[r0] = r7
            r7 = 3
            r3[r7] = r6
            java.lang.String r6 = "https://%s/%s/%s?key=%s"
            java.lang.String r6 = java.lang.String.format(r6, r3)
            r1.<init>(r6)
        L_0x002a:
            if (r2 > r8) goto L_0x00a3
            java.net.HttpURLConnection r6 = r5.openHttpURLConnection(r1)
            java.lang.String r7 = "POST"
            r6.setRequestMethod(r7)     // Catch:{ all -> 0x009e }
            java.lang.String r7 = "Authorization"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x009e }
            r0.<init>()     // Catch:{ all -> 0x009e }
            java.lang.String r3 = "FIS_v2 "
            r0.append(r3)     // Catch:{ all -> 0x009e }
            r0.append(r9)     // Catch:{ all -> 0x009e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x009e }
            r6.addRequestProperty(r7, r0)     // Catch:{ all -> 0x009e }
            r5.writeGenerateAuthTokenRequestBodyToOutputStream(r6)     // Catch:{ all -> 0x009e }
            int r7 = r6.getResponseCode()     // Catch:{ all -> 0x009e }
            r0 = 200(0xc8, float:2.8E-43)
            if (r7 != r0) goto L_0x005e
            com.google.firebase.installations.remote.TokenResult r7 = r5.readGenerateAuthTokenResponse(r6)     // Catch:{ all -> 0x009e }
            r6.disconnect()
            return r7
        L_0x005e:
            r0 = 401(0x191, float:5.62E-43)
            if (r7 == r0) goto L_0x008c
            r0 = 404(0x194, float:5.66E-43)
            if (r7 != r0) goto L_0x0067
            goto L_0x008c
        L_0x0067:
            r0 = 429(0x1ad, float:6.01E-43)
            if (r7 == r0) goto L_0x0086
            r0 = 500(0x1f4, float:7.0E-43)
            if (r7 < r0) goto L_0x0074
            r0 = 600(0x258, float:8.41E-43)
            if (r7 >= r0) goto L_0x0074
            goto L_0x0086
        L_0x0074:
            com.google.firebase.installations.remote.TokenResult$Builder r7 = com.google.firebase.installations.remote.TokenResult.builder()     // Catch:{ all -> 0x009e }
            com.google.firebase.installations.remote.TokenResult$ResponseCode r8 = com.google.firebase.installations.remote.TokenResult.ResponseCode.BAD_CONFIG     // Catch:{ all -> 0x009e }
            com.google.firebase.installations.remote.TokenResult$Builder r7 = r7.setResponseCode(r8)     // Catch:{ all -> 0x009e }
            com.google.firebase.installations.remote.TokenResult r7 = r7.build()     // Catch:{ all -> 0x009e }
            r6.disconnect()
            return r7
        L_0x0086:
            int r2 = r2 + 1
            r6.disconnect()
            goto L_0x002a
        L_0x008c:
            com.google.firebase.installations.remote.TokenResult$Builder r7 = com.google.firebase.installations.remote.TokenResult.builder()     // Catch:{ all -> 0x009e }
            com.google.firebase.installations.remote.TokenResult$ResponseCode r8 = com.google.firebase.installations.remote.TokenResult.ResponseCode.AUTH_ERROR     // Catch:{ all -> 0x009e }
            com.google.firebase.installations.remote.TokenResult$Builder r7 = r7.setResponseCode(r8)     // Catch:{ all -> 0x009e }
            com.google.firebase.installations.remote.TokenResult r7 = r7.build()     // Catch:{ all -> 0x009e }
            r6.disconnect()
            return r7
        L_0x009e:
            r7 = move-exception
            r6.disconnect()
            throw r7
        L_0x00a3:
            java.io.IOException r6 = new java.io.IOException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.remote.FirebaseInstallationServiceClient.generateAuthToken(java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.google.firebase.installations.remote.TokenResult");
    }

    private HttpURLConnection openHttpURLConnection(URL url) throws IOException {
        HeartBeatInfo.HeartBeat heartBeatCode;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.addRequestProperty("Content-Type", "application/json");
        httpURLConnection.addRequestProperty("Accept", "application/json");
        httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.addRequestProperty(X_ANDROID_PACKAGE_HEADER_KEY, this.context.getPackageName());
        HeartBeatInfo heartBeatInfo = this.heartbeatInfo;
        if (!(heartBeatInfo == null || this.userAgentPublisher == null || (heartBeatCode = heartBeatInfo.getHeartBeatCode(FIREBASE_INSTALLATIONS_ID_HEARTBEAT_TAG)) == HeartBeatInfo.HeartBeat.NONE)) {
            httpURLConnection.addRequestProperty(USER_AGENT_HEADER, this.userAgentPublisher.getUserAgent());
            httpURLConnection.addRequestProperty(HEART_BEAT_HEADER, Integer.toString(heartBeatCode.getCode()));
        }
        httpURLConnection.addRequestProperty(X_ANDROID_CERT_HEADER_KEY, getFingerprintHashForPackage());
        return httpURLConnection;
    }

    private InstallationResponse readCreateResponse(HttpURLConnection httpURLConnection) throws IOException {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(httpURLConnection.getInputStream(), UTF_8));
        TokenResult.Builder builder = TokenResult.builder();
        InstallationResponse.Builder builder2 = InstallationResponse.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                builder2.setUri(jsonReader.nextString());
            } else if (nextName.equals("fid")) {
                builder2.setFid(jsonReader.nextString());
            } else if (nextName.equals("refreshToken")) {
                builder2.setRefreshToken(jsonReader.nextString());
            } else if (nextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if (nextName2.equals("token")) {
                        builder.setToken(jsonReader.nextString());
                    } else if (nextName2.equals("expiresIn")) {
                        builder.setTokenExpirationTimestamp(parseTokenExpirationTimestamp(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                builder2.setAuthToken(builder.build());
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        return builder2.setResponseCode(InstallationResponse.ResponseCode.OK).build();
    }

    private TokenResult readGenerateAuthTokenResponse(HttpURLConnection httpURLConnection) throws IOException {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(httpURLConnection.getInputStream(), UTF_8));
        TokenResult.Builder builder = TokenResult.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("token")) {
                builder.setToken(jsonReader.nextString());
            } else if (nextName.equals("expiresIn")) {
                builder.setTokenExpirationTimestamp(parseTokenExpirationTimestamp(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        return builder.setResponseCode(TokenResult.ResponseCode.OK).build();
    }

    private String getFingerprintHashForPackage() {
        try {
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(this.context, this.context.getPackageName());
            if (packageCertificateHashBytes != null) {
                return Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
            }
            Log.e("ContentValues", "Could not get fingerprint hash for package: " + this.context.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("ContentValues", "No such package: " + this.context.getPackageName(), e);
            return null;
        }
    }

    static long parseTokenExpirationTimestamp(String str) {
        Preconditions.checkArgument(EXPIRATION_TIMESTAMP_PATTERN.matcher(str).matches(), PARSING_EXPIRATION_TIME_ERROR_MESSAGE);
        if (str == null || str.length() == 0) {
            return 0;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }
}

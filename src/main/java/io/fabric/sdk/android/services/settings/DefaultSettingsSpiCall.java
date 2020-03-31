package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class DefaultSettingsSpiCall extends AbstractSpiCall implements SettingsSpiCall {
    static final String BUILD_VERSION_PARAM = "build_version";
    static final String DISPLAY_VERSION_PARAM = "display_version";
    static final String HEADER_DEVICE_MODEL = "X-CRASHLYTICS-DEVICE-MODEL";
    static final String HEADER_INSTALLATION_ID = "X-CRASHLYTICS-INSTALLATION-ID";
    static final String HEADER_OS_BUILD_VERSION = "X-CRASHLYTICS-OS-BUILD-VERSION";
    static final String HEADER_OS_DISPLAY_VERSION = "X-CRASHLYTICS-OS-DISPLAY-VERSION";
    static final String ICON_HASH = "icon_hash";
    static final String INSTANCE_PARAM = "instance";
    static final String SOURCE_PARAM = "source";

    /* access modifiers changed from: package-private */
    public boolean requestWasSuccessful(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    public DefaultSettingsSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory) {
        this(kit, str, str2, httpRequestFactory, HttpMethod.GET);
    }

    DefaultSettingsSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod) {
        super(kit, str, str2, httpRequestFactory, httpMethod);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [io.fabric.sdk.android.services.network.HttpRequest] */
    /* JADX WARN: Type inference failed for: r3v2, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0088  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject invoke(io.fabric.sdk.android.services.settings.SettingsRequest r9) {
        /*
            r8 = this;
            java.lang.String r0 = "X-REQUEST-ID"
            java.lang.String r1 = "Settings request ID: "
            java.lang.String r2 = "Fabric"
            r3 = 0
            java.util.Map r4 = r8.getQueryParamsFor(r9)     // Catch:{ HttpRequestException -> 0x006c, all -> 0x006a }
            io.fabric.sdk.android.services.network.HttpRequest r5 = r8.getHttpRequest(r4)     // Catch:{ HttpRequestException -> 0x006c, all -> 0x006a }
            io.fabric.sdk.android.services.network.HttpRequest r5 = r8.applyHeadersTo(r5, r9)     // Catch:{ HttpRequestException -> 0x0068 }
            io.fabric.sdk.android.Logger r9 = io.fabric.sdk.android.Fabric.getLogger()     // Catch:{ HttpRequestException -> 0x0068 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ HttpRequestException -> 0x0068 }
            r6.<init>()     // Catch:{ HttpRequestException -> 0x0068 }
            java.lang.String r7 = "Requesting settings from "
            r6.append(r7)     // Catch:{ HttpRequestException -> 0x0068 }
            java.lang.String r7 = r8.getUrl()     // Catch:{ HttpRequestException -> 0x0068 }
            r6.append(r7)     // Catch:{ HttpRequestException -> 0x0068 }
            java.lang.String r6 = r6.toString()     // Catch:{ HttpRequestException -> 0x0068 }
            r9.d(r2, r6)     // Catch:{ HttpRequestException -> 0x0068 }
            io.fabric.sdk.android.Logger r9 = io.fabric.sdk.android.Fabric.getLogger()     // Catch:{ HttpRequestException -> 0x0068 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ HttpRequestException -> 0x0068 }
            r6.<init>()     // Catch:{ HttpRequestException -> 0x0068 }
            java.lang.String r7 = "Settings query params were: "
            r6.append(r7)     // Catch:{ HttpRequestException -> 0x0068 }
            r6.append(r4)     // Catch:{ HttpRequestException -> 0x0068 }
            java.lang.String r4 = r6.toString()     // Catch:{ HttpRequestException -> 0x0068 }
            r9.d(r2, r4)     // Catch:{ HttpRequestException -> 0x0068 }
            org.json.JSONObject r3 = r8.handleResponse(r5)     // Catch:{ HttpRequestException -> 0x0068 }
            if (r5 == 0) goto L_0x0083
            io.fabric.sdk.android.Logger r9 = io.fabric.sdk.android.Fabric.getLogger()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
        L_0x0056:
            r4.append(r1)
            java.lang.String r0 = r5.header(r0)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r9.d(r2, r0)
            goto L_0x0083
        L_0x0068:
            r9 = move-exception
            goto L_0x006e
        L_0x006a:
            r9 = move-exception
            goto L_0x0086
        L_0x006c:
            r9 = move-exception
            r5 = r3
        L_0x006e:
            io.fabric.sdk.android.Logger r4 = io.fabric.sdk.android.Fabric.getLogger()     // Catch:{ all -> 0x0084 }
            java.lang.String r6 = "Settings request failed."
            r4.e(r2, r6, r9)     // Catch:{ all -> 0x0084 }
            if (r5 == 0) goto L_0x0083
            io.fabric.sdk.android.Logger r9 = io.fabric.sdk.android.Fabric.getLogger()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L_0x0056
        L_0x0083:
            return r3
        L_0x0084:
            r9 = move-exception
            r3 = r5
        L_0x0086:
            if (r3 == 0) goto L_0x00a2
            io.fabric.sdk.android.Logger r4 = io.fabric.sdk.android.Fabric.getLogger()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            java.lang.String r0 = r3.header(r0)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r4.d(r2, r0)
        L_0x00a2:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.settings.DefaultSettingsSpiCall.invoke(io.fabric.sdk.android.services.settings.SettingsRequest):org.json.JSONObject");
    }

    /* access modifiers changed from: package-private */
    public JSONObject handleResponse(HttpRequest httpRequest) {
        int code = httpRequest.code();
        Logger logger = Fabric.getLogger();
        logger.d(Fabric.TAG, "Settings result was: " + code);
        if (requestWasSuccessful(code)) {
            return getJsonObjectFrom(httpRequest.body());
        }
        Logger logger2 = Fabric.getLogger();
        logger2.e(Fabric.TAG, "Failed to retrieve settings from " + getUrl());
        return null;
    }

    private JSONObject getJsonObjectFrom(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            Logger logger = Fabric.getLogger();
            logger.d(Fabric.TAG, "Failed to parse settings JSON from " + getUrl(), e);
            Logger logger2 = Fabric.getLogger();
            logger2.d(Fabric.TAG, "Settings response " + str);
            return null;
        }
    }

    private Map<String, String> getQueryParamsFor(SettingsRequest settingsRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put(BUILD_VERSION_PARAM, settingsRequest.buildVersion);
        hashMap.put(DISPLAY_VERSION_PARAM, settingsRequest.displayVersion);
        hashMap.put("source", Integer.toString(settingsRequest.source));
        if (settingsRequest.iconHash != null) {
            hashMap.put(ICON_HASH, settingsRequest.iconHash);
        }
        String str = settingsRequest.instanceId;
        if (!CommonUtils.isNullOrEmpty(str)) {
            hashMap.put(INSTANCE_PARAM, str);
        }
        return hashMap;
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, SettingsRequest settingsRequest) {
        applyNonNullHeader(httpRequest, AbstractSpiCall.HEADER_API_KEY, settingsRequest.apiKey);
        applyNonNullHeader(httpRequest, AbstractSpiCall.HEADER_CLIENT_TYPE, AbstractSpiCall.ANDROID_CLIENT_TYPE);
        applyNonNullHeader(httpRequest, AbstractSpiCall.HEADER_CLIENT_VERSION, this.kit.getVersion());
        applyNonNullHeader(httpRequest, "Accept", "application/json");
        applyNonNullHeader(httpRequest, HEADER_DEVICE_MODEL, settingsRequest.deviceModel);
        applyNonNullHeader(httpRequest, HEADER_OS_BUILD_VERSION, settingsRequest.osBuildVersion);
        applyNonNullHeader(httpRequest, HEADER_OS_DISPLAY_VERSION, settingsRequest.osDisplayVersion);
        applyNonNullHeader(httpRequest, HEADER_INSTALLATION_ID, settingsRequest.installationId);
        return httpRequest;
    }

    private void applyNonNullHeader(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.header(str, str2);
        }
    }
}

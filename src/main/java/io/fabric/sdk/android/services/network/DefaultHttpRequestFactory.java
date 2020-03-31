package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.DefaultLogger;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class DefaultHttpRequestFactory implements HttpRequestFactory {
    private static final String HTTPS = "https";
    private boolean attemptedSslInit;
    private final Logger logger;
    private PinningInfoProvider pinningInfo;
    private SSLSocketFactory sslSocketFactory;

    public DefaultHttpRequestFactory() {
        this(new DefaultLogger());
    }

    public DefaultHttpRequestFactory(Logger logger2) {
        this.logger = logger2;
    }

    public PinningInfoProvider getPinningInfoProvider() {
        return this.pinningInfo;
    }

    public void setPinningInfoProvider(PinningInfoProvider pinningInfoProvider) {
        if (this.pinningInfo != pinningInfoProvider) {
            this.pinningInfo = pinningInfoProvider;
            resetSSLSocketFactory();
        }
    }

    private synchronized void resetSSLSocketFactory() {
        this.attemptedSslInit = false;
        this.sslSocketFactory = null;
    }

    public HttpRequest buildHttpRequest(HttpMethod httpMethod, String str) {
        return buildHttpRequest(httpMethod, str, Collections.emptyMap());
    }

    /* renamed from: io.fabric.sdk.android.services.network.DefaultHttpRequestFactory$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$fabric$sdk$android$services$network$HttpMethod;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.fabric.sdk.android.services.network.HttpMethod[] r0 = io.fabric.sdk.android.services.network.HttpMethod.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                io.fabric.sdk.android.services.network.DefaultHttpRequestFactory.AnonymousClass1.$SwitchMap$io$fabric$sdk$android$services$network$HttpMethod = r0
                io.fabric.sdk.android.services.network.HttpMethod r1 = io.fabric.sdk.android.services.network.HttpMethod.GET     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = io.fabric.sdk.android.services.network.DefaultHttpRequestFactory.AnonymousClass1.$SwitchMap$io$fabric$sdk$android$services$network$HttpMethod     // Catch:{ NoSuchFieldError -> 0x001d }
                io.fabric.sdk.android.services.network.HttpMethod r1 = io.fabric.sdk.android.services.network.HttpMethod.POST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = io.fabric.sdk.android.services.network.DefaultHttpRequestFactory.AnonymousClass1.$SwitchMap$io$fabric$sdk$android$services$network$HttpMethod     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.fabric.sdk.android.services.network.HttpMethod r1 = io.fabric.sdk.android.services.network.HttpMethod.PUT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = io.fabric.sdk.android.services.network.DefaultHttpRequestFactory.AnonymousClass1.$SwitchMap$io$fabric$sdk$android$services$network$HttpMethod     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.fabric.sdk.android.services.network.HttpMethod r1 = io.fabric.sdk.android.services.network.HttpMethod.DELETE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.network.DefaultHttpRequestFactory.AnonymousClass1.<clinit>():void");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: io.fabric.sdk.android.services.network.HttpRequest.post(java.lang.CharSequence, java.util.Map<?, ?>, boolean):io.fabric.sdk.android.services.network.HttpRequest
     arg types: [java.lang.String, java.util.Map<java.lang.String, java.lang.String>, int]
     candidates:
      io.fabric.sdk.android.services.network.HttpRequest.post(java.lang.CharSequence, boolean, java.lang.Object[]):io.fabric.sdk.android.services.network.HttpRequest
      io.fabric.sdk.android.services.network.HttpRequest.post(java.lang.CharSequence, java.util.Map<?, ?>, boolean):io.fabric.sdk.android.services.network.HttpRequest */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: io.fabric.sdk.android.services.network.HttpRequest.get(java.lang.CharSequence, java.util.Map<?, ?>, boolean):io.fabric.sdk.android.services.network.HttpRequest
     arg types: [java.lang.String, java.util.Map<java.lang.String, java.lang.String>, int]
     candidates:
      io.fabric.sdk.android.services.network.HttpRequest.get(java.lang.CharSequence, boolean, java.lang.Object[]):io.fabric.sdk.android.services.network.HttpRequest
      io.fabric.sdk.android.services.network.HttpRequest.get(java.lang.CharSequence, java.util.Map<?, ?>, boolean):io.fabric.sdk.android.services.network.HttpRequest */
    public HttpRequest buildHttpRequest(HttpMethod httpMethod, String str, Map<String, String> map) {
        HttpRequest httpRequest;
        SSLSocketFactory sSLSocketFactory;
        int i = AnonymousClass1.$SwitchMap$io$fabric$sdk$android$services$network$HttpMethod[httpMethod.ordinal()];
        if (i == 1) {
            httpRequest = HttpRequest.get((CharSequence) str, (Map<?, ?>) map, true);
        } else if (i == 2) {
            httpRequest = HttpRequest.post((CharSequence) str, (Map<?, ?>) map, true);
        } else if (i == 3) {
            httpRequest = HttpRequest.put(str);
        } else if (i == 4) {
            httpRequest = HttpRequest.delete(str);
        } else {
            throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (!(!isHttps(str) || this.pinningInfo == null || (sSLSocketFactory = getSSLSocketFactory()) == null)) {
            ((HttpsURLConnection) httpRequest.getConnection()).setSSLSocketFactory(sSLSocketFactory);
        }
        return httpRequest;
    }

    private boolean isHttps(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith(HTTPS);
    }

    private synchronized SSLSocketFactory getSSLSocketFactory() {
        if (this.sslSocketFactory == null && !this.attemptedSslInit) {
            this.sslSocketFactory = initSSLSocketFactory();
        }
        return this.sslSocketFactory;
    }

    private synchronized SSLSocketFactory initSSLSocketFactory() {
        SSLSocketFactory sSLSocketFactory;
        this.attemptedSslInit = true;
        try {
            sSLSocketFactory = NetworkUtils.getSSLSocketFactory(this.pinningInfo);
            this.logger.d(Fabric.TAG, "Custom SSL pinning enabled");
        } catch (Exception e) {
            this.logger.e(Fabric.TAG, "Exception while validating pinned certs", e);
            return null;
        }
        return sSLSocketFactory;
    }
}

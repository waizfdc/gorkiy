package com.google.android.gms.internal.firebase_ml;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzhp extends zzhd {
    private static final String[] zzaaw;
    private final HostnameVerifier hostnameVerifier;
    private final zzhi zzabu;
    private final SSLSocketFactory zzabv;

    public zzhp() {
        this(null, null, null);
    }

    private zzhp(zzhi zzhi, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier2) {
        zzhl zzhl;
        if (System.getProperty("com.google.api.client.should_use_proxy") != null) {
            zzhl = new zzhl(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("https.proxyHost"), Integer.parseInt(System.getProperty("https.proxyPort")))));
        } else {
            zzhl = new zzhl();
        }
        this.zzabu = zzhl;
        this.zzabv = null;
        this.hostnameVerifier = null;
    }

    public final boolean zzai(String str) {
        return Arrays.binarySearch(zzaaw, str) >= 0;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzhc zzc(String str, String str2) throws IOException {
        Object[] objArr = {str};
        if (zzai(str)) {
            HttpURLConnection zza = this.zzabu.zza(new URL(str2));
            zza.setRequestMethod(str);
            if (zza instanceof HttpsURLConnection) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) zza;
            }
            return new zzhk(zza);
        }
        throw new IllegalArgumentException(zzmn.zzb("HTTP method %s not supported", objArr));
    }

    static {
        String[] strArr = {HttpRequest.METHOD_DELETE, HttpRequest.METHOD_GET, HttpRequest.METHOD_HEAD, HttpRequest.METHOD_OPTIONS, HttpRequest.METHOD_POST, HttpRequest.METHOD_PUT, HttpRequest.METHOD_TRACE};
        zzaaw = strArr;
        Arrays.sort(strArr);
    }
}

package com.google.android.gms.internal.firebase_ml;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final class zzhk extends zzhc {
    private final HttpURLConnection zzabm;

    zzhk(HttpURLConnection httpURLConnection) {
        this.zzabm = httpURLConnection;
        httpURLConnection.setInstanceFollowRedirects(false);
    }

    public final void addHeader(String str, String str2) {
        this.zzabm.addRequestProperty(str, str2);
    }

    public final void zza(int i, int i2) {
        this.zzabm.setReadTimeout(i2);
        this.zzabm.setConnectTimeout(i);
    }

    public final zzhf zzgh() throws IOException {
        HttpURLConnection httpURLConnection = this.zzabm;
        if (zzgg() != null) {
            String contentType = getContentType();
            if (contentType != null) {
                addHeader(HttpRequest.HEADER_CONTENT_TYPE, contentType);
            }
            String contentEncoding = getContentEncoding();
            if (contentEncoding != null) {
                addHeader(HttpRequest.HEADER_CONTENT_ENCODING, contentEncoding);
            }
            long contentLength = getContentLength();
            int i = (contentLength > 0 ? 1 : (contentLength == 0 ? 0 : -1));
            if (i >= 0) {
                httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_LENGTH, Long.toString(contentLength));
            }
            String requestMethod = httpURLConnection.getRequestMethod();
            if (HttpRequest.METHOD_POST.equals(requestMethod) || HttpRequest.METHOD_PUT.equals(requestMethod)) {
                httpURLConnection.setDoOutput(true);
                if (i < 0 || contentLength > 2147483647L) {
                    httpURLConnection.setChunkedStreamingMode(0);
                } else {
                    httpURLConnection.setFixedLengthStreamingMode((int) contentLength);
                }
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    zzgg().writeTo(outputStream);
                    try {
                    } catch (IOException e) {
                        throw e;
                    }
                } finally {
                    try {
                        outputStream.close();
                    } catch (IOException unused) {
                    }
                }
            } else {
                Object[] objArr = {requestMethod};
                if (!(i == 0)) {
                    throw new IllegalArgumentException(zzmn.zzb("%s with non-zero content length is not supported", objArr));
                }
            }
        }
        try {
            httpURLConnection.connect();
            return new zzhn(httpURLConnection);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }
}

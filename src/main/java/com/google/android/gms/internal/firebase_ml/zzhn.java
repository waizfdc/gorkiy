package com.google.android.gms.internal.firebase_ml;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final class zzhn extends zzhf {
    private final int responseCode;
    private final String responseMessage;
    private final HttpURLConnection zzabm;
    private final ArrayList<String> zzabq = new ArrayList<>();
    private final ArrayList<String> zzabr = new ArrayList<>();

    zzhn(HttpURLConnection httpURLConnection) throws IOException {
        this.zzabm = httpURLConnection;
        int responseCode2 = httpURLConnection.getResponseCode();
        this.responseCode = responseCode2 == -1 ? 0 : responseCode2;
        this.responseMessage = httpURLConnection.getResponseMessage();
        ArrayList<String> arrayList = this.zzabq;
        ArrayList<String> arrayList2 = this.zzabr;
        for (Map.Entry next : httpURLConnection.getHeaderFields().entrySet()) {
            String str = (String) next.getKey();
            if (str != null) {
                for (String str2 : (List) next.getValue()) {
                    if (str2 != null) {
                        arrayList.add(str);
                        arrayList2.add(str2);
                    }
                }
            }
        }
    }

    public final int getStatusCode() {
        return this.responseCode;
    }

    public final InputStream getContent() throws IOException {
        InputStream inputStream;
        try {
            inputStream = this.zzabm.getInputStream();
        } catch (IOException unused) {
            inputStream = this.zzabm.getErrorStream();
        }
        if (inputStream == null) {
            return null;
        }
        return new zzhm(this, inputStream);
    }

    public final String getContentEncoding() {
        return this.zzabm.getContentEncoding();
    }

    public final long getContentLength() {
        String headerField = this.zzabm.getHeaderField(HttpRequest.HEADER_CONTENT_LENGTH);
        if (headerField == null) {
            return -1;
        }
        return Long.parseLong(headerField);
    }

    public final String getContentType() {
        return this.zzabm.getHeaderField(HttpRequest.HEADER_CONTENT_TYPE);
    }

    public final String getReasonPhrase() {
        return this.responseMessage;
    }

    public final String zzgi() {
        String headerField = this.zzabm.getHeaderField(0);
        if (headerField == null || !headerField.startsWith("HTTP/1.")) {
            return null;
        }
        return headerField;
    }

    public final int zzgj() {
        return this.zzabq.size();
    }

    public final String zzaf(int i) {
        return this.zzabq.get(i);
    }

    public final String zzag(int i) {
        return this.zzabr.get(i);
    }

    public final void disconnect() {
        this.zzabm.disconnect();
    }
}

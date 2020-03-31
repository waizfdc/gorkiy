package com.google.firebase.ml.common.internal.modeldownload;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzai {
    private final URL url;

    zzai(String str) throws MalformedURLException {
        this.url = new URL(str);
    }

    public final URLConnection openConnection() throws IOException {
        return this.url.openConnection();
    }
}

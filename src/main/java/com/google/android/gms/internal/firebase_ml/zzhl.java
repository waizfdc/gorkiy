package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzhl implements zzhi {
    private final Proxy zzabn;

    public zzhl() {
        this(null);
    }

    public zzhl(Proxy proxy) {
        this.zzabn = proxy;
    }

    public final HttpURLConnection zza(URL url) throws IOException {
        Proxy proxy = this.zzabn;
        return (HttpURLConnection) (proxy == null ? url.openConnection() : url.openConnection(proxy));
    }
}

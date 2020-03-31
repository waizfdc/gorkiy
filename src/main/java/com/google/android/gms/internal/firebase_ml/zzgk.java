package com.google.android.gms.internal.firebase_ml;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzgk implements zzgo {
    public final String getName() {
        return HttpRequest.ENCODING_GZIP;
    }

    public final void zza(zzjm zzjm, OutputStream outputStream) throws IOException {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new zzgn(this, outputStream));
        zzjm.writeTo(gZIPOutputStream);
        gZIPOutputStream.close();
    }
}

package com.google.android.gms.internal.firebase_ml;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzic extends zzht {
    public static zzic zzhq() {
        return zzib.zzaco;
    }

    public final zzhx zza(InputStream inputStream) {
        return zza(new InputStreamReader(inputStream, zzio.UTF_8));
    }

    public final zzhx zza(InputStream inputStream, Charset charset) {
        if (charset == null) {
            return zza(inputStream);
        }
        return zza(new InputStreamReader(inputStream, charset));
    }

    public final zzhx zzam(String str) {
        return zza(new StringReader(str));
    }

    private final zzhx zza(Reader reader) {
        return new zzid(this, new zzsi(reader));
    }

    public final zzhs zza(OutputStream outputStream, Charset charset) {
        return new zzie(this, new zzsj(new OutputStreamWriter(outputStream, charset)));
    }
}

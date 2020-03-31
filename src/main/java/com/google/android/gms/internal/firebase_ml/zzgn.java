package com.google.android.gms.internal.firebase_ml;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzgn extends BufferedOutputStream {
    zzgn(zzgk zzgk, OutputStream outputStream) {
        super(outputStream);
    }

    public final void close() throws IOException {
        try {
            flush();
        } catch (IOException unused) {
        }
    }
}

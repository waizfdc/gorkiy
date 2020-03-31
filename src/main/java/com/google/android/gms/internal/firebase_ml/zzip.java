package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzip extends OutputStream {
    long zzady;

    zzip() {
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.zzady += (long) i2;
    }

    public final void write(int i) throws IOException {
        this.zzady++;
    }
}

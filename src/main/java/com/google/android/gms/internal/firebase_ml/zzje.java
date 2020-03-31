package com.google.android.gms.internal.firebase_ml;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzje extends FilterInputStream {
    private final zzjb zzafs;

    public zzje(InputStream inputStream, Logger logger, Level level, int i) {
        super(inputStream);
        this.zzafs = new zzjb(logger, level, i);
    }

    public final int read() throws IOException {
        int read = super.read();
        this.zzafs.write(read);
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read > 0) {
            this.zzafs.write(bArr, i, read);
        }
        return read;
    }

    public final void close() throws IOException {
        this.zzafs.close();
        super.close();
    }
}

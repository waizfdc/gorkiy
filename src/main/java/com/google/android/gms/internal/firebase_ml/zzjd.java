package com.google.android.gms.internal.firebase_ml;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzjd extends FilterOutputStream {
    private final zzjb zzafs;

    public zzjd(OutputStream outputStream, Logger logger, Level level, int i) {
        super(outputStream);
        this.zzafs = new zzjb(logger, level, i);
    }

    public final void write(int i) throws IOException {
        this.out.write(i);
        this.zzafs.write(i);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        this.zzafs.write(bArr, i, i2);
    }

    public final void close() throws IOException {
        this.zzafs.close();
        super.close();
    }

    public final zzjb zzic() {
        return this.zzafs;
    }
}

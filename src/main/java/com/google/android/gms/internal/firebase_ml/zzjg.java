package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzjg implements zzjm {
    private final Logger logger;
    private final Level zzafr;
    private final zzjm zzzi;
    private final int zzzs;

    public zzjg(zzjm zzjm, Logger logger2, Level level, int i) {
        this.zzzi = zzjm;
        this.logger = logger2;
        this.zzafr = level;
        this.zzzs = i;
    }

    /* JADX INFO: finally extract failed */
    public final void writeTo(OutputStream outputStream) throws IOException {
        zzjd zzjd = new zzjd(outputStream, this.logger, this.zzafr, this.zzzs);
        try {
            this.zzzi.writeTo(zzjd);
            zzjd.zzic().close();
            outputStream.flush();
        } catch (Throwable th) {
            zzjd.zzic().close();
            throw th;
        }
    }
}

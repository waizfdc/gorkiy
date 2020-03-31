package com.google.android.gms.internal.firebase_ml;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzjb extends ByteArrayOutputStream {
    private boolean closed;
    private final Logger logger;
    private int zzafp;
    private final int zzafq;
    private final Level zzafr;

    public zzjb(Logger logger2, Level level, int i) {
        this.logger = (Logger) zzmf.checkNotNull(logger2);
        this.zzafr = (Level) zzmf.checkNotNull(level);
        zzmf.checkArgument(i >= 0);
        this.zzafq = i;
    }

    public final synchronized void write(int i) {
        zzmf.checkArgument(!this.closed);
        this.zzafp++;
        if (this.count < this.zzafq) {
            super.write(i);
        }
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        zzmf.checkArgument(!this.closed);
        this.zzafp += i2;
        if (this.count < this.zzafq) {
            int i3 = this.count + i2;
            if (i3 > this.zzafq) {
                i2 += this.zzafq - i3;
            }
            super.write(bArr, i, i2);
        }
    }

    public final synchronized void close() throws IOException {
        if (!this.closed) {
            if (this.zzafp != 0) {
                StringBuilder sb = new StringBuilder("Total: ");
                zza(sb, this.zzafp);
                if (this.count != 0 && this.count < this.zzafp) {
                    sb.append(" (logging first ");
                    zza(sb, this.count);
                    sb.append(")");
                }
                this.logger.logp(Level.CONFIG, "com.google.api.client.util.LoggingByteArrayOutputStream", "close", sb.toString());
                if (this.count != 0) {
                    this.logger.logp(this.zzafr, "com.google.api.client.util.LoggingByteArrayOutputStream", "close", toString(HttpRequest.CHARSET_UTF8).replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", " "));
                }
            }
            this.closed = true;
        }
    }

    private static void zza(StringBuilder sb, int i) {
        if (i == 1) {
            sb.append("1 byte");
            return;
        }
        sb.append(NumberFormat.getInstance().format((long) i));
        sb.append(" bytes");
    }
}

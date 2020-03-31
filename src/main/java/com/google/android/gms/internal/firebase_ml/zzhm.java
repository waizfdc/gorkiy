package com.google.android.gms.internal.firebase_ml;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final class zzhm extends FilterInputStream {
    private long zzabo = 0;
    private final /* synthetic */ zzhn zzabp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzhm(zzhn zzhn, InputStream inputStream) {
        super(inputStream);
        this.zzabp = zzhn;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read == -1) {
            zzgp();
        } else {
            this.zzabo += (long) read;
        }
        return read;
    }

    public final int read() throws IOException {
        int read = this.in.read();
        if (read == -1) {
            zzgp();
        } else {
            this.zzabo++;
        }
        return read;
    }

    public final long skip(long j) throws IOException {
        long skip = this.in.skip(j);
        this.zzabo += skip;
        return skip;
    }

    private final void zzgp() throws IOException {
        long contentLength = this.zzabp.getContentLength();
        if (contentLength != -1) {
            long j = this.zzabo;
            if (j != 0 && j < contentLength) {
                long j2 = this.zzabo;
                StringBuilder sb = new StringBuilder(102);
                sb.append("Connection closed prematurely: bytesRead = ");
                sb.append(j2);
                sb.append(", Content-Length = ");
                sb.append(contentLength);
                throw new IOException(sb.toString());
            }
        }
    }
}

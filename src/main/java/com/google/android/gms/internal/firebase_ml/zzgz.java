package com.google.android.gms.internal.firebase_ml;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzgz {
    private final int statusCode;
    private final String zzaam;
    private InputStream zzaan;
    private final String zzaao;
    private final String zzaap;
    private zzhf zzaaq;
    private final zzgu zzaar;
    private boolean zzaas;
    private final zzgv zzzb;
    private int zzzs;
    private boolean zzzt;

    zzgz(zzgu zzgu, zzhf zzhf) throws IOException {
        StringBuilder sb;
        this.zzaar = zzgu;
        this.zzzs = zzgu.zzfu();
        this.zzzt = zzgu.zzfv();
        this.zzaaq = zzhf;
        this.zzaao = zzhf.getContentEncoding();
        int statusCode2 = zzhf.getStatusCode();
        boolean z = false;
        this.statusCode = statusCode2 < 0 ? 0 : statusCode2;
        String reasonPhrase = zzhf.getReasonPhrase();
        this.zzaam = reasonPhrase;
        Logger logger = zzhd.zzaav;
        if (this.zzzt && logger.isLoggable(Level.CONFIG)) {
            z = true;
        }
        zzgv zzgv = null;
        if (z) {
            sb = new StringBuilder();
            sb.append("-------------- RESPONSE --------------");
            sb.append(zzjl.zzafu);
            String zzgi = zzhf.zzgi();
            if (zzgi != null) {
                sb.append(zzgi);
            } else {
                sb.append(this.statusCode);
                if (reasonPhrase != null) {
                    sb.append(' ');
                    sb.append(reasonPhrase);
                }
            }
            sb.append(zzjl.zzafu);
        } else {
            sb = null;
        }
        zzgu.zzfx().zza(zzhf, z ? sb : null);
        String contentType = zzhf.getContentType();
        contentType = contentType == null ? zzgu.zzfx().getContentType() : contentType;
        this.zzaap = contentType;
        this.zzzb = contentType != null ? new zzgv(contentType) : zzgv;
        if (z) {
            logger.logp(Level.CONFIG, "com.google.api.client.http.HttpResponse", "<init>", sb.toString());
        }
    }

    public final String getContentType() {
        return this.zzaap;
    }

    public final zzgt zzfw() {
        return this.zzaar.zzfx();
    }

    public final boolean zzgd() {
        int i = this.statusCode;
        return i >= 200 && i < 300;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMessage() {
        return this.zzaam;
    }

    public final InputStream getContent() throws IOException {
        if (!this.zzaas) {
            zzje content = this.zzaaq.getContent();
            if (content != null) {
                try {
                    String str = this.zzaao;
                    if (str != null && str.contains(HttpRequest.ENCODING_GZIP)) {
                        content = new GZIPInputStream(content);
                    }
                    Logger logger = zzhd.zzaav;
                    if (this.zzzt && logger.isLoggable(Level.CONFIG)) {
                        content = new zzje(content, logger, Level.CONFIG, this.zzzs);
                    }
                    this.zzaan = content;
                } catch (EOFException unused) {
                    content.close();
                } catch (Throwable th) {
                    content.close();
                    throw th;
                }
            }
            this.zzaas = true;
        }
        return this.zzaan;
    }

    public final void ignore() throws IOException {
        InputStream content = getContent();
        if (content != null) {
            content.close();
        }
    }

    public final void disconnect() throws IOException {
        ignore();
        this.zzaaq.disconnect();
    }

    public final <T> T zza(Class<T> cls) throws IOException {
        int i = this.statusCode;
        boolean z = true;
        if (this.zzaar.getRequestMethod().equals(HttpRequest.METHOD_HEAD) || i / 100 == 1 || i == 204 || i == 304) {
            ignore();
            z = false;
        }
        if (!z) {
            return null;
        }
        return this.zzaar.zzfz().zza(getContent(), zzgf(), cls);
    }

    /* JADX INFO: finally extract failed */
    public final String zzge() throws IOException {
        InputStream content = getContent();
        if (content == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            zzmf.checkNotNull(content);
            zzmf.checkNotNull(byteArrayOutputStream);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = content.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    content.close();
                    return byteArrayOutputStream.toString(zzgf().name());
                }
            }
        } catch (Throwable th) {
            content.close();
            throw th;
        }
    }

    private final Charset zzgf() {
        zzgv zzgv = this.zzzb;
        return (zzgv == null || zzgv.zzgc() == null) ? zzio.ISO_8859_1 : this.zzzb.zzgc();
    }
}

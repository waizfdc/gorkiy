package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public abstract class zzhc {
    private String zzaao;
    private String zzaap;
    private long zzaat = -1;
    private zzjm zzaau;

    public abstract void addHeader(String str, String str2) throws IOException;

    public void zza(int i, int i2) throws IOException {
    }

    public abstract zzhf zzgh() throws IOException;

    public final void setContentLength(long j) throws IOException {
        this.zzaat = j;
    }

    public final long getContentLength() {
        return this.zzaat;
    }

    public final void setContentEncoding(String str) throws IOException {
        this.zzaao = str;
    }

    public final String getContentEncoding() {
        return this.zzaao;
    }

    public final void setContentType(String str) throws IOException {
        this.zzaap = str;
    }

    public final String getContentType() {
        return this.zzaap;
    }

    public final void zza(zzjm zzjm) throws IOException {
        this.zzaau = zzjm;
    }

    public final zzjm zzgg() {
        return this.zzaau;
    }
}

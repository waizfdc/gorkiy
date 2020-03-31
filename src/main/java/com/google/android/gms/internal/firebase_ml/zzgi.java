package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public abstract class zzgi implements zzgp {
    private zzgv zzzb;
    private long zzzc;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    protected zzgi(String str) {
        this(str == null ? null : new zzgv(str));
    }

    public final boolean zzfp() {
        return true;
    }

    private zzgi(zzgv zzgv) {
        this.zzzc = -1;
        this.zzzb = zzgv;
    }

    public final long getLength() throws IOException {
        if (this.zzzc == -1) {
            this.zzzc = zzja.zzb(this);
        }
        return this.zzzc;
    }

    /* access modifiers changed from: protected */
    public final Charset zzfo() {
        zzgv zzgv = this.zzzb;
        return (zzgv == null || zzgv.zzgc() == null) ? zzio.UTF_8 : this.zzzb.zzgc();
    }

    public final String getType() {
        zzgv zzgv = this.zzzb;
        if (zzgv == null) {
            return null;
        }
        return zzgv.zzfq();
    }
}

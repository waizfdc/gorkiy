package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzgr implements zzjm {
    private final zzjm zzzi;
    private final zzgo zzzj;

    public zzgr(zzjm zzjm, zzgo zzgo) {
        this.zzzi = (zzjm) zzmf.checkNotNull(zzjm);
        this.zzzj = (zzgo) zzmf.checkNotNull(zzgo);
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        this.zzzj.zza(this.zzzi, outputStream);
    }
}

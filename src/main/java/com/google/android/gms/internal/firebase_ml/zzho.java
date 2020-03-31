package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzho extends zzgi {
    private final Object data;
    private final zzht zzabs;
    private String zzabt;

    public zzho(zzht zzht, Object obj) {
        super("application/json; charset=UTF-8");
        this.zzabs = (zzht) zzmf.checkNotNull(zzht);
        this.data = zzmf.checkNotNull(obj);
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        zzhs zza = this.zzabs.zza(outputStream, zzfo());
        if (this.zzabt != null) {
            zza.zzgt();
            zza.zzal(this.zzabt);
        }
        zza.zzc(this.data);
        if (this.zzabt != null) {
            zza.zzgu();
        }
        zza.flush();
    }

    public final zzho zzak(String str) {
        this.zzabt = str;
        return this;
    }
}

package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzhv implements zzji {
    private final zzht zzabs;
    private final Set<String> zzabx;

    protected zzhv(zzhu zzhu) {
        this.zzabs = zzhu.zzabs;
        this.zzabx = new HashSet(zzhu.zzabw);
    }

    public final <T> T zza(InputStream inputStream, Charset charset, Class<T> cls) throws IOException {
        zzhx zza = this.zzabs.zza(inputStream, charset);
        if (!this.zzabx.isEmpty()) {
            try {
                boolean z = (zza.zza(this.zzabx) == null || zza.zzhb() == zzhz.END_OBJECT) ? false : true;
                Object[] objArr = {this.zzabx};
                if (!z) {
                    throw new IllegalArgumentException(zzmn.zzb("wrapper key(s) not found: %s", objArr));
                }
            } catch (Throwable th) {
                zza.close();
                throw th;
            }
        }
        return zza.zza(cls, true, null);
    }

    public final zzht zzfm() {
        return this.zzabs;
    }

    public final Set<String> zzgy() {
        return Collections.unmodifiableSet(this.zzabx);
    }
}

package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class zzgc implements zzgf {
    private final String key;
    private final String zzyx;

    public zzgc() {
        this(null);
    }

    public zzgc(String str) {
        this(str, null);
    }

    private zzgc(String str, String str2) {
        this.key = str;
        this.zzyx = null;
    }

    public void zza(zzgb<?> zzgb) throws IOException {
        String str = this.key;
        if (str != null) {
            zzgb.put("key", str);
        }
    }
}

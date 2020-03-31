package com.google.android.gms.internal.firebase_ml;

import java.nio.charset.Charset;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzij {
    public static String zzd(byte[] bArr) {
        Charset charset = zzif.UTF_8;
        if (bArr == null) {
            return null;
        }
        return new String(bArr, charset);
    }
}

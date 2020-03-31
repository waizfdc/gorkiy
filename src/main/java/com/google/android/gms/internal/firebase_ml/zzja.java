package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzja {
    /* JADX INFO: finally extract failed */
    public static long zzb(zzjm zzjm) throws IOException {
        zzip zzip = new zzip();
        try {
            zzjm.writeTo(zzip);
            zzip.close();
            return zzip.zzady;
        } catch (Throwable th) {
            zzip.close();
            throw th;
        }
    }
}

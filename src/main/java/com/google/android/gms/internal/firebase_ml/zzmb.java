package com.google.android.gms.internal.firebase_ml;

import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzmb {
    private static final Logger logger = Logger.getLogger(zzmb.class.getName());
    private static final zzmc zzagx = new zza();

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    static final class zza {
        private zza() {
        }
    }

    private zzmb() {
    }

    static String zzba(@NullableDecl String str) {
        return str == null ? "" : str;
    }

    static boolean zzaz(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }
}

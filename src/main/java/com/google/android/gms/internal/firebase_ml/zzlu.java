package com.google.android.gms.internal.firebase_ml;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzlu extends zzlr {
    static final zzlu zzags = new zzlu();

    private zzlu() {
        super("CharMatcher.none()");
    }

    public final boolean zzb(char c) {
        return false;
    }

    public final int zza(CharSequence charSequence, int i) {
        zzmf.zza(i, charSequence.length(), FirebaseAnalytics.Param.INDEX);
        return -1;
    }
}

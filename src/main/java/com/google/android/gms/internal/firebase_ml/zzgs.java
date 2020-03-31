package com.google.android.gms.internal.firebase_ml;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzgs {
    final zzin zzzk;
    final StringBuilder zzzl;
    final zzir zzzm;
    final List<Type> zzzn;

    public zzgs(zzgt zzgt, StringBuilder sb) {
        Class<?> cls = zzgt.getClass();
        this.zzzn = Arrays.asList(cls);
        this.zzzm = zzir.zza(cls, true);
        this.zzzl = sb;
        this.zzzk = new zzin(zzgt);
    }
}

package com.google.android.gms.internal.firebase_ml;

import android.graphics.Rect;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzqy {
    public static String zzbt(int i) {
        if (i == 1) {
            return "builtin/stable";
        }
        if (i != 2) {
            return null;
        }
        return "builtin/latest";
    }

    public static String zzcc(String str) {
        return str == null ? "" : str;
    }

    public static float zza(Float f) {
        if (f == null) {
            return 0.0f;
        }
        return f.floatValue();
    }

    private static int zzc(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static Rect zza(zzkh zzkh, float f) {
        if (zzkh == null || zzkh.zzij() == null || zzkh.zzij().size() != 4) {
            return null;
        }
        int i = 0;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        for (zzli next : zzkh.zzij()) {
            i2 = Math.min(zzc(next.zziu()), i2);
            i3 = Math.min(zzc(next.zziv()), i3);
            i = Math.max(zzc(next.zziu()), i);
            i4 = Math.max(zzc(next.zziv()), i4);
        }
        return new Rect(Math.round(((float) i2) * f), Math.round(((float) i3) * f), Math.round(((float) i) * f), Math.round(((float) i4) * f));
    }
}

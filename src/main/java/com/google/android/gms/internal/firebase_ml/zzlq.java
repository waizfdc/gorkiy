package com.google.android.gms.internal.firebase_ml;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public abstract class zzlq {
    public static zzlq zza(char c) {
        return new zzls(',');
    }

    public abstract boolean zzb(char c);

    protected zzlq() {
    }

    public int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        zzmf.zza(i, length, FirebaseAnalytics.Param.INDEX);
        while (i < length) {
            if (zzb(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static String zzc(char c) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }
}

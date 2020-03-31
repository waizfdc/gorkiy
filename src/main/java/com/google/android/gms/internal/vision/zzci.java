package com.google.android.gms.internal.vision;

import kotlin.text.Typography;

/* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
public enum zzci implements zzgw {
    MODE_TYPE_UNKNOWN(0),
    FAST(1),
    ACCURATE(2),
    SELFIE(3);
    
    private static final zzgv<zzci> zzgy = new zzch();
    private final int value;

    public final int zzag() {
        return this.value;
    }

    public static zzci zzq(int i) {
        if (i == 0) {
            return MODE_TYPE_UNKNOWN;
        }
        if (i == 1) {
            return FAST;
        }
        if (i == 2) {
            return ACCURATE;
        }
        if (i != 3) {
            return null;
        }
        return SELFIE;
    }

    public static zzgy zzah() {
        return zzcj.zzhb;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
    }

    private zzci(int i) {
        this.value = i;
    }
}

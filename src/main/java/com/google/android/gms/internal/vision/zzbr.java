package com.google.android.gms.internal.vision;

import kotlin.text.Typography;

/* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
public enum zzbr implements zzgw {
    ROTATION_0(0),
    ROTATION_90(1),
    ROTATION_180(2),
    ROTATION_270(3);
    
    private static final zzgv<zzbr> zzgy = new zzbt();
    private final int value;

    public final int zzag() {
        return this.value;
    }

    public static zzbr zzh(int i) {
        if (i == 0) {
            return ROTATION_0;
        }
        if (i == 1) {
            return ROTATION_90;
        }
        if (i == 2) {
            return ROTATION_180;
        }
        if (i != 3) {
            return null;
        }
        return ROTATION_270;
    }

    public static zzgy zzah() {
        return zzbs.zzhb;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
    }

    private zzbr(int i) {
        this.value = i;
    }
}

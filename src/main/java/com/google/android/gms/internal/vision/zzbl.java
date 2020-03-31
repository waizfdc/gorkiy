package com.google.android.gms.internal.vision;

import kotlin.text.Typography;

/* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
public enum zzbl implements zzgw {
    RGBA(0),
    NV21(1),
    RGB(2),
    GRAY(3),
    GRAY16(4);
    
    private static final zzgv<zzbl> zzgy = new zzbo();
    private final int value;

    public final int zzag() {
        return this.value;
    }

    public static zzbl zze(int i) {
        if (i == 0) {
            return RGBA;
        }
        if (i == 1) {
            return NV21;
        }
        if (i == 2) {
            return RGB;
        }
        if (i == 3) {
            return GRAY;
        }
        if (i != 4) {
            return null;
        }
        return GRAY16;
    }

    public static zzgy zzah() {
        return zzbn.zzhb;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
    }

    private zzbl(int i) {
        this.value = i;
    }
}

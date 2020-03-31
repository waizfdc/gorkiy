package com.google.android.gms.internal.vision;

import kotlin.text.Typography;

/* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
public enum zzce implements zzgw {
    LANDMARK_TYPE_UNKNOWN(0),
    NO_LANDMARK(1),
    ALL_LANDMARKS(2),
    CONTOUR_LANDMARKS(3);
    
    private static final zzgv<zzce> zzgy = new zzcg();
    private final int value;

    public final int zzag() {
        return this.value;
    }

    public static zzce zzp(int i) {
        if (i == 0) {
            return LANDMARK_TYPE_UNKNOWN;
        }
        if (i == 1) {
            return NO_LANDMARK;
        }
        if (i == 2) {
            return ALL_LANDMARKS;
        }
        if (i != 3) {
            return null;
        }
        return CONTOUR_LANDMARKS;
    }

    public static zzgy zzah() {
        return zzcf.zzhb;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
    }

    private zzce(int i) {
        this.value = i;
    }
}

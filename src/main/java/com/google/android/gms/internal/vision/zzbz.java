package com.google.android.gms.internal.vision;

import kotlin.text.Typography;

/* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
public enum zzbz implements zzgw {
    CLASSIFICATION_TYPE_UNKNOWN(0),
    NO_CLASSIFICATION(1),
    ALL_CLASSIFICATIONS(2);
    
    private static final zzgv<zzbz> zzgy = new zzcb();
    private final int value;

    public final int zzag() {
        return this.value;
    }

    public static zzbz zzn(int i) {
        if (i == 0) {
            return CLASSIFICATION_TYPE_UNKNOWN;
        }
        if (i == 1) {
            return NO_CLASSIFICATION;
        }
        if (i != 2) {
            return null;
        }
        return ALL_CLASSIFICATIONS;
    }

    public static zzgy zzah() {
        return zzca.zzhb;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
    }

    private zzbz(int i) {
        this.value = i;
    }
}

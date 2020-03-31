package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzpp<T> {
    private final String zzbcv;
    private final T zzbcw;

    public static <T> zzpp<T> zzj(String str, T t) {
        return new zzpp<>(str, t);
    }

    private zzpp(String str, T t) {
        if (str != null) {
            this.zzbcv = str;
            if (t != null) {
                this.zzbcw = t;
                return;
            }
            throw new NullPointerException("Null options");
        }
        throw new NullPointerException("Null firebasePersistentKey");
    }

    public final String toString() {
        String str = this.zzbcv;
        String valueOf = String.valueOf(this.zzbcw);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 58 + String.valueOf(valueOf).length());
        sb.append("MlModelDriverInstanceKey{firebasePersistentKey=");
        sb.append(str);
        sb.append(", options=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzpp) {
            zzpp zzpp = (zzpp) obj;
            return this.zzbcv.equals(zzpp.zzbcv) && this.zzbcw.equals(zzpp.zzbcw);
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzbcv, this.zzbcw);
    }
}

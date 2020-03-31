package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzwz implements zzxh {
    private zzxh[] zzcfj;

    zzwz(zzxh... zzxhArr) {
        this.zzcfj = zzxhArr;
    }

    public final boolean zzh(Class<?> cls) {
        for (zzxh zzh : this.zzcfj) {
            if (zzh.zzh(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzxe zzi(Class<?> cls) {
        for (zzxh zzxh : this.zzcfj) {
            if (zzxh.zzh(cls)) {
                return zzxh.zzi(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}

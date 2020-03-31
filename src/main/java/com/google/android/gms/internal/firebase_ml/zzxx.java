package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zzvx;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzxx implements zzxe {
    private final int flags;
    private final String info;
    private final Object[] zzcfu;
    private final zzxg zzcfx;

    zzxx(zzxg zzxg, String str, Object[] objArr) {
        this.zzcfx = zzxg;
        this.info = str;
        this.zzcfu = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.flags = c | (charAt2 << i);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzvl() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzvm() {
        return this.zzcfu;
    }

    public final zzxg zzvc() {
        return this.zzcfx;
    }

    public final int zzva() {
        return (this.flags & 1) == 1 ? zzvx.zzf.zzcds : zzvx.zzf.zzcdt;
    }

    public final boolean zzvb() {
        return (this.flags & 2) == 2;
    }
}

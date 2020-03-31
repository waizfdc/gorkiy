package com.google.android.gms.internal.fitness;

import com.google.android.gms.internal.fitness.zzgg;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzhz implements zzhm {
    private final int flags;
    private final String info;
    private final zzho zzxm;
    private final Object[] zzxt = null;

    zzhz(zzho zzho, String str, Object[] objArr) {
        this.zzxm = zzho;
        this.info = str;
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
    public final String zzcn() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzco() {
        return this.zzxt;
    }

    public final zzho zzcj() {
        return this.zzxm;
    }

    public final int zzch() {
        return (this.flags & 1) == 1 ? zzgg.zze.zzvt : zzgg.zze.zzvu;
    }

    public final boolean zzci() {
        return (this.flags & 2) == 2;
    }
}

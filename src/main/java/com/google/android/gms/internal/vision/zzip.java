package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzip implements zzia {
    private final int flags;
    private final String info;
    private final Object[] zzyv;
    private final zzic zzyy;

    zzip(zzic zzic, String str, Object[] objArr) {
        this.zzyy = zzic;
        this.info = str;
        this.zzyv = objArr;
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
    public final String zzhp() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzhq() {
        return this.zzyv;
    }

    public final zzic zzhk() {
        return this.zzyy;
    }

    public final int zzhi() {
        return (this.flags & 1) == 1 ? zzgs.zzf.zzwt : zzgs.zzf.zzwu;
    }

    public final boolean zzhj() {
        return (this.flags & 2) == 2;
    }
}

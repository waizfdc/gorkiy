package com.google.android.gms.internal.firebase_ml;

import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzxy {
    private final ArrayDeque<zzuq> zzcgw;

    private zzxy() {
        this.zzcgw = new ArrayDeque<>();
    }

    /* access modifiers changed from: private */
    public final zzuq zzc(zzuq zzuq, zzuq zzuq2) {
        zzf(zzuq);
        zzf(zzuq2);
        zzuq pop = this.zzcgw.pop();
        while (!this.zzcgw.isEmpty()) {
            pop = new zzxw(this.zzcgw.pop(), pop, null);
        }
        return pop;
    }

    private final void zzf(zzuq zzuq) {
        while (!zzuq.zzsx()) {
            if (zzuq instanceof zzxw) {
                zzxw zzxw = (zzxw) zzuq;
                zzf(zzxw.zzcgs);
                zzuq = zzxw.zzcgt;
            } else {
                String valueOf = String.valueOf(zzuq.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        int zzdv = zzdv(zzuq.size());
        int i = zzxw.zzcgq[zzdv + 1];
        if (this.zzcgw.isEmpty() || this.zzcgw.peek().size() >= i) {
            this.zzcgw.push(zzuq);
            return;
        }
        int i2 = zzxw.zzcgq[zzdv];
        zzuq pop = this.zzcgw.pop();
        while (!this.zzcgw.isEmpty() && this.zzcgw.peek().size() < i2) {
            pop = new zzxw(this.zzcgw.pop(), pop, null);
        }
        zzxw zzxw2 = new zzxw(pop, zzuq, null);
        while (!this.zzcgw.isEmpty()) {
            if (this.zzcgw.peek().size() >= zzxw.zzcgq[zzdv(zzxw2.size()) + 1]) {
                break;
            }
            zzxw2 = new zzxw(this.zzcgw.pop(), zzxw2, null);
        }
        this.zzcgw.push(zzxw2);
    }

    private static int zzdv(int i) {
        int binarySearch = Arrays.binarySearch(zzxw.zzcgq, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    /* synthetic */ zzxy(zzxz zzxz) {
        this();
    }
}

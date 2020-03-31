package com.google.android.gms.internal.vision;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzfj implements Comparator<zzfh> {
    zzfj() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzfh zzfh = (zzfh) obj;
        zzfh zzfh2 = (zzfh) obj2;
        zzfq zzfq = (zzfq) zzfh.iterator();
        zzfq zzfq2 = (zzfq) zzfh2.iterator();
        while (zzfq.hasNext() && zzfq2.hasNext()) {
            int compare = Integer.compare(zzfh.zza(zzfq.nextByte()), zzfh.zza(zzfq2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzfh.size(), zzfh2.size());
    }
}

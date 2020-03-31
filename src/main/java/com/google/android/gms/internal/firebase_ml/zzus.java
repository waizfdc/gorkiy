package com.google.android.gms.internal.firebase_ml;

import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzus implements Comparator<zzuq> {
    zzus() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzuq zzuq = (zzuq) obj;
        zzuq zzuq2 = (zzuq) obj2;
        zzuz zzuz = (zzuz) zzuq.iterator();
        zzuz zzuz2 = (zzuz) zzuq2.iterator();
        while (zzuz.hasNext() && zzuz2.hasNext()) {
            int compare = Integer.compare(zzuq.zzb(zzuz.nextByte()), zzuq.zzb(zzuz2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzuq.size(), zzuq2.size());
    }
}

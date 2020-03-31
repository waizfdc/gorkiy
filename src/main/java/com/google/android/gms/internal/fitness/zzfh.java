package com.google.android.gms.internal.fitness;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzfh implements Comparator<zzff> {
    zzfh() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzff zzff = (zzff) obj;
        zzff zzff2 = (zzff) obj2;
        zzfk zzfk = (zzfk) zzff.iterator();
        zzfk zzfk2 = (zzfk) zzff2.iterator();
        while (zzfk.hasNext() && zzfk2.hasNext()) {
            int compare = Integer.compare(zzff.zza(zzfk.nextByte()), zzff.zza(zzfk2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzff.size(), zzff2.size());
    }
}

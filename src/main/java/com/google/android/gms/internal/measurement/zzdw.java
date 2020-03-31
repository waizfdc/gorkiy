package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
final class zzdw implements Comparator<zzdu> {
    zzdw() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzdu zzdu = (zzdu) obj;
        zzdu zzdu2 = (zzdu) obj2;
        zzed zzed = (zzed) zzdu.iterator();
        zzed zzed2 = (zzed) zzdu2.iterator();
        while (zzed.hasNext() && zzed2.hasNext()) {
            int compare = Integer.compare(zzdu.zzb(zzed.zza()), zzdu.zzb(zzed2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzdu.zza(), zzdu2.zza());
    }
}

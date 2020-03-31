package com.google.android.gms.internal.firebase_ml;

import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zziq implements Comparator<String> {
    zziq(zzir zzir) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        if (zzma.equal(str, str2)) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        return str.compareTo(str2);
    }
}

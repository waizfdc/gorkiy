package com.google.android.gms.internal.fitness;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzi {
    public static <T> int zza(T t, List<T> list) {
        if (t == null) {
            return -1;
        }
        int indexOf = list.indexOf(t);
        if (indexOf >= 0) {
            return indexOf;
        }
        list.add(t);
        return list.size() - 1;
    }
}

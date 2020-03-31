package com.google.android.gms.internal.vision;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzdn extends zzdf<Map.Entry<K, V>> {
    private final /* synthetic */ zzdk zzmb;

    zzdn(zzdk zzdk) {
        this.zzmb = zzdk;
    }

    public final int size() {
        return this.zzmb.size;
    }

    public final /* synthetic */ Object get(int i) {
        zzct.zzc(i, this.zzmb.size);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.zzmb.zzlx[i2], this.zzmb.zzlx[i2 + 1]);
    }
}

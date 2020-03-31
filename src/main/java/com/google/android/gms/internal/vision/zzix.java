package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzix extends zzjd {
    private final /* synthetic */ zziw zzaab;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzix(zziw zziw) {
        super(zziw, null);
        this.zzaab = zziw;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zziy(this.zzaab, null);
    }

    /* synthetic */ zzix(zziw zziw, zziv zziv) {
        this(zziw);
    }
}

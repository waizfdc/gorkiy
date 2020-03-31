package com.google.android.gms.internal.vision;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzdm<K> extends zzdj<K> {
    private final transient zzdf<K> zzlm;
    private final transient zzdg<K, ?> zzlw;

    zzdm(zzdg<K, ?> zzdg, zzdf<K> zzdf) {
        this.zzlw = zzdg;
        this.zzlm = zzdf;
    }

    public final zzdr<K> zzby() {
        return (zzdr) zzcc().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzcc().zza(objArr, i);
    }

    public final zzdf<K> zzcc() {
        return this.zzlm;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zzlw.get(obj) != null;
    }

    public final int size() {
        return this.zzlw.size();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}

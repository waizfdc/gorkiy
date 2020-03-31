package com.google.android.gms.internal.vision;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzjq implements Iterator<String> {
    private final /* synthetic */ zzjo zzaan;
    private Iterator<String> zzabj = this.zzaan.zzaao.iterator();

    zzjq(zzjo zzjo) {
        this.zzaan = zzjo;
    }

    public final boolean hasNext() {
        return this.zzabj.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.zzabj.next();
    }
}

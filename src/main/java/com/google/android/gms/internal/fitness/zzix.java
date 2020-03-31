package com.google.android.gms.internal.fitness;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzix implements Iterator<String> {
    private Iterator<String> zzzf = this.zzzg.zzze.iterator();
    private final /* synthetic */ zziv zzzg;

    zzix(zziv zziv) {
        this.zzzg = zziv;
    }

    public final boolean hasNext() {
        return this.zzzf.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.zzzf.next();
    }
}

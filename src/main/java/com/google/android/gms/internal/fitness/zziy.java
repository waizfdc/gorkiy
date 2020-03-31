package com.google.android.gms.internal.fitness;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zziy implements ListIterator<String> {
    private final /* synthetic */ zziv zzzg;
    private ListIterator<String> zzzh = this.zzzg.zzze.listIterator(this.zzzi);
    private final /* synthetic */ int zzzi;

    zziy(zziv zziv, int i) {
        this.zzzg = zziv;
        this.zzzi = i;
    }

    public final boolean hasNext() {
        return this.zzzh.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzzh.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzzh.nextIndex();
    }

    public final int previousIndex() {
        return this.zzzh.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object previous() {
        return this.zzzh.previous();
    }

    public final /* synthetic */ Object next() {
        return this.zzzh.next();
    }
}

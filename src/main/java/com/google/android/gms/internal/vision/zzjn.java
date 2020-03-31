package com.google.android.gms.internal.vision;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzjn implements ListIterator<String> {
    private ListIterator<String> zzaal = this.zzaan.zzaao.listIterator(this.zzaam);
    private final /* synthetic */ int zzaam;
    private final /* synthetic */ zzjo zzaan;

    zzjn(zzjo zzjo, int i) {
        this.zzaan = zzjo;
        this.zzaam = i;
    }

    public final boolean hasNext() {
        return this.zzaal.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzaal.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzaal.nextIndex();
    }

    public final int previousIndex() {
        return this.zzaal.previousIndex();
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
        return this.zzaal.previous();
    }

    public final /* synthetic */ Object next() {
        return this.zzaal.next();
    }
}

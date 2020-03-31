package com.google.android.gms.internal.fitness;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zziv extends AbstractList<String> implements zzgv, RandomAccess {
    /* access modifiers changed from: private */
    public final zzgv zzze;

    public zziv(zzgv zzgv) {
        this.zzze = zzgv;
    }

    public final zzgv zzby() {
        return this;
    }

    public final Object zzad(int i) {
        return this.zzze.zzad(i);
    }

    public final int size() {
        return this.zzze.size();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zziy(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzix(this);
    }

    public final List<?> zzbx() {
        return this.zzze.zzbx();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzze.get(i);
    }
}

package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
public final class zzia extends AbstractList<String> implements zzfv, RandomAccess {
    /* access modifiers changed from: private */
    public final zzfv zza;

    public zzia(zzfv zzfv) {
        this.zza = zzfv;
    }

    public final zzfv g_() {
        return this;
    }

    public final Object zzb(int i) {
        return this.zza.zzb(i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final void zza(zzdu zzdu) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzhz(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzic(this);
    }

    public final List<?> zzb() {
        return this.zza.zzb();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }
}

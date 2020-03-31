package com.google.android.gms.internal.firebase_ml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzwo extends zzuk<String> implements zzwr, RandomAccess {
    private static final zzwo zzceu;
    private static final zzwr zzcev = zzceu;
    private final List<Object> zzcew;

    public zzwo() {
        this(10);
    }

    public zzwo(int i) {
        this(new ArrayList(i));
    }

    private zzwo(ArrayList<Object> arrayList) {
        this.zzcew = arrayList;
    }

    public final int size() {
        return this.zzcew.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzsq();
        if (collection instanceof zzwr) {
            collection = ((zzwr) collection).zzur();
        }
        boolean addAll = this.zzcew.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzsq();
        this.zzcew.clear();
        this.modCount++;
    }

    public final void zze(zzuq zzuq) {
        zzsq();
        this.zzcew.add(zzuq);
        this.modCount++;
    }

    public final Object getRaw(int i) {
        return this.zzcew.get(i);
    }

    private static String zzs(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzuq) {
            return ((zzuq) obj).zzsu();
        }
        return zzvy.zzj((byte[]) obj);
    }

    public final List<?> zzur() {
        return Collections.unmodifiableList(this.zzcew);
    }

    public final zzwr zzus() {
        return zzso() ? new zzyx(this) : this;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        zzsq();
        return zzs(this.zzcew.set(i, (String) obj));
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* synthetic */ Object remove(int i) {
        zzsq();
        Object remove = this.zzcew.remove(i);
        this.modCount++;
        return zzs(remove);
    }

    public final /* bridge */ /* synthetic */ boolean zzso() {
        return super.zzso();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzsq();
        this.zzcew.add(i, (String) obj);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ zzwh zzcr(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzcew);
            return new zzwo(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzcew.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzuq) {
            zzuq zzuq = (zzuq) obj;
            String zzsu = zzuq.zzsu();
            if (zzuq.zzsv()) {
                this.zzcew.set(i, zzsu);
            }
            return zzsu;
        }
        byte[] bArr = (byte[]) obj;
        String zzj = zzvy.zzj(bArr);
        if (zzvy.zzi(bArr)) {
            this.zzcew.set(i, zzj);
        }
        return zzj;
    }

    static {
        zzwo zzwo = new zzwo();
        zzceu = zzwo;
        super.zzsp();
    }
}

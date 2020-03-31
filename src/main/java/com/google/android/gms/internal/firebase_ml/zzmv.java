package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzmv<E> extends zzmr<E> {
    static final zzmr<Object> zzaip = new zzmv(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzaiq;

    zzmv(Object[] objArr, int i) {
        this.zzaiq = objArr;
        this.size = i;
    }

    /* access modifiers changed from: package-private */
    public final int zzje() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzjh() {
        return false;
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzjd() {
        return this.zzaiq;
    }

    /* access modifiers changed from: package-private */
    public final int zzjf() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzaiq, 0, objArr, 0, this.size);
        return this.size + 0;
    }

    public final E get(int i) {
        zzmf.zzb(i, this.size);
        return this.zzaiq[i];
    }
}

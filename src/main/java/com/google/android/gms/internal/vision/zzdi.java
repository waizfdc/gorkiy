package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzdi<E> extends zzdf<E> {
    static final zzdf<Object> zzlt = new zzdi(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzlu;

    zzdi(Object[] objArr, int i) {
        this.zzlu = objArr;
        this.size = i;
    }

    /* access modifiers changed from: package-private */
    public final int zzca() {
        return 0;
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzbz() {
        return this.zzlu;
    }

    /* access modifiers changed from: package-private */
    public final int zzcb() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzlu, 0, objArr, i, this.size);
        return i + this.size;
    }

    public final E get(int i) {
        zzct.zzc(i, this.size);
        return this.zzlu[i];
    }
}

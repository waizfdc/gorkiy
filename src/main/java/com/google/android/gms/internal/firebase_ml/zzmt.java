package com.google.android.gms.internal.firebase_ml;

import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzmt extends zzmr<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzmr zzaio;

    zzmt(zzmr zzmr, int i, int i2) {
        this.zzaio = super;
        this.offset = i;
        this.length = i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzjh() {
        return true;
    }

    public final int size() {
        return this.length;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzjd() {
        return this.zzaio.zzjd();
    }

    /* access modifiers changed from: package-private */
    public final int zzje() {
        return this.zzaio.zzje() + this.offset;
    }

    /* access modifiers changed from: package-private */
    public final int zzjf() {
        return this.zzaio.zzje() + this.offset + this.length;
    }

    public final E get(int i) {
        zzmf.zzb(i, this.length);
        return this.zzaio.get(i + this.offset);
    }

    public final zzmr<E> zzd(int i, int i2) {
        zzmf.zza(i, i2, this.length);
        zzmr zzmr = this.zzaio;
        int i3 = this.offset;
        return (zzmr) super.subList(i + i3, i2 + i3);
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}

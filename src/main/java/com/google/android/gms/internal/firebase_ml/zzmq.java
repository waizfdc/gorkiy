package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzmq<E> extends zzmp<E> {
    private final zzmr<E> zzaim;

    zzmq(zzmr<E> zzmr, int i) {
        super(zzmr.size(), i);
        this.zzaim = zzmr;
    }

    /* access modifiers changed from: protected */
    public final E get(int i) {
        return this.zzaim.get(i);
    }
}

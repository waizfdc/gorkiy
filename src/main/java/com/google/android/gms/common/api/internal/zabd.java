package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
abstract class zabd {
    private final zabb zahq;

    protected zabd(zabb zabb) {
        this.zahq = zabb;
    }

    /* access modifiers changed from: protected */
    public abstract void zaal();

    public final void zaa(zabe zabe) {
        zabe.zaer.lock();
        try {
            if (zabe.zahu == this.zahq) {
                zaal();
                zabe.zaer.unlock();
            }
        } finally {
            zabe.zaer.unlock();
        }
    }
}

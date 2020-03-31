package com.google.android.gms.internal.fitness;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzfe extends zzfg {
    private final int limit = this.zzrh.size();
    private int position = 0;
    private final /* synthetic */ zzff zzrh;

    zzfe(zzff zzff) {
        this.zzrh = zzff;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzrh.zzi(i);
        }
        throw new NoSuchElementException();
    }
}

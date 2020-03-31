package com.google.android.gms.internal.fitness;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzfn {
    private final byte[] buffer;
    private final zzfs zzro;

    private zzfn(int i) {
        byte[] bArr = new byte[i];
        this.buffer = bArr;
        this.zzro = zzfs.zza(bArr);
    }

    public final zzff zzat() {
        if (this.zzro.zzaw() == 0) {
            return new zzfp(this.buffer);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final zzfs zzau() {
        return this.zzro;
    }

    /* synthetic */ zzfn(int i, zzfe zzfe) {
        this(i);
    }
}

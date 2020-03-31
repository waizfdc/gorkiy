package com.google.android.gms.internal.firebase_ml;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzik {
    byte[] buffer;
    boolean eof;
    int pos;
    int zzadl;
    int zzadm;
    int zzadn;
    int zzado;

    zzik() {
    }

    public final String toString() {
        return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.zzadn), Boolean.valueOf(this.eof), Integer.valueOf(this.zzadl), 0L, Integer.valueOf(this.zzado), Integer.valueOf(this.pos), Integer.valueOf(this.zzadm));
    }
}

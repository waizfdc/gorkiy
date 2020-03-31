package com.google.firebase.ml.common.internal.modeldownload;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzs {
    public static final zzs zzbet = new zzs(zzr.OK, null);
    private final zzr zzbeu;
    private final String zzbev;

    public zzs(zzr zzr, String str) {
        this.zzbeu = zzr;
        this.zzbev = str;
    }

    public final boolean isValid() {
        return this.zzbeu == zzr.OK;
    }

    public final zzr zzoh() {
        return this.zzbeu;
    }
}

package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzls extends zzlp {
    private final char zzagr;

    zzls(char c) {
        this.zzagr = c;
    }

    public final boolean zzb(char c) {
        return c == this.zzagr;
    }

    public final String toString() {
        String zzd = zzlq.zzc(this.zzagr);
        StringBuilder sb = new StringBuilder(String.valueOf(zzd).length() + 18);
        sb.append("CharMatcher.is('");
        sb.append(zzd);
        sb.append("')");
        return sb.toString();
    }
}

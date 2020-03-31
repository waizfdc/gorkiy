package com.google.android.gms.fitness.data;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzaj {
    private final double zzmm;
    private final double zzmn;

    private zzaj(double d, double d2) {
        this.zzmm = d;
        this.zzmn = d2;
    }

    public final boolean zza(double d) {
        return d >= this.zzmm && d <= this.zzmn;
    }
}

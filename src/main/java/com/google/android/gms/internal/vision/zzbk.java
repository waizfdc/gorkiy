package com.google.android.gms.internal.vision;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public final class zzbk {
    final String zzgk;
    final Uri zzgl;
    final String zzgm;
    final String zzgn;
    final boolean zzgo;
    final boolean zzgp;
    final boolean zzgq;
    final boolean zzgr;
    @Nullable
    final zzcl<Context, Boolean> zzgs;

    public zzbk(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    private zzbk(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable zzcl<Context, Boolean> zzcl) {
        this.zzgk = str;
        this.zzgl = uri;
        this.zzgm = str2;
        this.zzgn = str3;
        this.zzgo = z;
        this.zzgp = z2;
        this.zzgq = z3;
        this.zzgr = z4;
        this.zzgs = zzcl;
    }

    public final zzbk zzf(String str) {
        boolean z = this.zzgo;
        if (!z) {
            return new zzbk(this.zzgk, this.zzgl, str, this.zzgn, z, this.zzgp, this.zzgq, this.zzgr, this.zzgs);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzbe<Boolean> zza(String str, boolean z) {
        return zzbe.zza(this, str, z);
    }

    public final <T> zzbe<T> zza(String str, T t, zzbh<T> zzbh) {
        return zzbe.zza(this, str, t, zzbh);
    }
}

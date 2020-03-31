package com.google.android.gms.internal.firebase_ml;

import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzke extends zzhq {
    @zzjc
    private List<zzkq> features;
    @zzjc
    private zzkp image;
    @zzjc
    private zzkr imageContext;

    public final zzke zzb(List<zzkq> list) {
        this.features = list;
        return this;
    }

    public final zzke zza(zzkp zzkp) {
        this.image = zzkp;
        return this;
    }

    public final zzke zza(zzkr zzkr) {
        this.imageContext = zzkr;
        return this;
    }

    public final /* synthetic */ zzhq zza(String str, Object obj) {
        return (zzke) zzb(str, obj);
    }

    public final /* synthetic */ zzhq zzfa() {
        return (zzke) clone();
    }

    public final /* synthetic */ zziy zzfb() {
        return (zzke) clone();
    }

    public final /* synthetic */ zziy zzb(String str, Object obj) {
        return (zzke) super.zzb(str, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (zzke) super.clone();
    }
}

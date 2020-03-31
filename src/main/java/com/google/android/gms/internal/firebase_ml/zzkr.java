package com.google.android.gms.internal.firebase_ml;

import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzkr extends zzhq {
    @zzjc
    private zzkj cropHintsParams;
    @zzjc
    private List<String> languageHints;
    @zzjc
    private zzkv latLongRect;
    @zzjc
    private zzkz productSearchParams;
    @zzjc
    private zzlk webDetectionParams;

    public final zzkr zzd(List<String> list) {
        this.languageHints = list;
        return this;
    }

    public final /* synthetic */ zzhq zza(String str, Object obj) {
        return (zzkr) zzb(str, obj);
    }

    public final /* synthetic */ zzhq zzfa() {
        return (zzkr) clone();
    }

    public final /* synthetic */ zziy zzfb() {
        return (zzkr) clone();
    }

    public final /* synthetic */ zziy zzb(String str, Object obj) {
        return (zzkr) super.zzb(str, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (zzkr) super.clone();
    }
}

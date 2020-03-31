package com.google.android.gms.internal.firebase_ml;

import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzlj extends zzhq {
    @zzjc
    private zzkh boundingBox;
    @zzjc
    private Float confidence;
    @zzjc
    private zzlf property;
    @zzjc
    private List<zzld> symbols;

    public final zzkh zzik() {
        return this.boundingBox;
    }

    public final Float getConfidence() {
        return this.confidence;
    }

    public final zzlf zzil() {
        return this.property;
    }

    public final List<zzld> getSymbols() {
        return this.symbols;
    }

    public final /* synthetic */ zzhq zza(String str, Object obj) {
        return (zzlj) zzb(str, obj);
    }

    public final /* synthetic */ zzhq zzfa() {
        return (zzlj) clone();
    }

    public final /* synthetic */ zziy zzfb() {
        return (zzlj) clone();
    }

    public final /* synthetic */ zziy zzb(String str, Object obj) {
        return (zzlj) super.zzb(str, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (zzlj) super.clone();
    }
}

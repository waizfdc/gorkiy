package com.google.android.gms.internal.firebase_ml;

import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzla extends zzhq {
    @zzjc
    private zzkh boundingBox;
    @zzjc
    private Float confidence;
    @zzjc
    private zzlf property;
    @zzjc
    private List<zzlj> words;

    public final zzkh zzik() {
        return this.boundingBox;
    }

    public final Float getConfidence() {
        return this.confidence;
    }

    public final zzlf zzil() {
        return this.property;
    }

    public final List<zzlj> getWords() {
        return this.words;
    }

    public final /* synthetic */ zzhq zza(String str, Object obj) {
        return (zzla) zzb(str, obj);
    }

    public final /* synthetic */ zzhq zzfa() {
        return (zzla) clone();
    }

    public final /* synthetic */ zziy zzfb() {
        return (zzla) clone();
    }

    public final /* synthetic */ zziy zzb(String str, Object obj) {
        return (zzla) super.zzb(str, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (zzla) super.clone();
    }
}

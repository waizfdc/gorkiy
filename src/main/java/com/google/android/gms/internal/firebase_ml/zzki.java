package com.google.android.gms.internal.firebase_ml;

import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzki extends zzhq {
    @zzjc
    private String blockType;
    @zzjc
    private zzkh boundingBox;
    @zzjc
    private Float confidence;
    @zzjc
    private List<zzla> paragraphs;
    @zzjc
    private zzlf property;

    public final zzkh zzik() {
        return this.boundingBox;
    }

    public final Float getConfidence() {
        return this.confidence;
    }

    public final List<zzla> getParagraphs() {
        return this.paragraphs;
    }

    public final zzlf zzil() {
        return this.property;
    }

    public final /* synthetic */ zzhq zza(String str, Object obj) {
        return (zzki) zzb(str, obj);
    }

    public final /* synthetic */ zzhq zzfa() {
        return (zzki) clone();
    }

    public final /* synthetic */ zziy zzfb() {
        return (zzki) clone();
    }

    public final /* synthetic */ zziy zzb(String str, Object obj) {
        return (zzki) super.zzb(str, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (zzki) super.clone();
    }
}

package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzld extends zzhq {
    @zzjc
    private zzkh boundingBox;
    @zzjc
    private Float confidence;
    @zzjc
    private zzlf property;
    @zzjc
    private String text;

    public final zzkh zzik() {
        return this.boundingBox;
    }

    public final Float getConfidence() {
        return this.confidence;
    }

    public final zzlf zzil() {
        return this.property;
    }

    public final String getText() {
        return this.text;
    }

    public final /* synthetic */ zzhq zza(String str, Object obj) {
        return (zzld) zzb(str, obj);
    }

    public final /* synthetic */ zzhq zzfa() {
        return (zzld) clone();
    }

    public final /* synthetic */ zziy zzfb() {
        return (zzld) clone();
    }

    public final /* synthetic */ zziy zzb(String str, Object obj) {
        return (zzld) super.zzb(str, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (zzld) super.clone();
    }
}

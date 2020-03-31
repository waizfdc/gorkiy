package com.google.android.gms.internal.firebase_ml;

import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzkn extends zzhq {
    @zzjc
    private zzkh boundingPoly;
    @zzjc
    private Float confidence;
    @zzjc
    private String description;
    @zzjc
    private String locale;
    @zzjc
    private List<zzky> locations;
    @zzjc
    private String mid;
    @zzjc
    private List<Object> properties;
    @zzjc
    private Float score;
    @zzjc
    private Float topicality;

    public final zzkh zzin() {
        return this.boundingPoly;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<zzky> getLocations() {
        return this.locations;
    }

    public final String getMid() {
        return this.mid;
    }

    public final Float zzio() {
        return this.score;
    }

    public final /* synthetic */ zzhq zza(String str, Object obj) {
        return (zzkn) zzb(str, obj);
    }

    public final /* synthetic */ zzhq zzfa() {
        return (zzkn) clone();
    }

    public final /* synthetic */ zziy zzfb() {
        return (zzkn) clone();
    }

    public final /* synthetic */ zziy zzb(String str, Object obj) {
        return (zzkn) super.zzb(str, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (zzkn) super.clone();
    }
}

package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzkq extends zzhq {
    @zzjc
    private Integer maxResults;
    @zzjc
    private String model;
    @zzjc
    private String type;

    public final zzkq zza(Integer num) {
        this.maxResults = num;
        return this;
    }

    public final zzkq zzaw(String str) {
        this.model = str;
        return this;
    }

    public final zzkq zzax(String str) {
        this.type = str;
        return this;
    }

    public final /* synthetic */ zzhq zza(String str, Object obj) {
        return (zzkq) zzb(str, obj);
    }

    public final /* synthetic */ zzhq zzfa() {
        return (zzkq) clone();
    }

    public final /* synthetic */ zziy zzfb() {
        return (zzkq) clone();
    }

    public final /* synthetic */ zziy zzb(String str, Object obj) {
        return (zzkq) super.zzb(str, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (zzkq) super.clone();
    }
}

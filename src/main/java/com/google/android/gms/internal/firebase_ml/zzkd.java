package com.google.android.gms.internal.firebase_ml;

import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzkd extends zzhq {
    @zzjc
    private zzks context;
    @zzjc
    private zzkk cropHintsAnnotation;
    @zzjc
    private zzle error;
    @zzjc
    private List<Object> faceAnnotations;
    @zzjc
    private zzlg fullTextAnnotation;
    @zzjc
    private zzku imagePropertiesAnnotation;
    @zzjc
    private List<zzkn> labelAnnotations;
    @zzjc
    private List<zzkn> landmarkAnnotations;
    @zzjc
    private List<Object> localizedObjectAnnotations;
    @zzjc
    private List<zzkn> logoAnnotations;
    @zzjc
    private zzlc productSearchResults;
    @zzjc
    private zzlb safeSearchAnnotation;
    @zzjc
    private List<zzkn> textAnnotations;
    @zzjc
    private zzlh webDetection;

    public final zzlg zzif() {
        return this.fullTextAnnotation;
    }

    public final List<zzkn> zzig() {
        return this.labelAnnotations;
    }

    public final List<zzkn> zzih() {
        return this.landmarkAnnotations;
    }

    public final /* synthetic */ zzhq zza(String str, Object obj) {
        return (zzkd) zzb(str, obj);
    }

    public final /* synthetic */ zzhq zzfa() {
        return (zzkd) clone();
    }

    public final /* synthetic */ zziy zzfb() {
        return (zzkd) clone();
    }

    public final /* synthetic */ zziy zzb(String str, Object obj) {
        return (zzkd) super.zzb(str, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (zzkd) super.clone();
    }
}

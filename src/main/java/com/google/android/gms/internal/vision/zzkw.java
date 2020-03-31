package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public final class zzkw implements zzku {
    private static final zzbe<Boolean> zzagh;
    private static final zzbe<Boolean> zzagi;
    private static final zzbe<Boolean> zzagj;
    private static final zzbe<Boolean> zzagk;
    private static final zzbe<Boolean> zzagl;
    private static final zzbe<Boolean> zzagm;
    private static final zzbe<Boolean> zzagn;
    private static final zzbe<Boolean> zzago;
    private static final zzbe<Boolean> zzagp;

    public final boolean zzjp() {
        return zzagi.get().booleanValue();
    }

    public final boolean zzjq() {
        return zzagm.get().booleanValue();
    }

    static {
        zzbk zzf = new zzbk(zzbb.getContentProviderUri("com.google.android.gms.vision.sdk")).zzf("vision.sdk:");
        zzagh = zzf.zza("OptionalModule__enable_barcode_optional_module", false);
        zzagi = zzf.zza("OptionalModule__enable_barcode_optional_module_v25", false);
        zzagj = zzf.zza("OptionalModule__enable_face_optional_module", false);
        zzagk = zzf.zza("OptionalModule__enable_face_optional_module_v25", true);
        zzagl = zzf.zza("OptionalModule__enable_ica_optional_module", false);
        zzagm = zzf.zza("OptionalModule__enable_ica_optional_module_v25", false);
        zzagn = zzf.zza("OptionalModule__enable_ocr_optional_module", false);
        zzago = zzf.zza("OptionalModule__enable_ocr_optional_module_v25", false);
        zzagp = zzf.zza("OptionalModule__enable_old_download_path", true);
    }
}

package com.google.android.gms.internal.firebase_ml;

import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class zzfw extends zzhq {
    @zzjc
    private int code;
    @zzjc
    private List<zza> errors;
    @zzjc
    private String message;

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class zza extends zzhq {
        @zzjc
        private String domain;
        @zzjc
        private String location;
        @zzjc
        private String locationType;
        @zzjc
        private String message;
        @zzjc
        private String reason;

        public final String getReason() {
            return this.reason;
        }

        public final /* synthetic */ zzhq zza(String str, Object obj) {
            return (zza) zzb(str, obj);
        }

        public final /* synthetic */ zzhq zzfa() {
            return (zza) clone();
        }

        public final /* synthetic */ zziy zzfb() {
            return (zza) clone();
        }

        public final /* synthetic */ zziy zzb(String str, Object obj) {
            return (zza) super.zzb(str, obj);
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return (zza) super.clone();
        }
    }

    public final List<zza> zzez() {
        return this.errors;
    }

    public final /* synthetic */ zzhq zza(String str, Object obj) {
        return (zzfw) zzb(str, obj);
    }

    public final /* synthetic */ zzhq zzfa() {
        return (zzfw) clone();
    }

    public final /* synthetic */ zziy zzfb() {
        return (zzfw) clone();
    }

    public final /* synthetic */ zziy zzb(String str, Object obj) {
        return (zzfw) super.zzb(str, obj);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (zzfw) super.clone();
    }

    static {
        zzit.zzd(zza.class);
    }
}

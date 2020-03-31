package com.google.firebase.ml.common.internal.modeldownload;

import android.net.Uri;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzaa {
    private final zzn zzbfi;
    private final String zzbfl;
    /* access modifiers changed from: private */
    public final Uri zzbfm;
    /* access modifiers changed from: private */
    public final String zzbfn;

    public zzaa(String str, Uri uri, String str2, zzn zzn) {
        this.zzbfl = str;
        this.zzbfm = uri;
        this.zzbfn = str2;
        this.zzbfi = zzn;
    }

    public final String zzou() {
        return this.zzbfl;
    }

    public final String getModelHash() {
        return this.zzbfn;
    }

    public final zzn zzov() {
        return this.zzbfi;
    }
}

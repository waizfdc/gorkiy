package com.google.android.gms.internal.firebase_ml;

import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzqx implements zzpg {
    public final List<zzkq> features;
    public final zzkr imageContext;
    public final byte[] zzbkd;
    public final float zzbke;

    public zzqx(byte[] bArr, float f, List<zzkq> list, zzkr zzkr) {
        this.zzbkd = bArr;
        this.zzbke = f;
        this.features = list;
        this.imageContext = zzkr;
    }
}

package com.google.android.gms.internal.firebase_ml;

import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.vision.cloud.FirebaseVisionCloudDetectorOptions;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public abstract class zzra<ResultType> implements Closeable {
    private final zzkr imageContext;
    protected final zzpn zzbdc;
    private final zzpj zzbgn;
    private final zzqz zzbki;
    private final zzkq zzbkj;

    protected zzra(zzpn zzpn, String str, FirebaseVisionCloudDetectorOptions firebaseVisionCloudDetectorOptions) {
        this(zzpn, new zzkq().zza(Integer.valueOf(firebaseVisionCloudDetectorOptions.getMaxResults())).zzax(str).zzaw(zzqy.zzbt(firebaseVisionCloudDetectorOptions.getModelType())), (zzkr) null, firebaseVisionCloudDetectorOptions.isEnforceCertFingerprintMatch());
    }

    public void close() throws IOException {
    }

    /* access modifiers changed from: protected */
    public abstract ResultType zza(zzkd zzkd, float f);

    /* access modifiers changed from: protected */
    public abstract int zzpt();

    /* access modifiers changed from: protected */
    public abstract int zzpu();

    protected zzra(zzpn zzpn, String str, zzkr zzkr, boolean z) {
        this(zzpn, new zzkq().zzax(str).zzaw(zzqy.zzbt(1)), (zzkr) Preconditions.checkNotNull(zzkr, "ImageContext must not be null"), z);
    }

    private zzra(zzpn zzpn, zzkq zzkq, zzkr zzkr, boolean z) {
        Preconditions.checkNotNull(zzpn, "MlKitContext must not be null");
        Preconditions.checkNotNull(zzpn.getPersistenceKey(), "Firebase app name must not be null");
        this.zzbkj = (zzkq) Preconditions.checkNotNull(zzkq);
        this.zzbgn = zzpj.zza(zzpn);
        this.zzbki = new zzqz(this, zzpn.zznq(), z);
        this.zzbdc = zzpn;
        this.imageContext = zzkr;
    }

    public final Task<ResultType> zza(FirebaseVisionImage firebaseVisionImage) {
        Preconditions.checkNotNull(firebaseVisionImage, "Input image can not be null");
        Pair<byte[], Float> zze = firebaseVisionImage.zze(zzpt(), zzpu());
        if (zze.first == null) {
            return Tasks.forException(new FirebaseMLException("Can not convert the image format", 3));
        }
        return this.zzbgn.zza(this.zzbki, new zzqx((byte[]) zze.first, ((Float) zze.second).floatValue(), Collections.singletonList(this.zzbkj), this.imageContext));
    }
}

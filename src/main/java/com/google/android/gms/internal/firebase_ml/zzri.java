package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.vision.Frame;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class zzri<TDetectionResult> implements Closeable {
    private final zzpj zzbgn;
    private final zzpc<TDetectionResult, zzrl> zzbli;

    protected zzri(zzpn zzpn, zzpc<TDetectionResult, zzrl> zzpc) {
        Preconditions.checkNotNull(zzpn, "MlKitContext must not be null");
        Preconditions.checkNotNull(zzpn.getPersistenceKey(), "Persistence key must not be null");
        this.zzbli = zzpc;
        zzpj zza = zzpj.zza(zzpn);
        this.zzbgn = zza;
        zza.zza(zzpc);
    }

    /* access modifiers changed from: protected */
    public final Task<TDetectionResult> zza(FirebaseVisionImage firebaseVisionImage, boolean z, boolean z2) {
        Preconditions.checkNotNull(firebaseVisionImage, "FirebaseVisionImage can not be null");
        Frame zza = firebaseVisionImage.zza(z, z2);
        if (zza.getMetadata().getWidth() < 32 || zza.getMetadata().getHeight() < 32) {
            return Tasks.forException(new FirebaseMLException("Image width and height should be at least 32!", 3));
        }
        return this.zzbgn.zza(this.zzbli, new zzrl(firebaseVisionImage, zza));
    }

    public void close() throws IOException {
        this.zzbgn.zzb(this.zzbli);
    }
}

package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.cloud.FirebaseVisionCloudDetectorOptions;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.label.FirebaseVisionImageLabel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzrr extends zzra<List<FirebaseVisionImageLabel>> {
    public zzrr(zzpn zzpn, FirebaseVisionCloudDetectorOptions firebaseVisionCloudDetectorOptions) {
        super(zzpn, "LABEL_DETECTION", firebaseVisionCloudDetectorOptions);
        zzpo.zza(zzpn, 1).zza(zzng.zzab.zzln(), zznu.CLOUD_IMAGE_LABEL_CREATE);
    }

    /* access modifiers changed from: protected */
    public final int zzpt() {
        return 640;
    }

    /* access modifiers changed from: protected */
    public final int zzpu() {
        return 480;
    }

    public final Task<List<FirebaseVisionImageLabel>> detectInImage(FirebaseVisionImage firebaseVisionImage) {
        zzpo.zza(this.zzbdc, 1).zza(zzng.zzab.zzln(), zznu.CLOUD_IMAGE_LABEL_DETECT);
        return super.zza(firebaseVisionImage);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zza(zzkd zzkd, float f) {
        if (zzkd.zzig() == null) {
            return new ArrayList();
        }
        List<zzkn> zzig = zzkd.zzig();
        ArrayList arrayList = new ArrayList();
        for (zzkn zza : zzig) {
            FirebaseVisionImageLabel zza2 = FirebaseVisionImageLabel.zza(zza);
            if (zza2 != null) {
                arrayList.add(zza2);
            }
        }
        return arrayList;
    }
}

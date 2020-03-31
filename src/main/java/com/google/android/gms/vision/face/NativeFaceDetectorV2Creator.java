package com.google.android.gms.vision.face;

import android.content.Context;
import com.google.android.gms.internal.vision.zzl;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.internal.client.zzh;

/* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
public class NativeFaceDetectorV2Creator extends ChimeraNativeBaseFaceDetectorCreator {
    /* access modifiers changed from: protected */
    public final zzh zza(Context context, Context context2, DynamiteClearcutLogger dynamiteClearcutLogger, zzf zzf) {
        if (!zzl.zza(context2, "face", "libface_detector_v2_jni.so")) {
            return null;
        }
        return new NativeFaceDetectorV2Impl(context, context2, dynamiteClearcutLogger, zzf, new FaceDetectorV2Jni());
    }
}

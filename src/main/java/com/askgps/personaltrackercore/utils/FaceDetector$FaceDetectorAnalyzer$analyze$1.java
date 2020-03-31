package com.askgps.personaltrackercore.utils;

import androidx.camera.core.ImageProxy;
import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.utils.FaceDetector;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.face.FirebaseVisionFace;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "faces", "", "Lcom/google/firebase/ml/vision/face/FirebaseVisionFace;", "kotlin.jvm.PlatformType", "", "onSuccess"}, k = 3, mv = {1, 1, 16})
/* compiled from: FaceDetector.kt */
final class FaceDetector$FaceDetectorAnalyzer$analyze$1<TResult> implements OnSuccessListener<List<FirebaseVisionFace>> {
    final /* synthetic */ ImageProxy $image;
    final /* synthetic */ FaceDetector.FaceDetectorAnalyzer this$0;

    FaceDetector$FaceDetectorAnalyzer$analyze$1(FaceDetector.FaceDetectorAnalyzer faceDetectorAnalyzer, ImageProxy imageProxy) {
        this.this$0 = faceDetectorAnalyzer;
        this.$image = imageProxy;
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        onSuccess((List<FirebaseVisionFace>) ((List) obj));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.askgps.personaltrackercore.LogKt.toLog$default(java.lang.Iterable, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object):void
     arg types: [java.util.List<com.google.firebase.ml.vision.face.FirebaseVisionFace>, java.lang.String, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], int, ?[OBJECT, ARRAY]]
     candidates:
      com.askgps.personaltrackercore.LogKt.toLog$default(java.lang.Object, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object):void
      com.askgps.personaltrackercore.LogKt.toLog$default(java.lang.Throwable, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object):void
      com.askgps.personaltrackercore.LogKt.toLog$default(java.lang.Iterable, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object):void */
    public final void onSuccess(List<FirebaseVisionFace> list) {
        Intrinsics.checkExpressionValueIsNotNull(list, "faces");
        LogKt.toLog$default((Iterable) list, "face detected", (String) null, (String) null, 6, (Object) null);
        if (list.size() > 0) {
            this.this$0.OnSuccessListener.invoke(this.$image);
        } else {
            this.$image.close();
        }
    }
}

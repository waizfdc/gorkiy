package com.askgps.personaltrackercore.utils;

import androidx.camera.core.ImageProxy;
import com.askgps.personaltrackercore.LogKt;
import com.google.android.gms.tasks.OnFailureListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "e", "Ljava/lang/Exception;", "onFailure"}, k = 3, mv = {1, 1, 16})
/* compiled from: FaceDetector.kt */
final class FaceDetector$FaceDetectorAnalyzer$analyze$2 implements OnFailureListener {
    final /* synthetic */ ImageProxy $image;

    FaceDetector$FaceDetectorAnalyzer$analyze$2(ImageProxy imageProxy) {
        this.$image = imageProxy;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.askgps.personaltrackercore.LogKt.toLog$default(java.lang.Throwable, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object):void
     arg types: [java.lang.Exception, java.lang.String, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], int, ?[OBJECT, ARRAY]]
     candidates:
      com.askgps.personaltrackercore.LogKt.toLog$default(java.lang.Iterable, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object):void
      com.askgps.personaltrackercore.LogKt.toLog$default(java.lang.Object, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object):void
      com.askgps.personaltrackercore.LogKt.toLog$default(java.lang.Throwable, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object):void */
    public final void onFailure(Exception exc) {
        Intrinsics.checkParameterIsNotNull(exc, "e");
        LogKt.toLog$default((Throwable) exc, "error face detected", (String) null, (String) null, 6, (Object) null);
        this.$image.close();
    }
}

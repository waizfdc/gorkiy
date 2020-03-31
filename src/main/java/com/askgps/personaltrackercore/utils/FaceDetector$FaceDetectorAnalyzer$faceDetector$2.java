package com.askgps.personaltrackercore.utils;

import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/google/firebase/ml/vision/face/FirebaseVisionFaceDetector;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: FaceDetector.kt */
final class FaceDetector$FaceDetectorAnalyzer$faceDetector$2 extends Lambda implements Function0<FirebaseVisionFaceDetector> {
    public static final FaceDetector$FaceDetectorAnalyzer$faceDetector$2 INSTANCE = new FaceDetector$FaceDetectorAnalyzer$faceDetector$2();

    FaceDetector$FaceDetectorAnalyzer$faceDetector$2() {
        super(0);
    }

    public final FirebaseVisionFaceDetector invoke() {
        return FirebaseVision.getInstance().getVisionFaceDetector(FaceDetector.Companion.getOptions());
    }
}

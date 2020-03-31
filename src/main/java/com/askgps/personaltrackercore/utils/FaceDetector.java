package com.askgps.personaltrackercore.utils;

import android.media.Image;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/askgps/personaltrackercore/utils/FaceDetector;", "", "()V", "Companion", "FaceDetectorAnalyzer", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FaceDetector.kt */
public final class FaceDetector {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final FirebaseVisionFaceDetectorOptions options;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/askgps/personaltrackercore/utils/FaceDetector$Companion;", "", "()V", "options", "Lcom/google/firebase/ml/vision/face/FirebaseVisionFaceDetectorOptions;", "getOptions", "()Lcom/google/firebase/ml/vision/face/FirebaseVisionFaceDetectorOptions;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FaceDetector.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FirebaseVisionFaceDetectorOptions getOptions() {
            return FaceDetector.options;
        }
    }

    static {
        FirebaseVisionFaceDetectorOptions build = new FirebaseVisionFaceDetectorOptions.Builder().setContourMode(2).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "FirebaseVisionFaceDetect…URS)\n            .build()");
        options = build;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B(\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0017J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R)\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/askgps/personaltrackercore/utils/FaceDetector$FaceDetectorAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "OnSuccessListener", "Lkotlin/Function1;", "Landroidx/camera/core/ImageProxy;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "image", "", "(Lkotlin/jvm/functions/Function1;)V", "faceDetector", "Lcom/google/firebase/ml/vision/face/FirebaseVisionFaceDetector;", "getFaceDetector", "()Lcom/google/firebase/ml/vision/face/FirebaseVisionFaceDetector;", "faceDetector$delegate", "Lkotlin/Lazy;", "analyze", "degreesToFirebaseRotation", "", "degrees", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FaceDetector.kt */
    public static final class FaceDetectorAnalyzer implements ImageAnalysis.Analyzer {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(FaceDetectorAnalyzer.class), "faceDetector", "getFaceDetector()Lcom/google/firebase/ml/vision/face/FirebaseVisionFaceDetector;"))};
        /* access modifiers changed from: private */
        public final Function1<ImageProxy, Unit> OnSuccessListener;
        private final Lazy faceDetector$delegate = LazyKt.lazy(FaceDetector$FaceDetectorAnalyzer$faceDetector$2.INSTANCE);

        private final FirebaseVisionFaceDetector getFaceDetector() {
            Lazy lazy = this.faceDetector$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (FirebaseVisionFaceDetector) lazy.getValue();
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, kotlin.jvm.functions.Function1<? super androidx.camera.core.ImageProxy, kotlin.Unit>, kotlin.jvm.functions.Function1<androidx.camera.core.ImageProxy, kotlin.Unit>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public FaceDetectorAnalyzer(kotlin.jvm.functions.Function1<? super androidx.camera.core.ImageProxy, kotlin.Unit> r2) {
            /*
                r1 = this;
                java.lang.String r0 = "OnSuccessListener"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
                r1.<init>()
                r1.OnSuccessListener = r2
                com.askgps.personaltrackercore.utils.FaceDetector$FaceDetectorAnalyzer$faceDetector$2 r2 = com.askgps.personaltrackercore.utils.FaceDetector$FaceDetectorAnalyzer$faceDetector$2.INSTANCE
                kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
                kotlin.Lazy r2 = kotlin.LazyKt.lazy(r2)
                r1.faceDetector$delegate = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.askgps.personaltrackercore.utils.FaceDetector.FaceDetectorAnalyzer.<init>(kotlin.jvm.functions.Function1):void");
        }

        private final int degreesToFirebaseRotation(int i) {
            if (i == 0) {
                return 0;
            }
            if (i == 90) {
                return 1;
            }
            if (i == 180) {
                return 2;
            }
            if (i == 270) {
                return 3;
            }
            throw new Exception("Rotation must be 0, 90, 180, or 270.");
        }

        public void analyze(ImageProxy imageProxy) {
            Intrinsics.checkParameterIsNotNull(imageProxy, "image");
            Image image = imageProxy.getImage();
            ImageInfo imageInfo = imageProxy.getImageInfo();
            Intrinsics.checkExpressionValueIsNotNull(imageInfo, "image.imageInfo");
            int degreesToFirebaseRotation = degreesToFirebaseRotation(imageInfo.getRotationDegrees());
            if (image != null) {
                FirebaseVisionImage fromMediaImage = FirebaseVisionImage.fromMediaImage(image, degreesToFirebaseRotation);
                Intrinsics.checkExpressionValueIsNotNull(fromMediaImage, "FirebaseVisionImage.from…ediaImage, imageRotation)");
                getFaceDetector().detectInImage(fromMediaImage).addOnSuccessListener(new FaceDetector$FaceDetectorAnalyzer$analyze$1(this, imageProxy)).addOnFailureListener(new FaceDetector$FaceDetectorAnalyzer$analyze$2(imageProxy));
            }
        }
    }
}

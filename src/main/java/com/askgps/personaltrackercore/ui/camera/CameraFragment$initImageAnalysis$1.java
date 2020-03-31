package com.askgps.personaltrackercore.ui.camera;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "image", "Landroidx/camera/core/ImageProxy;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: CameraFragment.kt */
final class CameraFragment$initImageAnalysis$1 extends Lambda implements Function1<ImageProxy, Unit> {
    final /* synthetic */ ImageCapture $imageCapture;
    final /* synthetic */ CameraFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraFragment$initImageAnalysis$1(CameraFragment cameraFragment, ImageCapture imageCapture) {
        super(1);
        this.this$0 = cameraFragment;
        this.$imageCapture = imageCapture;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ImageProxy) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ImageProxy imageProxy) {
        Intrinsics.checkParameterIsNotNull(imageProxy, "image");
        this.this$0.FaceDetectorAnalyzerCalbback(this.$imageCapture, imageProxy);
    }
}

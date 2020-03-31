package com.askgps.personaltrackercore.ui.camera;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/askgps/personaltrackercore/ui/camera/CameraFragmentPhone$FaceDetectorAnalyzerCalbback$1", "Landroidx/camera/core/ImageCapture$OnImageSavedCallback;", "onError", "", "exception", "Landroidx/camera/core/ImageCaptureException;", "onImageSaved", "outputFileResults", "Landroidx/camera/core/ImageCapture$OutputFileResults;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CameraFragmentPhone.kt */
public final class CameraFragmentPhone$FaceDetectorAnalyzerCalbback$1 implements ImageCapture.OnImageSavedCallback {
    final /* synthetic */ File $file;
    final /* synthetic */ ImageProxy $image;
    final /* synthetic */ CameraFragmentPhone this$0;

    CameraFragmentPhone$FaceDetectorAnalyzerCalbback$1(CameraFragmentPhone cameraFragmentPhone, File file, ImageProxy imageProxy) {
        this.this$0 = cameraFragmentPhone;
        this.$file = file;
        this.$image = imageProxy;
    }

    public void onImageSaved(ImageCapture.OutputFileResults outputFileResults) {
        Intrinsics.checkParameterIsNotNull(outputFileResults, "outputFileResults");
        this.this$0.dismiss();
        CameraViewModel access$getViewModel$p = CameraFragmentPhone.access$getViewModel$p(this.this$0);
        String absolutePath = this.$file.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
        access$getViewModel$p.registerUser(absolutePath);
    }

    public void onError(ImageCaptureException imageCaptureException) {
        Intrinsics.checkParameterIsNotNull(imageCaptureException, "exception");
        ImageProxy imageProxy = this.$image;
        if (imageProxy != null) {
            imageProxy.close();
        }
    }
}

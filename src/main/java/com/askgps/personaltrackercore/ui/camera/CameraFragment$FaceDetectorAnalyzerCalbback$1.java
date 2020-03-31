package com.askgps.personaltrackercore.ui.camera;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import com.askgps.personaltrackercore.BaseMainActivity;
import com.askgps.personaltrackercore.config.CustomerCategory;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/askgps/personaltrackercore/ui/camera/CameraFragment$FaceDetectorAnalyzerCalbback$1", "Landroidx/camera/core/ImageCapture$OnImageSavedCallback;", "onError", "", "exception", "Landroidx/camera/core/ImageCaptureException;", "onImageSaved", "outputFileResults", "Landroidx/camera/core/ImageCapture$OutputFileResults;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CameraFragment.kt */
public final class CameraFragment$FaceDetectorAnalyzerCalbback$1 implements ImageCapture.OnImageSavedCallback {
    final /* synthetic */ File $file;
    final /* synthetic */ ImageProxy $image;
    final /* synthetic */ CameraFragment this$0;

    CameraFragment$FaceDetectorAnalyzerCalbback$1(CameraFragment cameraFragment, File file, ImageProxy imageProxy) {
        this.this$0 = cameraFragment;
        this.$file = file;
        this.$image = imageProxy;
    }

    public void onImageSaved(ImageCapture.OutputFileResults outputFileResults) {
        Intrinsics.checkParameterIsNotNull(outputFileResults, "outputFileResults");
        if (BaseMainActivity.Companion.getCustomer() == CustomerCategory.BUILDER_WATCH) {
            CameraViewModel access$getViewModel$p = CameraFragment.access$getViewModel$p(this.this$0);
            String absolutePath = this.$file.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
            String searchUser = access$getViewModel$p.searchUser(absolutePath);
            if (searchUser != null) {
                this.this$0.dismiss();
                CameraFragment.access$getViewModel$p(this.this$0).startIdentificationAsync(searchUser);
                return;
            }
            ImageProxy imageProxy = this.$image;
            if (imageProxy != null) {
                imageProxy.close();
                return;
            }
            return;
        }
        this.this$0.dismiss();
        CameraViewModel access$getViewModel$p2 = CameraFragment.access$getViewModel$p(this.this$0);
        String absolutePath2 = this.$file.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath2, "file.absolutePath");
        access$getViewModel$p2.startIdentificationOnNavigationAsync(absolutePath2);
    }

    public void onError(ImageCaptureException imageCaptureException) {
        Intrinsics.checkParameterIsNotNull(imageCaptureException, "exception");
        ImageProxy imageProxy = this.$image;
        if (imageProxy != null) {
            imageProxy.close();
        }
    }
}

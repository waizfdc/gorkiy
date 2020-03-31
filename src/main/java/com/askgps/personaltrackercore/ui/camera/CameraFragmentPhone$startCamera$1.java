package com.askgps.personaltrackercore.ui.camera;

import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: CameraFragmentPhone.kt */
final class CameraFragmentPhone$startCamera$1 implements Runnable {
    final /* synthetic */ ListenableFuture $cameraProviderFuture;
    final /* synthetic */ CameraFragmentPhone this$0;

    CameraFragmentPhone$startCamera$1(CameraFragmentPhone cameraFragmentPhone, ListenableFuture listenableFuture) {
        this.this$0 = cameraFragmentPhone;
        this.$cameraProviderFuture = listenableFuture;
    }

    public final void run() {
        ImageCapture access$initCapture = this.this$0.initCapture();
        ImageAnalysis access$initImageAnalysis = this.this$0.initImageAnalysis(access$initCapture);
        Preview access$initPreview = this.this$0.initPreview();
        CameraSelector access$initCameraSelector = this.this$0.initCameraSelector();
        ((ProcessCameraProvider) this.$cameraProviderFuture.get()).bindToLifecycle(this.this$0.getViewLifecycleOwner(), access$initCameraSelector, access$initCapture, access$initPreview, access$initImageAnalysis);
    }
}

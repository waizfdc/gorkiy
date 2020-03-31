package com.askgps.personaltrackercore.ui.camera;

import android.view.View;
import androidx.camera.core.ImageCapture;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: CameraFragmentPhone.kt */
final class CameraFragmentPhone$initCapture$1 implements View.OnClickListener {
    final /* synthetic */ ImageCapture $imageCapture;
    final /* synthetic */ CameraFragmentPhone this$0;

    CameraFragmentPhone$initCapture$1(CameraFragmentPhone cameraFragmentPhone, ImageCapture imageCapture) {
        this.this$0 = cameraFragmentPhone;
        this.$imageCapture = imageCapture;
    }

    public final void onClick(View view) {
        this.this$0.FaceDetectorAnalyzerCalbback(this.$imageCapture, null);
    }
}

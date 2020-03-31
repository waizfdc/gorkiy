package com.askgps.personaltrackercore.ui.camera;

import android.view.View;
import androidx.camera.core.ImageCapture;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: CameraFragment.kt */
final class CameraFragment$initCapture$1 implements View.OnClickListener {
    final /* synthetic */ ImageCapture $imageCapture;
    final /* synthetic */ CameraFragment this$0;

    CameraFragment$initCapture$1(CameraFragment cameraFragment, ImageCapture imageCapture) {
        this.this$0 = cameraFragment;
        this.$imageCapture = imageCapture;
    }

    public final void onClick(View view) {
        this.this$0.FaceDetectorAnalyzerCalbback(this.$imageCapture, null);
    }
}

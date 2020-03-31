package com.askgps.personaltrackercore.ui.camera;

import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 1, 16})
/* compiled from: CameraFragment.kt */
final class CameraFragment$onActivityCreated$1<T> implements Observer<String> {
    final /* synthetic */ CameraFragment this$0;

    CameraFragment$onActivityCreated$1(CameraFragment cameraFragment) {
        this.this$0 = cameraFragment;
    }

    public final void onChanged(String str) {
        this.this$0.dismiss();
    }
}

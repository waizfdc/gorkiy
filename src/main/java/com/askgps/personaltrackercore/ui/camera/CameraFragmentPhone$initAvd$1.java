package com.askgps.personaltrackercore.ui.camera;

import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.askgps.personaltrackercore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/askgps/personaltrackercore/ui/camera/CameraFragmentPhone$initAvd$1", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "onAnimationEnd", "", "drawable", "Landroid/graphics/drawable/Drawable;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CameraFragmentPhone.kt */
public final class CameraFragmentPhone$initAvd$1 extends Animatable2Compat.AnimationCallback {
    final /* synthetic */ CameraFragmentPhone this$0;

    CameraFragmentPhone$initAvd$1(CameraFragmentPhone cameraFragmentPhone) {
        this.this$0 = cameraFragmentPhone;
    }

    public void onAnimationEnd(Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(drawable, "drawable");
        ((AppCompatImageView) this.this$0._$_findCachedViewById(R.id.camera_face_detector_animation)).post(new CameraFragmentPhone$initAvd$1$onAnimationEnd$1(this));
    }
}

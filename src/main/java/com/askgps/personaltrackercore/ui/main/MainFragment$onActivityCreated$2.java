package com.askgps.personaltrackercore.ui.main;

import android.view.View;
import com.askgps.personaltrackercore.ui.camera.CameraFragment;
import com.askgps.personaltrackercore.ui.endwork.EndWorkFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainFragment.kt */
final class MainFragment$onActivityCreated$2 implements View.OnClickListener {
    final /* synthetic */ MainFragment this$0;

    MainFragment$onActivityCreated$2(MainFragment mainFragment) {
        this.this$0 = mainFragment;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.jvm.internal.Intrinsics.areEqual(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.Boolean, boolean]
     candidates:
      kotlin.jvm.internal.Intrinsics.areEqual(double, java.lang.Double):boolean
      kotlin.jvm.internal.Intrinsics.areEqual(float, java.lang.Float):boolean
      kotlin.jvm.internal.Intrinsics.areEqual(java.lang.Double, double):boolean
      kotlin.jvm.internal.Intrinsics.areEqual(java.lang.Double, java.lang.Double):boolean
      kotlin.jvm.internal.Intrinsics.areEqual(java.lang.Float, float):boolean
      kotlin.jvm.internal.Intrinsics.areEqual(java.lang.Float, java.lang.Float):boolean
      kotlin.jvm.internal.Intrinsics.areEqual(java.lang.Object, java.lang.Object):boolean */
    public final void onClick(View view) {
        if (Intrinsics.areEqual((Object) MainFragment.access$getViewModel$p(this.this$0).getWorkIsStart().getValue(), (Object) false)) {
            CameraFragment newInstance = CameraFragment.Companion.newInstance();
            newInstance.setCancelable(true);
            newInstance.show(this.this$0.getChildFragmentManager(), (String) null);
            return;
        }
        EndWorkFragment.Companion.newInstance().show(this.this$0.getChildFragmentManager(), (String) null);
    }
}

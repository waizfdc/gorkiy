package com.askgps.personaltrackerround;

import com.askgps.personaltrackercore.ui.camera.CameraFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainActivity.kt */
final class MainActivity$onNewIntent$7 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainActivity$onNewIntent$7(MainActivity mainActivity) {
        super(0);
        this.this$0 = mainActivity;
    }

    public final void invoke() {
        CameraFragment newInstance = CameraFragment.Companion.newInstance();
        newInstance.setCancelable(true);
        newInstance.show(this.this$0.getSupportFragmentManager(), (String) null);
    }
}

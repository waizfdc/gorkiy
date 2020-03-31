package com.askgps.personaltrackerround;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.askgps.personaltrackercore.ui.infoscreen.InfoFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainActivity.kt */
final class MainActivity$observeViewModel$3<T> implements Observer<Boolean> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$observeViewModel$3(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void onChanged(Boolean bool) {
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        if (bool.booleanValue()) {
            InfoFragment.Companion companion = InfoFragment.Companion;
            FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
            Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "supportFragmentManager");
            InfoFragment.Companion.showNetworkErrorDialog$default(companion, supportFragmentManager, false, null, 6, null);
        }
    }
}

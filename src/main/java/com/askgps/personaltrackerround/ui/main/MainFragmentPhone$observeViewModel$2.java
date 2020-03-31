package com.askgps.personaltrackerround.ui.main;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainFragmentPhone.kt */
final class MainFragmentPhone$observeViewModel$2<T> implements Observer<Boolean> {
    final /* synthetic */ MainFragmentPhone this$0;

    MainFragmentPhone$observeViewModel$2(MainFragmentPhone mainFragmentPhone) {
        this.this$0 = mainFragmentPhone;
    }

    public final void onChanged(Boolean bool) {
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        if (bool.booleanValue() && !this.this$0.getLoader().isVisible()) {
            this.this$0.getLoader().show(this.this$0.getChildFragmentManager(), "loader");
        }
        if (!bool.booleanValue() && this.this$0.getLoader().isVisible()) {
            this.this$0.getLoader().dismiss();
        }
    }
}

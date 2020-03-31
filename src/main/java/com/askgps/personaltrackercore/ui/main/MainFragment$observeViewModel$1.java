package com.askgps.personaltrackercore.ui.main;

import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import com.askgps.personaltrackercore.R;
import com.google.android.material.textview.MaterialTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainFragment.kt */
final class MainFragment$observeViewModel$1<T> implements Observer<Boolean> {
    final /* synthetic */ MainFragment this$0;

    MainFragment$observeViewModel$1(MainFragment mainFragment) {
        this.this$0 = mainFragment;
    }

    public final void onChanged(Boolean bool) {
        MaterialTextView materialTextView = (MaterialTextView) this.this$0._$_findCachedViewById(R.id.small_main_tc_time);
        Intrinsics.checkExpressionValueIsNotNull(materialTextView, "small_main_tc_time");
        materialTextView.setVisibility(0);
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        if (bool.booleanValue()) {
            AppCompatButton appCompatButton = (AppCompatButton) this.this$0._$_findCachedViewById(R.id.main_btn_action);
            Intrinsics.checkExpressionValueIsNotNull(appCompatButton, "main_btn_action");
            appCompatButton.setText(this.this$0.getString(R.string.end));
            return;
        }
        AppCompatButton appCompatButton2 = (AppCompatButton) this.this$0._$_findCachedViewById(R.id.main_btn_action);
        Intrinsics.checkExpressionValueIsNotNull(appCompatButton2, "main_btn_action");
        appCompatButton2.setText(this.this$0.getString(R.string.begin));
    }
}

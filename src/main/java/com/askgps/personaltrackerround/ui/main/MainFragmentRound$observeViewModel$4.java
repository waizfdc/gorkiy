package com.askgps.personaltrackerround.ui.main;

import androidx.lifecycle.Observer;
import com.askgps.personaltrackerround.R;
import com.google.android.material.textview.MaterialTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainFragmentRound.kt */
final class MainFragmentRound$observeViewModel$4<T> implements Observer<String> {
    final /* synthetic */ MainFragmentRound this$0;

    MainFragmentRound$observeViewModel$4(MainFragmentRound mainFragmentRound) {
        this.this$0 = mainFragmentRound;
    }

    public final void onChanged(String str) {
        MaterialTextView materialTextView = (MaterialTextView) this.this$0._$_findCachedViewById(R.id.loginLayout);
        Intrinsics.checkExpressionValueIsNotNull(materialTextView, "loginLayout");
        materialTextView.setText(str);
    }
}

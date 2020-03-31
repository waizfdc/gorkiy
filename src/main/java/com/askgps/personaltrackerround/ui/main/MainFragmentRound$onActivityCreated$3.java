package com.askgps.personaltrackerround.ui.main;

import android.view.View;
import com.askgps.personaltrackercore.ui.endwork.EndWorkFragment;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainFragmentRound.kt */
final class MainFragmentRound$onActivityCreated$3 implements View.OnClickListener {
    final /* synthetic */ MainFragmentRound this$0;

    MainFragmentRound$onActivityCreated$3(MainFragmentRound mainFragmentRound) {
        this.this$0 = mainFragmentRound;
    }

    public final void onClick(View view) {
        EndWorkFragment.Companion.newInstance().show(this.this$0.getChildFragmentManager(), (String) null);
    }
}

package com.askgps.personaltrackercore.ui.main;

import android.view.View;
import com.askgps.personaltrackercore.ui.sos.SosFragment;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainFragment.kt */
final class MainFragment$onActivityCreated$1 implements View.OnClickListener {
    final /* synthetic */ MainFragment this$0;

    MainFragment$onActivityCreated$1(MainFragment mainFragment) {
        this.this$0 = mainFragment;
    }

    public final void onClick(View view) {
        SosFragment.Companion.newInstance().show(this.this$0.getChildFragmentManager(), (String) null);
    }
}

package com.askgps.personaltrackercore.ui.rightscreen;

import android.view.View;
import com.askgps.personaltrackercore.ui.phonebook.PhoneBookFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: RightScreenFragment.kt */
final class RightScreenFragment$setOnClickListeners$4 implements View.OnClickListener {
    final /* synthetic */ RightScreenFragment this$0;

    RightScreenFragment$setOnClickListeners$4(RightScreenFragment rightScreenFragment) {
        this.this$0 = rightScreenFragment;
    }

    public final void onClick(View view) {
        new PhoneBookFragment().show(this.this$0.getChildFragmentManager(), Reflection.getOrCreateKotlinClass(PhoneBookFragment.class).getSimpleName());
    }
}

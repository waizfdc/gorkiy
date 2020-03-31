package com.askgps.personaltrackercore.ui.rightscreen;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.askgps.personaltrackercore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: RightScreenFragment.kt */
final class RightScreenFragment$setOnClickListeners$3 implements View.OnClickListener {
    final /* synthetic */ RightScreenFragment this$0;

    RightScreenFragment$setOnClickListeners$3(RightScreenFragment rightScreenFragment) {
        this.this$0 = rightScreenFragment;
    }

    public final void onClick(View view) {
        try {
            RightScreenFragment rightScreenFragment = this.this$0;
            Context context = this.this$0.getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
            rightScreenFragment.startActivity(context.getPackageManager().getLaunchIntentForPackage("com.android.vending"));
        } catch (Exception unused) {
            Context context2 = this.this$0.getContext();
            if (context2 == null) {
                Intrinsics.throwNpe();
            }
            Toast.makeText(context2, R.string.cannot_open_market, 0).show();
        }
    }
}

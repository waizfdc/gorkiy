package com.askgps.personaltrackerround.ui.main;

import android.content.Context;
import android.view.View;
import com.askgps.personaltrackercore.extension.ContextExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainFragmentPhone.kt */
final class MainFragmentPhone$onActivityCreated$1 implements View.OnClickListener {
    final /* synthetic */ MainFragmentPhone this$0;

    MainFragmentPhone$onActivityCreated$1(MainFragmentPhone mainFragmentPhone) {
        this.this$0 = mainFragmentPhone;
    }

    public final void onClick(View view) {
        Context context = this.this$0.getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        ContextExtensionKt.makeCall(context, MainFragmentPhone.SOS_PHONE);
    }
}

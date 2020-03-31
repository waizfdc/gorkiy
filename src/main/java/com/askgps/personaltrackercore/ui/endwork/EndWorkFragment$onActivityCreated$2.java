package com.askgps.personaltrackercore.ui.endwork;

import android.content.Context;
import android.view.View;
import com.askgps.personaltrackercore.extension.ContextExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: EndWorkFragment.kt */
final class EndWorkFragment$onActivityCreated$2 implements View.OnClickListener {
    final /* synthetic */ EndWorkFragment this$0;

    EndWorkFragment$onActivityCreated$2(EndWorkFragment endWorkFragment) {
        this.this$0 = endWorkFragment;
    }

    public final void onClick(View view) {
        Context context = this.this$0.getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        String id = ContextExtensionKt.getID(context);
        if (id != null) {
            EndWorkFragment.access$getViewModel$p(this.this$0).endWork(id);
        }
        this.this$0.dismiss();
    }
}

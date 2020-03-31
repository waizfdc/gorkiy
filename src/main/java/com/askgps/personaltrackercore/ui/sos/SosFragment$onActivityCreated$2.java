package com.askgps.personaltrackercore.ui.sos;

import androidx.lifecycle.Observer;
import com.askgps.personaltrackercore.R;
import com.google.android.material.textview.MaterialTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 1, 16})
/* compiled from: SosFragment.kt */
final class SosFragment$onActivityCreated$2<T> implements Observer<Integer> {
    final /* synthetic */ SosFragment this$0;

    SosFragment$onActivityCreated$2(SosFragment sosFragment) {
        this.this$0 = sosFragment;
    }

    public final void onChanged(Integer num) {
        MaterialTextView materialTextView = (MaterialTextView) this.this$0._$_findCachedViewById(R.id.sos_tv_through);
        Intrinsics.checkExpressionValueIsNotNull(materialTextView, "sos_tv_through");
        materialTextView.setText(this.this$0.getResources().getString(R.string.send_through, num));
        if (num != null && num.intValue() == 0) {
            this.this$0.dismiss();
        }
    }
}

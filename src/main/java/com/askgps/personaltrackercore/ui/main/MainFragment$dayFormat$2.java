package com.askgps.personaltrackercore.ui.main;

import com.askgps.personaltrackercore.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainFragment.kt */
final class MainFragment$dayFormat$2 extends Lambda implements Function0<String> {
    final /* synthetic */ MainFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainFragment$dayFormat$2(MainFragment mainFragment) {
        super(0);
        this.this$0 = mainFragment;
    }

    public final String invoke() {
        return this.this$0.getString(R.string.day_format);
    }
}

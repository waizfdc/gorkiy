package com.askgps.personaltrackerround.ui.main;

import com.askgps.personaltrackerround.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainFragmentPhone.kt */
final class MainFragmentPhone$timeFormat$2 extends Lambda implements Function0<String> {
    final /* synthetic */ MainFragmentPhone this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainFragmentPhone$timeFormat$2(MainFragmentPhone mainFragmentPhone) {
        super(0);
        this.this$0 = mainFragmentPhone;
    }

    public final String invoke() {
        return this.this$0.getString(R.string.time_format);
    }
}

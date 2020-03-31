package com.askgps.personaltrackercore.ui.infoscreen;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 1, 16})
/* compiled from: InfoFragment.kt */
final class InfoFragment$attemptCount$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ InfoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InfoFragment$attemptCount$2(InfoFragment infoFragment) {
        super(0);
        this.this$0 = infoFragment;
    }

    public final Integer invoke() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            return Integer.valueOf(arguments.getInt("string_title"));
        }
        return null;
    }
}

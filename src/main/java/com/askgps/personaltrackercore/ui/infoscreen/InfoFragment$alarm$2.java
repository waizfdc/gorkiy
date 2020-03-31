package com.askgps.personaltrackercore.ui.infoscreen;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: InfoFragment.kt */
final class InfoFragment$alarm$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ InfoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InfoFragment$alarm$2(InfoFragment infoFragment) {
        super(0);
        this.this$0 = infoFragment;
    }

    public final boolean invoke() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            return arguments.getBoolean("vibrate", false);
        }
        return false;
    }
}

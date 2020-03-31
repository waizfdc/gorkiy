package com.askgps.personaltrackercore.ui.infoscreen;

import android.os.Bundle;
import com.askgps.personaltrackercore.R;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: InfoFragment.kt */
final class InfoFragment$iconId$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ InfoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InfoFragment$iconId$2(InfoFragment infoFragment) {
        super(0);
        this.this$0 = infoFragment;
    }

    public final int invoke() {
        Bundle arguments = this.this$0.getArguments();
        return arguments != null ? arguments.getInt(SettingsJsonConstants.APP_ICON_KEY, R.drawable.ic_success) : InfoFragment.DEFAULT_ICON_ID;
    }
}

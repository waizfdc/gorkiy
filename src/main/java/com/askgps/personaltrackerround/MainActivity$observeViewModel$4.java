package com.askgps.personaltrackerround;

import androidx.lifecycle.Observer;
import com.askgps.personaltrackercore.database.model.Settings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/askgps/personaltrackercore/database/model/Settings;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainActivity.kt */
final class MainActivity$observeViewModel$4<T> implements Observer<Settings> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$observeViewModel$4(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void onChanged(Settings settings) {
        if (settings.getWorkIsStart()) {
            MainActivity mainActivity = this.this$0;
            Intrinsics.checkExpressionValueIsNotNull(settings, "it");
            mainActivity.startAllUtils(settings);
            return;
        }
        this.this$0.stopAllUtils();
    }
}

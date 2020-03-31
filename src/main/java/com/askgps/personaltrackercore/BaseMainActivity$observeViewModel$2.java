package com.askgps.personaltrackercore;

import androidx.lifecycle.Observer;
import com.askgps.personaltrackercore.config.CustomerCategory;
import com.askgps.personaltrackercore.database.model.Settings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/askgps/personaltrackercore/database/model/Settings;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 1, 16})
/* compiled from: BaseMainActivity.kt */
final class BaseMainActivity$observeViewModel$2<T> implements Observer<Settings> {
    final /* synthetic */ BaseMainActivity this$0;

    BaseMainActivity$observeViewModel$2(BaseMainActivity baseMainActivity) {
        this.this$0 = baseMainActivity;
    }

    public final void onChanged(Settings settings) {
        if (settings.getWorkIsStart()) {
            BaseMainActivity baseMainActivity = this.this$0;
            Intrinsics.checkExpressionValueIsNotNull(settings, "it");
            baseMainActivity.startAllUtils(settings);
        } else if (BaseMainActivity.Companion.getCustomer() == CustomerCategory.BUILDER_WATCH) {
            this.this$0.stopAllUtils();
        }
    }
}

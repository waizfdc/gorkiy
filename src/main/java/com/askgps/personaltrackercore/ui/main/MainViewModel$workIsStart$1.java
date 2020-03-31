package com.askgps.personaltrackercore.ui.main;

import androidx.arch.core.util.Function;
import com.askgps.personaltrackercore.database.model.Settings;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/askgps/personaltrackercore/database/model/Settings;", "kotlin.jvm.PlatformType", "apply"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainViewModel.kt */
final class MainViewModel$workIsStart$1<I, O> implements Function<X, Y> {
    public static final MainViewModel$workIsStart$1 INSTANCE = new MainViewModel$workIsStart$1();

    MainViewModel$workIsStart$1() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Boolean.valueOf(apply((Settings) obj));
    }

    public final boolean apply(Settings settings) {
        return settings.getWorkIsStart();
    }
}

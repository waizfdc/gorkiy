package com.askgps.personaltrackerround.ui.main;

import androidx.lifecycle.Observer;
import com.askgps.personaltrackercore.database.model.PhoneNumber;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/askgps/personaltrackercore/database/model/PhoneNumber;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainFragmentPhone.kt */
final class MainFragmentPhone$observeViewModel$3<T> implements Observer<List<? extends PhoneNumber>> {
    public static final MainFragmentPhone$observeViewModel$3 INSTANCE = new MainFragmentPhone$observeViewModel$3();

    MainFragmentPhone$observeViewModel$3() {
    }

    public final void onChanged(List<PhoneNumber> list) {
    }

    public /* bridge */ /* synthetic */ void onChanged(Object obj) {
        onChanged((List<PhoneNumber>) ((List) obj));
    }
}

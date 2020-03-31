package com.askgps.personaltrackercore.ui.phonebook;

import androidx.lifecycle.Observer;
import com.askgps.personaltrackercore.database.model.PhoneNumber;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/askgps/personaltrackercore/database/model/PhoneNumber;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 1, 16})
/* compiled from: PhoneBookFragment.kt */
final class PhoneBookFragment$observeViewModel$1<T> implements Observer<List<? extends PhoneNumber>> {
    final /* synthetic */ PhoneBookFragment this$0;

    PhoneBookFragment$observeViewModel$1(PhoneBookFragment phoneBookFragment) {
        this.this$0 = phoneBookFragment;
    }

    public /* bridge */ /* synthetic */ void onChanged(Object obj) {
        onChanged((List<PhoneNumber>) ((List) obj));
    }

    public final void onChanged(List<PhoneNumber> list) {
        PhoneBookAdapter adapter = PhoneBookFragment.access$getViewModel$p(this.this$0).getAdapter();
        Intrinsics.checkExpressionValueIsNotNull(list, "it");
        adapter.submitList(list);
    }
}

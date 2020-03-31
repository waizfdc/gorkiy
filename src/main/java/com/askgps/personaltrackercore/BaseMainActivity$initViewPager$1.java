package com.askgps.personaltrackercore;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.askgps.personaltrackercore.config.CustomerCategory;
import com.askgps.personaltrackercore.ui.leftscreen.LeftScreenFragment;
import com.askgps.personaltrackercore.ui.rightscreen.RightScreenFragment;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/askgps/personaltrackercore/BaseMainActivity$initViewPager$1", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BaseMainActivity.kt */
public final class BaseMainActivity$initViewPager$1 extends FragmentStatePagerAdapter {
    final /* synthetic */ BaseMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseMainActivity$initViewPager$1(BaseMainActivity baseMainActivity, FragmentManager fragmentManager, int i) {
        super(fragmentManager, i);
        this.this$0 = baseMainActivity;
    }

    public Fragment getItem(int i) {
        if (i != 1) {
            return LeftScreenFragment.Companion.newInstance();
        }
        return RightScreenFragment.Companion.newInstance();
    }

    public int getCount() {
        return BaseMainActivity.Companion.getCustomer() == CustomerCategory.PATIENT_PHONE ? 1 : 2;
    }
}

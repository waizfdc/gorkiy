package com.askgps.personaltrackercore;

import androidx.viewpager.widget.ViewPager;
import com.askgps.personaltrackercore.ui.PasswordDialog;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/askgps/personaltrackercore/BaseMainActivity$initViewPager$2", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BaseMainActivity.kt */
public final class BaseMainActivity$initViewPager$2 implements ViewPager.OnPageChangeListener {
    final /* synthetic */ BaseMainActivity this$0;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    BaseMainActivity$initViewPager$2(BaseMainActivity baseMainActivity) {
        this.this$0 = baseMainActivity;
    }

    public void onPageSelected(int i) {
        if (i == 1) {
            new PasswordDialog(new BaseMainActivity$initViewPager$2$onPageSelected$1(this)).show(this.this$0.getSupportFragmentManager(), "pass");
        }
    }
}

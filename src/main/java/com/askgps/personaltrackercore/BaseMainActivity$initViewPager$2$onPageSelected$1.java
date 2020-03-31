package com.askgps.personaltrackercore;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: BaseMainActivity.kt */
final class BaseMainActivity$initViewPager$2$onPageSelected$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ BaseMainActivity$initViewPager$2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseMainActivity$initViewPager$2$onPageSelected$1(BaseMainActivity$initViewPager$2 baseMainActivity$initViewPager$2) {
        super(1);
        this.this$0 = baseMainActivity$initViewPager$2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (!z) {
            ViewPager viewPager = (ViewPager) this.this$0.this$0._$_findCachedViewById(R.id.main_vp_screens);
            Intrinsics.checkExpressionValueIsNotNull(viewPager, "main_vp_screens");
            viewPager.setCurrentItem(0);
        }
    }
}

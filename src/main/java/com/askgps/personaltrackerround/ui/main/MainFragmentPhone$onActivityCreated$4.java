package com.askgps.personaltrackerround.ui.main;

import android.view.KeyEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "keyCode", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "onKey"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainFragmentPhone.kt */
final class MainFragmentPhone$onActivityCreated$4 implements View.OnKeyListener {
    final /* synthetic */ MainFragmentPhone this$0;

    MainFragmentPhone$onActivityCreated$4(MainFragmentPhone mainFragmentPhone) {
        this.this$0 = mainFragmentPhone;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 66) {
            return false;
        }
        Intrinsics.checkExpressionValueIsNotNull(keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (keyEvent.getAction() != 1) {
            return false;
        }
        this.this$0.click_btn_round();
        return true;
    }
}

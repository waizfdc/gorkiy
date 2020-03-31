package com.askgps.personaltrackercore.ui.widget;

import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import com.askgps.personaltrackercore.BaseMainActivity;
import com.askgps.personaltrackercore.R;
import com.askgps.personaltrackercore.config.CustomerCategory;
import com.askgps.personaltrackercore.ui.infoscreen.InfoFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u000e\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ&\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tJ\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/askgps/personaltrackercore/ui/widget/BatteryWidget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "batteryReceiver", "com/askgps/personaltrackercore/ui/widget/BatteryWidget$batteryReceiver$1", "Lcom/askgps/personaltrackercore/ui/widget/BatteryWidget$batteryReceiver$1;", "iFilter", "Landroid/content/IntentFilter;", "lastBatteryValue", "parentFragmentManager", "Landroidx/fragment/app/FragmentManager;", "getParentFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setParentFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "view", "Landroid/view/View;", "checkBatteryLow", "", "lastValue", "currValue", "alarmValue", "strId", "registerBatteryReceiver", "", "unregisterBatteryReceiver", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BatteryWidget.kt */
public final class BatteryWidget extends FrameLayout {
    /* access modifiers changed from: private */
    public final String TAG;
    private HashMap _$_findViewCache;
    private final BatteryWidget$batteryReceiver$1 batteryReceiver;
    private final IntentFilter iFilter;
    /* access modifiers changed from: private */
    public int lastBatteryValue;
    public FragmentManager parentFragmentManager;
    private final View view;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view2 = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final FragmentManager getParentFragmentManager() {
        FragmentManager fragmentManager = this.parentFragmentManager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentFragmentManager");
        }
        return fragmentManager;
    }

    public final void setParentFragmentManager(FragmentManager fragmentManager) {
        Intrinsics.checkParameterIsNotNull(fragmentManager, "<set-?>");
        this.parentFragmentManager = fragmentManager;
    }

    public final boolean checkBatteryLow(int i, int i2, int i3, int i4) {
        if (i < i3 || i2 >= i3) {
            return false;
        }
        String str = this.TAG;
        Log.e(str, "notify " + i3);
        boolean z = BaseMainActivity.Companion.getCustomer() != CustomerCategory.BUILDER_WATCH;
        InfoFragment.Companion companion = InfoFragment.Companion;
        FragmentManager fragmentManager = this.parentFragmentManager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentFragmentManager");
        }
        InfoFragment.Companion.showBatteryLowDialog$default(companion, fragmentManager, i4, z, null, 8, null);
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BatteryWidget(Context context) {
        this(context, null);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BatteryWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, com.askgps.personaltrackercore.ui.widget.BatteryWidget, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BatteryWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.TAG = "BatteryWidget";
        this.iFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        this.lastBatteryValue = 100;
        this.batteryReceiver = new BatteryWidget$batteryReceiver$1(this);
        View inflate = LayoutInflater.from(context).inflate(R.layout.battery_widget, (ViewGroup) this, true);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…ttery_widget, this, true)");
        this.view = inflate;
    }

    public final void registerBatteryReceiver() {
        Context context = getContext();
        if (context != null) {
            context.registerReceiver(this.batteryReceiver, this.iFilter);
        }
    }

    public final void unregisterBatteryReceiver() {
        Context context = getContext();
        if (context != null) {
            context.unregisterReceiver(this.batteryReceiver);
        }
    }
}

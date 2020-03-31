package com.askgps.personaltrackercore.ui.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.appcompat.widget.AppCompatImageView;
import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.R;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/askgps/personaltrackercore/ui/widget/BatteryWidget$batteryReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BatteryWidget.kt */
public final class BatteryWidget$batteryReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ BatteryWidget this$0;

    BatteryWidget$batteryReceiver$1(BatteryWidget batteryWidget) {
        this.this$0 = batteryWidget;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        try {
            int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            String access$getTAG$p = this.this$0.TAG;
            Log.e(access$getTAG$p, "Last battery level: " + this.this$0.lastBatteryValue);
            if (!this.this$0.checkBatteryLow(this.this$0.lastBatteryValue, intExtra, 5, R.string.low_battery_5) && !this.this$0.checkBatteryLow(this.this$0.lastBatteryValue, intExtra, 10, R.string.low_battery_10)) {
                this.this$0.checkBatteryLow(this.this$0.lastBatteryValue, intExtra, 20, R.string.low_battery_20);
            }
            this.this$0.lastBatteryValue = intExtra;
            if (intExtra != -1) {
                ((MaterialTextView) this.this$0._$_findCachedViewById(R.id.battery_widget_tv_percent)).post(new BatteryWidget$batteryReceiver$1$onReceive$1(this, intExtra));
            }
            int intExtra2 = intent.getIntExtra("status", -1);
            if (intExtra2 == 2 || intExtra2 == 5) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.this$0._$_findCachedViewById(R.id.chargingIcon);
                Intrinsics.checkExpressionValueIsNotNull(appCompatImageView, "chargingIcon");
                appCompatImageView.setVisibility(0);
                return;
            }
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) this.this$0._$_findCachedViewById(R.id.chargingIcon);
            Intrinsics.checkExpressionValueIsNotNull(appCompatImageView2, "chargingIcon");
            appCompatImageView2.setVisibility(4);
        } catch (Exception e) {
            LogKt.toFile$default(e.getMessage(), "ACTION_BATTERY_CHANGED Exception", null, null, 6, null);
        }
    }
}

package com.askgps.personaltrackercore.ui.widget;

import androidx.appcompat.widget.AppCompatImageView;
import com.askgps.personaltrackercore.R;
import com.google.android.material.textview.MaterialTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: BatteryWidget.kt */
final class BatteryWidget$batteryReceiver$1$onReceive$1 implements Runnable {
    final /* synthetic */ int $level;
    final /* synthetic */ BatteryWidget$batteryReceiver$1 this$0;

    BatteryWidget$batteryReceiver$1$onReceive$1(BatteryWidget$batteryReceiver$1 batteryWidget$batteryReceiver$1, int i) {
        this.this$0 = batteryWidget$batteryReceiver$1;
        this.$level = i;
    }

    public final void run() {
        MaterialTextView materialTextView = (MaterialTextView) this.this$0.this$0._$_findCachedViewById(R.id.battery_widget_tv_percent);
        Intrinsics.checkExpressionValueIsNotNull(materialTextView, "battery_widget_tv_percent");
        StringBuilder sb = new StringBuilder();
        sb.append(this.$level);
        sb.append('%');
        materialTextView.setText(sb.toString());
        int i = this.$level;
        if (i >= 90) {
            ((AppCompatImageView) this.this$0.this$0._$_findCachedViewById(R.id.battery_img)).setImageDrawable(this.this$0.this$0.getResources().getDrawable(R.drawable.ic_battery_100, null));
        } else if (i >= 65) {
            ((AppCompatImageView) this.this$0.this$0._$_findCachedViewById(R.id.battery_img)).setImageDrawable(this.this$0.this$0.getResources().getDrawable(R.drawable.ic_battery_75, null));
        } else if (i >= 35) {
            ((AppCompatImageView) this.this$0.this$0._$_findCachedViewById(R.id.battery_img)).setImageDrawable(this.this$0.this$0.getResources().getDrawable(R.drawable.ic_battery_50, null));
        } else if (i >= 10) {
            ((AppCompatImageView) this.this$0.this$0._$_findCachedViewById(R.id.battery_img)).setImageDrawable(this.this$0.this$0.getResources().getDrawable(R.drawable.ic_battery_25, null));
        } else if (i >= 0) {
            ((AppCompatImageView) this.this$0.this$0._$_findCachedViewById(R.id.battery_img)).setImageDrawable(this.this$0.this$0.getResources().getDrawable(R.drawable.ic_battery_0, null));
        }
    }
}

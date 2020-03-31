package com.askgps.personaltrackercore.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.askgps.personaltrackercore.LogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/askgps/personaltrackercore/utils/WifiUtils$wifiScanReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: WifiUtils.kt */
public final class WifiUtils$wifiScanReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ WifiUtils this$0;

    WifiUtils$wifiScanReceiver$1(WifiUtils wifiUtils) {
        this.this$0 = wifiUtils;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        this.this$0.scanEnd();
        boolean booleanExtra = intent.getBooleanExtra("resultsUpdated", false);
        LogKt.toFile$default(Boolean.valueOf(booleanExtra), "wifi scan result", null, WifiUtils.TAG, 2, null);
        if (booleanExtra) {
            this.this$0.scanSuccess();
        } else {
            this.this$0.scanFailure();
        }
    }
}

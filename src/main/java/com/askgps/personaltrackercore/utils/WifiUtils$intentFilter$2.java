package com.askgps.personaltrackercore.utils;

import android.content.IntentFilter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/content/IntentFilter;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: WifiUtils.kt */
final class WifiUtils$intentFilter$2 extends Lambda implements Function0<IntentFilter> {
    public static final WifiUtils$intentFilter$2 INSTANCE = new WifiUtils$intentFilter$2();

    WifiUtils$intentFilter$2() {
        super(0);
    }

    public final IntentFilter invoke() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        return intentFilter;
    }
}

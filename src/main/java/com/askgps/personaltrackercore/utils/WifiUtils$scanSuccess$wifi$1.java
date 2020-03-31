package com.askgps.personaltrackercore.utils;

import android.net.wifi.ScanResult;
import com.askgps.personaltrackercore.database.model.IndoorDevice;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/askgps/personaltrackercore/database/model/IndoorDevice;", "it", "Landroid/net/wifi/ScanResult;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: WifiUtils.kt */
final class WifiUtils$scanSuccess$wifi$1 extends Lambda implements Function1<ScanResult, IndoorDevice> {
    public static final WifiUtils$scanSuccess$wifi$1 INSTANCE = new WifiUtils$scanSuccess$wifi$1();

    WifiUtils$scanSuccess$wifi$1() {
        super(1);
    }

    public final IndoorDevice invoke(ScanResult scanResult) {
        String str = scanResult.BSSID;
        Intrinsics.checkExpressionValueIsNotNull(str, "it.BSSID");
        return new IndoorDevice(str, scanResult.level);
    }
}

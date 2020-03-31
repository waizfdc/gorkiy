package com.askgps.personaltrackercore.utils;

import com.askgps.personaltrackercore.LogKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: WifiUtils.kt */
final class WifiUtils$processWifi$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Set $wifi;
    final /* synthetic */ WifiUtils this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WifiUtils$processWifi$4(WifiUtils wifiUtils, Set set) {
        super(0);
        this.this$0 = wifiUtils;
        this.$wifi = set;
    }

    public final void invoke() {
        this.this$0.getRepo().setWifiEnabled(false);
        LogKt.toFile$default(this.$wifi, "WIFI", null, WifiUtils.TAG, 2, null);
    }
}

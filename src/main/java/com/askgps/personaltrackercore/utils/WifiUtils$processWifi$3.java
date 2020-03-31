package com.askgps.personaltrackercore.utils;

import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.repository.Repository;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: WifiUtils.kt */
final class WifiUtils$processWifi$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Set $wifi;
    final /* synthetic */ WifiUtils this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WifiUtils$processWifi$3(WifiUtils wifiUtils, Set set) {
        super(0);
        this.this$0 = wifiUtils;
        this.$wifi = set;
    }

    public final void invoke() {
        ((Repository) this.this$0.getKoin().get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(Repository.class), (Qualifier) null, (Function0<DefinitionParameters>) null)).setWifiEnabled(false);
        LogKt.toFile$default(this.$wifi, "WIFI + requestLocation", null, WifiUtils.TAG, 2, null);
    }
}

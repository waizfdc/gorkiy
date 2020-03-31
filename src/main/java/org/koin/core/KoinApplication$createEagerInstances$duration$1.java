package org.koin.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: KoinApplication.kt */
final class KoinApplication$createEagerInstances$duration$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ KoinApplication this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KoinApplication$createEagerInstances$duration$1(KoinApplication koinApplication) {
        super(0);
        this.this$0 = koinApplication;
    }

    public final void invoke() {
        this.this$0.getKoin().createEagerInstances$koin_core();
    }
}

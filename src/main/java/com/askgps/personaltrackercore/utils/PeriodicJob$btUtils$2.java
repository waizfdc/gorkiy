package com.askgps.personaltrackercore.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/askgps/personaltrackercore/utils/BluetoothUtils;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: PeriodicJob.kt */
final class PeriodicJob$btUtils$2 extends Lambda implements Function0<BluetoothUtils> {
    final /* synthetic */ PeriodicJob this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PeriodicJob$btUtils$2(PeriodicJob periodicJob) {
        super(0);
        this.this$0 = periodicJob;
    }

    public final BluetoothUtils invoke() {
        return new BluetoothUtils(this.this$0.context, this.this$0.scope);
    }
}

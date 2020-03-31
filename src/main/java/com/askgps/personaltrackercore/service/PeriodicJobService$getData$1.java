package com.askgps.personaltrackercore.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"getData", "", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.askgps.personaltrackercore.service.PeriodicJobService", f = "PeriodicJobService.kt", i = {0, 0}, l = {63}, m = "getData", n = {"this", "lhResult"}, s = {"L$0", "L$1"})
/* compiled from: PeriodicJobService.kt */
final class PeriodicJobService$getData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PeriodicJobService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PeriodicJobService$getData$1(PeriodicJobService periodicJobService, Continuation continuation) {
        super(continuation);
        this.this$0 = periodicJobService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getData(this);
    }
}

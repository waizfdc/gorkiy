package com.askgps.personaltrackercore.utils;

import com.askgps.personaltrackercore.LogKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.askgps.personaltrackercore.utils.RemovalFromHandUtils$periodicResultAsync$1", f = "RemovalFromHandUtils.kt", i = {0}, l = {63}, m = "invokeSuspend", n = {"$this$async"}, s = {"L$0"})
/* compiled from: RemovalFromHandUtils.kt */
final class RemovalFromHandUtils$periodicResultAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ long $period;
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ RemovalFromHandUtils this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemovalFromHandUtils$periodicResultAsync$1(RemovalFromHandUtils removalFromHandUtils, long j, Continuation continuation) {
        super(2, continuation);
        this.this$0 = removalFromHandUtils;
        this.$period = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        RemovalFromHandUtils$periodicResultAsync$1 removalFromHandUtils$periodicResultAsync$1 = new RemovalFromHandUtils$periodicResultAsync$1(this.this$0, this.$period, continuation);
        removalFromHandUtils$periodicResultAsync$1.p$ = (CoroutineScope) obj;
        return removalFromHandUtils$periodicResultAsync$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((RemovalFromHandUtils$periodicResultAsync$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            this.this$0.registerSensorListener();
            long j = this.$period;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (DelayKt.delay(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.unregisterSensorListener();
        LogKt.toLog$default(Boxing.boxBoolean(this.this$0.getResult()), "removal from hand", (String) null, (String) null, 6, (Object) null);
        return Boxing.boxBoolean(this.this$0.getResult());
    }
}

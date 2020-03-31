package com.askgps.personaltrackercore.service;

import android.app.job.JobParameters;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.askgps.personaltrackercore.service.PeriodicJobService$onStartJob$1", f = "PeriodicJobService.kt", i = {0}, l = {51}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: PeriodicJobService.kt */
final class PeriodicJobService$onStartJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JobParameters $params;
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ PeriodicJobService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PeriodicJobService$onStartJob$1(PeriodicJobService periodicJobService, JobParameters jobParameters, Continuation continuation) {
        super(2, continuation);
        this.this$0 = periodicJobService;
        this.$params = jobParameters;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        PeriodicJobService$onStartJob$1 periodicJobService$onStartJob$1 = new PeriodicJobService$onStartJob$1(this.this$0, this.$params, continuation);
        periodicJobService$onStartJob$1.p$ = (CoroutineScope) obj;
        return periodicJobService$onStartJob$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PeriodicJobService$onStartJob$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            PeriodicJobService periodicJobService = this.this$0;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (periodicJobService.getData(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.jobFinished(this.$params, false);
        return Unit.INSTANCE;
    }
}

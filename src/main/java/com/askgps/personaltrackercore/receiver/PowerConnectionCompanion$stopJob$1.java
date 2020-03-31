package com.askgps.personaltrackercore.receiver;

import com.askgps.personaltrackercore.LogKt;
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
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.askgps.personaltrackercore.receiver.PowerConnectionCompanion$stopJob$1", f = "PowerConnectionReceiver.kt", i = {0}, l = {40}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: PowerConnectionReceiver.kt */
final class PowerConnectionCompanion$stopJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ PowerConnectionCompanion this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PowerConnectionCompanion$stopJob$1(PowerConnectionCompanion powerConnectionCompanion, Continuation continuation) {
        super(2, continuation);
        this.this$0 = powerConnectionCompanion;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        PowerConnectionCompanion$stopJob$1 powerConnectionCompanion$stopJob$1 = new PowerConnectionCompanion$stopJob$1(this.this$0, continuation);
        powerConnectionCompanion$stopJob$1.p$ = (CoroutineScope) obj;
        return powerConnectionCompanion$stopJob$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PowerConnectionCompanion$stopJob$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            Job access$getAlarmJob$p = this.this$0.alarmJob;
            if (access$getAlarmJob$p != null) {
                this.L$0 = coroutineScope;
                this.label = 1;
                if (JobKt.cancelAndJoin(access$getAlarmJob$p, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.alarmJob = null;
        LogKt.toFile$default("Stop alarm job", null, null, null, 7, null);
        return Unit.INSTANCE;
    }
}

package com.askgps.personaltrackercore.receiver;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.askgps.personaltrackercore.receiver.PowerConnectionCompanion$startJob$1", f = "PowerConnectionReceiver.kt", i = {0}, l = {31}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: PowerConnectionReceiver.kt */
final class PowerConnectionCompanion$startJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ PowerConnectionCompanion this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PowerConnectionCompanion$startJob$1(PowerConnectionCompanion powerConnectionCompanion, Continuation continuation) {
        super(2, continuation);
        this.this$0 = powerConnectionCompanion;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        PowerConnectionCompanion$startJob$1 powerConnectionCompanion$startJob$1 = new PowerConnectionCompanion$startJob$1(this.this$0, continuation);
        powerConnectionCompanion$startJob$1.p$ = (CoroutineScope) obj;
        return powerConnectionCompanion$startJob$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PowerConnectionCompanion$startJob$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 1
            if (r1 == 0) goto L_0x001c
            if (r1 != r2) goto L_0x0014
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            goto L_0x0041
        L_0x0014:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.CoroutineScope r10 = r9.p$
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 7
            r8 = 0
            java.lang.String r3 = "Start alarm job"
            com.askgps.personaltrackercore.LogKt.toFile$default(r3, r4, r5, r6, r7, r8)
            r1 = r10
            r10 = r9
        L_0x002d:
            boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
            if (r3 == 0) goto L_0x005d
            r3 = 600000(0x927c0, double:2.964394E-318)
            r10.L$0 = r1
            r10.label = r2
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r3, r10)
            if (r3 != r0) goto L_0x0041
            return r0
        L_0x0041:
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 7
            r8 = 0
            java.lang.String r3 = "Alarm"
            com.askgps.personaltrackercore.LogKt.toFile$default(r3, r4, r5, r6, r7, r8)
            com.askgps.personaltrackercore.receiver.PowerConnectionCompanion r3 = r10.this$0
            com.askgps.personaltrackercore.repository.Repository r3 = r3.getRepo()
            io.reactivex.subjects.PublishSubject r3 = r3.getAlarm()
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r3.onNext(r4)
            goto L_0x002d
        L_0x005d:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.askgps.personaltrackercore.receiver.PowerConnectionCompanion$startJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

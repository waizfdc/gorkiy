package com.askgps.personaltrackercore.ui.sos;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.askgps.personaltrackercore.ui.sos.SosViewModel$startTimer$1", f = "SosViewModel.kt", i = {0}, l = {35}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: SosViewModel.kt */
final class SosViewModel$startTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ SosViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SosViewModel$startTimer$1(SosViewModel sosViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = sosViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        SosViewModel$startTimer$1 sosViewModel$startTimer$1 = new SosViewModel$startTimer$1(this.this$0, continuation);
        sosViewModel$startTimer$1.p$ = (CoroutineScope) obj;
        return sosViewModel$startTimer$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SosViewModel$startTimer$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x003b  */
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
            goto L_0x0048
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
            java.lang.String r3 = "start timer"
            com.askgps.personaltrackercore.LogKt.toLog$default(r3, r4, r5, r6, r7, r8)
            com.askgps.personaltrackercore.ui.sos.SosViewModel r1 = r9.this$0
            r3 = 5
            r1.timerCounter = r3
            r1 = r10
            r10 = r9
        L_0x0033:
            com.askgps.personaltrackercore.ui.sos.SosViewModel r3 = r10.this$0
            int r3 = r3.timerCounter
            if (r3 <= 0) goto L_0x0067
            r3 = 1000(0x3e8, double:4.94E-321)
            r10.L$0 = r1
            r10.label = r2
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r3, r10)
            if (r3 != r0) goto L_0x0048
            return r0
        L_0x0048:
            com.askgps.personaltrackercore.ui.sos.SosViewModel r3 = r10.this$0
            int r4 = r3.timerCounter
            int r4 = r4 + -1
            r3.timerCounter = r4
            com.askgps.personaltrackercore.ui.sos.SosViewModel r3 = r10.this$0
            androidx.lifecycle.MutableLiveData r3 = r3.getTimer()
            com.askgps.personaltrackercore.ui.sos.SosViewModel r4 = r10.this$0
            int r4 = r4.timerCounter
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            r3.postValue(r4)
            goto L_0x0033
        L_0x0067:
            com.askgps.personaltrackercore.ui.sos.SosViewModel r10 = r10.this$0
            r10.sendSos()
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 7
            r5 = 0
            java.lang.String r0 = "end timer"
            com.askgps.personaltrackercore.LogKt.toLog$default(r0, r1, r2, r3, r4, r5)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.askgps.personaltrackercore.ui.sos.SosViewModel$startTimer$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

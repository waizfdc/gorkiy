package com.askgps.personaltrackercore;

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
@DebugMetadata(c = "com.askgps.personaltrackercore.MainActivityViewModel$updateSettings$1", f = "MainActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MainActivityViewModel.kt */
final class MainActivityViewModel$updateSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $address;
    final /* synthetic */ Long $locationInterval;
    final /* synthetic */ Long $removalFromHandInterval;
    final /* synthetic */ Long $sendTelemetryInterval;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ MainActivityViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainActivityViewModel$updateSettings$1(MainActivityViewModel mainActivityViewModel, String str, Long l, Long l2, Long l3, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mainActivityViewModel;
        this.$address = str;
        this.$locationInterval = l;
        this.$sendTelemetryInterval = l2;
        this.$removalFromHandInterval = l3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        MainActivityViewModel$updateSettings$1 mainActivityViewModel$updateSettings$1 = new MainActivityViewModel$updateSettings$1(this.this$0, this.$address, this.$locationInterval, this.$sendTelemetryInterval, this.$removalFromHandInterval, continuation);
        mainActivityViewModel$updateSettings$1.p$ = (CoroutineScope) obj;
        return mainActivityViewModel$updateSettings$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((MainActivityViewModel$updateSettings$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getRepo().updateSettings(this.$address, this.$locationInterval, this.$sendTelemetryInterval, this.$removalFromHandInterval);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

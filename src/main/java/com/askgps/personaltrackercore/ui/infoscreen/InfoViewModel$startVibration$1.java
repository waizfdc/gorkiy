package com.askgps.personaltrackercore.ui.infoscreen;

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
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.askgps.personaltrackercore.ui.infoscreen.InfoViewModel$startVibration$1", f = "InfoViewModel.kt", i = {0}, l = {23}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: InfoViewModel.kt */
final class InfoViewModel$startVibration$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ InfoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InfoViewModel$startVibration$1(InfoViewModel infoViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = infoViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        InfoViewModel$startVibration$1 infoViewModel$startVibration$1 = new InfoViewModel$startVibration$1(this.this$0, continuation);
        infoViewModel$startVibration$1.p$ = (CoroutineScope) obj;
        return infoViewModel$startVibration$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((InfoViewModel$startVibration$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        CoroutineScope coroutineScope2;
        Job access$getVibrationJob$p;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = this.p$;
            Job access$getVibrationJob$p2 = this.this$0.vibrationJob;
            if (access$getVibrationJob$p2 == null || !access$getVibrationJob$p2.isActive() || (access$getVibrationJob$p = this.this$0.vibrationJob) == null) {
                coroutineScope = coroutineScope3;
                this.this$0.vibrationJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this, null), 3, null);
                return Unit.INSTANCE;
            }
            this.L$0 = coroutineScope3;
            this.label = 1;
            if (JobKt.cancelAndJoin(access$getVibrationJob$p, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope2 = coroutineScope3;
        } else if (i == 1) {
            coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        coroutineScope = coroutineScope2;
        this.this$0.vibrationJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this, null), 3, null);
        return Unit.INSTANCE;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
    @DebugMetadata(c = "com.askgps.personaltrackercore.ui.infoscreen.InfoViewModel$startVibration$1$1", f = "InfoViewModel.kt", i = {0}, l = {29}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    /* renamed from: com.askgps.personaltrackercore.ui.infoscreen.InfoViewModel$startVibration$1$1  reason: invalid class name */
    /* compiled from: InfoViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ InfoViewModel$startVibration$1 this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, continuation);
            r0.p$ = (CoroutineScope) obj;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = this.p$;
            } else if (i == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            do {
                Job access$getVibrationJob$p = this.this$0.this$0.vibrationJob;
                if (access$getVibrationJob$p == null || !access$getVibrationJob$p.isActive()) {
                    return Unit.INSTANCE;
                }
                this.this$0.this$0.getVibrate().postValue(Boxing.boxBoolean(true));
                this.L$0 = coroutineScope;
                this.label = 1;
            } while (DelayKt.delay(1000, this) != coroutine_suspended);
            return coroutine_suspended;
        }
    }
}

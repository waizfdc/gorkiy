package com.askgps.personaltrackerround.ui.main;

import com.askgps.personaltrackercore.BaseMainActivity;
import com.askgps.personaltrackercore.config.CustomerCategory;
import java.util.Calendar;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.askgps.personaltrackerround.ui.main.MainFragmentRound$runClockFace$1", f = "MainFragmentRound.kt", i = {0}, l = {216}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: MainFragmentRound.kt */
final class MainFragmentRound$runClockFace$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ MainFragmentRound this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainFragmentRound$runClockFace$1(MainFragmentRound mainFragmentRound, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mainFragmentRound;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        MainFragmentRound$runClockFace$1 mainFragmentRound$runClockFace$1 = new MainFragmentRound$runClockFace$1(this.this$0, continuation);
        mainFragmentRound$runClockFace$1.p$ = (CoroutineScope) obj;
        return mainFragmentRound$runClockFace$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((MainFragmentRound$runClockFace$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
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
        while (CoroutineScopeKt.isActive(coroutineScope)) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.this$0.scope, Dispatchers.getMain(), null, new AnonymousClass1(this, null), 2, null);
            this.L$0 = coroutineScope;
            this.label = 1;
            if (DelayKt.delay(1000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
    @DebugMetadata(c = "com.askgps.personaltrackerround.ui.main.MainFragmentRound$runClockFace$1$1", f = "MainFragmentRound.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.askgps.personaltrackerround.ui.main.MainFragmentRound$runClockFace$1$1  reason: invalid class name */
    /* compiled from: MainFragmentRound.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ MainFragmentRound$runClockFace$1 this$0;

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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Calendar access$getCal$p = this.this$0.this$0.cal;
                Intrinsics.checkExpressionValueIsNotNull(access$getCal$p, "cal");
                access$getCal$p.setTimeInMillis(System.currentTimeMillis());
                if (BaseMainActivity.Companion.getCustomer() != CustomerCategory.PATIENT_PHONE) {
                    MainFragmentRound.rotateSecArrow$default(this.this$0.this$0, this.this$0.this$0.cal.get(13), false, 2, null);
                }
                this.this$0.this$0.setClock();
                this.this$0.this$0.setDay();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

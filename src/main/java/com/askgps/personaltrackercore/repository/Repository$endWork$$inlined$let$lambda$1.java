package com.askgps.personaltrackercore.repository;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/askgps/personaltrackercore/repository/Repository$endWork$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: Repository.kt */
final class Repository$endWork$$inlined$let$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $imei$inlined;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ Repository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Repository$endWork$$inlined$let$lambda$1(Continuation continuation, Repository repository, String str) {
        super(2, continuation);
        this.this$0 = repository;
        this.$imei$inlined = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        Repository$endWork$$inlined$let$lambda$1 repository$endWork$$inlined$let$lambda$1 = new Repository$endWork$$inlined$let$lambda$1(continuation, this.this$0, this.$imei$inlined);
        repository$endWork$$inlined$let$lambda$1.p$ = (CoroutineScope) obj;
        return repository$endWork$$inlined$let$lambda$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((Repository$endWork$$inlined$let$lambda$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getDatabaseHelper().settingsDao().setWorkIsStart(false);
            Repository.sendWorkIsStart$default(this.this$0, this.$imei$inlined, false, null, 4, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

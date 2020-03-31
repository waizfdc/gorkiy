package com.askgps.personaltrackercore.repository;

import com.askgps.personaltrackercore.database.model.Location;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.askgps.personaltrackercore.repository.Repository$processingSosMessage$1", f = "Repository.kt", i = {0}, l = {262}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: Repository.kt */
final class Repository$processingSosMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ Repository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Repository$processingSosMessage$1(Repository repository, Continuation continuation) {
        super(2, continuation);
        this.this$0 = repository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        Repository$processingSosMessage$1 repository$processingSosMessage$1 = new Repository$processingSosMessage$1(this.this$0, continuation);
        repository$processingSosMessage$1.p$ = (CoroutineScope) obj;
        return repository$processingSosMessage$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((Repository$processingSosMessage$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            Repository repository = this.this$0;
            String value = repository.getImei().getValue();
            if (value == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(value, "imei.value!!");
            List listOf = CollectionsKt.listOf(new Location(value, System.currentTimeMillis(), null, null, null, null, null, null, null, null, null, null, null, null, null, Boxing.boxBoolean(true), null, null, null, null, 1015804, null));
            this.L$0 = coroutineScope;
            this.label = 1;
            if (repository.sendLocationWithDb(listOf, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}

package com.askgps.personaltrackercore.repository;

import com.askgps.personaltrackercore.LogKt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.askgps.personaltrackercore.repository.Repository$sendLocationWithDb$2", f = "Repository.kt", i = {0, 0, 0, 0, 0}, l = {329}, m = "invokeSuspend", n = {"$this$withContext", "attemptCount", "count", "result", "items"}, s = {"L$0", "I$0", "L$1", "Z$0", "L$2"})
/* compiled from: Repository.kt */
final class Repository$sendLocationWithDb$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $newItems;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ Repository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Repository$sendLocationWithDb$2(Repository repository, List list, Continuation continuation) {
        super(2, continuation);
        this.this$0 = repository;
        this.$newItems = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        Repository$sendLocationWithDb$2 repository$sendLocationWithDb$2 = new Repository$sendLocationWithDb$2(this.this$0, this.$newItems, continuation);
        repository$sendLocationWithDb$2.p$ = (CoroutineScope) obj;
        return repository$sendLocationWithDb$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((Repository$sendLocationWithDb$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Repository$sendLocationWithDb$2 repository$sendLocationWithDb$2;
        CoroutineScope coroutineScope;
        int i;
        AtomicInteger atomicInteger;
        List list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        boolean z = false;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = this.p$;
            AtomicInteger atomicInteger2 = new AtomicInteger(0);
            List mutableList = CollectionsKt.toMutableList((Collection) this.this$0.getDatabaseHelper().locationDao().getLocations());
            mutableList.addAll(this.$newItems);
            CollectionsKt.sortWith(mutableList, AnonymousClass1.INSTANCE);
            repository$sendLocationWithDb$2 = this;
            List list2 = mutableList;
            coroutineScope = coroutineScope2;
            list = list2;
            AtomicInteger atomicInteger3 = atomicInteger2;
            i = 3;
            atomicInteger = atomicInteger3;
        } else if (i2 == 1) {
            list = (List) this.L$2;
            z = this.Z$0;
            atomicInteger = (AtomicInteger) this.L$1;
            i = this.I$0;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            repository$sendLocationWithDb$2 = this;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (!z && atomicInteger.get() < i) {
            atomicInteger.incrementAndGet();
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy HH:mm:ss");
            Calendar instance = Calendar.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "Calendar.getInstance()");
            sb.append(simpleDateFormat.format(instance.getTime()));
            sb.append("] Retry sending ");
            sb.append(atomicInteger);
            sb.append(" from ");
            sb.append(i);
            LogKt.toFile$default(sb.toString(), null, null, null, 7, null);
            z = repository$sendLocationWithDb$2.this$0.sendLocation(list);
            if (!z && atomicInteger.get() < i) {
                repository$sendLocationWithDb$2.L$0 = coroutineScope;
                repository$sendLocationWithDb$2.I$0 = i;
                repository$sendLocationWithDb$2.L$1 = atomicInteger;
                repository$sendLocationWithDb$2.Z$0 = z;
                repository$sendLocationWithDb$2.L$2 = list;
                repository$sendLocationWithDb$2.label = 1;
                if (DelayKt.delay(45000, repository$sendLocationWithDb$2) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}

package com.askgps.personaltrackercore.repository;

import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.database.model.IndoorNavigation;
import java.util.List;
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
@DebugMetadata(c = "com.askgps.personaltrackercore.repository.Repository$saveLocationAsync$1", f = "Repository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Repository.kt */
final class Repository$saveLocationAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte $battery;
    final /* synthetic */ IndoorNavigation $indoorNavigation;
    final /* synthetic */ List $locations;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ Repository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Repository$saveLocationAsync$1(Repository repository, List list, byte b, IndoorNavigation indoorNavigation, Continuation continuation) {
        super(2, continuation);
        this.this$0 = repository;
        this.$locations = list;
        this.$battery = b;
        this.$indoorNavigation = indoorNavigation;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        Repository$saveLocationAsync$1 repository$saveLocationAsync$1 = new Repository$saveLocationAsync$1(this.this$0, this.$locations, this.$battery, this.$indoorNavigation, continuation);
        repository$saveLocationAsync$1.p$ = (CoroutineScope) obj;
        return repository$saveLocationAsync$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((Repository$saveLocationAsync$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List access$getItems = this.this$0.getItems(this.$locations, this.$battery, this.$indoorNavigation);
            this.this$0.getDatabaseHelper().locationDao().insertLocations(access$getItems);
            LogKt.toFile$default(access$getItems, "Saved " + access$getItems.size() + " items", null, null, 6, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

package com.askgps.personaltrackercore.repository;

import android.location.Location;
import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.database.model.IndoorNavigation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/google/android/gms/tasks/Task;", "Landroid/location/Location;", "kotlin.jvm.PlatformType", "onComplete"}, k = 3, mv = {1, 1, 16})
/* compiled from: Repository.kt */
final class Repository$requestLocation$1<TResult> implements OnCompleteListener<Location> {
    final /* synthetic */ byte $battery;
    final /* synthetic */ Function0 $callback;
    final /* synthetic */ IndoorNavigation $indoorNavigation;
    final /* synthetic */ Repository this$0;

    Repository$requestLocation$1(Repository repository, byte b, IndoorNavigation indoorNavigation, Function0 function0) {
        this.this$0 = repository;
        this.$battery = b;
        this.$indoorNavigation = indoorNavigation;
        this.$callback = function0;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
    @DebugMetadata(c = "com.askgps.personaltrackercore.repository.Repository$requestLocation$1$1", f = "Repository.kt", i = {0, 0, 1}, l = {397, 417}, m = "invokeSuspend", n = {"$this$launch", FirebaseAnalytics.Param.LOCATION, "$this$launch"}, s = {"L$0", "L$1", "L$0"})
    /* renamed from: com.askgps.personaltrackercore.repository.Repository$requestLocation$1$1  reason: invalid class name */
    /* compiled from: Repository.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ Repository$requestLocation$1 this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, task, continuation);
            r0.p$ = (CoroutineScope) obj;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    Location location = (Location) this.L$1;
                } else if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = this.p$;
                Task task = task;
                Intrinsics.checkExpressionValueIsNotNull(task, "it");
                if (task.getResult() != null) {
                    Task task2 = task;
                    Intrinsics.checkExpressionValueIsNotNull(task2, "it");
                    Object result = task2.getResult();
                    if (result == null) {
                        Intrinsics.throwNpe();
                    }
                    Intrinsics.checkExpressionValueIsNotNull(result, "it.result!!");
                    Location location2 = (Location) result;
                    LogKt.toFile$default("requestLastLocation: " + location2.getLongitude() + " - " + location2.getLatitude(), null, null, null, 7, null);
                    Repository repository = this.this$0.this$0;
                    String value = this.this$0.this$0.getImei().getValue();
                    if (value == null) {
                        Intrinsics.throwNpe();
                    }
                    Intrinsics.checkExpressionValueIsNotNull(value, "imei.value!!");
                    List listOf = CollectionsKt.listOf(new com.askgps.personaltrackercore.database.model.Location(value, System.currentTimeMillis(), Boxing.boxLong(location2.getTime()), Boxing.boxDouble(location2.getLatitude()), Boxing.boxDouble(location2.getLongitude()), Boxing.boxFloat((float) location2.getAltitude()), Boxing.boxInt((int) location2.getAccuracy()), Boxing.boxShort((short) ((int) location2.getBearing())), Boxing.boxFloat(location2.getSpeed()), location2.getProvider(), null, null, Boxing.boxByte(this.this$0.$battery), null, null, null, null, null, null, this.this$0.$indoorNavigation, 519168, null));
                    this.L$0 = coroutineScope2;
                    this.L$1 = location2;
                    this.label = 1;
                    if (repository.sendLocationWithDb(listOf, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    LogKt.toFile$default("requestLastLocation = null ", null, null, null, 7, null);
                    Repository repository2 = this.this$0.this$0;
                    String value2 = this.this$0.this$0.getImei().getValue();
                    if (value2 == null) {
                        Intrinsics.throwNpe();
                    }
                    Intrinsics.checkExpressionValueIsNotNull(value2, "imei.value!!");
                    List listOf2 = CollectionsKt.listOf(new com.askgps.personaltrackercore.database.model.Location(value2, System.currentTimeMillis(), null, null, null, null, null, null, null, null, null, null, Boxing.boxByte(this.this$0.$battery), null, null, null, null, null, null, this.this$0.$indoorNavigation, 520188, null));
                    this.L$0 = coroutineScope2;
                    this.label = 2;
                    if (repository2.sendLocationWithDb(listOf2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void onComplete(final Task<Location> task) {
        Intrinsics.checkParameterIsNotNull(task, "it");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.this$0.coroutineScope, Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
        this.$callback.invoke();
    }
}

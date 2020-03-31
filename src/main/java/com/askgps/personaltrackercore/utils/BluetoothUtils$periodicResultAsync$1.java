package com.askgps.personaltrackercore.utils;

import com.askgps.personaltrackercore.database.model.IndoorDevice;
import java.util.Set;
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
import kotlinx.coroutines.DelayKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lcom/askgps/personaltrackercore/database/model/IndoorDevice;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.askgps.personaltrackercore.utils.BluetoothUtils$periodicResultAsync$1", f = "BluetoothUtils.kt", i = {0}, l = {54}, m = "invokeSuspend", n = {"$this$async"}, s = {"L$0"})
/* compiled from: BluetoothUtils.kt */
final class BluetoothUtils$periodicResultAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Set<IndoorDevice>>, Object> {
    final /* synthetic */ long $period;
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ BluetoothUtils this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BluetoothUtils$periodicResultAsync$1(BluetoothUtils bluetoothUtils, long j, Continuation continuation) {
        super(2, continuation);
        this.this$0 = bluetoothUtils;
        this.$period = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        BluetoothUtils$periodicResultAsync$1 bluetoothUtils$periodicResultAsync$1 = new BluetoothUtils$periodicResultAsync$1(this.this$0, this.$period, continuation);
        bluetoothUtils$periodicResultAsync$1.p$ = (CoroutineScope) obj;
        return bluetoothUtils$periodicResultAsync$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((BluetoothUtils$periodicResultAsync$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            this.this$0.scanLeDevice();
            long j = this.$period;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (DelayKt.delay(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.stopScanLeDevice();
        return this.this$0.scanDevices;
    }
}

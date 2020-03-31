package com.askgps.personaltrackercore.receiver;

import android.content.Intent;
import com.askgps.personaltrackercore.utils.WifiUtils;
import com.google.android.gms.location.LocationResult;
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
@DebugMetadata(c = "com.askgps.personaltrackercore.receiver.LocationUpdatesBroadcastReceiver$onReceive$1", f = "LocationUpdatesBroadcastReceiver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LocationUpdatesBroadcastReceiver.kt */
final class LocationUpdatesBroadcastReceiver$onReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Intent $intent;
    final /* synthetic */ WifiUtils $wifiUtils;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocationUpdatesBroadcastReceiver$onReceive$1(Intent intent, WifiUtils wifiUtils, Continuation continuation) {
        super(2, continuation);
        this.$intent = intent;
        this.$wifiUtils = wifiUtils;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        LocationUpdatesBroadcastReceiver$onReceive$1 locationUpdatesBroadcastReceiver$onReceive$1 = new LocationUpdatesBroadcastReceiver$onReceive$1(this.$intent, this.$wifiUtils, continuation);
        locationUpdatesBroadcastReceiver$onReceive$1.p$ = (CoroutineScope) obj;
        return locationUpdatesBroadcastReceiver$onReceive$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((LocationUpdatesBroadcastReceiver$onReceive$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LocationResult extractResult = LocationResult.extractResult(this.$intent);
            if (extractResult != null) {
                this.$wifiUtils.wifiScan(extractResult, true);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

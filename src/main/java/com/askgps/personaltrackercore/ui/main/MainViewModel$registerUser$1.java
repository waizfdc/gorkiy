package com.askgps.personaltrackercore.ui.main;

import com.askgps.personaltrackercore.database.model.Device;
import com.askgps.personaltrackercore.repository.Repository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.askgps.personaltrackercore.ui.main.MainViewModel$registerUser$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MainViewModel.kt */
final class MainViewModel$registerUser$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ String $email;
    final /* synthetic */ String $fio;
    final /* synthetic */ String $password;
    final /* synthetic */ String $phone;
    final /* synthetic */ Ref.BooleanRef $result;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ MainViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainViewModel$registerUser$1(MainViewModel mainViewModel, String str, String str2, String str3, String str4, Ref.BooleanRef booleanRef, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mainViewModel;
        this.$fio = str;
        this.$password = str2;
        this.$phone = str3;
        this.$email = str4;
        this.$result = booleanRef;
        this.$callback = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        MainViewModel$registerUser$1 mainViewModel$registerUser$1 = new MainViewModel$registerUser$1(this.this$0, this.$fio, this.$password, this.$phone, this.$email, this.$result, this.$callback, continuation);
        mainViewModel$registerUser$1.p$ = (CoroutineScope) obj;
        return mainViewModel$registerUser$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((MainViewModel$registerUser$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Repository access$getRepo$p = this.this$0.getRepo();
            String str = this.$fio;
            String value = this.this$0.getImei().getValue();
            if (value == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(value, "imei.value!!");
            access$getRepo$p.setDeviceData(new Device(str, "", value, this.$password, "", this.$phone, this.$email, ""));
            if (this.$password.length() == 0) {
                Repository access$getRepo$p2 = this.this$0.getRepo();
                String str2 = this.$fio;
                String value2 = this.this$0.getImei().getValue();
                if (value2 == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(value2, "imei.value!!");
                access$getRepo$p2.setDeviceData(new Device(str2, "", value2, this.$password, "", this.$phone, this.$email, ""));
                this.$result.element = this.this$0.getRepo().requestPassword();
            } else {
                if (this.this$0.getRepo().getDeviceData().getDeviceId().length() == 0) {
                    this.$result.element = false;
                } else {
                    this.this$0.getRepo().getDeviceData().setCode(this.$password);
                    this.$result.element = true;
                }
            }
            this.$callback.invoke(Boxing.boxBoolean(this.$result.element));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

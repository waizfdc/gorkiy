package com.askgps.personaltrackerround.ui.main;

import android.content.Context;
import android.widget.Toast;
import com.askgps.personaltrackercore.ui.camera.CameraFragmentPhone;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainFragmentPhone.kt */
final class MainFragmentPhone$click_btn_round$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ MainFragmentPhone this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainFragmentPhone$click_btn_round$1(MainFragmentPhone mainFragmentPhone) {
        super(1);
        this.this$0 = mainFragmentPhone;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
    @DebugMetadata(c = "com.askgps.personaltrackerround.ui.main.MainFragmentPhone$click_btn_round$1$1", f = "MainFragmentPhone.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.askgps.personaltrackerround.ui.main.MainFragmentPhone$click_btn_round$1$1  reason: invalid class name */
    /* compiled from: MainFragmentPhone.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ MainFragmentPhone$click_btn_round$1 this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, z, continuation);
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
                if (z) {
                    CameraFragmentPhone newInstance = CameraFragmentPhone.Companion.newInstance();
                    newInstance.setCancelable(true);
                    newInstance.show(this.this$0.this$0.getChildFragmentManager(), (String) null);
                } else {
                    Context context = this.this$0.this$0.getContext();
                    if (context == null) {
                        Intrinsics.throwNpe();
                    }
                    Toast.makeText(context, "Ошибка регистрации. Повторите позднее.", 0).show();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void invoke(final boolean z) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.this$0.scope, Dispatchers.getMain(), null, new AnonymousClass1(this, null), 2, null);
    }
}

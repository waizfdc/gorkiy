package com.askgps.personaltrackerround;

import com.askgps.personaltrackercore.KoinModuleKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.koin.android.ext.koin.KoinExtKt;
import org.koin.core.KoinApplication;
import org.koin.core.module.Module;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lorg/koin/core/KoinApplication;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: Application.kt */
final class Application$onCreate$1 extends Lambda implements Function1<KoinApplication, Unit> {
    final /* synthetic */ Application this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Application$onCreate$1(Application application) {
        super(1);
        this.this$0 = application;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KoinApplication) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(KoinApplication koinApplication) {
        Intrinsics.checkParameterIsNotNull(koinApplication, "$receiver");
        KoinExtKt.androidContext(koinApplication, this.this$0);
        koinApplication.modules(CollectionsKt.listOf((Object[]) new Module[]{RoundKoinModuleKt.roundKoinModule(), KoinModuleKt.koinModule()}));
    }
}

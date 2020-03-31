package com.askgps.personaltrackerround;

import androidx.fragment.app.Fragment;
import com.askgps.personaltrackercore.config.CustomerCategory;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Definitions;
import org.koin.core.definition.Kind;
import org.koin.core.definition.Options;
import org.koin.core.module.Module;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.scope.ScopeDefinition;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lorg/koin/core/module/Module;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: RoundKoinModule.kt */
final class RoundKoinModuleKt$roundKoinModule$1 extends Lambda implements Function1<Module, Unit> {
    public static final RoundKoinModuleKt$roundKoinModule$1 INSTANCE = new RoundKoinModuleKt$roundKoinModule$1();

    RoundKoinModuleKt$roundKoinModule$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Module) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Module module) {
        Module module2 = module;
        Intrinsics.checkParameterIsNotNull(module2, "$receiver");
        Definitions definitions = Definitions.INSTANCE;
        ScopeDefinition rootScope = module.getRootScope();
        Options makeOptions = module2.makeOptions(false, false);
        List emptyList = CollectionsKt.emptyList();
        ScopeDefinition scopeDefinition = rootScope;
        ScopeDefinition.save$default(rootScope, new BeanDefinition(scopeDefinition, Reflection.getOrCreateKotlinClass(Class.class), QualifierKt.named("MainActivityClass"), AnonymousClass1.INSTANCE, Kind.Single, emptyList, makeOptions, null, null, 384, null), false, 2, null);
        Definitions definitions2 = Definitions.INSTANCE;
        ScopeDefinition rootScope2 = module.getRootScope();
        Options makeOptions2 = module2.makeOptions(false, false);
        List emptyList2 = CollectionsKt.emptyList();
        ScopeDefinition scopeDefinition2 = rootScope2;
        ScopeDefinition.save$default(rootScope2, new BeanDefinition(scopeDefinition2, Reflection.getOrCreateKotlinClass(CustomerCategory.class), QualifierKt.named("customer_category"), AnonymousClass2.INSTANCE, Kind.Single, emptyList2, makeOptions2, null, null, 384, null), false, 2, null);
        Definitions definitions3 = Definitions.INSTANCE;
        ScopeDefinition rootScope3 = module.getRootScope();
        Options makeOptions$default = Module.makeOptions$default(module2, false, false, 2, null);
        List emptyList3 = CollectionsKt.emptyList();
        ScopeDefinition scopeDefinition3 = rootScope3;
        ScopeDefinition.save$default(rootScope3, new BeanDefinition(scopeDefinition3, Reflection.getOrCreateKotlinClass(Fragment.class), QualifierKt.named("mainFragment"), AnonymousClass3.INSTANCE, Kind.Factory, emptyList3, makeOptions$default, null, null, 384, null), false, 2, null);
    }
}

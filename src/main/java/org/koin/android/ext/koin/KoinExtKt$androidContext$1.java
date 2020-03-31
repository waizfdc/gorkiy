package org.koin.android.ext.koin;

import android.app.Application;
import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Definitions;
import org.koin.core.definition.Kind;
import org.koin.core.definition.Options;
import org.koin.core.module.Module;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.scope.Scope;
import org.koin.core.scope.ScopeDefinition;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lorg/koin/core/module/Module;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: KoinExt.kt */
final class KoinExtKt$androidContext$1 extends Lambda implements Function1<Module, Unit> {
    final /* synthetic */ Context $androidContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KoinExtKt$androidContext$1(Context context) {
        super(1);
        this.$androidContext = context;
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
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Application.class);
        ScopeDefinition scopeDefinition = rootScope;
        ScopeDefinition.save$default(rootScope, new BeanDefinition(scopeDefinition, orCreateKotlinClass, null, new Function2<Scope, DefinitionParameters, Application>(this) {
            /* class org.koin.android.ext.koin.KoinExtKt$androidContext$1.AnonymousClass1 */
            final /* synthetic */ KoinExtKt$androidContext$1 this$0;

            {
                this.this$0 = r1;
            }

            public final Application invoke(Scope scope, DefinitionParameters definitionParameters) {
                Intrinsics.checkParameterIsNotNull(scope, "$receiver");
                Intrinsics.checkParameterIsNotNull(definitionParameters, "it");
                return (Application) this.this$0.$androidContext;
            }
        }, Kind.Single, emptyList, makeOptions, null, null, 384, null), false, 2, null);
    }
}

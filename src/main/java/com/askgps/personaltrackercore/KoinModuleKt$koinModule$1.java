package com.askgps.personaltrackercore;

import com.askgps.personaltrackercore.database.DatabaseHelper;
import com.askgps.personaltrackercore.location.GoogleApiHelper;
import com.askgps.personaltrackercore.receiver.PowerConnectionCompanion;
import com.askgps.personaltrackercore.repository.Repository;
import com.askgps.personaltrackercore.utils.AvatarUtils;
import com.askgps.personaltrackercore.utils.NotificationHandler;
import com.askgps.personaltrackercore.utils.RemovalFromHandUtils;
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
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.scope.ScopeDefinition;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lorg/koin/core/module/Module;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: KoinModule.kt */
final class KoinModuleKt$koinModule$1 extends Lambda implements Function1<Module, Unit> {
    public static final KoinModuleKt$koinModule$1 INSTANCE = new KoinModuleKt$koinModule$1();

    KoinModuleKt$koinModule$1() {
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
        Options makeOptions$default = Module.makeOptions$default(module2, false, false, 2, null);
        ScopeDefinition scopeDefinition = rootScope;
        BeanDefinition beanDefinition = r2;
        BeanDefinition beanDefinition2 = new BeanDefinition(scopeDefinition, Reflection.getOrCreateKotlinClass(String.class), QualifierKt.named("imei"), AnonymousClass1.INSTANCE, Kind.Factory, CollectionsKt.emptyList(), makeOptions$default, null, null, 384, null);
        ScopeDefinition.save$default(rootScope, beanDefinition, false, 2, null);
        Qualifier qualifier = null;
        Definitions definitions2 = Definitions.INSTANCE;
        ScopeDefinition rootScope2 = module.getRootScope();
        Options makeOptions = module2.makeOptions(false, false);
        ScopeDefinition scopeDefinition2 = rootScope2;
        ScopeDefinition.save$default(rootScope2, new BeanDefinition(scopeDefinition2, Reflection.getOrCreateKotlinClass(GoogleApiHelper.class), qualifier, AnonymousClass2.INSTANCE, Kind.Single, CollectionsKt.emptyList(), makeOptions, null, null, 384, null), false, 2, null);
        Definitions definitions3 = Definitions.INSTANCE;
        ScopeDefinition rootScope3 = module.getRootScope();
        Options makeOptions2 = module2.makeOptions(false, false);
        ScopeDefinition scopeDefinition3 = rootScope3;
        Qualifier qualifier2 = qualifier;
        ScopeDefinition.save$default(rootScope3, new BeanDefinition(scopeDefinition3, Reflection.getOrCreateKotlinClass(DatabaseHelper.class), qualifier2, AnonymousClass3.INSTANCE, Kind.Single, CollectionsKt.emptyList(), makeOptions2, null, null, 384, null), false, 2, null);
        Definitions definitions4 = Definitions.INSTANCE;
        ScopeDefinition rootScope4 = module.getRootScope();
        Options makeOptions3 = module2.makeOptions(false, false);
        ScopeDefinition scopeDefinition4 = rootScope4;
        ScopeDefinition.save$default(rootScope4, new BeanDefinition(scopeDefinition4, Reflection.getOrCreateKotlinClass(Repository.class), qualifier2, AnonymousClass4.INSTANCE, Kind.Single, CollectionsKt.emptyList(), makeOptions3, null, null, 384, null), false, 2, null);
        Definitions definitions5 = Definitions.INSTANCE;
        ScopeDefinition rootScope5 = module.getRootScope();
        Options makeOptions4 = module2.makeOptions(false, false);
        ScopeDefinition scopeDefinition5 = rootScope5;
        ScopeDefinition.save$default(rootScope5, new BeanDefinition(scopeDefinition5, Reflection.getOrCreateKotlinClass(PowerConnectionCompanion.class), qualifier2, AnonymousClass5.INSTANCE, Kind.Single, CollectionsKt.emptyList(), makeOptions4, null, null, 384, null), false, 2, null);
        Definitions definitions6 = Definitions.INSTANCE;
        ScopeDefinition rootScope6 = module.getRootScope();
        Options makeOptions5 = module2.makeOptions(false, false);
        ScopeDefinition scopeDefinition6 = rootScope6;
        BeanDefinition beanDefinition3 = r3;
        BeanDefinition beanDefinition4 = new BeanDefinition(scopeDefinition6, Reflection.getOrCreateKotlinClass(RemovalFromHandUtils.class), QualifierKt.named("RemovalFromHandUtils"), AnonymousClass6.INSTANCE, Kind.Single, CollectionsKt.emptyList(), makeOptions5, null, null, 384, null);
        ScopeDefinition.save$default(rootScope6, beanDefinition3, false, 2, null);
        Definitions definitions7 = Definitions.INSTANCE;
        ScopeDefinition rootScope7 = module.getRootScope();
        Options makeOptions6 = module2.makeOptions(false, false);
        ScopeDefinition scopeDefinition7 = rootScope7;
        ScopeDefinition.save$default(rootScope7, new BeanDefinition(scopeDefinition7, Reflection.getOrCreateKotlinClass(NotificationHandler.class), qualifier2, AnonymousClass7.INSTANCE, Kind.Single, CollectionsKt.emptyList(), makeOptions6, null, null, 384, null), false, 2, null);
        Definitions definitions8 = Definitions.INSTANCE;
        ScopeDefinition rootScope8 = module.getRootScope();
        Options makeOptions7 = module2.makeOptions(false, false);
        ScopeDefinition scopeDefinition8 = rootScope8;
        ScopeDefinition.save$default(rootScope8, new BeanDefinition(scopeDefinition8, Reflection.getOrCreateKotlinClass(AvatarUtils.class), qualifier2, AnonymousClass8.INSTANCE, Kind.Single, CollectionsKt.emptyList(), makeOptions7, null, null, 384, null), false, 2, null);
    }
}

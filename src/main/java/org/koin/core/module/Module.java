package org.koin.core.module;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Definitions;
import org.koin.core.definition.Kind;
import org.koin.core.definition.Options;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.scope.Scope;
import org.koin.core.scope.ScopeDefinition;
import org.koin.dsl.ScopeDSL;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005JX\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0006\b\u0000\u0010\u0018\u0018\u00012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u0004\u001a\u00020\u00032)\b\b\u0010\u001b\u001a#\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u0002H\u00180\u001cj\b\u0012\u0004\u0012\u0002H\u0018`\u001f¢\u0006\u0002\b H\bJ\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u0003J\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00000%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00000%H\u0002J\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00000%2\u0006\u0010'\u001a\u00020\u0000H\u0002J'\u0010(\u001a\u00020)2\u0006\u0010\u0019\u001a\u00020\u001a2\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020)0+¢\u0006\u0002\b J*\u0010(\u001a\u00020)\"\u0006\b\u0000\u0010\u0018\u0018\u00012\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020)0+¢\u0006\u0002\b H\bJb\u0010-\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0006\b\u0000\u0010\u0018\u0018\u00012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032)\b\b\u0010\u001b\u001a#\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u0002H\u00180\u001cj\b\u0012\u0004\u0012\u0002H\u0018`\u001f¢\u0006\u0002\b H\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u000bR!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006."}, d2 = {"Lorg/koin/core/module/Module;", "", "createAtStart", "", "override", "(ZZ)V", "getCreateAtStart", "()Z", "<set-?>", "isLoaded", "setLoaded$koin_core", "(Z)V", "otherScopes", "Ljava/util/ArrayList;", "Lorg/koin/core/scope/ScopeDefinition;", "Lkotlin/collections/ArrayList;", "getOtherScopes", "()Ljava/util/ArrayList;", "getOverride", "rootScope", "getRootScope", "()Lorg/koin/core/scope/ScopeDefinition;", "factory", "Lorg/koin/core/definition/BeanDefinition;", ExifInterface.GPS_DIRECTION_TRUE, "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/DefinitionParameters;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "makeOptions", "Lorg/koin/core/definition/Options;", "createdAtStart", "plus", "", "modules", "module", "scope", "", "scopeSet", "Lkotlin/Function1;", "Lorg/koin/dsl/ScopeDSL;", "single", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: Module.kt */
public final class Module {
    private final boolean createAtStart;
    private boolean isLoaded;
    private final ArrayList<ScopeDefinition> otherScopes = new ArrayList<>();
    private final boolean override;
    private final ScopeDefinition rootScope = ScopeDefinition.Companion.rootDefinition();

    public Module(boolean z, boolean z2) {
        this.createAtStart = z;
        this.override = z2;
    }

    public final boolean getCreateAtStart() {
        return this.createAtStart;
    }

    public final boolean getOverride() {
        return this.override;
    }

    public final ScopeDefinition getRootScope() {
        return this.rootScope;
    }

    public final boolean isLoaded() {
        return this.isLoaded;
    }

    public final void setLoaded$koin_core(boolean z) {
        this.isLoaded = z;
    }

    public final ArrayList<ScopeDefinition> getOtherScopes() {
        return this.otherScopes;
    }

    public final void scope(Qualifier qualifier, Function1<? super ScopeDSL, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(qualifier, "qualifier");
        Intrinsics.checkParameterIsNotNull(function1, "scopeSet");
        ScopeDefinition scopeDefinition = new ScopeDefinition(qualifier, false, null, 6, null);
        function1.invoke(new ScopeDSL(scopeDefinition));
        this.otherScopes.add(scopeDefinition);
    }

    public final /* synthetic */ <T> void scope(Function1<? super ScopeDSL, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "scopeSet");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ScopeDefinition scopeDefinition = new ScopeDefinition(new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class)), false, null, 6, null);
        function1.invoke(new ScopeDSL(scopeDefinition));
        getOtherScopes().add(scopeDefinition);
    }

    public static /* synthetic */ BeanDefinition single$default(Module module, Qualifier qualifier, boolean z, boolean z2, Function2 function2, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        boolean z3 = (i & 2) != 0 ? false : z;
        boolean z4 = (i & 4) != 0 ? false : z2;
        Function2 function22 = function2;
        Intrinsics.checkParameterIsNotNull(function22, "definition");
        Definitions definitions = Definitions.INSTANCE;
        ScopeDefinition rootScope2 = module.getRootScope();
        Options makeOptions = module.makeOptions(z4, z3);
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(rootScope2, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, function22, Kind.Single, emptyList, makeOptions, null, null, 384, null);
        ScopeDefinition.save$default(rootScope2, beanDefinition, false, 2, null);
        return beanDefinition;
    }

    public final /* synthetic */ <T> BeanDefinition<T> single(Qualifier qualifier, boolean z, boolean z2, Function2<? super Scope, ? super DefinitionParameters, ? extends T> function2) {
        Function2<? super Scope, ? super DefinitionParameters, ? extends T> function22 = function2;
        Intrinsics.checkParameterIsNotNull(function22, "definition");
        Definitions definitions = Definitions.INSTANCE;
        ScopeDefinition rootScope2 = getRootScope();
        Options makeOptions = makeOptions(z2, z);
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(rootScope2, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function22, Kind.Single, emptyList, makeOptions, null, null, 384, null);
        ScopeDefinition.save$default(rootScope2, beanDefinition, false, 2, null);
        return beanDefinition;
    }

    public static /* synthetic */ Options makeOptions$default(Module module, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return module.makeOptions(z, z2);
    }

    public final Options makeOptions(boolean z, boolean z2) {
        boolean z3 = false;
        boolean z4 = this.createAtStart || z2;
        if (this.override || z) {
            z3 = true;
        }
        return new Options(z4, z3);
    }

    public static /* synthetic */ BeanDefinition factory$default(Module module, Qualifier qualifier, boolean z, Function2 function2, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        boolean z2 = (i & 2) != 0 ? false : z;
        Function2 function22 = function2;
        Intrinsics.checkParameterIsNotNull(function22, "definition");
        Definitions definitions = Definitions.INSTANCE;
        ScopeDefinition rootScope2 = module.getRootScope();
        Options makeOptions$default = makeOptions$default(module, z2, false, 2, null);
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = r2;
        BeanDefinition beanDefinition2 = new BeanDefinition(rootScope2, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, function22, Kind.Factory, emptyList, makeOptions$default, null, null, 384, null);
        ScopeDefinition.save$default(rootScope2, beanDefinition, false, 2, null);
        return beanDefinition;
    }

    public final /* synthetic */ <T> BeanDefinition<T> factory(Qualifier qualifier, boolean z, Function2<? super Scope, ? super DefinitionParameters, ? extends T> function2) {
        Function2<? super Scope, ? super DefinitionParameters, ? extends T> function22 = function2;
        Intrinsics.checkParameterIsNotNull(function22, "definition");
        Definitions definitions = Definitions.INSTANCE;
        ScopeDefinition rootScope2 = getRootScope();
        Options makeOptions$default = makeOptions$default(this, z, false, 2, null);
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition<T> beanDefinition = r1;
        BeanDefinition<T> beanDefinition2 = new BeanDefinition<>(rootScope2, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function22, Kind.Factory, emptyList, makeOptions$default, null, null, 384, null);
        ScopeDefinition.save$default(rootScope2, beanDefinition, false, 2, null);
        return beanDefinition;
    }

    public final List<Module> plus(Module module) {
        Intrinsics.checkParameterIsNotNull(module, "module");
        return CollectionsKt.listOf((Object[]) new Module[]{this, module});
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Iterable):java.util.List<T>
     arg types: [java.util.List, java.util.List<org.koin.core.module.Module>]
     candidates:
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Iterable):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Object):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, kotlin.sequences.Sequence):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Object[]):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, kotlin.sequences.Sequence):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object[]):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Iterable):java.util.List<T> */
    public final List<Module> plus(List<Module> list) {
        Intrinsics.checkParameterIsNotNull(list, "modules");
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(this), (Iterable) list);
    }
}

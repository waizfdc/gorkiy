package org.koin.core.definition;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.core.scope.ScopeDefinition;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jr\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072)\b\b\u0010\b\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u00050\tj\b\u0012\u0004\u0012\u0002H\u0005`\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\b\u0002\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013H\bJr\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00142\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072#\u0010\b\u001a\u001f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0002\b\u00030\tj\u0006\u0012\u0002\b\u0003`\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\b\u0002\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013H\u0000¢\u0006\u0002\b\u0017Jr\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072)\b\b\u0010\b\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u00050\tj\b\u0012\u0004\u0012\u0002H\u0005`\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\b\u0002\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013H\bJ^\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072)\b\b\u0010\b\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u00050\tj\b\u0012\u0004\u0012\u0002H\u0005`\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\bJ^\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072)\b\b\u0010\b\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u00050\tj\b\u0012\u0004\u0012\u0002H\u0005`\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\b¨\u0006\u001a"}, d2 = {"Lorg/koin/core/definition/Definitions;", "", "()V", "createFactory", "Lorg/koin/core/definition/BeanDefinition;", ExifInterface.GPS_DIRECTION_TRUE, "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/DefinitionParameters;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "scopeDefinition", "Lorg/koin/core/scope/ScopeDefinition;", "options", "Lorg/koin/core/definition/Options;", "secondaryTypes", "", "Lkotlin/reflect/KClass;", "createSingle", "clazz", "createSingle$koin_core", "saveFactory", "saveSingle", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: Definitions.kt */
public final class Definitions {
    public static final Definitions INSTANCE = new Definitions();

    private Definitions() {
    }

    public static /* synthetic */ BeanDefinition saveSingle$default(Definitions definitions, Qualifier qualifier, Function2 function2, ScopeDefinition scopeDefinition, Options options, int i, Object obj) {
        ScopeDefinition scopeDefinition2 = scopeDefinition;
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        Function2 function22 = function2;
        Intrinsics.checkParameterIsNotNull(function22, "definition");
        Intrinsics.checkParameterIsNotNull(scopeDefinition2, "scopeDefinition");
        Options options2 = options;
        Intrinsics.checkParameterIsNotNull(options2, "options");
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeDefinition, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, function22, Kind.Single, emptyList, options2, null, null, 384, null);
        ScopeDefinition.save$default(scopeDefinition2, beanDefinition, false, 2, null);
        return beanDefinition;
    }

    public static /* synthetic */ BeanDefinition createSingle$default(Definitions definitions, Qualifier qualifier, Function2 function2, ScopeDefinition scopeDefinition, Options options, List list, int i, Object obj) {
        List list2;
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        if ((i & 16) != 0) {
            list2 = CollectionsKt.emptyList();
        } else {
            list2 = list;
        }
        Intrinsics.checkParameterIsNotNull(function2, "definition");
        ScopeDefinition scopeDefinition2 = scopeDefinition;
        Intrinsics.checkParameterIsNotNull(scopeDefinition2, "scopeDefinition");
        Options options2 = options;
        Intrinsics.checkParameterIsNotNull(options2, "options");
        Intrinsics.checkParameterIsNotNull(list2, "secondaryTypes");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new BeanDefinition(scopeDefinition2, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, function2, Kind.Single, list2, options2, null, null, 384, null);
    }

    public final /* synthetic */ <T> BeanDefinition<T> createSingle(Qualifier qualifier, Function2<? super Scope, ? super DefinitionParameters, ? extends T> function2, ScopeDefinition scopeDefinition, Options options, List<? extends KClass<?>> list) {
        Intrinsics.checkParameterIsNotNull(function2, "definition");
        ScopeDefinition scopeDefinition2 = scopeDefinition;
        Intrinsics.checkParameterIsNotNull(scopeDefinition2, "scopeDefinition");
        Options options2 = options;
        Intrinsics.checkParameterIsNotNull(options2, "options");
        List<? extends KClass<?>> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "secondaryTypes");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new BeanDefinition(scopeDefinition2, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function2, Kind.Single, list2, options2, null, null, 384, null);
    }

    public static /* synthetic */ BeanDefinition createSingle$koin_core$default(Definitions definitions, KClass kClass, Qualifier qualifier, Function2 function2, ScopeDefinition scopeDefinition, Options options, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        Qualifier qualifier2 = qualifier;
        if ((i & 32) != 0) {
            list = CollectionsKt.emptyList();
        }
        return definitions.createSingle$koin_core(kClass, qualifier2, function2, scopeDefinition, options, list);
    }

    public final BeanDefinition<?> createSingle$koin_core(KClass<?> kClass, Qualifier qualifier, Function2<? super Scope, ? super DefinitionParameters, ?> function2, ScopeDefinition scopeDefinition, Options options, List<? extends KClass<?>> list) {
        Intrinsics.checkParameterIsNotNull(kClass, "clazz");
        Function2<? super Scope, ? super DefinitionParameters, ?> function22 = function2;
        Intrinsics.checkParameterIsNotNull(function22, "definition");
        ScopeDefinition scopeDefinition2 = scopeDefinition;
        Intrinsics.checkParameterIsNotNull(scopeDefinition2, "scopeDefinition");
        Options options2 = options;
        Intrinsics.checkParameterIsNotNull(options2, "options");
        List<? extends KClass<?>> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "secondaryTypes");
        return new BeanDefinition(scopeDefinition2, kClass, qualifier, function22, Kind.Single, list2, options2, null, null, 384, null);
    }

    public static /* synthetic */ BeanDefinition createFactory$default(Definitions definitions, Qualifier qualifier, Function2 function2, ScopeDefinition scopeDefinition, Options options, List list, int i, Object obj) {
        List list2;
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        if ((i & 16) != 0) {
            list2 = CollectionsKt.emptyList();
        } else {
            list2 = list;
        }
        Intrinsics.checkParameterIsNotNull(function2, "definition");
        ScopeDefinition scopeDefinition2 = scopeDefinition;
        Intrinsics.checkParameterIsNotNull(scopeDefinition2, "scopeDefinition");
        Options options2 = options;
        Intrinsics.checkParameterIsNotNull(options2, "options");
        Intrinsics.checkParameterIsNotNull(list2, "secondaryTypes");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new BeanDefinition(scopeDefinition2, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, function2, Kind.Factory, list2, options2, null, null, 384, null);
    }

    public final /* synthetic */ <T> BeanDefinition<T> createFactory(Qualifier qualifier, Function2<? super Scope, ? super DefinitionParameters, ? extends T> function2, ScopeDefinition scopeDefinition, Options options, List<? extends KClass<?>> list) {
        Intrinsics.checkParameterIsNotNull(function2, "definition");
        ScopeDefinition scopeDefinition2 = scopeDefinition;
        Intrinsics.checkParameterIsNotNull(scopeDefinition2, "scopeDefinition");
        Options options2 = options;
        Intrinsics.checkParameterIsNotNull(options2, "options");
        List<? extends KClass<?>> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "secondaryTypes");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new BeanDefinition(scopeDefinition2, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function2, Kind.Factory, list2, options2, null, null, 384, null);
    }

    public static /* synthetic */ BeanDefinition saveFactory$default(Definitions definitions, Qualifier qualifier, Function2 function2, ScopeDefinition scopeDefinition, Options options, int i, Object obj) {
        ScopeDefinition scopeDefinition2 = scopeDefinition;
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        Function2 function22 = function2;
        Intrinsics.checkParameterIsNotNull(function22, "definition");
        Intrinsics.checkParameterIsNotNull(scopeDefinition2, "scopeDefinition");
        Options options2 = options;
        Intrinsics.checkParameterIsNotNull(options2, "options");
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeDefinition, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, function22, Kind.Factory, emptyList, options2, null, null, 384, null);
        ScopeDefinition.save$default(scopeDefinition2, beanDefinition, false, 2, null);
        return beanDefinition;
    }

    public final /* synthetic */ <T> BeanDefinition<T> saveSingle(Qualifier qualifier, Function2<? super Scope, ? super DefinitionParameters, ? extends T> function2, ScopeDefinition scopeDefinition, Options options) {
        ScopeDefinition scopeDefinition2 = scopeDefinition;
        Function2<? super Scope, ? super DefinitionParameters, ? extends T> function22 = function2;
        Intrinsics.checkParameterIsNotNull(function22, "definition");
        Intrinsics.checkParameterIsNotNull(scopeDefinition2, "scopeDefinition");
        Options options2 = options;
        Intrinsics.checkParameterIsNotNull(options2, "options");
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeDefinition, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function22, Kind.Single, emptyList, options2, null, null, 384, null);
        ScopeDefinition.save$default(scopeDefinition2, beanDefinition, false, 2, null);
        return beanDefinition;
    }

    public final /* synthetic */ <T> BeanDefinition<T> saveFactory(Qualifier qualifier, Function2<? super Scope, ? super DefinitionParameters, ? extends T> function2, ScopeDefinition scopeDefinition, Options options) {
        ScopeDefinition scopeDefinition2 = scopeDefinition;
        Function2<? super Scope, ? super DefinitionParameters, ? extends T> function22 = function2;
        Intrinsics.checkParameterIsNotNull(function22, "definition");
        Intrinsics.checkParameterIsNotNull(scopeDefinition2, "scopeDefinition");
        Options options2 = options;
        Intrinsics.checkParameterIsNotNull(options2, "options");
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeDefinition, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function22, Kind.Factory, emptyList, options2, null, null, 384, null);
        ScopeDefinition.save$default(scopeDefinition2, beanDefinition, false, 2, null);
        return beanDefinition;
    }
}
